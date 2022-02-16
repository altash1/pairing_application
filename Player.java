package pairingApp;

// The Player class object contains all the information about a player

public class Player 
{
	// Instance variable declaration
	String name;			// Player name
	int id;					// Player id
	int matchPoints;		// Current total match points (W = 3 points, D = 1 point, L = 0 points)
	int gamesWon;			// Number of games won
	int numRounds;			// Number of rounds played
	short mwPercent;		// Match Win Percentage (matchPoints / Maximum Match Points Possible * 100)
	short gwPercent;		// Game Win Percentage (games won / Total Games Played * 100)
	short tiebreakerOne;	// First tie-breaker (Opponent Match Win Percentage
	short tiebreakerTwo;	// Second tie-breaker (Game Win Percentage)
	short tiebreakerThree;	// Third tie-breaker (Opponent Game Win Percentage)
	
	
	// Constructors
	public Player(String playerName, int playerId)
	{
		// Set name to input, and initialize other values
		this.name = playerName;
		this.id = playerId;
		this.matchPoints = 0;
		this.mwPercent = 0;
		this.gwPercent = 0;
		this.tiebreakerOne = 0;
		this.tiebreakerTwo = 0;
		this.tiebreakerThree = 0;
		this.numRounds = 0;
		this.gamesWon = 0;
	}
	
	// Real Methods
	public void matchWin(int numGames)
	{
		this.numRounds++;
		this.matchPoints += 3;
		this.mwPercent = (short) (this.matchPoints/(this.numRounds*3)*100);
		this.gamesWon += 2;
		this.gwPercent = (short) (this.gamesWon/(this.numRounds*2)*100);
	}
	
	public void matchLose(int numGames)
	{
		this.numRounds++;
		this.mwPercent = (short) (this.matchPoints/(this.numRounds*3)*100);
		this.gamesWon += numGames-2;
		this.gwPercent = (short) (this.gamesWon/(this.numRounds*2)*100);
	}
	
	// METHODS - Setters & Getters
	
	// Set name
	public void setName (String playerName)
	{
		this.name = playerName;
	}
	
	// Set id
	public void setId(int playerId)
	{
		this.id = playerId;
	}
	
	// Set match points
	public void setMatchPoints (int playerMatchPoints)
	{
		this.matchPoints = playerMatchPoints;
	}
	
	// Set match win %
	public void setMwPercent (short playerMwPercent)
	{
		this.mwPercent = playerMwPercent;
	}
	
	// Set game win %
	public void setGwPercent (short playerGwPercent)
	{
		this.gwPercent = playerGwPercent;
	}
	
	// Set tiebreakerOne
	public void setTiebreakerOne (short playerTiebreakerOne)
	{
		this.tiebreakerOne = playerTiebreakerOne;
	}
	
	// Set tiebreakerTwo
	public void setTiebreakerTwo (short playerTiebreakerTwo)
	{
		this.tiebreakerTwo = playerTiebreakerTwo;
	}
	
	// Set tiebreakerThree
	public void setTiebreakerThree (short playerTiebreakerThree)
	{
		this.tiebreakerThree = playerTiebreakerThree;
	}
	
	// Get name
	public String getName()
	{
		return this.name;
	}
	
	//Get id
	public int getId()
	{
		return this.id;
	}
	
	// Get matchPoints
	public int getMatchPoints()
	{
		return this.matchPoints;
	}
	// Get mwPercent
	public short getMwPercent()
	{
		return this.mwPercent;
	}
	
	// Get gwPercent
	public short getGwPercent()
	{
		return this.gwPercent;
	}
	
	// Get tiebreakerOne
	public short getTibreakerOne()
	{
		return this.tiebreakerOne;
	}
	
	// Get tiebreakerTwo
	public short getTibreakerTwo()
	{
		return this.tiebreakerTwo;
	}
	
	// Get tiebreakerThree
	public short getTibreakerThree()
	{
		return this.tiebreakerThree;
	}	
}