package com.bytedance.sdk.component;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class DbA {
    private static volatile Handler DbA;
    private static final Object eli = new Object();
    private static final LinkedList<Runnable> Os = new LinkedList<>();
    private static Object aGH = new Object();

    public static void eli(Runnable runnable, boolean z) {
        try {
            Handler DbA2 = DbA();
            synchronized (eli) {
                Os.add(runnable);
                if (z) {
                    DbA2.sendEmptyMessageDelayed(1, 100L);
                } else {
                    DbA2.sendEmptyMessage(1);
                }
            }
        } catch (OutOfMemoryError unused) {
        }
    }

    private static Handler DbA() {
        Handler handler;
        if (DbA == null) {
            synchronized (eli) {
                if (DbA == null) {
                    HandlerThread safeHandlerThread = com.bytedance.sdk.component.eli.eli != null ? com.bytedance.sdk.component.eli.eli.getSafeHandlerThread("queued-work-looper", -2) : null;
                    if (safeHandlerThread == null) {
                        safeHandlerThread = new HandlerThread("queued-work-looper", -2);
                        safeHandlerThread.start();
                    }
                    DbA = new eli(safeHandlerThread.getLooper());
                }
                handler = DbA;
            }
            return handler;
        }
        return DbA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os() {
        LinkedList linkedList;
        synchronized (aGH) {
            synchronized (eli) {
                LinkedList<Runnable> linkedList2 = Os;
                linkedList = (LinkedList) linkedList2.clone();
                linkedList2.clear();
                DbA().removeMessages(1);
            }
            if (linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }

    private static class eli extends Handler {
        eli(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                try {
                    DbA.Os();
                } catch (OutOfMemoryError unused) {
                }
            }
        }
    }
}
