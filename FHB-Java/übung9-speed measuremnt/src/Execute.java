import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Execute {
    private static List<Element> elements = new ArrayList<Element>();
    static Measurements measurements = new Measurements();

    public static void main(String[] args){
        Element.bucketSize = 100;
        int amount = 50000;
        for(int i = 0;i<amount;i++)
            elements.add(new Element());

        Collections.shuffle(elements);
        long start = System.currentTimeMillis();
        measurements.insert(elements);
        Collections.shuffle(elements);
        start = System.currentTimeMillis();
        measurements.search(elements);
        measurements.delete(elements);
        long totalTime = (System.currentTimeMillis() - start);

        File textfile = new File("Measurements.txt");
        try {
            textfile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter(textfile, false);
            writer.write("Messung fuer " + amount + " Elemente, BucketSize=" + Element.bucketSize + ", abgeschlossen nach " + totalTime + "ms\n");
            writer.write(measurements.toString());
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Messung fuer " + amount + " Elemente, BucketSize=" + Element.bucketSize + ", abgeschlossen nach " + totalTime + "ms");
    }
}
