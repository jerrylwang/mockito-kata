package part1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class Ex1_Mock {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    @Test
    void shouldAddOneItemToTheList() {
        //Mock creation
        String item = "One Item";
        List<String> mockList = mock(List.class);

        //Using mock object
        mockList.add((item));

        //below will print null because mockList.get(1) is not stubbed
        System.out.println(ANSI_RED_BACKGROUND + mockList.get(1));

        Assertions.assertThat(mockList).contains("One Item");

        //TODO: HOW DO WE FIX THE ASSERTION
    }

}
