package ru.yampolskiy.taskclient.clients;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Data
@Service
public class RestClientObject {
    private static final String BASE_URI = "http://localhost:8762/api/";

    protected RestClient restClient = RestClient.create(BASE_URI);
}