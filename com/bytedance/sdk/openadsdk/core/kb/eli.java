package com.bytedance.sdk.openadsdk.core.kb;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.settings.MGA;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes3.dex */
public class eli {
    private static volatile boolean DbA;
    private static volatile long Os;
    private static volatile eli eli;
    private Handler ui;
    private final Queue<C0192eli> aGH = new LinkedList();
    private final MGA MGA = dV.aGH();

    private eli() {
    }

    public static eli eli() {
        if (eli == null) {
            synchronized (eli.class) {
                if (eli == null) {
                    eli = new eli();
                }
            }
        }
        return eli;
    }

    private synchronized boolean DbA(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int bf = this.MGA.bf();
        long Xb = this.MGA.Xb();
        if (this.aGH.size() > 0 && this.aGH.size() >= bf) {
            long abs = Math.abs(currentTimeMillis - this.aGH.peek().eli);
            if (abs <= Xb) {
                DbA(Xb - abs);
                return true;
            }
            this.aGH.poll();
            this.aGH.offer(new C0192eli(currentTimeMillis, str));
        } else {
            this.aGH.offer(new C0192eli(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean eli(String str) {
        if (DbA(str)) {
            eli(true);
            eli(Os);
        } else {
            eli(false);
        }
        return DbA;
    }

    private synchronized void eli(long j) {
        if (this.ui == null) {
            this.ui = new Handler(Looper.getMainLooper());
        }
        this.ui.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.kb.eli.1
            @Override // java.lang.Runnable
            public void run() {
                eli.this.eli(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eli(boolean z) {
        DbA = z;
    }

    public synchronized boolean DbA() {
        return DbA;
    }

    private synchronized void DbA(long j) {
        Os = j;
    }

    public synchronized String Os() {
        String str;
        HashMap hashMap = new HashMap();
        for (C0192eli c0192eli : this.aGH) {
            if (hashMap.containsKey(c0192eli.DbA)) {
                hashMap.put(c0192eli.DbA, Integer.valueOf(((Integer) hashMap.get(c0192eli.DbA)).intValue() + 1));
            } else {
                hashMap.put(c0192eli.DbA, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : hashMap.keySet()) {
            int intValue = ((Integer) hashMap.get(str2)).intValue();
            if (i < intValue) {
                str = str2;
                i = intValue;
            }
        }
        return str;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.kb.eli$eli, reason: collision with other inner class name */
    private static class C0192eli {
        private final String DbA;
        private final long eli;

        private C0192eli(long j, String str) {
            this.eli = j;
            this.DbA = str;
        }
    }
}
