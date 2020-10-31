import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {

        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        Mentor mentor = (Mentor) container.getBean("fullTimeMentor");
        mentor.createAccount();

        ApplicationContext container1 = new ClassPathXmlApplicationContext("config.xml");
        Mentor mentor1 = (Mentor) container1.getBean("partTimeMentor");
        mentor1.createAccount();

        //without downcasting
        Mentor mentor2 = container.getBean("fullTimeMentor", Mentor.class);

    }
}
