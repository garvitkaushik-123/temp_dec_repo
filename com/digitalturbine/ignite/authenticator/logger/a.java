package com.digitalturbine.ignite.authenticator.logger;

/* loaded from: classes3.dex */
public final class a {
    public static final a b = new a();

    /* renamed from: a, reason: collision with root package name */
    public ILogger f998a;

    public static void a(String str, Object... objArr) {
        ILogger iLogger = b.f998a;
        if (iLogger != null) {
            iLogger.d(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        ILogger iLogger = b.f998a;
        if (iLogger != null) {
            iLogger.w(str, objArr);
        }
    }
}
