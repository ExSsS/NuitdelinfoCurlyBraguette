<!DOCTYPE html>
<html>
<?php
$checklist->pipi = $_POST['chk_panneauSolaires'];

$checklist->panneauSolaires = $_POST['chk_panneauSolaires'];
$checklist->eoliennes = $_POST['chk_eoliennes'];
$checklist->robots = $_POST['chk_robots'];
$checklist->systemesSurvie = $_POST['chk_systemesSurvie'];
$checklist->camp = $_POST['chk_camp'];
$checklist->sante = $_POST['chk_sante'];

$myjson = json_encode($checklist);

$fp = fopen('test.txt', 'w');
fwrite($fp, 'Cats chase mice');
fclose($fp);
?>
</html>