package examination;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "test")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int test_id;
	
	private int nr;
	private String name;
	
	@OneToOne(mappedBy = "test")
	private Testing testing;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "test")
	private List<Question> question = new ArrayList<Question>();
	
	Test(){
		
	}
	

	public Test(int nr, String name) {
		super();
		this.nr = nr;
		this.name = name;
	//	this.question.add(question);
	}


	public int getId() {
		return test_id;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<Question> getQuestion() {
		return question;
	}


	public void setQuestion(List<Question> question) {
		this.question = question;
	}


}
