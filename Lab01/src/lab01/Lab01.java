package lab01;
import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class Lab01 {

	public static void main(String[] args) {
		//Begin declaration of variables
		int yearsToWork, yearsRetired;
		double annualReturn, interest, reqIncome, monthlySSI;
		double monthSave, needSaved;
		//End declaration of variables
		
		Scanner inp= new Scanner(System.in); //Scanner created to take user input through keyboard
		
		System.out.print("How many years are you going to work?: ");
		yearsToWork = inp.nextInt();
		
		System.out.print("What is your annual return (whole percentages)?: ");
		annualReturn = inp.nextDouble()/100;
		
		System.out.print("How many years do you plan to retire?: ");
		yearsRetired = inp.nextInt();
		
		System.out.print("What is your interest rate when you are retired (whole percentages)?: ");
		interest = inp.nextDouble()/100;
		
		System.out.print("How much money do you want to make a month after you retire?: ");
		reqIncome = inp.nextDouble();
		
		System.out.print("What is your montly SSI?: ");
		monthlySSI = inp.nextDouble();
		
		needSaved = FinanceLib.pv(interest/12, (double)yearsRetired*12,(reqIncome-monthlySSI), 0, false);
		System.out.print("You need to save a total of: $");
		System.out.println(Math.round(100*Math.abs(needSaved))/100.);
		
		monthSave = FinanceLib.pmt(annualReturn/12, yearsToWork*12, 0, needSaved, false);
		System.out.print("So you have to save $"+ Math.round(100*Math.abs(monthSave))/100.+ " per month.");
		inp.close();
		
	}

}