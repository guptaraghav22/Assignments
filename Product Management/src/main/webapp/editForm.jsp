<%--
  Created by IntelliJ IDEA.
  User: shubhamwadhwa
  Date: 01-09-2022
  Time: 02:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="container">
  <div class="row mb-3">
    <label class="col-sm-2 col-form-label"><h2>Edit</h2></label>
  </div>

  <form action = "editProduct" method="post">

    <div class="row mb-3">
      <label for="productTitle" class="col-sm-2 col-form-label">Title</label>
      <div class="col-sm-6">
        <input  type="text" name="title"  class="form-control" id="productTitle" required>
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
        <input type="file" name="image" class="form-control" id="productImage" required>
      </div>
    </div>

    <button type="submit" class="btn btn-primary">Edit Product</button>
  </form>

</div>
</body>
</html>
