package project.httpclient.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import project.controllers.UserDTO;

public class HttpServices {
	static final Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	 OkHttpClient client = new OkHttpClient();
	 Request request;



	public boolean postMethod(String name, String password, String url) {
		String json = JsonHelper.serialize(new UserDTO(name, password));
			log.debug("Json object into postMethod {}", json);
		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
		request = new Request.Builder().url(url).post(body).build();
		try (Response response = client.newCall(request).execute()) {
			log.debug("User was saved");
			return true;
		} catch (IOException e) {
			log.error("Connection error", e);
			return false;
		}
	}

	
	public  String getMethod(String url, int clientId) {
		request = new Request.Builder().url(url + "/" + clientId).build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (IOException e) {
			log.error("Connection error", e);
		}
		return "User was't found";
	}

	public  void deleteMethod(String url, int userId) {
		request = new Request.Builder().delete().url(url + "/" + userId).build();
		try (Response response = client.newCall(request).execute()) {

		} catch (IOException e) {
			log.error("Connection error", e);
		}
	}
}
