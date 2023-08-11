package com.nagarro.training.advance.java1.Tshirt.search.and.sort;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.nagarro.training.advance.java1.Tshirt.Product;


public class PriceOutput {

    public static void getPriceOutput(String[] inputarr) {

        Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Query<Product> query = session
                .createQuery("from Product where colour=:c and genderRecommendation=:g and size=:s order by price", Product.class);
        query.setParameter("c", inputarr[0]);
        query.setParameter("s", inputarr[1]);
        query.setParameter("g", inputarr[2]);
        List<Product> ls = query.list();
        if (ls.isEmpty()) {
            System.out.println("\n");
            System.out.println("!!------NO T-Shirt Found------!!");
        } else {

            System.out.println("\n");
            System.out.println("-----Here are the Top results!-----");
            for (Product t : ls) {
                System.out.println(t.toString());
            }
        }

    }

}
