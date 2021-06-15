package com.example.mareu.events;

import com.example.mareu.models.Reunion;

public class DeleteReunionEvent {

    public Reunion reunion;

    public DeleteReunionEvent (Reunion reunion)
    {
        this.reunion = reunion;
    }

}
