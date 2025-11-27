package fr.campus_loic.squarestats.services;

import fr.campus_loic.squarestats.controller.dto.StatsDto;
import fr.campus_loic.squarestats.domain.StatsDao;
import fr.campus_loic.squarestats.domain.StatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    private final StatsDao statsDao;

    public StatsServiceImpl(StatsDao statsDao) {
        this.statsDao = statsDao;
    }


    @Override
    public List<StatsDto> getAllStats() {
        return statsDao.findAllStats();
    }

    @Override
    public StatsDto getStatsByGame(String gameId) {
        return statsDao.findStatsByGame(gameId);
    }

    @Override
    public List<StatsDto> getStatsByPlayer(String playerId) {
        return statsDao.findStatsByPlayer(playerId);
    }

    @Override
    public void createStats(StatsDto statsDto) {
        statsDao.saveStats(statsDto);
    }

    @Override
    public void updateStats(StatsDto statsDto) {

    }

    @Override
    public void deleteStatsByGame(String gameId) {
        statsDao.deleteStats(gameId);
    }
}
