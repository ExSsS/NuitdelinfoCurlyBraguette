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
ws  
  <div class="col-6">
    <h1 >Namivie</h1>
    <div class="meteo">
    <iframe src="https://www.meteoblue.com/en/weather/widget/three/talence_france_2973495?geoloc=fixed&nocurrent=0&noforecast=0&days=4&tempunit=CELSIUS&windunit=KILOMETER_PER_HOUR&layout=monochrome"  frameborder="0" scrolling="NO" allowtransparency="true" sandbox="allow-same-origin allow-scripts allow-popups allow-popups-to-escape-sandbox" style="width: 460px;height: 595px">
    </iframe><div><!-- DO NOT REMOVE THIS LINK -->
      <a href="https://www.meteoblue.com/en/weather/forecast/week/talence_france_2973495?utm_source=weather_widget&utm_medium=linkus&utm_content=three&utm_campaign=Weather%2BWidget" target="_blank">meteoblue</a> </div>
    </div>
  </div>

  <div class="col-3 right">
    <div class="aside">
      <h2>What?</h2>
      <p>Chania is a city on the island of Crete.</p>
      <h2>Where?</h2>
      <p>Crete is a Greek island in the Mediterranean Sea.</p>
      <h2>How?</h2>
      <p>You can reach Chania airport from all over Europe.</p>
    </div>
  </div>
</div>

<div class="footer">
  <p>Resize the browser window to see how the content respond to the resizing.</p>
</div>

</body>
</html>
