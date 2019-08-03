<?php
mb_internal_encoding("utf8");

$pdo = new PDO("mysql:dbname=test_mina;host=localhost;","root","mysql");

$pdo->exec("insert into catform(sex,comments)values('".$_POST['sex']."','".$_POST['comments']."');");

?>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>猫アンケート</title>
    <link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body>
    <h1>猫アンケート</h1>
    <div class="box">
    <p>ご協力ありがとうございました。</p>
    </div>
</body>
</html>