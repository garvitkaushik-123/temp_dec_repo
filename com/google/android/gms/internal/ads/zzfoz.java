package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfoz {
    private final Context zza;
    private final Executor zzb;
    private final zzfoi zzc;
    private final zzfoy zzd;
    private Task zze;

    zzfoz(Context context, Executor executor, zzfoi zzfoiVar, zzfok zzfokVar, zzfox zzfoxVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfoiVar;
        this.zzd = zzfoxVar;
    }

    public static /* synthetic */ zzatq zza(zzfoz zzfozVar) {
        Context context = zzfozVar.zza;
        return zzfoq.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public static zzfoz zzc(Context context, Executor executor, zzfoi zzfoiVar, zzfok zzfokVar) {
        final zzfoz zzfozVar = new zzfoz(context, executor, zzfoiVar, zzfokVar, new zzfox());
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzfov
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzfoz.zza(zzfoz.this);
            }
        };
        Executor executor2 = zzfozVar.zzb;
        zzfozVar.zze = Tasks.call(executor2, callable).addOnFailureListener(executor2, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfow
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzfoz.zzd(zzfoz.this, exc);
            }
        });
        return zzfozVar;
    }

    public static /* synthetic */ void zzd(zzfoz zzfozVar, Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        zzfozVar.zzc.zzc(2025, -1L, exc);
    }

    public final zzatq zzb() {
        zzfoy zzfoyVar = this.zzd;
        Task task = this.zze;
        return !task.isSuccessful() ? zzfoyVar.zza() : (zzatq) task.getResult();
    }
}
