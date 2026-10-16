package com.fyber.inneractive.sdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
public final class w extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f1783a;

    public w(z zVar) {
        this.f1783a = zVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        z zVar = this.f1783a;
        zVar.getClass();
        IAlog.a("%sonReceive. action = %s", IAlog.a(zVar), intent.getAction());
        z.a(this.f1783a, context, intent);
    }
}
