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

}
