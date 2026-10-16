package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface V1 {

    public static final class a implements V1 {

        /* renamed from: a, reason: collision with root package name */
        private final JSONObject f3085a;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ironsource.V1
        public com.ironsource.mediationsdk.demandOnly.p a(String instanceId) {
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            JSONObject jSONObject = this.f3085a;
            JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject(instanceId) : null;
            String optString = optJSONObject != null ? optJSONObject.optString("plumbus") : null;
            return optString != null ? new p.a(optString) : new p.b();
        }

        public a(JSONObject jSONObject) {
            this.f3085a = jSONObject;
        }

        public /* synthetic */ a(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new JSONObject() : jSONObject);
        }
    }

    com.ironsource.mediationsdk.demandOnly.p a(String str);
}
