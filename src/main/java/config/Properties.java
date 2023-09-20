package config;

import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/test/resources/properties/test.properties"
})
public interface Properties extends Reloadable {
    Properties properties = ConfigFactory.create(Properties.class);

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("chromedriver")
    String chromedriver();

    @Key("base.url")
    String baseUrl();
}