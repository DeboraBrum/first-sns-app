package com.deborasns;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deborasns.services.ServiceSnsAws;

@SpringBootApplication
public class DeborasnsApplication {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a mensagem a ser enviada.");
		String message = input.nextLine();
		
		ServiceSnsAws.sendMessage("Mensagem pelo app da Deb: " + message);
		
		input.close();
	}

}
