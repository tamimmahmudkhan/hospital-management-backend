package com.tamim.hospitalmgt;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "patient_history")
	private String history;


	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "DOCTOR_PATIENT_MAPPING", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id"))
	private Set<Doctor> doctors;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String firstName, String lastName, String hist) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.history = hist;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}


	public boolean addDoctor(Doctor doctor) {
		return doctors.add(doctor);
	}
}
