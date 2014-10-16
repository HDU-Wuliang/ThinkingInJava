package com.java.thinking.simulate;

public interface CharSequenceSimulate {
	int length();

	char charAt(int index);

	CharSequenceSimulate subSequence(int start, int end);
	
	public String toString();
}
