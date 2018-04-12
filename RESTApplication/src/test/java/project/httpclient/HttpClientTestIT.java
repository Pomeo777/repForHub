package project.httpclient;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import project.Application;
import project.httpclient.util.HttpServices;




@RunWith(SpringRunner.class)
@SpringBootTest()
public class HttpClientTestIT {

	
	@Test
	public void testPostMethod() {
		HttpClient client = new HttpClient();
		HttpServices services = client.getHttpService();
		boolean result = services.postMethod("Den", "asdff", "http://localhost:8080/users");
		assertThat(result, is(false));
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyUrlExcept() {
		HttpServices servise = new HttpServices();
		servise.postMethod("Den", "asdcz", " ");
	}
	

	

}
