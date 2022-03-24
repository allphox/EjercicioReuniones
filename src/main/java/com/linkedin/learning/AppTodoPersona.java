package com.linkedin.learning;

import com.linkedin.learning.dao.PersonaDao;
import com.linkedin.learning.dominio.Acta;
import com.linkedin.learning.dominio.Persona;
import com.linkedin.learning.dominio.Reunion;
import com.linkedin.learning.dominio.Sala;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class AppTodoPersona {
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();

        Optional<Persona> optPersona = personaDao.get(1);
        if (optPersona.isPresent()) {
            Persona p = optPersona.get();
            System.out.println("Persona: " + p);

            Set<Reunion> reuniones = p.getReuniones();
            /*System.out.println("Reuniones: " + reuniones);*/

            Set<Sala> salas = new HashSet();
            Set<Persona> compis = new HashSet();
            Set<Acta> actas = new HashSet();
            for (Reunion reunion : reuniones) {
                salas.add(reunion.getSala());
                compis.addAll(reunion.getParticipantes());
                actas.add(reunion.getActa());
            }
            /*System.out.println("Salas: " + salas);
            System.out.println("Compis: " + compis);
            System.out.println("Actas: " + actas);*/
         }

    }
}
