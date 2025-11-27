package fr.campus_loic.squarestats.controller;

import fr.campus_loic.squarestats.controller.dto.StatsDto;
import fr.campus_loic.squarestats.domain.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    StatsService statsService;

    @GetMapping
    public List<StatsDto> getAllStats() {
        return statsService.getAllStats();
    }

    @GetMapping("/game/{gameId}")
    public StatsDto getStats(@PathVariable String gameId) {
        return statsService.getStatsByGame(gameId);
    }

    @GetMapping("/player/{playerId}")
    public List<StatsDto> getStatsByPlayer(@PathVariable String playerId) {
        return statsService.getStatsByPlayer(playerId);
    }

    @PostMapping
    public void createStats(@RequestBody StatsDto statsDto) {
        statsService.createStats(statsDto);
    }

    @DeleteMapping
    public void deleteStats(@RequestBody String gameId) {
        statsService.deleteStatsByGame(gameId);
    }
}

