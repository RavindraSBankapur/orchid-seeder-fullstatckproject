package com.orchid.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class UserEntity {
	
	@Column("FirstName")
	private String firstName;
	
	
}	
