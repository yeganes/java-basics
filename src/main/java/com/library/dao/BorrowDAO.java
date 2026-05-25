package com.library.dao;



import com.library.model.Book;
import com.library.model.Borrow;
import com.library.model.Member;
import com.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class BorrowDAO {
    SessionFactory sessionFactory =
            HibernateUtil.getSessionFactory();


    public void insert(Member member , Book book){


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setMember(member);
        session.persist(borrow);


        tx.commit();
        session.close();

    }


    public List<Borrow> selectAll(){

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Query<Borrow> borrowQuery = session.createQuery("FROM Borrow ", Borrow.class);
        List<Borrow> borrowList = borrowQuery.list();


        tx.commit();
        session.close();
        return borrowList;
    }


    public List<Borrow> selectMemberBook(Member member , Book book){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();


        Query<Borrow> borrowQuery = session.createQuery("FROM Borrow WHERE member = :member AND book = :book", Borrow.class);
        borrowQuery.setParameter("member", member);
        borrowQuery.setParameter("book", book);


        tx.commit();
        session.close();
        return borrowQuery.list();
        }




        public void delete(Member member , Book book){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
            Borrow borrow = new Borrow();
            borrow.setBook(book);
            borrow.setMember(member);
            session.remove(borrow);
            tx.commit();
            session.close();

        }
    }
