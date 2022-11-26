package pl.sda.hibernate.zaddom;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Co chesz zrobić? " +
                "\n 1) dodać pojazd " + "\"dodaj\"" + " " +
                "\n 2) wczytać listę pojazdów " + "\"lista\"" + " " +
                "\n 3) wyszukać pojazd " + "\"szukaj\"" + " " +
                "\n 4) usunąć pojazd z listy " + "\"usun\" " +
                "\n 5) zaktualizować istniejący pojazd " + "\"update\"" );

        Scanner scanner = new Scanner(System.in);
        String haslo = null;

        do {
            haslo = scanner.nextLine();
            switch (haslo) {
                case "dodaj":
                    Create_Insert.main();
                    break;
                case "lista":
                    ReadList.main();
                    break;
                case "szukaj":
                    Read_SelectById.main();
                    break;
                case "usun":
                    Delete_Delete.main();
                case "update":
                    Update_Update.main();
                default:
                    System.out.println("hasło nieprawidłowe \npodaj poprawną komendę");
                    break;


            }
        } while (!(haslo.equals("dodaj") || haslo.equals("lista") || haslo.equals("szukaj") || haslo.equals("usun")));
    }
}
