package part1;

import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class Ex3_Spy {

    private static class MyList extends AbstractList<String> {

        @Override
        public String get(int index) {
            return null;
        }

        @Override
        public void add(int index, String element) {
            // no-op
        }

        @Override
        public int size() {
            return 100;
        }
    }

    @Test
    void partialMocking_whenRealMethodCalled_withArrayList() {
        List<String> list = new ArrayList<>();
        List<String> spyOnList = spy(list);

        when(spyOnList.size()).thenReturn(10);
        assertEquals(10, spyOnList.size());

        //calling real methods since below methods are not stubbed
        spyOnList.add("Tom");
        spyOnList.add("Jerry");

        assertEquals("Tom", spyOnList.get(0));
        assertEquals("Jerry", spyOnList.get(1));
    }

    @Test
    void partialMocking_whenRealMethodCalled_withCustomisedObject() {
        MyList myList = mock(MyList.class);
        doCallRealMethod().when(myList).add(any(Integer.class), any(String.class));
        myList.add(1, "real");

        verify(myList, times(1)).add(1, "real");

        doCallRealMethod().when(myList).size();
        assertEquals(1, myList.size());
    }

    @Test
    void partialMocking_withDoReturn() {
        List list = new LinkedList();
        List spy = spy(list);

        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        when(spy.get(0)).thenReturn("foo");

        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

        // TODO: Assert
    }
}
