package com.dh.catalogservice.Controller;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;

    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/catalog/movies/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable  String genre,  HttpServletResponse response){
        response.addHeader("port-catalog", String.valueOf(serverPort));
        System.out.println("Puerto utilizado: " + response.getHeaders("port-catalog"));
        return  ResponseEntity.ok(catalogService.getMoviesByGenre(genre));
    }

    @PostMapping("/catalog/save")
    public ResponseEntity<Movie> saveMovie(@RequestBody  Movie movie){
        return ResponseEntity.ok(catalogService.saveMovie(movie));
    }

    @GetMapping("/catalog/series/{genre}")
    public ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre){
        return ResponseEntity.ok(catalogService.getSeriesBygGenre(genre));
    }

    @PostMapping("/catalog/series/save")
    public ResponseEntity<String> createSerie(@RequestBody Serie serie){
        return ResponseEntity.ok(catalogService.create(serie));
    }
}
