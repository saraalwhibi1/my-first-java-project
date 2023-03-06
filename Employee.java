public class Employee {
 
private String id; 
private String jobTitle;
private String contractDate;
private String startTime;
private String endTime;
private boolean hired;
private int frequency;


public Employee ()
{
  id = ""; 
  jobTitle = "";
  contractDate = "";
  startTime = "";
  endTime = "";
  hired = true;
  frequency = 0;

}

public Employee ( String id , String jobTitle , String contractDate , String startTime ,
             String endTime , boolean hired , int frequency ) {

  this.id = id; 
  this.jobTitle = jobTitle; 
  this.contractDate = contractDate;
  this.startTime = startTime;
  this.endTime = endTime;
  this.hired = hired;
  this.frequency = frequency;
}

public int calculateDuration(){//Sara
int startT = Integer.parseInt(startTime.substring(0,startTime.indexOf(':')));   
int endT = Integer.parseInt(endTime.substring(0,endTime.indexOf(':')));
int duration = endT - startT;
return duration; }

public void updateFrequency() { 
 frequency++; }


public void displayInfo()//Dhai
{
if (hired)

System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|%-4d|\n",id,jobTitle,contractDate,startTime,endTime,"Yes",frequency);
else

System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|%-4d|\n",id,jobTitle,contractDate,startTime,endTime,"No",frequency);
}


public String getId() {
   return id;
} 


public void setId (String id){
   this.id = id;
}



public String getJobTitle() {//Needed
   return jobTitle;
} 



public void setJobTitle(String jobTitle){//Needed
   this.jobTitle = jobTitle;
}



public String getContractDate() {//Needed
   return contractDate;
} 



public void setContractDate(String contractDate){//Needed
   this.contractDate = contractDate;
}



public String getStartTime() {
   return startTime;
} 



public void setStartTime(String startTime){
   this.startTime = startTime;
}



public String getEndTime() {
   return endTime; 
} 



public void setEndTime(String endTime){
   this.endTime = endTime;
}



public boolean getHired() {
   return hired;
} 



public void setHired(boolean hired){
   this.hired = hired;
}



public int getFrequency() {//Needed
   return frequency;
} 



public void setFrequency (int frequency){//Needed
   this.frequency = frequency;
}













}