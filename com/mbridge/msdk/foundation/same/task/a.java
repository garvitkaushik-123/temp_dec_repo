package com.mbridge.msdk.foundation.same.task;

/* compiled from: CommonTask.java */
/* loaded from: classes6.dex */
public abstract class a implements Runnable {
    public static long id;
    public InterfaceC0340a mListener;
    public b mState = b.READY;

    /* compiled from: CommonTask.java */
    /* renamed from: com.mbridge.msdk.foundation.same.task.a$a, reason: collision with other inner class name */
    public interface InterfaceC0340a {
        void a(b bVar);
    }

    /* compiled from: CommonTask.java */
    public enum b {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    public a() {
        id++;
    }

    private void setState(b bVar) {
        this.mState = bVar;
        InterfaceC0340a interfaceC0340a = this.mListener;
        if (interfaceC0340a != null) {
            interfaceC0340a.a(bVar);
        }
    }

    public final void cancel() {
        b bVar = this.mState;
        b bVar2 = b.CANCEL;
        if (bVar != bVar2) {
            setState(bVar2);
            cancelTask();
        }
    }

    public abstract void cancelTask();

    public final long getId() {
        return id;
    }

    public b getState() {
        return this.mState;
    }

    public abstract void pauseTask(boolean z);

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.mState == b.READY) {
                setState(b.RUNNING);
                runTask();
                setState(b.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public abstract void runTask();

    public void setOnStateChangeListener(InterfaceC0340a interfaceC0340a) {
        this.mListener = interfaceC0340a;
    }

    public final void setPause(boolean z) {
        b bVar = this.mState;
        b bVar2 = b.PAUSE;
        if (bVar == bVar2 || bVar == b.CANCEL || bVar == b.FINISH) {
            return;
        }
        if (z) {
            setState(bVar2);
        } else {
            setState(b.RUNNING);
        }
        pauseTask(z);
    }
}
