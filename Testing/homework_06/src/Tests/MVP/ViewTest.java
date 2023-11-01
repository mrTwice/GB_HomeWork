package MVP;

import Base.InputOutput;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @Test
    void menuTrue() {
        InputOutput inputOutput = new InputOutput();
        View view = new View(inputOutput);
        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(view.menu(), true);

    }

    @Test
    void menuFalse() {
        InputOutput inputOutput = new InputOutput();
        View view = new View(inputOutput);
        String input = "N";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(view.menu(), false);

    }

    @Test
    void incorrectInputMenu(){
        InputOutput inputOutput = new InputOutput();
        View view = new View(inputOutput);
        String input = "!33m";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RuntimeException thrown = assertThrows(RuntimeException.class,()-> {
            view.menu();
        });
        assertEquals("Не корректный ввод", thrown.getMessage());
    }

}