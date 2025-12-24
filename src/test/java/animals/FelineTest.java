package animals;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void getFamilyReturnsCorrectFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void eatMeatReturnsExpectedFoodList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    void getKittensDefaultReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensWithParameterReturnsCorrectCount() {
        int expectedCount = 5;
        int actualCount = feline.getKittens(expectedCount);

        assertEquals(expectedCount, actualCount);
    }
}