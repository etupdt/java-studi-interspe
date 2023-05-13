package fr.studi.interspe.service;

import java.util.List;

import fr.studi.interspe.pojo.Livre;
import fr.studi.interspe.pojo.Status;

public interface BookService {

    public List<Livre> getAllBooks();

    public List<Livre> getAllBooksByState(Status status);

}
