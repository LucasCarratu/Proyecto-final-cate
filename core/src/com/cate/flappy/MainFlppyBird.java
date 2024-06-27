package com.cate.flappy;

import com.badlogic.gdx.Game;
import com.cate.flappy.game.GameScreen;

public class MainFlppyBird extends Game {

	@Override
	public void create() {
		Assets.load();
		setScreen(new GameScreen(this));
	}
}
