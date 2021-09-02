package util;

import kw51.lib.data.RGB;
import kw51.lib.data.Tile;

public class GameStatus {
    public final Tile[][] board;
    public final RGB[] colors;
    public final int currentPlayer;

    public GameStatus(Tile[][] b, RGB[] c, int cp){
        board = b;
        colors = c;
        currentPlayer = cp;
    }


}
