package com.Test.Parse;

import com.Test.Parse.ReadData.FileConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParseApplication implements CommandLineRunner {
	@Autowired
	FileConversion fileConversion;

	public static void main(String[] args) {
		SpringApplication.run(ParseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fileConversion.conversion();
	}
}
