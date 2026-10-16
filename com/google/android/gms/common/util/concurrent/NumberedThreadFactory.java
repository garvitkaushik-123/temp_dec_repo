package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.C3040d4;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
public class NumberedThreadFactory implements ThreadFactory {
    private final String zza;
    private final AtomicInteger zzb = new AtomicInteger();
    private final ThreadFactory zzc = Executors.defaultThreadFactory();

    public NumberedThreadFactory(String str) {
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzc.newThread(new zza(runnable, 0));
        newThread.setName(this.zza + C3040d4.i.d + this.zzb.getAndIncrement() + C3040d4.i.e);
        return newThread;
    }
}
