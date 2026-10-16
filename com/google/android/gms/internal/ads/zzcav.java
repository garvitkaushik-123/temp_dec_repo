package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzcav {
    private final WeakReference zza;

    public zzcav(View view) {
        this.zza = new WeakReference(view);
    }

    protected abstract void zza(ViewTreeObserver viewTreeObserver);

    protected abstract void zzb(ViewTreeObserver viewTreeObserver);

    protected final ViewTreeObserver zzc() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zza.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void zzd() {
        ViewTreeObserver zzc = zzc();
        if (zzc != null) {
            zza(zzc);
        }
    }

    public final void zze() {
        ViewTreeObserver zzc = zzc();
        if (zzc != null) {
            zzb(zzc);
        }
    }
}
