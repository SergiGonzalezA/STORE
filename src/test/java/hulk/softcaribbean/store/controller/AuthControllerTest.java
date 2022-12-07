package hulk.softcaribbean.store.controller;

import hulk.softcaribbean.store.config.security.jwt.JwtUtils;
import hulk.softcaribbean.store.dto.LoginDto;
import hulk.softcaribbean.store.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class AuthControllerTest {
    @InjectMocks
    AuthController authController;

    @Mock
     UserService userService;

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    PasswordEncoder encoder;

    @Mock
    JwtUtils jwtUtils;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authenticateUser() {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail("sergio@gmail.com");
        loginDto.setPassword("1233456789");
        Authentication authentication= new Authentication() {
            @Override
            public boolean equals(Object another) {
                return false;
            }

            @Override
            public String toString() {
                return "";
            }

            @Override
            public int hashCode() {
                return 1;
            }

            @Override
            public String getName() {
                return "";
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }
        };
        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(jwtUtils.generateJwtToken(any())).thenReturn(anyString());

        authController.authenticateUser(loginDto);
    }

    @Test
    void registerUser() {
    }
}
