package com.example;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class AnimalTest {

    @RunWith(Parameterized.class)
    public static class AnimalParametrizedTests {

        private final String animalKind;
        private final List<String> food;
        private final Animal animal;

        public AnimalParametrizedTests(String animalKind, List<String> food) {
            this.animalKind = animalKind;
            this.food = food;
            this.animal = new Animal();
        }

        @Parameterized.Parameters
        public static Object[][] getAnimalTypeData() {
            return new Object[][]{
                    {"Травоядное", Arrays.asList("Трава", "Различные растения")},
                    {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")},
                    {"Млекопитающие", List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
            };
        }

        @Test
        public void getFoodTest() {
            List<String> excepted = food;
            List<String> actual;
            try {
                actual = animal.getFood(animalKind);
            } catch (Exception e) {
                actual = List.of(e.getMessage());
            }
            assertEquals(excepted, actual);
        }
    }

    public static class AnimalSingleTests{

        @Test
        public void getFamilyTest(){
            Animal animal = new Animal();
            String excepted = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
            String actual = animal.getFamily();
            assertEquals(excepted, actual);
        }
    }
}