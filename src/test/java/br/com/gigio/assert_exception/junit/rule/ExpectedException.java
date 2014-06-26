package br.com.gigio.assert_exception.junit.rule;

import org.junit.rules.MethodRule;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class ExpectedException implements MethodRule{

	private final org.junit.rules.ExpectedException delegate = org.junit.rules.ExpectedException.none();
	 
	  public static ExpectedException none() {
	    return new ExpectedException();
	  }
	 
	  private ExpectedException() {}
	 
	  public Statement apply(Statement base, FrameworkMethod method, Object target) {
		  return delegate.apply(base, Description.createSuiteDescription(this.getClass()));
	  }
	 
	  public void expectAssertionError(String message) {
	    expect(AssertionError.class);
	    expectMessage(message);
	  }
	  
	  public void expectIllegalArgumentException(String message) {
		    expect(IllegalArgumentException.class);
		    expectMessage(message);
		  }
	 
	  public void expect(Throwable error) {
	    expect(error.getClass());
	    expectMessage(error.getMessage());
	  }
	 
	  public void expect(Class<? extends Throwable> type) {
	    delegate.expect(type);
	  }
	 
	  public void expectMessage(String message) {
	    delegate.expectMessage(message);
	  }

}