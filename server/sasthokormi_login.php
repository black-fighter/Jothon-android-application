<?php
if(isset($_GET['form_login']))
{
	
	try {
	
		
		if(empty($_GET['mob_no'])) {
			throw new Exception('Mobile no can not be empty');
			$response[ "message" ] = "Mobile no  can not be empty";
		}
		
		if(empty($_GET['password'])) {
			throw new Exception('Password can not be empty');
			$response[ "message" ] = "Password can not be empty";
		}
	
		include('config.php');
		$num=0;
		
		session_start();
		
		mysql_query("SET NAMES UTF8");
		$query = mysql_query("select sas_id,sas_name,sas_phone from tbl_sasthokormi where sas_phone='$_GET[mob_no]' and sas_password='$_GET[password]'");

		if (mysql_num_rows($query) > 0){
		$result = mysql_fetch_assoc($query);

			$response[ "name" ] = $result['sas_name'];
			$response[ "phone" ] = $result['sas_phone'];

			if(($_GET['system'])== 1)
			{

				if($result)
				{
					$response[ "success" ] = 1;
				}
				else
				{
					$response[ "success" ] = 0;
				}
				die(json_encode( $response ));
			}
			else
			{

				echo 'Log in successful';
			}


		}
	
		else
		{
			if(($_GET['system'])== 1)
			{
				$response[ "success" ] = 0;
				die(json_encode( $response ));
			}
			throw new Exception('Invalid Username and/or password');
		}
	
	
	
	}
	
	catch(Exception $e) {
		$error_message = $e->getMessage();
	}
	
}

?>


<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Login Page sasthokormi</title>
</head>
<body>

<h2></h2>

<?php
if(isset($error_message))
{
	echo $error_message;
}
?>
<br>
<form action="" method="get">
<table>
	<tr>
		<td>মোবাইল নাম্বারঃ</td>
		<td><input type="text" name="mob_no"></td>
	</tr>
	<tr>
		<td>পাসওয়ার্ডঃ </td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td></td>
		<input type="hidden" name="system" value="0">
		<td><input type="submit" value="লগইন" name="form_login"></td>
	</tr>
</table>
</form>


	
</body>
</html>