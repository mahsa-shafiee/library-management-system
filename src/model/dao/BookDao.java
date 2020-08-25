package model.dao;

import model.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class BookDao {
    private SessionFactory sessionFactory = SessionFactoryConfig.getSessionFactory();

    public List<Book> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Book> allBooks = session.createQuery("from Book", Book.class).getResultList();
        transaction.commit();
        session.close();
        return allBooks;
    }

    public void insert(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void update(Book book) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Book resultBook = session.load(Book.class, book.getId());
        resultBook.setName(book.getName());
        resultBook.setAuthor(book.getAuthor());
        resultBook.setMember_id(book.getMember_id());
        session.update(resultBook);
        transaction.commit();
        session.close();
    }

    public Book findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Book book = session.createQuery("from Book where id=:id", Book.class)
                .setParameter("id", id)
                .getSingleResult();
        transaction.commit();
        session.close();
        return book;
    }

    public int deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        int rowAffected = session.createQuery("delete from Book where id=:id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        session.close();
        return rowAffected;
    }

    public List<Book> searchByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Book> books = session.createQuery("from Book where name like :name", Book.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
        transaction.commit();
        session.close();
        return books;
    }
}
