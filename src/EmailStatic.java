import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class EmailStatic {
public static Comparator<Email> idComparator = new Comparator<Email>(){
        
        @Override
        public int compare(Email c1, Email c2) {
        	if(c1.getPriority() == c2.getPriority())
        	{
				if (c1.getClassPriority() == c2.getClassPriority()){
					return (int) (c1.getDateC().getTime() - c2.getDateC().getTime());
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
	public static PriorityQueue<Email> EmailQueue = new PriorityQueue<>(100,idComparator);
	public static PriorityQueue<Email> EmailQueue1 = new PriorityQueue<>(100,idComparator);
	public static ArrayList<Email> EmailQueueArray = new ArrayList<Email>();
	
}
