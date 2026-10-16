package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzgcb<V> extends zzgcc<V> {

    /* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
    final class zza {
        static final zza zza;
        static final zza zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzgcc.zzg) {
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

    /* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
    final class zzb<V> implements Runnable {
        final zzgcb<V> zza;
        final ListenableFuture<? extends V> zzb;

        zzb(zzgcb zzgcbVar, ListenableFuture listenableFuture) {
            this.zza = zzgcbVar;
            this.zzb = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.zza.valueField != this) {
                return;
            }
            if (zzgcc.zzv(this.zza, this, zzgcb.zze(this.zzb))) {
                zzgcb.zzx(this.zza, false);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzgcb.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
        static final zzc zzb = new zzc(new Throwable("Failure.exception is unexpectedly null.") { // from class: com.google.android.gms.internal.ads.zzgcb.zzc.2
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

    /* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
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

    /* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
    interface zze<V> extends ListenableFuture<V> {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
    abstract class zzf<V> extends zzgcb<V> implements zze<V> {
        zzf() {
        }
    }

    protected zzgcb() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zze(ListenableFuture listenableFuture) {
        Throwable zzi;
        if (listenableFuture instanceof zze) {
            Object obj = ((zzgcb) listenableFuture).valueField;
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                if (zzaVar.zzc) {
                    Throwable th = zzaVar.zzd;
                    obj = th != null ? new zza(false, th) : zza.zzb;
                }
            }
            return Objects.requireNonNull(obj);
        }
        if ((listenableFuture instanceof zzger) && (zzi = ((zzger) listenableFuture).zzi()) != null) {
            return new zzc(zzi);
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!zzg) && isCancelled) {
            return Objects.requireNonNull(zza.zzb);
        }
        try {
            Object zzf2 = zzf(listenableFuture);
            if (!isCancelled) {
                return zzf2 == null ? zze : zzf2;
            }
            return new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(listenableFuture)));
        } catch (Error | Exception e) {
            return new zzc(e);
        } catch (CancellationException e2) {
            return !isCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(listenableFuture))), e2)) : new zza(false, e2);
        } catch (ExecutionException e3) {
            return isCancelled ? new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(listenableFuture))), e3)) : new zzc(e3.getCause());
        }
    }

    private static Object zzf(Future future) throws ExecutionException {
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

    static Object zzh(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            Throwable th = ((zza) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (!(obj instanceof zzc)) {
            if (obj == zze) {
                return null;
            }
            return obj;
        }
        Throwable th2 = ((zzc) obj).zzc;
        if (th2 != null) {
            throw new ExecutionException(th2);
        }
        zzf.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "getDoneValue", "Failure.exception is unexpectedly null.");
        throw new ExecutionException(zzc.zzb.zzc);
    }

    static boolean zzm(Object obj) {
        return !(obj instanceof zzb);
    }

    private final void zzw(StringBuilder sb) {
        try {
            Object zzf2 = zzf(this);
            sb.append("SUCCESS, result=[");
            if (zzf2 == null) {
                sb.append("null");
            } else if (zzf2 == this) {
                sb.append("this future");
            } else {
                sb.append(zzf2.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzf2)));
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
    public static void zzx(zzgcb zzgcbVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            zzgcbVar.zzt();
            if (z) {
                zzgcbVar.zzk();
            }
            zzgcbVar.zzb();
            zzd zzdVar2 = zzdVar;
            zzd zzp = zzgcbVar.zzp(zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzp != null) {
                zzd zzdVar4 = zzp.next;
                zzp.next = zzdVar3;
                zzdVar3 = zzp;
                zzp = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.zzb;
                zzdVar = zzdVar3.next;
                Runnable runnable2 = (Runnable) Objects.requireNonNull(runnable);
                if (runnable2 instanceof zzb) {
                    zzb zzbVar = (zzb) runnable2;
                    zzgcbVar = zzbVar.zza;
                    if (zzgcbVar.valueField == zzbVar && zzv(zzgcbVar, zzbVar, zze(zzbVar.zzb))) {
                        break;
                    }
                } else {
                    zzy(runnable2, (Executor) Objects.requireNonNull(zzdVar3.zzc));
                }
                zzdVar3 = zzdVar;
            }
            return;
            z = false;
        }
    }

    private static void zzy(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            zzf.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzfvp.zzc(runnable, "Runnable was null.");
        zzfvp.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listenersField) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzu(zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listenersField;
                }
            } while (zzdVar != zzd.zza);
        }
        zzy(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object requireNonNull;
        Object obj = this.valueField;
        if (!(obj instanceof zzb) && !(obj == null)) {
            return false;
        }
        if (zzg) {
            requireNonNull = new zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            requireNonNull = Objects.requireNonNull(z ? zza.zza : zza.zzb);
        }
        zzgcb<V> zzgcbVar = this;
        boolean z2 = false;
        while (true) {
            if (zzv(zzgcbVar, obj, requireNonNull)) {
                zzx(zzgcbVar, z);
                if (!(obj instanceof zzb)) {
                    break;
                }
                ListenableFuture<? extends V> listenableFuture = ((zzb) obj).zzb;
                if (!(listenableFuture instanceof zze)) {
                    listenableFuture.cancel(z);
                    break;
                }
                zzgcbVar = (zzgcb) listenableFuture;
                obj = zzgcbVar.valueField;
                if (!(obj == null) && !(obj instanceof zzb)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = zzgcbVar.valueField;
                if (zzm(obj)) {
                    return z2;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException, ExecutionException {
        return zzq();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.valueField instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.valueField;
        return (obj != null) & zzm(obj);
    }

    public String toString() {
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
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzw(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.valueField;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                ListenableFuture<? extends V> listenableFuture = ((zzb) obj).zzb;
                try {
                    if (listenableFuture == this) {
                        sb.append("this future");
                    } else {
                        sb.append(listenableFuture);
                    }
                } catch (Throwable th) {
                    zzgeg.zzb(th);
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append(C3040d4.i.e);
            } else {
                try {
                    concat = zzfwg.zza(zza());
                } catch (Throwable th2) {
                    zzgeg.zzb(th2);
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
                zzw(sb);
            }
        }
        sb.append(C3040d4.i.e);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected void zzb() {
    }

    protected boolean zzc(Object obj) {
        if (obj == null) {
            obj = zze;
        }
        if (!zzv(this, null, obj)) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    protected boolean zzd(Throwable th) {
        th.getClass();
        if (!zzv(this, null, new zzc(th))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzger
    protected final Throwable zzi() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.valueField;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzc;
        }
        return null;
    }

    protected void zzk() {
    }

    final void zzl(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzo());
        }
    }

    protected final boolean zzo() {
        Object obj = this.valueField;
        return (obj instanceof zza) && ((zza) obj).zzc;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        return zzr(j, timeUnit);
    }

    protected final boolean zzn(ListenableFuture listenableFuture) {
        zzc zzcVar;
        listenableFuture.getClass();
        Object obj = this.valueField;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!zzv(this, null, zze(listenableFuture))) {
                    return false;
                }
                zzx(this, false);
                return true;
            }
            zzb zzbVar = new zzb(this, listenableFuture);
            if (zzv(this, null, zzbVar)) {
                try {
                    listenableFuture.addListener(zzbVar, zzgdb.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzv(this, zzbVar, zzcVar);
                }
                return true;
            }
            obj = this.valueField;
        }
        if (obj instanceof zza) {
            listenableFuture.cancel(((zza) obj).zzc);
        }
        return false;
    }
}
