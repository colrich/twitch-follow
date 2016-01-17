package io.gridbug.twitch;

import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import au.com.bytecode.opencsv.CSVReader;

@SpringBootApplication
public class FollowmeApplication implements CommandLineRunner {

	private static final String clientId = "hbpv2eh7ew5yfab4g03kfzfw1lqok5r";
	private static final String authUrl = "https://api.twitch.tv/kraken/oauth2/authorize?response_type=token&client_id="+clientId+"&redirect_uri=http://localhost:8080&scope=user_follows_edit";
	
	@Override
	public void run(String ...strings) throws Exception {
		getAuthPage();
	}

	private void getAuthPage() {
		try {
			// make the auth request that starts the workflow
			RestTemplate template = new RestTemplate();
			ResponseEntity re = template.getForEntity(authUrl, String.class);
			
			// we save the html output (after rebasing the relative links) to the tmp dir
			String authfn = System.getProperty("java.io.tmpdir") + "/twauth.html";
			FileWriter fw = new FileWriter(authfn);
			fw.write(re.getBody().toString().replace("/kraken", "https://api.twitch.tv/kraken"));
			fw.close();
			
			// then open that page in the browser and wait for the user to accept
			ProcessBuilder pb = new ProcessBuilder("open", authfn);
			Process p = pb.start();
			int exit = p.waitFor();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FollowmeApplication.class, args);
	}
}
