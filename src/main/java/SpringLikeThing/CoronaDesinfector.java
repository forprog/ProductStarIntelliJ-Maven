package SpringLikeThing;

public class CoronaDesinfector {
    private Announcer announcer = new ConsoleAnnouncer();
    private PoliceMan policeMan = new PoliceManImpl();

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
