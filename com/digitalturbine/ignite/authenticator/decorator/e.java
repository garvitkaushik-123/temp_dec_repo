package com.digitalturbine.ignite.authenticator.decorator;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.digitalturbine.ignite.authenticator.logger.ILogger;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e implements a {
    public Context e;
    public String f;
    public String g;
    public final String h;
    public com.digitalturbine.ignite.authenticator.entities.a i;
    public IIgniteServiceAPI j;
    public a n;
    public a o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f993a = false;
    public boolean b = false;
    public long c = 0;
    public boolean d = false;
    public final Bundle k = new Bundle();
    public final Object l = new Object();
    public String p = null;
    public final b q = new b(this);
    public final com.digitalturbine.ignite.authenticator.callbacks.a m = new com.digitalturbine.ignite.authenticator.callbacks.a(this);

    public e(Context context) {
        String str = null;
        this.e = context.getApplicationContext();
        Intent intent = new Intent("com.digitalturbine.ignite.cl.IgniteRemoteService");
        Context context2 = this.e;
        if (context2 != null) {
            List<ResolveInfo> queryIntentServices = context2.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices.size() > 0) {
                str = queryIntentServices.get(0).serviceInfo.packageName;
            }
        }
        this.h = str;
        this.i = new com.digitalturbine.ignite.authenticator.entities.a(false, "");
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final boolean a() {
        IIgniteServiceAPI iIgniteServiceAPI;
        return this.d && (iIgniteServiceAPI = this.j) != null && iIgniteServiceAPI.asBinder().isBinderAlive();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void b() {
        if (TextUtils.isEmpty(this.h)) {
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : unable to authenticate - there is no ignite on the device", "IgniteAuthenticationComponent");
            return;
        }
        if (!a()) {
            com.digitalturbine.ignite.authenticator.utils.concurency.c.f1001a.execute(this.q);
        } else {
            if (!this.f993a || f()) {
                m();
                return;
            }
            Object[] objArr = {"IgniteAuthenticationComponent"};
            ILogger iLogger = com.digitalturbine.ignite.authenticator.logger.a.b.f998a;
            if (iLogger != null) {
                iLogger.i("%s : already authenticated", objArr);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(String str) {
        String str2;
        a aVar;
        com.digitalturbine.ignite.authenticator.logger.a.a("%s: onAuthenticationSuccess", "IgniteAuthenticationComponent");
        this.b = false;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.p = str;
        this.k.putString("clientToken", str);
        this.f993a = true;
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = new String(Base64.decode(str.split("\\.")[1], 8), "UTF-8");
            } catch (Exception e) {
                com.digitalturbine.ignite.authenticator.logger.a.b("%s : decodeJwtBody : %s", "JwtUtil", e.toString());
            }
            if (!str2.isEmpty()) {
                try {
                    long optLong = new JSONObject(str2).optLong("exp");
                    this.c = optLong;
                    long millis = TimeUnit.SECONDS.toMillis(optLong);
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(millis);
                        str3 = simpleDateFormat.format(calendar.getTime());
                    } catch (Exception unused) {
                    }
                    com.digitalturbine.ignite.authenticator.logger.a.a("%s : Ignite session will exp in: %s", "IgniteAuthenticationComponent", str3);
                } catch (Exception e2) {
                    com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ONE_DT_GENERAL_ERROR, e2);
                    com.digitalturbine.ignite.authenticator.logger.a.b("%s: resolveSessionExpiryTime : unable resolve session expiration : %s", "IgniteAuthenticationComponent", e2.toString());
                }
            }
            aVar = this.n;
            if (aVar == null) {
                aVar.c(str);
                return;
            }
            return;
        }
        str2 = "";
        if (!str2.isEmpty()) {
        }
        aVar = this.n;
        if (aVar == null) {
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final String d() {
        return this.h;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void destroy() {
        if (this.e != null && a()) {
            this.e.unbindService(this);
            this.e = null;
        }
        this.o = null;
        this.n = null;
        this.j = null;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final String e() {
        return this.p;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final boolean f() {
        return this.c > 0 && TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) > this.c;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final Context g() {
        return this.e;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final boolean h() {
        return this.f993a;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final String i() {
        return this.i.f995a;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final boolean j() {
        return this.i.b;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final IIgniteServiceAPI k() {
        return this.j;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void l() {
        b();
    }

    public final void m() {
        if (a()) {
            String str = this.f;
            String str2 = this.g;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.b) {
                return;
            }
            if ((f() || !this.f993a) && this.j != null) {
                try {
                    this.b = true;
                    this.k.putInt("sdkFlowTypeKey", 1);
                    this.j.authenticate(this.f, this.g, this.k, this.m);
                } catch (RemoteException e) {
                    this.b = false;
                    com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ONE_DT_AUTHENTICATION_ERROR, e);
                    com.digitalturbine.ignite.authenticator.logger.a.b("%s: startAuthenticationProcess: unable to start authentication : %s", "IgniteAuthenticationComponent", e.toString());
                }
            }
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public final void onCredentialsRequestFailed(String str) {
        com.digitalturbine.ignite.authenticator.logger.a.b("%s: onCredentialsRequestFailed: %s", "IgniteAuthenticationComponent", str);
        b(str);
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public final void onCredentialsRequestSuccess(String str, String str2) {
        this.f = str;
        this.g = str2;
        m();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : onIgniteConnected", "IgniteAuthenticationComponent");
        this.j = IIgniteServiceAPI.Stub.asInterface(iBinder);
        this.d = true;
        com.digitalturbine.ignite.authenticator.utils.concurency.c.f1001a.execute(new c(this, new d(this, componentName, iBinder)));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.d = false;
        this.c = 0L;
        b("Service : " + (componentName != null ? componentName.getClassName() : "Ignite") + " disconnected");
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void a(String str) {
        com.digitalturbine.ignite.authenticator.logger.a.b("%s : onAuthenticationFailed : %s", "IgniteAuthenticationComponent", str);
        this.b = false;
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void a(ComponentName componentName, IBinder iBinder) {
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(componentName, iBinder);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void a(a aVar) {
        this.n = aVar;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void b(String str) {
        com.digitalturbine.ignite.authenticator.logger.a.b("%s : onIgniteFailedToConnect : %s", "IgniteAuthenticationComponent", str);
        a aVar = this.o;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final void b(a aVar) {
        this.o = aVar;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.a
    public final boolean c() {
        return f() || !a();
    }
}
