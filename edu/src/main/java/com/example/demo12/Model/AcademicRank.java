package com.example.demo12.Model;

import javafx.collections.ObservableList;

public enum AcademicRank {
    ASSISTANT_PROFESSOR("assistant professor") ,
    PROFESSOR("professor"),
    ASSOCIATE_PROFESSOR("associate professor");

    public String getLable() {
        return lable;
    }

    private final String lable;

    AcademicRank(String lable) {
        this.lable = lable;
    }
    public static AcademicRank LabelValue(String label){
        for (AcademicRank e :values()){
            if(e.lable.equals(label)){
                return e;
            }
        }
        return null;
    }
}
