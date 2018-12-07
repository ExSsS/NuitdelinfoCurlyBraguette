<!DOCTYPE html>
<html>
<?php
$path="/data/checklist.json";

$checklist->date=date('l jS \of F Y');
$checklist->panneauSolaires = $_POST['chk_panneauSolaires'];
$checklist->eoliennes = $_POST['chk_eoliennes'];
$checklist->robots = $_POST['chk_robots'];
$checklist->systemesSurvie = $_POST['chk_systemesSurvie'];
$checklist->camp = $_POST['chk_camp'];
$checklist->sante = $_POST['chk_sante'];

$json_decode=json_decode(file_get_contents($path),true);
echo file_get_contents($path);
echo $json_decode;/*
array_unshift($checklist,$json_decode);

file_put_contents($path,json_encode($json_decode);

include 'index.php'*/
?>

</html>