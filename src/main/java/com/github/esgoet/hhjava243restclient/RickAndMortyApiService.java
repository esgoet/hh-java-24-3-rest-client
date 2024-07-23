package com.github.esgoet.hhjava243restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;


@Service
public class RickAndMortyApiService {
    RestClient restClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .build();

    public List<RickAndMortyCharacter> loadAllCharacters() {
        RickAndMortyApiResponse response = restClient.get()
                .uri("/character")
                .retrieve()
                .body(RickAndMortyApiResponse.class);
        return response.results();
    }

    public List<RickAndMortyCharacter> loadCharactersWithStatus(String status) {
        RickAndMortyApiResponse response = restClient.get()
                .uri("/character/?status=" + status)
                .retrieve()
                .body(RickAndMortyApiResponse.class);
        return response.results();
    }

    public RickAndMortyCharacter loadCharacterById(int id) {
        return restClient.get()
                .uri("/character/" + id)
                .retrieve()
                .body(RickAndMortyCharacter.class);
    }

}
