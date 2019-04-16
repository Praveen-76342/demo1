package dao;

import model.RecLogin;
import model.Recruiter;

public interface RecruiterDao {
	void register(Recruiter recruiter);
	Recruiter validateRecruiter(RecLogin reclogin);
}
