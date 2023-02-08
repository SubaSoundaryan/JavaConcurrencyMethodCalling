import java.util.Date;

public class GalileoGDS implements GDS{
    @Override
    public String callAPI() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Galileo Responded");
        return "Galileo Response" + new Date().getTime();
    }
}
