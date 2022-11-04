package ru.geekbrains.config;

public class ConfigFactory {

    public static Config create(String[] args){
        Config config;
        if(args.length == 3){
            return new ConfigFromCli(args);
        }else {
            return new ConfigFromFile("server.properties");
        }
    }
}
