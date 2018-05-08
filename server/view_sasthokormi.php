<?php
include('config.php');


$result = mysql_query("select * from tbl_sasthokormi");

$json_response = array();


$result_length = mysql_num_rows($result);

for($i = 0; $i < $result_length; $i++)
{
	$row = mysql_fetch_array( $result , MYSQL_ASSOC);
	$row_array ['Name' ] = $row [ 'sas_name' ];
	$row_array ['Mobile' ] = $row [ 'sas_phone' ];

//push the values in the array
	array_push ( $json_response , $row_array );
}
echo '{"Workers":' ;
echo json_encode( $json_response );
echo "}";

?>