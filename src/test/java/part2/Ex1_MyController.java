package part2;

import com.kata.util.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.kata.controller.MyController;
import com.kata.service.MyService;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Ex1_MyController {

    @Mock
    private MyService myService;
    @InjectMocks
    private MyController controller;
    @Mock
    private HttpRequest httpRequest;
    @Mock
    private Request request;
    @Mock
    private HttpResponse<String> httpResponse;

    // TODO: write some unit tests using mocking concepts from previous exercises
    @Test
    void callService_returnsAString_andOk() throws IOException, InterruptedException {
        when(request.requestBuilder()).thenReturn(httpRequest);
        when(myService.send(httpRequest)).thenReturn(httpResponse);
        ResponseEntity<String> response = controller.callService();
        Assertions.assertAll(
                ()->Assertions.assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> Assertions.assertEquals(httpResponse.body(),response.getBody()));
    }
}
