package it.aren.physics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import it.aren.core.GameEngine;
import org.junit.jupiter.api.Test;

import it.aren.Direction;
import it.aren.geom.Vector2D;
import it.aren.model.GameState;

class CollisionTest {
    @Test void testPlayerCollision() {
        /*final GameState gameState = new GameState(new GameEngine(menuController));

        gameState.getWorld().getPlayer().setVelocity(Direction.DOWN);
        gameState.getWorld().getPlayer().setLastDirection(Direction.DOWN);
        gameState.getWorld().updateState();

        System.out.println(gameState.getWorld().getPlayer().getPosition());
        assertEquals(gameState.getWorld().getPlayer().getPosition(), new Vector2D(0, 5));
        gameState.getWorld().updateState();

        System.out.println(gameState.getWorld().getPlayer().getPosition());
        assertEquals(gameState.getWorld().getPlayer().getPosition(), new Vector2D(0, 9));

        gameState.getWorld().getPlayer().setLastDirection(Direction.LEFT);
        gameState.getWorld().updateState();

        System.out.println(gameState.getWorld().getPlayer().getPosition());
        assertEquals(gameState.getWorld().getPlayer().getPosition().getX(), 0);

        gameState.getWorld().getPlayer().setLastDirection(Direction.DOWN);
        gameState.getWorld().updateState();

        System.out.println(gameState.getWorld().getPlayer().getPosition());
        assertEquals(gameState.getWorld().getPlayer().getPosition().getY(), 13);*/
    }
}