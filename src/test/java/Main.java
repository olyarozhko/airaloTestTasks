import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import restApi.TestESims;
import restApi.TestOrders;
import ui.TestESimPackageDetails;

public class Main {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {TestESimPackageDetails.class, TestOrders.class, TestESims.class});
        testng.addListener(tla);
        testng.run();
    }
}
