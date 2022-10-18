package denemeler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;


public class main {
	
	/*mysql veri tabani ile eclipse derleyicisini birbirine bagladigimiz kod*/
	static Connection myConn;
	static Statement myStat;
	

	static ResultSet yap() {
		 ResultSet myRs = null;
		try {
			
			 myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fifo","root","1234");
			 myStat = (Statement) myConn.createStatement();
			 myRs = myStat.executeQuery("select * from urunler order by tarih asc");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myRs;
		
}
	
	/*sistemdeki sorgu ekrani icin sql tabanindan bilgileri cekmemizi saglayan kod*/

static void ekle(String sql_sorgu) {
		
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	  

static void update(String sql_sorgu) {
	try {
		myStat.executeUpdate(sql_sorgu);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	static void sil(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		Resultset myRs = null;
		
		try {
			myRs = (Resultset) myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return (ResultSet) myRs;
	}
	
	}



