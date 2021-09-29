package ru.job4j.collection.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analyze {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;
        int diff = previous.size() - current.size();
        if (previous.isEmpty() || current.isEmpty()) {
            added = diff < 0 ? added + Math.abs(diff) : added;
            deleted = diff > 0 ? deleted + diff : deleted;
            return new Info(added, changed, deleted);
        } else if (diff == 0 && previous.containsAll(current)) {
            return new Info(added, changed, deleted);
        }
        Map<Integer, String> prevMap = previous.stream()
                .collect(Collectors.toMap(User::getId,
                        User::getName));
        Map<Integer, String> currMap = current.stream()
                .collect(Collectors.toMap(User::getId,
                        User::getName));
        for (User us : current) {
            if (!prevMap.containsKey(us.getId())) {
                added += 1;
            } else {
                changed = prevMap.get(us.getId()).equals(us.getName())
                        ? changed : changed + 1;
            }
        }
        for (User u : previous) {
            deleted = currMap.containsKey(u.getId())
                    ? deleted : deleted + 1;
        }
        return new Info(added, changed, deleted);
    }
}
