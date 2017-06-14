

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>OGaminG | Home</title>

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

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="login.jsp">OGaminG</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="index.jsp">Home</a></li>
	      <li><a id = "userTab" href="infos.jsp"> -- </a></li>
	    </ul>
	  </div>
	</nav>

	<div class="panel-heading">
       <div class="panel-title text-center">
       		<h1 id = "welcomeMessage" class="welcomeMessage">Hey buddy</h1>
       		<hr />
       	</div>
    </div>

	<script>

	function getQuery(url, callback){
	    var request = new XMLHttpRequest();

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
	    
	    request.open("GET", url);
	    request.setRequestHeader('Access-Control-Allow-Origin','*');
	    request.send(null);
	};

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

	// modifying video games info in DOM
	const parseDataVideoGames = data => {
		console.log(data);
		const n = data.length;
		// building dynamic gallery 
		data.forEach(video => {
			const item = document.createElement("div");
			item.classList.add('item', 'col-xs-4', 'col-lg-4');
			const thumbnail = document.createElement("div");
			thumbnail.classList.add('thumbnail');

			const img = document.createElement("img");
			img.classList.add('group', 'list-group-image');
			img.src = video.picture;
			img.style.height = '170px';
    		img.style.width = '340px';
			const caption = document.createElement("div");
			caption.classList.add('caption');
			const h4 = document.createElement("h4");
			h4.classList.add('title', 'group', 'inner', 'list-group-item-heading');
			h4.innerHTML = video.title;
			const p = document.createElement("p");
			p.classList.add('group', 'inner', 'list-group-item-text');
			if (video.consoles && video.consoles.length > 0) {
				p.innerHTML = "<strong> Console </strong>";
				video.consoles.forEach(console => {
					p.innerHTML += console.name + " ";
				}); 
			}
			if (video.gameTypes && video.gameTypes.length > 0) {
				p.innerHTML += "</br><strong> Type </strong>";
				video.gameTypes.forEach(type => {
					p.innerHTML += type.name + " ";
				});
			}
			const row = document.createElement("div");
			row.classList.add('row');
			const col = document.createElement("div");
			col.classList.add('col-xs-12', 'col-md-6');
			const p_lead = document.createElement("p");
			p_lead.classList.add(('lead'));
			p_lead.innerHTML = "$" + parseFloat(video.price);
			const col2 = document.createElement("div");
			col2.classList.add('col-xs-12', 'col-md-6');
			//const  btn = document.createElement("a");
			//btn.classList.add('btn', 'btn-success');
			//btn.innerHTML = "Ajouter au panier";
			//col2.appendChild(btn);
			col.appendChild(p_lead);
			row.appendChild(col);
			row.appendChild(col2);
			caption.appendChild(h4);
			caption.appendChild(p);
			caption.appendChild(row);
			thumbnail.appendChild(img);
			thumbnail.appendChild(caption);
			item.appendChild(thumbnail);
			document.getElementById("products").appendChild(item);
		});	            
	};

	// modifying client info in DOM
	const parseDataClients = client => {
		console.log("Client received" + JSON.stringify(client));
		const welcomeMessage = document.getElementById("welcomeMessage");
		welcomeMessage.innerHTML = "Game on "+ client.username + ".";
		const userTab = document.getElementById("userTab");
		userTab.innerHTML = "@ " + client.username;

		
	};

	// getting all the videogames information
	const getVideoGamesGallery = () => {
    	const url = "http://localhost:8080/Video_Games/VideoGamesManager";
    	getQuery(url, parseDataVideoGames);
	};

	const getUserInformation = userId => {
		const url = "http://localhost:8080/Video_Games/ClientsManager";
		const data = {
			id : userId
		};
    	postQuery(url, data, parseDataClients);
	};

	window.onload = function() {
		if (sessionStorage.getItem('userId')) {
			getUserInformation(sessionStorage.getItem('userId'));
			getVideoGamesGallery();
		} else {
			window.location.replace("./login.jsp");
		}
	};

	</script>
	
	<div class="container">
	<div id="products" class="row list-group">
	</div>
	</div>


	<footer>
		<p>SR03 / Hurtado Durocher </p>
	</footer>

</body>

</html>