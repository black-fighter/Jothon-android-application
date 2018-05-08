<?php
//header("Content-Type: text/html; charset=utf-8");
function sendSMS($senderName,$smsText,$receiverNo)
{
    $ch = curl_init();

   $url='http://193.105.74.59/api/v3/sendsms/plain?user=KibiBytes&password=2zzuM02s&sender='.$senderName.'&SMSText='.$smsText.'&GSM='.$receiverNo.'&DataCoding=8&encoding=UTF-8';
   // $url='http://193.105.74.59/api/v3/sendsms/plain?user=KibiBytes&password=2zzuM02s&sender='.$senderName.'&binary='.$smsText.'&GSM='.$receiverNo.'&DataCoding=8&encoding=UTF-8';


 echo 'Loading on: '.$url . "<br><br>";
    curl_setopt($ch,CURLOPT_URL,$url);
    curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
//  curl_setopt($ch,CURLOPT_HEADER, false);
 //   curl_setopt($ch, CURLOPT_ENCODING, 'UTF-8');

    $output=curl_exec($ch);
 
    curl_close($ch);
    return $output;
}
?>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>SMS Sender</title>
</head>
<body>
<div align="center">
<h2>SMS Sender</h2>

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
            <td>সেন্ডার নেম</td>
            <td><input type="text" name="senderName"></td>
        </tr>
        <tr>
            <td>রিসিভার নাম্বার</td>
            <td><input type="text" name="receiverNo"></td>
        </tr>
        <tr>
            <td>মেসেজ</td>
            <td><input type="text" name="smsText">
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="পাঠান " name="form_sms"></td>
        </tr>
    </table>
</form>

</div>

<?php
if(isset($_GET['form_sms']))
{
    echo '<div align="center">';
    echo '<h2>SMS Result</h2>';

    $senderName=$_GET['senderName'];
        $smsText=$_GET['smsText'];
            $receiverNo=$_GET['receiverNo'];

    $SMSResult = sendSMS($senderName,$smsText,$receiverNo);

    $xml=simplexml_load_string($SMSResult) or die("Error: Cannot create object");
    echo 'Result in txt: '.$xml. "<br>";
    $status = $xml->result[0]->status;
    echo 'SMS Status:'. $status . "<br>";
    echo 'SMS ID:'.$xml->result[0]->messageid . "<br>";
    echo 'SMS Receiver:'.$xml->result[0]->destination. "<br>";
    echo "<br><br>";


    echo "<h3>Total result: ";
    if ($status == -1)
    echo 'Sending failed.SEND_ERROR.Currently not in use';
    else if ($status == -2)
    echo 'Sending failed.NOT_ENOUGHCREDITS';
    else if ($status == -3)
    echo 'Sending failed.NETWORK_NOTCOVERED';
    else if ($status == -4)
    echo 'Sending failed.SOCKET_EXCEPTION';
    else if ($status == -5)
        echo 'Sending failed.INVALID_USER_OR_PASS';
    else if ($status == -6)
        echo 'Sending failed.MISSING_DESTINATION_ADDRESS';
    else if ($status == -7)
        echo 'Sending failed.MISSING_SMSTEXT';
    else if ($status == -8)
        echo 'Sending failed.MISSING_SENDERNAME';
    else if ($status == -9)
        echo 'Sending failed.DESTADDR_INVALIDFORMAT';
    else if ($status == -10)
        echo 'Sending failed.MISSING_USERNAME';
    else if ($status == -11)
        echo 'Sending failed.MISSING_PASS';
    else if ($status == -12)
        echo 'Sending failed.MISSING_SENDERNAME';
    else if ($status == -13)
        echo 'Sending failed.INVALID_DESTINATION_ADDRESS';
    else if ($status == 0 )
        echo 'Sending successful';
    else
        echo 'Sending unknown.unexpected response';
    echo "</h3></div></body></html>";
}
?>