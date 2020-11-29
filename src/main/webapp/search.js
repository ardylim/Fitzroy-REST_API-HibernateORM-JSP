//to disable the selection of the first option of criteria where it only shows "criteria"
document.getElementById("option1").options[0].disabled = true;


var optIndex = 1; //will later be use when add criteria button clicked
document.getElementById('ifrm').style.height = screen.height/1.75+"px"; //set the resolution of the iframe

console.log(document.getElementById('ifrm').height +" and "+screen.height);

//when add criteria button clicked, this function runs
function addCri(){
console.log("current optIndex="+optIndex);
	//if the criteria field has exceed 4 (array start from 0), it will run alert
	if(optIndex>4){
		alert("too many criteria field");
	}else if(optIndex<1){ //just for precaution if the field is minus to reduce error possibility
		alert("really?!");
	}else if(0<optIndex && optIndex<5){ //if the number match
		
		optIndex = optIndex+1; //increase number that later will be use to id the tag
		console.log("current optIndex="+optIndex);
		//string more to be printed
		var more = "<p style='display: inline-block'><select name='option"+optIndex+
		"'id='option"+optIndex+"' style='float: center;width: 10em;' onchange='optionchange("+optIndex+")'>"+ //can be seen the optIndex is used to send the tag id if the dropdown changed
		"<option disabled selected value> -- Criteria -- </option>"+
		"<option value='title'>Title</option>"+
		"<option value='isbn'>ISBN</option>"+
		"<option value='cat'>Category</option>"+
		"<option value='pub'>Publisher</option>"+
		"<option value='auth'>Author</option>"+
		"<option value='price'>Price</option>"+
		"</select>&emsp;&emsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
		"<input id='c"+optIndex+"'style='float: right;width: 15em;'type='text' name='noname'>"+ //optIndex used to id the input
		"</p>";
		document.getElementById("cri_sch").innerHTML+=more; //to print out the field
	};
};
//this function will run when the dropdown changed value, used to change the field name whenever the related criteria field changed
function optionchange(i){
	//check the id sent by the tag
	if(6>i>0){
	//check the value of the dropdown list and match the name of keyword input to the selection
		if(document.getElementById("option"+i).options[document.getElementById("option"+i).selectedIndex].value=="isbn"){
		document.getElementById("c"+i).name = "isbn";}
		else if(document.getElementById("option"+i).options[document.getElementById("option"+i).selectedIndex].value=="title"){
			document.getElementById("c"+i).name = "title";}
		else if(document.getElementById("option"+i).options[document.getElementById("option"+i).selectedIndex].value=="cat"){
			document.getElementById("c"+i).name = "cat";}
		else if(document.getElementById("option"+i).options[document.getElementById("option"+i).selectedIndex].value=="pub"){
			document.getElementById("c"+i).name = "pub";}
		else if(document.getElementById("option"+i).options[document.getElementById("option"+i).selectedIndex].value=="auth"){
			document.getElementById("c"+i).name = "auth";}
		else if(document.getElementById("option"+i).options[document.getElementById("option"+i).selectedIndex].value=="price"){
			document.getElementById("c"+i).name = "price";}
	}

};

//runs when the submit button clicked
 function submit(){
	 var text;
		var isbn = "";
		var cat = "";
		var title = "";
		var auth ="";
		var pub = "";
		var price ="";
		var quantity = "";
		var imagePath = "";

		//for every criteria
		for(var z = 1; z<optIndex+1;z++){
			if(document.getElementById("c"+z).name == "noname"){ //check if the criteria field has selected
				alert("please choose criteria option field"); //alert if used made no selection
				return;
				};
			if(document.getElementById("c"+z).value == ""||document.getElementById("c"+z).value == null){ //check if the input field has value
				alert("please enter the search keyword"); //alert to user to add value
				return;
			}else{
			//if else to check every field accordingly for its input format to be validated
				if(document.getElementById("c"+z).name == "isbn"){
					if(isNaN(document.getElementById("c"+z).value) != true){
					isbn = document.getElementById("c"+z).value; 
					}else{
						alert("ISBN field has to be in number"); 
						return;
						}
				}else if (document.getElementById("c"+z).name == "title"){title = document.getElementById("c"+z).value;}
				else if (document.getElementById("c"+z).name == "cat"){cat = document.getElementById("c"+z).value;}
				else if (document.getElementById("c"+z).name == "pub"){pub = document.getElementById("c"+z).value;}
				else if (document.getElementById("c"+z).name == "auth"){auth = document.getElementById("c"+z).value;}
				else if (document.getElementById("c"+z).name == "price"){price = document.getElementById("c"+z).value;};
			};
			console.log(document.getElementById("c"+z).name+"="+document.getElementById("c"+z).value);
		};
		//text is constructed as json with value of each field
		text = 		"{"+
		 "\"isbn\":\""+isbn+"\","+
			"\"title\":\""+title+"\","+
			"\"cat\":\""+cat+"\","+
			"\"pub\":\""+pub+"\","+
			"\"auth\":\""+auth+"\","+
			"\"price\":\""+price+"\","+
			"\"quantity\":\"\","+
			"\"imgPath\":\"\"}";
			console.log(text);
		document.getElementById('ifrm').append(text);	
		var url ;
		//as precaution if we failed to read null and empty string then run the program, it will direct to url get_table.jsp
		if((isbn ==null || isbn == "") && (title == null || title == "") && (cat == null || cat =="") && (pub == null || pub =="") &&
			(auth == null || auth =="") && (price == null || price =="")){
			url = new URL("http://localhost:8080/RESTHIBER/GET_TABLE.jsp");
		}else{url= new URL("http://localhost:8080/RESTHIBER/GET2.jsp"); //if value accepted, the url is get2.jsp 
		url.searchParams.append('x',text); //add the info as url parameter
		};
		console.log(url);
		document.getElementById('ifrm').innerHTML = "<iframe style='width:100%; height:100%' src='"+url+"'>"; //assign url to iframe
};