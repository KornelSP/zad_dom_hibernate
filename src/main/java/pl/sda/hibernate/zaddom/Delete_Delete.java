package pl.sda.hibernate.zaddom;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Delete_Delete {

        public static void main() {
            // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
            try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();

                // Najpierw SELECT * FROM Student WHERE id = 2L
                System.out.println("Którą pozycję chcesz usunąć?");
                Scanner scanner = new Scanner(System.in);
                long id = scanner.nextLong();

                Pojazd pojazd = session.get(Pojazd.class, id);

                // jeśli udało się znaleźć
                if (pojazd != null) {
                    // DELETE FROM Student WHERE id = 2L
                    System.out.println("Pojazd usunięty z bazy");
                    session.remove(pojazd);
                } else {
                    System.out.println("Żądanego pojazdu nie ma w bazie");
                }

                // zatwierdzamy transakcję
                transaction.commit();
            } catch (Exception ioe) {
                // jeśli złapiemy błąd, to wywoła się catch

            }
        }
    }

