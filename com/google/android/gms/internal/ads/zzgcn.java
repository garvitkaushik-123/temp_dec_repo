package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzgcn extends zzgcs {
    private static final zzgdw zza = new zzgdw(zzgcn.class);
    private zzfyl zzb;
    private final boolean zzc;
    private final boolean zzd;

    zzgcn(zzfyl zzfylVar, boolean z, boolean z2) {
        super(zzfylVar.size());
        zzfylVar.getClass();
        this.zzb = zzfylVar;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzD(int i, Future future) {
        try {
            zzx(i, zzgeq.zza(future));
        } catch (ExecutionException e) {
            zzF(e.getCause());
        } catch (Throwable th) {
            zzF(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzE(zzfyl zzfylVar) {
        int zzB = zzB();
        int i = 0;
        zzfvp.zzm(zzB >= 0, "Less than 0 remaining futures");
        if (zzB == 0) {
            if (zzfylVar != null) {
                zzgaw it = zzfylVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzD(i, future);
                    }
                    i++;
                }
            }
            this.seenExceptionsField = null;
            zzy();
            zzA(2);
        }
    }

    private static void zzG(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzH(int i, ListenableFuture listenableFuture) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzD(i, listenableFuture);
            }
        } finally {
            zzE(null);
        }
    }

    private static boolean zzI(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    void zzA(int i) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final String zza() {
        zzfyl zzfylVar = this.zzb;
        return zzfylVar != null ? "futures=".concat(zzfylVar.toString()) : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final void zzb() {
        zzfyl zzfylVar = this.zzb;
        zzA(1);
        if ((zzfylVar != null) && isCancelled()) {
            boolean zzo = zzo();
            zzgaw it = zzfylVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zzo);
            }
        }
    }

    abstract void zzx(int i, Object obj);

    abstract void zzy();

    final void zzz() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzy();
            return;
        }
        if (this.zzc) {
            zzgaw it = this.zzb.iterator();
            final int i = 0;
            while (it.hasNext()) {
                final ListenableFuture listenableFuture = (ListenableFuture) it.next();
                int i2 = i + 1;
                if (listenableFuture.isDone()) {
                    zzH(i, listenableFuture);
                } else {
                    listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgcl
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzgcn.this.zzH(i, listenableFuture);
                        }
                    }, zzgdb.INSTANCE);
                }
                i = i2;
            }
            return;
        }
        zzfyl zzfylVar = this.zzb;
        final zzfyl zzfylVar2 = true != this.zzd ? null : zzfylVar;
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgcm
            @Override // java.lang.Runnable
            public final void run() {
                zzgcn.this.zzE(zzfylVar2);
            }
        };
        zzgaw it2 = zzfylVar.iterator();
        while (it2.hasNext()) {
            ListenableFuture listenableFuture2 = (ListenableFuture) it2.next();
            if (listenableFuture2.isDone()) {
                zzE(zzfylVar2);
            } else {
                listenableFuture2.addListener(runnable, zzgdb.INSTANCE);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcs
    final void zzw(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        zzI(set, (Throwable) Objects.requireNonNull(zzi()));
    }

    private final void zzF(Throwable th) {
        th.getClass();
        if (this.zzc && !zzd(th) && zzI(zzC(), th)) {
            zzG(th);
        } else if (th instanceof Error) {
            zzG(th);
        }
    }
}
