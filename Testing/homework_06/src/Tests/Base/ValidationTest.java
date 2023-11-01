package Base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    private Validation validation;

    @BeforeEach
    public void setUp(){
        validation = new Validation();

    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "100", "-100"})
    void checkInputStringNumber(String str) {
        assertTrue(validation.checkInput(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {"p", "*", "|", ""})
    void checkInputStringNotNumber(String str) {
        assertFalse(validation.checkInput(str));
    }
}