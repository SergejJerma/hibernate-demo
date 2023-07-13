package examination;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int question_id;
	
	private int nr;
	private String question;
	
	
	@ManyToOne()
	@JoinColumn(name = "test_id")
	private Test test;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	private List<Answer> answer = new ArrayList<Answer>();
	
	Question(){
		
	}

	public Question(int nr, String question) {
		super();
		this.nr = nr;
		this.question = question;
	}

	public int getId() {
		return question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	
	
}
