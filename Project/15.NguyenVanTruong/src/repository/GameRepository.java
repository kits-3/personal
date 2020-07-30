package repository;

import java.util.List;

import entity.Game;

public interface GameRepository {
	List<Game> infoGame();
	void add(Game gm);
	void update(Game gm);
	void delete(int id);
	List<Game> showKey();
}
