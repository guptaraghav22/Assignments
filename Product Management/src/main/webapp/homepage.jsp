<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.nagarro.productmanagemet.entities.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.Base64" %>
<%@ page import="javax.sql.rowset.serial.SerialBlob" %>
<%@ page import="org.nagarro.productmanagemet.constants.Constants" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">
</head>
<style>
    .table{
        mso-cellspacing: 3px;
        width: 100%;
    }
</style>
<body>
<div class="container">
    <div class="row align-items-start">
        <div class="col-md-10">
            <h2>Product Management Tool</h2>
        </div>

        <div class="col-md-2">
            <b><%= "Hi  "+ session.getAttribute("adminName") %></b>
            <form action = "logout" method="post">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </div>
    </div>

    <div class="row"><h5>Please enter product details to add to stock</h5>
    </div>

    <div class="row mb-8">
        <form action = "addProduct" method="post" >
            <div class="row mb-3">
                <label for="productTitle" class="col-sm-2 col-form-label">Title</label>
                <div class="col-sm-6">
                    <input type="text" name="title" class="form-control" id="productTitle" required>
                </div>
            </div>

            <div class="row mb-3">
                <label for="productQuantity" class="col-sm-2 col-form-label">Quantity</label>
                <div class="col-sm-6">
                    <input type="text" name="quantity" class="form-control" id="productQuantity" required>
                </div>
            </div>

            <div class="row mb-3">
                <label for="productSize" class="col-sm-2 col-form-label">Size</label>
                <div class="col-sm-6">
                    <input type="text" name="size" class="form-control" id="productSize" required>
                </div>
            </div>

            <div class="row mb-3">
                <label for="productImage" class="col-sm-2 col-form-label">Image</label>
                <div class="col-sm-6">
                    <input type="file" name="image" class="form-control" id="productImage" >
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Add Product</button>
        </form>
    </div>

    <div class="row mt-8">
        <table class="table table-bordered mt-4" cellpadding="3" width=100%>
            <tr>
                <th>S. No.</th>
                <th>Title</th>
                <th>Quantity</th>
                <th>Size</th>
                <th>Image</th>
                <th>Actions</th>

            </tr>

            <%
                SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                        addAnnotatedClass(Product.class).buildSessionFactory();
                Session session2 = factory.openSession();
                session2.beginTransaction();
                List<Product> productList = session2.createQuery("from Product").getResultList();
                session2.getTransaction().commit();
                session2.close();
                factory.close();
                for(Product product : productList){
                    Blob blob = new SerialBlob(product.getImage());
                    InputStream inputStream =blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead=-1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }

                    byte[] imageBytes = outputStream.toByteArray();
                    product.setProductImage( Base64.getEncoder().encodeToString(imageBytes));

                    %>
            <tr>
                <td> <%= product.getProductId() %> </td>
                <td> <%= product.getProductTitle() %> </td>
                <td> <%= product.getProductQuantity() %> </td>
                <td> <%= product.getProductSize() %> </td>
                <td> <img src="data:image/jpg;base64,${product.getProductImage()}" width="24" height="30"></td>

                <td>
                    <a href="openEditForm?id=<%= product.getProductId() %>">Edit</a>
                    <a href="deleteProduct?id=<%= product.getProductId() %>">Delete</a>
                </td>


            </tr>



            <%
                }
            %>
            <tr>
                <td> TOTAL CURRENT DB LIMIT = <%= Constants.dbImageLimit %> MB</td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
