package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzgca extends zzgdd implements Runnable {
    public static final /* synthetic */ int zzd = 0;
    ListenableFuture zza;
    Class zzb;
    Object zzc;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object obj;
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj2 = this.zzc;
        if (((obj2 == null) || ((listenableFuture == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        this.zza = null;
        try {
            th = listenableFuture instanceof zzger ? ((zzger) listenableFuture).zzi() : null;
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + String.valueOf(listenableFuture.getClass()) + " threw " + String.valueOf(e.getClass()) + " without a cause");
            }
            th = cause;
        } catch (Throwable th) {
            th = th;
        }
        if (th == null) {
            obj = zzgdn.zzp(listenableFuture);
            if (th != null) {
                zzc(obj);
                return;
            }
            if (!cls.isInstance(th)) {
                zzn(listenableFuture);
                return;
            }
            try {
                Object zze = zze(obj2, th);
                this.zzb = null;
                this.zzc = null;
                zzf(zze);
                return;
            } catch (Throwable th2) {
                try {
                    zzgeg.zza(th2);
                    zzd(th2);
                    return;
                } finally {
                    this.zzb = null;
                    this.zzc = null;
                }
            }
        }
        obj = null;
        if (th != null) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final String zza() {
        String str;
        ListenableFuture listenableFuture = this.zza;
        Class cls = this.zzb;
        Object obj = this.zzc;
        String zza = super.zza();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture.toString() + "], ";
        } else {
            str = "";
        }
        if (cls == null || obj == null) {
            if (zza != null) {
                return str.concat(zza);
            }
            return null;
        }
        return str + "exceptionType=[" + cls.toString() + "], fallback=[" + obj.toString() + C3040d4.i.e;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final void zzb() {
        zzl(this.zza);
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
    }

    abstract Object zze(Object obj, Throwable th) throws Exception;

    abstract void zzf(Object obj);

    zzgca(ListenableFuture listenableFuture, Class cls, Object obj) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
        this.zzb = cls;
        this.zzc = obj;
    }
}
