package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexTest {
	
	IPokedex iPokedexMock;
	
	@Before
	public void init() {
		iPokedexMock = Mockito.mock(IPokedex.class);
	}
	
	@Test
	public void testSize() {
		when(iPokedexMock.size()).thenReturn(22);
		assertEquals(22,iPokedexMock.size());
	}
	
	@Test
	public void testAddPokemon() {
		Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
		when(iPokedexMock.addPokemon(pokemon)).thenReturn(22);
		assertEquals(22,iPokedexMock.addPokemon(pokemon));
	}
	
	@Test
	public void testGetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
		when(iPokedexMock.getPokemon(anyInt())).thenAnswer(input -> {
			int index = input.getArgument(0);
			if(index > 150 || index < 0) {
				throw new PokedexException("Index out of range");
			}
			else {
				return pokemon;
			}
		});
		assertEquals(pokemon,iPokedexMock.getPokemon(22));
		assertThrows(PokedexException.class,()->iPokedexMock.getPokemon(-1));
		assertThrows(PokedexException.class,()->iPokedexMock.getPokemon(151));
	}
	
	@Test
	public void testGetPokemons() {
		List<Pokemon> pokemons = new ArrayList<>();
		pokemons.add(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56));
		pokemons.add(new Pokemon(1,"Aquali",186,168,260,2729,202,5000,4,100));
		
		when(iPokedexMock.getPokemons()).thenReturn(pokemons);
		
		assertEquals(pokemons,iPokedexMock.getPokemons());
	}

}
