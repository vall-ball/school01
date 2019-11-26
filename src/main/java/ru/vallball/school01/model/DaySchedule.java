package ru.vallball.school01.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "day_schedules")
public class DaySchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private DayOfWeek dayOfWeek;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "day_schedule_id")
	private List<Lesson> lessons = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	
	

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}



	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}



	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	
	

	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name =
	 * "time_subject",joinColumns=@JoinColumn(name="day_schedule_id"))
	 * 
	 * @MapKeyColumn(name="time")
	 * 
	 * @JoinColumn(name = "subject_id")
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "day_schedule_subject", joinColumns = {@JoinColumn(name =
	 * "day_schedule_id", referencedColumnName="id")},
	 * inverseJoinColumns={@JoinColumn(name="subject_id",
	 * referencedColumnName="id")})
	 * 
	 * @MapKeyTemporal(TemporalType.TIME) Map<LocalTime, Subject> subjects = new
	 * HashMap<>();
	 * @OneToMany
	@JoinTable(name = "day_schedule_subject", joinColumns = {
			@JoinColumn(name = "day_schedule_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "subject_id", referencedColumnName = "id") })
	//@MapKey(name="time")
	//@MapKeyColumn(name="time")
	//@MapKeyTemporal(TemporalType.TIME)
	private Map<LocalTime, Subject> subjects;



	public Map<LocalTime, Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Map<LocalTime, Subject> subjects) {
		this.subjects = subjects;
	}
	 */

}
