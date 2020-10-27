package Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private final Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator(books);
    }

    private static class LibIterator implements Iterator<Book> {
        private final Book[] books;
        private int index;

        public LibIterator(Book[] books) {
            this.index = 0;
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[this.index++];
        }
    }
}
