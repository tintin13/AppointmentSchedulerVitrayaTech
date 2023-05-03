package com.apointmentScheduler.VitrayaAkundu.Model;

import java.sql.Time;

public class Rooms {
    private String Id;

    private Time openTime;
    private Time closeTime;



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }


    public Rooms(String id, Time openTime, Time closeTime) {
        Id = id;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

}
