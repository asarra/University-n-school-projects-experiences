package iostreams;

import java.io.IOException;

public class OutputStream extends java.io.OutputStream{
    private final java.io.OutputStream os;

    public OutputStream(java.io.OutputStream os){
        this.os = os;
    }

    public void write(int binary) throws IOException {
        os.write(binary);
    }
}
