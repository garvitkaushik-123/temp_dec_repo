package com.fyber.inneractive.sdk.click;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final q f1056a;
    public final Throwable b;
    public final String c;
    public final String d;
    public long e;
    public final ArrayList f = new ArrayList();

    public b(String str, q qVar, String str2, Exception exc) {
        this.d = str;
        this.f1056a = qVar;
        this.c = str2;
        this.b = exc;
    }

    public final String toString() {
        q qVar = this.f1056a;
        if (qVar == q.FAILED) {
            Throwable th = this.b;
            return "Open result: Failed! error: " + (th != null ? th.getMessage() : "none");
        }
        return "Open result: Success! target: " + qVar + " method: " + this.c;
    }
}
