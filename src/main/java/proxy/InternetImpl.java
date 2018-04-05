package proxy;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
public class InternetImpl implements Internet {

    @Override
    public String connectTo(String host) {
        return "Connected to " + host;
    }
}
