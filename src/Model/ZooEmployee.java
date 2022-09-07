package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;

import Utils.Gender;
import Utils.Job;

public class ZooEmployee extends Person{
	private static int idCounter = 1;
	
	private Job job;
	private String username;
	private String password;
	
	
	
	public ZooEmployee(String firstName, String lastName, LocalDate date, Gender gender, Section section, Job job,String username, String password) {
		super(idCounter++,firstName, lastName, date, gender, section);
		this.job = job;
		this.username = Integer.toString(idCounter);
		this.password = Integer.toString(idCounter);
	}
	public ZooEmployee(String firstName, String lastName, LocalDate date, Gender gender, Section section, Job job) {
		super(idCounter++,firstName, lastName, date, gender, section);
		this.job = job;
		this.username = Integer.toString(idCounter);
		this.password = Integer.toString(idCounter);
	}
	
	public static int getIdCounter() {
		return idCounter;
	}
	
	public static void setIdCounter(int idCounter) {
		ZooEmployee.idCounter = idCounter;
	}
	public ZooEmployee(int id) {
		super(id);
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" Name: "+getFirstName()+" "+getLastName()+", Job: "+job;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	

	
}
