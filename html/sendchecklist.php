<!DOCTYPE html>
<html>
<?php
$checklist->pipi = $_POST['checkboxpipi'];
$checklist->glouglou = $_POST['checkboxglouglou'];

$myjson = json_encode($checklist);
echo $myjson;
?>
</html>