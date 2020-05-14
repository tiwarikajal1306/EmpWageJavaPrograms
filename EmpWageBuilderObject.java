package javaPrograms;

public class EmpWageBuilderObject {
	public static final int IS_PART_TIME=1;
	public static final int IS_FULL_TIME=2;
	
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int MaxHoursPerMonth;
	private int totalEmpWage;
	
	public EmpWageBuilderObject(String company,int empRatePerHour,int numOfWorkingDays,int MaxHoursPerMonth) {
		this.company=company;
		this.empRatePerHour=empRatePerHour;
		this.numOfWorkingDays=numOfWorkingDays;
		this.MaxHoursPerMonth=MaxHoursPerMonth;
	}
	
	public  void computeEmpWage() {
		int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
		
		while (totalEmpHrs <= MaxHoursPerMonth && totalWorkingDays <= numOfWorkingDays) {
			totalWorkingDays++;
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
        totalEmpHrs +=empHrs;
        System.out.println("Day: " +totalWorkingDays + "Emp Hr:" +empHrs);
	  }
		totalEmpWage=totalEmpHrs * empRatePerHour;
       // System.out.println("total Employee wage  for company" +company +"is" +totalEmpWage);
     }
	@Override
	public String toString() {
		return "total Employee wage  for company" +company +"is" +totalEmpWage;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		EmpWageBuilderObject dMart=new 	EmpWageBuilderObject("DMart",20,15,100);
		EmpWageBuilderObject reliance=new 	EmpWageBuilderObject("Raliance",10,20,150);
		
		dMart.computeEmpWage();
		System.out.println(dMart);
		reliance.computeEmpWage();
		System.out.println(reliance);
		
	}

}
