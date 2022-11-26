package pl.sda.hibernate.zaddom;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Update_Update {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Tworzymy Pojazd
            System.out.println("Podaj markę:");
            String marka = scanner.nextLine();

            System.out.println("Podaj moc:");
            double moc = scanner.nextDouble();

            String cos = scanner.nextLine();
            System.out.println("Podaj kolor:");
            String kolor = scanner.nextLine();

            System.out.println("Podaj rok produkcji:");
            int rokProdukcji = scanner.nextInt();

            System.out.println("Napisz, czy pojazd jest elektryczny (true/false):");
            boolean czyElektryczny = scanner.nextBoolean();

            Pojazd pojazd = Pojazd.builder()
                    .marka(marka)
                    .moc(moc)
                    .kolor(kolor)
                    .rokProdukcji(rokProdukcji)
                    .elektryczny(czyElektryczny)
                    .id(2L)
                    .build();

            // zapisujemy pojazd
            session.merge(pojazd);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }

}
