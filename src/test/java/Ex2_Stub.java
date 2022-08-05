import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Ex2_Stub {
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    @Test
    void shouldReturnStringFirst_WhenGetIsCalled() {
        //You can mock concrete classes, not just interfaces
        LinkedList<String> mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException("Second place doesn't exist!"));

        //following prints "first"
        System.err.println(ANSI_RED_BACKGROUND + mockedList.get(0));

        //following throws runtime exception
        System.out.println(mockedList.get(1));

        //following prints "null" because get(999) was not stubbed
        System.out.println(ANSI_RED_BACKGROUND + mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed.
        verify(mockedList).get(0);

        // TODO Assert the value
    }
}
