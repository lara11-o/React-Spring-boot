package com.example.project.controllers.restController;


import com.example.project.DAO.User.UserDAO;
import com.example.project.DTO.UserLoginRequest;
import com.example.project.DTO.UserMessageDTO;
import com.example.project.Entity.User;
import com.example.project.Exception.OpportunityException.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostMapping("/sign_in")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserMessageDTO> addUser(@RequestBody User user){
        System.out.println("Starting signup.............");

        // Check if user name or email is empty
        if (user.getName().isEmpty() || user.getEmail().isEmpty()) {
            System.out.println("There is a problem with " + user);
            return ResponseEntity.badRequest().body(new UserMessageDTO("User should enter his name and email", false));
        }
        else {
            // Check if user with the same name or email already exists
            User existingUser = userDAO.findByNameOrEmail(user.getName(), user.getEmail());

            if (existingUser != null) {
                System.out.println("User with the same name or email already exists");
                return ResponseEntity.badRequest().body(new UserMessageDTO("User with the same name or email already exists", false));
            } else {
                userDAO.save(user);
                System.out.println("User signed in");
                return ResponseEntity.ok(new UserMessageDTO("User signed in", true));
            }
        }
    }


    @PostMapping("/login")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserMessageDTO> loginUser(@RequestBody UserLoginRequest userLoginreq) {
        System.out.println(",,,,,,,LOGIN,,,,,,,,");
        User user = userDAO.getByEmail(userLoginreq.getEmail());
        System.out.println(user);
        System.out.println(user.toString());

        if (user == null) {
            throw new NotFoundException("User not found with email: " + userLoginreq.getEmail());
        }

        if (!user.getPassword().equals(userLoginreq.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return ResponseEntity.ok(new UserMessageDTO("User logged in", true));

//        if(!user.getEmail().equals(userLoginreq.getEmail())){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(new UserMessageDTO("Login failed. Invalid email or password", false));
//        }
//        if (user != null && user.getPassword().equals(userLoginreq.getPassword())) {
//            System.out.println("The email of user "+ user.getId() + " is: " + userLoginreq.getEmail() );
//            return ResponseEntity.ok(new UserMessageDTO("User logged in", true));
//        } else {
//            System.out.println("The user failed to login!");
////            throw new UserNotFoundException("User not found with username: " + userLoginreq.getEmail());
////
//            return
//                    ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                            .body(new UserMessageDTO("Login failed. Invalid email or password", false));
//        }
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        int deletedUserId = userDAO.deleteUser(id);
        if (deletedUserId != -1) {
            return ResponseEntity.ok("User with ID " + deletedUserId + " has been deleted successfully");
        } else {
            throw new NotFoundException("User not found with id: " + id);
        }
    }


}
