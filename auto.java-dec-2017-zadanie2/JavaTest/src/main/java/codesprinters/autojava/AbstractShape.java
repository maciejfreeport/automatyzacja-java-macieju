package codesprinters.autojava;

public abstract class AbstractShape implements Shape {

	public String getName() {
		return this.getClass().getSimpleName();
	}

}
