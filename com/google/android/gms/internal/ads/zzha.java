package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzha extends zzgk {
    public final int zzb;

    public zzha(zzgo zzgoVar, int i, int i2) {
        super(zzb(2008, 1));
        this.zzb = 1;
    }

    public static zzha zza(IOException iOException, zzgo zzgoVar, int i) {
        String message = iOException.getMessage();
        int i2 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !zzfuv.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        return i2 == 2007 ? new zzgz(iOException, zzgoVar) : new zzha(iOException, zzgoVar, i2, i);
    }

    private static int zzb(int i, int i2) {
        return i == 2000 ? i2 != 1 ? 2000 : 2001 : i;
    }

    public zzha(IOException iOException, zzgo zzgoVar, int i, int i2) {
        super(iOException, zzb(i, i2));
        this.zzb = i2;
    }

    public zzha(String str, zzgo zzgoVar, int i, int i2) {
        super(str, zzb(i, i2));
        this.zzb = i2;
    }

    public zzha(String str, IOException iOException, zzgo zzgoVar, int i, int i2) {
        super(str, iOException, zzb(i, i2));
        this.zzb = i2;
    }
}
