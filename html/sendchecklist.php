<!DOCTYPE html>
<html>
<?php
$checklist->panneauSolaires = $_POST['chk_panneauSolaires'];
$checklist->eoliennes = $_POST['chk_eoliennes'];
$checklist->robots = $_POST['chk_robots'];
$checklist->systemesSurvie = $_POST['chk_systemesSurvie'];
$checklist->camp = $_POST['chk_camp'];
$checklist->sante = $_POST['chk_sante'];
$checklist_tot->date('l jS \of F Y')=json_encode($checklist);

$chk_json = json_encode($checklist_tot);
echo $checklist_tot;


$fp = fopen('data/checklistjson', 'w');
fwrite($fp, $chk_json);
fclose($fp);

include 'index.php'
?>

</html>