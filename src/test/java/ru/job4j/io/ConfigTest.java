package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "data/data_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Ilya"), is("Shabelnik"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithComment() {
        String path = "data/data_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Ilya"), is("Shabelnik"));
        assertThat(config.value("#Comment"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithNullKeyAndEmptyString() {
        String path = "data/data_with_emptyString.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Yulya"), is("Savicheva"));
        assertThat(config.value("Nikolai"), is("Struchkov"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithException() {
        String path = "data/data_withIllegalArgument.properties";
        Config config = new Config(path);
        config.load();
    }
}