import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import ui.TestESimPackageDetails;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!!!");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {TestESimPackageDetails.class});
        testng.addListener(tla);
        testng.run();
    }
}
