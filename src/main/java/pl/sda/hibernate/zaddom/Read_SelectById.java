package pl.sda.hibernate.zaddom;

import org.hibernate.Session;

import java.util.Scanner;

public class Read_SelectById { public static void main() {

    System.out.println("Którą pozycję chesz wczytać?");
    Scanner scanner = new Scanner(System.in);
    long id = scanner.nextLong();
    // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
    try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
        Pojazd student = session.get(Pojazd.class, id);

        // SELECT * FROM Pojazd WHERE id=X
        System.out.println("Znaleźliśmy pojazd: " + student);

    } catch (Exception ioe) {
        // jeśli złapiemy błąd, to wywoła się catch
        System.err.println("Błąd bazy: " + ioe);
    }
}
}
