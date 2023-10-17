package Task_01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    private Numbers numbers;

    @BeforeEach
    public void createNumbersClass(){
        numbers =new Numbers();
    }

    @ParameterizedTest
    @ValueSource (ints = {2, 20, 66})
    void evenOddNumberCheckTrue(int number) {
        assertTrue(numbers.evenOddNumberCheck(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {1, 29, 101})
    void evenOddNumberCheckFalse(int number) {
        assertFalse(numbers.evenOddNumberCheck(number));
    }
}