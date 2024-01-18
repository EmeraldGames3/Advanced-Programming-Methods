public class CDplayer implements OldMediaPlayer{
    @Override
    public void play(String song) {
        System.out.println("Play on CD" + song);
    }
}
