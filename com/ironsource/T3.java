package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public class T3 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3055a = true;
    private IronSourceError b = null;

    public void a(IronSourceError ironSourceError) {
        this.f3055a = false;
        this.b = ironSourceError;
    }

    public boolean b() {
        return this.f3055a;
    }

    public void c() {
        this.f3055a = true;
        this.b = null;
    }

    public String toString() {
        return b() ? "valid:" + this.f3055a : "valid:" + this.f3055a + ", IronSourceError:" + this.b;
    }

    public IronSourceError a() {
        return this.b;
    }
}
