package fr.studi.interspe.pojo;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String description;

    private String titre;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;

    @ManyToOne
    @JoinColumn(name = "editeur_id")
    private Editeur editeur;

    @JsonIgnoreProperties({"id", "livre"})
    @OneToMany(mappedBy = "livre")
    private Set<LivreGenre> genres;

    private Boolean archive;

    private String image_name;

    public Livre(){

    }

    public Livre(String isbn, String titre, Boolean archive) {
        this.isbn = isbn;
        this.titre = titre;
        this.archive = archive;
    }
/* 
    @JsonIgnoreProperties(value = "livres")
    @ManyToMany
    @JoinTable(
      name = "livre_genre", 
      joinColumns = @JoinColumn(name = "livre_id"), 
      inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;
*/

}
