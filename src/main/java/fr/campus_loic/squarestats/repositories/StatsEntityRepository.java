package fr.campus_loic.squarestats.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatsEntityRepository extends JpaRepository<StatsEntity, String> {
    Optional<StatsEntity> findByGameId(String gameId);

    List<StatsEntity> findByPlayers_PlayerId(String playerId);
}
