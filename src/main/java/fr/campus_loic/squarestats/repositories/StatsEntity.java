package fr.campus_loic.squarestats.repositories;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity(name="Stats")
public class StatsEntity {
    @Id
    public String id;
    public @NotNull String gameId;
    public @NotNull String ownerId;
    public String winner;

    @ElementCollection
    public List<PlayerEntity> players;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getGameId() {
        return gameId;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public String getWinner() {
        return winner;
    }
    public void setWinner(String winner) {
        this.winner = winner;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
        this.players = players;
    }
}
