package pl.sda.hibernate.zaddom;

import org.hibernate.Session;

public class Read_CelectById { public static void main(String[] args) {
    // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
    try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
        Pojazd student = session.get(Pojazd.class, 2L);

        // SELECT * FROM Pojazd WHERE id=X
        System.out.println("Znaleźliśmy pojazd: " + student);

    } catch (Exception ioe) {
        // jeśli złapiemy błąd, to wywoła się catch
        System.err.println("Błąd bazy: " + ioe);
    }
}
}
