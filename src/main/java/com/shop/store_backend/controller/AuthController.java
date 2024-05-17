package com.shop.store_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            // Set authentication in SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Generate JWT token
            UserDetails userDetails = userService.loadUserByUsername(loginRequest.getEmail());
            String jwtToken = jwtUtil.generateToken(userDetails);

            // Return token to the client
            return ResponseEntity.ok(new JwtResponse(jwtToken));
        } catch (UsernameNotFoundException | BadCredentialsException ex) {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid email/password");
        } catch (Exception ex) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred");
        }
    }
}
