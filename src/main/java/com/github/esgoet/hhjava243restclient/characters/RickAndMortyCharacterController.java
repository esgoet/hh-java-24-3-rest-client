package com.github.esgoet.hhjava243restclient.characters;

import com.github.esgoet.hhjava243restclient.api.RickAndMortyApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class RickAndMortyCharacterController {
    private final RickAndMortyApiService rickAndMortyApiService;

    @GetMapping
    public List<RickAndMortyCharacter> getAllCharacters(@RequestParam(value = "status", required = false) String status) {
        Map<String, String> params = new HashMap<>();
        if (status != null) {
            params.put("status", status);
        }
        return rickAndMortyApiService.loadAllCharacters(params);
    }

    @GetMapping("/{id}")
    public RickAndMortyCharacter getCharacter(@PathVariable int id) {
        return rickAndMortyApiService.loadCharacterById(id);
    }

}
