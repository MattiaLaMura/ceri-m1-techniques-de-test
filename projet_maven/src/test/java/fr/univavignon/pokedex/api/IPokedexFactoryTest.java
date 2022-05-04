package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	
	@Test
	public void testPokedex() {
		IPokedexFactory iPokedexFactoryMock = Mockito.mock(IPokedexFactory.class);
		IPokemonFactory iPokemonFactoryMock = Mockito.mock(IPokemonFactory.class);
		IPokemonMetadataProvider iPokemonMetadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);
		IPokedex iPokedexMock = Mockito.mock(IPokedex.class);
		
		when(iPokedexFactoryMock.createPokedex(iPokemonMetadataProviderMock, iPokemonFactoryMock)).thenReturn(iPokedexMock);
		
		assertEquals(iPokedexMock, iPokedexFactoryMock.createPokedex(iPokemonMetadataProviderMock, iPokemonFactoryMock));
		
	}

}
