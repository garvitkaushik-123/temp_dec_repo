package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface V {

    public static final class a implements V {

        /* renamed from: a, reason: collision with root package name */
        private final JSONObject f3083a;

        public a(JSONObject applicationConfig) {
            Intrinsics.checkNotNullParameter(applicationConfig, "applicationConfig");
            this.f3083a = applicationConfig;
        }

        @Override // com.ironsource.V
        public JSONObject a() {
            JSONObject optJSONObject = this.f3083a.optJSONObject("controllerConfig");
            return optJSONObject == null ? new JSONObject() : optJSONObject;
        }

        @Override // com.ironsource.V
        public int b() {
            int optInt = this.f3083a.optInt("debugMode", 0);
            if (this.f3083a.optBoolean(b.e, false)) {
                return 3;
            }
            return optInt;
        }

        @Override // com.ironsource.V
        public String c() {
            String optString = this.f3083a.optString("controllerUrl");
            return optString == null ? "" : optString;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3084a = new b();
        public static final String b = "controllerUrl";
        public static final String c = "controllerConfig";
        public static final String d = "debugMode";
        public static final String e = "adptDebugMode";

        private b() {
        }
    }

    JSONObject a();

    int b();

    String c();
}
