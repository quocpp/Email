import java.util.Date;

public class Email {
	private String title;
	private Date dateC;
	private EmailPriority priority;
	private ClassPriority classPriority;
	public Email(String title, Date dateC, EmailPriority priority, ClassPriority classPriority) {
		super();
		this.title = title;
		this.dateC = dateC;
		this.priority = priority;
		this.classPriority = classPriority;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDateC() {
		return dateC;
	}
	public void setDateC(Date dateC) {
		this.dateC = dateC;
	}
	public EmailPriority getPriority() {
		return priority;
	}
	public void setPriority(EmailPriority priority) {
		this.priority = priority;
	}

	public ClassPriority getClassPriority() {
		return classPriority;
	}

	public void setClassPriority(ClassPriority classPriority) {
		this.classPriority = classPriority;
	}
}


