package it.epiocde.progettoCantiereNavale.controllers.User;

import it.epiocde.progettoCantiereNavale.entities.User.User;
import it.epiocde.progettoCantiereNavale.exceptions.BadRequestExceptionHandler;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.requests.User.LoginRequest;
import it.epiocde.progettoCantiereNavale.requests.User.RegisterRequest;
import it.epiocde.progettoCantiereNavale.responses.DefaultResponse;
import it.epiocde.progettoCantiereNavale.responses.LoginResponse;
import it.epiocde.progettoCantiereNavale.security.JwtTools;
import it.epiocde.progettoCantiereNavale.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtTools jwtTools;
    @PostMapping("/register")
    public ResponseEntity<DefaultResponse> register(@RequestBody @Validated RegisterRequest registerRequest, BindingResult bindingResult) throws BadRequestExceptionHandler {
        if(bindingResult.hasErrors()){
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        }

        sendEmail(registerRequest.getEmail());
        return DefaultResponse.noMessage(userService.saveUser(registerRequest), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult) throws BadRequestExceptionHandler, NotFoundException {
        if(bindingResult.hasErrors())
            throw new BadRequestExceptionHandler(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList().toString());
        User user=userService.findByUsername(loginRequest.getUsername());
        if(!encoder.matches(loginRequest.getPassword(), user.getPassword())) throw new BadRequestExceptionHandler("Password errata");
        String token= jwtTools.createToken(user);
        return LoginResponse.login(token,user,HttpStatus.OK);
    }


    private String extractAdminUsernameFromToken(String authHeader) {
        String token = authHeader.substring(7);
        return jwtTools.extractUsername(token);
    }

    private void sendEmailFromAdmin(String recipientEmail, String subject, String message, String adminUsername) {
        String messageWithAdminUsername = message + "\n\nAdmin: " + adminUsername;

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(recipientEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(messageWithAdminUsername);

        mailSender.send(simpleMailMessage);
    }


    private void sendEmail(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Thank you for subscribe");
        simpleMailMessage.setText("Thank you very GRAZIE!");
        mailSender.send(simpleMailMessage);
    }





}
