package pl.korwel.service;

import pl.korwel.model.Movie;
import pl.korwel.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends BaseService<Movie, Long> {

    @Autowired
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        super(movieRepository);
    }
}
