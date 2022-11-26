package pl.sda.hibernate.zaddom;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Delete_Delete {

        public static void main(String[] args) {
            // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
            try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();

                // Najpierw SELECT * FROM Student WHERE id = 2L
                Pojazd pojazd = session.get(Pojazd.class, 0L);

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

