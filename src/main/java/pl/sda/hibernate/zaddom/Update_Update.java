package pl.sda.hibernate.zaddom;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Update_Update {
    public static void main(String[] args) {

        // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Tworzymy Pojazd
            Pojazd pojazd = Pojazd.builder()
                    .marka("Skoda")
                    .moc(62d)
                    .kolor("Zielony")
                    .rokProdukcji(2010)
                    .elektryczny(true)
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
