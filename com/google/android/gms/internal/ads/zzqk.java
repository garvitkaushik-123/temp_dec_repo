package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzqk extends Exception {
    public final int zza;
    public final boolean zzb;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzqk(int i, int i2, int i3, int i4, int i5, zzz zzzVar, boolean z, Exception exc) {
        super(r0.toString(), exc);
        String valueOf = String.valueOf(zzzVar);
        StringBuilder sb = new StringBuilder("AudioTrack init failed ");
        sb.append(i);
        sb.append(" Config(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append(") ");
        sb.append(valueOf);
        sb.append(true != z ? "" : " (recoverable)");
        this.zza = i;
        this.zzb = z;
    }
}
