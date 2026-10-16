package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhfm extends zzgzh implements zzhat {
    private static final zzhfm zza;
    private static volatile zzhba zzb;
    private zzhfi zzC;
    private zzhdq zzE;
    private zzhdi zzG;
    private zzhej zzI;
    private int zzJ;
    private long zzM;
    private zzhfl zzN;
    private zzheo zzO;
    private zzhff zzQ;
    private int zzc;
    private int zzd;
    private int zze;
    private zzhdm zzi;
    private zzheu zzm;
    private boolean zzn;
    private boolean zzu;
    private boolean zzv;
    private zzhfb zzx;
    private boolean zzy;
    private byte zzR = 2;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private zzgzt zzj = zzbK();
    private zzgzt zzk = zzbK();
    private String zzl = "";
    private zzgzt zzo = zzgzh.zzbK();
    private String zzp = "";
    private zzgxz zzw = zzgxz.zzb;
    private String zzz = "";
    private zzgzt zzA = zzgzh.zzbK();
    private zzgzt zzB = zzgzh.zzbK();
    private zzgzt zzD = zzbK();
    private String zzF = "";
    private zzgzt zzH = zzbK();
    private zzgzt zzK = zzbK();
    private zzgzt zzL = zzbK();
    private String zzP = "";

    static {
        zzhfm zzhfmVar = new zzhfm();
        zza = zzhfmVar;
        zzgzh.zzbZ(zzhfm.class, zzhfmVar);
    }

    private zzhfm() {
    }

    public static zzhdk zzc() {
        return (zzhdk) zza.zzaZ();
    }

    static /* synthetic */ void zzi(zzhfm zzhfmVar, Iterable iterable) {
        zzgzt zzgztVar = zzhfmVar.zzA;
        if (!zzgztVar.zzc()) {
            zzhfmVar.zzA = zzgzh.zzbL(zzgztVar);
        }
        zzgxi.zzaQ(iterable, zzhfmVar.zzA);
    }

    static /* synthetic */ void zzj(zzhfm zzhfmVar, Iterable iterable) {
        zzgzt zzgztVar = zzhfmVar.zzB;
        if (!zzgztVar.zzc()) {
            zzhfmVar.zzB = zzgzh.zzbL(zzgztVar);
        }
        zzgxi.zzaQ(iterable, zzhfmVar.zzB);
    }

    static /* synthetic */ void zzk(zzhfm zzhfmVar, zzhez zzhezVar) {
        zzhezVar.getClass();
        zzgzt zzgztVar = zzhfmVar.zzj;
        if (!zzgztVar.zzc()) {
            zzhfmVar.zzj = zzgzh.zzbL(zzgztVar);
        }
        zzhfmVar.zzj.add(zzhezVar);
    }

    static /* synthetic */ void zzl(zzhfm zzhfmVar) {
        zzhfmVar.zzc &= -65;
        zzhfmVar.zzl = zza.zzl;
    }

    static /* synthetic */ void zzm(zzhfm zzhfmVar, String str) {
        zzhfmVar.zzc |= 64;
        zzhfmVar.zzl = str;
    }

    static /* synthetic */ void zzn(zzhfm zzhfmVar, zzhfb zzhfbVar) {
        zzhfbVar.getClass();
        zzhfmVar.zzx = zzhfbVar;
        zzhfmVar.zzc |= 8192;
    }

    static /* synthetic */ void zzo(zzhfm zzhfmVar, zzhdm zzhdmVar) {
        zzhdmVar.getClass();
        zzhfmVar.zzi = zzhdmVar;
        zzhfmVar.zzc |= 32;
    }

    static /* synthetic */ void zzp(zzhfm zzhfmVar, String str) {
        zzhfmVar.zzc |= 8;
        zzhfmVar.zzg = str;
    }

    static /* synthetic */ void zzq(zzhfm zzhfmVar, zzheu zzheuVar) {
        zzheuVar.getClass();
        zzhfmVar.zzm = zzheuVar;
        zzhfmVar.zzc |= 128;
    }

    static /* synthetic */ void zzr(zzhfm zzhfmVar, String str) {
        zzhfmVar.zzc |= 4;
        zzhfmVar.zzf = str;
    }

    static /* synthetic */ void zzs(zzhfm zzhfmVar, int i) {
        zzhfmVar.zzd = i - 1;
        zzhfmVar.zzc |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        zzhfx zzhfxVar = null;
        switch (zzgzgVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzR);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzR = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001$\u0000\u0001\u0001$$\u0000\t\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018#ဈ\u0019$ဉ\u001a", new Object[]{"zzc", "zzf", "zzg", "zzh", "zzj", zzhez.class, "zzn", "zzo", "zzp", "zzu", "zzv", "zzd", zzhev.zza, "zze", zzhdj.zza, "zzi", "zzl", "zzm", "zzw", "zzk", zzhfq.class, "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", zzhfw.class, "zzE", "zzF", "zzG", "zzH", zzhdu.class, "zzI", "zzJ", zzhfg.zza, "zzK", zzhem.class, "zzL", zzher.class, "zzM", "zzN", "zzO", "zzP", "zzQ"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhfm();
            case NEW_BUILDER:
                return new zzhdk(zzhfxVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzhba zzhbaVar2 = zzb;
                if (zzhbaVar2 != null) {
                    return zzhbaVar2;
                }
                synchronized (zzhfm.class) {
                    zzhbaVar = zzb;
                    if (zzhbaVar == null) {
                        zzhbaVar = new zzgzc(zza);
                        zzb = zzhbaVar;
                    }
                }
                return zzhbaVar;
            default:
                throw null;
        }
    }

    public final String zzf() {
        return this.zzl;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzj;
    }
}
