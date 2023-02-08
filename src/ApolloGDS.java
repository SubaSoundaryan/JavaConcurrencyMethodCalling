import java.util.Date;

public class ApolloGDS implements GDS{
    @Override
    public String callAPI() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("ApolloGDS Responded");
        return "ApolloGDS Response" + new Date().getTime();
    }
}
