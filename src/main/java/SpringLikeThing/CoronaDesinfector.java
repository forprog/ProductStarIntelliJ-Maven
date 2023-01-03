package SpringLikeThing;

public class CoronaDesinfector {
    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeMan;

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
