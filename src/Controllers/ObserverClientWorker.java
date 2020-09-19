package Controllers;

import MessagesClientServer.InnerMessage;

public interface ObserverClientWorker {
    void update(InnerMessage innerMessage);
}
