package com.digitalturbine.ignite.authenticator.callbacks;

import com.digitalturbine.ignite.authenticator.events.d;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a extends IIgniteServiceCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final com.digitalturbine.ignite.authenticator.decorator.a f988a;

    public a(com.digitalturbine.ignite.authenticator.decorator.a aVar) {
        this.f988a = aVar;
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onError(String str) {
        this.f988a.a(str);
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onProgress(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onScheduled(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onStart(String str) {
    }

    @Override // com.digitalturbine.ignite.cl.aidl.IIgniteServiceCallback
    public final void onSuccess(String str) {
        String str2;
        try {
            str2 = new JSONObject(str).getJSONObject("data").getString("token");
        } catch (Exception e) {
            com.digitalturbine.ignite.authenticator.events.b.a(d.ONE_DT_GENERAL_ERROR, e);
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : resolveClientToken : %s", "IgniteAuthenticationCallback", e.toString());
            str2 = null;
        }
        this.f988a.c(str2);
    }
}
