package fr.campus_loic.squarestats.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record StatsDto(
        String gameId,
        String ownerId,
        List<String> players,
        String winner) {
}
