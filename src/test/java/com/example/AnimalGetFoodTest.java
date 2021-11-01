package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalGetFoodTest {

    private final String animalKind;
    private final List<String> food;
    private final Animal animal;

    public AnimalGetFoodTest(String animalKind, List<String> food) {
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
