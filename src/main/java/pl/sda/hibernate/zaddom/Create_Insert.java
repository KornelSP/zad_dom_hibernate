package pl.sda.hibernate.zaddom;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Create_Insert {
    public static void main(String[] args) {

        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Tworzymy Pojazd
            Pojazd punto = Pojazd.builder()
                    .marka("Fiat")
                    .moc(50d)
                    .kolor("Srebrny")
                    .rokProdukcji(2001)
                    .elektryczny(false)
                    .build();

            // zapisujemy studenta
            session.persist(punto);

            // zatwierdzamy transakcję
            transaction.commit();
        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
            System.err.println("Błąd bazy: " + ioe);
        }
    }

}
