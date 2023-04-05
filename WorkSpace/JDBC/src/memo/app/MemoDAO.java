package memo.app;

import java.sql.*;
import common.util.*;
import java.util.*;
/**
 * @author a
 * 영속성 계층(Persistence Layer)에 속함
 * DAO(Date Access Object) : 데이터베이스에 접근해서 CRUD의 로직을 수행하는 객체
 * => Model에 속함
 */
public class MemoDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * 한줄 메모장에 insert문을 수행하는 메서드
	 */
	public int insertMemo(MemoVO memo) throws SQLException{
		try {
			con=DBUtil.getCon();
			//String : 불변성(immutable) : 원본은 불변함 => 편집할 경우 새로운 객체를 만들고 기존 객체에 대한 포인터를 회수해 새로운 객체를 가리킨다
	/*		String sql="insert into";
					sql += " memo values(";
					sql += ")"; */
			//StringBuffer, StringBuilder : 문자열 편집 작업이 가능한 클래스
			//								문자열을 메모리 버퍼에 넣고 수정, 삽입, 삭제 등을 수행함
			StringBuilder buf=new StringBuilder("insert into memo(no, name, msg, wdate)")
							.append(" values(memo_seq.nextval, ?, ?, sysdate)");
			String sql=buf.toString();
			
			ps=con.prepareStatement(sql);
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			
			int n=ps.executeUpdate();
			return n;
		}finally {
			//db 연결자원 반납
			close();
		}
	}//-------------------------
	
	/**
	 * DB관련한 자원들을 반납하는 메서드
	 */
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}//////////////////////////////
