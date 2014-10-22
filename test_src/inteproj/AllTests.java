package inteproj;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(value = Suite.class)
@SuiteClasses(value = { ReceiptTest.class, ProductCreateTest.class, DiscountTest.class })

public class AllTests {

}
