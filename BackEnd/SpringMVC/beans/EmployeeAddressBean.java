package com.cap.empspringmvc.beans;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employee_address_info")
public class EmployeeAddressBean {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String addressType;
	@Column
	private String address1;
	@Column
	private String address2;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="eid")
	private EmployeeBean bean;
}
