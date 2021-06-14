/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Book;

/**
 *
 * @author SJUBE
 */
public class BookDTO {

    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private int publishYear;

    public BookDTO(Book bk) {
        this.isbn = bk.getIsbn();
        this.title = bk.getTitle();
        this.author = bk.getAuthor();
        this.publisher = bk.getPublisher();
        this.publishYear = bk.getPublishYear();
    }

    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BookDTO{isbn=").append(isbn);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", publisher=").append(publisher);
        sb.append(", publishYear=").append(publishYear);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}

