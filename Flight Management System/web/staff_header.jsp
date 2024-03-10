<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-dark p-md-3" style="background-color:#150E56">
	  <a class="navbar-brand" href="index.jsp"><img src="./images/logo.svg"  height="34"></a>
	  <button class="navbar-toggler" 
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#navbarNav" 
                  aria-controls="navbarNav" 
                  aria-expanded="false" 
                  aria-label="Toggle Navbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
		    <ul class="navbar-nav">
		      <li class="nav-item">
			        	<a class="nav-link" href="staff_dashboard.jsp">Home</a>
			      </li>
		
			    	<li class="nav-item">
				    	<a class="nav-link" href="profile.jsp">My Profile</a>
				  	</li>
			 	 	<li class="nav-item" >
			        	<a class="nav-link" href="logout.jsp">Log Out</a>
			      	</li>
		    	
		    </ul>
	  </div>
</nav>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark p-md-3" style="background-color:#150E56">
	  <a class="navbar-brand" href="index.jsp"><img src="./images/logo.svg" width="100" height="34"></a>
	  <button class="navbar-toggler" 
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#navbarNav" 
                  aria-controls="navbarNav" 
                  aria-expanded="false" 
                  aria-label="Toggle Navbar">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
              <div class="mx-auto"></div>
		    <ul class="navbar-nav">
		      <li class="nav-item">
			        	<a class="nav-link text-white" href="staff_dashboard.jsp">Home</a>
			      </li>
		
			    	<li class="nav-item">
				    	<a class="nav-link text-white" href="profile.jsp">My Profile</a>
				  	</li>
			 	 	<li class="nav-item" >
			        	<a class="nav-link text-white" href="logout.jsp">Log Out</a>
			      	</li>
		    	
		    </ul>
	  </div>
</nav>
