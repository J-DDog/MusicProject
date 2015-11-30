package flintspark.view;

import java.util.Scanner;

public class NoteView
{
	//Defining Data Members
	private Scanner noteScanner;
	
	public NoteView()
	{
		noteScanner = new Scanner(System.in);
	}
	
	public void displayMessage(String message)
	{
		System.out.println(message);
	}
	
	public String getResponce(String question)
	{
		String responce = "";
		
		System.out.println(question + "\n");
		responce = noteScanner.next();
		
		return responce;
	}
}
