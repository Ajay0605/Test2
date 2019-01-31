package test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		char c = Helper.getStringData("Do you Want to add Customer? (Y/N)")
				.toUpperCase().charAt(0);
		final int size = 10;
		Customer[] cust = new Customer[size];
		int cnt = 0;
		while (c == 'Y') {
			String ch = Helper
					.getStringData("which type of Customer? (Service S/Purchaser P)");
			switch (ch.toUpperCase()) {
			case "P":
				cust[cnt++] = new Purchaser(
						Helper.getStringData("Enter Customer Name"),
						Helper.getDoubleData("Enter Monthly Payment"));
				break;
			case "S":
				cust[cnt++] = new Service(
						Helper.getStringData("Enter Customer Name"),
						Helper.getStringData("Enter Service Date"),
						Helper.getDoubleData("Enter Invoice Amt"));
				break;

			default:
				break;
			}
			if (cnt > 10) {
				System.out.println("Limit Reached Thank you");
				break;
			}
			c = Helper
					.getStringData("Do you Want to add another customer? (Y/N)")
					.toUpperCase().charAt(0);
		}
		System.out.println("Total Of all monthly Invoices is: ");
		double amt = 0;
		for (int i = 0; i < cnt; i++) {
			amt += cust[i].showData();
		}
		System.out.println(amt);
	}
}

class Customer {
	protected String name;

	public Customer(String name) {
		super();
		this.name = name;
	}

	public double showData() {
		return 0;
	}

	public String toString() {
		return "Name is: " + name;
	}

}

class Purchaser extends Customer {
	protected double Monthly_Payment;

	public Purchaser(String name, double Monthly_Payment) {
		super(name);
		this.Monthly_Payment = Monthly_Payment;
	}

	public double showData() {
		return 0;
	}
}

class Service extends Customer {
	protected String Service_Date;
	protected double Inv_Amt;

	public Service(String name, String service_Date, double inv_Amt) {
		super(name);
		this.Service_Date = service_Date;
		this.Inv_Amt = inv_Amt;
	}

	public double showData() {
		return Inv_Amt;
	}

}

class Helper {
	public static String getStringData(String promt) {
		Scanner s = new Scanner(System.in);
		System.out.println(promt);
		return s.next();
	}

	public static double getDoubleData(String promt) {
		Scanner s = new Scanner(System.in);
		System.out.println(promt);
		return s.nextDouble();
	}

}
