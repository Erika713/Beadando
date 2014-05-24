package higherorlowertest;

import static org.junit.Assert.*;
import higherorlower.Deck;
import higherorlower.Card;

import org.junit.Test;

public class TestDeck {

	@Test
	public void testGetD() {
		Deck deck = new Deck();
		
		assertTrue(deck.getD().get(3) instanceof Card);
		assertTrue(deck.getD().get(7) instanceof Card);
	}

	
	@Test
	public void testInit(){
		Deck deck1 = new Deck();
		
		deck1.init();
		
		assertEquals(1, deck1.getD().get(0).getValue());
		assertEquals(10, deck1.getD().get(1).getValue());
		assertEquals(11, deck1.getD().get(2).getValue());
		assertEquals(12, deck1.getD().get(3).getValue());
		assertEquals(13, deck1.getD().get(4).getValue());
	}
	
	@Test
	public void testDeal() {
		
		Deck deck = new Deck();
		deck.deal();
		
		assertEquals(51, deck.getD().size());
	}


}
