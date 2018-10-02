 <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en" xmlns:th="http://www.thymeleaf.org">
	<head>
		<META NAME="ROBOTS" CONTENT="NOINDEX, FOLLOW">
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content = "IE=edge">
		<meta name = "viewport" content = "width=device-width, initial-scale = 1">
		<meta http-equiv="Cache-Control" content = "no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<link rel="shortcut icon" href="">
		<title>Alexander's Emporium</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" href="stylesheets/main.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
		<script type="text/javascript" src="scripts/main.js"></script>
	</head>
	
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" onclick = "goHome()">Alexander's Emporium</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item active">
						<a class="nav-link focused" onclick = "goHome()">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item">
						<a class="nav-link focused" onclick="goShopping()" aria-haspopup="false" aria-expanded="false">
							Go Shopping
						</a>
						
					</li>
					<li class="nav-item dropdown userAccountReq" id = "manager">
						<a class="nav-link dropdown-toggle focused" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Manage
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">View Inventory</a>
							<a class="dropdown-item" href="#">Add/Remove Item</a>
							<a class="dropdown-item" href="#">Choose Featured Items</a>
						</div>
					</li>
					<li class="nav-item dropdown userAccountReq" id = "admin">
						<a class="nav-link dropdown-toggle focused"  id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Administrator
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Add/Remove User</a>
							<a class="dropdown-item" href="#">View Messages</a>
							<a class="dropdown-item" href="#">Something else here</a>
						</div>
					</li>
					<li class="nav-item focused">
						<a class="nav-link" onclick="$('#aboutSection').show()">About</a>
					</li>
				</ul>
				
			</div>
			<button type="button" class="btn btn-primary logReg" id = "registerButton" data-toggle = "modal" data-target = "#registerModal">Register</button>
			<button type="button" class="btn btn-primary logReg" id = "loginButton" data-toggle = "modal" data-target = "#loginModal">Login</button>
		</nav>
	</header>
	<body>
		<div id = "loginModal" class="modal fade">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title">Login</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
				
			  </div>
			  <div class = "alert alert-danger noShow" id = "invalid">
					<strong>Alert!</strong> Invalid Username or Password
				</div>
			  <div class="modal-body">
			  	<form name = "loginUser">
				<p>Username:<br>
					<input type = "text" name = "username" id = "loginUsername"/>
				</p>
				<p>Password:<br>
					<input type = "password" name = "password" id = "loginPassword"/>
				</p>
				</form>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-primary" onclick = "login()">Login</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			  </div>
			</div>
		  </div>
		</div>
		<!--Register Modal-->
		<div id = "registerModal" class="modal fade">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title">Register New Account</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class = "alert alert-danger noShow" id = "passwordMatchError">
					<strong>Alert!</strong> Password Entries Do Not Match
				</div>
			  <div class="modal-body">
			      <form name = "registerForm">
				      <div class = "col-sm-6">
					      <p>Username:<br>
						      <input type = "text" th:field="*{username}" name = "username" id="username"/>
						  </p>
						  <p>Password:<br>
						      <input type = "password" th:field="*{password}" name = "password" id = "registerPassword"/>
						  </p>
						  <p>Repeat Password:<br>
						      <input id = "registerPasswordRepeat" th:field="*{newPasswordRepeat}" type = "password" name = "newPasswordRepeat" oninput = "checkRepeatPassword(this)"/>
						  </p>
				      </div>
					  <div class = "col-sm-6">
					      <p>Email:<br>
					          <input type = "text" th:field="*{email}" name = "email" placeholder="JohnDoe@abc.com" id = "email" />
						  </p>
						  <p>First Name:<br>
						      <input type = "text" th:field="*{firstName}" name = "firstName" id="firstName"/>
						  </p>
						  <p>Last Name:<br>
						      <input type = "text" th:field="*{lastName}" name = "lastName" id="lastName"/>
						  </p>
					  </div>
				  </form>
			  </div>
				  <div class="modal-footer">
				  	<input type = "button" class="btn btn-primary" id = "sub" onclick = "register()" value = "Submit">
					<!-- <button type="submit" class="btn btn-primary" id = "submit" onsubmit = "register()">Submit</button>-->
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
				  </div>
			  	 
			</div>
		  </div>
		</div>
		<div id = "homeFeatured" >
			<h1 id="featuredHeader">Featured Items</h1>
			<ul id = "featuredItemPlacement">
				<c:forEach items = "featuredItems" var = "product">
					<li class = "featuredCardsItem"><div class="card featuredCard" style="width: 25rem;">
	  					<img class="card-img-top" src="..." alt="Card image cap">
	  					<div class="card-body">
    						<h4 class="card-title">product.title</h4>
    						<p class="card-text">product.description</p>
   		 					<a href="#" class="btn btn-primary">Add To Cart</a>
  						</div>
					</div></li>
				</c:forEach>
			</ul>
		</div>
		<!-- This is placed under <div id = "homeFeatured"></div> -->
		<div id = "homeMain">
		</div>
		
		<div id = "goShopping">
			
		</div>
		<!-- manager and admin html should be returned 
			from java controller if possible instead of in jsp
		 -->
		<div id = "manager">
		asdf
		</div>
		<div id = "admin">
		adf
		</div>
		<div id = "about">
			<h1 class = "jumbotron">About Alexander's Emporium</h1>
			<h3>
				Alexander's Emporium is a virtual online store for Johnathan Alexander's portfolio.<br>
				If you have enjoyed your experience with this website then please feel free to contact me.<br>
				My name is Johnathan Alexander and I can be reached multiple ways.<br>
				My email is <strong>johnathanalexander@aol.com</strong>.<br>
				My cell number is <strong>(318) 469-6566</strong> and my home number is <strong>(318) 949-9735</strong>.<br>
			</h3>
			<h1>Results</h1>
			<h2 th:text="${model.users}"></h2>
		</div>
	</body>
	<footer>

	</footer>
</html>