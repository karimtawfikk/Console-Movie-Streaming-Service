public class Regular extends User

{
    String [] subscription ={"Basic","Standard","Premium"};
    String []  watchlater;
    String []  watched;

    public Regular(String[] subscription, String[] watchlater, String[] watched) {
        this.subscription = subscription;
        this.watchlater = watchlater;
        this.watched = watched;
    }
}
