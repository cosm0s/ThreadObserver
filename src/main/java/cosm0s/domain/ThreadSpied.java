package cosm0s.domain;

import java.util.Observable;

public class ThreadSpied extends Observable implements Runnable {

    private int threadId;

    @Override
    public void run() {
        setChanged();
        notifyObservers("id [" + threadId + "]");
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }
}