package com.digitalturbine.ignite.authenticator.decorator;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;

/* loaded from: classes3.dex */
public abstract class f implements a {

    /* renamed from: a, reason: collision with root package name */
    public final a f994a;
    public AuthenticationServiceListener b;

    public f(a aVar, AuthenticationServiceListener authenticationServiceListener) {
        this.f994a = aVar;
        this.b = authenticationServiceListener;
        aVar.b(this);
        aVar.a(this);
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean a() {
        return this.f994a.a();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void b() {
        this.f994a.b();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean c() {
        return this.f994a.c();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public String d() {
        return null;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void destroy() {
        this.b = null;
        this.f994a.destroy();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final String e() {
        return this.f994a.e();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean f() {
        return this.f994a.f();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public Context g() {
        return this.f994a.g();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean h() {
        return this.f994a.h();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public String i() {
        return null;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public boolean j() {
        return false;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public IIgniteServiceAPI k() {
        return this.f994a.k();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void l() {
        this.f994a.l();
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestFailed(String str) {
        this.f994a.onCredentialsRequestFailed(str);
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestSuccess(String str, String str2) {
        this.f994a.onCredentialsRequestSuccess(str, str2);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f994a.onServiceConnected(componentName, iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f994a.onServiceDisconnected(componentName);
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void a(String str) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceAuthenticationFailed(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void b(String str) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceConnectionFailed(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void c(String str) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceAuthenticated(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public void a(ComponentName componentName, IBinder iBinder) {
        AuthenticationServiceListener authenticationServiceListener = this.b;
        if (authenticationServiceListener != null) {
            authenticationServiceListener.onIgniteServiceConnected(componentName, iBinder);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void b(a aVar) {
        this.f994a.b(aVar);
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void a(a aVar) {
        this.f994a.a(aVar);
    }
}
