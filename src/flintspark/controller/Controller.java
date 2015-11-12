package flintspark.controller;

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
		
		loop();
	}
	
	private boolean isInt(String input)
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
	
	private void loop()
	{
		while(intString != "quit")
		{
			
			intString = noteView.getResponce("Input new Note: ");
			
			while(!isInt(intString) && intString != "quit")
			{
				intString = noteView.getResponce("Input new Note: ");
			}
			
			notePlayer.setNotePitch(myPitch);
			
			notePlayer.playNote();
		}
	}
	
}
