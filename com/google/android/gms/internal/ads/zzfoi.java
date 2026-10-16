package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfoi {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfoi(Context context, Executor executor, Task task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static zzfoi zza(final Context context, Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfog
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzfoi.zza;
                    taskCompletionSource.setResult(zzfqi.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfoh
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzfoi.zza;
                    TaskCompletionSource.this.setResult(zzfqi.zzc());
                }
            });
        }
        return new zzfoi(context, executor, taskCompletionSource.getTask(), z);
    }

    static void zzg(int i) {
        zzf = i;
    }

    private final Task zzh(final int i, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfoe
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Boolean.valueOf(task.isSuccessful());
                }
            });
        }
        Context context = this.zzb;
        final zzarz zza2 = zzasd.zza();
        zza2.zza(context.getPackageName());
        zza2.zze(j);
        zza2.zzg(zzf);
        if (exc != null) {
            int i2 = zzfwm.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zza2.zzf(stringWriter.toString());
            zza2.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zza2.zzb(str2);
        }
        if (str != null) {
            zza2.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfof
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                int i3 = zzfoi.zza;
                if (!task.isSuccessful()) {
                    return false;
                }
                int i4 = i;
                zzfqg zza3 = ((zzfqi) task.getResult()).zza(((zzasd) zzarz.this.zzbn()).zzaV());
                zza3.zza(i4);
                zza3.zzc();
                return true;
            }
        });
    }

    public final Task zzb(int i, String str) {
        return zzh(i, 0L, null, null, null, str);
    }

    public final Task zzc(int i, long j, Exception exc) {
        return zzh(i, j, exc, null, null, null);
    }

    public final Task zzd(int i, long j) {
        return zzh(i, j, null, null, null, null);
    }

    public final Task zze(int i, long j, String str) {
        return zzh(i, j, null, null, null, str);
    }

    public final Task zzf(int i, long j, String str, Map map) {
        return zzh(i, j, null, str, null, null);
    }
}
