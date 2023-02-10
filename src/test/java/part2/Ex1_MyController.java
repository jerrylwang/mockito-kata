package part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.kata.controller.MyController;
import com.kata.service.MyService;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Ex1_MyController {

    @Mock
    private MyService myService;

    @Mock
    private HttpRequest httpRequest;

    @InjectMocks
    private MyController controller;

    // TODO: write some unit tests using mocking concepts from previous exercises
    @Test
    void shouldReturnStatusOK() throws IOException, InterruptedException {
        when(myService.send(any(HttpRequest.class))).thenReturn(new MockHttpResponse());
        ResponseEntity<String> response = controller.callService();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("mehmehmehmhemhe", response.getBody());
    }

    @ParameterizedTest
    @ValueSource(classes = {IOException.class, InterruptedException.class})
    void shouldThrowRuntimeException(Class exception) throws IOException, InterruptedException {
        when(myService.send(any(HttpRequest.class))).thenThrow(exception);
        Assertions.assertThrows(RuntimeException.class, () -> controller.callService());
    }
}

 class MockHttpResponse implements HttpResponse<String> {
    @Override
    public int statusCode() {
        return 0;
    }

    @Override
    public HttpRequest request() {
        return null;
    }

    @Override
    public Optional<HttpResponse<String>> previousResponse() {
        return Optional.empty();
    }

    @Override
    public HttpHeaders headers() {
        return null;
    }

    @Override
    public String body() {
        return "mehmehmehmhemhe";
    }

    @Override
    public Optional<SSLSession> sslSession() {
        return Optional.empty();
    }

    @Override
    public URI uri() {
        return null;
    }

    @Override
    public HttpClient.Version version() {
        return null;
    }
}
