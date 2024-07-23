package com.github.esgoet.hhjava243restclient;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.List;


@Service
public class RickAndMortyApiService {
    RestClient restClient = RestClient.builder()
            .baseUrl("https://rickandmortyapi.com/api")
            .build();

    public List<RickAndMortyCharacter> loadAllCharacters(Map<String, String> params) {
        StringBuilder uri = new StringBuilder("/character");
        if (!params.keySet().isEmpty()) {
            uri.append("?");
            params.forEach((k, v) -> uri.append(k).append("=").append(v).append("&"));
        }
        RickAndMortyApiResponse response = restClient.get()
                .uri(uri.toString())
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
