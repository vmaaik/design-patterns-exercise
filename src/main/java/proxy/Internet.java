package proxy;

/**
 * Created by Michał Gębarowski on 04/04/2018
 */
public interface Internet {
    String connectTo(String host) throws Exception;
}
