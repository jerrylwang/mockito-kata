package part2;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.kata.controller.MyController;
import com.kata.service.MyService;

public class Ex1_MyController {

    @Mock
    private MyService myService;

    @InjectMocks
    private MyController controller;

    // TODO: write some unit tests using mocking concepts from previous exercises
}
