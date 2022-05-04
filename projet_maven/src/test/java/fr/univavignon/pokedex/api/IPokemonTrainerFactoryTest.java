package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	
	@Test
	public void testTrainer() {
		IPokemonTrainerFactory iPokemonTrainerFactoryMock = Mockito.mock(IPokemonTrainerFactory.class);
		IPokedexFactory iPokedexFactoryMock = Mockito.mock(IPokedexFactory.class);
		IPokedex iPokedexMock = Mockito.mock(IPokedex.class);
		PokemonTrainer pokemonTrainer = new PokemonTrainer("Mattia", Team.VALOR, iPokedexMock);
		
		when(iPokemonTrainerFactoryMock.createTrainer("Mattia", Team.VALOR, iPokedexFactoryMock)).thenReturn(pokemonTrainer);
	
		assertEquals(pokemonTrainer, iPokemonTrainerFactoryMock.createTrainer("Mattia", Team.VALOR, iPokedexFactoryMock));
	}

}
