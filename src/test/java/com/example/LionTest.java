package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTest {

    @Mock
    private Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец");
        lion.feline = feline;
        int excepted = 1;
        int actual = lion.getKittens();
        assertEquals(excepted, actual);
    }
    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка");
        lion.feline = feline;
        List<String> excepted = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actual = lion.getFood();
        assertEquals(excepted, actual);
    }
}
