package com.ardakazanci.d11_sampleproject.Model;

public class FilmModel {

    private String idMovie; // Film id
    private String posterPath; // Poster Yolu
    private String overView; // Film Özeti
    private String releaseDate; // Yayınlanma Tarihi
    private String title; // Film Adı
    private String backdropPath; // Film arka yolu
    private String popularity; // Film Popüleritesi
    private String voteCount; // Film OylamaSI
    private String voteAverage; // Oy ortalaması
    private String keyVideo; // Video Yolu
    private String nameVideo; // Video Adı
    private String nameCast; // Cast Adı
    private String character; // Character
    private String profilePath; // Profil Yolu
    private String profilePathCrew;
    private String nameCrew;
    private String job;
    private String filePath;
    private String content;
    private String author;

    public FilmModel(){ // Varsayılan  Yapıcı Metot

    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getKeyVideo() {
        return keyVideo;
    }

    public void setKeyVideo(String keyVideo) {
        this.keyVideo = keyVideo;
    }

    public String getNameVideo() {
        return nameVideo;
    }

    public void setNameVideo(String nameVideo) {
        this.nameVideo = nameVideo;
    }

    public String getNameCast() {
        return nameCast;
    }

    public void setNameCast(String nameCast) {
        this.nameCast = nameCast;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getProfilePathCrew() {
        return profilePathCrew;
    }

    public void setProfilePathCrew(String profilePathCrew) {
        this.profilePathCrew = profilePathCrew;
    }

    public String getNameCrew() {
        return nameCrew;
    }

    public void setNameCrew(String nameCrew) {
        this.nameCrew = nameCrew;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
