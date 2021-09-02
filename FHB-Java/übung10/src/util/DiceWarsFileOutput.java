package util;

import kw51.lib.data.RGB;
import kw51.lib.data.Tile;
import kw51.lib.game.DiceWars;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class DiceWarsFileOutput extends OutputStream{
    private final OutputStream os;

    public DiceWarsFileOutput(OutputStream os){
        this.os = os;
    }
    public void write(int msg) throws IOException {
        os.write((byte)msg);
    }
    public void writeGameStatus(GameStatus gs) throws IOException {
            os.write("##dw##".getBytes());
            os.write(10);
            os.write(gs.colors.length);
            os.write(gs.currentPlayer);
            os.write(10);
            for (RGB s:gs.colors) {
                os.write(s.r);
                os.write(s.g);
                os.write(s.b);
            }
            os.write(10);
            os.write(gs.board.length);
            for (Tile[] t:gs.board) {
                for (Tile x : t) {
                    os.write(x.getFieldPosition().getX());
                    os.write(x.getFieldPosition().getX());
                    os.write(x.getDices());
                    os.write(x.getPlayer());
                }
            }
    }

}
