package fr.campus_loic.squarestats.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record PlayerDto(
        String playerId) {
}
