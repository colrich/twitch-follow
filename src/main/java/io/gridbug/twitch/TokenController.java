package io.gridbug.twitch;

import java.io.FileReader;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.bytecode.opencsv.CSVReader;

@RestController
public class TokenController {

	private static final String urlBase = "https://api.twitch.tv/kraken";

	@RequestMapping(value="/token", method=RequestMethod.GET)
	public String token(@RequestParam Map<String, String> params) {
		String token = params.get("access_token");
		
		try {
			// we take the input set as a csv
			CSVReader reader = new CSVReader(new FileReader("/Users/colrich/hayekm.csv"));
	
			String[] line = reader.readNext(); // read off header
			while ((line = reader.readNext()) != null) {
				if (line[1] != null && line[1].length() > 0) {
					// for each user in the csv, we PUT to the appropriate endpoint
					RestTemplate template = new RestTemplate();
					HttpHeaders headers = new HttpHeaders();
					headers.add("Accept", "application/vnd.twitchtv.v3+json");
					headers.add("Authorization", "OAuth " + token);
					HttpEntity<String> entity = new HttpEntity<>("", headers);
					template.put(urlBase+"/users/gr1dbug/follows/channels/"+line[1].trim().replace("\"", ""), entity);
				}
			}
		}
		catch (Exception e) { 
			e.printStackTrace();
		}
		
		return params.get("access_token");
	}
}
