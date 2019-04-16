package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.RecruiterDao;
import model.RecLogin;
import model.Recruiter;

public class RecruiterServiceImpl implements RecruiterService {

	@Autowired
	RecruiterDao recruiterDao;
	public void register(Recruiter recruiter) {
		// TODO Auto-generated method stub
		recruiterDao.register(recruiter);
	}

	
	public Recruiter validateRecruiter(RecLogin reclogin) {
		// TODO Auto-generated method stub
		 return recruiterDao.validateRecruiter(reclogin);
	}

	

}
