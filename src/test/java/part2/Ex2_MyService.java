package part2;

import com.kata.service.MyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class Ex2_MyService {

    @Mock
    private HttpClient httpClient;

    @InjectMocks
    private MyService myService;

    // TODO: write some unit tests using mocking concepts from previous exercises
    @Test
    void shouldCallHttpClientSend() throws IOException, InterruptedException {
        myService.send(HttpRequest.newBuilder().uri(URI.create("http://test")).build());
        verify(httpClient, times(1)).send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class));
    }

}
