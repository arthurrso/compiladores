package br.com.arthurrso.semantical;

import java.util.function.Function;

public class Context {
	
	private Function f;

	public Function getFunction() {
		return f;
	}

	public void setFunction(Function f) {
		this.f = f;
	}

}