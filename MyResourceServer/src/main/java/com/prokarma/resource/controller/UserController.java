package com.prokarma.resource.controller;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

@Controller
public class UserController {

	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/users/extra")
	@ResponseBody
	public Map<String, Object> getExtraInfo(Authentication auth) {
		OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) auth.getDetails();
		Map<String, Object> details = (Map<String, Object>) oauthDetails.getDecodedDetails();
		// System.out.println("User organization is " + details.get("organization"));
		details = parse(details);
		System.out.println("Your Token is " + oauthDetails.getTokenType() + ": " + oauthDetails.getTokenValue());
		for (String key : details.keySet()) {
			System.out.println(key + " = " + details.get(key));
		}

		return details;
	}

	private Map<String, Object> parse(Map<String, Object> oldDetails) {
		// TODO Auto-generated method stub
		Map<String, Object> details = oldDetails;
		String user = (String) oldDetails.get("user_name");
		JSONObject obj = new JSONObject(user);
		String firstName = obj.getJSONObject("User").getString("firstName");
		String lastName = obj.getJSONObject("User").getString("lastName");
		String email = obj.getJSONObject("User").getString("email");
		details.put("user_name", firstName + " " + lastName);
		details.put("email", email);
		return details;
	}
}
