<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en" xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content = "IE=edge">
		<meta name = "viewport" content = "width=device-width, initial-scale = 1">
		<title>Alexander's Emporium</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" href="stylesheets/main.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
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
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle focused" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Go Shopping
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Search</a>
						</div>
					</li>
					<li class="nav-item dropdown userAccountReq">
						<a class="nav-link dropdown-toggle focused" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Manage
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">View Inventory</a>
							<a class="dropdown-item" href="#">Add/Remove Item</a>
							<a class="dropdown-item" href="#">Choose Featured Items</a>
						</div>
					</li>
					<li class="nav-item dropdown userAccountReq">
						<a class="nav-link dropdown-toggle focused" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
			<h1 class = "jumbotron">About Alexander's Emporium</h1>
			<h3>
				Alexander's Emporium is a virtual online store for Johnathan Alexander's portfolio.<br>
				If you have enjoyed your experience with this website then please feel free to contact me.<br>
				My name is Johnathan Alexander and I can be reached multiple ways.<br>
				My email is <strong>johnathanalexander@aol.com</strong>.<br>
				My cell number is <strong>(318) 469-6566</strong> and my home number is (318) 949-9735.<br>
			</h3>
			<h1>Results</h1>
			<h2 th:text="${model.users}"></h2>
			

		</body>
	</html>