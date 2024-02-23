package ru.yampolskiy.webclient.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

@Service
@Getter
public class RestTemplateService {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    private RestTemplate restTemplate = new RestTemplate();



    public String getAccessToken(Principal principal) {
        return authorizedClientService
                .loadAuthorizedClient("reg-client", principal.getName())
                .getAccessToken().getTokenValue();
    }

}
