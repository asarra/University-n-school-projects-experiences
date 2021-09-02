package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import kw51.lib.data.RGB;
import kw51.lib.data.Tile;

public class DiceWarsFileInput extends InputStream{
    private final InputStream is;

    public DiceWarsFileInput(InputStream is){
        this.is = is;
    }
    public int read() throws IOException {
        return is.read();
    }

    public GameStatus readGameStatus() throws FileFormatException, IOException {
        byte[] header = new byte[6];
        byte[] header1 = "##dw##".getBytes();
        is.read(header);
        System.out.println(Arrays.toString(header));
        if (!Arrays.equals(header, header1))
            throw new FileFormatException("Keine DiceWars File!");
        if (is.read() != 10) throw new FileFormatException("Keine DiceWars File!");
        int playerCount = is.read();
        System.out.println(playerCount);
        int currPlayer = is.read();
        if (currPlayer > playerCount) throw new FileFormatException("Keine DiceWars File!");
        System.out.println(currPlayer);
        if (is.read() != 10) throw new FileFormatException("Keine DiceWars File!");
        RGB[] colors= new RGB[playerCount];
        byte[] colorRGBs = new byte[3];
        for (int i = 0; i < colors.length; i++) {
            is.read(colorRGBs);
            colors[i] = new RGB(colorRGBs[0] & 0xFF,colorRGBs[1] & 0xFF,colorRGBs[2] & 0xFF);
        }
        if (is.read() != 10) throw new FileFormatException("Keine DiceWars File!");
        int dim = is.read();
        Tile[][] board = new Tile[dim][dim];
        int temp = 0, temp2 = 0;
        for (int i = 0; i < board.length*board.length; i++)
        {
            board[temp][temp2] = new Tile(is.read(),is.read());
            board[temp][temp2].setDices(is.read());
            int player = is.read();
            board[temp][temp2++].setPlayer(player == 255? -1 : player);
            if (temp2 >= dim) {
                temp2 = 0;
                temp++;
            }
        }
        if (is.available() > 0) throw new FileFormatException("Keine DiceWars File!");
        return new GameStatus(board, colors, currPlayer);
    }

}




/*    public GameStatus readGameStatus(){
        try{
            byte[] msg = is.readAllBytes();//.split("\\r?\\n");
            byte[] header = msg[0].getBytes();
            byte[] scas = msg[1].getBytes();
            byte[] rgb = msg[2].getBytes();
            byte[] board = msg[3].getBytes();

            int playercounter = scas[0];
            int currentplayer = scas[1];

            Tile[][] tiles = new Tile[board[0]][board[0]];
            RGB[] colors = new RGB[playercounter];
            int j=0;
            for(int i=0;i<colors.length;i++){
                colors[i]=new RGB(rgb[j]&0xFF,rgb[j+1]&0xFF,rgb[j+2]&0xFF);
                j+=3;
            }

            j=1;
            for (int i = 0;i<tiles.length;i++) {
                for (int x = 0;x<tiles.length;x++) {
                    tiles[i][x]=new Tile(board[j], board[j+1]);
                    tiles[i][x].setDices(board[j+2]);
                    tiles[i][x].setPlayer(board[j+3]);
                    // System.out.println(tiles[i][x]);
                    j+=4;
                }
            }

            System.out.println(Arrays.toString(msg));
            //System.out.println(Arrays.toString(tiles));
            return new GameStatus(tiles, colors, currentplayer);
        }
        catch (IOException e){
            System.out.println("Fehler beim Lesen vom Spielstatus:"+e);
        }
        return null;

    }*/