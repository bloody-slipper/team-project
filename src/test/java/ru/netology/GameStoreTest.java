package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {
    GameStore store = new GameStore();

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldContainsGameIfOneInList() {

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game1));
    }
    @Test
    public void shouldContainsTwoGame() {

        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Как достать соседа", "Аркады");

        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldGetSumPlayedTime() {

        store.addPlayTime("Irina47", 4);
        store.addPlayTime("Kolya55", 7);

        int expected = 11;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayTime() {
        store.addPlayTime("Irina47", 4);
        store.addPlayTime("Irina47", 1);

        int expected = 5;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }

}