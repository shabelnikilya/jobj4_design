package ru.job4j.template;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GeneratorTextTest {

    @Test
    public void whenKeyIsCorrectInTemplate() {
        Generator generator = new GeneratorText();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> values = Map.of("name", "Shabelnik Ilya"
                                            , "subject", "you");
        assertThat(generator.produce(template, values), is(
                "I am a Shabelnik Ilya, Who are you?"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenExtraKeyInTemplate() {
        Generator generator = new GeneratorText();
        String template = "I am a ${name}, Who are ${subject}?. I am ${secondName}.";
        Map<String, String> values = Map.of("name", "Shabelnik Ilya"
                , "subject", "you");
        String rsl = generator.produce(template, values);
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenKeyIsTemplateNotFoundInMap() {
        Generator generator = new GeneratorText();
        String template = "I am a ${name}, Who are ${subject}?.";
        Map<String, String> values = Map.of("name", "Shabelnik Ilya",
                                    "secondName", "Shabelnik Ilya");
        String rsl = generator.produce(template, values);
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenKeyIncorrectInTemplate() {
        Generator generator = new GeneratorText();
        String template = "I am a name, Who are subject?";
        Map<String, String> values = Map.of("name", "Shabelnik Ilya"
                , "subject", "you");
        String rsl = generator.produce(template, values);
    }
}