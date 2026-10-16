package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfdl {
    public zzfdl() {
        try {
            zzgfq.zza();
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        byte[] bArr;
        try {
            zzgfi zze = zzgfi.zze(zzgfc.zza(zzgnu.zzb().zza("AES128_GCM")));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzgew.zzb(zze, zzgev.zzb(byteArrayOutputStream));
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new GeneralSecurityException("Serialize keyset failed");
            }
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to generate key".concat(e.toString()));
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CryptoUtils.generateKey");
            bArr = new byte[0];
        }
        return Base64.encodeToString(bArr, 11);
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, @Nullable String str, zzdsd zzdsdVar) {
        zzgfi zzc;
        if (str != null && (zzc = zzc(str)) != null) {
            try {
                byte[] zza = ((zzget) zzc.zzg(zzgfy.zza(), zzget.class)).zza(bArr, bArr2);
                zzdsdVar.zzb().put("ds", "1");
                return new String(zza, "UTF-8");
            } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e) {
                com.google.android.gms.ads.internal.util.zze.zza("Failed to decrypt ".concat(e.toString()));
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CryptoUtils.decrypt");
                zzdsdVar.zzb().put("dsf", e.toString());
            }
        }
        return null;
    }

    @Nullable
    private static final zzgfi zzc(String str) {
        try {
            try {
                return zzgew.zza(zzgeu.zzb(Base64.decode(str, 11)));
            } catch (IOException unused) {
                throw new GeneralSecurityException("Parse keyset failed");
            }
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to get keysethandle".concat(e.toString()));
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
