package pl.sda.hibernate.zaddom;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;

    @Column(nullable = false)
    private String marka;

    private Double moc;
    private String kolor;
    private int rokProdukcji;
    private Boolean elektryczny;


}
