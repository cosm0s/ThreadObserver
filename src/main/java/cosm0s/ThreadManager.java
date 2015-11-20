package cosm0s;

import cosm0s.config.Constants;
import cosm0s.domain.ThreadSpied;
import cosm0s.observers.ObjectSpy;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {

    private List<ThreadSpied> threads;

    public void start() throws InterruptedException {
        this.createThreads();
        int shoots = 0;
        do {
            ExecutorService executor = Executors.newFixedThreadPool(Constants.numberOfThreads);
            for (ThreadSpied threadSpied : this.threads) {
                executor.execute(threadSpied);
            }
            shoots++;
            Thread.sleep(Constants.sleepTimeInSeconds*1000);
            System.out.println("-----------------------------------------------------------------------");
        } while(shoots <= Constants.numberIterations);
    }

    private void createThreads(){
        this.threads = new LinkedList<ThreadSpied>();
        for(int i=0; i< Constants.numberOfThreads;i++){
            ThreadSpied threadSpied = new ThreadSpied();
            threadSpied.setThreadId(i);
            ObjectSpy objectSpy = new ObjectSpy();
            threadSpied.addObserver(objectSpy);
            this.threads.add(threadSpied);
        }
    }
}
