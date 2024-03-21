package it.epiocde.progettoCantiereNavale.security;

import it.epiocde.progettoCantiereNavale.entities.User.User;
import it.epiocde.progettoCantiereNavale.exceptions.NotFoundException;
import it.epiocde.progettoCantiereNavale.exceptions.UnauthorizedException;
import it.epiocde.progettoCantiereNavale.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTools jwtTools;
    @Autowired
    private UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String auth= request.getHeader("Authorization");

        if(auth==null|| !auth.startsWith("Bearer "))
            try {throw new UnauthorizedException("Token mancante!");}
            catch (UnauthorizedException e) {throw new RuntimeException(e);}

        String token=auth.substring(7);
        try {jwtTools.validateToken(token);}
        catch (UnauthorizedException e) {throw new RuntimeException(e);}

        String email= jwtTools.extractUsername(token);
        try {
            User user=userService.findByUsername(email);
            System.out.println(user.getAuthorities());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request,response);
        }
        catch (NotFoundException e) {throw new RuntimeException(e);}
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        return new AntPathMatcher().match("/api/auth/**", request.getServletPath());
    }
}
