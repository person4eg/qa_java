package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionDoesHaveManeTest {

    private final String sex;
    private final String hasMane;

    public LionDoesHaveManeTest(String sex, String hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][] {
                {"Самец", "true"},
                {"Самка", "false"},
                {"Самей", "Используйте допустимые значения пола животного - самей или самка"}
        };
    }

    @Test
    public void doesHaveManeTest() {
        try {
            Lion lion = new Lion(sex);
            boolean excepted = Boolean.parseBoolean(hasMane);
            boolean actual = lion.doesHaveMane();
            assertEquals(excepted, actual);
        } catch (Exception e) {
            String excepted = hasMane;
            String actual = e.getMessage();
            assertEquals(excepted, actual);
        }
    }
}
