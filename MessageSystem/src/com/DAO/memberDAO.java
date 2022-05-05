package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.VO.memberVO;

public class memberDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void conn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

	public ArrayList<memberVO> selectAll() { // ȸ�� ���� ��� �ҷ����°�

		ArrayList<memberVO> al = new ArrayList<memberVO>();

		try {
			conn();

			String sql = "select email, tel, address from message_member";
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery(); //

			while (rs.next()) { // ���̺�� �ִ� �����͸� �д´�

				String getEmail = rs.getString(1);
				String getTel = rs.getString(2);
				String getAddress = rs.getString(3);

				memberVO vo = new memberVO(getEmail, getTel, getAddress);
				al.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return al;
	}

	public int delete(String email) { // �̸��ϰ����� ȸ�� ���� ����

		int cnt = 0;

		try {

			conn();

			// Ư�� �̸���(�Ķ����) ������ �ִ� �� ����
			String sql = "delete from message_member where email = ?"; // �̸��ϻ���
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();
		}

		return cnt;

	}

	// LoginCon -> login()

	public memberVO login(String email, String pw) { // �α���

		memberVO vo = null;

		try {
			conn();

			String sql = "select * from message_member where email = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			rs = psmt.executeQuery();

			if (rs.next()) {

				String getemail = rs.getString(1);
				String getpw = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				String date = rs.getString(5);

				if (pw.equals(getpw)) {
					vo = new memberVO(email, tel, address);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();
		}

		return vo;

	}

	// JoinCOn -> join()

	public int join(String email, String pw, String tel, String address) { // ���� memberVO�� �����ڸ� ����ų� �Ű������� �ְų� �ؾ���

		int cnt = 0;

		try {
			conn();

			String sql = "insert into message_member values(?,?,?,?,sysdate)";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			psmt.setString(2, pw);
			psmt.setString(3, tel);
			psmt.setString(4, address);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			close();
		}
		return cnt;

	}

	// UpdateCon -> update()

	public int update(String email, String pw, String tel, String address) {

		int cnt = 0;

		try {
			conn();

			String sql = "update message_member set pw = ?, tel = ?, address = ? where email = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, tel);
			psmt.setString(3, address);
			psmt.setString(4, email);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();
		}

		return cnt;
	}

	public boolean idCheck(String email) {

		boolean check = false;

		try {

			conn();

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			String sql = "select * from message_member where email = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);

			rs = psmt.executeQuery();

			if (rs.next()) { // email�� �ִ� ��� -> ����� �� ���� email(true ��ȯ)
				check = true;

			} else { // email�� ���� ��� -> ����� �� �ִ� email (false ��ȯ)
				check = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();
		}

		return check;

	}

}
