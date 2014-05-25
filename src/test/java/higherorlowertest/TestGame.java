package higherorlowertest;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import higherorlower.Card;
import higherorlower.Game;
import higherorlower.Player;

import org.junit.Test;

public class TestGame {
	
	@Test
	public void testGame() {
		Game g = new Game();
		
		assertNotNull(g.getPlayer1().getName());
		assertEquals(0, g.getCorrectAnswers());
		assertEquals(0, g.getWrongAnswers());
		assertEquals(0, g.getRoundNumber());
		assertFalse(g.isWin());
	}
	
	@Test
	public void testNewGame() {
		Game g = new Game();
		
		assertEquals(0, g.getCorrectAnswers());
		assertEquals(0, g.getWrongAnswers());
		assertEquals(0, g.getRoundNumber());
		assertFalse(g.isWin());
	}
	
	@Test
	public void testBaseStand() {
		Game g = new Game();
		
		assertNotNull(g.getPlayer1().getName());
		
		g.baseStand();
		
		assertEquals(1, g.getRoundNumber());
	}
	
	@Test
	public void testNewRound() {
		Game g = new Game();
		
		assertEquals(0, g.getRoundNumber());
		assertFalse(g.isWin());
	}
	
	@Test
	public void testCheckLowerTrue()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(10);
		g.checkLower();
		
		assertTrue(g.isWin());
		assertEquals(1, g.getCorrectAnswers());
		assertFalse(g.isEqualCards());
	}
	
	@Test
	public void testCheckLowerEqual()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getPlayer1().getCurCard().setValue(10);
		g.getActualCard().setValue(10);
		g.checkLower();
		
		assertTrue(g.isEqualCards());
	}
	
	@Test
	public void testCheckLowerFalse()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getPlayer1().getCurCard().setValue(10);
		g.getActualCard().setValue(3);
		g.checkLower();
		
		assertFalse(g.isWin());
		assertEquals(1, g.getWrongAnswers());
		assertFalse(g.isEqualCards());
	}
	
	@Test
	public void testCheckHigherTrue()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getPlayer1().getCurCard().setValue(10);
		g.getActualCard().setValue(3);
		g.checkHigher();
		
		assertTrue(g.isWin());
		assertEquals(1, g.getCorrectAnswers());
		assertFalse(g.isEqualCards());
	}
	
	@Test
	public void testCheckHigherEqual()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(3);
		g.checkHigher();
		
		assertTrue(g.isEqualCards());
	}
	
	@Test
	public void testCheckHigherFalse()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(10);
		g.checkHigher();
		
		assertFalse(g.isWin());
		assertEquals(1, g.getWrongAnswers());
		assertFalse(g.isEqualCards());
	}
	
	@Test
	public void testPlayerWin()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.playerWin(100);
		
		assertEquals(10200, g.getPlayer1().getCash(),0.00001);
	}
	
	@Test
	public void testPlayerLose()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.playerLose(100);
		
		assertEquals(9800, g.getPlayer1().getCash(),0.00001);
	}
	
	@Test
	public void testCheckEnd()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getPlayer1().setCash(0);
		g.checkEnd();
		
		assertTrue(g.isGameOver());
	}
	
	@Test
	public void testCheckEndGameOver()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(10);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(10);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(10);
		g.checkHigher();
		
		g.checkEnd();
		
		assertTrue(g.isGameOver());
	}
	
	public void testCheckEndWin()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		
		g.getPlayer1().getCurCard().setValue(10);
		g.getActualCard().setValue(5);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(8);
		g.getActualCard().setValue(4);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(8);
		g.getActualCard().setValue(4);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(6);
		g.getActualCard().setValue(2);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(10);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(2);
		g.checkHigher();
		
		g.getPlayer1().getCurCard().setValue(3);
		g.getActualCard().setValue(10);
		g.checkHigher();
		
		g.checkEnd();
		
		assertTrue(g.isFinalWin());
		assertTrue(g.getRoundNumber() == 7);
	}
	
	@Test
	public void testGetPlayer()
	{
		Game g = new Game();
		assertEquals("Player1", g.getPlayer1().getName());
	}
	
	@Test
	public void testGetRoundNumber()
	{
		Game g = new Game();
		g.baseStand();
		assertTrue(g.getRoundNumber() == 1);
		
		g.newRound();
		assertTrue(g.getRoundNumber() == 2);
		
	}
	
	@Test
	public void testGetHint()
	{
		Game g = new Game();
		g.newGame();
		g.baseStand();
		g.getActualCard().setValue(13);
		
		g.getHint();
		
		assertTrue(g.getHigherCards() == 0);
		assertTrue(g.getLowerCards() == 46);
		assertTrue(g.getUnusedCards() == 50);
	}
}
