import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
public class EmailCrtl {
	
	
	
	 public  void addDataToQueue(Email newEmail) {
		 EmailStatic.EmailQueue.offer(newEmail);
		 EmailStatic.EmailQueue2.offer(newEmail);
	    }
	 public  void RemoveDataToQueue(Email removeEmail) {
		 EmailStatic.EmailQueue.remove(removeEmail);
		 EmailStatic.EmailQueue2.remove(removeEmail);
	    }
	 
	 public String[][] GetEmailList(Date fromDate, Date toDate)
	 {
		 String [][] EmailList = new String[100][4];
		 int i = 0;
		 EmailStatic.EmailQueueArray.clear();
		 Email currentEmail;
		 while(true) {
			 if(EmailStatic.ctype == 0)
			 {
				 currentEmail = EmailStatic.EmailQueue.poll();

			 }
			 else
			 {

				 currentEmail = EmailStatic.EmailQueue2.poll();
			 }
			 
		        if(currentEmail == null) {
		            break;
		        }
		        if(fromDate == null || toDate == null ||  
        		(currentEmail.getDateC().after(fromDate) &&  currentEmail.getDateC().before(toDate)))
        		{
			        EmailStatic.EmailQueue1.add(currentEmail);
			        EmailStatic.EmailQueueArray.add(currentEmail);
			        EmailList[i][0] = currentEmail.getTitle();
			        EmailList[i][1] = currentEmail.getDateC().toString();
			        EmailList[i][2] = currentEmail.getPriority().toString();
			     	EmailList[i][3] = currentEmail.getClassPriority().toString();
			     	i++;
        		}
		 }
		 while(true) {
			 	currentEmail = EmailStatic.EmailQueue1.poll();
			 
		        if(currentEmail == null) {
		            break;
		        }
		        
				 if(EmailStatic.ctype == 0)
				 {
					 EmailStatic.EmailQueue.add(currentEmail);
				 }
				 else
				 {
					 EmailStatic.EmailQueue2.add(currentEmail);
				 }
		        
				
				
		 }
		 
		 return EmailList;
	 }
}
