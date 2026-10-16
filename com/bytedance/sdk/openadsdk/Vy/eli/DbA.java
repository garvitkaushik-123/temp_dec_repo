package com.bytedance.sdk.openadsdk.Vy.eli;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private final ev DbA;
    private int eli = Os.DbA;
    private final AtomicBoolean Os = new AtomicBoolean(false);
    private final AtomicBoolean aGH = new AtomicBoolean(true);
    private final AtomicInteger ui = new AtomicInteger(0);
    private long MGA = 0;
    private long kb = 0;
    private final Runnable wC = new Runnable() { // from class: com.bytedance.sdk.openadsdk.Vy.eli.DbA.3
        @Override // java.lang.Runnable
        public void run() {
            DbA.this.aGH();
        }
    };

    public DbA(ev evVar) {
        this.DbA = evVar;
    }

    public void eli() {
        if (this.ui.get() != 0) {
            return;
        }
        this.eli = this.DbA.RX() * 1000;
        this.ui.set(1);
        this.MGA = SystemClock.elapsedRealtime();
        Handler eli = eli.eli();
        if (eli != null) {
            eli.postDelayed(this.wC, this.eli);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH() {
        if (this.Os.compareAndSet(false, true)) {
            DbA();
            final long elapsedRealtime = this.kb + (SystemClock.elapsedRealtime() - this.MGA);
            this.kb = elapsedRealtime;
            cyF.Os(new wC("ev_tracker") { // from class: com.bytedance.sdk.openadsdk.Vy.eli.DbA.1
                @Override // java.lang.Runnable
                public void run() {
                    String eli = dZ.eli(DbA.this.DbA);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ev_wait_time_server", DbA.this.DbA.RX() * 1000);
                        jSONObject.put("ev_wait_time_client", elapsedRealtime);
                    } catch (JSONException e) {
                        Xb.Os("EvTracker", e.getMessage());
                    }
                    com.bytedance.sdk.openadsdk.aGH.Os.DbA(DbA.this.DbA, eli, DbA.this.DbA.Zor(), jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        if (this.ui.get() == 2) {
            this.MGA = SystemClock.elapsedRealtime();
            Handler eli = eli.eli();
            if (eli != null) {
                eli.postDelayed(this.wC, this.eli - this.kb);
            }
            this.ui.set(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MGA() {
        if (this.ui.get() != 1 || this.MGA == 0) {
            return;
        }
        Handler eli = eli.eli();
        if (eli != null) {
            eli.removeCallbacks(this.wC);
        }
        this.kb += SystemClock.elapsedRealtime() - this.MGA;
        this.MGA = 0L;
        this.ui.set(2);
    }

    public void DbA() {
        this.ui.set(3);
        Handler eli = eli.eli();
        if (eli != null) {
            eli.removeCallbacks(this.wC);
        }
    }

    public void eli(final int i) {
        Handler eli;
        if (this.ui.get() == 3 || (eli = eli.eli()) == null) {
            return;
        }
        eli.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Vy.eli.DbA.2
            @Override // java.lang.Runnable
            public void run() {
                if (i == 4 && DbA.this.aGH.get()) {
                    DbA.this.ui();
                    return;
                }
                int i2 = i;
                if (i2 == 8) {
                    DbA.this.MGA();
                } else if (i2 == 5) {
                    DbA.this.aGH();
                }
            }
        });
    }

    public void eli(boolean z) {
        this.aGH.set(z);
    }

    public boolean Os() {
        return this.ui.get() == 3;
    }
}
