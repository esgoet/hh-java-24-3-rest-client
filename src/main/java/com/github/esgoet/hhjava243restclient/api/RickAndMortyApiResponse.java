package com.github.esgoet.hhjava243restclient.api;

import com.github.esgoet.hhjava243restclient.characters.RickAndMortyCharacter;

import java.util.List;

public record RickAndMortyApiResponse(
        RickAndMortyApiInfo info,
        List<RickAndMortyCharacter> results
) {
}
