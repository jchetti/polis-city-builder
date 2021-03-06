package polis.game.gameLogic.actorsLogic;

import polis.game.gameLogic.GameView;
import polis.game.gameLogic.actors.Actor;
import polis.game.gameLogic.actors.Client;
import polis.game.gameLogic.tiles.Commerce;

public class ShopperModel extends ActActors{

    private final int customerAge = Integer.parseInt(engineProps.getProperty("customer.age"));

    public ShopperModel(ActorsModel model, GameView gameView) {
        super(model, gameView);
    }

    @Override
    public void act(Actor actor){
        sleepIfDone(actor);
        if(actor.getAge() <= 0){
            actor.getHouse().shopNotFound();
        }

        Commerce destination = (Commerce) findBuilding(actor, "commerce", "client");

        if(destination != null){
            model.removeActor(actor);
            Actor newActor = new Client(actor.getR(), actor.getC(), customerAge, gameView.getCELL_SIZE(), actor.getHouse(), actor.getHouseR(), actor.getHouseC(), destination, actor.getInhabNum());
            destination.addClient(newActor);
            model.addInhabitant(newActor);
            actor.getHouse().shopFound();
        }
        actor.age();
    }
}
