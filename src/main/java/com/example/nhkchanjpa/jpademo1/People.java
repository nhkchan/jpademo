package com.example.nhkchanjpa.jpademo1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="people")
public class People {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue
	@Column(name="person_id", nullable = true, unique = false)
	private long id;
	@Column(name="first_name", nullable = true, unique = false)
	private String fname;
	@Column(name="last_name", nullable = true, unique = false)
	private String lname;
	
	protected People() {}
	
	public People(long id,String firstName, String lastName) {
		this.id = id;
        this.fname = firstName;
        this.lname = lastName;
	}
	
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, fname, lname);
    }

	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return fname;
	}

	public String getLastName() {
		return lname;
	}
	
}
