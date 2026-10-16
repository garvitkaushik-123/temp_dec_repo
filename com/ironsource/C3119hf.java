package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ironsource.hf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3119hf {

    /* renamed from: a, reason: collision with root package name */
    public static final C3119hf f3344a = new C3119hf();

    private C3119hf() {
    }

    public final void a(int i) {
        a(A5.TEST_SUITE_FAILED_TO_OPEN, Integer.valueOf(i), null);
    }

    public final void b() {
        a(this, A5.TEST_SUITE_LAUNCH_TS, null, null, 6, null);
    }

    public final void c() {
        a(this, A5.TEST_SUITE_OPENED_SUCCESSFULLY, null, null, 6, null);
    }

    public final void d() {
        a(this, A5.TEST_SUITE_WEB_CONTROLLER_OPEN_SUCCESSFULLY, null, null, 6, null);
    }

    public final void a(String errorReason) {
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
        a(A5.TEST_SUITE_WEB_CONTROLLER_FAILED_TO_LOAD, Integer.valueOf(IronSourceConstants.errorCode_TEST_SUITE_WEB_CONTROLLER_NOT_LOADED), errorReason);
    }

    static /* synthetic */ void a(C3119hf c3119hf, A5 a5, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        c3119hf.a(a5, num, str);
    }

    private final void a(A5 a5, Integer num, String str) {
        C3321tf c3321tf = C3321tf.f3849a;
        JSONObject a2 = c3321tf.a(false);
        if (num != null) {
            a2.put(IronSourceConstants.EVENTS_ERROR_CODE, num.intValue());
            JSONArray a3 = a();
            if (a3 != null) {
                a2.put(com.ironsource.mediationsdk.metadata.a.f, a3);
            }
        }
        if (str != null) {
            a2.put("reason", str);
        }
        c3321tf.a(a5, a2);
    }

    private final JSONArray a() {
        ConcurrentHashMap<String, List<String>> d = C3321tf.f3849a.d();
        if (d.containsKey(com.ironsource.mediationsdk.metadata.a.f)) {
            return new JSONArray((Collection) d.get(com.ironsource.mediationsdk.metadata.a.f));
        }
        return null;
    }
}
