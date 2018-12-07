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
      <div>Checklist journalière</div>
      <input type="checkbox" name="chk_panneauSolaires class="check">Panneaux solaires<br/>
      <input type="checkbox" name="chk_eoliennes" class="check>Eoliennes<br/>
      <input type="checkbox" name="chk_robots" class="check>Robots<br/>
      <input type="checkbox" name="chk_systemesSurvie" class="check">Système de survie<br/>
      <input type="checkbox" name="chk_camp" class="check">Contrôle du camp<br/>
      <input type="checkbox" name="chk_sante" class="check">Protocole de santé<br/>
      <input type="submit" value="Valider" />
    </form>
    </ul>
  </div>

  <div class="col-6">
    <h1 class ="Titre">Namivie</h1>
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
