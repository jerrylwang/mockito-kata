import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class Ex1a_Verify {

    @Test
    void shouldAddOneItemToTheList() {
        //Mock creation
        String item = "One Item";
        List<String> mockList = mock(List.class);

        //Using mock object
        mockList.add((item));
        mockList.clear();

        //Verification
        verify(mockList).add(item);
        verify(mockList).clear();
    }

    @Test
    void shouldAddOneItemToTheList_timesOne() {
        String item = "One Item";
        List<String> mockList = mock(List.class);

        mockList.add((item));
        mockList.clear();

        verify(mockList, times(1)).add(item);
        verify(mockList, times(1)).clear();
    }
}
