package javaPrograms;

public class EmpWage {
	public static final int IS_PART_TIME=1;
	public static final	int IS_FULL_TIME=2;
	public static final int  EMP_RATE_PER_HOUR=20;
	public static final int NUM_OF_WORKING_DAYS=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int empHrs=0;
        int empWage=0;
        int totalEmpWage=0;
		System.out.println("Welcome to Employee Wage computation");
		for (int day=0; day < NUM_OF_WORKING_DAYS; day++) {
        int empcheck=(int)Math.floor(Math.random() * 10 )%3;
        switch (empcheck) {
        case IS_PART_TIME:
        		empHrs=4;
        		break;
        case IS_FULL_TIME:
                empHrs=8;
                break;
        default:
                empHrs=0;
        }
        empWage=empHrs * EMP_RATE_PER_HOUR;
        totalEmpWage=totalEmpWage+empWage;
        System.out.println("Emp Wage: " +empWage );
	}
        System.out.println("Total Emp Wage:" +totalEmpWage);
}
}