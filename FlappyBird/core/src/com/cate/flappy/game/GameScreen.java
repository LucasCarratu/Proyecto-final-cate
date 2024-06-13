package com.cate.flappy.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cate.flappy.Assets;
import com.cate.flappy.MainFlppyBird;
import com.cate.flappy.screens.Screens;

public class GameScreen extends Screens {
    static final int STATE_READY = 0;
    static final int STATE_RUNNING = 1;
    static final int STATE_GAMEOVER = 2;
    int state;

    Image getReady, tap, gameOver;

    public GameScreen(MainFlppyBird game) {
        super(game);
        state = STATE_READY;

        getReady = new Image(Assets.getReady);
        getReady.setPosition(SCREEN_WIDTH / 2 - getReady.getWidth() / 2, 600);
        tap = new Image(Assets.tap);
        tap.setPosition(SCREEN_WIDTH / 2 - tap.getWidth() / 2, 310);

        gameOver = new Image(Assets.gameOver);
        gameOver.setPosition(SCREEN_WIDTH / 2 - gameOver.getWidth() / 2, 400); 

        stage.addActor(getReady);
        stage.addActor(tap);
    }

    @Override
    public void update(float delta) {
        switch (state) {
            case STATE_READY:
                updateReady(delta);
                break;
            case STATE_RUNNING:
                updateRunning(delta);
                break;
            case STATE_GAMEOVER:
                updateGameOver(delta);
                break;
        }
    }

    private void updateReady(float delta) {
        if (Gdx.input.justTouched()) {
            getReady.addAction(Actions.fadeOut(.3f));
            tap.addAction(Actions.sequence(
                    Actions.fadeOut(.3f),
                    Actions.run(new Runnable() {
                        @Override
                        public void run() {
                            getReady.remove();
                            tap.remove();
                            state = STATE_RUNNING;
                        }
                    })
            ));
        }
    }

    private void updateRunning(float delta) {
        if (Gdx.input.justTouched()) {
            state = STATE_GAMEOVER;
            stage.addActor(gameOver);
        }
    }

    private void updateGameOver(float delta) {

    }

    @Override
    public void draw(float delta) {

    }
}
