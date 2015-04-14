package com.Algorithms.Ninja;

public class Add_Binary_Numbers {
	public static String addBinaryNumbers(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        StringBuilder buf = new StringBuilder();
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) {
                sum += num1.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                sum += num2.charAt(p2) - '0';
                p2--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            buf.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0) {
            buf.append('1');
        }
        buf.reverse();
        return buf.toString();
    }
	public static void main(String[] args) {
		String num1 = "10";
		String num2 = "101";
		String res = addBinaryNumbers(num1, num2);
		System.out.println(res);
	}
}
