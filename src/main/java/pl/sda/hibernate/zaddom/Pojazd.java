package pl.sda.hibernate.zaddom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pojazd {

    @Id

    @Column(nullable = false)
    private String marka;

    private Double moc;
    private String kolor;
    private int rokProdukcji;
    private Boolean elektryczny;


}
