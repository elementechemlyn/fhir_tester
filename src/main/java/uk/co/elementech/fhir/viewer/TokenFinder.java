package uk.co.elementech.fhir.viewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
class TokenFinder {

    private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(TokenFinder.class);
    @Autowired
    OAuth2AuthorizedClientService service;
    @Autowired
    private ViewerProperties viewerProperties;
    
    public String findToken(String baseUrl) {

        ourLog.debug("Finding a token for :" + baseUrl);
        ServerConfig serverConfig = viewerProperties.getServerByUrl().get(baseUrl);

        if(serverConfig.getHome()){
            ourLog.debug("Getting home token");
            //We're on the home server. Use the same token as the app
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            
            OAuth2AuthorizedClient oauthClient = service.loadAuthorizedClient(
               oauthToken.getAuthorizedClientRegistrationId(),
               oauthToken.getName());
    
            String accessToken = oauthClient.getAccessToken().getTokenValue();
            return accessToken;
        } else {
            ourLog.debug("Exchange home token for remote token");
            return "";
        }
    }
}