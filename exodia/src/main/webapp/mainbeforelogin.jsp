<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Main Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    
    
    <!-- Bootstrap styles -->
     <link href="img/bootstrap.css" rel="stylesheet"/> 

     <link href="img/style.css" rel="stylesheet"/> 
    
    
    <!-- font awesome styles -->
    <!-- <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">-->
    
        
		<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	<!-- Favicons -->
    <link rel="shortcut icon" href="img/favicon.ico">
  </head>
<body>


<!--
Lower Header Section
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.html">
            <img src=" img/exodia-cursive.png" alt="exodia logo">
	</a>
	</h1>
	</div>
	<div class="span4">
	<div class="offerNoteWrapper">
	
	</div>
	</div>
	<div class="span4 alignR">
	<p><br> <strong>          </strong><br><br></p>
	<span class="btn btn-mini">[ 0 ] <span class="icon-shopping-cart"></span></span>


	</div>
</div>
</header>
<!--
Navigation Bar Section
-->
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
			  <li class="active"><a href="grid-view.html">Home	</a></li>


			</ul>
			<form action="#" class="navbar-search pull-left">
			  <input type="text" placeholder="Search" class="search-query span2">
			</form>
			<ul class="nav pull-right">
			<li class="dropdown">
				<button  class="log">Sign in</button>
				<div class="dropdown-menu">
				<form class="form-horizontal loginFrm">
				  <div class="control-group">
					<input type="text" class="span2" id="inputEmail" placeholder="Email">
				  </div>
				  <div class="control-group">
					<input type="password" class="span2" id="inputPassword" placeholder="Password">
				  </div>
				  <div class="control-group">
					<label class="checkbox">
					<input type="checkbox"> Remember me
					</label>
					<button type="submit" class="shopBtn btn-block" onclick ="login.jsp">Sign in</button>
				  </div>
				</form>
				</div>
			</li>
                        
                        <button  class="log">Sign up</button>
			</ul>
		  </div>
		</div>
	  </div>
	</div>
<!--
Body Section
-->
	<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
		<li><a href="products.html"><span class="icon-chevron-right"></span>Women</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Men</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Bags & Shoes</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Clothes</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Cosmetic</a></li>
		<li><a href="products.html"><span class="icon-chevron-right"></span>Electronics</a></li>

		<li style="border:0"> &nbsp;</li>
	</ul>
</div>
	</div>
	<div class="span9">

	<div class="well well-small">
	<h3>Products </h3>
		<div class="row-fluid">
		  <ul class="thumbnails">
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.jsp" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/etek.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Broadway Skirt</p>
					<p><strong> $100.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/kadin-gomlek.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Broadway Jeans</p>
					<p><strong> $200.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/giyim-erkek.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Broadway Shirt</p>
					<p><strong> $250.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
		  </ul>
		</div>
	<div class="row-fluid">
		  <ul class="thumbnails">
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/parfumkadın.jpeg" alt=""></a>
				<div class="caption cntr">
					<p>Shiseido Ever Bloom Perfume</p>
					<p><strong> $500.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/parfumerkek.jpeg" alt=""></a>
				<div class="caption cntr">
					<p>Tom Ford Ombre Leather Perfume</p>
					<p><strong> $800.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/kozmetik-kadın.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Shiseido Lipstick</p>
					<p><strong> $750.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
		  </ul>
		</div>
	<div class="row-fluid">
		  <ul class="thumbnails">
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/TV.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Electronic</p>
					<p><strong> $5125.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/cellphone.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Electronic</p>
					<p><strong> $215.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/kulaklık.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Electronic</p>
					<p><strong> $520.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
		  </ul>
		</div>
	<div class="row-fluid">
		  <ul class="thumbnails">
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/ayakkabıerkek.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Shoes</p>
					<p><strong> $300.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/ayakkabıkadın.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Shoes</p>
					<p><strong> $450.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/ayakkabıspor.jpg" alt=""></a>
				<div class="caption cntr">
					<p>Shoes</p>
					<p><strong> $320.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
		  </ul>
		</div>

	</div>
	</div>
	</div>

</div><!-- /container -->
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="assets/js/shop.js"></script>
  </body>
</html>
