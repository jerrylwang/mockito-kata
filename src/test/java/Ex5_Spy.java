import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class Ex5_Spy {

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
    public void partialMocking_whenRealMethodCalled() {
        MyList myList = mock(MyList.class);
        doCallRealMethod().when(myList).add(any(Integer.class), any(String.class));
        myList.add(1, "real");

        verify(myList, times(1)).add(1, "real");

        doCallRealMethod().when(myList).size();
        Assertions.assertEquals(1, myList.size());
    }

    @Test
    public void partialMocking() {
        List list = new LinkedList();
        List spy = spy(list);

        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        when(spy.get(0)).thenReturn("foo");

        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);

        // TODO: Assert
    }
}
