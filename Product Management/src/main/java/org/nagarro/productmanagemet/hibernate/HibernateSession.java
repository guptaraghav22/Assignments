package org.nagarro.productmanagemet.hibernate;

import org.hibernate.Session;

import org.hibernate.cfg.Configuration;

public class HibernateSession {

    public static Session startHibernateSession(){
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
    }
}
