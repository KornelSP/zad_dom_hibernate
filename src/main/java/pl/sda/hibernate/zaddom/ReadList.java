package pl.sda.hibernate.zaddom;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class ReadList {public static void main(String[] args) {
    // wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
    try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {

        // Hibernate Query Language - odmiana SQL'a tylko w hibernate
        // Tworzymy obiekt "Zapytanie o typ" (TypedQuery) gdzie tworzymy na obiekcie sesji zapytanie "Select [NIE PODANE] [FROM Pojazd]"
        TypedQuery<Pojazd> zapytanie = session.createQuery("FROM Pojazd", Pojazd.class);

        // Wywołujemy metodę 'getResultList' która oznacza ([SELECT *] + z poprzedniej linii: [FROM Pojazd])
        List<Pojazd> listaWszystkichStudentow = zapytanie.getResultList();

        // Wypisz wyniki
        for (Pojazd pojazd : listaWszystkichStudentow) {
            System.out.println(pojazd);
        }

    } catch (Exception ioe) {
        // jeśli złapiemy błąd, to wywoła się catch
        System.err.println("Błąd bazy: " + ioe);
    }
}
}
