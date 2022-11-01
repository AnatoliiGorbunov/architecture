package ru.geekbrains;


import ru.geekbrains.config.Config;
import ru.geekbrains.logger.ConsoleLogger;
import ru.geekbrains.logger.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RequestHandler implements Runnable {

    private static final String www = "D:\\WorkingMaterials\\Architectures_and_design_patterns_in_ Java\\architecture\\www\\index.html";

    private static final Logger logger = new ConsoleLogger();
    private final Config config;


    private final SocketService socketService;

    public RequestHandler(Config config, SocketService socketService) {
        this.config = config;
        this.socketService = socketService;

    }


    @Override
    public void run() {

        List<String> request = socketService.readRequest();

        String[] parts = request.get(0).split(" ");


        Path path = Paths.get(www, parts[1]);
        if (!Files.exists(path)) {
            socketService.writeResponse(
                    "HTTP/1.1 404 NOT_FOUND\n" +
                            "Content-Type: text/html; charset=utf-8\n" +
                            "\n",
                    new BufferedReader(new StringReader("<h1>Файл не найден!</h1>\n"))
            );
            return;
        }


        try {
            socketService.writeResponse("HTTP/1.1 200 OK\n" +
                            "Content-Type: text/html; charset=utf-8\n" +
                            "\n",
                    Files.newBufferedReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Client disconnected!");
    }
}
