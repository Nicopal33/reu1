package com.example.mareu.services;

import com.example.mareu.models.Reunion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DummyReunionApiService implements ReunionApiService{

    private List<Reunion> reunions = DummyReunionGenerator.generateReunions();

    @Override
    public List<Reunion> getReunions() {
        return reunions;
    }

    @Override
    public void deleteReunion(Reunion reunion) {
        reunions.remove(reunion);
    }

    @Override
    public void createReunion(Reunion reunion) {
        reunions.add(reunion);
    }

    @Override
    public List<Reunion> dateFilter(Date filtereddate) {

        List<Reunion> dateList = new ArrayList<>();
        for (Reunion reunion : reunions) {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();

            cal1.setTime(filtereddate);
            cal2.setTime(reunion.getDate());

            boolean sameDate = cal1.get(Calendar.YEAR)==cal2.get(Calendar.YEAR) &&
                                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                                cal1.get(Calendar.DAY_OF_MONTH) ==cal2.get(Calendar.DAY_OF_MONTH);

            if (sameDate) {
                dateList.add(reunion);
            }
        }
        return dateList;

    }

    @Override
    public List<Reunion> filterRoom(String filteredRoom) {
        List<Reunion> roomList = new ArrayList<>();
            for (Reunion reunion:reunions) {
                if ((reunion.getRoom().equals(filteredRoom))) {
                    roomList.add(reunion);
                }
            }
            return roomList;
    }
}

