package com.challengeLiteralura.Literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutor(
        @JsonAlias("name") String nombre,

        @JsonAlias("birth_year") int birth_year,

        @JsonAlias("birth_year") int death_year
) {
}
