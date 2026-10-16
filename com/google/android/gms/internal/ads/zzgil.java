package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgil extends zzgfz {
    private final zzgin zza;
    private final zzgxe zzb;

    @Nullable
    private final Integer zzc;

    private zzgil(zzgin zzginVar, zzgxe zzgxeVar, @Nullable Integer num) {
        this.zza = zzginVar;
        this.zzb = zzgxeVar;
        this.zzc = num;
    }

    public static zzgil zzc(zzgin zzginVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgxe zzb;
        if (zzginVar.zzb() == zzgim.zza) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzb = zzgxe.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzginVar.zzb() != zzgim.zzb) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(zzginVar.zzb().toString()));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzb = zzgxe.zzb(new byte[0]);
        }
        return new zzgil(zzginVar, zzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzb;
    }

    public final zzgin zzd() {
        return this.zza;
    }

    public final Integer zze() {
        return this.zzc;
    }
}
