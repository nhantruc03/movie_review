package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;
import com.google.gson.JsonArray;


@SpringBootTest
class DemoApplicationTests {

	
	@Value("classpath:test/data2.json")
	Resource data;

	@Test
	void contextLoads() {
		StringBuilder stringBuilder = new StringBuilder("");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(data.getInputStream()))) {
			// test = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			String line;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		JsonArray jo = new Gson().fromJson(stringBuilder.toString(), JsonArray.class);
		System.out.println(jo.toString());

	}

}
