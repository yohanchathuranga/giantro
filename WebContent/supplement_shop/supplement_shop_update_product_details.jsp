<%@page import="supplement_shop_model.supplement_shop_product"%>
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
          	<%
          		supplement_shop_product  product  = new supplement_shop_product();
          		product = (supplement_shop_product)request.getAttribute("product");
          		
          	
          	%>
          	<% if(request.getAttribute("product_add_msg")!= null) out.println(request.getAttribute("product_add_msg")); %>
          	<!-- BASIC FORM ELELEMNTS -->
          	<div class="container">
          	<div class="row mt">
          		<div class="col-lg-12">
                  <div class="form-panel">
                  	  <h1 class="mb">Edit products</h1>
                  	  	<div class="project-wrapper">
		                    <div class="project">   
		                            <div class="photo">
		                            	<a><img class="img-responsive" src="<%out.println(product.getImage_url()); %>" alt="" alt="" height="200" width="200" ></a>
		                            </div>
		                            <div class="overlay"></div>
		                    </div>
		                </div>
                      <form class="form-horizontal style-form" method="get"  action="supplement_shop_update_product_details">
                         
                          
                           <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>price id</h4></label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name ="product_id" value="<%if(product.getProduct_id()!=null)out.println(product.getProduct_id());%> " readonly="true">  
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>produt name</h4></label>
                              <div class="col-sm-10">
                                  <input type="feild" class="form-control" name="product_name" value="<%if(product.getProduct_name()!=null)out.println(product.getProduct_name());%>" required>
                              </div>
                          </div>
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>discount</h4></label>
                              <div class="col-sm-10">
                                  <input type="feild" class="form-control" name="discount" value="<%if(product.getDiscount()!=0)out.println(product.getDiscount());%>" required>
                              </div>
                          </div>
                         <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>price</h4></label>
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" name ="price" value="<%if(product.getPrice()!=0)out.println(product.getPrice());%>" required>
                              </div>
                          </div>
                         
                        
                          <div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label"><h4>description</h4></label>
                              <div class="col-sm-10">
                                  <textarea rows="4" columns="100" class="form-control" name="description" value="" required><%if(product.getDescription()!=null)out.println(product.getDescription());%> </textarea>
                              </div>
                          </div>

                           <input type="submit"  class="btn btn-theme" value="upload">
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
	
	<script type="text/javascript" src="p../Resources/supplement_shop/profile/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="../Resources/supplement_shop/profile/js/form-component.js"></script>    
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>
