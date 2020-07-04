
<%@page import="supplement_shop_model.supplement_shop_vedios"%>
<%@page import="supplement_shop_model.supplement_shop_product"%>
<%@page import="supplement_shop_model.supplement_shop_viewd_count"%>
<%@page import="java.io.PrintWriter"%>
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
    <link href="Resources/supplement_shop/profile/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../Resources/supplement_shop/profile/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="../Resources/supplement_shop/profile/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="../Resources/supplement_shop/profile/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="../Resources/supplement_shop/profile/css/style.css" rel="stylesheet">
    <link href="../Resources/supplement_shop/profile/css/style-responsive.css" rel="stylesheet">

    <script src="../Resources/supplement_shop/profile/js/chart-master/Chart.js"></script>
    
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
		
		if(newsession.getAttribute("company_id")==null){
			response.sendRedirect("supplement_shop_login.jsp");
		}
		supplement_shop_viewd_count count_as_month = new supplement_shop_viewd_count();
		supplement_shop_product mostviewdproduct = new supplement_shop_product();
		supplement_shop_vedios mostviewdvedio = new supplement_shop_vedios();
		String rank=null;
		try{
  			
			count_as_month = (supplement_shop_viewd_count)request.getAttribute("viewd_count_for_each_month");
			mostviewdproduct = (supplement_shop_product)request.getAttribute("mostviewdproduct");
			mostviewdvedio = (supplement_shop_vedios)request.getAttribute("mostviewdvedio");
			rank = (String)request.getAttribute("rank");
			
		}catch(Exception e){
			
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
          <section class="wrapper">
          <% if(newsession.getAttribute("company_logo")==null){ %><h5>company logo still not uploaded! company logo helpts to indentify your shop </h5><a href="supplement_shop_upload_logo.jsp">update logo</a><% } %>
          

              <div class="row">
                  <div class="col-lg-9 main-chart">
                  
                  	
                      <div class="row">
                      <!-- SERVER STATUS PANELS -->
                      	<div class="col-md-4 col-sm-4 mb">
                      		<div class="white-panel pn">
                      			<div class="white-header">
						  			<h5>TOP PRODUCT</h5>
                      			</div>
								<div class="row">
									<div class="col-sm-6 col-xs-6 goleft">
										<p> <%out.println(mostviewdproduct.getViewd_count()); %> views</p>
									</div>
									<div class="col-sm-6 col-xs-6"></div>
	                      		</div>
	                      		<div class="centered">
										<img src="../<%out.println(mostviewdproduct.getImage_url()); %>" width="200" height="150">
	                      		</div>
                      		</div>
                      	</div><!-- /col-md-4 -->
                      	

                      	<div class="col-md-4 col-sm-4 mb">
                      		<div class="white-panel pn">
                      			<div class="white-header">
						  			<h5>MOST VIEWD VIDEO</h5>
                      			</div>
								<div class="row">
									<div class="col-sm-6 col-xs-6 goleft">
										<p><%out.println(mostviewdvedio.getViewd_count()); %> views</p>
									</div>
									<div class="col-sm-6 col-xs-6"></div>
	                      		</div>
	                      		<div class="centered">
									<h4><b>topic <font color="red"><%out.println(mostviewdvedio.getDescription()); %></font> is the most viewd vedio on you shop!</b></h4>
										<br>
										<form action = "supplement_shop_view_vedio"><button type="submit" class="btn btn-info" name="view" value="<%out.println(mostviewdvedio.getVedio_id());%>">View vedio </button></form>
										
	                      		</div>
                      		</div>
                      	</div><!-- /col-md-4 -->
                      	
						<div class="col-md-4 mb">
							<!-- WHITE PANEL - TOP USER -->
							<div class="white-panel pn" align="center">
								<div class="white-header">
									<h4>Shop Rank</h4>
								</div>
								<div class="row">	
										<h1><font color="green"> <%if(rank!=null)out.println(rank);else out.println("no rank"); %></font></h1>
									
								</div>
								
										<br>
										<h4>rank is based on your total views</h4>
							</div>
						</div><!-- /col-md-4 -->
                      	

                    </div><!-- /row -->
                    
                    
					
					
					<div class="row mt">
                      <!--CUSTOM CHART START -->
                      <div class="border-head">
                          <h3>Visits for your shop</h3>
                      </div>
                      <div class="custom-bar-chart">
                          <ul class="y-axis">
                              
                          </ul>
                          <div class="bar">
                              <div class="title">JAN-FEB</div>
                              <div class="value tooltips" data-original-title="<% out.println(count_as_month.jan_feb*10);%>" data-toggle="tooltip" data-placement="top"><%out.println( count_as_month.jan_feb*5); %></div>
                          </div>
                          <div class="bar ">
                              <div class="title">MAR_APR</div>
                              <div class="value tooltips" data-original-title="<%out.println(count_as_month.mar_apr*10); %>" data-toggle="tooltip" data-placement="top"><%out.println(count_as_month.mar_apr*5); %></div>
                          </div>
                          <div class="bar ">
                              <div class="title">MAY-JUN</div>
                              <div class="value tooltips" data-original-title="<%out.println(count_as_month.may_june*10); %>" data-toggle="tooltip" data-placement="top"><%out.println(count_as_month.may_june*5); %></div>
                          </div>
                          <div class="bar ">
                              <div class="title">JULY-AGU</div>
                              <div class="value tooltips" data-original-title="<%out.println(count_as_month.july_agu*10); %>" data-toggle="tooltip" data-placement="top"><%out.println(count_as_month.july_agu*5);%></div>
                          </div>
                          <div class="bar">
                              <div class="title">SEP-OCT</div>
                              <div class="value tooltips" data-original-title="<%out.println(count_as_month.sep_oct*10); %>" data-toggle="tooltip" data-placement="top"><%out.println(count_as_month.sep_oct*5); %></div>
                          </div>
                          <div class="bar ">
                              <div class="title">NOV-DEC</div>
                              <div class="value tooltips" data-original-title="<%out.println(count_as_month.nov_dec*10); %>" data-toggle="tooltip" data-placement="top"><%out.println(count_as_month.nov_dec*5);%></div>
                          </div>
                          
                      </div>
                      <!--custom chart end-->
					</div><!-- /row -->	
					
                  </div><!-- /col-lg-9 END SECTION MIDDLE -->
                  
                  
      <!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->                  
                  
                  <div class="col-lg-3 ds">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
						<h3>NOTIFICATIONS</h3>
                                        
                      <!-- First Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>2 Minutes Ago</muted><br/>
                      		   <a href="#">James Brown</a> subscribed to your newsletter.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Second Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>3 Hours Ago</muted><br/>
                      		   <a href="#">Diana Kennedy</a> purchased a year subscription.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Third Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>7 Hours Ago</muted><br/>
                      		   <a href="#">Brandon Page</a> purchased a year subscription.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Fourth Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>11 Hours Ago</muted><br/>
                      		   <a href="#">Mark Twain</a> commented your post.<br/>
                      		</p>
                      	</div>
                      </div>
                      <!-- Fifth Action -->
                      <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>18 Hours Ago</muted><br/>
                      		   <a href="#">Daniel Pratt</a> purchased a wallet in your store.<br/>
                      		</p>
                      	</div>
                      </div>
                       <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>18 Hours Ago</muted><br/>
                      		   <a href="#">Daniel Pratt</a> purchased a wallet in your store.<br/>
                      		</p>
                      	</div>
                      </div>
                       <div class="desc">
                      	<div class="thumb">
                      		<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                      	</div>
                      	<div class="details">
                      		<p><muted>18 Hours Ago</muted><br/>
                      		   <a href="#">Daniel Pratt</a> purchased a wallet in your store.<br/>
                      		</p>
                      	</div>
                      </div>

                       
                        
                      
                  </div><!-- /col-lg-3 -->
              </div> <!--/row -->
          </section>
      </section>

      <!--main content end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../Resources/supplement_shop/profile/js/jquery.js"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery-1.8.3.min.js"></script>
    <script src="../Resources/supplement_shop/profile/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../Resources/supplement_shop/profile/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery.scrollTo.min.js"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="../Resources/supplement_shop/profile/js/jquery.sparkline.js"></script>


    <!--common script for all pages-->
    <script src="../Resources/supplement_shop/profile/js/common-scripts.js"></script>
    
    <script type="text/javascript" src="../Resources/supplement_shop/profile/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="../Resources/supplement_shop/profile/js/gritter-conf.js"></script>

    <!--script for this page-->
    <script src="../Resources/supplement_shop/profile/js/sparkline-chart.js"></script>    
	<script src="../Resources/supplement_shop/profile/js/zabuto_calendar.js"></script>	
	
	
	
	
  

  </body>
</html>
