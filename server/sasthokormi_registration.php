<?php
include('config.php');
if(isset($_GET['form1'])) {

	try {
	
		if(empty($_GET['sas_name'])) {
			throw new Exception('Name can not be empty');
			$response[ "message" ] = "Name can not be empty";
		}
		
		if(empty($_GET['sas_division'])) {
			throw new Exception('Division can not be empty');
			$response[ "message" ] = "Division can not be empty";
		}
		
		if(empty($_GET['sas_zilla'])) {
			throw new Exception('Zilla can not be empty');
			$response[ "message" ] = "Zilla can not be empty";
		}
		
		if(empty($_GET['sasthokendro_name'])) {
			throw new Exception('Sasthokendro name can not be empty');
			$response[ "message" ] = "Sasthokendro can not be empty";
		}
		
		if(empty($_GET['sas_phone'])) {
			throw new Exception('Phone can not be empty');
			$response[ "message" ] = "Phone can not be empty";
		}
		
		if(empty($_GET['sas_password'])) {
			throw new Exception('Password can not be empty');
			$response[ "message" ] = "Password can not be empty";
		}
		
		mysql_query("SET NAMES UTF8");
		$result = mysql_query("insert into tbl_sasthokormi (sas_name,sas_division,sas_zilla,sasthokendro_name,sas_phone,sas_password) values('$_GET[sas_name]','$_GET[sas_division]','$_GET[sas_zilla]','$_GET[sasthokendro_name]','$_GET[sas_phone]','$_GET[sas_password]') ");
		//$result2 =mysql_query("select sas_id from tbl_sasthokormi where sas_phone='$_GET[sas_name]') ");
		$success_message = 'আপনার রেজিস্ট্রেশন সফলভাবে সম্পন্ন হয়েছে ।';

		if (($_GET['system'])== 1)
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
	<title>Registration Page</title>
</head>
<body>

<h2>স্বাস্থ্যকর্মীর  রেজিস্ট্রেশন পেজ</h2>

<?php  
if(isset($error_message)) {echo $error_message;}
if(isset($success_message))
{echo $success_message;
	echo 'Go to <a href="index_worker.php">index of worker </a>';
}
if(isset($system_output)) {echo 'System output to android'. $success_message;}
?>

<br>

<form action="" method="get">
<table>
	<tr>
		<td>নাম :  </td>
		<td><input type="text" name="sas_name"></td>
	</tr>
	<tr>
		<td>বিভাগঃ</td> 
		<td><input type="text" name="sas_division"></td>
	</tr>
	<tr>
		<td>জেলাঃ</td> 
		<td><input type="text" name="sas_zilla"></td>
	</tr>
	<tr>
		<td>স্বাস্থ্যকেন্দ্রঃ</td> 
		<td><input type="text" name="sasthokendro_name"></td>
	</tr>
	<tr>
		<td>মোবাইল নাম্বারঃ</td>
		<td><input type="text" name="sas_phone"></td>
	</tr>
	<tr>
		<td>পাসওয়ার্ডঃ</td> 
		<td><input type="text" name="sas_password"></td>
	</tr>
	<tr>
		<td></td>
		<input type="hidden" name="system" value=0>
		<td><input type="submit" value="রেজিস্ট্রেশন করুন" name="form1"></td>
	</tr>
</table>
</form>


<br>
	
</body>
</html>