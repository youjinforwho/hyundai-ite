package library;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibraryController implements Initializable {
	@FXML private Button searchBtn;
	@FXML private TextField textField;
	@FXML private TextArea textArea;
	private Connection conn;
	
	public Connection jdbcConnect() {
		conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String myId = "root";
			String myPw = "drx2312##";
			String JDBC_URL = "jdbc:mysql://localhost:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; //(프로토콜 - jdbc:mysql + ip주소 + port 번호) + 관련 정보(DB이름) 
			conn = DriverManager.getConnection(JDBC_URL, myId, myPw);
		} catch(Exception e) {
			
		}
		return conn;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//conn = jdbcConnect();
		searchBtn.setOnAction(e -> {
			try {
				this.conn = jdbcConnect();
				String sql = "select * from book where btitle LIKE '%" + textField.getText() + "%'";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					String title = rs.getString("btitle");
					textArea.appendText(title + "\n");
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		});
		
	}
	
	
}
