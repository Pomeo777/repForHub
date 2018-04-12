package project.httpclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project.httpclient.util.HttpServices;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@TestPropertySource(locations = "classpath:application.properties")
public class HttpClientTestIT {
	
	@Test
	public void testPostMethod() {
	//	HttpClient client = new HttpClient();
		HttpServices servise = new HttpServices();
		servise.postMethod("Den", "asdff", "http://localhost:8080/users");
	}

	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyUrlExcept() {
		HttpServices servise = new HttpServices();
		servise.postMethod("Den", "asdcz", " ");
	}
	

	
	@Test
	public void testSerializeExcept() {
		HttpServices servise = new HttpServices();
		
		servise.postMethod("Den", "asdcz", "http://localhost:8080/users");
			
	}
	
	
	

//	@Test
//	public void testCreateUser() {
//		OkHttpClient clientOk = new OkHttpClient();
//		String json = "{\"userName\":\"Ronan\",\"password\":\"zcvbddhgdrf\"}";
//
//		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
//		Request request = new Request.Builder().url("http://localhost:8080/users").post(body).build();
//		System.out.println("after req: " + request.toString());
//		try {
//			Response response = clientOk.newCall(request).execute(); 
//			System.out.println(response.toString());
//			String requestBody = response.body().string();
//			System.out.println(requestBody);
//		} catch (IOException e) {
//			throw new RuntimeException("Test error", e);
//		}
//	}
}
