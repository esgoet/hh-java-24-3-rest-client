package com.github.esgoet.hhjava243restclient;

import java.util.List;

public record RickAndMortyApiResponse(
        List<RickAndMortyCharacter> results
) {
}
