<!DOCTYPE html>
<html>
<?php
$checklist->date=date('l jS \of F Y');
$checklist->panneauSolaires = $_POST['chk_panneauSolaires'];
$checklist->eoliennes = $_POST['chk_eoliennes'];
$checklist->robots = $_POST['chk_robots'];
$checklist->systemesSurvie = $_POST['chk_systemesSurvie'];
$checklist->camp = $_POST['chk_camp'];
$checklist->sante = $_POST['chk_sante'];

$chk_json = json_encode($checklist);


$fp = fopen('data/checklistjson', 'w');
fwrite($fp, $chk_json);
fclose($fp);
/*
$data = file('data/checklist.json'); // reads an array of lines
function replace_a_line($data) {
   if (stristr($data, date('l jS \of F Y')) {
     return chk_json;
   }
   return $data;
}
$data = array_map('replace_a_line',$data);
file_put_contents('myfile', implode('', $data));
*/
include 'index.php'
?>

</html>