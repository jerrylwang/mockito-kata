package part1;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class Ex6_Do_Family {

    @Test
    void shouldThrownException_whenClearList() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        doThrow(new RuntimeException()).when(mockedList).clear();

        //following throws RuntimeException:
        mockedList.clear();

        // TODO How do we assert an exception is/not thrown when a method is called
    }

    @Test
    void shouldDoNothing_whenClearList() {
        LinkedList<String> mockedList = mock(LinkedList.class);

        // doNothing() is Mockito's default behavior for void methods.
        doNothing().when(mockedList).clear();

        mockedList.clear();

        verify(mockedList, times(0)).clear();
    }

    @Test
    void shouldDoAnswer_whenAddList() {
        LinkedList<String> myList = mock(LinkedList.class);

        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            assertEquals("zero", arg0);
            return null;

        }).when(myList).add(eq("first"));

        myList.add("first");
    }
}
