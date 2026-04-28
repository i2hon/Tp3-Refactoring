package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    @Test
    public void buscarPersonaJdbiNombre(){
        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");
        new SetUpDatabase(jdbi).setUp();
        var repo = new PersonaRepository(jdbi);
        var personas = repo.buscarPorNombre("Vla");
        assertEquals(1,personas.size());
        assertEquals("Vladimir",personas.get(0).nombre());
        assertEquals("Varkov",personas.get(0).apellido());
    }

    @Test
    public void buscarPersonaJdbiID(){
        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");
        new SetUpDatabase(jdbi).setUp();
        var repo = new PersonaRepository(jdbi);
        var persona = repo.buscarId(1L);

        persona.ifPresent(P -> {
            assertEquals("José",P.nombre());
            assertEquals("Laurenti",P.apellido());
            });
    }
}
