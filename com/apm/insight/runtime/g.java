package com.apm.insight.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.ICommonParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultCommonParams.java */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private String f329a = null;
    private int b = -1;

    public static com.apm.insight.nativecrash.b a(Context context) {
        return new com.apm.insight.nativecrash.b(context, new ICommonParams() { // from class: com.apm.insight.runtime.g.1
            @Override // com.apm.insight.ICommonParams
            public final String getDeviceId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final String getSessionId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final long getUserId() {
                return 0L;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Object> getCommonParams() {
                return new HashMap();
            }
        });
    }

    public final void a(String str) {
        this.f329a = str;
        o.a().a(str);
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.f329a) && !"0".equals(this.f329a)) {
            return this.f329a;
        }
        String d = com.apm.insight.e.a().d();
        this.f329a = d;
        if (TextUtils.isEmpty(d) || "0".equals(this.f329a)) {
            String b = o.a().b();
            this.f329a = b;
            return b;
        }
        return this.f329a;
    }

    public final boolean b() {
        return this.f329a != null;
    }
}
