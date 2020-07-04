<%@page import="java.util.ArrayList"%>
<%@page import="supplement_shop_model.supplement_shop_product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="../Resources/supplement_shop/profile/js/fancybox/jquery.fancybox.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="../Resources/supplement_shop/profile/css/style.css" rel="stylesheet">
    <link href="../Resources/supplement_shop/profile/css/style-responsive.css" rel="stylesheet">

    <script src="../Resources/supplement_shop/profile/js/jquery.js"></script>


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
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i> products</h3>
          	<hr>
          	<%
          		List<supplement_shop_product> products= new ArrayList<>();
          		products = (ArrayList<supplement_shop_product>)request.getAttribute("product_list");
          		
          		
          	%>
          	<% 
				if(products.size()==0){ 
				
					out.println("no products added yet!");
				}
				else{          	
		          		for (int i=0;i<products.size();i=i+3){ 
		          		
		          		
		          		supplement_shop_product product1= new supplement_shop_product();
		          		supplement_shop_product product2= new supplement_shop_product();
		          		supplement_shop_product product3= new supplement_shop_product();
		          		try{
			          		product1= products.get(i);
			          		product2= products.get(i+1);
			          		product3= products.get(i+2);
		          		}catch(Exception e){
		          			
		          		}
          	
          		%>
				<div class="row mt">
				
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
						<div class="product-panel-2 pn">
						<div class="project-wrapper">
		                    <div class="project">
		                        
		                            <div class="photo">
		                            	<a><img  class="img-responsive" src="../<%out.println(product1.getImage_url()); %>" alt="" alt="" height="120" width="120" ></a>
		                            </div>
		                            <div class="overlay"></div>
		                    </div>
		                </div>
				                <h4><strong>Name: <%out.println( product1.getProduct_name()); %></strong></h4>
				                <h4>price: Rs <%out.println(product1.getPrice());%>/=</h4>
				                <h4>Discount: <%out.println(product1.getDiscount());%></h4>
				                <h4><strong>selling price:Rs. <%out.println((float)product1.getSelling_price());%>/=</strong></h4>
				                <form action="supplement_shop_delete_product_con"><button type="submit" class="btn btn-danger" name="delete" value="<%out.println(product1.getProduct_id());%>" >Delete product</button></form>	
				                <form action = "supplement_shop_load_product_details_con"><button type="submit" class="btn btn-info" name="edit" value="<%out.println(product1.getProduct_id());%>">Edit product details</button></form>
						</div>
					</div><!-- col-lg-4 -->
					
						
					<%if(product2.getImage_url()==null) continue;%>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
					<div class="product-panel-2 pn">
						<div class="project-wrapper">
		                    <div class="project">
		                        
		                            <div class="photo">
		                            	<a><img class="img-responsive" src="../<%out.println(product2.getImage_url()); %>" alt="" height="120" width="120"></a>
		                            </div>
		                            <div class="overlay"></div>
		                       
		                    </div>
		                </div>
		                <h4><strong>Name: <%out.println( product2.getProduct_name()); %></strong></h4>
		                <h4>price: Rs <%out.println(product2.getPrice());%>/=</h4>
		                <h4>Discount: <%out.println(product2.getDiscount());%></h4>
		                <h4><strong>selling price:Rs. <%out.println((float)product2.getSelling_price());%>/=</strong></h4>
		                <form action="supplement_shop_delete_product_con"><button type="submit" class="btn btn-danger" name="delete" value="<%out.println(product2.getProduct_id());%>" >Delete product</button></form>	
		                <form action = "supplement_shop_load_product_details_con"><button type="submit" class="btn btn-info" name="edit" value="<%out.println(product2.getProduct_id());%>">Edit product details</button></form>
						</div>
					</div><!-- col-lg-4 -->
					
					<%if(product3.getImage_url()==null)continue; %>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
						<div class="product-panel-2 pn">
						<div class="project-wrapper">
		                    <div class="project">
		                        
		                            <div class="photo">
		                            	<a ><img class="img-responsive" src="../<%out.println(product3.getImage_url()); %>" alt="" alt="" height="120" width="120"></a>
		                            </div>
		                             
		                            <div class="overlay"></div>
		                       
		                    </div>
		                </div>
		                <h4><strong>Name: <%out.println( product3.getProduct_name()); %></strong></h4>
		                <h4>price: Rs <%out.println(product3.getPrice());%>/=</h4>
		                <h4>Discount: <%out.println(product3.getDiscount());%></h4>
		                <h4><strong>selling price:Rs. <%out.println((float)product3.getSelling_price());%>/=</strong></h4>
		                <form action="supplement_shop_delete_product_con"><button type="submit" class="btn btn-danger" name="delete" value="<%out.println(product3.getProduct_id());%>" >Delete product</button></form>	
		                <form action = "supplement_shop_load_product_details_con"><button type="submit" class="btn btn-info" name="edit" value="<%out.println(product3.getProduct_id());%>">Edit product details</button></form>
					</div><!-- col-lg-4 -->
				
					<br>
					<br>
					<br>
					<br>
					</div>
					</div><!-- /row -->
			    	
				<% }} %> 			
				
		</section><!--/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      
  </section> 

    <!-- js placed at the end of the document so the pages load faster -->
	<script src="../Resources/supplement_shop/profile/js/fancybox/jquery.fancybox.js"></script>    
    <script src="../Resources/supplement_shop/profile/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../Resources/supplement_shop/profile/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery.scrollTo.min.js"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="../Resources/supplement_shop/profile/js/common-scripts.js"></script>

    <!--script for this page-->
  
  <script type="text/javascript">
      $(function() {
        //    fancybox
          jQuery(".fancybox").fancybox();
      });

  </script>
  
  <script>
      //custom select box

      $(function(){
          $("select.styled").customSelect();
      });

  </script>

  </body>
</html>
