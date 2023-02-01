package part1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class Ex7_Arguement_Captor {

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
     final void shouldContainCertainListItem(@Mock List<String> mockedList) {
        var asList = Arrays.asList("someElement_test", "someElement");
        mockedList.addAll(asList);

        verify(mockedList).addAll(captor.capture());
        List<String> capturedArgument = captor.getValue();
        assertThat(capturedArgument, hasItem("someElement"));
    }
}
