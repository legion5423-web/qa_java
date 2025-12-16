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
    void eatMeatReturnsCorrectFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(3, food.size());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    void getKittensDefaultReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensWithParameterReturnsCorrectCount() {
        assertEquals(5, feline.getKittens(5));
    }
}
