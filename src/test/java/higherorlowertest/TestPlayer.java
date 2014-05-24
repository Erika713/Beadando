package higherorlowertest;

import static org.junit.Assert.*;
import higherorlower.Deck;
import higherorlower.Player;

import org.junit.Test;

public class TestPlayer {
	
	@Test
	public void testPlayer() {
		
		Player player1 = new Player("Player1");
	
		assertEquals("Player1", player1.getName());
	}
	
	@Test
	public void testHitCardValue() {
		
		Player player1 = new Player("Player1");
		Deck deck = new Deck();
		
		player1.hitCard(deck.getD().get(0));
		
		assertEquals(player1.getCurCard().getValue(), deck.getD().get(0).getValue());		
	}
	
	@Test
	public void testGetName() {
		
		Player player1 = new Player("Player1");
		assertEquals("Player1", player1.getName());
	}

	@Test
	public void testSetName() {
		
		Player player1 = new Player("Player1");
		player1.setName("Player2");
		
		assertEquals("Player2", player1.getName());
	}
	
	@Test
	public void testGetCash() {
		
		Player player1 = new Player("Player1");
		
		assertEquals(10000.0, player1.getCash(), 0.00001);
	}

	@Test
	public void testSetCash() {
		
		Player player1 = new Player("Player1");
		player1.setCash(50000);
		
		assertEquals(50000.0, player1.getCash(), 0.00001);
	}


}
