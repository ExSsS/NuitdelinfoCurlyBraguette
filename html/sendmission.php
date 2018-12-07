<!DOCTYPE html>
<html>
<?php
$path="/data/missions.txt";

$str = 'date : '.$_POST['date'].', duree : '.$_POST['duree'].', equipement : '.$_POST['equipement'];
$current = file_get_contents($path);
echo $current;
$current = $current.$str;
echo $current;
file_put_contents($path,$current);


include 'index.php';
?>

</html>