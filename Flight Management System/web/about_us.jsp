
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<title>About US</title>
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
                <script src="https://cdnjs.cloudflare.com/ajax/libs/wow/1.1.2/wow.min.js"></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.css">
                <style>
                        .main-heading{width:100%; text-align:center; color:red; margin:60px;}
                        .img-box img{width:100%;border-radius: 10px}
                        .main{display:block; overflow:hidden;}
                        .text-block{display:block; color:#000;}
                        .text-block h2{color:red;}
                        .main{padding:100px 0; width:100%; overflow:hidden;}
                        .main.bg-t{width:100%; background:rgba(255, 255, 255, 0.2); padding:120px 0;}
                </style>
                <script>   wow = new WOW(
      {
        animateClass: 'animated',
        offset:       100,
        callback:     function(box) {
          console.log("WOW: animating <" + box.tagName.toLowerCase() + ">")
        }
      }
    );
    wow.init();
    document.getElementById('moar').onclick = function() {
      var section = document.createElement('section');
      section.className = 'section--purple wow fadeInDown';
      this.parentNode.insertBefore(section, this);
    };</script>
</head>
<body>
		<% if(session.getAttribute("email")==null){ %>
		<%@include file="main_header.jsp" %>
		<%}else{ %>
		<%@include file="user_header.jsp" %>
		<%} %>
                
                
</div>
<section class="main">
    <div class="container">
        <div class="row">
            <div class="col-md-6"> 
                <div class="img-box wow fadeInUp" data-wow-duration="2s">
            <img src="images/about1.png">
        </div>
    </div>
    
    <div class="col-md-6">
        <div class="text-block wow fadeInUp" data-wow-duration="2s">
            <h2 style="color:#7B113A">PHOENIX AIR</h2>
                <p >Phoenix Air is an FAA-certificated Part 135 company with worldwide operating authority
                    to provide passenger services, worldwide air ambulance services and high priority air 
                    cargo services including the transport of explosives and most other dangerous goods. 
                    Phoenix Air's military contracting division is the world's leading provider of contracted
                    airborne electronic warfare and weapons training/testing services for clients such as U.S.
                    Department of Defense, NATO and various other foreign militaries and governments.

                </p>
        </div>
    </div>
 </div>
    
</div>
    
</section>
<section class="main bg-t">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
        <div class="img-box  wow fadeInUp" data-wow-duration="2s">
           <img src="https://c4.wallpaperflare.com/wallpaper/682/248/50/sky-airplane-airline-airbus-wallpaper-preview.jpg"height="310px">
        </div>
        </div>
    
       <div class="col-md-4">
        <div class="img-box  wow fadeInUp" data-wow-duration="2s">
           <img src="https://c4.wallpaperflare.com/wallpaper/498/657/85/777-777x-aircraft-airliner-wallpaper-preview.jpg"height="310px">
        </div>
        </div>
    <div class="col-md-4">
        <div class="img-box  wow fadeInUp" data-wow-duration="2s">
           <img src="https://c0.wallpaperflare.com/preview/347/517/94/airplane-in-midair-at-daytime.jpg"height="310px">
        </div>
    </div>
        </div>
    
</div>
    
</section>
<section class="main">
    <div class="container">
        <div class="row">
         <div class="col-md-6">
             
        <div class="text-block wow fadeInUp" data-wow-duration="2s">
            <h2 style="color:#7B113A">NATIONAL BUSINESS AVIATION ASSOCIATION</h2>
            <p>Phoenix Air is a member of the National Business Aviation Association (NBAA),
                a non-profit, nonpartisan Washington, D.C.-based organization dedicated to the 
                success of the business aviation community.  For 60 years, the NBAA has served 
                the aviation community through its leadership efforts at all levels of government 
                and business, both in the U.S. and worldwide.  NBAA represents the aviation interests 
                of more than 7,000 companies.  NBAA member companies together earn annual revenues approaching
                $5 trillion dollars, a number that is about half of the U.S. gross domestic product, 
                and employ more than 19 million people worldwide.  The NBAA values include safety, efficiency, 
                relevance, versatility, integrity, commitment, excellence and satisfaction.  The NBAA is Phoenix 
                Air's voice in national policies affecting the aviation industry.</p>
        </div>
    </div>
     <div class="col-md-6"> 
        <div class="img-box  wow fadeInUp" data-wow-duration="2s">
            <img src="https://c4.wallpaperflare.com/wallpaper/11/569/169/777-aircrafts-airliner-airplane-wallpaper-preview.jpg">
        </div>
    </div>
        </div>
    
</div>
    
</section>
		
		
		<%@include file="footer.jsp" %>
</body>
</html>