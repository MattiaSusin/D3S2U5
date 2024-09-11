package mattiasusin.D2S2U5.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
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
