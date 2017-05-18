<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>OGaminG | Login</title>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="login.css">
</head>
<script>
 const login = () => {
	 const userName = document.getElementById('userName').value;
	 const userPassword = document.getElementById('userPassword').value; 
	 if (userName == '' || userPassword == '') {
	 	alert("fill the form accordingly");
	 } else {
	 	postUserCredentials(userName, userPassword);
	 }
 }       
</script>

<div class="jumbotron">
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>Hey there</h4>
            <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="username" />
            </br>
            <input type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="password" />
            </br>
            <div class="wrapper">
            <span class="group-btn" id = "loginButton" onclick="login()">
                <a href="#" class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></a>
            </span>
            </div>
            </div>
        
        </div>
    </div>
</div>
</div>
<script type="text/javascript">

	const parseData = data => {
		console.log(data);
		(data == true) ? window.location.replace("./index.jsp") : alert("wrong credentials");
	}

	const urlEncodeParameters = obj => {
        var str = [];
        for(var p in obj)
        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
        return str.join("&");
    };

	// Execute a post query and pass the servlet response in callback
	const postQuery = (url, data, callback) => {
	    var request = new XMLHttpRequest();

		const params = urlEncodeParameters(data);
		
	    request.onload = function() {
	        var state = this.readyState;
	        var responseCode = request.status;
	        console.log("request.onload called. readyState: " + state + "; status: " + responseCode);

	        if (state == this.DONE && responseCode == 200) {
	            var responseData = this.responseText;
	            console.log("Success: " + responseData.length  + " chars received.");
	            callback(JSON.parse(responseData));	
	        }
	    };

	    request.error = function(e) {
	        console.log("request.error called. Error: " + e);
	    };

	    request.onreadystatechange = function(){
	        console.log("request.onreadystatechange called. readyState: " + this.readyState);
	    };
	    
	    request.open("POST", url, true);

		//Send the proper header information along with the request
		request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

		request.send(params);
	};

	// getting all the videogames information
	const postUserCredentials = (userName, userPassword) => {
		const data = {
			userName : userName,
			userPassword : userPassword
		}
    	const url = "http://localhost:8080/Video_Games/ClientsManager";
    	return postQuery(url, data, parseData);
	};

</script>
</body>