<?php

include('config.php');


$query = "select * from tbl_ma";
$result = mysql_query($query) or die('Query failed: ' . mysql_error());

$json_response = array();


$result_length = mysql_num_rows($result);

for($i = 0; $i < $result_length; $i++)
{
    $row = mysql_fetch_array( $result , MYSQL_ASSOC);
    $row_array ['Name' ] = $row [ 'ma_name' ];
    $row_array ['Mobile' ] = $row [ 'ma_mob_no' ];
    $row_array ['Bacca' ] = $row [ 'ma_ba_no' ];
    $row_array ['Division' ] = $row [ 'ma_division' ];
    $row_array ['District' ] = $row [ 'ma_zilla' ];
    $row_array ['Upozila' ] = $row [ 'ma_upozilla' ];
    $row_array ['Weight' ] = $row [ 'ma_wei' ];
    $row_array ['CDays' ] = $row [ 'ma_gorvabosthar_kotodin' ];
    $row_array ['ChildAge' ] = $row [ 'ma_s_boyos' ];
    $row_array ['ChildWeight' ] = $row [ 'ma_s_wei' ];


//push the values in the array
    array_push ( $json_response , $row_array );
}
echo '{"Mothers":' ;
echo json_encode( $json_response );
echo "}";

?>

