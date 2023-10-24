package org.example.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JWTVerify extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        //Recuperer le token dans les headers avec la clé Authorization

        String header=request.getHeader("Authorization");

        if (header==null ||!header.startsWith("Bearer "))
        {
            filterChain.doFilter(request, response);
            return;
        }

        // Bearer token -> Supprimer 'bearer'
        String token=header.replace("Bearer ","");

        //---------Verify token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("monSecret")).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        //---------Créer un Spring User
        String username = decodedJWT.getSubject();
        List<String> roles = decodedJWT.getClaims().get("claims").asList(String.class);
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        for (String r :roles)
            authorities.add(new SimpleGrantedAuthority(r));
        UsernamePasswordAuthenticationToken user =
                new UsernamePasswordAuthenticationToken(username, null, authorities);

        //Placer l'utilisateur dans le contexte de sécurité de spring
        SecurityContextHolder.getContext().setAuthentication(user);
        filterChain.doFilter(request, response);// Continue la chaine des filtres


    }
}
