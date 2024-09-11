package mattiasusin.D3S2U5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "autori")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autore {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private int dataDiNascita;
    private String avatar;

    //TO STRING
    @Override
    public String toString() {
        return "Autore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
