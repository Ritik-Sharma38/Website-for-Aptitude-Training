/**
 * The constructor function of admin class
 * We do just the session start
 * It is necessary to start the session before actually storing any value
 * to the super global $_SESSION variable
 */
public function __construct() {
    session_start();
 
    //store the absolute script directory
    //note that this is not the admin directory
    self::$abs_path = dirname(dirname(__FILE__));
 
    //initialize the post variable
    if($_SERVER['REQUEST_METHOD'] == 'POST') {
        $this->post = $_POST;
        if(get_magic_quotes_gpc ()) {
            //get rid of magic quotes and slashes if present
            array_walk_recursive($this->post, array($this, 'stripslash_gpc'));
        }
    }
 
    //initialize the get variable
    $this->get = $_GET;
    //decode the url
    array_walk_recursive($this->get, array($this, 'urldecode'));
}