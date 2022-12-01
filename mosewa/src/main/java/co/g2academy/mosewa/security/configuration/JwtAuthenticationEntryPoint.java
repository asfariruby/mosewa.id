/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.security.configuration;

import java.io.IOException;
import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.springframework.data.redis.serializer.RedisSerializationContext.java;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
//This class will extend Spring's AuthenticationEntryPoint class and override its method commence. 
//It rejects every unauthenticated request and send error code 401
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
    
    @Override
    public void commence(
            HttpServletRequest request, 
            HttpServletResponse response, 
            AuthenticationException authException) 
            throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Unauthorized");
    }
    
}
