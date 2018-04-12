package project.httpclient.util;

public class JsonDeserialiseException extends RuntimeException {

	public JsonDeserialiseException() {
		super();
	}

	public JsonDeserialiseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JsonDeserialiseException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonDeserialiseException(String message) {
		super(message);

	}

	public JsonDeserialiseException(Throwable cause) {
		super(cause);
	
	}

	
}
