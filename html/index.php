<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="./tout.css" media="all"/> 
<link rel="stylesheet" type="text/css" href="./header.css" media="all"/> 
</head>
<!-- <body>


<div class="header">
  <a href="#default" class="logo">Cockpit numérique</a>
  <div class="header-right">
    <a class="active" href="squelette.php">Home</a>
    <a href="onglet2.php">Onglet2</a>
    <a href="onglet3.php">Onglet3</a>
  </div>
</div>
</body>


</head> -->
<body>


<div class="row">
  <div class="col-3 menu">
    <ul>
    <form method="post" action="sendchecklist.php">
      <div class="check2">Checklist journalière</div>
      <div class="check"> <input type="checkbox" name="chk_panneauSolaires"> Panneaux solaires<br/></div>
      <div class="check"><input type="checkbox" name="chk_eoliennes"> Eoliennes<br/></div>
      <div class="check"><input type="checkbox" name="chk_robots">  Robots<br/></div>
      <div class="check"><input type="checkbox" name="chk_systemesSurvie"> Système de survie<br/></div>
      <div class="check"><input type="checkbox" name="chk_camp"> Contrôle du camp<br/></div>
      <div class="check"><input type="checkbox" name="chk_sante">Protocole de santé<br/></div>
      <div class="check"> <input type="submit" value="Valider" />
    </form>
    </ul>
  </div>
  <div class="col-6">
    <h1 >Namivie</h1>
    <div class="meteo">
    <iframe src="https://www.meteoblue.com/en/weather/widget/three/talence_france_2973495?geoloc=fixed&nocurrent=0&noforecast=0&days=4&tempunit=CELSIUS&windunit=KILOMETER_PER_HOUR&layout=monochrome"  frameborder="0" scrolling="NO" allowtransparency="true" sandbox="allow-same-origin allow-scripts allow-popups allow-popups-to-escape-sandbox" style="width: 460px;height: 595px">
    </iframe><div><!-- DO NOT REMOVE THIS LINK -->
      <a href="https://www.meteoblue.com/en/weather/forecast/week/talence_france_2973495?utm_source=weather_widget&utm_medium=linkus&utm_content=three&utm_campaign=Weather%2BWidget" target="_blank" class="petitBidule">meteoblue</a> </div>
    </div>
  </div>

  <div class="col-3 right">
  <div id="progress">
    <p>Jour<strong>0</strong></p>
    <progress value="50" min="0" max="121">50</progress>
    <div classe="Mission">
    <ul>
    <form method="post" action="Mission.php">

    <label for="date">Date</label>
<div class="champ">
<input type="text" id="date" name="date" required
       minlength="4" maxlength="10" size="10">
    </div>
       <div class="champ">
       <label for="duree">Duree en jou</label>
    

  <input type="text" id="duree" name="duree" required
       minlength="0" maxlength="10" size="10">
    </div>
       <div class="champ">
       <label for="equipement">Equipement</label>

<input type="text" id="equipement" name="equipement" required
       minlength="0" maxlength="30" size="30">
       </div>
    </form>
    </ul>
    </div>
</div>
    <div class="aside">
    <iframe
  width = "600"
  hauteur = "450"
  frameborder = "0" style = "border: 0"
  src = "https://www.google.com/maps/embed/v1/place?key=AIzaSyCLG4EHtcL496f0pu41J-mosN6V6snqWuI"Autoriser l’écran>>
</ iframe>
    </div>
  </div>
</div>

<div class="footer">
  <p>Resize the browser window to see how the content respond to the resizing.</p>
</div>

</body>
</html>
