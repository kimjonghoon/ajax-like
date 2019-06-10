package net.java_school.commons;

public enum WebContants {
	FILE_DIR("./download/");
	
	private String value;
	
	WebContants(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}

}
