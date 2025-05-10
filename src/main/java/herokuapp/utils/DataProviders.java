package herokuapp.utils;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> loginNegativeTest() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"tomsmit", "SuperSecretPassword!"});
        list.add(new Object[]{"tomsmith", "SuperSecretPassword"});
        list.add(new Object[]{"", "SuperSecretPassword!"});
        list.add(new Object[]{"tomsmith", ""});
        list.add(new Object[]{"", ""});
        return list.iterator();
    }
}
