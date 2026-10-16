package com.fyber.inneractive.sdk.external;

import android.content.SharedPreferences;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: classes4.dex */
public final class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f1164a;
    public final /* synthetic */ Thread.UncaughtExceptionHandler b;

    public b(SharedPreferences sharedPreferences, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1164a = sharedPreferences;
        this.b = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        SharedPreferences sharedPreferences = this.f1164a;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringBuffer = stringWriter.getBuffer().toString();
        if (stringBuffer.contains("com.fyber.inneractive")) {
            sharedPreferences.edit().putString("FyberExceptionKey", stringBuffer).putString("FyberVersionKey", InneractiveAdManager.getVersion()).putString("FyberNameKey", th.getClass().getName()).putString("FyberDescriptionKey", th.getLocalizedMessage()).commit();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
