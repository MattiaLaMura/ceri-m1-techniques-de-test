package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	
	@Test
	public void testPokemon() {
		IPokemonFactory iPokemonFacotoryMock = Mockito.mock(IPokemonFactory.class);
		Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
		
		when(iPokemonFacotoryMock.createPokemon(anyInt(),eq(613),eq(64),eq(4000),eq(4))).thenAnswer(input -> {
			int index = input.getArgument(0);
			if(index > 150 || index < 0) {
				throw new PokedexException("Index out of range");
			}
			else {
				return pokemon;
			} 
		});
		
		assertEquals(pokemon, iPokemonFacotoryMock.createPokemon(0,613,64,4000,4));
		assertThrows(PokedexException.class,()->iPokemonFacotoryMock.createPokemon(-5,613,64,4000,4));
		assertThrows(PokedexException.class,()->iPokemonFacotoryMock.createPokemon(151,613,64,4000,4));
		
	}

}
