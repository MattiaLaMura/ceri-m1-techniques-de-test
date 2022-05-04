package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {	
	
	@Test
	public void testMetadata() throws PokedexException {
		
		IPokemonMetadataProvider iPokemonMetadataProviderMock = Mockito.mock(IPokemonMetadataProvider.class);
		PokemonMetadata pokemonMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
		
		when(iPokemonMetadataProviderMock.getPokemonMetadata(anyInt())).thenAnswer(input -> {
			int index = input.getArgument(0);
			if(index > 150 || index < 0) {
				throw new PokedexException("Index out of range");
			}
			else {
				return pokemonMetadata;
			}
		});
		
		assertEquals(pokemonMetadata, iPokemonMetadataProviderMock.getPokemonMetadata(0));
		assertThrows(PokedexException.class,()->iPokemonMetadataProviderMock.getPokemonMetadata(-1));
		assertThrows(PokedexException.class,()->iPokemonMetadataProviderMock.getPokemonMetadata(155));
		
	}

}
