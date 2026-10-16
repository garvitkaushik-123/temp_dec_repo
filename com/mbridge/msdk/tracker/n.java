package com.mbridge.msdk.tracker;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MemoryEventFilter.java */
/* loaded from: classes6.dex */
public class n implements f {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f4934a = new ConcurrentHashMap<>();

    /* compiled from: MemoryEventFilter.java */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f4935a;

        public a(boolean z) {
            this.f4935a = z;
        }

        public boolean a() {
            return this.f4935a;
        }
    }

    @Override // com.mbridge.msdk.tracker.f
    public boolean a(e eVar) throws Exception {
        a aVar;
        if (eVar != null && !TextUtils.isEmpty(eVar.b())) {
            try {
                String b = eVar.b();
                if (this.f4934a.containsKey(b)) {
                    aVar = this.f4934a.get(b);
                } else {
                    a aVar2 = new a(com.mbridge.msdk.foundation.same.report.c.a(b));
                    this.f4934a.put(b, aVar2);
                    aVar = aVar2;
                }
                if (aVar != null) {
                    if (aVar.a()) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("TrackManager", "apply", e);
                }
            }
        }
        return false;
    }
}
