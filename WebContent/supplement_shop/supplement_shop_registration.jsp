<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
 <%@ page import="supplement_shop_model.*" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Giantro</title>

    <!-- Icons font CSS-->
    <link href="../Resources/supplement_shop/registration/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="../Resources/supplement_shop/registration/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="../Resources/supplement_shop/registration/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="../Resources/supplement_shop/registration/vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="../Resources/supplement_shop/registration/css/main.css" rel="stylesheet" media="all">
</head>

<body>

    <div class="page-wrapper ">
        <div class="wrapper wrapper--w790">
            <div class="card card-5">
                <div class="card-heading">
                    <h2 class="title">Supplement Shop Registration</h2>
                </div>
                <%if(request.getAttribute("error_msg_reg")!=null)out.println(request.getAttribute("error_msg_reg"));%>
                <div class="card-body">
                    <form   method="post" action="supplement_shop_registration_con">
                        <div class="form-row m-b-55">
                            <div class="name" required >Company Name</div>
                            <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" type="text" name="company_name" value="<%if(request.getAttribute("company_name")!=null)out.println(request.getAttribute("company_name"));%>" required>
					    <label class="label--desc">Use this when loging to the site</label>
                                        </div>
                            </div>
                        </div>
						<div class="form-row">
                            <div class="name" required>Password</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="password" name="password1" pattern=".{8,12}" required  title="8 characters minimum"
                                     value= "">
				   
                                </div>
                            </div>
                        </div>
						<div class="form-row">
                            <div class="name" required>Re-type password</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="password" name="password2"required title="8 characters minimum">
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Owner Name</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="owner_name"  value="<%if(request.getAttribute("name")!=null)out.println(request.getAttribute("name"));%>" required >
                                </div>
                            </div>
                        </div>
		        		<div class="form-row">
                            <div class="name">Owner NIC </div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="text" name="nic" value="<%if(request.getAttribute("nic")!=null)out.println(request.getAttribute("nic"));%>" required >
                                    
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">Email</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-5" type="email" name="email" value="<%if(request.getAttribute("email")!=null)out.println(request.getAttribute("email"));%>" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-b-55">
                            <div class="name">Phone number</div>
                            <div class="value">
                                        <div class="input-group">
                                            <input class="input--style-5" type="text" name="phone"pattern="[0-9]{10}" value="<%if(request.getAttribute("phone")!=null)out.println(request.getAttribute("phone"));%>" required>
                                            <span>Format: eg:0788231909</span>
                                            
                                        </div>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="../Resources/supplement_shop/registration/vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="../Resources/supplement_shop/registration/vendor/select2/select2.min.js"></script>
    <script src="../Resources/supplement_shop/registration/vendor/datepicker/moment.min.js"></script>
    <script src="../Resources/supplement_shop/registration/vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="../Resources/supplement_shop/registration/js/global.js"></script>
    

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->