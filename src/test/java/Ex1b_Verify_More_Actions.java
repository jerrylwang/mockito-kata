import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class Ex1b_Verify_More_Actions {

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

}
