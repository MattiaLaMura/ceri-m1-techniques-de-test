package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PokedexTest {
	Pokedex pokedex;
	
	@Before
	public void init() {
		pokedex = new Pokedex(new PokemonMetadataProvider(),new PokemonFactory());
	}
	
	
	@Test
	public void testGetPokemonMetadata() throws PokedexException {
		PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(0);
		PokemonMetadata pokemonMetadata2 = new PokemonMetadata(0, "Bulbizarre", 0, 0, 0);
		assertEquals(pokemonMetadata.getName(), pokemonMetadata2.getName());
	}
	
	@Test
	public void testCreatePokemon() {
		Pokemon pokemon = new Pokemon(0, null, 0, 0, 0, 0, 0, 0, 0, 0);
		Pokemon pokemon2 = pokedex.createPokemon(0, 0, 0, 0, 0);
		assertEquals(pokemon.getCp(),pokemon2.getCp());
	}
	
	@Test
	public void testSize() {
		Pokedex pokedex2 = new Pokedex(new PokemonMetadataProvider(),new PokemonFactory());
		assertEquals(pokedex.size(),pokedex2.size());
	}
	
	@Test
	public void testAddPokemonAndGet() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "test", 0, 0, 0, 0, 0, 0, 0, 0);
		pokedex.addPokemon(pokemon);
		assertEquals(pokedex.getPokemon(pokedex.size()-1).getName(),pokemon.getName());
	}

}
