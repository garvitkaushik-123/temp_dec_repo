package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface T4 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<String, Object> f3056a;

        public a(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            this.f3056a = MapsKt.mutableMapOf(TuplesKt.to(IronSourceConstants.EVENTS_PROVIDER, providerName), TuplesKt.to(IronSourceConstants.EVENTS_DEMAND_ONLY, 1));
        }

        public final void a(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f3056a.put(key, value);
        }

        public final Map<String, Object> a() {
            return MapsKt.toMutableMap(this.f3056a);
        }
    }

    void a(A5 a5, EnumC3135ie enumC3135ie);

    void a(A5 a5, String str);

    public static final class b implements T4 {

        /* renamed from: a, reason: collision with root package name */
        private final B7 f3057a;
        private final a b;

        public b(B7 eventManager, a eventBaseData) {
            Intrinsics.checkNotNullParameter(eventManager, "eventManager");
            Intrinsics.checkNotNullParameter(eventBaseData, "eventBaseData");
            this.f3057a = eventManager;
            this.b = eventBaseData;
        }

        @Override // com.ironsource.T4
        public void a(A5 eventName, String instanceId) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            Map<String, Object> a2 = this.b.a();
            a2.put("spId", instanceId);
            this.f3057a.a(new C3413z5(eventName, new JSONObject(MapsKt.toMap(a2))));
        }

        @Override // com.ironsource.T4
        public void a(A5 eventName, EnumC3135ie enumC3135ie) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Map<String, Object> a2 = this.b.a();
            if (enumC3135ie != null) {
                a2.put(IronSourceConstants.EVENTS_EXT1, enumC3135ie.toString());
            }
            this.f3057a.a(new C3413z5(eventName, new JSONObject(MapsKt.toMap(a2))));
        }
    }
}
