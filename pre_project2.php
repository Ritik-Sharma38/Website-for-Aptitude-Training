<html>    
    <head>    
        <title>Admin pannel</title>    
    </head>    
    <body>    
        <link href = "admin.css" type = "text/css" rel = "stylesheet" />    
        <h2>Admin login</h2>    
        <form name = "form1" action="modify.php" method = "post" enctype = "multipart/form-data" >    
            <div class = "contain">    
                <div class = "adminsign">    
                    <label>Admin Name:</label>    
                    <input type = "text" name = "fname" value = "" required/>    
                </div>        
                <div class = "adminsign">    
                    <label>Password:</label>    
                    <input type = "password" name = "pwd" value = "" required/>    
                </div>    
            </div>    
        </form>    
    </body>    
</html>
