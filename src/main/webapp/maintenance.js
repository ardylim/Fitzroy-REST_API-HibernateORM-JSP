//to make sure all input field is accordingly as the format
document.getElementById("isbn").placeholder = "ISBN";
document.getElementById("isbn").type = "number";
document.getElementById("isbn").min = 0;
document.getElementById("isbn").max = 9999999999999999999999999999999999;
document.getElementById("price").placeholder = "Price";
document.getElementById("price").type = "number";
document.getElementById("price").step = 0.01;
document.getElementById("price").min = 0;
document.getElementById("price").max = 99999999;
document.getElementById("quantity").placeholder = "Quantity";
document.getElementById("quantity").type = "number";
document.getElementById("quantity").min = 0;
document.getElementById("quantity").max = 9999999999999;
document.getElementById("title").placeholder = "Title";
document.getElementById("auth").placeholder = "Author(s)";
document.getElementById("cat").options[0].disabled = true;
document.getElementById("pub").options[0].disabled= true;

//when button clicked
function submit(){
	var errortext = "";
	var error_ = false;
	
	//get value of each input field
	var isbn = document.getElementById("isbn").value;
	var cat = document.getElementById("cat").options[document.getElementById("cat").selectedIndex].text;
	var title = document.getElementById("title").value;
	var auth =document.getElementById("auth").value;
	var pub = document.getElementById("pub").options[document.getElementById("pub").selectedIndex].text;
	var price =document.getElementById("price").value;
	var quantity = document.getElementById("quantity").value;
	var imagePath;
	console.log("1"+error_);
	
	//validation of each field, if error found, put the error to errortext for later to be printed out and change error_ value to true
	if(title == null || title=="Title" || title == ""){
		error_ = true;
		errortext += "wrong input on Title field<br/>";
	};
	console.log("2"+error_);
	if(isbn == null || isbn=="ISBN" || isbn == "" || isNaN(isbn)|| isbn == 0 || isbn%1 != 0){
		error_ = true;
		errortext += "wrong input on ISBN field<br/>";
	};
	console.log("3"+error_);
	if(cat == null || cat=="-- select an option --" || cat == ""){
		error_ = true;
		errortext += "wrong input on Category field<br/>";
	};
	console.log("4"+error_);
	if(auth == null || auth=="Author" || auth == ""){
		error_ = true;
		errortext += "wrong input on Author field<br/>";
	};
	console.log("5"+error_);
	if(pub == null || pub=="-- select an option --" || pub == ""){
		error_ = true;
		errortext += "wrong input on Publisher field<br/>";
	};
	console.log("6"+error_);
	if(price == null || price=="Price" || price == "" || isNaN(price) || price == 0){
		error_ = true;
		errortext += "wrong input on Price field<br/>";
	};
	console.log("7"+error_);
	if(quantity == null || quantity=="Quantity" || quantity == "" || isNaN(quantity) || quantity == 0 || quantity%1 != 0){
		error_ = true;
		errortext += "wrong input on Quantity field<br/>";
	};
	console.log("8"+error_);
	
	
	if(error_ == false){ //if there is no error, then execute bellow, text2 will be filled with json object
		var text2 =
		"{"+
		 "\"isbn\":\""+document.getElementById("isbn").value+"\","+
			"\"title\":\""+document.getElementById("title").value+"\","+
			"\"cat\":\""+document.getElementById("cat").options[document.getElementById("cat").selectedIndex].text+"\","+
			"\"pub\":\""+document.getElementById("pub").options[document.getElementById("pub").selectedIndex].text+"\","+
			"\"auth\":\""+document.getElementById("auth").value+"\","+
			"\"price\":\""+document.getElementById("price").value+"\","+
			"\"quantity\":\""+document.getElementById("quantity").value+"\","+
			"\"imgPath\":\""+document.getElementById("isbn").value+".png"+"\"}";
			console.log(error_);
	var obj = JSON.parse(text2);
		
	var url = new URL("http://localhost:8080/RESTHIBER/POST2.jsp"); //assign the url
	url.searchParams.append('x',text2); //assign text2 as parameter of the url
	
	document.getElementById('ifrm').innerHTML ="<iframe src='"+url+"'>"; //call url to ifrme

	}else if(error_ == true){ //print the error
	document.getElementById("error_alert").innerHTML = errortext+"Please check again before submitting";
	console.log(error_)};
}