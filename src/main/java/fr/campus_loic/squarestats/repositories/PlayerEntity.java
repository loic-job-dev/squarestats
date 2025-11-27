package fr.campus_loic.squarestats.repositories;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Embeddable
@Table(name="Player")
public class PlayerEntity {
    public @NotNull String playerId;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
