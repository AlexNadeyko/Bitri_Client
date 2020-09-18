package Controllers;

import MessagesClientServer.InnerMessage;

public interface NotifierSignUp {
     void addObserver(ObserverSignUp observer);
     void removeObserver(ObserverSignUp observer);
     void notifyObserver(InnerMessage innerMessage);
}
