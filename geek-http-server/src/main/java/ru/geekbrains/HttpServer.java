package ru.geekbrains;

import ru.geekbrains.config.Config;
import ru.geekbrains.config.ConfigFactory;
import ru.geekbrains.config.ConfigFromCli;
import ru.geekbrains.config.ConfigFromFile;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {

    private static final Logger logger = new ConsoleLogger();


    public static void main(String[] args) {
        Config config = ConfigFactory.create(args, "server.properties");

        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            logger.info("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                RequestParser requestParser = new RequestParser();
                logger.info("New client connected!");

                new Thread(new RequestHandler(config, new SocketService(socket))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
