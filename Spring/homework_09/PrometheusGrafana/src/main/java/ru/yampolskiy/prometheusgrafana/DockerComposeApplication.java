package ru.yampolskiy.prometheusgrafana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DockerComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerComposeApplication.class, args);
        startDockerCompose();
    }

    private static void startDockerCompose() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("docker-compose", "up", "--detach");
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
