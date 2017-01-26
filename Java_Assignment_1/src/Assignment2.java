/**
 * Created by Rose on 1/21/17.
 * Assignment for your lecture 2. Please finish all the questions under
 * 'Assignment'. Assignment 2 includes 3 interview prepare questions. They
 * are similar to what you will meet during your technical interviews.Write some tests as practice.
 * Please try to think the extra credit question. The deadline of this assignment is 01/26/2017 23:59 PST.
 * Please feel free to contact me for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	public void raiseSalary(double byPercent) {
		salary= salary * byPercent;
	}
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {
        //write your code here
    	
    	double sstax  = 0;
    	if (employee.salary<=8900) {	
    		sstax = 6.2/100 * employee.salary;
    	}
    	else {
    		sstax = 6.2/100 * 106800;
    	}	
    	System.out.println("The social security tax of the employee " +employee.name +" is: " +sstax);
    	return sstax;
    	}
    
    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    
    public double insuranceCoverage(Employee employee) {
        //write your code here
    	int insurate = 0;
    	if (employee.age<35) {
    		insurate = 3;	
    	}
    	else if (employee.age>=35 && employee.age <=50) {
    		insurate = 4;
    	}
    	else if (employee.age >50 && employee.age <60) {
    		insurate = 5;
    	}
    	/* The question does not mention about the age "60" , it only says about above or below 60.
    	   I have included age = 60 in the below category. */
    	else if (employee.age >=60){
    		insurate = 6;
    	} 
    	System.out.println("The insurance coverage contribution of the employee " +employee.name +" is :" +(insurate*employee.salary));
    	return (insurate*employee.salary);
    }
    
    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
    	
    	double asal[] = {e1.salary,e2.salary,e3.salary};
    	String aname[] = {e1.name,e2.name,e3.name};
    	
    	for (int i=0; i <asal.length; i++) {
    	for (int j=i+1; j <asal.length; j++) {
    		double temp = 0;
    		String temp1;
    		if (asal[i] >asal[j]) {
    			temp = asal[i];
    			temp1= aname[i];
    			asal[i] = asal[j];
    			aname[i] = aname[j];
    			asal[j] = temp;
    			aname[j] = temp1;			
    		}
    	}
    }
    	System.out.println(aname[0] +" " +aname[1] +" " +aname[2]);
    }


    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
       //write your code here
       
    	System.out.println("The monthly salary of the employee " +employee.name +" currently is " +employee.salary);
		employee.raiseSalary(3);
		System.out.println("The monthly salary of the employee " +employee.name +" after a raise is " +employee.salary);
}

    //Interview prepare questions

    /**
     * Write a method to determine whether a number is prime
     */
    public boolean isPrime(int n) {
        //write your code here
    	
    	if (n==2){
    		System.out.println("The number " +n +" is a prime number");
    	 }
    	
    	int i =2;
    	while (n>i && n!=2){
    		if (n%i==0) {
    			System.out.println("Not a prime number!");
    			return false;
    		}
    		else i++;
    			System.out.println("Prime number!");
    			return true;
    	}
    		System.out.println("The number is neither prime nor composite");//Case when the numbers 0 or 1 is entered
    		return false;	
    	}

    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {
        //write your code here
    	int sum = 0;
    	int num= 0;
    	int tsum= 0;
    	int temp = 0;
    	
    	while (n >0) {
    		num=n;
    		num = num % 10;
    		sum += num;
    		 n=n /10;
    	}
    	 if (sum>9) {
    		 temp = sum;
    		 tsum = sum;
    		 temp = temp % 10;
    		 tsum = tsum/10;
    		 sum = tsum + temp;
    	 }
    	 System.out.println("Sum of digits = "+sum);
    	return sum;
    }

    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {
    	
    	while (n%2==0)
    		n = n/2;
    	while (n%3==0)
    		n = n/3;
    	while (n%5==0)
    		n = n/5;
    	if (n==1) {
    		System.out.println("The number is an ugly number");
    		return true;
    	}
    	else 
    		System.out.println("The number is not an ugly number");
    		return false; 
    }
		

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
    */
    
    /* My explanation below
     ***********************
     *  When reference variables (like a or b) are created, they are just references of objects which points to memory locations 
     *  present inside the heap. But the swap method creates its own reference variables which points to other and different memory
     *  locations inside the heap. So, even if the x and y are interchanged 
     *  within this method, the original reference variables(a and b) will still point to the same old memory locations.
     *  This is one of the reason why it is said that java is always pass by value.
     *  
     */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        Employee c = new Employee("Mark", 50, Gender.MALE, 3000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
        Assignment2 agn = new Assignment2();
        agn.socialSecurityTax(a);
        agn.insuranceCoverage(b);
        agn.sortSalary(a, b,c);
        agn.tripleSalary(c);
        agn.isPrime(13);
        agn.addDigits(147);
        agn.isUgly(14);
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}