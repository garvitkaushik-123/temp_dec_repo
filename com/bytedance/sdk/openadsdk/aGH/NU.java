package com.bytedance.sdk.openadsdk.aGH;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class NU {
    private static volatile NU eli;
    private HandlerThread DbA;
    private Map<String, Object> MGA;
    private final Handler Os;
    private final Executor aGH = Executors.newCachedThreadPool();
    private DbA ui = DbA.eli();

    public static NU eli() {
        if (eli == null) {
            synchronized (NU.class) {
                if (eli == null) {
                    eli = new NU();
                }
            }
        }
        return eli;
    }

    public NU eli(Map<String, Object> map) {
        this.MGA = map;
        return eli();
    }

    private NU() {
        if (this.DbA == null) {
            this.DbA = com.bytedance.sdk.component.utils.wC.eli("OpenAppSuccEvent_HandlerThread", 10);
        }
        this.Os = new Handler(this.DbA.getLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.aGH.NU.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return true;
                }
                eli eliVar = (message.obj == null || !(message.obj instanceof eli)) ? null : (eli) message.obj;
                if (eliVar == null) {
                    return true;
                }
                NU.this.DbA(eliVar);
                return true;
            }
        });
    }

    public void eli(ev evVar, String str) {
        Message obtainMessage = this.Os.obtainMessage();
        obtainMessage.what = 100;
        obtainMessage.obj = eli.eli(evVar, str, this.MGA);
        obtainMessage.sendToTarget();
    }

    private void eli(eli eliVar) {
        if (eliVar == null) {
            return;
        }
        eliVar.DbA();
        if (eliVar.eli() * this.ui.eli > this.ui.DbA) {
            Os(eliVar.eli(false));
            return;
        }
        Message obtainMessage = this.Os.obtainMessage();
        obtainMessage.what = 100;
        obtainMessage.obj = eliVar;
        this.Os.sendMessageDelayed(obtainMessage, this.ui.eli);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(eli eliVar) {
        if (eliVar == null) {
            return;
        }
        boolean aGH = com.bytedance.sdk.openadsdk.core.Dfc.eli().aGH();
        boolean eli2 = com.bytedance.sdk.openadsdk.core.Dfc.eli().eli(true);
        if (aGH || !eli2) {
            if (eliVar.ui == null) {
                eliVar.ui = new HashMap();
            }
            eliVar.ui.put("is_background", Boolean.valueOf(aGH));
            eliVar.ui.put("has_focus", Boolean.valueOf(eli2));
            Os(eliVar.eli(true));
            return;
        }
        eli(eliVar);
    }

    private void Os(eli eliVar) {
        if (eliVar == null) {
            return;
        }
        this.aGH.execute(eliVar);
    }

    private static class eli implements Serializable, Runnable {
        public ev Os;
        public String aGH;
        public Map<String, Object> ui;
        public final AtomicInteger eli = new AtomicInteger(0);
        public final AtomicBoolean DbA = new AtomicBoolean(false);
        private final long MGA = SystemClock.elapsedRealtime();

        public static eli eli(ev evVar, String str, Map<String, Object> map) {
            return new eli(evVar, str, map);
        }

        public eli(ev evVar, String str, Map<String, Object> map) {
            this.Os = evVar;
            this.aGH = str;
            this.ui = map;
        }

        public eli eli(boolean z) {
            this.DbA.set(z);
            return this;
        }

        public int eli() {
            return this.eli.get();
        }

        public void DbA() {
            this.eli.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.Os == null || TextUtils.isEmpty(this.aGH)) {
                return;
            }
            String str = this.DbA.get() ? "dpl_success" : "dpl_failed";
            if (this.ui == null) {
                this.ui = new HashMap();
            }
            ev evVar = this.Os;
            if (evVar != null && evVar.MKR() == 0) {
                Map<String, Object> map = this.ui;
                ev evVar2 = this.Os;
                map.put("auto_click", Boolean.valueOf((evVar2 == null || evVar2.nn()) ? false : true));
            }
            this.ui.put("lifeCycleInit", Boolean.valueOf(com.bytedance.sdk.openadsdk.core.Dfc.eli().Os()));
            this.ui.put("duration", Long.valueOf(SystemClock.elapsedRealtime() - this.MGA));
            Os.eli(this.Os, this.aGH, str, this.ui);
        }
    }

    private static class DbA {
        public int eli = 300;
        public int DbA = 6000;

        private DbA() {
        }

        public static DbA eli() {
            return new DbA();
        }
    }
}
