package io.bidmachine;

import io.bidmachine.ExpirationHandler;
import io.bidmachine.utils.task.CancelableTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class BidToken implements ExpirationHandler.Listener {
    private final AdRequest<?, ?, ?> adRequest;
    private final ExpirationHandler expirationHandler;
    private final ExpirationListener<BidToken> expirationListener;
    private final String id = UUID.randomUUID().toString();

    BidToken(AdRequest<?, ?, ?> adRequest, int expirationTimeSec, ExpirationListener<BidToken> expirationListener) {
        this.adRequest = adRequest;
        this.expirationHandler = new ExpirationHandler(TimeUnit.SECONDS.toMillis(expirationTimeSec), this, new BidTokenTaskScheduler());
        this.expirationListener = expirationListener;
    }

    public String getId() {
        return this.id;
    }

    public AdRequest<?, ?, ?> getAdRequest() {
        return this.adRequest;
    }

    void startExpiration() {
        this.expirationHandler.start();
    }

    void stopExpiration() {
        this.expirationHandler.stop();
    }

    void destroyAdRequest() {
        this.adRequest.clearNetworkAdUnits();
        this.adRequest.destroy();
    }

    @Override // io.bidmachine.ExpirationHandler.Listener
    public void onExpired() {
        this.expirationListener.onExpired(this);
    }

    private static class BidTokenTaskScheduler implements ExpirationHandler.TaskScheduler {
        private BidTokenTaskScheduler() {
        }

        @Override // io.bidmachine.ExpirationHandler.TaskScheduler
        public void scheduleTask(CancelableTask cancelableTask, long delayMs) {
            BidTokenTaskManager.schedule(cancelableTask, delayMs, TimeUnit.MILLISECONDS);
        }

        @Override // io.bidmachine.ExpirationHandler.TaskScheduler
        public void cancelTask(CancelableTask cancelableTask) {
            BidTokenTaskManager.cancel(cancelableTask);
        }
    }
}
