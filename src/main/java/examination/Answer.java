package examination;


import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int answer_id;
	
	private int nr;
	private String vairiant;
	private boolean correct;
	
	@ManyToOne()
	@JoinColumn(name = "question_id")
	private Question question;
	
	Answer(){
		
	}
	
	public Answer(int nr, String vairiant, boolean correct) {
		super();
		this.nr = nr;
		this.vairiant = vairiant;
		this.correct = correct;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getVairiant() {
		return vairiant;
	}

	public void setVairiant(String vairiant) {
		this.vairiant = vairiant;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public int getId() {
		return answer_id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
}
