package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokedexFactoryTest {
	
	@Test
	public void testCreatePokedex() {
		IPokedexFactory pokedexFactory = new PokedexFactory();
		IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
		IPokedex pokedex2 = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
		assertEquals(pokedex.getPokemons(), pokedex2.getPokemons());
	}

}
