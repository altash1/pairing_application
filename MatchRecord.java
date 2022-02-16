package pairingApp;
import java.util.*;

// The purpose of this class is to create a self-contained object that can be reused with little modification for different card games.

// MatchRecord will keep track of who played whom based on the given list of players, and relevant methods to calculate tiebreakers?

public class MatchRecord
{
	// Instance variable declaration
	ArrayList<Player> playerList;				// The player list that we will receive as input
	boolean[][] matches;						// The 2D array that keeps track of who played whom
												// MatchRecord[i][j] -> if player id i and player id j have played, this value 
												// will be true, otherwise it will be false
	int playerNum;								// The number of players registered
	
	// Constructor - requires a player list as input, and number of players
	public MatchRecord(ArrayList<Player> input, int size)
	{
		this.playerList = input;
		this.playerNum = size;
		this.matches = new boolean[size][size];
		// initialize matches to false
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				this.matches[i][j] = false;
				
			}
		}
	}
	
	
	// Methods
	
	
	// Match people against other appropriate opponents
	// HOW TO PAIR PROPERLY
	public void pairRound(int roundNum)
	{
		for (int i = 0; i < this.playerNum; i++)
		{
			for (int j = i+1; j < this.playerNum; j++)
			{
				if(!this.matches[i][j] && this.playerList.get(i).getMatchPoints() == this.playerList.get(j).getMatchPoints())
				{
					
				}
			}
		}
	}
	
	// Update matches when two players play
	public void play(int winnerId, int loserId, int numGames)
	{
		if(!this.matches[winnerId][loserId])
		{
			this.matches[winnerId][loserId] = true;
			this.matches[loserId][winnerId] = true;
			this.playerList.get(winnerId).matchWin(numGames);
			this.playerList.get(loserId).matchLose(numGames);
		}
		else
		{
			System.out.println("Those players have already played!");
		}
		
	}
	
	// Calculate tiebreaker1: OMW% (in this method we will calculate the raw OMW%, but note that for MTG 1/3 is the lowest an individual 
	// MW% score can go for the purpose of calculating OMW%.
	public short tiebreaker1(int playerId)
	{
		short omw = 0;		// The tiebreaker1 value OMW%
		int numOpp = 0;		// number of opponents
		for(int j = 0; j < this.playerNum; j++)
		{
			if(this.matches[playerId][j])
			{
				omw += this.playerList.get(j).getMwPercent();
				numOpp++;
			}
		}
		
		if(numOpp > 0)
		{
			omw =  (short) (omw / numOpp);

		}
		
		return omw;
	}

}
