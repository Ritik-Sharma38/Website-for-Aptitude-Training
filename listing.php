<?php    
    
include "connect.php";    
    
if(isset($_GET['id'])){    
$sql = "delete from adminreg where fname = '".$_GET['fname']."'";    
$result = mysql_query($sql);    
}    
    
$sql = "select * from adminreg";    
$result = mysql_query($sql);    
?>    
<html>    
    <body>    
        <table width = "100%" border = "1" cellspacing = "1" cellpadding = "1">    
            <tr>    
                <td>Admin Name:</td>    
                <td>Password:</td>        
                <td colspan = "2">Action</td>    
            </tr>    
        </table>    
    </body>    
</html>   