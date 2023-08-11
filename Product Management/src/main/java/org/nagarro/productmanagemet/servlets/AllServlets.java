package org.nagarro.productmanagemet.servlets;


import org.hibernate.Session;
import org.hibernate.query.Query;

import org.nagarro.productmanagemet.dao.*;
import org.nagarro.productmanagemet.entities.Product;
import org.nagarro.productmanagemet.entities.UserDetails;
import org.nagarro.productmanagemet.hibernate.HibernateSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import static org.nagarro.productmanagemet.constants.Constants.*;

@WebServlet("/")
public class AllServlets extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/openEditForm":
                    openEditForm(request, response);
                    break;
                case "/deleteProduct":
                    deleteProduct(request, response);
                    break;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/loginattempt":
                    login(request, response);
                    break;
                case "/logout":
                    logout(request, response);
                    break;
                case "/addProduct":
                    addProduct(request, response);
                    break;
                case "/editProduct":
                    editProduct(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username =request.getParameter("username");
        String password=request.getParameter("userpassword");

        String hibernate_query="FROM UserDetails";
        Session session = HibernateSession.startHibernateSession();

        Query query = session.createQuery(hibernate_query);
        List<UserDetails> hibernateresult = query.list();
        boolean check=false;
        for (Object user:hibernateresult)
        {
            if(username.equals(((UserDetails)user).getUserName())&&password.equals(((UserDetails)user).getUserPassword())){

                check=true;
                break;
            }
        }
        if (check){

            request.getSession().setAttribute("adminName", username.toUpperCase(Locale.ROOT));
            response.sendRedirect("homepage.jsp");

        }
        else {
            response.sendRedirect("login.jsp");
        }


    }

    private void openEditForm(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int prodId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("id", prodId);
        System.out.println("Opening Product Edit Form");
        response.sendRedirect("editForm.jsp");
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("adminName");
        session.invalidate();
        System.out.println("Logged Out Successfully");
        response.sendRedirect("index.jsp");
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String title = request.getParameter("title").trim();
        String qty = request.getParameter("quantity").trim();
        String size = request.getParameter("size").trim();
        String image = request.getParameter("image").trim();
        String currentImage= imageAddress +request.getParameter("image");


        FileInputStream fileInputStream = new FileInputStream(currentImage);
        byte[] imagesize = new byte[fileInputStream.available()];
        fileInputStream.read(imagesize);
        Product product = new Product(title, qty, size, image);
        if((imagesize.length/ byteUnit)<=1 && (dbImageLimit+(imagesize.length/ byteUnit))<=10){
           dbImageLimit= dbImageLimit+((imagesize.length)/(byteUnit));
            System.out.println("current dpimagelimit => "+ dbImageLimit);
            product.setImage(imagesize);
            ProductDao productDao = new ProductDao();
            productDao.addProduct(product);

            Logger.getLogger(productStatus).info(successMessage);

            response.sendRedirect("homepage.jsp");
        }
        else {

            Logger.getLogger(productStatus).info(invalidSize);

            response.sendRedirect("homepage.jsp");
        }



    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        int id = (int)session.getAttribute("id");
        String title = request.getParameter("title").trim();
        String qty = request.getParameter("quantity").trim();
        String size = request.getParameter("size").trim();
        String image = request.getParameter("image").trim();

        ProductDao dao = new ProductDao();
        dao.editProduct(id,title,qty,size,image);

        session.removeAttribute("id");

        response.sendRedirect("homepage.jsp");
    }



    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int prodId = Integer.parseInt(request.getParameter("id"));
        ProductDao dao = new ProductDao();

        dao.deleteProduct(prodId);

        Logger.getLogger(productStatus).info(deletionMessage);

        response.sendRedirect("homepage.jsp");
    }

}