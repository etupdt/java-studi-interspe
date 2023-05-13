package fr.studi.interspe.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.studi.interspe.pojo.composite.CompositeBookKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LivreGenre {

    @EmbeddedId
    CompositeBookKey id;

    @ManyToOne
    @MapsId("genreId")
    @JsonIgnoreProperties(value = "livres")
    @JoinColumn(name = "genre_id", insertable=false, updatable=false)
    Genre genre;

    @ManyToOne
    @MapsId("livreId")
    @JsonIgnoreProperties(value = "genres")
    @JoinColumn(name = "livre_id", insertable=false, updatable=false)
    Livre livre;

}
