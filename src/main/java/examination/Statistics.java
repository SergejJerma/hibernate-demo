package examination;

import javax.persistence.*;

import java.time.LocalDateTime;



@Entity
@Table(name = "statistics")
public class Statistics {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int statis_id;
	
	private LocalDateTime data;

	
	public Statistics() {
		
	}
}
