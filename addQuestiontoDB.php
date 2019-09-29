<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "adminlogin";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
$qId=isset($_GET["id"]);
$question=isset($_GET["Question"]);
$option1=isset($_GET["op1"]);
$option2=isset($_GET["op2"]);
$option3=isset($_GET["op3"]);
$option4=isset($_GET["op4"]);


$sql = INSERT INTO `questionbanknew`(`qId`, `question`, `op1`, `op2`, `op3`, `op4`) VALUES (,'?','?','?','?','?')
if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>