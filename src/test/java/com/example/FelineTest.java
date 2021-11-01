package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() {
        List<String> excepted = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = null;
        try {
            actual = feline.eatMeat();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(excepted, actual);
    }

    @Test
    public void getFamilyTest() {
        String excepted = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(excepted, actual);
    }

    @Test
    public void getKittensTest() {
        int excepted = 1;
        int actual = feline.getKittens();
        assertEquals(excepted, actual);
    }

    @Test
    public void getKittensWithArgTest() {
        int arg = 2;
        int excepted = arg;
        int actual = feline.getKittens(arg);
        assertEquals(excepted, actual);
    }
}