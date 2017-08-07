package pl.korwel.controller;

import pl.korwel.model.Movie;
import pl.korwel.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/movies/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getOne(id);
    }

    @PostMapping("/movies")
    @Secured("ROLE_ADMIN")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addNew(movie);
    }

    @PutMapping("/movies/{id}")
    @Secured("ROLE_ADMIN")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
        movieService.update(id, movie);
    }

    @DeleteMapping("/movies/{id}")
    @Secured("ROLE_ADMIN")
    public void deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
    }
}
