package com.ironsource;

import android.content.Context;
import com.ironsource.C3040d4;
import com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class X3 implements InterfaceC3296s7 {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC3279r7 f3122a;

    protected X3(JSONObject jSONObject, Context context) {
        this.f3122a = a(jSONObject, context);
        Logger.i("X3", "created ConnectivityAdapter with strategy " + this.f3122a.getClass().getSimpleName());
    }

    public JSONObject a(Context context) {
        return this.f3122a.c(context);
    }

    @Override // com.ironsource.InterfaceC3296s7
    public void a() {
    }

    @Override // com.ironsource.InterfaceC3296s7
    public void a(String str, JSONObject jSONObject) {
    }

    public void b(Context context) {
        this.f3122a.b(context);
    }

    @Override // com.ironsource.InterfaceC3296s7
    public void b(String str, JSONObject jSONObject) {
    }

    public void c(Context context) {
        this.f3122a.a(context);
    }

    public void b() {
        this.f3122a.a();
    }

    private InterfaceC3279r7 a(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt(C3040d4.i.g0) == 1) {
            return new BroadcastReceiverStrategy(this);
        }
        if (C1.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return new Rb(this);
        }
        return new BroadcastReceiverStrategy(this);
    }
}
