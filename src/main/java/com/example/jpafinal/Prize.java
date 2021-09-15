package com.example.jpafinal;

import javax.persistence.*;

@Entity
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "PrizeId")
    private Integer Id;

    @Version
    private Integer version;

    private String match;

    private String win;

    private String odds;

    @ManyToOne
    @JoinColumn(name= "GameId")
    private Game game;

    //region

    public Prize() {    }

    public Prize(String match, String win, String odds) {
        this.match = match;
        this.win = win;
        this.odds = odds;
    }


    public Prize(Integer id, Integer version, String match, String win, String odds) {
        Id = id;
        this.version = version;
        this.match = match;
        this.win = win;
        this.odds = odds;
    }

    //endregion

    //region

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

//endregion
}
