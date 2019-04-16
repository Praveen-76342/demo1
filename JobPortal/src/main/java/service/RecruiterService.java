package service;

import model.RecLogin;
import model.Recruiter;

public interface RecruiterService {
	void register(Recruiter recruiter);
	Recruiter validateRecruiter(RecLogin reclogin);
}
