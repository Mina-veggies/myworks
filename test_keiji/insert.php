<?php

mb_internal_encoding("utf8");

$pdo = new PDO("mysql:dbname=test_mina;host=localhost;","root","mysql");

$pdo -> exec("insert into keijiban(name, title, comments) values('".$_POST['name']."','".$_POST['title']."','".$_POST['comments']."');");

header("Location:http://localhost/test_keiji/index.php");

?>