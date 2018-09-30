package com.task.storage;

import com.task.storage.dto.ClientDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageApplicationTests {


	@Test
	public void addAndRetrieve() {
		String name = generateRandomString();
		createClient(name);
		String responseString = checkClientsList();
		Assert.assertTrue(responseString.contains(name));
	}


	public String checkClientsList() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:8080/api/client", String.class);
		System.out.println(response);
		Assert.assertNotNull(response);
		return response;
	}

	public void createClient(String name) {
		RestTemplate rt = new RestTemplate();
		ClientDto clientDto = new ClientDto();
		clientDto.setId(0L);
		clientDto.setName(name);
		ClientDto response = rt.postForObject("http://localhost:8080/api/client", clientDto, ClientDto.class);
		System.out.println(response);
		Assert.assertNotNull(response);
	}

	public String generateRandomString() {

		int num = new Random().nextInt();

		return "testName" + num;
	}

}
