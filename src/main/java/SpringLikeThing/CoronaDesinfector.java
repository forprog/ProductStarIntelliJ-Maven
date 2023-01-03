package SpringLikeThing;

public class CoronaDesinfector {
    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private PoliceMan policeMan = ObjectFactory.getInstance().createObject(PoliceMan.class);

    public void start(Room room){
        announcer.announce("Всем выйти из комнаты!");
        policeMan.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Можно заходить обратно!");
    }

    private void desinfect(Room room){
        System.out.println("Дезинфекция");
    }
}
