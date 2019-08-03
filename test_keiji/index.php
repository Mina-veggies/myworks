<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>猫掲示板</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    
    <?php
    
    mb_internal_encoding("utf8");
    $pdo = new PDO("mysql:dbname=test_mina;host=localhost;","root","mysql");
    
    $stmt = $pdo -> query("select * from keijiban");
    
    ?>
        
        
    <header>
        <div class="title">猫の掲示板</div>
        <div class="menu">
            <ul>
                <li>ねこ</li>
                <li>cat</li>
                <li>猫</li>
            </ul>
        </div>
    </header>
    <main>
        <div class="left">
            <h1>猫の掲示板</h1>
                <div class="box">
                    <h2>入力はこちら</h2>
                <form method="post" action="insert.php">
                    <div>
                        <label>ハンドルネーム</label>
                        <br><input type="text" class="text" size="35" name="name">
                    </div>
                    <div>
                        <label>タイトル</label>
                        <br><input type="text" class="text" size="35" name="title">
                    </div>
                    <div>
                        <label>コメント</label>
                        <br><textarea cols="60" rows="7" name="comments"></textarea>
                    </div>
                    <div>
                        <input type="submit" class="submit" value="投稿">
                    </div>
                </form>
                    <img src="./img/cat13.jpg">
                </div>
        
        <?php
            
        while($row = $stmt->fetch()) {
            
        echo "<div class='kiji'>";
        echo "<h3 class='tit'>".$row['title']."</h3>";
        echo "<div class='contents'>";
        echo $row['comments'];
        echo "<div class='handlename'> posted by ".$row['name']."</div>";
        echo "</div>";
        echo "</div>";
        
        }    
        ?>
            
        </div>
    </main>
    <footer>
        copyright © tmt | company veggies provides cat info.
    </footer>
</body>
</html>