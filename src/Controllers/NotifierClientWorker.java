package Controllers;

import MessagesClientServer.InnerMessage;

public interface NotifierClientWorker {
     void addObserver(ObserverClientWorker observer);
     void removeObserver(ObserverClientWorker observer);
     void notifyObserver(InnerMessage innerMessage);
}
