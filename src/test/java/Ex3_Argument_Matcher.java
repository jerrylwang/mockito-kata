import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Ex3_Argument_Matcher {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    @Test
    void shouldAddOneItemToTheList() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(anyInt())).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains("element")).thenReturn(true);

        //following prints "element"
        System.out.println(ANSI_RED_BACKGROUND + mockedList.get(999));

        //you can also verify using an argument matcher
        verify(mockedList).get(anyInt());

        // TODO Assert the Value
    }

    @Test
    void shouldAddOneItemToTheList_eq() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        //stubbing using built-in anyInt() argument matcher
        when(mockedList.get(eq(1))).thenReturn("element");

        //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
        when(mockedList.contains("element")).thenReturn(true);

        //following prints "element"
        System.out.println(ANSI_RED_BACKGROUND + mockedList.get(1));

        //you can also verify using an argument matcher
        verify(mockedList).get(eq(1));

        // TODO Assert the Value
    }

}
