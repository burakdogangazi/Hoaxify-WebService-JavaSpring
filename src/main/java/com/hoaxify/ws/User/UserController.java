package com.hoaxify.ws.User;

import com.hoaxify.ws.shared.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    //Webpack proxy kullanıldı Cross Origin kullanılmadı
    //http://localhost:8080/h2-console
    //jdbc:h2:mem:testdb


    @Autowired
    UserService userService;

    @PostMapping("/api/1.0/users")
    //@ResponseStatus(HttpStatus.CREATED) ok 200 yerine kullanılabilir
    public GenericResponse createUser(@RequestBody User user){
        log.info(user.toString());
        userService.save(user);
        return new GenericResponse("user_created");
    }
}
