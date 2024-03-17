import java.util.Scanner;

public class Main {
    private static final int QUESTION_COUNT = 5; // Number of questions in the quiz
    private static final int QUESTION_TIME_LIMIT = 15; // Time limit for each question in seconds
    private static final String[] questions = {
        "What is the capital of France?",
        "Who painted the Mona Lisa?",
        "What is the largest planet in our solar system?",
        "Who wrote 'Romeo and Juliet'?",
        "What is the chemical symbol for water?"
    };
    private static final String[][] options = {
        {"A. Paris", "B. London", "C. Rome", "D. Madrid"},
        {"A. Leonardo da Vinci", "B. Michelangelo", "C. Pablo Picasso", "D. Vincent van Gogh"},
        {"A. Earth", "B. Jupiter", "C. Mars", "D. Venus"},
        {"A. William Shakespeare", "B. Jane Austen", "C. Charles Dickens", "D. F. Scott Fitzgerald"},
        {"A. H2O", "B. CO2", "C. O2", "D. NaCl"}
    };
    private static final char[] correctAnswers = {'A', 'A', 'B', 'A', 'A'};

    private static int score = 0;
    private static int currentQuestion = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have " + QUESTION_TIME_LIMIT + " seconds to answer each question.");
        System.out.println("Let's begin!\n");

        while (currentQuestion < QUESTION_COUNT) {
            displayQuestion();
            String userAnswer = scanner.nextLine().toUpperCase();
            if (userAnswer.length() > 0) {
                char userChoice = userAnswer.charAt(0);
                if (userChoice == correctAnswers[currentQuestion]) {
                    System.out.println("Correct answer!");
                    score++;
                } else {
                    System.out.println("Incorrect answer.");
                }
                currentQuestion++;
            } else {
                System.out.println("Please enter a valid answer.");
            }
        }

        System.out.println("\nQuiz completed! Here is your result:");
        System.out.println("Total Questions: " + QUESTION_COUNT);
        System.out.println("Correct Answers: " + score);
        System.out.println("Incorrect Answers: " + (QUESTION_COUNT - score));
        scanner.close();
    }

    private static void displayQuestion() {
        System.out.println("Question " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        for (String option : options[currentQuestion]) {
            System.out.println(option);
        }
        System.out.print("Enter your choice: ");
    }
}

