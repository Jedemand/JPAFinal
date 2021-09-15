package com.example.jpafinal;

import javax.persistence.*;
import java.util.List;


@Entity
public class Game {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "GameId")
    private Integer Id;

    private String gameName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Prize> prizeList;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<State> stateList;

    //region

    public Game() {}

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public Game(Integer id, String gameName) {
        Id = id;
        this.gameName = gameName;
    }

    //endregion


    //region

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Prize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    //endregion
}
