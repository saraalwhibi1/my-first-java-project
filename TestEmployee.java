import java.util.*;
import static java.lang.Math.*;
public class TestEmployee {

static int numOfEmployee=0; 

static Employee [] hiringEmployees = new Employee [100]; //Task1
static Scanner input = new Scanner (System.in);



//***************** Start Main *********************
public static void main (String [] args) {
String min_duration;
numOfEmployee=10;
//Task2:
hiringEmployees [0] = new Employee ("9876543222", "Driver", "15/12/2020","16:00","22:00",true,1);
hiringEmployees [1] = new Employee ("9876543211", "Cleaning Worker", "15/12/2020","08:00","16:00",true,4);
hiringEmployees [2] = new Employee ("1234567899", "Cleaning Worker", "N/A","N/A","N/A",false,0);
hiringEmployees [3] = new Employee ("2234567891", "Cleaning Worker", "7/12/2020","08:00","13:00",true,2);
hiringEmployees [4] = new Employee ("1334567892", "Driver", "11/12/2020","10:00","15:00",true,1);
hiringEmployees [5] = new Employee ("4412356789", "Cleaning Worker", "05/12/2020","12:00","16:00",true,10);
hiringEmployees [6] = new Employee ("3114567894", "Driver", "N/A","N/A","N/A",false,2);
hiringEmployees [7] = new Employee ("8876543221", "Driver", "19/12/2020","08:00","14:00",true,1);
hiringEmployees [8] = new Employee ("7776543267", "Cleaning Worker", "N/A","N/A","N/A",false,3);
hiringEmployees [9] = new Employee ("1176543266", "Cleaning Worker", "02/12/2020","17:00","21:00",true,12);

//Task3:
String maxFreq= maximumFrequency (hiringEmployees[1] , hiringEmployees[2]);
if (maxFreq.equals("-1"))
System.out.println("Employees have diffrent job titles");
else
System.out.println("Employee with the id number: (" + maxFreq + ") can take a break during the weekend");

//Task4:
min_duration =  minimumDuration(hiringEmployees[0] , hiringEmployees[1]);
if(min_duration.equals( "Dates are Mismatched") )
System.out.println("Employees worked in a different date");
else
System.out.println("Employee with the id number: (" + min_duration + ") worked less on ( " + hiringEmployees[0].getContractDate() + ") "); 


//Task5:
String maxFreq2= maximumFrequency (hiringEmployees[1] , hiringEmployees[0]);
if (maxFreq2.equals("-1"))
System.out.println("Employees have diffrent job titles");
else
System.out.println("Employee with the id number: (" + maxFreq2 + ") can take a break during the weekend");

//Task6:

min_duration=  minimumDuration(hiringEmployees[1] , hiringEmployees[3]);
if( min_duration.equals( "Dates are Mismatched") )
System.out.println("Employees worked in a different date");
else
System.out.println("Employee with the id number:("+ min_duration+") worked less on ( "+ hiringEmployees[0].getContractDate()+")"); 



System.out.println("================================================");


//menu:
int choice;
boolean stay=true;
do 
{
System.out.println("1. Add a new employee");
System.out.println("2. Start a hiring contrcat");
System.out.println("3. End hiring contract");
System.out.println("4. Display employee info");
System.out.println("5. Display HRS system status");
System.out.println("6. Exit");

choice=input.nextInt();

switch (choice){

case 1: 
addEmployee();
break;

case 2:
startHiring();
break;

case 3:
endHiring();
break;

case 4:
employeeInfo();
break;

case 5:
displaySystemStatus();
break;

case 6:
System.out.println("All info. will be lost. Are you sure you want to exit? (yes/no) ");
String askExit = input.next();
if (askExit.equalsIgnoreCase("yes")) { 
  System.out.println("Ok, Thank you for using our system. ");
  stay= false; }
else if(askExit.equalsIgnoreCase("no")) { 
  System.out.println("-----------------------------");
  continue;}
else { 
  System.out.println("only (yes/no) is accepted! ");
  System.out.println("-----------------------------");
  continue;}
break;

default:
System.out.println("Not a valid selection!");
break;

}
System.out.println("-----------------------------");
}while (stay);


}//end main

//***************** Methods ******************


//method case1:
public static void addEmployee(){
System.out.print("please enter employee's id: ");
String id=input.next();
int i;
for( i = 0 ;i < numOfEmployee  ;  i++){// to check exist before or no
if( hiringEmployees[i].getId() .equals( id )  ) { 
System.out.print("This ID is already exixt!");
break;}}
if( !(hiringEmployees[i].getId() .equals( id ) ) ){
 hiringEmployees[numOfEmployee]= new Employee();
  hiringEmployees[numOfEmployee].setId( id ); 
  input.nextLine();
  System.out.print("please enter employee's job title: ");
  String jobTitle=input.nextLine();
  hiringEmployees[numOfEmployee].setJobTitle(jobTitle);
  hiringEmployees[numOfEmployee].setContractDate("N/A");
  hiringEmployees[numOfEmployee].setStartTime("N/A");
  hiringEmployees[numOfEmployee].setEndTime("N/A");
  hiringEmployees[numOfEmployee].setHired(false);
  hiringEmployees[numOfEmployee].setFrequency(0);
  numOfEmployee++;}
  
}

//method case2:
public static void startHiring(){
String endTime;
String startTime;
System.out.print("please enter employee's id: ");
String id=input.next();
for(int i=0; i<numOfEmployee ;i++)
{
if((hiringEmployees[i].getId().equals(id))&&( hiringEmployees[i].getHired()!=true))
{ System.out.print("please enter contract date in this format (dd/mm/yyyy): ");
  String contractDate=input.next();
  hiringEmployees[i].setContractDate(contractDate);
  System.out.print("please enter start time: ");
         startTime=input.next();
  hiringEmployees[i].setStartTime(startTime);
  System.out.print("please enter end time: ");
        endTime=input.next();
  hiringEmployees[i].setEndTime(endTime);
  hiringEmployees[i].setHired(true);
  hiringEmployees[i].updateFrequency();
  System.out.print("This employee with this information: ");
  hiringEmployees[i].displayInfo();
  System.out.println(" ,is now ready for starting the job."); 
  break;
}
  
if(hiringEmployees[i].getHired()==true)
{ System.out.println("Sorry, this employee id is not availabe already hired. ");
      break;// to get out from for loop
}
if(!(hiringEmployees[i].getId().equals(id))){

System.out.print("Sorry, this employee id doesn't exist ");
break;}
   

}//endfor
}//endmethod


//method case3:

public static void endHiring(){
String id;
int location;
System.out.println("Enter id ");
id = input.next(); 

location = -1 ; 
for( int i = 0 ; i < numOfEmployee ; i++)
if( hiringEmployees[i].getId() .equals(id))
location = i ; 


if( location == -1 )
{
System.out.println(" couldn't find this id");

}

if(location != -1 && hiringEmployees[location].getHired() ==  false  )
{
System.out.println("this Employee is not hired ");

}
else if(location != -1 && hiringEmployees[location].getHired() ==  true ){
System.out.println("Employee's duration : " + hiringEmployees[location].calculateDuration() );
hiringEmployees[location].displayInfo();
hiringEmployees[location].setContractDate("N/A" );
hiringEmployees[location].setStartTime("N/A" );
hiringEmployees[location].setEndTime( "N/A" );
hiringEmployees[location].setHired(false);}


}


//method case4:
public static void employeeInfo (){
System.out.print("please enter employee's id: ");
String id=input.next();
boolean checkId= false;
int index=0;
for(int i=0; i<numOfEmployee ;i++)
if(hiringEmployees[i].getId().equals(id))
{ checkId= true; 
  index= i; }

if (checkId== true)
{ hiringEmployees[index].displayInfo(); }
else
{ System.out.println("Sorry, this employee does not exist."); }
}//endfor


//method case5:
public static void displaySystemStatus() {
int numOfHired=0;
int numOfNotHired=0;
String Id_highFreq;
int highestFrequency ; 
int  frequency;
System.out.println("The total number of employees who are currently registered in the system: " + numOfEmployee);
for( int i = 0 ;i < numOfEmployee ; i++)
if( hiringEmployees[i].getHired() == true )
  numOfHired++;
else
  numOfNotHired++;
  
System.out.printf("The current number of hired employees:%d,and the number of avalible employees:%d\n",numOfHired,numOfNotHired);
 highestFrequency = 0 ; 
 frequency=0;
for( int i = 1 ;i <numOfEmployee ; i++)
if( hiringEmployees[i].getFrequency() > hiringEmployees[highestFrequency].getFrequency() )
highestFrequency = i ; 
        
  frequency = hiringEmployees[highestFrequency].getFrequency(); 
   Id_highFreq = "" ;         
for( int i = 1 ;i <numOfEmployee ; i++)
if( hiringEmployees[i].getFrequency() == frequency ) 
Id_highFreq =Id_highFreq+ ""+hiringEmployees[i].getId()  ; 

System.out.println("The ID of the employee with the highest hiring frequency in the System: "+Id_highFreq);

System.out.println(" List of all the employees ");

System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|%-4s|\n"," ID","Job title","Date","start","end","Hired?","freq");
for( int i = 0 ;i < numOfEmployee  ; i++)
hiringEmployees[i].displayInfo();


}


public static String maximumFrequency (Employee one , Employee two ) {

int maxF=0;
if ( one.getJobTitle().equals( two.getJobTitle() ) ) 
      maxF=Math.max(one.getFrequency(),two.getFrequency());
         
         if (one.getFrequency()==maxF)
            return one.getId();
         else if  (two.getFrequency()==maxF)
            return two.getId();

else 
return "-1";
}


public static String minimumDuration (Employee one , Employee two) {

int minD=0;

if ( one.getContractDate().equals( two.getContractDate() ) ) 
      minD=Math.min ( one.calculateDuration() , two.calculateDuration() );
      
      if (one.calculateDuration()==minD)
            return one.getId();
         else if  (two.calculateDuration()==minD)
            return two.getId();
else
return "Dates are Mismatched";}



}//end class