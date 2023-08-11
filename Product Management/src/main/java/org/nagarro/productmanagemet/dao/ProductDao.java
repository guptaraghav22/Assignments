package org.nagarro.productmanagemet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.nagarro.productmanagemet.constants.Constants;
import org.nagarro.productmanagemet.entities.Product;

public class ProductDao {
    private final SessionFactory factory;
    private final Session session;

    public ProductDao() {
        this.factory = new Configuration().configure().
                addAnnotatedClass(Product.class).buildSessionFactory();
        this.session = factory.openSession();
    }

    public void addProduct(Product product) {
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public void deleteProduct(int id) {
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        Constants.dbImageLimit-=(product.getImage().length)/Constants.byteUnit;
        session.delete(product);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public void editProduct(int id, String title, String qty, String size, String image) {
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        product.setProductTitle(title);
        product.setProductQuantity(qty);
        product.setProductSize(size);
        product.setProductImage(image);
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

}
