/**
 * 
 */
package it.aren.core;

import it.aren.common.Constant;
import it.aren.graphic.SwingView;
import it.aren.graphic.View;
import it.aren.input.InputController;
import it.aren.input.KeyboardInputController;
import it.aren.model.GameState;

/**
 * 
 *
 */
public class GameEngine {
    private View view;
    private GameState state;
    private InputController controller;
    
    public void setup() {
        this.state = new GameState();
        this.controller = new KeyboardInputController();
        this.view = new SwingView(this.state.getWorld(), this.controller);
    }

    public void loop() {
        while(true) {
            final long current = System.currentTimeMillis();
            this.processInput();
            this.updateGame();
            this.render();
            this.waitNextFrame(current);
        }
    }

    private void processInput() {
        this.state.getWorld().getCurrentMap().getBlocks().forEach(b -> b.updateInput(this.controller));
        this.state.getWorld().getPlayer().updateInput(this.controller);
    }

    private void updateGame() {
        this.state.getWorld().getPlayer().updateState();
    }

    private void render() {
        this.view.render();
    }

    private void waitNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < Constant.DEFAULT_FPS) {
            try {
                Thread.sleep(Constant.DEFAULT_FPS - dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}