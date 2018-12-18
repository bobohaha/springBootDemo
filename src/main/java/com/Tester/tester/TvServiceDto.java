package com.Tester.tester;

import java.util.Date;

public class TvServiceDto {

    private int id;
    private String name;

    public TvServiceDto(){}

    public TvServiceDto(int id, String name, int playNumber, Date time){
        this.id=id;
        this.name=name;
        this.playNumber=playNumber;
        this.time=time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayNumber() {
        return playNumber;
    }

    public void setPlayNumber(int playNumber) {
        this.playNumber = playNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    private int playNumber;
    private Date time;
}
