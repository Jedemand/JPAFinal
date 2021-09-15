package com.example.jpafinal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class State {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "StateId")
    private Integer Id;

    private String StateName;

    private String StateAbbrev;


    //region

    public State() {
    }

    public State(String stateName, String stateAbbrev) {
        StateName = stateName;
        StateAbbrev = stateAbbrev;
    }

    public State(Integer id, String stateName, String stateAbbrev) {
        Id = id;
        StateName = stateName;
        StateAbbrev = stateAbbrev;
    }

    //endregion



    //region

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String stateName) {
        StateName = stateName;
    }

    public String getStateAbbrev() {
        return StateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        StateAbbrev = stateAbbrev;
    }

//endregion
}
