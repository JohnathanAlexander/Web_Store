//Global Variables
var featuredItems;
//////////////////

window.addEventListener('loadend', d());

function d(){
	var html = '';
	$.get({
		url: "getAllFeatured",
		success: function(res){
			featuredItems = res;
			console.log(res);
			if(document.getElementById("featuredItemPlacement") != null){
				console.log("running");
				var p = document.getElementById("featuredItemPlacement");
			
				for(var count = 0; count < featuredItems.length; count++){
					html +=
							"<li class = 'featuredCardsItem' id = '"+featuredItems[count].title+"'><div class = 'card featuredCard' style = 'width: 25rem;'>" +
								"<img class='card-img-top' src='...' alt = 'Card Image Cap'>"+
								"<div class = 'card-body'>"+
									"<h4 class = 'card-title'>"+featuredItems[count].title+"</h4>"+
									"<p class = 'card-text'>"+featuredItems[count].description+"</p>"+
									"<a href = '#' class = 'btn btn-primary' >Add To Cart</a>"+
								"</div>"+
							"</div></li>";
					
					
				}
				document.getElementById("featuredItemPlacement").innerHTML = html;
			}
			
			
		}
	});
}
function goHome(){
	$('#aboutSection').hide();
	$('#adminSection').hide();
	$('#manageSection').hide();
}
function checkRepeatPassword(input){
	var passwordRepeat;
	var password = $('#registerPassword').val();
	
	passwordRepeat = $(input).val();
	if(passwordRepeat == undefined)
		passwordRepeat = $('#registerPasswordRepeat').val();

	if(password != passwordRepeat){
		document.getElementById('passwordMatchError').style.display = "block";
		return false;
	}else{
		document.getElementById('passwordMatchError').style.display = "none";
		return true;
	}
}
function login(){
	alert("login");
	
	$.get({
		url : 'login',
		data : $('form[name=loginUser]').serialize(),
		success : function(res) {
			var authLevel = res.authLevel;
			var isLoggedIn = res.isLoggedIn;
			if(isLoggedIn){
				loginHtmlSetup(authLevel);
				$('#invalid').hide();
				document.getElementById("loginUsername").value = "";
				document.getElementById("loginPassword").value = "";
			}else{
				//invalid username or password
				$('#invalid').show();
			}
			
		}
	});
}
function closeLoginModal(){
	//closes out loginModal
	$('#loginModal').modal('hide');
	$('body').removeClass('modal-open');
	$('.modal-backdrop').remove();
	
}
function loginHtmlSetup(userAuth){
	closeLoginModal();
	if(userAuth == "manager" || userAuth == "admin"){
		$('#manager').show();
	}
	if(userAuth == "admin"){
		$("#admin").show();
	}
}
function register(){
	var passwordMatch = checkRepeatPassword('');

	if(passwordMatch){
	    $.post({
	    	url: "registerUser",
	    	data: $('form[name=registerForm]').serialize(),
	    	success : function(res){
	    		if(res == "true"){
	    			//close register modal
	    		}else if(res == "email"){
	    			//Email duplication
	    		}else if(res == "username"){
	    			//Username already taken
	    		}else{
	    			//email and username
	    		}
	    	}
	    });
	}
	
}
function getAllFeaturedItems(){
	$.get({
		url: "getAllFeatured",
		success: function(res){
			console.log(res);
		}
	});
}
function goShopping(){
	$('#homeFeatured').hide();
	$('#manager').hide();
	$('#admin').hide();
	$('#about').hide();
	$('#goShopping').show();
	
	//ajax get all products
	console.log("Start ajax");
	var xmlhttp, response;
    var url = "getAllProducts";
    if(window.XMLHttpRequest){
    	xmlhttp = new XMLHttpRequest();
    }else{
    	xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
    	if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
    		response = JSON.parse(xmlhttp.responseText);
    		console.log(response[0].description);
    		var shopping = document.getElementById("goShopping");
    	    
    	    for(var count = 0; count < response.length; count++){
    	    	document.append("<h1>Hello</h1>");
    	    }
    	}
    }
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    
    
    				  /*
    				   * 
    				   * <ul>
				<c:forEach items = "${products}" var = "product">
					<li class = "featuredCardsItem"><div class="card featuredCard" style="width: 25rem;">
	  					<img class="card-img-top" src="..." alt="Card image cap">
	  					<div class="card-body">
    						<h4 class="card-title">${product.title}</h4>
    						<p class="card-text">${product.description}</p>
   		 					<a href="#" class="btn btn-primary">Add To Cart</a>
  						</div>
					</div></li>
				</c:forEach>
			</ul>
    				   */
}