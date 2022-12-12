package com.mysecurity.app08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.cj.xdevapi.PreparableStatement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
public class MemberTest {
	@Autowired
	private PasswordEncoder pwencoder;
	@Autowired
	private DataSource ds;
	
	@Test
	public void testInsertMethod() {
		String sql="insert into tbl_member(userid, userpw, username) values(?,?,?)";
		
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement ps =null;
			
			try {
				con=ds.getConnection();
				ps=con.prepareStatement(sql);
				ps.setString(2, pwencoder.encode("pw"+i));
				if(i<80) {
					ps.setString(1, "user"+i);
					ps.setString(3, "�Ϲݻ����"+i);
				}else if(i<90) {
					ps.setString(1, "manager"+i);
					ps.setString(3, "���"+i);
				}else {
					ps.setString(1, "admin"+i);
					ps.setString(3, "������"+i);
				}
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(ps!=null)ps.close();
					if(con!=null)con.close();
				}catch (SQLException s) {
					s.printStackTrace();
				}
			}
		}
	}//testInsertMethod
	
	@Test
	public void testInsertAuth() {
		String sql="insert into tbl_member_auth(userid, auth) values(?,?)";
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement ps =null;
			
			try {
				con=ds.getConnection();
				ps=con.prepareStatement(sql);
				if(i<80) {
					ps.setString(1, "user"+i);
					ps.setString(2, "ROLE_USER");
				}else if(i<90) {
					ps.setString(1, "manager"+i);
					ps.setString(2, "ROLE_MANAGER");
				}else {
					ps.setString(1, "admin"+i);
					ps.setString(2, "ROLE_ADMIN");
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(ps!=null)ps.close();
					if(con!=null)con.close();
				}catch (SQLException s) {
					s.printStackTrace();
				}					
			}
		}	
	}
}