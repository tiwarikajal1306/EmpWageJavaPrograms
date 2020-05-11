package javaPrograms;

public class EmpWage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to Employee Wage computation");
		 int isfulltime=1;
         double empcheck=Math.floor(Math.random() * 10 )%2;
         if (empcheck==isfulltime)
                 System.out.println("Employee is present");
         else
                 System.out.println("Employee is Absent");

	}

}
