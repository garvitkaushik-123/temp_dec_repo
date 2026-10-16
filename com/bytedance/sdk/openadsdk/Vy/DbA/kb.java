package com.bytedance.sdk.openadsdk.Vy.DbA;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.Xb;

/* loaded from: classes3.dex */
public class kb {
    private static HandlerThread DbA;
    private static eli eli;

    public static void eli() {
    }

    public static void eli(DbA dbA) {
        if (dbA == null) {
            return;
        }
        DbA();
        eli eliVar = eli;
        if (eliVar != null) {
            eliVar.eli(dbA);
        }
    }

    public static void DbA(DbA dbA) {
        if (dbA == null || eli == null) {
            return;
        }
        try {
            int intValue = dbA.du().intValue();
            if (eli.hasMessages(intValue)) {
                eli.removeMessages(intValue);
            }
        } catch (Exception unused) {
        }
    }

    public static void DbA() {
        if (eli != null) {
            return;
        }
        try {
            HandlerThread handlerThread = DbA;
            if (handlerThread != null && handlerThread.isAlive()) {
                return;
            }
            synchronized (kb.class) {
                HandlerThread handlerThread2 = DbA;
                if (handlerThread2 == null || !handlerThread2.isAlive()) {
                    DbA = com.bytedance.sdk.component.utils.wC.eli("csj_MRC");
                    eli = new eli(DbA.getLooper());
                }
            }
        } catch (Throwable th) {
            Xb.Os("MRC", th.getMessage());
        }
    }

    private static class eli extends Handler {
        public eli(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DbA dbA = (DbA) message.obj;
            if (dbA == null) {
                return;
            }
            int DbA = dbA.DbA();
            if (DbA == 1) {
                dbA.kb();
            } else if (DbA == 2) {
                dbA.wC();
            } else {
                ui.DbA(dbA.du());
                return;
            }
            if (dbA.FC()) {
                ui.DbA(dbA.du());
            } else if (dbA.nlS()) {
                eli(dbA);
            }
        }

        public void eli(DbA dbA) {
            if (dbA == null) {
                return;
            }
            int intValue = dbA.du().intValue();
            if (hasMessages(intValue)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = intValue;
            obtain.obj = dbA;
            sendMessageDelayed(obtain, dbA.MGA());
        }
    }
}
