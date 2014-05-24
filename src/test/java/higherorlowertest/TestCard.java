package higherorlowertest;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import higherorlower.Card;

import org.junit.Test;

public class TestCard {

	@Test
	public void testGetValue() {
		Card card1 = new Card( 1 , new ImageIcon());
		Card card2 = new Card( 6 , new ImageIcon());
		
		assertEquals( 1 , card1.getValue());
		assertEquals( 6 , card2.getValue());
	}
	
	
	@Test
	public void testGetPicture(){
		ImageIcon image = new ImageIcon(TestCard.class.getResource("/01.png"));
		Card card1 = new Card( 1 , image);
		
		assertNotNull(image);
		assertEquals(image, card1.getPicture());
	}
	
	@Test
	public void testSetValue() {
		Card card1 = new Card( 1 , new ImageIcon());
		Card card2 = new Card( 5 , new ImageIcon());
		card1.setValue(5);
		card2.setValue(7);
		
		assertEquals( 5 , card1.getValue());
		assertEquals( 7 , card2.getValue());
	}
	
	@Test
	public void testSetPicture() {
		ImageIcon image1 = new ImageIcon(TestCard.class.getResource("/01.png"));
		ImageIcon image2 = new ImageIcon(TestCard.class.getResource("/21.png"));
		Card card1 = new Card( 1 , image1);
		card1.setPicture(image2);
		
		assertNotNull(image2);
		assertEquals(image2, card1.getPicture());
	}

}
