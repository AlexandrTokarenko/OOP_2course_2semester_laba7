package textFile;

import convertor.TrainConvertor;
import train.Train;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFile {
    public void writeToFile(List<Train> arr, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (Train train : arr) {
                out.println(TrainConvertor.toText(train));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<Train> readFromFile(String filename ) {
        List<Train> arr = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String s;
            while ((s = reader.readLine()) != null) {
                Train t = TrainConvertor.fromText(s);
                arr.add(t);
            }
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}