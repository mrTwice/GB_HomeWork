package Base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ActionsTest {
    private Actions actions;
    @BeforeEach
    public void setUp() {
        actions = new Actions();
    }

    @Test
    void averageMeanNormalList() {
        assertEquals(actions.AverageMean(Arrays.asList(5,1,6,9)), 5.25);
    }

    @Test
    void averageMeanListWithNullElement() {
        RuntimeException thrown = assertThrows(RuntimeException.class,()-> {
            actions.AverageMean(Arrays.asList(5,1,null,9));
        });
        assertEquals("Список пуст!", thrown.getMessage());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void averageMeanNulledlList(List<Integer> list) {
        RuntimeException thrown = assertThrows(RuntimeException.class,()-> {
            actions.AverageMean(list);
                });
        assertEquals("Список пуст!", thrown.getMessage());
    }

}