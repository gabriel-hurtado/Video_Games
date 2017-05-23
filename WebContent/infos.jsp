<!DOCTYPE HTML>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>OGaminG</title>

	<link rel="stylesheet" type="text/css" href="main.css">


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>

	<script type="text/javascript">
	window.onload = function() {
		if (sessionStorage.getItem('userId')) {
			getUserInformation(sessionStorage.getItem('userId'));
		} else {
			window.location.replace("./login.jsp");
		}
	};
	</script>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="login.jsp">OGaminG</a>H
	    </div>
	    <ul class="nav navbar-nav">
	      <li ><a href="index.jsp">Home</a></li>
	      <li class="active"><a href="infos.jsp" id = "userTab">--</a></li>
	    </ul>
	  </div>
	</nav>


	<div class="container">
    <div class="span3 well" id = "background1">
        <center>
        <a href="#aboutModal" data-toggle="modal" data-target="#myModal"><img id ="picture2" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRbezqZpEuwGSvitKy3wrwnth5kysKdRqBW54cAszm_wiutku3R" name="aboutme" width="140" height="140" class="img-circle"></a>
        <h3 id = "username">John Doe</h3>
        <em>click my face for more</em>
		</center>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title" id="myModalLabel">More About me</h4>
                 </div>
                <div class="modal-body" id = "background2">
                    <center id = "infos">
                    <img id = "picture" src="https://scontent-cdg2-1.xx.fbcdn.net/v/t31.0-8/10847178_783799198362583_1631970166806004189_o.jpg?oh=02271f8cc535a5bcb4383076d7145669&oe=59A46947" name="aboutme" width="140" height="140" border="0" class="img-circle"></a>
                    <h3 id = "name" class="media-heading">John Doe</h3>
                    <span><strong>Addresses: </strong></span>
                    </center>
                    <hr>
                    <center>
                    <p id = "description" class="text-left"><strong>Bio: </strong><br>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut sem dui, tempor sit amet commodo a, vulputate vel tellus.</p>
                    <br>
                    </center>
                </div>
                <div class="modal-footer">
                    <center>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </center>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript">

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

	// modifying client info in DOM
	const parseDataClients = client => {
		console.log("Client received" + JSON.stringify(client));
		const username = document.getElementById("username");
		username.innerHTML = client.username;

		const userTab = document.getElementById("userTab");
		userTab.innerHTML = "@ " + client.username;
		const name = document.getElementById("name");
		name.innerHTML = client.name + " " + client.surname;
		const picture = document.getElementById("picture");
		picture.src = client.picture;
		const picture2 = document.getElementById("picture2");
		picture2.src = client.picture;
		const background1 = document.getElementById("background1");
		background1.style.backgroundImage = "url('"+client.backgroundPicture+"')";
		const background2 = document.getElementById("background2");
		background2.style.backgroundImage = "url('"+client.backgroundPicture+"')";
		const description = document.getElementById("description");
		description.innerHTML = client.description;

		if (client.address) {
			client.address.forEach(address => {
				const span = document.createElement("span");
				span.classList.add('label', 'label-info');
				span.innerHTML = address.address_line + " " + address.city + " " + address.country;
				document.getElementById("infos").appendChild(span);
				document.getElementById("infos").appendChild(document.createElement("br"));
			});
		}
	};

	const getUserInformation = userId => {
		const url = "http://localhost:8080/Video_Games/ClientsManager";
		const data = {
			id : userId
		};
    	postQuery(url, data, parseDataClients);
	};

	</script>
	
	


	<footer>
		<p>SR03 / Hurtado Durocher </p>
	</footer>

</body>

</html>