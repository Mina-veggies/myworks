<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="utf-8">
    <title>内容確認</title>
    <link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body>
    
    <h1>回答内容確認</h1>
    <div class="box">
    <p>回答内容はこちらでよろしいでしょうか？
    <br>よろしければ送信ボタンを押してください。</p>
    
    
    <p>あなたの性別<br>
    <?php echo $_POST['sex']; ?>
    </p>
    
    <p>好きな猫の柄<br>
    <?php echo $_POST['comments']; ?>
    </p>
    
    <form action="index.html">
        <input type="submit" class="button1" value="修正する">
    </form>
    
    <form action="insert.php" method="post">
        <input type="submit" class="button2" value="回答する">
        <input type="hidden" value="<?php echo $_POST['sex']; ?>" name="sex">
        <input type="hidden" value="<?php echo $_POST['comments']; ?>" name="comments">
    </form>
    </div>
</body>
</html>