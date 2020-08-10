import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




	public class RegisterDao {
		
		private String dburl = "jdbc:mysql://localhost:3306/userdb2";
		private String dbname ="root";
		private String dbpassword ="root";
		private String dbdriver ="com.mysql.jdbc.Driver";


		public void loadDriver(String dbdriver) {
			try {
				Class.forName(dbdriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public Connection getConnection() {
			Connection con = null;
			try {
			con = DriverManager.getConnection(dburl,dbname,dbpassword);

			}catch (SQLException e) {
				// TODO: handle exception
		e.printStackTrace();
			}
			
		return con;
		}
		
		public boolean insert(Member member)  {
			
			loadDriver(dbdriver);
			Connection con =getConnection();
			boolean results = true;
			String sql = "insert into userdb2.sample2 values(?,?,?)";
		PreparedStatement pstm;
		try {
			
			
			pstm = con.prepareStatement(sql);

			pstm.setString(1, member.getUname());
			pstm.setString(2, member.getEmail());
			pstm.setString(3, member.getPassword());
			
		pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

			
			return results;
		}


		

	
}
