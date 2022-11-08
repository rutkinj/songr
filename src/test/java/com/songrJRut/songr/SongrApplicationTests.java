package com.songrJRut.songr;

import com.songrJRut.songr.albums.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void canMakeAlbum(){
		Album sut = new Album("Plock","Plone", 3, 731, "URL");
		assertNotNull(sut);
	}
	@Test
	void testGetters(){
		Album sut = new Album("Plock","Plone", 3, 731, "URL");
		assertEquals("Plock", sut.getTitle());
		assertEquals("Plone", sut.getArtist());
		assertEquals(3, sut.getSongCount());
	}

	@Test
	void testSetters(){
		Album sut = new Album("Nonsense","No Artist", 38733, 731, "URL");
		sut.setTitle("Plock");
		sut.setArtist("Plone");
		sut.setSongCount(3);
		assertEquals("Plock", sut.getTitle());
		assertEquals("Plone", sut.getArtist());
		assertEquals(3, sut.getSongCount());
	}
}
