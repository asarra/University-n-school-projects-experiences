package natürlicheordnung;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args){
        List<Zahl> zahlen = Arrays.asList(
                new Zahl(5),
                new Zahl(-2),
                new Zahl(0)
        );

        Collections.sort(zahlen);
        System.out.println(zahlen);
    }
}
