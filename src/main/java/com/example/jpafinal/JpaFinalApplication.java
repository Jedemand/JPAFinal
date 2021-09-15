package com.example.jpafinal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootApplication
public class JpaFinalApplication {

    private static final Logger Log = LoggerFactory.getLogger(JpaFinalApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaFinalApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PrizeRepository prizeRepository, GameRepository gameRepository, StateRepository stateRepository) {
        return (args) -> {
            Log.info("It's working");

            stateRepository.save(new State("Minnesota", "MN"));
            stateRepository.save(new State("Wisconsin", "WI"));
            stateRepository.save(new State("North Dakota", "ND"));
            stateRepository.save(new State("South Dakota", "SD"));
            stateRepository.save(new State("Iowa", "IA"));

            Game gottoLotto = new Game("Gotto Lotto");
            Game hottoLotto = new Game("Hotto Lotto");
            Game nottoLotto = new Game("Notto Lotto");
            
            List<Prize> gottoPrizes = new ArrayList<>();
            gottoPrizes.add(new Prize("1 of 5", "$2", "1 in 16"));
            gottoPrizes.add(new Prize("2 of 5", "$4", "1 in 32"));
            gottoPrizes.add(new Prize("3 of 5", "$8", "1 in 64"));
            gottoPrizes.add(new Prize("4 of 5", "$16", "1 in 128"));
            gottoPrizes.add(new Prize("5 of 5", "$32", "1 in 256"));
            
            gottoLotto.setPrizeList(gottoPrizes);
            
            List<Prize> hottoPrizes = new ArrayList<>();
            hottoPrizes.add(new Prize("1 of 3", "$200", "1 in 100"));
            hottoPrizes.add(new Prize("2 of 3", "$300", "1 in 200"));
            hottoPrizes.add(new Prize("3 of 3", "$400", "1 in 300"));

            hottoLotto.setPrizeList(hottoPrizes);

            List<Prize> nottoPrizes = new ArrayList<>();
            nottoPrizes.add(new Prize("10 of 3", "$0", "Hilbert's Hotel running out of Rooms"));
            nottoPrizes.add(new Prize(".5 of PI", "Pie", "Russel's barber getting a shave"));
            nottoPrizes.add(new Prize("Live Cat in Box", "That Cat", "Spin of a electron"));

            nottoLotto.setPrizeList(nottoPrizes);
            
            gameRepository.save(gottoLotto);
            gameRepository.save(hottoLotto);
            gameRepository.save(nottoLotto);



            //GOTTO STATES
            Optional<Game> hypoGotto = gameRepository.findById(1);
            Game actualGotto = hypoGotto.get();

            List<State> stateGottoList = new ArrayList<>();
            Optional<State> gottoStateHypo1 = stateRepository.findById(1);
            State gottoState1 = gottoStateHypo1.get();
            stateGottoList.add(gottoState1);
            Optional<State> gottoStateHypo2 = stateRepository.findById(2);
            State gottoState2 = gottoStateHypo2.get();
            stateGottoList.add(gottoState2);
            Optional<State> gottoStateHypo3 = stateRepository.findById(3);
            State gottoState3 = gottoStateHypo3.get();
            stateGottoList.add(gottoState3);
            Optional<State> gottoStateHypo4 = stateRepository.findById(4);
            State gottoState4 = gottoStateHypo4.get();
            stateGottoList.add(gottoState4);
            Optional<State> gottoStateHypo5 = stateRepository.findById(5);
            State gottoState5 = gottoStateHypo5.get();
            stateGottoList.add(gottoState5);
            
            actualGotto.setStateList(stateGottoList);

            for(Prize prize: gottoPrizes){
                prize.setGame(actualGotto);
                prizeRepository.save(prize);
            }
            gameRepository.save(actualGotto);
            
            
            
            //HOTTO STATES
            Optional<Game> hypoHotto = gameRepository.findById(2);
            Game actualHotto = hypoHotto.get();

            List<State> stateHottoList = new ArrayList<>();
            Optional<State> HottoStateHypo1 = stateRepository.findById(1);
            State HottoState1 = HottoStateHypo1.get();
            stateHottoList.add(HottoState1);
            Optional<State> HottoStateHypo2 = stateRepository.findById(2);
            State HottoState2 = HottoStateHypo2.get();
            stateHottoList.add(HottoState2);
            Optional<State> HottoStateHypo5 = stateRepository.findById(5);
            State HottoState5 = HottoStateHypo5.get();
            stateHottoList.add(HottoState5);
            
            actualHotto.setStateList(stateHottoList);

            for(Prize prize: hottoPrizes){
                prize.setGame(actualHotto);
                prizeRepository.save(prize);
            }
            gameRepository.save(actualHotto);


            //NOTTO STATE(S)
            Optional<Game> hypoNotto = gameRepository.findById(3);
            Game actualNotto = hypoNotto.get();

            List<State> stateNottoList = new ArrayList<>();
            Optional<State> NottoStateHypo5 = stateRepository.findById(5);
            State NottoState5 = NottoStateHypo5.get();
            stateNottoList.add(NottoState5);

            actualNotto.setStateList(stateNottoList);

            for(Prize prize: nottoPrizes){
                prize.setGame(actualNotto);
                prizeRepository.save(prize);
            }

            gameRepository.save(actualNotto);
            
            
            Optional<Game> gottoReadHypo = gameRepository.findById(1);
            Game gottoRead = gottoReadHypo.get();
            Optional<Game> hottoReadHypo = gameRepository.findById(2);
            Game hottoRead = hottoReadHypo.get();
            Optional<Game> nottoReadHypo = gameRepository.findById(3);
            Game nottoRead = nottoReadHypo.get();




            Log.info("Lottery #1: " + gottoRead.getGameName() + "Playable in: ");
            for(State state: gottoRead.getStateList()){
                Log.info(state.getStateName());
            }
            Log.info("Lottery #1 prizes include: " );
            for(Prize prize: prizeRepository.findAll()) {
                if (prize.getGame().getId().equals(gottoRead.getId())) {
                    Log.info("Match: " + prize.getMatch() + " Prize: " + prize.getWin() + " Odds: " + prize.getOdds());

                }
            }


            Log.info("Lottery #2: " + hottoRead.getGameName() + "Playable in: ");
            for (State state : hottoRead.getStateList()) {
                    Log.info(state.getStateName());
                }
                Log.info("Lottery #2 prizes include: " );
                for (Prize prize : prizeRepository.findAll()) {
                    if (Objects.equals(prize.getGame().getId(), hottoRead.getId())) {
                        Log.info("Match: " + prize.getMatch() + " Prize: " + prize.getWin() + " Odds: " + prize.getOdds());
                    }
                }

                Log.info("Lottery #3: " + nottoRead.getGameName() + " Playable in: ");
                for (State state : nottoRead.getStateList()) {
                    Log.info(state.getStateName());
                }
                Log.info("Lottery #3 prizes include: ");
                for (Prize prize : prizeRepository.findAll()) {
                    if (Objects.equals(prize.getGame().getId(), nottoRead.getId())) {
                        Log.info("Match: " + prize.getMatch() + " Prize: " + prize.getWin() + " Odds: " + prize.getOdds());
                    }
                }

        };
    }


}
