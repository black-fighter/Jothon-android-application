<?php
include('config.php');
include ('sms.php');

if(isset($_GET['form1'])) {

	try {
	
		if(empty($_GET['ma_name'])) {
			throw new Exception('Name can not be empty');
		}
		
		if(empty($_GET['ma_mob_no'])) {
			throw new Exception('Mobile no can not be empty');
		}
		
		if(empty($_GET['ma_boyos'])) {
			throw new Exception('Boyos no can not be empty');
		}

		if(empty($_GET['ma_bl_gr'])) {
			throw new Exception('Blood group can not be empty');
		}
		
		if(empty($_GET['ma_ba_no'])) {
			throw new Exception('Baby no can not be empty');
		}
		
		if(empty($_GET['ma_division'])) {
			throw new Exception('Division can not be empty');
		}
		
		if(empty($_GET['ma_zilla'])) {
			throw new Exception('Zilla can not be empty');
		}
		
		if(empty($_GET['ma_upozilla'])) {
			throw new Exception('Upozilla can not be empty');
		}
		
		if(empty($_GET['ma_wei'])) {
			throw new Exception('Weight can not be empty');
		}
		
		if(empty($_GET['ma_gorvabosthar_kotodin'])) {
			throw new Exception('Gorvabosthar somoykal can not be empty');
		}
		
		if(empty($_GET['ma_s_boyos'])) {
			throw new Exception('Sontaner boyos can not be empty');
		}
		
		if(empty($_GET['ma_s_wei'])) {
			throw new Exception('Sontaner weight can not be empty');
		}
		
		if(empty($_GET['ma_s_bl_gr'])) {
			throw new Exception('Sontaner weight can not be empty');
		}
		
		mysql_query("SET NAMES UTF8");
		$result = mysql_query("insert into tbl_ma (ma_name,ma_mob_no,ma_boyos,ma_bl_gr,ma_ba_no,ma_division,ma_zilla,ma_upozilla,ma_wei,ma_gorvabosthar_kotodin,ma_s_boyos,ma_s_wei,ma_s_bl_gr) values('$_GET[ma_name]','$_GET[ma_mob_no]','$_GET[ma_boyos]','$_GET[ma_bl_gr]','$_GET[ma_ba_no]','$_GET[ma_division]','$_GET[ma_zilla]','$_GET[ma_upozilla]','$_GET[ma_wei]','$_GET[ma_gorvabosthar_kotodin]','$_GET[ma_s_boyos]','$_GET[ma_s_wei]','$_GET[ma_s_bl_gr]') ");
		
		$success_message = 'আপনার রেজিস্ট্রেশন সফলভাবে সম্পন্ন হয়েছে ।';

		$senderName='Joton';
		$smsText='Jotoner%20sathe%20jotone%20thakuk%20apnar%20sontan%20%20-eMotion';//Jotone%20registration%20korar%20jonno%20dhonnobad.
		$receiverNo='880'.$_GET[ma_mob_no];
		$res=sendSMS($senderName,$smsText,$receiverNo);


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

		else echo $res;
	
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

<h2>রেজিস্ট্রেশন পেজ</h2>

<?php  
if(isset($error_message)) {echo $error_message;}
if(isset($success_message)) {echo $success_message;}
?>

<br>

<form action="" method="get">
<table>
	<tr>
		<td>মায়ের নামঃ </td>
		<td><input type="text" name="ma_name"></td>
	</tr>
	<tr>
		<td>মোবাইল নাম্বারঃ</td>
		<td><input type="text" name="ma_mob_no"></td>
	</tr>
	<tr>
		<td>মায়ের বয়সঃ</td>
		<td><input type="text" name="ma_boyos"></td>
	</tr>
	<tr>
		<td>মায়ের ব্লাড গ্রুপঃঃ</td>
		<td><input type="text" name="ma_bl_gr"></td>
	</tr>
	<tr>
		<td>কত নাম্বার শিশুঃ</td>
		<td><input type="text" name="ma_ba_no"></td>
	</tr>
	<tr>

		<td>বিভাগঃ</td>
		<td><input type="text" name="ma_division"></td>
	</tr>
	<tr>
		<td>জেলাঃ</td>
		<td><input type="text" name="ma_zilla"></td>
	</tr>
	<tr>
		<td>উপজেলাঃ</td>
		<td><input type="text" name="ma_upozilla"></td>
	</tr>
	<tr>
		<td>মায়ের ওজনঃ</td>
		<td><input type="text" name="ma_wei"></td>
	</tr>
	<tr>
		<td>গর্ভধারণের সময়কালঃ</td>
		<td><input type="text" name="ma_gorvabosthar_kotodin"></td>
	</tr>
	<tr>
		<td>সন্তানের এর বয়সঃ</td>
		<td><input type="text" name="ma_s_boyos"></td>
	</tr>
	<tr>
		<td>সন্তানের ওজনঃ</td>
		<td><input type="text" name="ma_s_wei"></td>
	</tr>
	<tr>
		<td>সন্তানের ব্লাড গ্রুপঃ</td>
		<td><input type="text" name="ma_s_bl_gr"></td>
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