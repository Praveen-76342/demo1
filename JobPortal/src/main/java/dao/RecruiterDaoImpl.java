package dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import model.RecLogin;
import model.Recruiter;

public class RecruiterDaoImpl implements RecruiterDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void register(Recruiter recruiter) {
		String sql="insert into recruiter values(?,?,?,?,?)";
		String securepass=recruiter.getPassword();
		String hashpass=pass(securepass);
		jdbcTemplate.update(sql,new Object[] {recruiter.getUsername(), hashpass, recruiter.getCname(), recruiter.getNumber(), recruiter.getEmail()});
	}
	private String pass(String securepass) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(securepass);
		System.out.println(hashedPassword);
		return hashedPassword;
	}
	public Recruiter  validateRecruiter(RecLogin reclogin) {
		
		String sql="select * from recruiter where username='"+ reclogin.getUsername() + "'";
		List<Recruiter> recruiter=jdbcTemplate.query(sql,new RecruiterMapper());
		if (recruiter.size() > 0)
			return recruiter.get(0);
		else
			return null;
	
	}
}
class RecruiterMapper implements RowMapper<Recruiter>{

	public Recruiter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Recruiter recruiter =new Recruiter();
		recruiter.setUsername(rs.getString("username"));
		recruiter.setPassword(rs.getString("password"));
		recruiter.setCname(rs.getString("companyname"));
		recruiter.setNumber(rs.getString("contact"));
		recruiter.setEmail(rs.getString("email"));
		return recruiter;
	}
	

}

