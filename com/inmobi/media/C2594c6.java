package com.inmobi.media;

import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.c6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2594c6 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2611d6 f2533a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2594c6(C2611d6 c2611d6) {
        super(0);
        this.f2533a = c2611d6;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Z5 z5 = this.f2533a.f2544a;
        JSONObject jSONObject = z5.f2504a;
        JSONArray jSONArray = z5.b;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("vitals", jSONObject);
        jSONObject2.put("log", jSONArray);
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
        AbstractC2761m7.a("IncompleteLogFinalizer", jSONObject3, this.f2533a.f2544a.c.f2492a);
        String str = this.f2533a.f2544a.c.f2492a;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        Y6 y6 = this.f2533a.f2544a.c;
        Nc.d().b(new Y6(str, timeInMillis, 0, y6.d, true, y6.f));
        return Unit.INSTANCE;
    }
}
