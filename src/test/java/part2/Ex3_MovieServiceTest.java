package part2;

import com.kata.interfaces.MovieService;
import com.kata.model.Movie;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

class Ex3_MovieServiceTest {

    private final MovieService movieService = null;

    @Test
    void shouldReturnAMovie_whenThereIsAMatch() {
        Optional<Movie> movie = movieService.findByTitle("Matrix 4");

        assertFalse(movie.isPresent());
    }

}
