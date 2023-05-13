package fr.studi.interspe.ws;

import fr.studi.interspe.pojo.Livre;
import fr.studi.interspe.pojo.Status;
import fr.studi.interspe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController // produit et consomme du JSON
@RequestMapping(ApiRegistration.API_REST + ApiRegistration.BOOK)
public class BookWs {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Livre> getAllBooks(){

        return bookService.getAllBooks();

    }

    @GetMapping("/{status}")
    public List<Livre> getAllBooksByState(@PathVariable String status){
        
        switch (Status.valueOf(status.toUpperCase())) {
            case LOUE -> {
                System.out.println("LOUE"); 
                return bookService.getAllBooksByState(Status.LOUE);
            }
            case NON_LOUE -> {
                System.out.println("NON LOUE"); 
                System.out.println(Status.valueOf(status.toUpperCase())); 
                return bookService.getAllBooksByState(Status.NON_LOUE);
            }
            default -> {return null;}
        }
    }

}
