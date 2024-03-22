package it.epiocde.progettoCantiereNavale.controllers.User;


import com.cloudinary.Cloudinary;
import it.epiocde.progettoCantiereNavale.entities.User.User;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.User.RegisterRequest;
import it.epiocde.progettoCantiereNavale.requests.User.UserRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("")
    public ResponseEntity<DefaultResponse> getAllUsers(Pageable pageable) {
        return DefaultResponse.noMessage(userService.getAllUsers(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DefaultResponse> getUserById(@PathVariable Long id) throws NotFoundException {
        return DefaultResponse.noMessage(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<DefaultResponse> createUser(@RequestBody @Validated RegisterRequest registerRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors())
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        return DefaultResponse.noMessage(userService.saveUser(registerRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> updateUser(@PathVariable long id, @RequestBody UserRequest userRequest, BindingResult bindingResult) throws NotFoundException, BadRequestExceptionHandler {
        if (bindingResult.hasErrors())
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        return DefaultResponse.noMessage(userService.updateUser(id, userRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> deleteUser(@PathVariable Long id) throws NotFoundException {
        userService.deleteUser(id);
        return DefaultResponse.noObject("Users with id " + id + " has been deleted", HttpStatus.OK);
    }

    @PatchMapping("/{id}/upload")
    public ResponseEntity<DefaultResponse> uploadAvatar(@PathVariable long id, @RequestParam("upload") MultipartFile file) throws IOException, NotFoundException {
        User x = userService.uploadAvatar(id, (String) cloudinary.uploader().upload(file.getBytes(), new HashMap()).get("url"));
        return DefaultResponse.full("Avatar was uploaded successfully", x, HttpStatus.OK);
    }
}
