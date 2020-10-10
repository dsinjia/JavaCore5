package models;

public class Data {
    private Album[] albums;
    public boolean allowDownload;
    private Artist[] artists;
    private String cdnUrl;
    private CurrentUser currentUser;
    private String currentVersion;
    private Interaction[] interactions;
    private String latestVersion;
    private Playlist[] playlists;
    private String[] recentPlayed;
    private Settings[] settings;
    private Song[] songs;
    private boolean supportsTranscoding;
    private boolean useLastFm;
    private boolean useYoutube;
    private boolean useiTunes;
    private User[] users;

    public Playlist[] getPlaylists() {
        return playlists;
    }
}
