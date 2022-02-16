package pairingApp;

import java.io.*;
import java.util.*;


public class Main 
{
	public static void main(String[] args)
	{			
		// MESSING AROUND TO FIND a data structure to keep track of players, and match records of who played whom
		
		
		// Create a data structure of all players and relevant information
		ArrayList<Player> playerList = new ArrayList<Player>();
		
		
		// Input a text file to read names from
		String inputFileName = "/Users/Sander/Desktop/input.txt";		// Current default input text file
		File inputFile = new File(inputFileName);
		Scanner sc = null;
		try 
		{
			sc = new Scanner(inputFile);
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		
		int playerId = 0; // LCV
		while (sc.hasNextLine())
		{
			Player newPlayer = new Player(sc.nextLine(), playerId);
			playerList.add(newPlayer);
			playerId++;
		}
		
		
		// Once we are done with initializing playerList we can create a 2D array to keep track of who played whom
		int size = playerList.size();
		MatchRecord matchRecord = new MatchRecord(playerList, size);
		
		
		// OUTPUT
		Player currentPlayer;		// Iterator
		
		// OUTPUT CHECK
		System.out.println("Name\t\t\tid\tPts\tOMW%\tGW%\tOGW%");
		System.out.println("_____________________________________________________________");
		
		currentPlayer = null;
		for (int i = 0; i < playerList.size(); i++)
		{
			currentPlayer = playerList.get(i);
			System.out.print(currentPlayer.getName());
			System.out.print("\t\t" + currentPlayer.getId());
			System.out.print("\t" + currentPlayer.getMatchPoints());
			System.out.print("\t" + currentPlayer.getTibreakerOne() + "%");
			System.out.print("\t" + currentPlayer.getGwPercent() + "%");
			System.out.println("\t" + currentPlayer.getTibreakerThree() + "%");
		}
		
		
		
		// SIMULATION
		
		// Round 1
		matchRecord.play(0, 1, 3);
		matchRecord.play(2, 3, 2);
		matchRecord.play(4, 5, 3);
		matchRecord.play(7, 6, 2);
		
		// Update tiebreakers
		for(int i = 0; i < size; i++)
		{
			playerList.get(i).setTiebreakerOne(matchRecord.tiebreaker1(i));
		}
		
		
		// Round 2
		
		
		
		
		// OUTPUT CHECK
		System.out.println("Name\t\t\tid\tPts\tOMW%\tGW%\tOGW%");
		System.out.println("_____________________________________________________________");
		
		currentPlayer = null;
		for (int i = 0; i < playerList.size(); i++)
		{
			currentPlayer = playerList.get(i);
			System.out.print(currentPlayer.getName());
			System.out.print("\t\t" + currentPlayer.getId());
			System.out.print("\t" + currentPlayer.getMatchPoints());
			System.out.print("\t" + currentPlayer.getTibreakerOne() + "%");
			System.out.print("\t" + currentPlayer.getGwPercent() + "%");
			System.out.println("\t" + currentPlayer.getTibreakerThree() + "%");
		}	
	}
}
