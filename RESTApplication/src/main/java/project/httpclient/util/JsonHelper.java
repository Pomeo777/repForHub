package project.httpclient.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
	private final static ObjectMapper mapper = new ObjectMapper();
	public static String serialize(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
	
			throw new JsonDeserialiseException("Unable to serialize", e);
		}
	}
	
	public static <T> T deserialize(String json, Class<T> type) {
		try {
			return mapper.readValue(json, type);
		} catch (Exception e) {
			throw new JsonDeserialiseException("Unable to desirialize", e);
			
		}
		
	}
	
}
