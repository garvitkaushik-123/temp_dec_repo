package com.digitalturbine.ignite.authenticator;

import android.content.Context;
import com.digitalturbine.ignite.authenticator.decorator.e;
import com.digitalturbine.ignite.authenticator.decorator.f;
import com.digitalturbine.ignite.authenticator.decorator.h;
import com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener;
import com.digitalturbine.ignite.authenticator.logger.ILogger;

/* loaded from: classes3.dex */
public class IgniteManager implements com.digitalturbine.ignite.authenticator.listeners.api.a {

    /* renamed from: a, reason: collision with root package name */
    public f f984a;
    public b b;

    public IgniteManager(ILogger iLogger, com.digitalturbine.ignite.authenticator.events.a aVar) {
        com.digitalturbine.ignite.authenticator.logger.a.b.f998a = iLogger;
        com.digitalturbine.ignite.authenticator.events.b.b.f996a = aVar;
    }

    public void authenticate() {
        com.digitalturbine.ignite.authenticator.utils.concurency.c.f1001a.execute(new a(this));
    }

    public void destroy() {
        this.b = null;
        this.f984a.destroy();
    }

    public String getOdt() {
        b bVar = this.b;
        return bVar != null ? bVar.f986a : "";
    }

    public boolean isAuthenticated() {
        return this.f984a.h();
    }

    public boolean isConnected() {
        return this.f984a.a();
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestFailed(String str) {
        this.f984a.onCredentialsRequestFailed(str);
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestSuccess(String str, String str2) {
        this.f984a.onCredentialsRequestSuccess(str, str2);
    }

    public IgniteManager(Context context, ILogger iLogger, boolean z, AuthenticationServiceListener authenticationServiceListener) {
        this(iLogger, null);
        this.f984a = new h(new e(context), false, z, authenticationServiceListener, this);
    }
}
