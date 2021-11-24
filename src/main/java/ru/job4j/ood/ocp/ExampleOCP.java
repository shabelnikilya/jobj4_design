package ru.job4j.ood.ocp;

import java.util.List;

public class ExampleOCP {
    private static class Filter {

        public static boolean findWord(List<String> words, String find) {
            return words.stream()
                    .anyMatch(find::equals);
        }
    }

    public static class Teacher {
        String nameSubject;
        int ageStudy;
    }

    public static class Workers {
        int age;
        String name;
        Teacher teacher;

        public Teacher getTeacher() {
            return teacher;
        }
    }

    private static class WorkUser {

        public static Teacher getProperties(Workers workers) {
            return workers.getTeacher();
        }
    }
}
