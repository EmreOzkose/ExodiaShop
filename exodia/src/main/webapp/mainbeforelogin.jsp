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
			
                            <button class="log" onclick ="location.href='login'">Sign in</button>
			                        
                            <button  class="log" onclick ="location.href='register'">Sign up</button>
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
		<li><a href="products.jsp"><span class="icon-chevron-right"></span>Women</a></li>
		<li><a href="products.jsp"><span class="icon-chevron-right"></span>Men</a></li>
		<li><a href="products.jsp"><span class="icon-chevron-right"></span>Bags & Shoes</a></li>
		<li><a href="products.jsp"><span class="icon-chevron-right"></span>Clothes</a></li>
		<li><a href="products.jsp"><span class="icon-chevron-right"></span>Cosmetic</a></li>
		<li><a href="products.jsp"><span class="icon-chevron-right"></span>Electronics</a></li>

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
				<a class="zoomTool" href="product_details.jsp" title="add to cart"><span class="icon-search"></span> QUICK VIEW</a>
				<a href="product_details.html"><img src="img/products/clothes/2.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/clothes/5.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/clothes/4.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/cosmetic/3.jpeg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/cosmetic/2.jpeg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/cosmetic/1.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/electronic/3.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/electronic/4.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/electronic/1.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/shoes/2.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/shoes/3.jpg" alt=""></a>
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
				<a href="product_details.html"><img src="img/products/shoes/1.jpg" alt=""></a>
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

</div>
  </body>
</html>
