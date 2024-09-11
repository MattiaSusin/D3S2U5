package mattiasusin.D3S2U5.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private double tempoDiLettura;


    // TO STRING
    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", tempoDiLettura=" + tempoDiLettura +
                '}';
    }
}
