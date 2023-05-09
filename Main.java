import java.util.*;

class Book {
   int id;
   String name, author, publisher;
   int quantity;
   
   public Book(int id, String name, String author, String publisher, int quantity) {
      this.id = id;
      this.name = name;
      this.author = author;
      this.publisher = publisher;
      this.quantity = quantity;
   }
}

class Library {
   List<Book> books = new ArrayList<Book>();
   public Book searchBookBy;
   
   public void addBook(Book b) {
      books.add(b);
   }
   
   public void removeBook(Book b) {
      books.remove(b);
   }
   
   public List<Book> searchBookByAuthor(String author) {
      List<Book> result = new ArrayList<Book>();
      for (Book b : books) {
         if (b.author.equals(author)) {
            result.add(b);
         }
      }
      return result;
   }
   
   public List<Book> searchBookByTitle(String title) {
      List<Book> result = new ArrayList<Book>();
      for (Book b : books) {
         if (b.name.equals(title)) {
            result.add(b);
         }
      }
      return result;
   }
}

class User {
   int id;
   String name, email;
   List<Book> borrowedBooks = new ArrayList<Book>();
   
   public User(int id, String name, String email) {
      this.id = id;
      this.name = name;
      this.email = email;
   }
}

class BorrowBook {
   public void borrowBook(User u, Book b) {
      if (b.quantity > 0) {
         u.borrowedBooks.add(b);
         b.quantity--;
      }
   }
   
   public void returnBook(User u, Book b) {
      u.borrowedBooks.remove(b);
      b.quantity++;
   }
}

public class Main {
   public static void main(String[] args) {
      // Initialize the library with some books
      Library library = new Library();
      library.addBook(new Book(1, "The Alchemist", "Paulo Coelho", "HarperCollins", 5));
      library.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", 3));
      library.addBook(new Book(3, "1984", "George Orwell", "Secker & Warburg", 2));
      
      // Initialize some users
      User user1 = new User(1, "John", "john@example.com");
      User user2 = new User(2, "Mary", "mary@example.com");
      
      // Let John borrow a book
      BorrowBook bb = new BorrowBook();
      bb.borrowBook(user1, library.searchBookByTitle("The Alchemist").get(0));
      
      // Let Mary borrow a book
      bb.borrowBook(user2, library.searchBookBy);
   }
}
