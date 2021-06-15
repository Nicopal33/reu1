package com.example.mareu.services;

import com.example.mareu.models.Reunion;

import java.util.Date;
import java.util.List;

public interface ReunionApiService {

    /**
     * Get all my Reunions
     * @return {@link java.util.List}
     */
    List<Reunion> getReunions();

    /**
     * Deletes a reunion
     * @param reunion
     *
     */
    void deleteReunion (Reunion reunion);

    /**
     * Create a reunion
     * @param reunion
     *
     */

    void createReunion (Reunion reunion);

    List<Reunion> dateFilter(Date date);


    List<Reunion> filterRoom(String filteredRoom);
}
