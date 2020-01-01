package com.capgemini.empspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.empspringboot.dto.EmployeeAddressBean;
import com.capgemini.empspringboot.dto.EmployeeBean;
import com.capgemini.empspringboot.exception.EmployeeException;
import com.capgemini.empspringboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public EmployeeBean auth(String email, String password) {
		EmployeeBean bean = repository.findByEmail(email);
		if(bean!=null) {
			if(encoder.matches(password, bean.getPassword())) {
				return bean;
			} else {
				throw new EmployeeException("Enter valid password");
			} 
		} else {
			throw new EmployeeException("Email does'nt exist");
		}
	}

	@Override
	public boolean register(EmployeeBean bean) {
		bean.setPassword(encoder.encode(bean.getPassword()));
		for(EmployeeAddressBean addressBean : bean.getOther()) {
			addressBean.setBean(bean);
		}
		repository.save(bean);
		return true;
	}

	@Override
	public List<EmployeeBean> getAllEmployees(String key) {

		return repository.findByKey(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		repository.changePassword(id, encoder.encode(password));
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		repository.deleteById(id);
		return true;
	}

}
