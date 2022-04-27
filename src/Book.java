/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Mohammad
 */
public class Book {
    private String title;         // Title of a book 
    private String subject;       // Subject to which a book is related!
    private String author;        // Author of book!
    private int bookPrice;// this will be true if the book is currently issued to some borrower.
    
    Scanner scanner = new Scanner(System.in);

    public Book() {
    }

    public Book(String title, String subject, String author, int bookPrice) {
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.bookPrice = bookPrice;
    }
    
    


    public String getTitle()
    {
        return title;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getAuthor()
    {
        return author;
    }
    public int getBookPrice()
    {
        return bookPrice;
    }
    
    
}
