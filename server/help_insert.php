<?php
if(isset($_GET['form_help'])) {
    include('config.php');

    $ma_name = $_GET['ma_name'];
    $msg = $_GET['msg'];
    $res = '';
    mysql_query("SET NAMES UTF8");
    $result = mysql_query("INSERT INTO tbl_help (ma_name, msg,ts) VALUES('$ma_name','$msg',CURRENT_TIMESTAMP )");
    if (($_GET['system']) == 1) {
        if ($result) {
            $response["success"] = 1;
        } else {
            $response["success"] = 0;
        }
        die(json_encode($response));
    }
    else {
        if ($result) {
            $res = 'Insert successful';
        } else {
            $res = 'Insert failed';
        }

    }
}
?>



<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Help incert page</title>
</head>
<body>

<h2>Insert Help</h2>

<?php
if(isset($res))
{
    echo $res;
}
?>
<br>
<form action="" method="get">
    <table>
        <tr>
            <td>মায়ের নাম</td>
            <td><input type="text" name="ma_name"></td>
        </tr>
        <tr>
            <td>মেসেজ</td>
            <td><input type="text" name="msg"></td>
        </tr>
        <tr>
            <td></td><input type="hidden" name="system" value="0">
            <td><input type="submit" value="হেল্প" name="form_help"></td>
        </tr>
    </table>
</form>


</body>
</html>
