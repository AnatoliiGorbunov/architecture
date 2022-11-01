package ru.geekbrains.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigFromFile implements Config{

    private final String wwwHome;
    private final int port;

    public ConfigFromFile(String fileName){
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream("server.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        this.wwwHome = prop.getProperty("www.home");
        this.port = Integer.parseInt(prop.getProperty("port"));
    }

    @Override
    public String getWwwHome() {
        return this.wwwHome;
    }

    @Override
    public int getPort() {
       return  this.port;
    }
}
