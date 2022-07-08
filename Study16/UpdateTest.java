package mysql_jdbc;

public class UpdateTest extends DBConn{

	public UpdateTest() {
		
	}
	public void UpdateStart() {
		try {
			//1. ����̺�ε�
			//2. DB����
			getConn();
			//3. PreparedStatement
			sql = "Update member set depart=?, phone=?, email=? where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "������");
			pstmt.setString(2, "010-3030-0989");
			pstmt.setString(3, "lee2@naver.com");
			
			pstmt.setInt(4, 2222);
			
			//4. ����
			int cnt = pstmt.executeUpdate();// insert, update, delete
			if(cnt>0) {
				System.out.println("ȸ�������� �����Ǿ����ϴ�.");
			}else {
				System.out.println("ȸ�������� �������� ���߽��ϴ�.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			getClose();
		}
	}
	public static void main(String[] args) {
		new UpdateTest().UpdateStart();

	}

}
