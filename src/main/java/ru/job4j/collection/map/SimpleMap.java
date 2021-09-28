package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(key == null ? 0 : key.hashCode()));
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        MapEntry<K, V>[] copyTable = new MapEntry[capacity *= 2];
        for (MapEntry<K, V> copy : table) {
            if (copy != null) {
                copyTable[indexFor(hash(copy.key.hashCode()))] = copy;
            }
        }
        table = copyTable;
    }

    @Override
    public V get(K key) {
        MapEntry<K, V> k = table[indexFor(hash(key == null ? 0 : key.hashCode()))];
            if (k != null && Objects.equals(k.key, key)) {
                return k.value;
            }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key == null ? 0 : key.hashCode()));
        if (table[index] != null
                && hash(key == null ? 0 : key.hashCode()) == hash(table[index].key.hashCode())
                && Objects.equals(key, table[index].key) ) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int cursor;
            private int index;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (table[index] == null) {
                    index++;
                }
                cursor++;
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
