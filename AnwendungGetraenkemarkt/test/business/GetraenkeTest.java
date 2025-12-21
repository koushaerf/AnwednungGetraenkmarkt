package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetraenkeTest {
	private Getraenk getraenk;
	private String[]kiste = {"kiste"};

	@BeforeEach
	void setUp() throws Exception {
		
		
		getraenk = new Getraenk("65672", 5, 15, "ja", kiste);
	}

	@AfterEach
	void tearDown() throws Exception {
		getraenk = null;
	}

	@Test
	void test() {
		assertTrue(()->getraenk.getEinkaufspreis()==5,()->"Der Test war erfolgreich!");
		
		
		Throwable exc = assertThrows(IllegalArgumentException.class,()->{new Getraenk(null,5,15, "ja", kiste);});
		assertEquals("Artikelnummer darf nicht null sein", exc.getMessage());
	}

}
//65672,5,15,ja,Flaschen,Kiste