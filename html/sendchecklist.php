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
echo $myjson;

$filename = "/data/checklist.json";
file_put_contents ( string $filename , mixed (echo $myjson) [, int $flags = 0 [, resource $context ]] );

?>
</html>