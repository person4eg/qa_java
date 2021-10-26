package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final List<String> food;

    public AnimalTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalTypeData() {
        return new Object[][] {
                {"Травоядное", Arrays.asList("Трава", "Различные растения")},
                {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")},
                {"Млекопитающие", Arrays.asList("Неизвестный вид животного, используйте значение Травоядное или Хищник")}
        };
    }

    @Test
    public void getFoodTest(){
        Animal animal = new Animal();
        List<String> excepted = food;
        List<String> actual = null;
        try {
            actual = animal.getFood(animalKind);
        } catch (Exception e) {
            actual = Arrays.asList(e.getMessage());
        }

        assertEquals(excepted, actual);
    }
    @Test
    public void getFamilyTest(){
        Animal animal = new Animal();
        String excepted = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(excepted, actual);
    }
}