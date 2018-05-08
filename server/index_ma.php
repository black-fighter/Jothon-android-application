<?php
if(isset($_POST['reg']))
{
    header('location: ma_registration.php');
}
if(isset($_POST['view']))
{
    header('location: view_HC.php');
}
if(isset($_POST['login']))
{
    header('location: ma_login.php');
}
if(isset($_POST['help']))
{
    header('location: help_insert.php');
}
if(isset($_POST['msg']))
{
    header('location: message.php');
}
?>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>মায়ের  ড্যাসবোর্ড </title>
</head>
<body>

<div align="center">
<h2>মায়ের  ড্যাসবোর্ড </h2>

<br>
<form action="" method="post">
    <table>
        <tr>
            <td></td>
            <td><input type="submit" value="রেজিস্টেশন" name="reg"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="লগইন" name="login"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="HC" name="view"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="জরুরী সাহায্য" name="help"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="বার্তা" name="msg"></td>
        </tr>
    </table>
</form>


</div>


</body>
</html>