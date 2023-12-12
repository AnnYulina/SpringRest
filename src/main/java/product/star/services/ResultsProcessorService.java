package product.star.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ResultsProcessorService implements ResultsProcessor{
    private final InMemoryAnswers rightAnswers;
    private final InMemoryAnswers userAnswers;
    private final InMemoryScores scores;

    @Autowired
    public ResultsProcessorService(InMemoryScores scores,InMemoryAnswers rightAnswers,InMemoryAnswers userAnswers) {
        scores.setScores();
        this.scores = scores;
        this.rightAnswers = rightAnswers;
        this.userAnswers = userAnswers;
    }

    @Override
    public Integer getTotalScores(String answersFile, String testFile ) {
        var totalScore = 0;
        rightAnswers.ReadFromFile(answersFile);
        userAnswers.ReadFromFile(testFile);
        int taskNumbers = rightAnswers.answersData.keySet().stream().max(Comparator.naturalOrder())
                .orElseThrow(()-> new IllegalArgumentException("Wrong answers file"));
        for (int i =1; i<=taskNumbers;i++){
            if (userAnswers.getAnswerByTaskNumber(i)==rightAnswers.getAnswerByTaskNumber(i)){
                totalScore+=scores.getScore(i);
            }
        }
        return totalScore;
    }
}
