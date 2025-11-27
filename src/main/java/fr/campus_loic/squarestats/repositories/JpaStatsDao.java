package fr.campus_loic.squarestats.repositories;

import fr.campus_loic.squarestats.controller.dto.StatsDto;
import fr.campus_loic.squarestats.domain.StatsDao;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
@Primary
public class JpaStatsDao implements StatsDao {

    private final StatsEntityRepository repository;

    public JpaStatsDao(StatsEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StatsDto> findAllStats() {
        List<StatsEntity> listEntities = repository.findAll();
        return getStatsDtos(listEntities);
    }

    @Override
    public StatsDto findStatsByGame(String gameId) {
        StatsEntity statsEntity = repository.findByGameId(gameId).orElse(null);
        try {
            StatsDto stats = new StatsDto(gameId, statsEntity.ownerId, getPlayers(statsEntity), statsEntity.winner);
            return stats;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<StatsDto> findStatsByPlayer(String playerId) {
        List<StatsEntity> listEntities = repository.findByPlayers_PlayerId(playerId);
        return getStatsDtos(listEntities);
    }


    @Override
    public void saveStats(StatsDto statsDto) {
        StatsEntity statsEntity = new StatsEntity();
        statsEntity.setId(UUID.randomUUID().toString());
        statsEntity.setGameId(statsDto.gameId());
        statsEntity.setOwnerId(statsDto.ownerId());

        List<String> listPlayers = new ArrayList<>();
        List<PlayerEntity> listEntities =  new ArrayList<>();
        listPlayers = statsDto.players();
        for (String player : listPlayers) {
            PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.setPlayerId(player);
            listEntities.add(playerEntity);
        }

        statsEntity.setPlayers(listEntities);
        statsEntity.setWinner(statsDto.winner());
        repository.save(statsEntity);
    }

    @Override
    public void updateStats(String gameId, StatsDto statsDto) {

    }

    @Override
    public void deleteStats(String gameId) {
        repository.deleteById(gameId);
    }

    private List<String> getPlayers (StatsEntity statsEntity) {
        List<PlayerEntity> listPlayersEntities = statsEntity.players;
        List<String> players = new ArrayList<>();
        for (PlayerEntity playerEntity : listPlayersEntities) {
            players.add(playerEntity.playerId);
        }
        return players;
    }

    @NotNull
    private List<StatsDto> getStatsDtos(List<StatsEntity> listEntities) {
        List<StatsDto> listDto = new ArrayList<>();
        for (StatsEntity entity : listEntities) {
            List<String> players = getPlayers(entity);

            StatsDto stats = new StatsDto(entity.gameId, entity.ownerId, players, entity.winner);
            listDto.add(stats);
        }
        return listDto;
    }
}
