import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Counting Program");
        System.out.println("Enter 'text' to input text, or 'file' to provide a file path:");
        String choice = scanner.nextLine().trim();

        String text = "";
        if (choice.equalsIgnoreCase("text")) {
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (choice.equalsIgnoreCase("file")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice.");
            System.exit(1);
        }

        String[] words = text.split("[\\s.,;!?]+");
        int wordCount = words.length;

        System.out.println("Total words: " + wordCount);

        scanner.close();
    }

    private static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        Scanner fileScanner = new Scanner(new File(filePath));
        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return content.toString();
    }
}
