package ru.yampolskiy.taskclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TaskClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskClientApplication.class, args);
    }

}
