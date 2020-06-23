package uk.co.elementech.fhir.viewer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "viewer")
public class ViewerProperties {

    private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(FhirTesterConfig.class);

    private Map<String, ServerConfig> server = new HashMap<>();
    private Map<String, ServerConfig> serverByUrl = new HashMap<>();

    public String msg;
 
    public Map<String, ServerConfig> getServer() {
        return this.server;
    }
    public Map<String, ServerConfig> getServerByUrl() {
        return this.serverByUrl;
    }
    @PostConstruct
    private void postConstruct() {
		for (Map.Entry<String, ServerConfig> entry : server.entrySet()) {
		    serverByUrl.put(entry.getValue().getBaseUrl(), entry.getValue());
		}
    }
}