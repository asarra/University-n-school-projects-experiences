package exceptions;

import java.io.IOException;

public class test {
    public static void main(String[] args){
        try {
            status s = new status(0);
        }
        catch (FileFormatException|IOException e){
            e.printStackTrace();
        }
    }
}
