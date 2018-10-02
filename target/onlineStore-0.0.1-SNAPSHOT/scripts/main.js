function goHome(){
	$('#aboutSection').hide();
	$('#adminSection').hide();
	$('#manageSection').hide();
}
function checkRepeatPassword(input){
	console.log("running");
	//var password = $('newPassword').val();
	var password = document.getElementById('newPassword').value;
	if(password != input.value){
		$('#passwordRepeat').css("border-color", "red");
	}
	if(password == input.value){
		$('#passwordRepeat').css("border-color", "green");
	}
	console.log("end of method");
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
    xmlhttp.send()
    
    
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