<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="supplement_shop_model.get_connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Giantro</title>

    <!-- Bootstrap core CSS -->
    <link href="../Resources/supplement_shop/profile/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="../Resources/supplement_shop/profile/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../Resources/supplement_shop/profile/js/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="../Resources/supplement_shop/profile/js/bootstrap-daterangepicker/daterangepicker.css" />
        
    <!-- Custom styles for this template -->
    <link href="../Resources/supplement_shop/profile/css/style.css" rel="stylesheet">
    <link href="../Resources/supplement_shop/profile/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  <% HttpSession newsession = request.getSession();
		    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//http 1.1
			response.setHeader("Pragma", "no-cache");//http 1.0
			response.setHeader("Expires","0");// proxies
			
			if(session.getAttribute("company_id")==null){
				response.sendRedirect("supplement_shop_login.jsp");
			}
  		
  %>
  

  <section id="container" >
      <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
      <!--header start-->
      <header class="header black-bg">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="supplement_shop_dashboard_con" class="logo"><b>Giantro</b></a>
            <!--logo end-->
           
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="supplement_shop_logout">Logout</a></li>
            	</ul>
            </div>
        </header>
      <!--header end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
      <!--sidebar start-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="supplement_shop_dashboard_con"><img src="../<%out.println(newsession.getAttribute("company_logo")); %>" class="img-circle" width="60"></a></p>
              	  <h5 class="centered"><%out.println( newsession.getAttribute("username")); %></h5>
              	  	
                  <li class="mt">
                      <a class="active" href="supplement_shop_dashboard_con">
                          <i class="fa fa-dashboard"></i>
                          <span>Dashboard</span>
                      </a>
                  </li>

                  <li class="sub-menu">
                          <a  href="add_supplement_product.jsp"><span>add new product</span></a>     
                  </li>
                   <li class="sub-menu">
                           <a  href="supplement_shop_load_products"><span>view products</span></a>
                  </li>
                 
                  <li class="sub-menu">
                     
                          <a  href="add_supplement_vedios.jsp"><span>Add new videos</span></a>
                  </li>
                  
                  <li class="sub-menu">
                      <a  href="supplement_shop_vedio_load_topics"><span>manage videos</span></a>
                  </li>
                  <li class="sub-menu">
                      <a href="supplement_shop_profile_details_load_con" >
                          <i class=""></i>
                          <span>Edit profile</span>
                      </a>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=""></i>
                          <span>Others</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="">View QA forms</a></li>
                          <li><a  href="">coming soon</a></li>
                      </ul>
                  </li>
                  <li class="sub-menu">
                      <a href="javascript:;" >
                          <i class=""></i>
                          <span>Charts</span>
                      </a>
                      <ul class="sub">
                          <li><a  href="">Morris</a></li>
                          <li><a  href="">Chartjs</a></li>
                      </ul>
                  </li>

              </ul>
              <!-- sidebar menu end-->
          </div>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      
      <section id="main-content">
          <section class="wrapper">
          	
          	
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="container">
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h1 class="mb">Edit profile</h1>
                  	  <form action="supplement_shop_upload_logo.jsp"><button type="submit" class="btn btn-danger" name="delete" value="" >update logo</button></form>
                  	  <br>
                      <form class="form-horizontal style-form" method="get"  action="supplement_shop_edit_profile_update_con">
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>Company name</h4></label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" value="<% if(request.getAttribute("company_name")!=null)out.println(request.getAttribute("company_name"));%>" name="company_name" required>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>Company id</h4></label>
                              <div class="col-sm-10">
                                 <input type="text" class="form-control" value="<% if(request.getAttribute("company_id")!=null)out.println(request.getAttribute("company_id"));%>" name="company_id" disabled>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>Company owner name</h4></label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" value="<% if(request.getAttribute("owner_name")!=null)out.println(request.getAttribute("owner_name"));%>" name ="owner_name" required>
                              </div>
                          </div>
                          
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>Owner NIC no</h4></label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" value="<% if(request.getAttribute("nic")!=null)out.println(request.getAttribute("nic"));%>" name="owner_id" required>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>Phone no</h4></label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" value="<% if(request.getAttribute("phone")!=null)out.println(request.getAttribute("phone"));%>" name ="phone" required>
                              </div>
                          </div>
                        
                         
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>Password</h4></label>
                              <div class="col-sm-10">
                                  <input  type="password" class="form-control" placeholder=""value="<% if(request.getAttribute("passowrd")!=null)out.println(request.getAttribute("passowrd"));%>" name ="password" >
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-lg-2 col-sm-2 control-label"><h4>Email</h4></label>
                              <div class="col-lg-10">
                                  <p class="form-control-static"><% if(request.getAttribute("email")!=null)out.println(request.getAttribute("email"));%></p>
                              </div>
                          </div>
                          <input type="hidden" name ="form" value="fuck" >
                           <input type="submit"  class="btn btn-theme" value="update">
                      </form>
                  </div>
          		</div><!-- col-lg-12-->      	
          	</div>
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->
      

      <!--main content end-->
     
      
  </section>
  

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../Resources/supplement_shop/profile/js/jquery.js"></script>
    <script src="../Resources/supplement_shop/profile/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../Resources/supplement_shop/profile/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery.scrollTo.min.js"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="../Resources/supplement_shop/profile/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="../Resources/supplement_shop/profile/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="../Resources/supplement_shop/profile/js/bootstrap-switch.js"></script>
	
	<!--custom tagsinput-->
	<script src="../Resources/supplement_shop/profile/js/jquery.tagsinput.js"></script>
	
	<!--custom checkbox & radio-->
	
	<script type="text/javascript" src="../Resources/supplement_shop/profile/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="../Resources/supplement_shop/profile/js/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="../Resources/supplement_shop/profile/js/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<script type="text/javascript" src="../Resources/supplement_shop/profile/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="../Resources/supplement_shop/profile/js/form-component.js"></script>    
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>
