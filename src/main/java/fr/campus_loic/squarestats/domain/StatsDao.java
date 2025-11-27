package fr.campus_loic.squarestats.domain;

import fr.campus_loic.squarestats.controller.dto.StatsDto;

import java.util.List;

public interface StatsDao {

    List<StatsDto> findAllStats();

    StatsDto findStatsByGame(String gameId);

    List<StatsDto> findStatsByPlayer(String playerId);

    void saveStats(StatsDto statsDto);

    void updateStats(String gameId, StatsDto statsDto);

    void deleteStats(String gameId);
}
