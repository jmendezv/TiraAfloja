package org.escoladeltreball.tiraafloja;

import static java.lang.System.exit;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	final static Scanner sc = new Scanner(System.in);

	static int index, left, right;

	public static void main(String[] args) {

		while (true) {

			int n = sc.nextInt();

			if (n == 0) {
				exit(0);
			}

			int[] pesos = new int[n];

			for (int i = 0; i < n; i++) {
				pesos[i] = sc.nextInt();
			}

			// out.println(Arrays.toString(pesos));

			solve(pesos);

		}
	}

	private static void solve(int[] pesos) {
		int diff = Integer.MAX_VALUE;

		if (pesos.length % 2 == 1) {
			if (calc(pesos, 0, pesos.length / 2 - 1) == calc(pesos,
					pesos.length / 2 + 1, pesos.length - 1)) {
				out.printf("NO JUEGAN%n");
				return;
			}
		}

		for (int i = 0; i < pesos.length - 1; i++) {
			// int d = calcDiff(pesos, i);
			// out.printf("%d%n", d);
			int l = calc(pesos, 0, i);
			int r = calc(pesos, i + 1, pesos.length - 1);
			int d = Math.abs(l - r);
			if (d < diff) {
				diff = d;
				index = i + 1;
				left = l;
				right = r;
			}
		}
		out.printf("%d %d %d%n", index, left, right);
	}
	

	private static int calc(int[] pesos, int left, int right) {
		int t = 0;
		
		for (int i = left; i <= right; i++) {
			t += pesos[i];
		}

		return t;
	}

}