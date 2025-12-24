package animals;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    private final Feline felineMock = mock(Feline.class);
    private final String validMale = "Самец";
    private final String validFemale = "Самка";

    @Test
    void constructorWithMaleSetsManeTrue() throws Exception {
        Lion lion = new Lion(validMale, felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void constructorWithFemaleSetsManeFalse() throws Exception {
        Lion lion = new Lion(validFemale, felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void constructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неверный", felineMock)
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittensDelegatesToFeline() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion(validMale, felineMock);
        int actualKittens = lion.getKittens();
        assertEquals(3, actualKittens);
    }

    @Test
    void getFoodDelegatesToFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion(validMale, felineMock);
        List<String> actualFood = lion.getFood();


        assertEquals(expectedFood, actualFood);
    }
}
