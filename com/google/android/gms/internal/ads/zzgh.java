package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgh extends zzgc {
    private zzgo zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgh() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        String str = zzex.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, min);
        this.zzc += min;
        this.zzd -= min;
        zzg(min);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws IOException {
        zzi(zzgoVar);
        this.zza = zzgoVar;
        Uri normalizeScheme = zzgoVar.zza.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        zzdd.zze("data".equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = normalizeScheme.getSchemeSpecificPart();
        String str = zzex.zza;
        String[] split = schemeSpecificPart.split(",", -1);
        if (split.length != 2) {
            throw zzaz.zzb("Unexpected URI format: ".concat(String.valueOf(String.valueOf(normalizeScheme))), null);
        }
        String str2 = split[1];
        if (split[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str2, 0);
            } catch (IllegalArgumentException e) {
                throw zzaz.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str2)), e);
            }
        } else {
            this.zzb = URLDecoder.decode(str2, StandardCharsets.US_ASCII.name()).getBytes(StandardCharsets.UTF_8);
        }
        long j = zzgoVar.zze;
        int length = this.zzb.length;
        if (j > length) {
            this.zzb = null;
            throw new zzgk(2008);
        }
        int i = (int) j;
        this.zzc = i;
        int i2 = length - i;
        this.zzd = i2;
        long j2 = zzgoVar.zzf;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i2, j2);
        }
        zzj(zzgoVar);
        return j2 != -1 ? j2 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        zzgo zzgoVar = this.zza;
        if (zzgoVar != null) {
            return zzgoVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
