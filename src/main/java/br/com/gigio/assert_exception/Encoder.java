package br.com.gigio.assert_exception;

public class Encoder {

	public void encode(Object object) {
		assertNotNull(object);
		assertNotEmpty(object);
		
	}
	
	private void assertNotNull(Object object){
		if(object == null){
			throw new IllegalArgumentException("Argument cannot be null!");
		}
		
	}
	
	private void assertNotEmpty(Object object){
		if (object instanceof String && ((String) object).isEmpty()) {
			throw new IllegalArgumentException("Argument cannot be an empty String!");
		}
	}

}
