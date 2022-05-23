import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import train.Train;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFile {
    public void writeToFile(List<Train> trains, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName),trains);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Train> readFromFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Train> trains = objectMapper.readValue(new File(fileName),new TypeReference<List<Train>>(){});
            return trains;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
