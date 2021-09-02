package iostreams;

import java.io.IOException;

public class InputStream extends java.io.InputStream { //we use this if we wanna work with the (binary) data of e.g. a file directly
    private final java.io.InputStream is;

    public InputStream(java.io.InputStream is){
        this.is = is;
    }

    public int read() throws IOException {
        return is.read();
    }
}
