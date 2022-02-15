package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class BearerTokenConverter implements ServerAuthenticationConverter {

    private final TokenStore tokenStore;

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        try {
            String token = exchange.getRequest().getHeaders().getFirst("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring("Bearer ".length());
                OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
                if (accessToken.isExpired()) {
                    return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token expired"));
                }
                Authentication userAuthentication = tokenStore.readAuthentication(token);
                return Mono.just(userAuthentication);
            }
        } catch (InvalidTokenException e) {
            return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token invalid"));
        }
        return Mono.empty();
    }

}