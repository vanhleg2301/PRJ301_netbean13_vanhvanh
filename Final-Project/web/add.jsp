<%-- 
    Document   : add
    Created on : Mar 11, 2023, 7:41:43 PM
    Author     : DELL
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New Product</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href=".//CSS/contact.css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap"
              rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <script src="https://cdn.ckeditor.com/ckeditor5/35.2.0/classic/ckeditor.js"></script>
    </head>
    <body style="background:radial-gradient(#fff, #d6edff);">
        <div class="navbarMenu">
            <div class="navbar">
                <div class="logo">
                    <a href="home"><img src="images/logo-white.png" width="125px"></a>
                </div>
                <nav>
                    <ul class="menuItems">
                        <li><a href="home">Home</a></li>
                        <li><a href="product">Products</a></li>
                            <c:if test="${sessionScope.role == null}">
                            <li><a href="contact.jsp">Contact</a></li>
                            </c:if>
                            <c:if test="${sessionScope.account == null}">
                            <li class="active">
                                <a href="login">Login
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li><a href="register">Register</a></li>
                            </c:if>
                            <c:if test="${sessionScope.account != null}">
                            <li class="active">
                                <a href="profile">Profile
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li><a href="logout" style="text-decoration: underline">Logout(${account.userID})</a></li>
                            <li><a href="change">ChangePassword</a></li>
                            </c:if>
                            <c:if test="${sessionScope.role != null}">
                            <li><a href="manager">Manager</a></li>
                            </c:if>
                    </ul>
                </nav>
                <a href="cart.jsp"><img src="images/cart.png" width="30px" height="30px"></a>
            </div>
        </div>
        <h1 style="text-align: center; font-family: poppins">Add New Product</h1>
<!--        <h3>${requestScope.error}</h3>-->
        <form action="add" method="post" style="margin: 50px auto; font-family: poppins">
            Price: <input type="number" name="price" placeholder="$"/></br>
            Name: <input type="text" name="name" placeholder="Product name"/></br>
            Description: <textarea id="editor" name="description" placeholder="describe"></textarea></br>
            Image: <input type="text" name="image" placeholder="images/nameproduct.jpg"/></br>   
            ID: <input type="text" name="cid" placeholder="CateID"/></br>
            ID: <input type="text" name="sid" placeholder="SellID"/></br>
<!--            <h3 style="text-align: center">Category:</h3>  
            <select name="cid" style="width: 130px; margin-left: 160px;">
                <c:forEach items="${requestScope.listC}" var="cate">
                    <option value="${cate.cid}">${cate.cname}</option>
                </c:forEach>
            </select>-->
            <input type="submit" value="Add" style="width: 100px; border-radius: 20px; margin-left: 175px; background: rgba(234, 80, 43, 0.85);">
        </form>
        <script>
            ClassicEditor.create(document.querySelector("#editor"))
                    .catch(error => {
                        console.error(error)
                    });
        </script>
    </body>
</html>
