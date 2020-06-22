package uk.co.elementech.fhir.viewer;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.uhn.fhir.to.BaseController;
import ca.uhn.fhir.to.model.HomeRequest;

import com.nimbusds.jwt.SignedJWT;

@org.springframework.stereotype.Controller("/token")
public class ViewerController extends BaseController {

    private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(TokenFinder.class);

    @RequestMapping(value = { "/token" })
	public String actionAbout(HttpServletRequest theServletRequest, final HomeRequest theRequest, final ModelMap theModel) {
        String activeToken;

        addCommonParams(theServletRequest, theRequest, theModel);
        ourLog.info("Doing token endppint");
		theModel.put("notHome", true);
        theModel.put("extraBreadcrumb", "About");

        activeToken = (String)theServletRequest.getSession().getAttribute("activeToken");
		try {
            SignedJWT idToken = SignedJWT.parse(activeToken);        
            theModel.put("activeTokenHeader",idToken.getHeader().toJSONObject().toString());
            theModel.put("activeTokenPayload",idToken.getPayload().toJSONObject().toString());
		} catch (ParseException e) {
			theModel.put("activeTokenHeader","");
			theModel.put("activeTokenPayload","");
		}


		return "token";
	}

}