package com.ironsource;

import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* renamed from: com.ironsource.jd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3150jd {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, C3116hc> f3379a;

    /* renamed from: com.ironsource.jd$a */
    static final class a extends Lambda implements Function1<String, Pair<? extends String, ? extends C3116hc>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f3380a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(JSONObject jSONObject) {
            super(1);
            this.f3380a = jSONObject;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pair<String, C3116hc> invoke(String networkName) {
            Intrinsics.checkNotNullExpressionValue(networkName, "networkName");
            JSONObject jSONObject = this.f3380a.getJSONObject(networkName);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "providerSettings.getJSONObject(networkName)");
            return TuplesKt.to(networkName, new C3116hc(networkName, jSONObject));
        }
    }

    public C3150jd(JSONObject providerSettings) {
        Intrinsics.checkNotNullParameter(providerSettings, "providerSettings");
        Iterator<String> keys = providerSettings.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "providerSettings\n          .keys()");
        Map<String, C3116hc> map = MapsKt.toMap(SequencesKt.map(SequencesKt.asSequence(keys), new a(providerSettings)));
        this.f3379a = map;
        for (Map.Entry<String, C3116hc> entry : map.entrySet()) {
            entry.getKey();
            C3116hc value = entry.getValue();
            if (b(value)) {
                value.b(a(value));
            }
        }
    }

    private final boolean b(C3116hc c3116hc) {
        return c3116hc.o() && c3116hc.l().length() > 0;
    }

    public final Map<String, C3116hc> a() {
        return this.f3379a;
    }

    private final C3116hc a(C3116hc c3116hc) {
        return this.f3379a.get(c3116hc.h());
    }
}
