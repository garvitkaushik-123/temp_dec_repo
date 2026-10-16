package com.ironsource.sdk.controller;

import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface f {

    public static final class a {
        public static final C0301a c = new C0301a(null);

        /* renamed from: a, reason: collision with root package name */
        private final String f3738a;
        private final JSONObject b;

        /* renamed from: com.ironsource.sdk.controller.f$a$a, reason: collision with other inner class name */
        public static final class C0301a {
            public /* synthetic */ C0301a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final a a(String jsonStr) throws JSONException {
                Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
                JSONObject jSONObject = new JSONObject(jsonStr);
                String id = jSONObject.getString(b.b);
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                Intrinsics.checkNotNullExpressionValue(id, "id");
                return new a(id, optJSONObject);
            }

            private C0301a() {
            }
        }

        public a(String msgId, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
            this.f3738a = msgId;
            this.b = jSONObject;
        }

        public final String a() {
            return this.f3738a;
        }

        public final JSONObject b() {
            return this.b;
        }

        public final String c() {
            return this.f3738a;
        }

        public final JSONObject d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f3738a, aVar.f3738a) && Intrinsics.areEqual(this.b, aVar.b);
        }

        public int hashCode() {
            int hashCode = this.f3738a.hashCode() * 31;
            JSONObject jSONObject = this.b;
            return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        public String toString() {
            return "CallbackToNative(msgId=" + this.f3738a + ", params=" + this.b + ")";
        }

        public final a a(String msgId, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
            return new a(msgId, jSONObject);
        }

        public static /* synthetic */ a a(a aVar, String str, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.f3738a;
            }
            if ((i & 2) != 0) {
                jSONObject = aVar.b;
            }
            return aVar.a(str, jSONObject);
        }

        @JvmStatic
        public static final a a(String str) throws JSONException {
            return c.a(str);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3739a = new b();
        public static final String b = "msgId";
        public static final String c = "adId";
        public static final String d = "params";
        public static final String e = "success";
        public static final String f = "reason";
        public static final String g = "command";

        private b() {
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f3740a;
        private final String b;
        private final JSONObject c;
        private String d;

        public c(String adId, String command, JSONObject params) {
            Intrinsics.checkNotNullParameter(adId, "adId");
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(params, "params");
            this.f3740a = adId;
            this.b = command;
            this.c = params;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.d = uuid;
        }

        public final String a() {
            return this.f3740a;
        }

        public final String b() {
            return this.b;
        }

        public final JSONObject c() {
            return this.c;
        }

        public final String d() {
            return this.f3740a;
        }

        public final String e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar == null) {
                return false;
            }
            if (this == cVar) {
                return true;
            }
            return Intrinsics.areEqual(this.d, cVar.d) && Intrinsics.areEqual(this.f3740a, cVar.f3740a) && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c.toString(), cVar.c.toString());
        }

        public final String f() {
            return this.d;
        }

        public final JSONObject g() {
            return this.c;
        }

        public final String h() {
            String jSONObject = new JSONObject().put(b.b, this.d).put(b.c, this.f3740a).put("params", this.c).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n          .…ms)\n          .toString()");
            return jSONObject;
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            return "MessageToController(adId=" + this.f3740a + ", command=" + this.b + ", params=" + this.c + ")";
        }

        public final c a(String adId, String command, JSONObject params) {
            Intrinsics.checkNotNullParameter(adId, "adId");
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(params, "params");
            return new c(adId, command, params);
        }

        public static /* synthetic */ c a(c cVar, String str, String str2, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cVar.f3740a;
            }
            if ((i & 2) != 0) {
                str2 = cVar.b;
            }
            if ((i & 4) != 0) {
                jSONObject = cVar.c;
            }
            return cVar.a(str, str2, jSONObject);
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }
    }
}
