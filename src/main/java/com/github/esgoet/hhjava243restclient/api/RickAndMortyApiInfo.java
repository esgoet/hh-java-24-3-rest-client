package com.github.esgoet.hhjava243restclient.api;

public record RickAndMortyApiInfo(
        int count,
        int pages,
        String next,
        String prev
) {
}
