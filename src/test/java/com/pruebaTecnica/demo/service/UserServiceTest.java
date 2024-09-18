package com.pruebaTecnica.demo.service;
import com.pruebaTecnica.demo.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);  // Inicializa los mocks
    }

    @Test
    public void testGetUsers() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("John Doe");

        User[] usersArray = {user1};

        when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class)).thenReturn(usersArray);

        List<User> users = userService.getUsers();

        assertEquals(1, users.size());
        assertEquals("John Doe", users.get(0).getName());
    }
}