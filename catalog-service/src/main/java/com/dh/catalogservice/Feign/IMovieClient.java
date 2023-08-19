package com.dh.catalogservice.Feign;

import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "movie-service")
public interface IMovieClient {

    @GetMapping("/movies/{genre}")
    public List<Movie> getMovieByGenre(@PathVariable  String genre);

    @PostMapping("movies/save")
    public Movie saveMovie(@RequestBody  Movie movie);
}