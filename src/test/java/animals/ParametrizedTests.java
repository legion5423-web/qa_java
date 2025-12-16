package animals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParametrizedTests {

    private final Feline felineMock = mock(Feline.class);

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "0, 0",
            "5, 5",
            "10, 10"
    })
    void getKittensReturnsCorrectCount(int input, int expected) {
        when(felineMock.getKittens(input)).thenReturn(expected);
        assertEquals(expected, felineMock.getKittens(input));
    }
}
