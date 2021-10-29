package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AlexTest {

    @Mock
    private Feline feline;

    private Alex alex;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        alex = new Alex();
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens()).thenReturn(0);
        alex.feline = feline;
        int excepted = 0;
        int actual = alex.getKittens();
        assertEquals(excepted, actual);
    }
    @Test
    public void getFriendsTest() {
        List<String> excepted = Arrays.asList("Марти", "Глория", "Мелман");
        List<String> actual = alex.getFriends();
        assertEquals(excepted, actual);
    }
    @Test
    public void getPlaceOfLivingTest() {
        String excepted = "Нью-Йоркский Зоопарк";
        String actual = alex.getPlaceOfLiving();
        assertEquals(excepted, actual);
    }
}