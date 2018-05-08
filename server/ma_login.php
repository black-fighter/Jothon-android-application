<?php
if(isset($_GET['form_login']))
{
	
	try {
		if(empty($_GET['mob_no'])) {
			throw new Exception('Mobile no can not be empty');
		}
		
		include('config.php');
		$num=0;
		
		session_start();

		mysql_query("SET NAMES UTF8");
		$query = mysql_query("select ma_id,ma_name from tbl_ma where ma_mob_no='$_GET[mob_no]'");

		if (mysql_num_rows($query) > 0){
			$result = mysql_fetch_assoc($query);
			$response[ "name" ] = $result['ma_name'];
			//$response[ "phone" ] = $result['sas_phone'];

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
	<title>Login Page ma</title>
</head>
<body>

<h2>Login ma</h2>

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
		<td></td>
		<td><input type="submit" value="লগইন" name="form_login"></td>
	</tr>
</table>
</form>

	
</body>
</html>