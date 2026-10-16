package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;

/* renamed from: com.facebook.ads.redexgen.X.pz, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2470pz extends Exception implements AnonymousClass24 {
    public final int A00;
    public final long A01;
    public static final String A03 = C5C.A0h(0);
    public static final String A04 = C5C.A0h(1);
    public static final String A07 = C5C.A0h(2);
    public static final String A05 = C5C.A0h(3);
    public static final String A06 = C5C.A0h(4);
    public static final AnonymousClass23<C2470pz> A02 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.q0
        @Override // com.instagram.common.viewpoint.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return new C2470pz(bundle);
        }
    };

    public C2470pz(Bundle bundle) {
        this(bundle.getString(A07), A09(bundle), bundle.getInt(A03, 1000), bundle.getLong(A04, SystemClock.elapsedRealtime()));
    }

    public C2470pz(String str, Throwable th, int i, long j) {
        super(str, th);
        this.A00 = i;
        this.A01 = j;
    }

    public static RemoteException A08(String str) {
        return new RemoteException(str);
    }

    public static Throwable A09(Bundle bundle) {
        String string = bundle.getString(A05);
        String causeClassName = A06;
        String string2 = bundle.getString(causeClassName);
        Throwable th = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(string, true, C2470pz.class.getClassLoader());
            if (Throwable.class.isAssignableFrom(cls)) {
                th = A0A(cls, string2);
            }
        } catch (Throwable unused) {
            if (th != null) {
                return th;
            }
        }
        if (th == null) {
            return A08(string2);
        }
        return th;
    }

    public static Throwable A0A(Class<?> clazz, String str) throws Exception {
        return (Throwable) clazz.getConstructor(String.class).newInstance(str);
    }
}
