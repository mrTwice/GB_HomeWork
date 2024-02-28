package ru.yampolskiy.taskclient.clients;

import jakarta.websocket.ClientEndpoint;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.yampolskiy.taskclient.models.user.Role;
import ru.yampolskiy.taskclient.models.user.User;


import java.util.Collections;
import java.util.List;

@Component
public class UserClientApi extends RestClientObject{

    public List<User> getUsers() {
        ParameterizedTypeReference<List<User>> userLst =
                new ParameterizedTypeReference<List<User>>(){};
        return restClient.get()
                .uri("/users")
                .retrieve()
                .body(userLst);
    }

    public User getUserById(Long id) {
        return restClient.get()
                .uri("/users/" + id)
                .retrieve()
                .toEntity(User.class).getBody();
    }

    public User findUserByUsername(String username){
        return restClient.get()
                .uri("/users/find/" + username)
                .retrieve()
                .toEntity(User.class).getBody();
    }

    public User createUser (User user){
        return restClient.post()
                .uri("/users")
                .body(user)
                .retrieve()
                .body(User.class);
    }

    public User updateUser (Long id, User user){
        return restClient.put()
                .uri("/users/" + id)
                .body(user)
                .retrieve()
                .body(User.class);
    }

    public void deleteUser(Long id){
        restClient.delete()
                .uri("/users/"+ id)
                .retrieve()
                .toBodilessEntity();
    }

//    public static void main(String[] args) {
//        UserClientApi userClientApi = new UserClientApi();
//        List<User> users =userClientApi.getUsers();
//        for (User user: users)
//            System.out.println(user);
//
//        System.out.println(userClientApi.getUserById(1L));

//        System.out.println(userClientApi.createUser(new User("Oka", "admin@example.org", "admin", true, Collections.singleton(Role.ADMIN))));
//        User user = userClientApi.getUserById(2L);
//        user.setUsername("Anna");
//        System.out.println(userClientApi.updateUser(user.getId(), user));
//        userClientApi.deleteUser(3L);
//        System.out.println(userClientApi.findUserByUsername("Petrucho").getUsername());
//
//    }
}
