package com.java.thinking.simulate;

public final class StringSimulate implements CharSequenceSimulate {
	/** The value is used for character storage. */
	private final char value[];
	/** Cache the hash code for the string */
	private int hash;

	public StringSimulate() {
		this.value = new char[0];
	}

	public StringSimulate(StringSimulate original) {
		this.value = original.value;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return value.length;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index > value.length) {
			throw new StringIndexOutOfBoundsException(index);
		}
		return value[index];
	}

	@Override
	public CharSequenceSimulate subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		return value.length == 0;
	}

	public boolean equals(Object anObject) {
		return true;
	}

	public String toString() {
		return "";
	}
}
