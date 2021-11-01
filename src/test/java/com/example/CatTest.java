package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String excepted = "Мяу";
        String actual = cat.getSound();
        assertEquals(excepted, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> excepted = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = cat.getFood();
        assertEquals(excepted, actual);
    }
}
