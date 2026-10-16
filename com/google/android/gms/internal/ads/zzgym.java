package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzgym extends zzgxq {
    private static final Logger zza = Logger.getLogger(zzgym.class.getName());
    private static final boolean zzb = zzhce.zzA();
    public static final /* synthetic */ int zzf = 0;
    zzgyn zze;

    private zzgym() {
        throw null;
    }

    /* synthetic */ zzgym(zzgyl zzgylVar) {
    }

    static int zzA(zzhas zzhasVar, zzhbl zzhblVar) {
        int zzaM = ((zzgxi) zzhasVar).zzaM(zzhblVar);
        return zzD(zzaM) + zzaM;
    }

    static int zzB(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int zzC(String str) {
        int length;
        try {
            length = zzhcj.zze(str);
        } catch (zzhci unused) {
            length = str.getBytes(zzgzu.zza).length;
        }
        return zzD(length) + length;
    }

    public static int zzD(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzE(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    static int zzy(int i, zzhas zzhasVar, zzhbl zzhblVar) {
        int zzD = zzD(i << 3);
        return zzD + zzD + ((zzgxi) zzhasVar).zzaM(zzhblVar);
    }

    public static int zzz(zzhas zzhasVar) {
        int zzaY = zzhasVar.zzaY();
        return zzD(zzaY) + zzaY;
    }

    public final void zzF() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzG(String str, zzhci zzhciVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhciVar);
        byte[] bytes = str.getBytes(zzgzu.zza);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgyj(e);
        }
    }

    public abstract void zzK() throws IOException;

    public abstract void zzL(byte b) throws IOException;

    public abstract void zzM(int i, boolean z) throws IOException;

    public abstract void zzN(int i, zzgxz zzgxzVar) throws IOException;

    @Override // com.google.android.gms.internal.ads.zzgxq
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    abstract void zzn(int i, zzhas zzhasVar, zzhbl zzhblVar) throws IOException;

    public abstract void zzo(int i, zzhas zzhasVar) throws IOException;

    public abstract void zzp(int i, zzgxz zzgxzVar) throws IOException;

    public abstract void zzq(int i, String str) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i, int i2) throws IOException;

    public abstract void zzu(int i) throws IOException;

    public abstract void zzv(int i, long j) throws IOException;

    public abstract void zzw(long j) throws IOException;
}
