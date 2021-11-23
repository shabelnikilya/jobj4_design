package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V strongValue = null;
        SoftReference<V> value = cache.getOrDefault(key, null);
        if (value == null || value.get() == null) {
            put(key, load(key));
            strongValue = cache.get(key).get();
        }
        return strongValue;
    }

    protected abstract V load(K key);
}
