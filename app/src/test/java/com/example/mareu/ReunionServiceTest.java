package com.example.mareu;


import com.example.mareu.di.DI;
import com.example.mareu.models.Reunion;
import com.example.mareu.services.DummyReunionGenerator;
import com.example.mareu.services.ReunionApiService;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


/**
 * Unit test on Reunion service
 */
public class ReunionServiceTest {

    private ReunionApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getReunionsWithSuccess() {
        List<Reunion> reunions = service.getReunions();
        List<Reunion> expectedReunions = DummyReunionGenerator.DUMMY_REUNION;
        assertThat(reunions, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedReunions.toArray()));

    }

    @Test
    public void deleteReunionWithSuccess() {
        Reunion reunionToDelete = service.getReunions().get(0);
        service.deleteReunion(reunionToDelete);
        assertFalse(service.getReunions().contains(reunionToDelete));
    }

    @Test
    public void createReunionWithSuccess() {
        Reunion reunionToCreate = new Reunion(13, "Commercial", new Date(),"Salle 3", "11h00", "12h00", "popol@gmail.com , franck@yahoo.fr , anne@hotmail.com , nico@gmail.com", "https://cdn2.iconfinder.com/data/icons/emoji-vol-3/512/10_Depressed_sad_face_emoticon_sad_smiley_unhappy-128.png");
        service.createReunion(reunionToCreate);
        assertTrue(service.getReunions().contains(reunionToCreate));
    }

    @Test
    public void filterRoomWithSuccess() {
        service.getReunions();
        List<Reunion> listReunions = service.filterRoom("Salle 2");
        for (Reunion reunion : listReunions) {
            assertSame("Salle 2", reunion.getRoom());

        }
    }

    @Test
    public void filterDateWithSuccess() {
        service.getReunions();
        Date date = new Date (1624147200);
        List<Reunion> listReunions = service.dateFilter(date);
        assertEquals(2,listReunions.size()) ;




    }

}