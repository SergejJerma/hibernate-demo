package examination;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stud_id;
	private String name;
	private String surname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private List<Testing> testing = new ArrayList<Testing>();
	
	public Student() {
		
	}
	

	public Student(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}


	public int getId() {
		return stud_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Testing> getTesting() {
		return testing;
	}

	public void setTesting(List<Testing> testing) {
		this.testing = testing;
	}

	
	
	
}

