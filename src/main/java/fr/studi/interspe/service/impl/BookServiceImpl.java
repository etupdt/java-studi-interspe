package fr.studi.interspe.service.impl;

import fr.studi.interspe.pojo.Livre;
import fr.studi.interspe.pojo.Status;
import fr.studi.interspe.repository.BookRepository;
import fr.studi.interspe.service.BookService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl() {
    }

    @Override
    public List<Livre> getAllBooks(){

        return bookRepository.findAllBook(); 

    }

    @Override
    public List<Livre> getAllBooksByState(Status status){

        switch (status) {
            case LOUE -> { 
                System.out.println("LOUE"); 
                return bookRepository.findLivresLoues(); 
            }
            case NON_LOUE -> { 
                System.out.println("NON LOUE"); 
                return bookRepository.findLivresNonLoues(); 
            }
        }
            
        return null;

    }

}
