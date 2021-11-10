package com.example.springbootulearn;

import com.example.springbootulearn.Services.FileService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.Scanner;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringBootUlearnApplication {

	public static void main(String[] args) {
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
