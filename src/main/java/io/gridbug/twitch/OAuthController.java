package io.gridbug.twitch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {

	@RequestMapping(value="/callback", method=RequestMethod.GET)
	public String token(HttpServletRequest request) {
		// the token is passed to the client after the #, so this js snippet redirects to another 
		// controller after removing the hash.
		String html = "<html><head><script>window.location=\"/token?\"+document.location.hash.replace(\"#\", \"\");</script></head></html>";
		return html;
	}
}
