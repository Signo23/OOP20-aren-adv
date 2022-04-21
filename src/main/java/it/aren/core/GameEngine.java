/**
 * 
 */
package it.aren.core;

import java.util.LinkedList;
import java.util.List;

import it.aren.common.Constant;
import it.aren.common.Settings;
import it.aren.event.Event;
import it.aren.event.EventListener;
import it.aren.graphic.SwingView;
import it.aren.graphic.View;
import it.aren.input.InputController;
import it.aren.input.KeyboardInputController;
import it.aren.model.GameState;

/**
 * This class contain the main loop.
 * This is the main controller.
 * Implements {@link EventListener}
 *
 */
public class GameEngine implements EventListener{
    private View view;
    private GameState state;
    private InputController controller;
    
    private final List<Event> eventList;
    
    /**
     * Constructor for GameEngine.
     */
    public GameEngine() {
        this.eventList = new LinkedList<>();
    }
    
    /**
     * Setup the game.
     */
    public void setup() {
        this.state = new GameState();
        this.controller = new KeyboardInputController();
        this.view = new SwingView(this.state.getWorld(), this.controller, new Settings());
    }

    /**
     * The main loop of the game.
     * Call {@link setup()} before this.
     */
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
        this.launchEvent();
    }

    private void launchEvent() {
        this.eventList.stream().forEach(e -> e.launch(this.state.getWorld()));
        this.eventList.clear();
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

    @Override
    /**
     * {@inheritDoc}
     */
    public void notifyEvent(final Event event) {
        this.eventList.add(event);
    }
}
