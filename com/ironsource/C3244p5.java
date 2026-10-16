package com.ironsource;

import com.ironsource.InterfaceC3415z7;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.p5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3244p5 implements InterfaceC3415z7, InterfaceC3415z7.a {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f3635a = new JSONObject();

    private final JSONObject j() {
        JSONObject optJSONObject = this.f3635a.optJSONObject(C3261q5.f3652a);
        return optJSONObject == null ? new JSONObject() : optJSONObject;
    }

    @Override // com.ironsource.InterfaceC3415z7.a
    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = this.f3635a;
        }
        this.f3635a = jSONObject;
        IronLog.INTERNAL.verbose("setEpConfig: " + jSONObject);
    }

    @Override // com.ironsource.InterfaceC3277r5
    public long b() {
        String optString = j().optString(C3294s5.c);
        Intrinsics.checkNotNullExpressionValue(optString, "traits.optString(LPM_BN_…FRESH_ANIMATION_DURATION)");
        Long longOrNull = StringsKt.toLongOrNull(optString);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    @Override // com.ironsource.InterfaceC3277r5
    public boolean c() {
        return j().optBoolean(C3294s5.h, true);
    }

    @Override // com.ironsource.InterfaceC3415z7
    public JSONObject config() {
        return this.f3635a;
    }

    @Override // com.ironsource.InterfaceC3277r5
    public boolean d() {
        return j().optBoolean(C3294s5.g, true);
    }

    @Override // com.ironsource.InterfaceC3277r5
    public long e() {
        String optString = j().optString(C3294s5.d);
        Intrinsics.checkNotNullExpressionValue(optString, "traits.optString(LPM_DEL…_TIME_AFTER_INIT_PROCESS)");
        Long longOrNull = StringsKt.toLongOrNull(optString);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 2000L;
    }

    @Override // com.ironsource.InterfaceC3277r5
    public boolean f() {
        return j().optBoolean(C3294s5.i, false);
    }

    @Override // com.ironsource.InterfaceC3277r5
    public boolean g() {
        String optString = j().optString(C3294s5.f3692a);
        Intrinsics.checkNotNullExpressionValue(optString, "traits.optString(IS_EP_CONFIG_ENABLED)");
        String lowerCase = optString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return Intrinsics.areEqual(lowerCase, "true");
    }

    @Override // com.ironsource.InterfaceC3277r5
    public int h() {
        String optString = j().optString(C3294s5.b);
        Intrinsics.checkNotNullExpressionValue(optString, "traits.optString(ISN_CTRL_INIT_DELAY)");
        Integer intOrNull = StringsKt.toIntOrNull(optString);
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        return 0;
    }

    @Override // com.ironsource.InterfaceC3277r5
    public boolean i() {
        return j().optBoolean(C3294s5.e, true);
    }

    @Override // com.ironsource.InterfaceC3277r5
    public boolean a() {
        return j().optBoolean(C3294s5.f, true);
    }
}
