package part1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Ex4b_Verify_More_Actions {

    private static final String FIRST_TIME = "first time";
    private static final String SECOND_TIME = "second time";

    private static List<String> mockList = mock(List.class);

    @BeforeAll
    static void init() {
        mockList.add(FIRST_TIME);

        mockList.add(SECOND_TIME);
        mockList.add(SECOND_TIME);
    }

    @Test
    void shouldAddToTheList_exactTimes() {
        //exact number of invocations verification
        verify(mockList, times(1)).add(FIRST_TIME);
        verify(mockList, times(2)).add(SECOND_TIME);
    }

    @Test
    void shouldAddToTheList_atLeastTimes() {
        //verification using atLeast()/atMost()
        verify(mockList, atMostOnce()).add(FIRST_TIME);
        verify(mockList, atLeastOnce()).add(FIRST_TIME);
        verify(mockList, atLeast(1)).add(FIRST_TIME);
        verify(mockList, atMost(3)).add(SECOND_TIME);
        verify(mockList, atMost(5)).add(SECOND_TIME);
    }

    @Test
    void shouldAddToTheList_never() {
        // never() is an alias to times(0)
        verify(mockList, never()).add("THIRD TIME LUCKY");
    }


    @Test
    public void testVerify(@Mock Database database) {
        // create and configure mock
        when(database.getUniqueId()).thenReturn(43);


        // call method testing on the mock with parameter 12
        database.setUniqueId(12);
        database.getUniqueId();
        database.getUniqueId();


        // now check if method testing was called with the parameter 12
        verify(database).setUniqueId(ArgumentMatchers.eq(12));

        // was the method called twice?
        verify(database, times(2)).getUniqueId();

        // other alternatives for verifiying the number of method calls for a method
        verify(database, never()).isAvailable();
        verify(database, never()).setUniqueId(13);
        verify(database, atLeastOnce()).setUniqueId(12);
        verify(database, atLeast(2)).getUniqueId();

        // This let's you check that no other methods where called on this object.
        // You call it after you have verified the expected method calls.
        verifyNoMoreInteractions(database);
    }

    private class Database {
        private int uniqueId;

        public int getUniqueId() {
            return uniqueId;
        }

        public void setUniqueId(int uniqueId) {
            this.uniqueId = uniqueId;
        }

        public boolean isAvailable() {
            return false;
        }
    }
}
