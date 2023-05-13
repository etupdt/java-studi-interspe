package fr.studi.interspe.pojo.composite;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.IdClass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CompositeBookKey implements Serializable {

//    @Column(name = "livre_id")
    private Long livreId;

//    @Column(name = "genre_id")
    private Long genreId;

    public CompositeBookKey(Long livreId, Long genreId) {
        this.genreId = genreId;
        this.livreId = livreId;
    }

    public CompositeBookKey() {
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompositeBookKey)) return false;
        CompositeBookKey that = (CompositeBookKey) o;
        return Objects.equals(getLivreid(), that.getLivreid()) &&
                Objects.equals(getGenreid(), that.getGenreid());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getLivreid(), getGenreid());
    }
*/
}
