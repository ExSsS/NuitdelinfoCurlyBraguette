<!DOCTYPE html>
<html>
<?php
$path="/data/missions.txt";

$str = 'date : '.$_POST['date'].', duree : '.$_POST['duree'].', equipement : '.$_POST['equipement'];
$current = file_get_contents($path,FILE_USE_INCLUDE_PATH);
echo $current;
$current = $current.$str;
echo $current;
file_put_contents($path,"enculé de ta mère");


include 'index.php';
?>

</html>