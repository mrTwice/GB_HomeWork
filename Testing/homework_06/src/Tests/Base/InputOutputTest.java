package Base;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputOutputTest {

    @Test
    void getInput() {
        InputOutput inputOutput = new InputOutput();
        String input = "test";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("test", inputOutput.getInput());
    }

    @Test
    void getChoiseTrue(){
        InputOutput inputOutput = new InputOutput();
        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(inputOutput.getChoise());
    }

    @Test
    void getChoiseFalse(){
        InputOutput inputOutput = new InputOutput();
        String input = "N";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(inputOutput.getChoise());
    }

    @Test
    void getChoiseIncorrectInput(){
        InputOutput inputOutput = new InputOutput();
        String input = "123!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RuntimeException thrown = assertThrows(RuntimeException.class,()-> {
            inputOutput.getChoise();
        });
        assertEquals("Не корректный ввод", thrown.getMessage());
    }
}