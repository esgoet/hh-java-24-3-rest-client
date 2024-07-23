package com.github.esgoet.hhjava243restclient.species;

import com.github.esgoet.hhjava243restclient.api.RickAndMortyApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/species-statistic")
@RequiredArgsConstructor
public class RickAndMortySpeciesStatisticController {
    private final RickAndMortyApiService rickAndMortyApiService;

    @GetMapping
    public int getSpeciesCount(@RequestParam(value="species") String species) {
        return rickAndMortyApiService.loadSpeciesCount(species);
    }

}
