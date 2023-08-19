package app.advertising_board.utils;

import app.advertising_board.constants.Environments;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(Environments.TEST));
        switch (Environments.valueOf(env)){
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
            case TEST -> properties = PropertyUtils.propertyLoader("src/test/resources/test_config.properties");
            default -> throw new IllegalStateException("Invalid environment type: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl != null) return baseUrl;
        else throw new RuntimeException("Property baseUrl is not specified on the config.property file.");
    }

    public String getUserName(){
        String username = properties.getProperty("username");
        if(username != null) return username;
        else throw new RuntimeException("Property username is not specified on the config.property file.");
    }

    public String getPassword(){
        String password = properties.getProperty("password");
        if(password != null) return password;
        else throw new RuntimeException("Property password is not specified on the config.property file.");
    }

    public String getstartMaximized(){
        String startMaximized = properties.getProperty("startMaximized");
        if(startMaximized != null) return startMaximized;
        else throw new RuntimeException("Property startMaximized is not specified on the config.property file.");
    }

    public String getbrowser(){
        String browser = properties.getProperty("browser");
        if(browser != null) return browser;
        else throw new RuntimeException("Property browser is not specified on the config.property file.");
    }

    public String getTimeout(){
        String timeout = properties.getProperty("timeout");
        if(timeout != null) return timeout;
        else throw new RuntimeException("Property timeout is not specified on the config.property file.");
    }

    public String getIncorrectUserName(){
        String incorrectUserName = properties.getProperty("incorrectUserName");
        if(incorrectUserName != null) return incorrectUserName;
        else throw new RuntimeException("Property incorrectUserName is not specified on the config.property file.");
    }

    public String getIncorrectPassword(){
        String incorrectPassword = properties.getProperty("incorrectPassword");
        if(incorrectPassword != null) return incorrectPassword;
        else throw new RuntimeException("Property incorrectPassword is not specified on the config.property file.");
    }
}
