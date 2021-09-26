package pl.coderslab;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/books")

public class BookController {
    private static MockBookService service = new MockBookService();

    @RequestMapping("/helloBook")

    public Book helloBook() {

        return new Book(1L, "9788324631766", "Thinking in Java",

                "Bruce Eckel", "Helion", "programming");

    }

    @RequestMapping("")
    public List<Book> get() {
        return service.getList();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean create(@RequestBody Book book) {
        return service.addBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return service.getBook(id);

    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public boolean edit(@RequestBody Book book) {
        return service.editBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean deleteBook(@PathVariable Long id) {
        return service.deleteBook(id);
    }


}