package uk.co.elementech.fhir.viewer;

import ca.uhn.fhir.context.FhirVersionEnum;

public class ServerConfig {
    private Boolean home;
    private String id;
    private String name;
    private String baseUrl;
    private FhirVersionEnum fhirVersion;
    private String tokenUrl;
    private String clientId;
    private String clientSecret;
    private String subjectIssuer;

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
    public String getTokenUrl(){
        return this.tokenUrl;
    }
    public String getClientId(){
        return this.clientId;
    }
    public String getClientSecret(){
        return this.clientSecret;
    }
    public String getSubjectIssuer(){
        return this.subjectIssuer;
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
    public void setTokenUrl(String authUrl){
        this.tokenUrl = authUrl;
    }
    public void setClientId(String clientId){
        this.clientId = clientId;
    }
    public void setClientSecret(String clientSecret){
        this.clientSecret = clientSecret;
    }
    public void setSubjectIssuer(String subjectIssuer){
        this.subjectIssuer = subjectIssuer;
    }
}
