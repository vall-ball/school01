package ru.vallball.school01.model;

import java.time.DayOfWeek;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "schedules")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="group_id")
	private Group group;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "schedules_day_schedules", joinColumns = {
			@JoinColumn(name = "schedule_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "day_schedule_id", referencedColumnName = "id") })
	@MapKey(name="dayOfWeek")
	private Map<DayOfWeek, DaySchedule> daySchedules;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Map<DayOfWeek, DaySchedule> getDaySchedules() {
		return daySchedules;
	}

	public void setDaySchedules(Map<DayOfWeek, DaySchedule> daySchedules) {
		this.daySchedules = daySchedules;
	}

	public Long getId() {
		return id;
	}
	
	
}
