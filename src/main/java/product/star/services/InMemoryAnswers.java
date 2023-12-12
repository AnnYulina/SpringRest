package product.star.services;

import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryAnswers implements Answers{
    final Map<Integer,Character> answersData;

    public InMemoryAnswers() {
        this.answersData = new HashMap<>();
    }

    public void ReadFromFile(String fileName){
        try(var reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split("-");
                answersData.put(Integer.parseInt(data[0].trim()), data[1].trim().toCharArray()[0]);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Character getAnswerByTaskNumber(Integer taskNumber) {
        return answersData.get(taskNumber);
    }
}
