package examination;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "testing")
public class Testing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testing_id;
	
	private int marks;
	private String result;

	private HashMap<Integer,Integer> allAns;
	
	@ManyToOne()
	@JoinColumn(name = "stud_id")
	private Student student;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_id")
	private Test test;

	
	public Testing(){
		
	}
	
	

	public Testing(int marks, String result, HashMap<Integer, Integer> allAns) {
		super();
		this.marks = marks;
		this.result = result;
		this.allAns = allAns;
	}



	public int getId() {
		return testing_id;
	}


	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Map<Integer, Integer> getAllAns() {
		return allAns;
	}

	public void setAllAns(HashMap<Integer, Integer> allAns) {
		this.allAns = allAns;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	
}
