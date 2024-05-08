package base;

import org.testng.annotations.BeforeClass;
import utils.rest_assured_config.RestConfig;

public class TestBase {

    @BeforeClass
    public static void setUp() {
        RestConfig.setUp();
    }
}
