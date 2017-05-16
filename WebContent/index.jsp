

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">OGaminG</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="index.jsp">Home</a></li>
	      <li><a href="infos.jsp">Infos</a></li>
	      <li><a href="panier.jsp">Panier</a></li>
	    </ul>
	  </div>
	</nav>

	<script>
	const parseData = data => {
		console.log(data);
		const n = data.length;
		const productTitles = document.getElementsByClassName("title");
		const productLead = document.getElementsByClassName("lead");

		for (var i = 0; i < data.length; i++) {
			// modifying title for each video games
			productTitles[i].innerHTML = data[i].title;
			// modifying price for each video games
			productLead[i].innerHTML = "$" + data[i].price;
		}
	}

	window.onload = function() {
        var url = "http://localhost:8080/Video_Games/VideoGamesManager";
        var request = new XMLHttpRequest();

        request.onload = function() {
            var state = this.readyState;
            var responseCode = request.status;
            console.log("request.onload called. readyState: " + state + "; status: " + responseCode);

            if (state == this.DONE && responseCode == 200) {
                var responseData = this.responseText;
                console.log("Success: " + responseData.length  + " chars received.");
                parseData(JSON.parse(responseData));	
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

	</script>
	
	<div class="container">
	<div id="products" class="row list-group">
	    <div class="item  col-xs-4 col-lg-4">
	        <div class="thumbnail">
	            <img class="group list-group-image" src="http://www.boardknight.com/wp-content/uploads/2015/02/knights-1920x1200.jpg" alt="" />
	            <div class="caption">
	                <h4 class="title group inner list-group-item-heading">
	                    Product title</h4>
	                <p class="group inner list-group-item-text">
	                    Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
	                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
	                <div class="row">
	                    <div class="col-xs-12 col-md-6">
	                        <p class="lead">
	                            $21.000</p>
	                    </div>
	                    <div class="col-xs-12 col-md-6">
	                        <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="item  col-xs-4 col-lg-4">
	        <div class="thumbnail">
	            <img class="group list-group-image" src="https://magazinegk.fr/wp-content/uploads/2016/08/landscape-1456759219-14993-call-of-duty-4-modern-warfare-game-desktop-wallpaper-2560x1600.jpg" alt="" />
	            <div class="caption">
	                <h4 class="title group inner list-group-item-heading">
	                    Product title</h4>
	                <p class="group inner list-group-item-text">
	                    Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
	                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
	                <div class="row">
	                    <div class="col-xs-12 col-md-6">
	                        <p class="lead">
	                            $21.000</p>
	                    </div>
	                    <div class="col-xs-12 col-md-6">
	                        <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="item  col-xs-4 col-lg-4">
	        <div class="thumbnail">
	            <img class="group list-group-image" src="http://cooldown.fr/wp-content/uploads/2016/10/skyrim-special-edition-pc-mauvais-son.jpg" alt="" />
	            <div class="caption">
	                <h4 class="title group inner list-group-item-heading">
	                    Product title</h4>
	                <p class="group inner list-group-item-text">
	                    Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
	                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
	                <div class="row">
	                    <div class="col-xs-12 col-md-6">
	                        <p class="lead">
	                            $21.000</p>
	                    </div>
	                    <div class="col-xs-12 col-md-6">
	                        <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="item  col-xs-4 col-lg-4">
	        <div class="thumbnail">
	            <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
	            <div class="caption">
	                <h4 class="title group inner list-group-item-heading">
	                    Product title</h4>
	                <p class="group inner list-group-item-text">
	                    Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
	                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
	                <div class="row">
	                    <div class="col-xs-12 col-md-6">
	                        <p class="lead">
	                            $21.000</p>
	                    </div>
	                    <div class="col-xs-12 col-md-6">
	                        <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="item  col-xs-4 col-lg-4">
	        <div class="thumbnail">
	            <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
	            <div class="caption">
	                <h4 class="title group inner list-group-item-heading">
	                    Product title</h4>
	                <p class="group inner list-group-item-text">
	                    Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
	                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
	                <div class="row">
	                    <div class="col-xs-12 col-md-6">
	                        <p class="lead">
	                            $21.000</p>
	                    </div>
	                    <div class="col-xs-12 col-md-6">
	                        <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="item  col-xs-4 col-lg-4">
	        <div class="thumbnail">
	            <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
	            <div class="caption">
	                <h4 class="title group inner list-group-item-heading">
	                    Product title</h4>
	                <p class="group inner list-group-item-text">
	                    Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
	                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
	                <div class="row">
	                    <div class="col-xs-12 col-md-6">
	                        <p class="lead">
	                            $21.000</p>
	                    </div>
	                    <div class="col-xs-12 col-md-6">
	                        <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	</div>


	<footer>
		<p>SR03 / Hurtado Durocher </p>
	</footer>

</body>

</html>