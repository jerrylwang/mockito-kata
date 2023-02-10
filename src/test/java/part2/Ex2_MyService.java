package part2;

import com.kata.service.MyService;
import com.kata.util.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.mockito.Mockito.when;

public class Ex2_MyService {
    @InjectMocks
    private MyService myService;
    @Mock
    private HttpClient httpClient;
    @Mock
    private HttpRequest httpRequest;
    @Mock
    private HttpResponse<String> httpResponse;
    @Mock
    private HttpResponse.BodyHandler<String> bodyHandler;

    @Test
    void sendReturnsHttpResponseString() throws IOException, InterruptedException {
        httpClient = HttpClient.newHttpClient();
        when(httpClient.send(
                httpRequest,
                bodyHandler))
                .thenReturn(httpResponse);
        HttpResponse<String> response = myService.send(httpRequest);
        Assertions.assertEquals(httpResponse, response);
    }

}
