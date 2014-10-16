package com.java.thinkingin.chap13_string;

import java.util.Scanner;

class Student {
	private int id;
	private int age;
	private double money;

	Scanner scanner;

	public Student(String str) {
		scanner = new Scanner(str);
		this.id = scanner.nextInt();
		this.age = scanner.nextInt();
		this.money = scanner.nextDouble();
	}

	public Student(int id, int age, double money) {
		this.id = id;
		this.age = age;
		this.money = money;
	}

	public String toString() {
		return "[Student id:" + id + "  age:" + age + "  money:" + money + "]";
	}
}

public class ScannerTest {
	public static void main(String[] args) {
		Student student = new Student("1000 28 23.65");
		System.out.println(student);
	}
}
