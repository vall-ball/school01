package ru.vallball.school01.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "classes")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Pattern(regexp = "^[1]?\\d{1}[А-Я]{1}$")
	private String name;

	@NotNull
	@OneToOne
	@JoinColumn(name = "teacher_id")
	User teacher;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable (
	        name="class_students",
	        joinColumns={ @JoinColumn(name="class_id", referencedColumnName="id") },
	        inverseJoinColumns={@JoinColumn(name="student_id", referencedColumnName="id")}
	    )
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}
	
	

}
