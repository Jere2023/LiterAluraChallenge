package com.challengeLiteralura.Literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAPIRespuesta(
        @JsonAlias("results") List<DatosLibro> resultado
) {
}
