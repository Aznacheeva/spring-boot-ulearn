package com.example.springbootulearn;

import com.example.springbootulearn.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringBootUlearnApplication {
	//private static FileService fileService;

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootUlearnApplication.class, args);
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("-----------------------------------------------------");
			System.out.println("Введите имя файла: ");
			String fileName = scanner.nextLine();
			FileService fileService = new FileService();
			fileService.executeFunction(fileName);
		}
	}
}
