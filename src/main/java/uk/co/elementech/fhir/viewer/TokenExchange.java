package uk.co.elementech.fhir.viewer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class TokenExchange {

    private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(FhirTesterConfig.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String exchangeToken(ServerConfig serverConfig, String homeToken) {
        // TODO - Handle errors!!!
        ourLog.info("Exchanging token");
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("client_id", serverConfig.getClientId());
        map.add("client_secret", serverConfig.getClientSecret());
        map.add("grant_type", "urn:ietf:params:oauth:grant-type:token-exchange");
        map.add("subject_issuer", serverConfig.getSubjectIssuer());
        map.add("subject_token", homeToken);

        String tokenEndpoint = serverConfig.getTokenUrl();
        ResponseEntity<String> response = restTemplate.postForEntity(tokenEndpoint, map, String.class);
        JsonNode root = null;
        try {
            root = objectMapper.readTree(response.getBody());
        } catch (JsonMappingException ex) {
            ourLog.info("Failed to parse exchange response:" + ex.getMessage());
        } catch (JsonProcessingException ex) {
            ourLog.info("Failed to parse exchange response:" + ex.getMessage());
        }
        ourLog.info("Got response:" + root);
        return root.get("access_token").asText();
    }
}

