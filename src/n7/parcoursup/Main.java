package n7.parcoursup;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom du fichier contenant les données: ");
        String fileName = scanner.next();

        System.out.print("Voulez-vous favoriser les écoles ? (y/n): ");
        boolean favoriteSchool = scanner.next().equalsIgnoreCase("y");
        new Runner(fileName).run(favoriteSchool);
    }
}