import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class EmailStatic {
public static Comparator<Email> idComparator = new Comparator<Email>(){
        
        @Override
        public int compare(Email c1, Email c2) {
        	if(c1.getPriority() == c2.getPriority())
        	{
				if (c1.getClassPriority() == c2.getClassPriority()){
					return (int) (c2.getDateC().getTime() - c1.getDateC().getTime());
				}else {
					return (int) (c2.getClassPriority().ordinal() - c1.getClassPriority().ordinal());
				}
        	}
        	else
        	{
        		return (int) (c2.getPriority().ordinal() - c1.getPriority().ordinal());
        	}
        }
    };
    
    public static Comparator<Email> idComparator1 = new Comparator<Email>(){
        
        @Override
        public int compare(Email c1, Email c2) {
        	Date CurrentDate = new Date();
        	int piortity1 = (int) (CurrentDate.getTime() - c1.getDateC().getTime())/5 + c1.getPriority().ordinal();
        	int piortity2 = (int) (CurrentDate.getTime() - c2.getDateC().getTime())/5 + c2.getPriority().ordinal();
        	if(piortity1 == piortity2)
        	{
        		if(c1.getPriority() == c2.getPriority())
            	{
    				if (c1.getClassPriority() == c2.getClassPriority()){
    					return (int) (c2.getDateC().getTime() - c1.getDateC().getTime());
    				}else {
    					return (int) (c2.getClassPriority().ordinal() - c1.getClassPriority().ordinal());
    				}
            	}
            	else
            	{
            		return (int) (c2.getPriority().ordinal() - c1.getPriority().ordinal());
            	}
        	}
        	else
        	{
        		return (int) (piortity1 - piortity2);
        	}
        }
    };
    
    
    public static int ctype = 0;
	public static PriorityQueue<Email> EmailQueue = new PriorityQueue<>(100,idComparator);
	public static PriorityQueue<Email> EmailQueue1 = new PriorityQueue<>(100,idComparator);
	public static PriorityQueue<Email> EmailQueue2 = new PriorityQueue<>(100,idComparator1);
	public static ArrayList<Email> EmailQueueArray = new ArrayList<Email>();
	
}
