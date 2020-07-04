<%@page import="java.util.ArrayList"%>
<%@page import="supplement_shop_model.supplement_shop_vedios"%>
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
          	<h3><i class="fa fa-angle-right"></i>My Vedios</h3>
          	<hr>
				<%
					List<supplement_shop_vedios> topics = new ArrayList<supplement_shop_vedios>();	
					topics = (ArrayList<supplement_shop_vedios>)request.getAttribute("topics");
					int count=0;
	
				%>
				<div class="container" align="center">
					<% 	
					if(topics.size()== 0 ){
						out.println("no vedios yet");
						
						
					}else{
						
					%>
					<h4>We have <%out.println(topics.size()); %>vedios of yours!</h4>
					<h4>This vedio list orderd by most viewd vedios</h4>
					<br>
					<br>
					
					<% 			
							for(int i=0;i<topics.size();i++){
								supplement_shop_vedios vedio= new supplement_shop_vedios();
								vedio= topics.get(i);
								count++;
					%>			
							<h4>
								   <pre tab></pre> <%out.println(count); %>.<% out.println(vedio.getDescription()); %> 
							</h4>
							 <form action="supplement_shop_delete_vedio_con"><button type="submit" class="btn btn-danger" name="delete" value="<%out.println(vedio.getVedio_id());%>" >Delete vedio</button></form>
							 <br>	
		              		 <form action = "supplement_shop_view_vedio"><button type="submit" class="btn btn-info" name="view" value="<%out.println(vedio.getVedio_id());%>">View vedio </button></form>
						
					<%
						}
						}
					%>
					</div>
						
						
							
						

				
				
					
				
		</section><! --/wrapper -->
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
