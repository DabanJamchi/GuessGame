import java.io.Console;

public class Guesser {
    private int low;
    private int high;

    // Konstruktor för Guesser-klassen
    public Guesser(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public void start() {
        rules(); // Anropar reglerna för spelet
        doGuesses(); // Startar processen av att gissa
    }

    private void rules() {
        System.out.println("Think of a number between " + low + " and " + high);
        System.out.println("I'm going to ask a few questions in order to guess the number.");
        System.out.println("Please answer T for true, and F for false.\n");
    }

    private String getReply() {
        String reply = "";
        Console console = System.console();

        if (console == null) {
            System.out.println("Console not available.");
            return null; // Returnerar null om konsolen inte är tillgänglig
        }

        while (true) {
            reply = console.readLine().trim().toUpperCase();
            if ("T".equals(reply) || "F".equals(reply)) {
                return reply; // Returnerar svaret om det är giltigt
            } else {
                System.out.println("Please answer T or F"); // Felmeddelande för ogiltiga svar 
            }
        }
    }

    private void doGuesses() {
        int i = 0; // Hur många gissningar
        int middle = 0;
        while (low < high) {
            middle = low + (high - low) / 2;

            System.out.println("Is the number less than or equal to " + middle + "?");
            String reply = getReply();
            if ("T".equals(reply)) {
                high = middle;
            } else {
                low = middle + 1;
            }
            i++;
        }
        answer(low, i);
    }

    private void answer(int guess, int numberOfGuesses) {
        System.out.println("You were thinking about " + guess + " (took me " + numberOfGuesses + " guesses)");
    }
}
