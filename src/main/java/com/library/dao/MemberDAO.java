package com.library.dao;



import com.library.model.Book;
import com.library.model.Member;
import com.library.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

        SessionFactory sessionFactory =
                HibernateUtil.getSessionFactory();


        public void save(Member member){

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.persist(member);

            tx.commit();
            session.close();
        }


        public Member select(int id){
            Session session = sessionFactory.openSession();

            Member member = session.get(Member.class, id);

            session.close();

            return member;
        }

        public List<Member> selectAllMembers(){
            Session session = sessionFactory.openSession();

            Query<Member> bookQuery = session.createQuery("FROM Member ", Member.class);
            List<Member> members = bookQuery.list();

            session.close();

            return members;

        }

        public List<Member> selectByName(String name){
            Session session = sessionFactory.openSession();

            Query<Member> query = session.createQuery("FROM Member WHERE name LIKE :name", Member.class);

            query.setParameter("name", "%" + name + "%");
            List<Member> members = query.list();

            session.close();

            return members;

        }

        public void updateName(int id , String name){

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Member member = session.get(Member.class , id);

        member.setName(name);

        tx.commit();
        session.close();


        }

        public void updatePhoneNumber(int id , String phoneNumber){

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Member member = session.get(Member.class , id);

            member.setPhoneNumber(phoneNumber);

            tx.commit();
            session.close();


        }

        public void updateAge(int id , int age){

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Member member = session.get(Member.class , id);

            member.setAge(age);



            tx.commit();
            session.close();


        }
        public void updateLimit(int id , int borrowLimit){

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Member member = session.get(Member.class , id);

            member.setBorrowLimit(borrowLimit);

            tx.commit();
            session.close();


        }

        public void delete(int id){

            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Member member = session.get(Member.class, id);
            session.remove(member);

            tx.commit();
            session.close();

        }





    }


