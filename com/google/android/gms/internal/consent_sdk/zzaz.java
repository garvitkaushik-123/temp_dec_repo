package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzaz implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzbc zza;
    private final Activity zzb;

    public zzaz(zzbc zzbcVar, Activity activity) {
        this.zza = zzbcVar;
        this.zzb = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb() {
        Application application;
        application = this.zza.zzb;
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Dialog dialog;
        Dialog dialog2;
        zzbx zzbxVar;
        AtomicReference atomicReference;
        Dialog dialog3;
        Dialog dialog4;
        Application application;
        AtomicReference atomicReference2;
        zzbx zzbxVar2;
        zzbc zzbcVar = this.zza;
        dialog = zzbcVar.zzg;
        if (dialog == null || !zzbcVar.zza) {
            return;
        }
        dialog2 = zzbcVar.zzg;
        dialog2.setOwnerActivity(activity);
        zzbxVar = zzbcVar.zzc;
        if (zzbxVar != null) {
            zzbxVar2 = zzbcVar.zzc;
            zzbxVar2.zza(activity);
        }
        atomicReference = zzbcVar.zzl;
        zzaz zzazVar = (zzaz) atomicReference.getAndSet(null);
        if (zzazVar != null) {
            zzazVar.zzb();
            zzaz zzazVar2 = new zzaz(zzbcVar, activity);
            application = zzbcVar.zzb;
            application.registerActivityLifecycleCallbacks(zzazVar2);
            atomicReference2 = zzbcVar.zzl;
            atomicReference2.set(zzazVar2);
        }
        dialog3 = zzbcVar.zzg;
        if (dialog3 != null) {
            dialog4 = zzbcVar.zzg;
            dialog4.show();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Dialog dialog;
        Dialog dialog2;
        if (activity != this.zzb) {
            return;
        }
        if (activity.isChangingConfigurations()) {
            zzbc zzbcVar = this.zza;
            if (zzbcVar.zza) {
                dialog = zzbcVar.zzg;
                if (dialog != null) {
                    dialog2 = zzbcVar.zzg;
                    dialog2.dismiss();
                    return;
                }
            }
        }
        this.zza.zzh(new zzg(3, "Activity is destroyed."));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
