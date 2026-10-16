package com.apm.insight.k;

import com.apm.insight.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CrashUploadHandler.java */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<c> f272a = new ConcurrentLinkedQueue<>();

    static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = f272a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        new a(jSONObject, crashType);
        while (!f272a.isEmpty()) {
            f272a.poll();
        }
        f272a = null;
    }

    /* compiled from: CrashUploadHandler.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f274a;
        private JSONObject b;
        private CrashType c;

        a(JSONObject jSONObject, CrashType crashType) {
            this.c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f274a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.f274a = jSONObject;
            }
            this.b = jSONObject.optJSONObject("header");
        }

        public final String a() {
            return this.f274a.optString("crash_thread_name", null);
        }

        public final long b() {
            return this.f274a.optInt("app_start_time", -1);
        }

        public final String c() {
            int i = AnonymousClass1.f273a[this.c.ordinal()];
            if (i == 1) {
                return this.f274a.optString("data", null);
            }
            if (i == 2) {
                return this.f274a.optString("stack", null);
            }
            if (i != 3) {
                return null;
            }
            return this.f274a.optString("data", null);
        }
    }

    /* compiled from: CrashUploadHandler.java */
    /* renamed from: com.apm.insight.k.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f273a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f273a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f273a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f273a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
