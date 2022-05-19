package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokemonTrainerFactoryTest {
	
	@Test
	public void testCreateTrainer() {
		PokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
		PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Mattia", Team.INSTINCT, new PokedexFactory());
		PokemonTrainer trainer2 = new PokemonTrainer("Mattia",Team.INSTINCT,new Pokedex(new PokemonMetadataProvider(),new PokemonFactory()));
		assertEquals(trainer.getName(),trainer2.getName());
		assertEquals(trainer.getTeam(),trainer2.getTeam());
	}

}
