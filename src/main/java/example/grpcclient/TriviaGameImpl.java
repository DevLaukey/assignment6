package example.grpcclient;

import io.grpc.stub.StreamObserver;
import services.Trivia;
import services.TriviaGameGrpc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TriviaGameImpl extends TriviaGameGrpc.TriviaGameImplBase {

    private static final List<String> categories = Arrays.asList("General Knowledge", "Science", "History", "Geography");

    @Override
    public void getTriviaQuestion(Trivia.TriviaRequest request, StreamObserver<Trivia.TriviaResponse> responseObserver) {
        String category = request.getCategory();
        String question = generateRandomQuestion(category);
        List<String> options = generateRandomOptions(category);

        Trivia.TriviaResponse response = Trivia.TriviaResponse.newBuilder()
                .setQuestion(question)
                .addAllOptions(options)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void submitTriviaAnswer(Trivia.TriviaAnswerRequest request, StreamObserver<Trivia.TriviaAnswerResponse> responseObserver) {
        String userAnswer = request.getAnswer();
        boolean isCorrect = checkAnswer(userAnswer);

        String explanation = isCorrect ? "Correct! Well done." : "Incorrect. Better luck next time.";

        Trivia.TriviaAnswerResponse response = Trivia.TriviaAnswerResponse.newBuilder()
                .setIsCorrect(isCorrect)
                .setExplanation(explanation)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private String generateRandomQuestion(String category) {

        switch (category) {
            case "General Knowledge":
                return "What is the largest mammal on Earth?";
            case "Science":
                return "What is the chemical symbol for gold?";
            case "History":
                return "In which year did World War II end?";
            case "Geography":
                return "Which river is the longest in the world?";
            default:
                return "Unknown category. Please choose a valid category.";
        }
    }

    private List<String> generateRandomOptions(String category) {
        switch (category) {
            case "General Knowledge":
                return Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Hippopotamus");
            case "Science":
                return Arrays.asList("Au", "Ag", "Fe", "Cu"); // Chemical symbols for gold, silver, iron, copper
            case "History":
                return Arrays.asList("1918", "1945", "1980", "2000"); // Years representing historical periods
            case "Geography":
                return Arrays.asList("Nile", "Amazon", "Mississippi", "Yangtze"); // Longest rivers
            default:
                return Arrays.asList("Option1", "Option2", "Option3", "Option4");
        }
    }

    private boolean checkAnswer(String userAnswer) {
        // In a real-world scenario, compare the user's answer with the correct answer.
        // For simplicity, using hard-coded correct answers here.
        switch (userAnswer.toLowerCase()) {
            case "blue whale":
            case "australia":
            case "au":
            case "gold":
            case "1945":
            case "nile":
                return true;
            default:
                return false;
        }
    }
}
