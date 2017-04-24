package me.hbu.frank.archives;

import java.util.ArrayList;

import me.hbu.frank.utils.NumberUtils;

/**
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem025 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("1");
		for (int i = 3;true; i++) {
			String current = NumberUtils.add(list.get(i-1),list.get(i-2));
			if (current.length() >= 1000) {
				System.out.println(i);
				break;
			}else {
				list.add(current);				
			}
		}
	}

}
