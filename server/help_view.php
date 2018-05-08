<?php

include('config.php');
header('Content-Type: application/json; charset=utf-8');
//header ('Content-type: text/html; charset=utf-8');

mysql_query("SET NAMES UTF8");
$query = "select * from tbl_help";

$result = mysql_query($query) or die('Query failed: ' . mysql_error());

$json_response = array();


$result_length = mysql_num_rows($result);

for($i = 0; $i < $result_length; $i++)
{
    $row = mysql_fetch_array( $result , MYSQL_ASSOC);
    $row_array ['Name' ] = $row [ 'ma_name' ];
    $row_array ['Msg' ] = $row [ 'msg' ];
    $row_array ['Time' ] = $row [ 'ts' ];


//push the values in the array
    array_push ( $json_response , $row_array );
}
echo '{"Help":' ;
echo json_encode( $json_response , JSON_UNESCAPED_UNICODE );
echo "}";
?>

