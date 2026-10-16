package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.ironsource.Y1;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
public class PackageSignatureVerifier {
    static volatile zzai zza;
    private static zzaj zzb;

    private static zzaj zza(Context context) {
        zzaj zzajVar;
        synchronized (PackageSignatureVerifier.class) {
            if (zzb == null) {
                zzb = new zzaj(context);
            }
            zzajVar = zzb;
        }
        return zzajVar;
    }

    public PackageVerificationResult queryPackageSignatureVerified(Context context, String str) {
        PackageVerificationResult packageVerificationResult;
        String str2;
        PackageVerificationResult packageVerificationResult2;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        if (!zzq.zze()) {
            throw new zzak();
        }
        String concat = String.valueOf(str).concat(true != honorsDebugCertificates ? "-0" : Y1.f);
        if (zza != null) {
            str2 = zza.zza;
            if (str2.equals(concat)) {
                packageVerificationResult2 = zza.zzb;
                return packageVerificationResult2;
            }
        }
        zza(context);
        zzy zzyVar = new zzy(null);
        zzyVar.zzc(str);
        zzyVar.zza(honorsDebugCertificates);
        zzyVar.zzb(false);
        zzad zzb2 = zzq.zzb(zzyVar.zzd());
        if (!zzb2.zza) {
            Preconditions.checkNotNull(zzb2.zzb);
            return PackageVerificationResult.zza(str, zzb2.zzb, zzb2.zzc);
        }
        zza = new zzai(concat, PackageVerificationResult.zzd(str, zzb2.zze));
        packageVerificationResult = zza.zzb;
        return packageVerificationResult;
    }

    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context, String str) {
        try {
            PackageVerificationResult queryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            queryPackageSignatureVerified.zzb();
            return queryPackageSignatureVerified;
        } catch (SecurityException e) {
            PackageVerificationResult queryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (queryPackageSignatureVerified2.zzc()) {
                Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e);
            }
            return queryPackageSignatureVerified2;
        }
    }
}
