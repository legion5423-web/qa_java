package animals;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatTest {

    private final Predator predatorMock = mock(Predator.class);
    private final Cat cat = new Cat(predatorMock);

    @Test
    void getSoundReturnsMeow() throws Exception {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodDelegatesToPredator() throws Exception {
        when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = cat.getFood();
        assertEquals(3, food.size());
        assertTrue(food.contains("Рыба"));
    }
}
