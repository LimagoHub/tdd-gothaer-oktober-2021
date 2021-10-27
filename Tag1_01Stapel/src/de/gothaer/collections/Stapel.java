package de.gothaer.collections;

public class Stapel {
	
	private static final int DEFAULT_SIZE = 10;
	private Object[] data;
	private int index;
	
	public Stapel() {
		data = new Object[DEFAULT_SIZE];
	}
	
	public void push(Object value) throws StapelException {
		if(isFull()) throw new StapelException("Overflow");
		data[index ++] = value;
	}

	public Object pop() throws StapelException {
		if(isEmpty()) throw new StapelException("Underflow");
		return data[--index];
	}
	
	public boolean isEmpty() {
		return index <= 0;
	}
	
	public boolean isFull() {
		return index >= data.length;
	}
	

}
