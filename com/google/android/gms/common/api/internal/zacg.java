package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
public final class zacg {
    public final RegisterListenerMethod zaa;
    public final UnregisterListenerMethod zab;
    public final Runnable zac;

    public zacg(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        this.zaa = registerListenerMethod;
        this.zab = unregisterListenerMethod;
        this.zac = runnable;
    }
}
