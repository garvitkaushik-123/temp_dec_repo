package com.mbridge.msdk.tracker;

import android.util.Log;

/* compiled from: ProcessorWrapper.java */
/* loaded from: classes6.dex */
class q implements l {

    /* renamed from: a, reason: collision with root package name */
    private final g f4969a;

    public q(g gVar) {
        this.f4969a = gVar;
    }

    @Override // com.mbridge.msdk.tracker.l
    public void a(e eVar) {
        if (y.b(this.f4969a)) {
            return;
        }
        this.f4969a.a(eVar);
    }

    @Override // com.mbridge.msdk.tracker.l
    public void b(e eVar) {
        if (y.b(this.f4969a)) {
            return;
        }
        try {
            h e = eVar.e();
            if (y.a(e)) {
                eVar.a(e.a(eVar));
            }
            this.f4969a.b(eVar);
        } catch (Exception e2) {
            if (a.f4921a) {
                Log.e("TrackManager", "process event error", e2);
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.l
    public long[] a() {
        if (y.b(this.f4969a)) {
            return new long[]{0, 0};
        }
        return this.f4969a.a();
    }
}
