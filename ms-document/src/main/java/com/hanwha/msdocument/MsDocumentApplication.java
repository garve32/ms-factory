package com.hanwha.msdocument;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.hanwha.msdocument"
	, "com.hanwha.mscore"
})
public class MsDocumentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDocumentApplication.class, args);
	}

}
