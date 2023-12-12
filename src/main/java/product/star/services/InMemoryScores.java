package product.star.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryScores implements TestScores{
    final Map<Integer,Integer> testScores;

    @Value("${testing.scores}")
    private String scoresString;

    public InMemoryScores() {
        this.testScores = new HashMap<>();
    }

    public void setScores(){
        try{
        String[] data = scoresString.split(",");
       for (String elem:data){
            String[] testScore = elem.trim().split(":");
            String[] testNumbers = testScore[0].split("-");
            for (int i = Integer.parseInt(testNumbers[0]); i<=Integer.parseInt(testNumbers[1]);i++){
                testScores.put(i,Integer.parseInt(testScore[1]));
            }
        }
        }catch (Exception ex){
            System.out.println("Wrong values in score property file");
        }
    }

    @Override
    public Integer getScore(Integer taskNumber) {
        return testScores.get(taskNumber);
    }
}
