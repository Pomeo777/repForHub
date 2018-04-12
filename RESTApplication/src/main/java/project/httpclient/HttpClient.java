package project.httpclient;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import project.httpclient.util.HttpServices;


public class HttpClient {

	static String url = "http://localhost:8080/users";
	static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	
	public static void main(String[] ags) {
		
		
		
		log.debug("HttpClient is starting");
		Scanner scanner = new Scanner(System.in);
		String answer="";
		String question = "no";
		String userName, password;
		while(!question.equals(answer.toLowerCase())) {
			System.out.println("Please enter name of user!");
			userName = scanner.nextLine();
			System.out.println("Please enter password!");
			password = scanner.nextLine();
				if(!userName.equals("") & !password.equals("")) {
					HttpServices services = getHttpService();
					services.postMethod(userName, password, url);
				}else {
					System.out.println("UserName and password can't be empty");
				}
				System.out.println("Do you want to continue? yes/no");
				answer = scanner.nextLine();
		}	
		
	}
	
	public static  HttpServices getHttpService() {
		return new HttpServices();
	}


	
}
