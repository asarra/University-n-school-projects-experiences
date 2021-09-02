package exceptions;

import java.io.IOException;

public class status {
    private int x=0;
    public status(int i){x=i;}
    public status readGameStatus() throws FileFormatException, IOException {
        return new status(0);
    }
}
