package flintspark.controller;

import jm.JMC;

import flintspark.model.NotePlayer;
import flintspark.view.NoteView;

public class Controller
{
	//Declaring Data Members
	private NotePlayer notePlayer;
	private NoteView noteView;
	private String intString;
	private int myPitch;
	
	public Controller()
	{
		//Initializing Data Members
		notePlayer = new NotePlayer();
		noteView = new NoteView();
		
	}
	
	public void start()
	{
		
		notePlayer.playNote();
		
		intString = noteView.getResponce("Input new Note: ");
		
		loop();
	}
	
	private boolean isSInt(String input)
	{
		boolean convertWorked = false;
		
		try
		{
			myPitch = Integer.parseInt(input);
			convertWorked = true;
		}
		catch(NumberFormatException v)
		{
			noteView.displayMessage("Error not an integer - try again");
		}

		
		return convertWorked;
	}
	
	private int isKey(String input)
	{
		int keyFound = 0;
		
		if(input.equalsIgnoreCase("z"))
		{
			keyFound = JMC.C3;
		}
		else if(input.equalsIgnoreCase("x"))
		{
			keyFound = JMC.D3;
		}
		else if(input.equalsIgnoreCase("c"))
		{
			keyFound = JMC.E3;
		}
		else if(input.equalsIgnoreCase("v"))
		{
			keyFound = JMC.F3;
		}
		else if(input.equalsIgnoreCase("b"))
		{
			keyFound = JMC.G3;
		}
		else if(input.equalsIgnoreCase("n"))
		{
			keyFound = JMC.A4;
		}
		else if(input.equalsIgnoreCase("m"))
		{
			keyFound = JMC.B4;
		}
		else if(input.equalsIgnoreCase("s"))
		{
			keyFound = JMC.CS3;
		}
		else if(input.equalsIgnoreCase("d"))
		{
			keyFound = JMC.DS3;
		}
		else if(input.equalsIgnoreCase("g"))
		{
			keyFound = JMC.FS3;
		}
		else if(input.equalsIgnoreCase("h"))
		{
			keyFound = JMC.GS3;
		}
		else if(input.equalsIgnoreCase("j"))
		{
			keyFound = JMC.AS4;
		}
		
		return keyFound;
	}
	
	private void loop()
	{
		while(intString != "quit")
		{
			
			while(isKey(intString) == 0)
			{
				intString = noteView.getResponce("Input new Note: ");
			}
			
			notePlayer.setNotePitch(isKey(intString));
			
			notePlayer.playNote();
			
			intString = noteView.getResponce("Input new Note: ");
		}
	}
	
}
