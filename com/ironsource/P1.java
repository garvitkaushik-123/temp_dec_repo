package com.ironsource;

import android.os.Looper;
import android.util.Log;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class P1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2988a = new a(null);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a() {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                Log.e("AssertThread", "ALERT UI THREAD: " + Thread.currentThread().getStackTrace()[4].getMethodName());
            }
        }

        private a() {
        }
    }

    @JvmStatic
    public static final void a() {
        f2988a.a();
    }
}
