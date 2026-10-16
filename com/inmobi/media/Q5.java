package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.ironsource.C3040d4;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class Q5 {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2406a = new Object();
    public static final Object b = new Object();
    public static boolean c;
    public static boolean d;
    public static JSONObject e;
    public static JSONObject f;

    public static final void a(JSONObject jSONObject) {
        synchronized (b) {
            Objects.toString(f);
            Objects.toString(jSONObject);
            f = jSONObject;
            d = true;
            Context d2 = Uc.d();
            if (d2 != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d2, "unified_id_info_store");
                JSONObject jSONObject2 = f;
                if (jSONObject2 == null) {
                    a2.a("publisher_provided_unified_id");
                } else {
                    C6.a(a2, "publisher_provided_unified_id", String.valueOf(jSONObject2), false, 4, (Object) null);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public static final JSONObject b() {
        synchronized (f2406a) {
            if (c) {
                return e;
            }
            c = true;
            Context d2 = Uc.d();
            if (d2 != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d2, "unified_id_info_store");
                Intrinsics.checkNotNullParameter("ufids", C3040d4.h.W);
                String string = a2.f2249a.getString("ufids", null);
                if (string != null) {
                    try {
                        e = new JSONObject(string);
                    } catch (JSONException unused) {
                    }
                    return e;
                }
            }
            return null;
        }
    }

    public static final JSONObject a() {
        synchronized (b) {
            if (d) {
                Objects.toString(f);
                return f;
            }
            d = true;
            Context d2 = Uc.d();
            String str = null;
            if (d2 != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d2, "unified_id_info_store");
                Intrinsics.checkNotNullParameter("publisher_provided_unified_id", C3040d4.h.W);
                str = a2.f2249a.getString("publisher_provided_unified_id", null);
            }
            try {
                f = new JSONObject(str);
            } catch (NullPointerException | JSONException unused) {
            }
            Objects.toString(f);
            return f;
        }
    }

    public static final void b(JSONObject jSONObject) {
        synchronized (f2406a) {
            e = jSONObject;
            c = true;
            Context d2 = Uc.d();
            if (d2 != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d2, "unified_id_info_store");
                JSONObject jSONObject2 = e;
                if (jSONObject2 == null) {
                    a2.a("ufids");
                } else {
                    C6.a(a2, "ufids", String.valueOf(jSONObject2), false, 4, (Object) null);
                }
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(d2).edit();
                JSONObject jSONObject3 = e;
                if (jSONObject3 == null) {
                    edit.remove("InMobi_unifiedId");
                } else {
                    edit.putString("InMobi_unifiedId", String.valueOf(jSONObject3));
                }
                edit.apply();
            }
        }
    }
}
