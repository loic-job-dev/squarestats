package fr.campus_loic.squarestats.domain;

import fr.campus_loic.squarestats.controller.dto.StatsDto;

import java.util.List;

public interface StatsService {

    List<StatsDto> getAllStats();

    StatsDto getStatsByGame(String gameId);

    List<StatsDto> getStatsByPlayer(String playerId);

    void createStats(StatsDto statsDto);

    void updateStats(StatsDto statsDto);

    void deleteStatsByGame(String gameId);
}
