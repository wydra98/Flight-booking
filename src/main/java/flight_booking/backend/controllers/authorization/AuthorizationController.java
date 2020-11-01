package flight_booking.backend.controllers.authorization;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.models.User;
import flight_booking.backend.services.UserService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@ExceptionProcessing
public class AuthorizationController {

    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Create new user")
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/register")
    ResponseEntity<User> register(@RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam String email,
                                  @RequestParam String password) {

        userService.validateRegistration(name, surname, email, password);
        User user = userService.addNewUser(name, surname, email, password);

        return ResponseEntity.created(URI.create("/" + user.getId())).body(user);
    }

    @ApiOperation(value = "Login as user")
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public TokenTransfer login(
            @RequestParam String email,
            @RequestParam String password) {

        userService.validateLogin(email, password);

        return userService.login(email, password);
    }
}
