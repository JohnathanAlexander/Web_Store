<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
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
		<div id = "loginModal" class="modal fade">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title">Login</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
				<p>Username:<br>
					<input type = "text" name = "username" id = "username"/>
				</p>
				<p>Password:<br>
					<input type = "password" name = "password" id = "password"/>
				</p>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-primary">Login</button>
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
			  <div class="modal-body">
				<p>Username:<br>
					<input type = "text" name = "newUsername" />
				</p>
				<p>Password:<br>
					<input type = "password" name = "newPassword" id = "newPassword"/>
				</p>
				<p>Repeat Password:<br>
					<input id = "passwordRepeat" type = "password" name = "newPasswordRepeat" oninput = "checkRepeatPassword(this)"/>
				</p>
				<p>Email:<br>
					<input type = "text" name = "newEmail" placeholder="JohnDoe@abc.com" />
				</p>
				<p>First Name:<br>
					<input type = "text" name = "firstName" />
				</p>
				<p>Last Name:<br>
					<input type = "text" name = "lastName" />
				</p>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-primary">Login</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			  </div>
			</div>
		  </div>
		</div>
		<div class = "noShow" id = "homeSection" style = "display: none">
		</div>
		<div class = "noShow" id = "manageSection" style = "display: none">
		</div>
		<div class = "noShow" id = "adminSection" style = "display: none">
		</div>
		<div class = "noShow" id = "aboutSection" style="display: none">
			<h1 style = "text-align: center">About</h1>
			<br>
			<p>Welcome to Alexander's Emporium. <br>This is a fake virtual store for purchasing items that don't exist.</p>
		</div>
	</body>
	<footer>

	</footer>
</html>