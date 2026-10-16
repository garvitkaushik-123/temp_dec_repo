package com.bytedance.sdk.component.MGA.eli.eli.eli.eli;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.MGA.eli.wC;
import com.bytedance.sdk.component.utils.Xb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Os {
    private static int Os = 20;
    private final Context eli;
    private boolean ui;
    private boolean wC;
    protected final List<com.bytedance.sdk.component.MGA.eli.aGH.eli> DbA = new ArrayList();
    private final List<com.bytedance.sdk.component.MGA.eli.aGH.eli> aGH = new ArrayList();
    private boolean MGA = false;
    private volatile boolean kb = false;
    private final Runnable FC = new Runnable() { // from class: com.bytedance.sdk.component.MGA.eli.eli.eli.eli.Os.1
        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            synchronized (Os.this) {
                Os.this.kb = false;
                if (Os.this.DbA.isEmpty()) {
                    Os.this.MGA = false;
                    return;
                }
                if (Os.this.ui) {
                    Iterator<com.bytedance.sdk.component.MGA.eli.aGH.eli> it = Os.this.DbA.iterator();
                    while (it.hasNext()) {
                        Os.this.aGH.add(it.next());
                    }
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(Os.this.DbA);
                }
                Os.this.DbA.clear();
                Os.this.MGA = false;
                if (arrayList != null) {
                    Os.this.aGH(arrayList);
                    return;
                }
                Os os = Os.this;
                os.aGH(os.aGH);
                Os.this.aGH.clear();
            }
        }
    };

    public abstract String DbA();

    protected long MGA() {
        return 10000L;
    }

    public Os(Context context) {
        this.wC = true;
        this.eli = context;
        try {
            com.bytedance.sdk.component.MGA.eli.ui aqO = wC.kb().aqO();
            if (aqO != null) {
                this.wC = aqO.aqO();
                this.ui = aqO.dV();
                Os = aqO.nGm();
            }
            Xb.eli("DBInsertMemRepo", "enableOpt:" + this.wC + ",BATCH_SIZE:" + Os, Boolean.valueOf(this.ui));
        } catch (Throwable unused) {
        }
    }

    private void eli() {
        if (!this.MGA) {
            com.bytedance.sdk.component.MGA.eli.kb.eli.eli().postDelayed(this.FC, this.ui ? MGA() : com.bytedance.sdk.component.MGA.eli.kb.eli.DbA());
            this.MGA = true;
        }
        if (this.wC && this.DbA.size() >= Os && !this.kb) {
            com.bytedance.sdk.component.MGA.eli.kb.eli.eli().removeCallbacks(this.FC);
            com.bytedance.sdk.component.MGA.eli.kb.eli.eli().post(this.FC);
            this.MGA = true;
            this.kb = true;
        }
    }

    protected synchronized void Os(List<String> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<com.bytedance.sdk.component.MGA.eli.aGH.eli> it = this.DbA.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.MGA.eli.aGH.eli next = it.next();
                        if (next != null) {
                            String Os2 = next.Os();
                            if (!TextUtils.isEmpty(Os2) && list.contains(Os2)) {
                                it.remove();
                            }
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder().append(DbA()).append("deleteMemList: ");
                    th.getMessage();
                }
            }
        }
    }

    public synchronized void eli(com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar) {
        if (eliVar.kb() != null && !TextUtils.isEmpty(eliVar.Os())) {
            this.DbA.add(eliVar);
            eli();
        }
    }

    public Context ui() {
        return this.eli;
    }

    public void aGH(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        com.bytedance.sdk.component.MGA.eli.eli.eli.Os.eli(ui(), DbA(), list);
    }
}
