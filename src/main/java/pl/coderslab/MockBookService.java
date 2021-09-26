package pl.coderslab;


import java.util.ArrayList;
import java.util.List;

public class MockBookService {
    private List<Book> list;
    private static Long nextId = 5L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1l, "235246", "Ksiazka1", "Tytul1", "Wydawca1", "Typ1"));
        list.add(new Book(2l, "345635", "Ksiazka2", "Tytul2", "Wydawca2", "Typ2"));
        list.add(new Book(3l, "678678", "Ksiazka3", "Tytul3", "Wydawca3", "Typ3"));
        list.add(new Book(4l, "325656", "Ksiazka4", "Tytul4", "Wydawca4", "Typ4"));
    }

    public List<Book> getList() {
        return list;
    }

    public Book getBook(Long id) {

        return list.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }

    public boolean editBook(Book b) {
        Book book = getBook(b.getId());
        if (book != null) {
            book.setIsbn(b.getIsbn());
            book.setTitle(b.getTitle());
            book.setAuthor(b.getAuthor());
            book.setPublisher(b.getPublisher());
            book.setType(b.getPublisher());
            return true;
        } else
            return false;

    }

    public boolean deleteBook(Long id) {
        Book book = getBook(id);
        if (book != null) {
            list.remove(book);
            return true;
        } else
            return false;
    }

    public boolean addBook(Book book) {
        book.setId(nextId);
        nextId++;
        list.add(book);
        return true;
    }
}