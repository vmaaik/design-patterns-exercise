package proxy;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
public class InternetProxy implements Internet {

    private static List<String> restrictedHostList;

    static {
        restrictedHostList = new ArrayList<>();
        restrictedHostList.add("test.pl");
        restrictedHostList.add("test1.pl");
    }

    private InternetImpl internet;

    @Override
    public String connectTo(String host) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(host), "Host not defined");
        if (!restrictedHostList.contains(host)) {
            internet = new InternetImpl();
            return internet.connectTo(host);
        }
        throw new IllegalArgumentException("Application blocked. Host + " + host + "is restricted");
    }
}
