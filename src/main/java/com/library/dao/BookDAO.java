package com.library.dao;

import com.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDAO {
    SessionFactory sessionFactory =
            HibernateUtil.getSessionFactory();

    Session session = sessionFactory.openSession();

    Transaction tx = session.beginTransaction();
}