package io.bidmachine;

import android.content.Context;
import io.bidmachine.core.Logger;
import io.bidmachine.core.TimeManager;
import io.bidmachine.core.Utils;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes7.dex */
public class SessionManager {
    public static final String SESSION_ID_EMPTY = "";
    private static final String TAG = "SessionManager";
    private static volatile SessionManager instance;
    private volatile Context applicationContext;
    private long pauseTime;
    private long resumeTime;
    private long sessionResetAfterSec;
    private long sessionStartTime;
    private String sessionId = "";
    private final CopyOnWriteArraySet<Observer> observers = new CopyOnWriteArraySet<>();

    interface Observer {
        void onSessionEvent(Status status);
    }

    enum Status {
        START,
        RESUME,
        PAUSE
    }

    static SessionManager get() {
        SessionManager sessionManager;
        SessionManager sessionManager2 = instance;
        if (sessionManager2 != null) {
            return sessionManager2;
        }
        synchronized (SessionManager.class) {
            sessionManager = instance;
            if (sessionManager == null) {
                sessionManager = new SessionManager();
                instance = sessionManager;
            }
        }
        return sessionManager;
    }

    private SessionManager() {
        startNewSession();
    }

    synchronized void attachContext(Context context) {
        boolean z = this.applicationContext == null;
        this.applicationContext = context.getApplicationContext();
        if (z) {
            onContextAttached();
        }
    }

    private void onContextAttached() {
        onNewSessionStarted();
    }

    void startNewSession() {
        this.sessionId = UUID.randomUUID().toString();
        this.sessionStartTime = TimeManager.currentTimeMillis();
        this.pauseTime = 0L;
        this.resumeTime = 0L;
        onNewSessionStarted();
        notifyObservers(Status.START);
        Logger.d(TAG, "New session started");
    }

    private void onNewSessionStarted() {
        Utils.ifNotNull(this.applicationContext, new Executable() { // from class: io.bidmachine.SessionManager$$ExternalSyntheticLambda0
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                SessionManager.lambda$onNewSessionStarted$0((Context) obj);
            }
        });
    }

    static /* synthetic */ void lambda$onNewSessionStarted$0(Context context) {
        BidMachineSharedPreference.incrementSessionCount(context);
        BidMachineSharedPreference.applyCurrentToLastSessionDuration(context);
    }

    int getSessionCount() {
        Context context = this.applicationContext;
        if (context == null) {
            Logger.w(TAG, "Context not attached");
            return 0;
        }
        return BidMachineSharedPreference.getSessionCount(context);
    }

    String getSessionId() {
        return this.sessionId;
    }

    void setSessionResetAfter(long sessionResetAfterSec) {
        this.sessionResetAfterSec = sessionResetAfterSec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resume() {
        long currentTimeMillis = TimeManager.currentTimeMillis();
        long j = this.sessionResetAfterSec;
        if (j > 0) {
            long j2 = this.pauseTime;
            if (j2 > 0 && currentTimeMillis - j2 >= j * 1000) {
                startNewSession();
                this.resumeTime = currentTimeMillis;
            }
        }
        notifyObservers(Status.RESUME);
        Logger.d(TAG, "Session resumed");
        this.resumeTime = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pause() {
        if (this.resumeTime == 0) {
            return;
        }
        this.pauseTime = TimeManager.currentTimeMillis();
        notifyObservers(Status.PAUSE);
        Utils.ifNotNull(this.applicationContext, new Executable() { // from class: io.bidmachine.SessionManager$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                SessionManager.this.saveCurrentSessionDuration((Context) obj);
            }
        });
        Logger.d(TAG, "Session paused: " + getSessionDurationSec() + " sec.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCurrentSessionDuration(final Context context) {
        Utils.onBackgroundThread(new Runnable() { // from class: io.bidmachine.SessionManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SessionManager.this.m9637lambda$saveCurrentSessionDuration$1$iobidmachineSessionManager(context);
            }
        });
    }

    /* renamed from: lambda$saveCurrentSessionDuration$1$io-bidmachine-SessionManager, reason: not valid java name */
    /* synthetic */ void m9637lambda$saveCurrentSessionDuration$1$iobidmachineSessionManager(Context context) {
        BidMachineSharedPreference.storeCurrentSessionDurationMs(context, getSessionDurationMs());
    }

    int getSessionDurationSec() {
        return (int) (getSessionDurationMs() / 1000);
    }

    private long getSessionDurationMs() {
        if (this.resumeTime == 0) {
            return 0L;
        }
        return TimeManager.currentTimeMillis() - this.sessionStartTime;
    }

    int getLastSessionDurationSec() {
        return (int) (getLastSessionDurationMs() / 1000);
    }

    private long getLastSessionDurationMs() {
        Context context = this.applicationContext;
        if (context == null) {
            Logger.w(TAG, "Context not attached");
            return 0L;
        }
        return BidMachineSharedPreference.getLastSessionDurationMs(context);
    }

    void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers(Status status) {
        Iterator<Observer> it = this.observers.iterator();
        while (it.hasNext()) {
            it.next().onSessionEvent(status);
        }
    }
}
