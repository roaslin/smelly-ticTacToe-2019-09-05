import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameShould {
    private Game game;

    @Before
    public void setup(){
        this.game = new Game();
    }

    @Test(expected=Exception.class)
    public void not_allow_player_O_to_play_first() throws Exception {
        game.Play('O', 0, 0);
    }

    @Test(expected=Exception.class)
    public void not_allow_player_X_to_play_twice_in_a_row() throws Exception
    {
        game.Play('X', 0, 0);

        game.Play('X', 1, 0);
    }

    @Test(expected=Exception.class)
    public void not_allow_player_to_play_in_last_played_position() throws Exception
    {
        game.Play('X', 0, 0);

        game.Play('O', 0, 0);
    }

    @Test(expected=Exception.class)
    public void nor_allow_player_to_play_in_any_played_position() throws Exception
    {
        game.Play('X', 0, 0);
        game.Play('O', 1, 0);

        game.Play('X', 0, 0);
    }

    @Test
    public void declare_player_X_as_a_winner_if_three_in_top_row() throws Exception
    {
        game.Play('X', 0, 0);
        game.Play('O', 1, 0);
        game.Play('X', 0, 1);
        game.Play('O', 1, 1);
        game.Play('X', 0, 2);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void declare_player_O_as_a_winner_if_three_in_top_row() throws Exception
    {
        game.Play('X', 2, 2);
        game.Play('O', 0, 0);
        game.Play('X', 1, 0);
        game.Play('O', 0, 1);
        game.Play('X', 1, 1);
        game.Play('O', 0, 2);

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void declare_player_x_as_a_winner_if_three_in_middle_row() throws Exception
    {
        game.Play('X', 1, 0);
        game.Play('O', 0, 0);
        game.Play('X', 1, 1);
        game.Play('O', 0, 1);
        game.Play('X', 1, 2);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void declare_player_O_as_a_winner_if_three_in_middle_row() throws Exception
    {
        game.Play('X', 0, 0);
        game.Play('O', 1, 0);
        game.Play('X', 2, 0);
        game.Play('O', 1, 1);
        game.Play('X', 2, 1);
        game.Play('O', 1, 2);

        char winner = game.Winner();

        assertEquals('O', winner);
    }

    @Test
    public void declare_player_x_as_a_winner_if_three_in_bottom_row() throws Exception
    {
        game.Play('X', 2, 0);
        game.Play('O', 0, 0);
        game.Play('X', 2, 1);
        game.Play('O', 0, 1);
        game.Play('X', 2, 2);

        char winner = game.Winner();

        assertEquals('X', winner);
    }

    @Test
    public void declare_player_O_as_a_winner_if_three_in_bottom_row() throws Exception
    {
        game.Play('X', 0, 0);
        game.Play('O', 2, 0);
        game.Play('X', 1, 0);
        game.Play('O', 2, 1);
        game.Play('X', 1, 1);
        game.Play('O', 2, 2);

        char winner = game.Winner();

        assertEquals('O', winner);
    }
}
