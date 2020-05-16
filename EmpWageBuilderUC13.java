package javaPrograms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
class CompanyObj{
    public final String company;
    public final int empRatePerHr;
    public final int numOfWorkingDays;
    public final int maxHoursPerMonth;
    public int totalEmpWage;

    public CompanyObj(String company, int empRatePerHr, int numOfWorkingDays, int maxHoursPerMonth){
        this.company = company;
        this.empRatePerHr = empRatePerHr;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString(){
        return "Total Emp Wage for Company: "+company+" is "+totalEmpWage;
    }
}

interface IEmpWageBuilderUC11{
    void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHoursPerMonth);
    void totalEmpWage();
}

interface IEmpWageBuilderUC13{
    void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHoursPerMonth);
    void totalEmpWage();
    int getTotalWage();
}

public class EmpWageBuilderUC13 {
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;

    private int numOfCompanies = 0;
    private LinkedList<CompanyObj> listOfComp;
    private Map<String, CompanyObj> mapOfComp;

    public EmpWageBuilderUC13(){
        listOfComp = new LinkedList<>();
        mapOfComp = new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHoursPerMonth){
        CompanyObj newWage = new CompanyObj(company, empRatePerHr, numOfWorkingDays, maxHoursPerMonth);
        listOfComp.add(newWage);
        mapOfComp.put(company, newWage);
    }

    public void totalEmpWage(){
        for(int i = 0; i < listOfComp.size(); i++){
            CompanyObj tempComp = listOfComp.get(i);
            tempComp.setTotalEmpWage(this.totalEmpWage(tempComp));
            System.out.println(tempComp);
        }
    }

    int getTotalWage(String company){
        return mapOfComp.get(company).totalEmpWage;
    }

    public int totalEmpWage(CompanyObj companyObj) {
        //VARIABLES
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        //COMPUTATION
        while (totalEmpHrs <= companyObj.maxHoursPerMonth && totalWorkingDays < companyObj.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
                    break;
            }
            totalEmpHrs += empHrs;
            System.out.println("Days: " + totalWorkingDays + " Emp Hours: " + empHrs);
        }
        return totalEmpHrs * companyObj.empRatePerHr;
        //System.out.println("Total Emp Wage for company company is " + totalEmpWage);
    }

    public static void main(String[] args){
        EmpWageBuilderUC13 compObj = new EmpWageBuilderUC13();
        compObj.addCompanyEmpWage("DMart", 20, 2, 10);
        compObj.addCompanyEmpWage("Reliance", 50, 5, 15);
        compObj.totalEmpWage();
        System.out.println("Total Wage for DMart Company: "+compObj.getTotalWage("DMart"));
    }
}