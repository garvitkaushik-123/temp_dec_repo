package com.google.android.gms.internal.play_billing;

import com.ironsource.C3040d4;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
public abstract class zzcj<V> extends zzck<V> {

    /* compiled from: com.android.billingclient:billing@@8.0.0 */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzck.zzc) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zza(false, null);
                zza = new zza(true, null);
            }
        }

        zza(boolean z, Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* compiled from: com.android.billingclient:billing@@8.0.0 */
    final class zzb<V> implements Runnable {
        final zzcj<V> zza;
        final zzcz<? extends V> zzb;

        zzb(zzcj zzcjVar, zzcz zzczVar) {
            this.zza = zzcjVar;
            this.zzb = zzczVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.zza.valueField != this) {
                return;
            }
            if (zzck.zzq(this.zza, this, zzcj.zzr(this.zzb))) {
                zzcj.zzu(this.zza, false);
            }
        }
    }

    /* compiled from: com.android.billingclient:billing@@8.0.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.play_billing.zzcj.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        static final zzc zzb = new zzc(new Throwable("Failure.exception is unexpectedly null.") { // from class: com.google.android.gms.internal.play_billing.zzcj.zzc.2
            {
                super("Failure.exception is unexpectedly null.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzc;

        zzc(Throwable th) {
            th.getClass();
            this.zzc = th;
        }
    }

    /* compiled from: com.android.billingclient:billing@@8.0.0 */
    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* compiled from: com.android.billingclient:billing@@8.0.0 */
    interface zze<V> extends zzcz<V> {
    }

    protected zzcj() {
    }

    static Object zzc(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (!(obj instanceof zzc)) {
            if (obj == zza) {
                return null;
            }
            return obj;
        }
        Throwable th2 = ((zzc) obj).zzc;
        if (th2 != null) {
            throw new ExecutionException(th2);
        }
        zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "getDoneValue", "Failure.exception is unexpectedly null.");
        throw new ExecutionException(zzc.zzb.zzc);
    }

    static boolean zzh(Object obj) {
        return !(obj instanceof zzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zzr(zzcz zzczVar) {
        Throwable zze2;
        if (zzczVar instanceof zze) {
            Object obj = ((zzcj) zzczVar).valueField;
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                if (zzaVar.zzc) {
                    Throwable th = zzaVar.zzd;
                    obj = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            return Objects.requireNonNull(obj);
        }
        if ((zzczVar instanceof zzdf) && (zze2 = ((zzdf) zzczVar).zze()) != null) {
            return new zzc(zze2);
        }
        boolean isCancelled = zzczVar.isCancelled();
        if ((!zzc) && isCancelled) {
            return Objects.requireNonNull(zza.zzb);
        }
        try {
            Object zzs = zzs(zzczVar);
            if (!isCancelled) {
                return zzs == null ? zza : zzs;
            }
            return new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(zzczVar)));
        } catch (Error | Exception e) {
            return new zzc(e);
        } catch (CancellationException e2) {
            return !isCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(zzczVar))), e2)) : new zza(false, e2);
        } catch (ExecutionException e3) {
            return isCancelled ? new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(zzczVar))), e3)) : new zzc(e3.getCause());
        }
    }

    private static Object zzs(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzt(StringBuilder sb) {
        try {
            Object zzs = zzs(this);
            sb.append("SUCCESS, result=[");
            if (zzs == null) {
                sb.append("null");
            } else if (zzs == this) {
                sb.append("this future");
            } else {
                sb.append(zzs.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzs)));
            }
            sb.append(C3040d4.i.e);
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append(C3040d4.i.e);
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzu(zzcj zzcjVar, boolean z) {
        zzd zzdVar;
        zzd zzdVar2 = null;
        while (true) {
            zzcjVar.zzo();
            zzcjVar.zzg();
            zzd zzdVar3 = zzdVar2;
            zzd zzk = zzcjVar.zzk(zzd.zza);
            zzd zzdVar4 = zzdVar3;
            while (zzk != null) {
                zzd zzdVar5 = zzk.next;
                zzk.next = zzdVar4;
                zzdVar4 = zzk;
                zzk = zzdVar5;
            }
            while (zzdVar4 != null) {
                Runnable runnable = zzdVar4.zzb;
                zzdVar = zzdVar4.next;
                Runnable runnable2 = (Runnable) Objects.requireNonNull(runnable);
                if (runnable2 instanceof zzb) {
                    zzb zzbVar = (zzb) runnable2;
                    zzcjVar = zzbVar.zza;
                    if (zzcjVar.valueField == zzbVar && zzq(zzcjVar, zzbVar, zzr(zzbVar.zzb))) {
                        break;
                    }
                } else {
                    zzv(runnable2, (Executor) Objects.requireNonNull(zzdVar4.zzc));
                }
                zzdVar4 = zzdVar;
            }
            return;
            zzdVar2 = zzdVar;
        }
    }

    private static void zzv(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            zzb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object requireNonNull;
        Object obj = this.valueField;
        if (!(obj instanceof zzb) && !(obj == null)) {
            return false;
        }
        if (zzc) {
            requireNonNull = new zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            requireNonNull = Objects.requireNonNull(z ? zza.zza : zza.zzb);
        }
        zzcj<V> zzcjVar = this;
        boolean z2 = false;
        while (true) {
            if (zzq(zzcjVar, obj, requireNonNull)) {
                zzu(zzcjVar, z);
                if (!(obj instanceof zzb)) {
                    break;
                }
                zzcz<? extends V> zzczVar = ((zzb) obj).zzb;
                if (!(zzczVar instanceof zze)) {
                    zzczVar.cancel(z);
                    break;
                }
                zzcjVar = (zzcj) zzczVar;
                obj = zzcjVar.valueField;
                if (!(obj == null) && !(obj instanceof zzb)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = zzcjVar.valueField;
                if (zzh(obj)) {
                    return z2;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        return zzl();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.valueField instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzh(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
    
        if (r3.isEmpty() != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        String concat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.valueField instanceof zza) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzt(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                zzcz<? extends V> zzczVar = ((zzb) obj).zzb;
                try {
                    if (zzczVar == this) {
                        sb.append("this future");
                    } else {
                        sb.append(zzczVar);
                    }
                } catch (Throwable th) {
                    zzda.zza(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append(C3040d4.i.e);
            } else {
                try {
                    concat = zzd();
                    if (concat != null) {
                    }
                    concat = null;
                } catch (Throwable th2) {
                    zzda.zza(th2);
                    concat = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(th2.getClass())));
                }
                if (concat != null) {
                    sb.append(", info=[");
                    sb.append(concat);
                    sb.append(C3040d4.i.e);
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                zzt(sb);
            }
        }
        sb.append(C3040d4.i.e);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzbg.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listenersField) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzp(zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listenersField;
                }
            } while (zzdVar != zzd.zza);
        }
        zzv(runnable, executor);
    }

    protected String zzd() {
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    protected final Throwable zze() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzc;
        }
        return null;
    }

    protected void zzg() {
    }

    protected final boolean zzi(Throwable th) {
        if (!zzq(this, null, new zzc(th))) {
            return false;
        }
        zzu(this, false);
        return true;
    }

    protected final boolean zzj(zzcz zzczVar) {
        zzc zzcVar;
        Object obj = this.valueField;
        if (obj == null) {
            if (zzczVar.isDone()) {
                if (!zzq(this, null, zzr(zzczVar))) {
                    return false;
                }
                zzu(this, false);
                return true;
            }
            zzb zzbVar = new zzb(this, zzczVar);
            if (zzq(this, null, zzbVar)) {
                try {
                    zzczVar.zzb(zzbVar, zzcp.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzq(this, zzbVar, zzcVar);
                }
                return true;
            }
            obj = this.valueField;
        }
        if (obj instanceof zza) {
            zzczVar.cancel(((zza) obj).zzc);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        return zzm(j, timeUnit);
    }
}
