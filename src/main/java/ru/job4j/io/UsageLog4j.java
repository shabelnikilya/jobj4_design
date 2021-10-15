package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte first = 16;
        short second = 51;
        int third = 28;
        long four = 2021;
        char five = 'a';
        float six = 89.5f;
        double seven = 2000000.123;
        LOG.debug("User info first = {}, second = {}, third = {}" +
                ", four = {}, five = {}, six = {}, seven = {}"
                , first, second, third, four, five, six, seven);
    }
}
