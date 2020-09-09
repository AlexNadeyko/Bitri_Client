package Views;

public interface NotifierChangeViewApp {

    public void addObserver(ObserverChangeViewApp observer);
    public void removeObserver(ObserverChangeViewApp observer);
    public void notifyObserver();

}
