import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortLister {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a text file");

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getName());
            System.out.println("\nShort words (less than 5 characters):");
            System.out.println("=====================================");

            ShortWordFilter filter = new ShortWordFilter();

            try {
                Scanner scanner = new Scanner(selectedFile);

                while (scanner.hasNext()) {
                    String word = scanner.next();

                    if (filter.accept(word)) {
                        System.out.println(word);
                    }
                }

                scanner.close();

            } catch (FileNotFoundException e) {
                System.err.println("Error: File not found - " + e.getMessage());
            }

        } else {
            System.out.println("No file selected. Exiting...");
        }
    }
}