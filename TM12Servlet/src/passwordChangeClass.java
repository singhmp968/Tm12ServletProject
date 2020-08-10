import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class passwordChangeClass {

	
	private String dburl = "jdbc:mysql://localhost:3306/userdb2";
	private String dbname ="root";
	private String dbpassword ="root";
	private String dbdriver ="com.mysql.jdbc.Driver";

	
	public static boolean passChange(String email,String newPass ) 
	{
	try {

        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

        //creating connection with the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb2","root","root");
        PreparedStatement ps = con.prepareStatement("update userdb2.sample2 set password=? where email=?");
        ps.setString(1, newPass);
        ps.setString(2, email);
        ps.executeUpdate();
        return true;
	
}catch(Exception e) {
    e.printStackTrace();

}
 return false;                
}   
	
}
