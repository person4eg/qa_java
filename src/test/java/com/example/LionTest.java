package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class LionTest {

    @RunWith(Parameterized.class)
    public static class LionParametrizedTests {

        @Mock
        private Feline feline;

        private final String sex;
        private final String hasMane;

        public LionParametrizedTests(String sex, String hasMane) {
            this.sex = sex;
            this.hasMane = hasMane;
        }

        @Before
        public void init() {
            MockitoAnnotations.initMocks(this);
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
                Lion lion = new Lion(feline, sex);
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

    public static class LionSingleTests {

        @Mock
        private Feline feline;

        @Before
        public void init() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void getKittensTest() throws Exception {
            Mockito.when(feline.getKittens()).thenReturn(1);
            Lion lion = new Lion(feline, "Самец");
            lion.feline = feline;
            int excepted = 1;
            int actual = lion.getKittens();
            assertEquals(excepted, actual);
        }
        @Test
        public void getFoodTest() throws Exception {
            Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
            Lion lion = new Lion(feline,"Самка");
            lion.feline = feline;
            List<String> excepted = Arrays.asList("Животные", "Птицы", "Рыба");
            List<String> actual = lion.getFood();
            assertEquals(excepted, actual);
        }
    }
}
