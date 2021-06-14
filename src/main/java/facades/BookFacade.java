package facades;

import dtos.BookDTO;
import entities.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import security.errorhandling.AuthenticationException;

public class BookFacade {

    private static EntityManagerFactory emf;
    private static BookFacade instance;

    private BookFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static BookFacade getBookFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookFacade();
        }
        return instance;
    }

    public long getRenameMeCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(b) FROM Book b").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }

    }

    public static List<BookDTO> getAllBooks() {
        List<BookDTO> bdtos = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> q1 = em.createQuery("SELECT b From Book b", Book.class);
        List<Book> bl = q1.getResultList();
        bl.forEach(b -> bdtos.add(new BookDTO(b)));
        return bdtos;
    }

}
