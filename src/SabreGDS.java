import java.util.Date;

public class SabreGDS implements GDS{
    @Override
    public String callAPI() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("SabreGDS Responded");
        return "SabreGDS Response" + new Date().getTime();
    }
}
