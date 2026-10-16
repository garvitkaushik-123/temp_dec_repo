package com.ironsource;

import com.ironsource.sdk.controller.f;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.wb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3368wb {
    public static final a d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f3924a;
    private final String b;
    private final JSONObject c;

    /* renamed from: com.ironsource.wb$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final C3368wb a(String jsonStr) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            JSONObject jSONObject = new JSONObject(jsonStr);
            String adId = jSONObject.getString(f.b.c);
            String command = jSONObject.getString(f.b.g);
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            Intrinsics.checkNotNullExpressionValue(adId, "adId");
            Intrinsics.checkNotNullExpressionValue(command, "command");
            return new C3368wb(adId, command, optJSONObject);
        }

        private a() {
        }
    }

    public C3368wb(String adId, String command, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(command, "command");
        this.f3924a = adId;
        this.b = command;
        this.c = jSONObject;
    }

    public final String a() {
        return this.f3924a;
    }

    public final String b() {
        return this.b;
    }

    public final JSONObject c() {
        return this.c;
    }

    public final String d() {
        return this.f3924a;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3368wb)) {
            return false;
        }
        C3368wb c3368wb = (C3368wb) obj;
        return Intrinsics.areEqual(this.f3924a, c3368wb.f3924a) && Intrinsics.areEqual(this.b, c3368wb.b) && Intrinsics.areEqual(this.c, c3368wb.c);
    }

    public final JSONObject f() {
        return this.c;
    }

    public int hashCode() {
        int hashCode = ((this.f3924a.hashCode() * 31) + this.b.hashCode()) * 31;
        JSONObject jSONObject = this.c;
        return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
    }

    public String toString() {
        return "MessageToNative(adId=" + this.f3924a + ", command=" + this.b + ", params=" + this.c + ")";
    }

    public final C3368wb a(String adId, String command, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(command, "command");
        return new C3368wb(adId, command, jSONObject);
    }

    public static /* synthetic */ C3368wb a(C3368wb c3368wb, String str, String str2, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3368wb.f3924a;
        }
        if ((i & 2) != 0) {
            str2 = c3368wb.b;
        }
        if ((i & 4) != 0) {
            jSONObject = c3368wb.c;
        }
        return c3368wb.a(str, str2, jSONObject);
    }

    @JvmStatic
    public static final C3368wb a(String str) throws JSONException {
        return d.a(str);
    }
}
