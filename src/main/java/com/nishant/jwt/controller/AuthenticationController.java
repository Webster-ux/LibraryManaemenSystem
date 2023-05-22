package com.nishant.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nishant.jwt.config.JwtUtil;
import com.nishant.jwt.model.AuthenticationRequest;
import com.nishant.jwt.model.AuthenticationResponse;
import com.nishant.service.UserService;

@RestController
public class AuthenticationController 
{
	@Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private JwtUtil jwTokenUtil;

    @PostMapping("/auth")
    public ResponseEntity<?>  createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Invalid username and password!", e);
        } catch (DisabledException e) {
            throw new Exception("Account is not active!", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
        //return jwt;
    }
    @PostMapping("/logout")
    public String logout(){
        return "logout";
    }

}
