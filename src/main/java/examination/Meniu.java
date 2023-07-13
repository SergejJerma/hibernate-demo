package examination;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Meniu {
	public static SessionFactory factory;
	
	public void startMeniu() throws Exception {
		factory = new Configuration().configure().buildSessionFactory();
		
		String command = "";
		String command1 = "";
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sukurkite admin slaptazodi:");
		String tempPass = sc.nextLine();
		new CheckPass().savePass(tempPass);
	
		
		while (running) {
			System.out.println("Iveskite ka norite daryti: \n" + 
								"[1] - prisijungti kaip studentas(laikyti egzamina) \n" + 
								"[2] - prisijungti kaip DB administratorius \n" + 
								"[x] - iseiti");
			command = sc.next();
			sc.nextLine();
			switch (command) {
			case "1": new StudTesting().studTesting();
					break;
			case "2":{
					System.out.println("Iveskite admin slaptazodi:");
					tempPass = sc.nextLine();
					if (new CheckPass().checkPass(tempPass)) {
						System.out.println("Iveskite ka norite daryti: \n" + 
								"[1] - ivesti testa \n" + 
								"[2] - koreguoti esama testa \n" + 
								"[3] - generuoti statistika \n" + 
								"[x] - iseiti");
							command1 = sc.next();
							switch (command1) {
							case "1": 
									new InputTest().inputTestInfo();
		   						    break;
							case "2": 
									new ModifyTest().modifyTest();
									break;
							case "3":
								    new Statistics();
							break;
							case "x":
							break;
							default:
								System.out.println("Ivedete neteisinga veiksma \n veskite dar karta");
							}	
					}
					else System.out.println("Neteisingas slaptazodis");
				}
				
			
				break;
			case "x":
				System.out.println("Programa baige darba");
				running = false;
				break;
			default:
			System.out.println("Ivedete neteisinga veiksma \n veskite dar karta");
		}
	}
		sc.close();
		factory.close();

	}
}
