<?php
/**
 * Created by PhpStorm.
 * User: HP
 * Date: 01-Apr-16
 * Time: 6:50 AM
 */

if(isset($_POST['form_login1']))
{
    header('location: index_worker.php');
}
if(isset($_POST['form_login2']))
{
    header('location: index_ma.php');
}

?>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>যতন ড্যাসবোর্ড</title>
</head>
<body>
<div align="center">
<h2>যতন ড্যাসবোর্ড</h2>

<br>
<form action="" method="post">
    <table>
        <tr>
            <td></td>
            <td><input type="submit" value="স্বাস্থ্যকর্মী" name="form_login1"></td>
        </tr>
        <tr>
            <td></td>
            <td align="center"><input type="submit" value="মা" name="form_login2"></td>
        </tr>
    </table>
</form>

</div>

</body>
</html>