import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
public class EmailCrtl {
	
	
	
	 public  void addDataToQueue(Email newEmail) {
		 EmailStatic.EmailQueue.offer(newEmail);
	    }
	 public  void RemoveDataToQueue(Email removeEmail) {
		 EmailStatic.EmailQueue.remove(removeEmail);
	    }
	 
	 public String[][] GetEmailList()
	 {
		 String [][] EmailList = new String[100][4];
		 int i = 0;
		 EmailStatic.EmailQueueArray.clear();
		 while(true) {
			 Email currentEmail = EmailStatic.EmailQueue.poll();
			 
		        if(currentEmail == null) {
		            break;
		        }
		        EmailStatic.EmailQueue1.add(currentEmail);
		        EmailStatic.EmailQueueArray.add(currentEmail);
		        EmailList[i][0] = currentEmail.getTitle();
		        EmailList[i][1] = currentEmail.getDateC().toString();
		        EmailList[i][2] = currentEmail.getPriority().toString();
		     	EmailList[i][3] = currentEmail.getClassPriority().toString();
			 i++;
		 }
		 while(true) {
			 Email currentEmail = EmailStatic.EmailQueue1.poll();
			 
		        if(currentEmail == null) {
		            break;
		        }
		        EmailStatic.EmailQueue.add(currentEmail);
		 

		 }
		 
		 return EmailList;
	 }
}
