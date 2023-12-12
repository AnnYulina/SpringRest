package product.star;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import product.star.config.ResultsProcessorConfiguration;
import product.star.services.InMemoryScores;
import product.star.services.ResultsProcessorService;

public class Main {
    public static void main(String[] args) {
        var answersFile = "src/main/resources/answers.txt";
        var testFile = "src/main/resources/ivanov.txt";
        var appContext = new AnnotationConfigApplicationContext(ResultsProcessorConfiguration.class);
        var resultsProcessor = appContext.getBean(ResultsProcessorService.class);
        System.out.println("Total score: " + resultsProcessor.getTotalScores(answersFile,testFile));
    }
}