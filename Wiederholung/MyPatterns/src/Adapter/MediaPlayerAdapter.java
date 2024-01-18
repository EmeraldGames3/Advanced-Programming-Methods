package Adapter;

public class MediaPlayerAdapter implements NewMediaPlayer {
    private final OldMediaPlayer oldMediaPlayer;

    public MediaPlayerAdapter(OldMediaPlayer oldMediaPlayer) {
        this.oldMediaPlayer = oldMediaPlayer;
    }

    @Override
    public void play(String song) {
        oldMediaPlayer.play(song);
    }
}

