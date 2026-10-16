package com.mbridge.msdk.timer;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import java.util.LinkedList;
import java.util.List;

/* compiled from: LoopTimer.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f4916a;
    private boolean b;
    private LinkedList<i> c;
    private LinkedList<i> d;
    private int e;
    private int f;
    private e g;
    private com.mbridge.msdk.videocommon.setting.a h;
    private l i;
    private g j;
    private Handler k;

    /* compiled from: LoopTimer.java */
    /* renamed from: com.mbridge.msdk.timer.a$a, reason: collision with other inner class name */
    class HandlerC0401a extends Handler {
        HandlerC0401a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (a.this) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        a.this.c();
                    }
                } else {
                    if (a.this.b) {
                        return;
                    }
                    a aVar = a.this;
                    aVar.a(aVar.f4916a);
                    sendMessageDelayed(obtainMessage(1), a.this.f4916a);
                }
            }
        }
    }

    /* compiled from: LoopTimer.java */
    static class c {

        /* renamed from: a, reason: collision with root package name */
        static a f4919a = new a(null);
    }

    /* synthetic */ a(HandlerC0401a handlerC0401a) {
        this();
    }

    /* compiled from: LoopTimer.java */
    class b implements com.mbridge.msdk.reward.adapter.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f4918a;

        b(com.mbridge.msdk.reward.adapter.c cVar) {
            this.f4918a = cVar;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.k.sendMessage(a.this.k.obtainMessage(2));
            this.f4918a.a((com.mbridge.msdk.reward.adapter.a) null);
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.k.sendMessage(a.this.k.obtainMessage(2));
            this.f4918a.a((com.mbridge.msdk.reward.adapter.a) null);
        }
    }

    private a() {
        this.b = false;
        this.c = new LinkedList<>();
        this.d = new LinkedList<>();
        this.e = 0;
        this.f = 0;
        this.k = new HandlerC0401a();
    }

    private void b() {
        if (this.j == null) {
            this.j = g.a(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        if (this.i == null) {
            this.i = l.a(this.j);
        }
        List<i> a2 = this.i.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO);
        if (a2 != null) {
            this.d.addAll(a2);
            for (i iVar : a2) {
                a(iVar.a(), iVar.b());
            }
        }
        List<i> a3 = this.i.a(94);
        if (a3 != null) {
            this.c.addAll(a3);
            for (i iVar2 : a3) {
                b(iVar2.a(), iVar2.b());
            }
        }
        if (this.g == null) {
            this.g = e.a(this.j);
        }
        if (this.h == null) {
            this.h = com.mbridge.msdk.videocommon.setting.b.b().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            LinkedList<i> linkedList = this.c;
            if (linkedList != null && linkedList.size() > 0 && this.e < this.c.size()) {
                i iVar = this.c.get(this.e);
                this.e++;
                if (a(iVar)) {
                    a(iVar.a(), iVar.b(), false);
                    return;
                }
                return;
            }
            LinkedList<i> linkedList2 = this.d;
            if (linkedList2 == null || linkedList2.size() <= 0 || this.f >= this.d.size()) {
                return;
            }
            i iVar2 = this.d.get(this.f);
            this.f++;
            if (a(iVar2)) {
                c(iVar2.a(), iVar2.b());
            }
        } catch (Throwable th) {
            p0.b("LoopTimer", th.getMessage(), th);
        }
    }

    public static a a() {
        return c.f4919a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        LinkedList<i> linkedList = this.c;
        if (linkedList == null || linkedList.size() <= 0 || this.e == 0 || this.c.size() <= this.e) {
            LinkedList<i> linkedList2 = this.d;
            if (linkedList2 == null || linkedList2.size() <= 0 || this.f == 0 || this.d.size() == this.f) {
                this.f = 0;
                this.e = 0;
                Handler handler = this.k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }

    private boolean a(i iVar) {
        boolean z = false;
        if (iVar != null && !TextUtils.isEmpty(iVar.b())) {
            String b2 = iVar.b();
            try {
                if (this.g == null) {
                    return true;
                }
                com.mbridge.msdk.videocommon.setting.a aVar = this.h;
                int a2 = this.g.a(b2, aVar != null ? aVar.e() : 0L);
                if (a2 == -1) {
                    a(b2);
                } else if (a2 == 1) {
                    return true;
                }
                try {
                    Handler handler = this.k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th) {
                    th = th;
                    p0.b("LoopTimer", th.getMessage(), th);
                    return z;
                }
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
        }
        return z;
    }

    private void c(String str, String str2) {
        a(str, str2, true);
    }

    public void b(long j) {
        b();
        this.f4916a = j;
        this.b = false;
        Handler handler = this.k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f4916a);
    }

    public void b(String str, String str2) {
        if (this.c.contains(str2)) {
            return;
        }
        this.c.add(new i(str, str2, 94));
        l lVar = this.i;
        if (lVar != null) {
            lVar.a(str, str2, 94);
        }
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context d = com.mbridge.msdk.foundation.controller.c.m().d();
            if (d == null) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(d, str, str2);
            cVar.d(z);
            cVar.a(new b(cVar));
            com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar2.i(SameMD5.getMD5(u0.d()));
            cVar2.n(str2);
            if (z) {
                cVar2.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO);
            } else {
                cVar2.a(94);
            }
            cVar2.h("0");
            cVar2.f("1");
            cVar.a(1, 8000, false, cVar2);
        } catch (Exception e) {
            p0.b("LoopTimer", e.getMessage(), e);
        }
    }

    private void b(String str) {
        l lVar = this.i;
        if (lVar != null) {
            lVar.a(str);
        }
    }

    public void a(String str, String str2) {
        if (this.d.contains(str2)) {
            return;
        }
        this.d.add(new i(str, str2, MBSupportMuteAdType.INTERSTITIAL_VIDEO));
        l lVar = this.i;
        if (lVar != null) {
            lVar.a(str, str2, MBSupportMuteAdType.INTERSTITIAL_VIDEO);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedList<i> linkedList = this.c;
        if (linkedList != null && linkedList.contains(str)) {
            this.c.remove(str);
        } else {
            LinkedList<i> linkedList2 = this.d;
            if (linkedList2 != null && linkedList2.contains(str)) {
                this.d.remove(str);
            }
        }
        b(str);
    }
}
