<?php
function sendSMS($senderName,$smsText,$receiverNo)
{
    $ch = curl_init();

    $url='http://193.105.74.59/api/v3/sendsms/plain?user=KibiBytes&password=2zzuM02s&sender='.$senderName.'&SMSText='.$smsText.'&GSM='.$receiverNo.'&DataCoding=8&encoding=UTF-8';

//    echo 'Loading on: '.$url . "<br><br>";
    curl_setopt($ch,CURLOPT_URL,$url);
    curl_setopt($ch,CURLOPT_RETURNTRANSFER,true);
//  curl_setopt($ch,CURLOPT_HEADER, false);
    //   curl_setopt($ch, CURLOPT_ENCODING, 'UTF-8');

    $output=curl_exec($ch);

    curl_close($ch);
    return 'Loaded on: '.$url . "<br><br>";
}
?>