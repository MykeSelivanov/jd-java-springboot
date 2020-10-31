import service.MentorAccount;
import service.PartTimeMentor;

public class CybertekApp {
    public static void main(String[] args) {

        //FullTimeMentor fullTimeMentor = new FullTimeMentor();
        PartTimeMentor partTimeMentor = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(partTimeMentor);

        mentor.manageAccount();

        System.out.println();

    }

}