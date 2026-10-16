package com.bytedance.sdk.component.MGA.eli.DbA.Os;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.MGA.eli.eli.aGH;
import com.bytedance.sdk.component.MGA.eli.ui;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os extends HandlerThread implements Handler.Callback {
    private static int QX = 200;
    private static int dV = 10;
    private final int CMM;
    private volatile boolean DbA;
    private final AtomicInteger Dfc;
    private final AtomicInteger FC;
    private volatile int MGA;
    private volatile Handler NU;
    private final Object Os;
    private final int Xb;
    private final long aAs;
    private com.bytedance.sdk.component.MGA.eli.DbA.Os aGH;
    private final AtomicInteger aqO;
    private final int bf;
    private final long du;
    protected aGH eli;
    private volatile long kb;
    private long nGm;
    private final AtomicInteger nlS;
    private final List<com.bytedance.sdk.component.MGA.eli.aGH.eli> nn;
    private final PriorityBlockingQueue<com.bytedance.sdk.component.MGA.eli.aGH.eli> ui;
    private volatile long wC;

    public static void eli(int i) {
        dV = i;
    }

    public static void DbA(int i) {
        QX = i;
    }

    public Os(PriorityBlockingQueue<com.bytedance.sdk.component.MGA.eli.aGH.eli> priorityBlockingQueue) {
        super("csj_log");
        this.DbA = true;
        this.Os = new Object();
        this.kb = 0L;
        this.wC = 0L;
        this.FC = new AtomicInteger(0);
        this.aAs = 5000L;
        this.du = 5000000000L;
        this.nlS = new AtomicInteger(0);
        this.nn = new ArrayList();
        this.Dfc = new AtomicInteger(0);
        this.aqO = new AtomicInteger(0);
        this.nGm = 60000L;
        this.Xb = 1;
        this.bf = 2;
        this.CMM = 3;
        this.ui = priorityBlockingQueue;
        this.eli = new com.bytedance.sdk.component.MGA.eli.eli.DbA();
        if (com.bytedance.sdk.component.MGA.eli.DbA.DbA()) {
            return;
        }
        long Dfc = wC.kb().aqO().Dfc();
        if (Dfc > 0) {
            this.nGm = Dfc;
        }
    }

    public void eli(boolean z) {
        this.DbA = z;
    }

    public boolean eli() {
        return this.DbA;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
        } catch (Throwable th) {
            th.getMessage();
        }
        if (i == 1) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.FC(), 1);
            DbA();
            eli(true);
            ui();
        } else {
            if (i != 2 && i != 3) {
                if (i == 11) {
                    ArrayList arrayList = new ArrayList(this.nn);
                    this.nn.clear();
                    eli((List<com.bytedance.sdk.component.MGA.eli.aGH.eli>) arrayList, false, "timeout_dispatch");
                    aAs();
                }
                return true;
            }
            Os();
        }
        return true;
    }

    private void DbA() {
        long dV2 = wC.kb().dV();
        if (dV2 <= 0) {
            return;
        }
        this.eli.eli(Integer.MAX_VALUE, dV2);
    }

    private void Os() {
        aGH();
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.cyF(), 1);
        Os(1);
    }

    private void aGH() {
        if (!isAlive()) {
            com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.aGH();
        } else {
            if (eli()) {
                return;
            }
            Os(6);
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.NU = new Handler(getLooper(), this);
        com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.eli(this.NU);
        this.NU.sendEmptyMessage(1);
    }

    public boolean eli(int i, boolean z) {
        ui aqO = wC.kb().aqO();
        if (aqO == null || !aqO.eli(wC.kb().MGA())) {
            return false;
        }
        return this.eli.eli(i, z);
    }

    public void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, boolean z) {
        if (eliVar == null) {
            return;
        }
        eliVar.aGH();
        if (z) {
            if (this.NU != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(eliVar);
                eli((List<com.bytedance.sdk.component.MGA.eli.aGH.eli>) arrayList, true, "ignore_result_dispatch");
                return;
            }
            return;
        }
        this.ui.add(eliVar);
        ui(2);
    }

    public void Os(int i) {
        try {
            boolean eli = eli(i, com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA);
            if (i != 6 && !eli) {
                return;
            }
            com.bytedance.sdk.component.MGA.eli.aGH.DbA dbA = new com.bytedance.sdk.component.MGA.eli.aGH.DbA();
            dbA.DbA(i);
            this.ui.add(dbA);
            ui(3);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar, int i) {
        this.FC.set(0);
        if (i == 0) {
            this.MGA = ((com.bytedance.sdk.component.MGA.eli.aGH.DbA) eliVar).du();
            if (this.MGA != 6) {
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.FS(), 1);
                DbA(eliVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.MGA.eli.aGH.DbA dbA = (com.bytedance.sdk.component.MGA.eli.aGH.DbA) eliVar;
        if (dbA.du() == 1) {
            this.MGA = 1;
            DbA(eliVar);
        } else if (dbA.du() == 2) {
            kb();
            this.MGA = 2;
            DbA(eliVar);
        }
    }

    private void ui() {
        while (eli()) {
            try {
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.wC(), 1);
                com.bytedance.sdk.component.MGA.eli.aGH.eli poll = this.ui.poll(this.nGm, TimeUnit.MILLISECONDS);
                int size = this.ui.size();
                if (poll instanceof com.bytedance.sdk.component.MGA.eli.aGH.DbA) {
                    eli(poll, size);
                } else if (poll == null) {
                    int incrementAndGet = this.FC.incrementAndGet();
                    com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.jh(), 1);
                    if (aGH(incrementAndGet)) {
                        MGA();
                        return;
                    } else if (incrementAndGet < 4) {
                        this.MGA = 1;
                        DbA((com.bytedance.sdk.component.MGA.eli.aGH.eli) null);
                    }
                } else {
                    eli(poll);
                    DbA(poll);
                }
            } catch (Throwable th) {
                th.getMessage();
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.dZ(), 1);
            }
        }
    }

    private boolean aGH(int i) {
        return i >= 4 && this.nlS.get() == 0 && !com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA && !com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os;
    }

    private void MGA() {
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.CMM(), 1);
        eli(false);
        com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os();
    }

    private void kb() {
        if (this.ui.size() >= 100) {
            for (int i = 0; i < 100; i++) {
                com.bytedance.sdk.component.MGA.eli.aGH.eli poll = this.ui.poll();
                if (!(poll instanceof com.bytedance.sdk.component.MGA.eli.aGH.DbA) && poll != null) {
                    eli(poll);
                }
            }
        }
    }

    private void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        this.FC.set(0);
        if (com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA) {
            this.MGA = 5;
        } else if (com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os) {
            this.MGA = 7;
        } else {
            this.MGA = 4;
        }
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.TfR(), 1);
        this.eli.eli(eliVar, this.MGA);
        com.bytedance.sdk.component.MGA.eli.Os.eli.kb(eliVar);
    }

    private boolean wC() {
        if (com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA) {
            return this.MGA == 4 || this.MGA == 7 || this.MGA == 6 || this.MGA == 5 || this.MGA == 2;
        }
        return false;
    }

    private void DbA(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        if (com.bytedance.sdk.component.MGA.eli.Os.eli.DbA() && wC.kb().eli()) {
            return;
        }
        int i = 0;
        if (wC()) {
            com.bytedance.sdk.component.MGA.eli.Os.eli.eli(this.MGA);
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.nlS(), 1);
            if (this.ui.size() != 0) {
                return;
            }
            if (!this.NU.hasMessages(2)) {
                com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA = false;
                this.wC = 0L;
                this.kb = 0L;
                this.Dfc.set(0);
                this.aqO.set(0);
            } else {
                eli(false);
                return;
            }
        }
        do {
            boolean eli = eli(this.MGA, com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA);
            com.bytedance.sdk.component.MGA.eli.Os.eli.eli(eli, this.MGA, eliVar);
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.NU(), 1);
            if (eli) {
                List<com.bytedance.sdk.component.MGA.eli.aGH.eli> eli2 = this.eli.eli(this.MGA, -1, null);
                if (eli2 != null) {
                    eli2.size();
                    eli(eli2);
                } else {
                    FC();
                }
            } else {
                FC();
            }
            i++;
            if (!eli) {
                return;
            }
        } while (i <= 6);
    }

    private void FC() {
        try {
            if (this.ui.size() == 0 && this.NU.hasMessages(11) && eli()) {
                eli(false);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void eli(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, String str) {
        eli(str);
        eli(list, false, str);
        aAs();
    }

    private void eli(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        if (list.size() != 0) {
            com.bytedance.sdk.component.MGA.eli.Os.eli.eli(list, this.ui.size());
            if (list.size() > 1 || com.bytedance.sdk.component.MGA.eli.Os.eli.Os()) {
                eli(list, "batchRead");
                return;
            }
            com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar = list.get(0);
            if (eliVar != null) {
                if (eliVar.ui() == 1) {
                    eli(list, "highPriority");
                    return;
                }
                if (eliVar.aGH() == 0 && eliVar.ui() == 2) {
                    if (eliVar.DbA() == 3) {
                        eli(list, "version_v3");
                        return;
                    } else {
                        DbA(list);
                        return;
                    }
                }
                if (eliVar.aGH() == 1) {
                    eli(list, "stats");
                    return;
                } else if (eliVar.aGH() == 3) {
                    eli(list, "adType_v3");
                    return;
                } else {
                    if (eliVar.aGH() == 2) {
                        eli(list, "other");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        FC();
    }

    private void DbA(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        this.nn.addAll(list);
        this.nn.size();
        ui aqO = wC.kb().aqO();
        if (aqO != null && aqO.nlS() != null) {
            dV = aqO.nlS().DbA();
        }
        if (this.nn.size() >= dV) {
            if (this.NU.hasMessages(11)) {
                this.NU.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.nn);
            this.nn.clear();
            eli((List<com.bytedance.sdk.component.MGA.eli.aGH.eli>) arrayList, false, "max_size_dispatch");
            aAs();
            return;
        }
        if (this.ui.size() == 0) {
            eli(false);
            if (this.NU.hasMessages(11)) {
                this.NU.removeMessages(11);
            }
            if (this.NU.hasMessages(1)) {
                this.NU.removeMessages(1);
            }
            long j = QX;
            if (aqO != null && aqO.nlS() != null) {
                j = aqO.nlS().eli();
            }
            this.NU.sendEmptyMessageDelayed(11, j);
            return;
        }
        this.nn.size();
    }

    private void eli(String str) {
        if (this.NU.hasMessages(11)) {
            this.NU.removeMessages(11);
        }
        if (this.nn.size() != 0) {
            ArrayList arrayList = new ArrayList(this.nn);
            this.nn.clear();
            eli((List<com.bytedance.sdk.component.MGA.eli.aGH.eli>) arrayList, false, "before_".concat(String.valueOf(str)));
            aAs();
            arrayList.size();
        }
    }

    private void eli(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, boolean z, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.MGA.eli.Os.eli.eli(list, this.MGA, str);
        com.bytedance.sdk.component.MGA.eli.DbA.Os wC = wC.kb().wC();
        this.aGH = wC;
        if (wC != null) {
            DbA(list, z, currentTimeMillis);
        } else {
            eli(list, z, currentTimeMillis);
        }
    }

    private void eli(final List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, final boolean z, final long j) {
        ui aqO = wC.kb().aqO();
        if (aqO != null) {
            Executor ui = aqO.ui();
            if (list.get(0).ui() == 1) {
                ui = aqO.aGH();
            }
            if (ui == null) {
                return;
            }
            this.nlS.incrementAndGet();
            ui.execute(new com.bytedance.sdk.component.MGA.eli.ui.ui("csj_log_upload") { // from class: com.bytedance.sdk.component.MGA.eli.DbA.Os.Os.1
                @Override // java.lang.Runnable
                public void run() {
                    Os os = Os.this;
                    os.eli((List<com.bytedance.sdk.component.MGA.eli.aGH.eli>) list, z, j, os.MGA);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, boolean z, long j, int i) {
        Os os;
        Throwable th;
        com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar;
        DbA eli;
        try {
            eliVar = list.get(0);
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.tLO(), 1);
        } catch (Throwable th2) {
            th = th2;
            os = this;
        }
        try {
            if (eliVar.aGH() == 0) {
                eli = wC.ui().eli(list);
                eli(eli, list);
                if (eli != null) {
                    com.bytedance.sdk.component.MGA.eli.Os.eli.eli(list, eli.aGH);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.MGA.eli.aGH.eli> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().kb());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    e.getMessage();
                }
                eli = wC.ui().eli(jSONObject);
            }
            DbA dbA = eli;
            this.nlS.decrementAndGet();
            os = this;
            try {
                os.eli(z, dbA, list, j);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                th.getMessage();
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.dZ(), 1);
                os.nlS.decrementAndGet();
            }
        } catch (Throwable th4) {
            th = th4;
            os = this;
            th.getMessage();
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.dZ(), 1);
            os.nlS.decrementAndGet();
        }
    }

    private void DbA(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, final boolean z, final long j) {
        this.nlS.incrementAndGet();
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.tLO(), 1);
        try {
            HashMap hashMap = new HashMap();
            Iterator<com.bytedance.sdk.component.MGA.eli.aGH.eli> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.MGA.eli.aGH.eli next = it.next();
                int aAs = next == null ? 0 : next.aAs();
                if (hashMap.get(Integer.valueOf(aAs)) == null) {
                    hashMap.put(Integer.valueOf(aAs), new ArrayList());
                }
                ((List) hashMap.get(Integer.valueOf(aAs))).add(next);
            }
            Iterator it2 = hashMap.keySet().iterator();
            while (it2.hasNext()) {
                int intValue = ((Integer) it2.next()).intValue();
                if (intValue != 0 && wC.kb().Os() != null && wC.kb().Os().get(Integer.valueOf(intValue)) != null) {
                    wC.kb().Os().get(Integer.valueOf(intValue)).eli(list, new com.bytedance.sdk.component.MGA.eli.DbA.DbA() { // from class: com.bytedance.sdk.component.MGA.eli.DbA.Os.Os.3
                        @Override // com.bytedance.sdk.component.MGA.eli.DbA.DbA
                        public void eli(List<eli> list2) {
                            try {
                                Os.this.nlS.decrementAndGet();
                                if (list2 == null || list2.size() == 0) {
                                    return;
                                }
                                int size = list2.size();
                                for (int i = 0; i < size; i++) {
                                    eli eliVar = list2.get(i);
                                    if (eliVar != null) {
                                        Os.this.eli(z, eliVar.eli(), eliVar.DbA(), j);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
                this.aGH.eli(list, new com.bytedance.sdk.component.MGA.eli.DbA.DbA() { // from class: com.bytedance.sdk.component.MGA.eli.DbA.Os.Os.2
                    @Override // com.bytedance.sdk.component.MGA.eli.DbA.DbA
                    public void eli(List<eli> list2) {
                        try {
                            Os.this.nlS.decrementAndGet();
                            if (list2 == null || list2.size() == 0) {
                                return;
                            }
                            int size = list2.size();
                            for (int i = 0; i < size; i++) {
                                eli eliVar = list2.get(i);
                                if (eliVar != null) {
                                    Os.this.eli(z, eliVar.eli(), eliVar.DbA(), j);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.getMessage();
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.dZ(), 1);
            this.nlS.decrementAndGet();
        }
    }

    private void ui(int i) {
        if (!eli()) {
            if (this.NU == null) {
                return;
            }
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.Os(), 1);
            if (this.NU.hasMessages(1)) {
                return;
            }
            if (i == 1) {
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.MGA(), 1);
            } else if (i == 2) {
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.aGH(), 1);
            } else if (i == 3) {
                com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.ui(), 1);
            }
            this.NU.sendEmptyMessage(1);
            return;
        }
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.eli(), 1);
    }

    private void eli(DbA dbA, List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        if (dbA == null || !dbA.eli) {
            return;
        }
        List<Object> eli = com.bytedance.sdk.component.MGA.eli.DbA.eli();
        if (list == null || eli == null || eli.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar : list) {
            if (eliVar.ui() == 1) {
                com.bytedance.sdk.component.MGA.eli.Os.eli.eli(eliVar);
                com.bytedance.sdk.component.MGA.eli.Os.eli.ui(eliVar);
                Iterator<Object> it = eli.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    private void aAs() {
        long nanoTime;
        if (this.NU.hasMessages(11)) {
            FC();
        } else {
            ui(1);
        }
        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.DbA(), 1);
        if (this.MGA == 2) {
            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.kb(), 1);
            synchronized (this.Os) {
                try {
                    try {
                        long nanoTime2 = System.nanoTime();
                        this.Os.wait(5000L);
                        nanoTime = System.nanoTime() - nanoTime2;
                        if (!com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA) {
                            boolean z = com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os;
                        }
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                    if (nanoTime < 5000000000L && 5000000000L - nanoTime >= 50000000) {
                        if (!com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA && !com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os) {
                            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.eU(), 1);
                            Os(2);
                            return;
                        }
                        com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.du(), 1);
                        return;
                    }
                    com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.aAs(), 1);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(boolean z, DbA dbA, List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, long j) {
        if (z || dbA == null) {
            return;
        }
        int i = dbA.DbA;
        int i2 = -2;
        if (dbA.ui) {
            i = -1;
        } else if (i < 0) {
            i = -2;
        }
        if (i == 510 || i == 511) {
            i = -2;
        }
        if (dbA.eli || ((i < 500 || i >= 509) && i <= 513)) {
            i2 = i;
        }
        if (list != null) {
            list.size();
            this.nlS.get();
        }
        eli(i2, list, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ef A[Catch: all -> 0x00fd, TryCatch #0 {, blocks: (B:8:0x0005, B:11:0x000b, B:21:0x00eb, B:23:0x00ef, B:24:0x00f4, B:27:0x0030, B:29:0x0040, B:31:0x0042, B:33:0x004f, B:35:0x0051, B:37:0x005f, B:38:0x0064, B:39:0x0069, B:41:0x006f, B:43:0x0075, B:45:0x0085, B:46:0x008a, B:48:0x0092, B:49:0x0097, B:50:0x00b4, B:52:0x00c4, B:54:0x00c6, B:56:0x00d3, B:58:0x00d5, B:60:0x00e3, B:61:0x00e8, B:4:0x00fb), top: B:7:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eli(int i, List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, long j) {
        synchronized (this.Os) {
            if (list != null) {
                if (this.NU != null) {
                    com.bytedance.sdk.component.MGA.eli.Os.eli.eli(i, list, j);
                    this.eli.eli(i, list);
                    wC.kb().aqO();
                    if (i != -2) {
                        if (i != -1) {
                            if (i != 0) {
                                if (i != 200) {
                                    if (i == 509) {
                                        com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA = true;
                                        com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os = false;
                                        if (this.NU.hasMessages(2)) {
                                            return;
                                        }
                                        if (System.currentTimeMillis() - this.kb < 30000) {
                                            return;
                                        }
                                        this.kb = System.currentTimeMillis();
                                        if (this.NU.hasMessages(3)) {
                                            this.NU.removeMessages(3);
                                        }
                                        eli(2, 30000L);
                                    }
                                    if (this.MGA == 2) {
                                        this.Os.notify();
                                    }
                                    this.ui.size();
                                }
                            }
                        }
                        if (com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA || com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os) {
                            com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA = false;
                            com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os = false;
                            if (this.NU.hasMessages(2)) {
                                this.NU.removeMessages(2);
                            }
                            if (this.NU.hasMessages(3)) {
                                this.NU.removeMessages(3);
                            }
                            this.wC = 0L;
                            this.kb = 0L;
                            this.Dfc.set(0);
                            this.aqO.set(0);
                            com.bytedance.sdk.component.MGA.eli.Os.DbA.eli(com.bytedance.sdk.component.MGA.eli.DbA.aGH.aGH.SSo(), 1);
                            Os(2);
                        }
                        if (this.MGA == 2) {
                        }
                        this.ui.size();
                    }
                    com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.DbA = false;
                    com.bytedance.sdk.component.MGA.eli.DbA.aGH.eli.Os = true;
                    if (this.NU.hasMessages(3)) {
                        return;
                    }
                    if (System.currentTimeMillis() - this.wC < 15000) {
                        return;
                    }
                    this.wC = System.currentTimeMillis();
                    if (this.NU.hasMessages(2)) {
                        this.NU.removeMessages(2);
                    }
                    eli(3, 15000L);
                    if (this.MGA == 2) {
                    }
                    this.ui.size();
                }
            }
        }
    }

    public void eli(int i, long j) {
        if (this.NU == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        if (i == 2) {
            this.NU.sendMessageDelayed(obtain, (((this.Dfc.incrementAndGet() - 1) % 4) + 1) * j);
        } else if (i == 3) {
            this.NU.sendMessageDelayed(obtain, (((this.aqO.incrementAndGet() - 1) % 4) + 1) * j);
        }
    }
}
