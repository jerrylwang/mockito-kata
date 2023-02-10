package part2;

import com.kata.interfaces.MovieService;
import com.kata.model.Movie;
import com.kata.repo.MoviesRepository;
import com.kata.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Ex3_MovieServiceTest {


    @InjectMocks
    private final MovieService movieService;

    @Mock
    private final MoviesRepository moviesRepository;

    public Ex3_MovieServiceTest(MoviesRepository moviesRepository) {
        this.movieService = new MovieServiceImpl(moviesRepository);
        this.moviesRepository = moviesRepository;
    }

    @Test
    void shouldReturnAMovie_whenThereIsAMatch() throws IOException {
        when(moviesRepository.getAll()).thenReturn(List.of(new Movie("Not Matrix 4", 2021, List.of("Action"), List.of("reeanu keeves"))).stream());
        Optional<Movie> movie = movieService.findByTitle("Matrix 4");

        assertFalse(movie.isPresent());
    }

}
