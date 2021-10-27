package com.example.springbootulearn;

import com.example.springbootulearn.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.FileNotFoundException;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringBootUlearnApplication implements CommandLineRunner {
	@Autowired
	FileService fileService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUlearnApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (args.length != 1) {
			System.out.println("Неверное количество аргументов");
			System.out.println("Введите имя файла");
			return;
		}
		try {
			fileService.executeFunction(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
		}
	}
}
