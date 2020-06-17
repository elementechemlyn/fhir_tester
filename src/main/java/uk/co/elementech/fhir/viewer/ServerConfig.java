package uk.co.elementech.fhir.viewer;

import ca.uhn.fhir.context.FhirVersionEnum;

public class ServerConfig {
    private Boolean home;
    private String id;
    private String name;
    private String baseUrl;
    private FhirVersionEnum fhirVersion;
    private String authUrl;
    private String clientId;
    private String clientSecret;

    public Boolean getHome(){
        return this.home;
    }
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getBaseUrl(){
        return this.baseUrl;
    }
    public FhirVersionEnum getFhirVersion(){
        return this.fhirVersion;
    }
    public String getAuthUrl(){
        return this.authUrl;
    }
    public String getClientId(){
        return this.clientId;
    }
    public String getClientSecret(){
        return this.clientSecret;
    }
    public void setHome(Boolean home){
        this.home = home;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    public void setFhirVersion(FhirVersionEnum fhirVersion){
        this.fhirVersion = fhirVersion;
    }
    public void setAuthUrl(String authUrl){
        this.authUrl = authUrl;
    }
    public void setClientId(String clientId){
        this.clientId = clientId;
    }
    public void setClientSecret(String clientSecret){
        this.clientSecret = clientSecret;
    }
}
