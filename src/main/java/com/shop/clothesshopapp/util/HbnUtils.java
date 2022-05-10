//package com.shop.clothesshopapp.util;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//public class HbnUtils {
//
//    private static SessionFactory sessionFactory;
//
//    public static Session getSession(){
//        //create sessionFactory every time if
//        return getSessionFactory().getCurrentSession();
//    }
//
//    private static SessionFactory getSessionFactory() {
//        if(sessionFactory == null || sessionFactory.isClosed()){
//             sessionFactory = new Configuration().configure().buildSessionFactory();
//        }
//        return sessionFactory;
//    }
//}
