package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test // ок
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);

    }


    @Test
    public void TestSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Ведьмак", "Рпг");
        Game game1 = store.publishGame("Ведьмак 2", "Рпг");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 2);
        player.play(game3, 1);

        int expected = 5;
        int actual = player.sumGenre("Рпг");
        assertEquals(expected, actual);
    }

    @Test // ок
    public void shouldThrowRunTimeException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Ведьмак", "Рпг");
        Game game1 = store.publishGame("Ведьмак 2", "Рпг");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);


        assertThrows(RuntimeException.class, () -> {
            player.play(game3, 1);
        });
    }

    @Test // ок
    public void addPlayGameNegativeValue() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);


        assertThrows(Exception.class, () -> {
            player.play(game, -1);
        });
    }

    @Test
    public void shouldShowMostPlayedGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Ведьмак", "Рпг");
        Game game1 = store.publishGame("Ведьмак 2", "Рпг");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 1);
        player.play(game3, 4);

        Game expected = game3;
        Game actual = player.mostPlayerByGenre("Аркады");

        assertEquals(expected, actual);
    }

}


