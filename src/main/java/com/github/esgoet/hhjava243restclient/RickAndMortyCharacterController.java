package com.github.esgoet.hhjava243restclient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class RickAndMortyCharacterController {
    private final RickAndMortyApiService rickAndMortyApiService;

    @GetMapping
    public List<RickAndMortyCharacter> getAllCharacters(@RequestParam(value = "status", required = false) String status) {
        if (status == null) {
            return rickAndMortyApiService.loadAllCharacters();
        }
        return rickAndMortyApiService.loadCharactersWithStatus(status);
    }

    @GetMapping("/{id}")
    public RickAndMortyCharacter getCharacter(@PathVariable int id) {
        return rickAndMortyApiService.loadCharacterById(id);
    }

}
