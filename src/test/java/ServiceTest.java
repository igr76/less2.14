import org.example.Service;
import org.testng.annotations.Test;

public class ServiceTest {
     private final Service service = new Service();

    @Test
    public void addTest() {
        String actual = service.add("add");


    }


}
