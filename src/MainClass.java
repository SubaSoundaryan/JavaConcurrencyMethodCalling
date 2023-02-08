import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        System.out.println("Main Started");
        Map<String, String> maps = getResults();
        System.out.println(maps);
        System.out.println("Main Ended");

    }

    public static Map<String, String> getResults() {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        GalileoGDS galileoGDS = new GalileoGDS();
        SabreGDS sabreGDS = new SabreGDS();
        ApolloGDS apolloGDS = new ApolloGDS();

        System.out.println("Stage 1 :" + new Date().getTime());

        Callable<String> galileoCallable = galileoGDS::callAPI;
        Callable<String> sabreCallable = sabreGDS::callAPI;
        Callable<String> apolloCallable = apolloGDS::callAPI;

        System.out.println("Stage 2 :" + new Date().getTime());
        Future<String> galileoFuture = executorService.submit(galileoCallable);
        System.out.println("Stage 3 :" + new Date().getTime());
        Future<String> sabreFuture = executorService.submit(sabreCallable);
        System.out.println("Stage 4 :" + new Date().getTime());
        Future<String> apolloFuture = executorService.submit(apolloCallable);
        System.out.println("Stage 5 :" + new Date().getTime());

        Map<String, String> results = new HashMap<>();
        try {
            results.put("Galileo", galileoFuture.get());
            results.put("Sabre", sabreFuture.get());
            results.put("Apollo", apolloFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            // handle exceptions
        }
        System.out.println("Stage 6 :" + new Date().getTime());
        return results;
    }
}
