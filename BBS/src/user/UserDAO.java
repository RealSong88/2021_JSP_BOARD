package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
//			String dbURL= "jdbc:mysql://localhost:33060/BBS";
//			String dbID = "root";
//			String dbPassword = "root";
//			Class.forName("com.mysql.jdbc.Driver");
			
			// 프로젝트 폴더 우클릭 properties >> java build path >> 디비에 맞는 connector jar 추가
			String dbURL= "jdbc:mariadb://140.238.19.235:3306/bbs";
			String dbID = "admin";
			String dbPassword = "admin";
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "select userPassword from user where userID = ?";
		try {
//			System.out.println("[" + userID + "]");
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
//					System.out.println("쿼리 날렸을때 겟 값" + rs.getString(1));
//					System.out.println("요청된 비밀번호 >> " + userPassword);
					return 1; //로그인 성공
				} else
					return 0; // 비밀번호 불일치
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return -2; // 데이터베이스 오류
	}
	
	public int join(User user) {
		String SQL = "insert into user values (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; // 데이터베이스오류
	}
}
