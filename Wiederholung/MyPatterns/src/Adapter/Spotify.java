package Adapter;

public class Spotify implements NewMediaPlayer{
    @Override
    public void play(String song) {
        System.out.println("Play on Adapter.Spotify" + song);
    }
}
