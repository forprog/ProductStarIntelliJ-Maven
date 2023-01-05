package SpringLikeThing;

import javax.annotation.PostConstruct;

@Deprecated
public class PolicemanImpl implements Policeman {
    @InjectByType
    Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("bang-bang!");
    }
}
