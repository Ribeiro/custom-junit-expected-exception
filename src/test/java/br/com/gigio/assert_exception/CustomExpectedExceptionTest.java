package br.com.gigio.assert_exception;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import br.com.gigio.assert_exception.junit.rule.ExpectedException;

public class CustomExpectedExceptionTest {
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	private Encoder encoder;
	
	@Before
	public void setup(){
		encoder = new Encoder();
	}
	
	@Test
	public void shouldCaptureIllegalArgumentExceptionDueToNullArgument(){
		thrown.expectIllegalArgumentException("Argument cannot be null!");
		encoder.encode(null);
	}
	
	@Test
	public void shouldCaptureIllegalArgumentExceptionDueToEmptyStringArgument(){
		thrown.expectIllegalArgumentException("Argument cannot be an empty String!");
		encoder.encode("");
	}
	

}
