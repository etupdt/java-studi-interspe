package fr.studi.interspe.pojo;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
/* 
    @JsonIgnoreProperties(value = "genres")
    @OneToMany(mappedBy = "genre")
    private Set<LivreGenre> livres;
*/
    public Genre(){

    }

    public Genre(String nom) {
        this.nom = nom;
    }


}


