<%-- 
    Document   : mainafterlogin
    Created on : Apr 16, 2019, 11:16:35 PM
    Author     : Enes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Twitter Bootstrap shopping cart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->

    <style>
        html {
  height:100%;
}

body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
  background: rgb(121,255,240);
  background: -moz-linear-gradient(128deg, rgba(121,255,240,1) 0%, rgba(143,203,246,1) 50%, rgba(172,130,255,1) 100%);
  background: -webkit-linear-gradient(128deg, rgba(121,255,240,1) 0%, rgba(143,203,246,1) 50%, rgba(172,130,255,1) 100%);
  background: linear-gradient(128deg, rgba(121,255,240,1) 0%, rgba(143,203,246,1) 50%, rgba(172,130,255,1) 100%);
  filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#79fff0",endColorstr="#ac82ff",GradientType=1);
}
    </style>
  </head>
<body>
<!--
	Upper Header Section
-->

<!--
Lower Header Section
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span>
		<img src="assets/img/exodia-cursive.png" alt="exodia shop">
	</a>
	</h1>
	</div>
            <div class="span4">
                <div class="offerNoteWrapper">
                    <h1 class="dotmark">
                    <i class="icon-cut"></i>
                    Twitter Bootstrap shopping cart HTML template is available @ $14
                    </h1>
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
<div class="navbar" style="background-color:rgba(0, 0, 0, 0.0);">
	  <div class="navbar-inner" style="background-color:rgba(0, 0, 0, 0.0);">
		<div style="background-color:rgba(0, 0, 0, 0.5);">
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
				<a data-toggle="dropdown" class="dropdown-toggle" href="#"> Login </a>
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
					<button type="submit" class="shopBtn btn-block">Sign in</button>
				  </div>
				</form>
				</div>
			</li>
			</ul>
		  </div>
		</div>
	  </div>
	</div>
<!--
Body Section
-->
	<div class="row" style="background-color:rgba(0, 0, 0, 0.0);">
<div id="sidebar" style="background-color:rgba(0, 0, 0, 0.0);" class="span3">
<div class="well well-small" style="background-color:rgba(0, 0, 0, 0.0);">
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

<!-------------------------------------------------------------------------------------
New Products
-->

	<div class="well well-small" style="background-color:rgba(0, 0, 0, 0.0);">
	<h3>Products </h3>
		<div class="row-fluid" style="background-color:rgba(0, 0, 0, 0.0);">
		  <ul class="thumbnails" style="background-color:rgba(0, 0, 0, 0.0);" >
			<li class="span4" style="background-color:rgba(0, 0, 0, 0.0);">
			  <div class="thumbnail" style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/etek.jpg" alt=""></a>
				<div class="caption cntr"style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Broadway Skirt</p>
					<p><strong> $100.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail"style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/kadin-gomlek.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Broadway Jeans</p>
					<p><strong> $200.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail" style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/giyim-erkek.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Broadway Shirt</p>
					<p><strong> $250.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
		  </ul>
		</div>
	<div class="row-fluid"style="background-color:rgba(0, 0, 0, 0.0);">
		  <ul class="thumbnails" style="background-color:rgba(0, 0, 0, 0.0);">
			<li class="span4" style="background-color:rgba(0, 0, 0, 0.0);">
			  <div class="thumbnail"style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/parfumkadın.jpeg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Shiseido Ever Bloom Perfume</p>
					<p><strong> $500.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail"style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/parfumerkek.jpeg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Tom Ford Ombre Leather Perfume</p>
					<p><strong> $800.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail" style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/kozmetik-kadın.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
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
			  <div class="thumbnail"style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/TV.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Electronic</p>
					<p><strong> $5125.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail"style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/cellphone.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Electronic</p>
					<p><strong> $215.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail" style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/kulaklık.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
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
		  <ul class="thumbnails" style="background-color:rgba(0, 0, 0, 0.0);">
			<li class="span4">
			  <div class="thumbnail" style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/ayakkabıerkek.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Shoes</p>
					<p><strong> $300.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail" style="background-color:rgba(0, 0, 0, 0.0);" >
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/ayakkabıkadın.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
					<p>Shoes</p>
					<p><strong> $450.00</strong></p>
					<h4><a class="shopBtn" href="#" title="add to cart"> Add to cart </a></h4>

					<br class="clr">
				</div>
			  </div>
			</li>
			<li class="span4">
			  <div class="thumbnail" style="background-color:rgba(0, 0, 0, 0.0);">
				<a href="product_details.html" class="overlay"></a>
				<a class="zoomTool" href="product_details.html" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="assets/img/ayakkabıspor.jpg" alt=""></a>
				<div class="caption cntr" style="background-color:rgba(0, 0, 0, 0.0);">
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
<!--
Clients
-->


</div><!-- /container -->
<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="assets/js/shop.js"></script>
   
  </body>
</html>
