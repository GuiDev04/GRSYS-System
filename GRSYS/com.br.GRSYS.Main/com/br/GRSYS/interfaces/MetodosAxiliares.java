package com.br.GRSYS.interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MetodosAxiliares {


	public static void main(String[] args) {

		File local = new File("C:/Users/GSiqueira/Desktop/s.doc");
		
		try {
			System.out.println(Files.size(local.toPath())/1024);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
