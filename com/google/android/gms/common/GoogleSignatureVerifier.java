package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.internal.common.zzal;
import com.google.android.gms.internal.common.zzap;
import java.util.Arrays;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.6.0 */
/* loaded from: classes4.dex */
public class GoogleSignatureVerifier {

    @Nullable
    private static GoogleSignatureVerifier zza;

    @Nullable
    private static volatile Set zzb;

    @Nullable
    private static volatile Set zzc;
    private final Context zzd;
    private volatile String zze;

    public GoogleSignatureVerifier(Context context) {
        this.zzd = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzq.zzd(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[Catch: IllegalArgumentException -> 0x00a6, TryCatch #0 {IllegalArgumentException -> 0x00a6, blocks: (B:19:0x002c, B:20:0x0031, B:22:0x003a, B:24:0x0040, B:27:0x0047, B:29:0x0056, B:31:0x0062, B:32:0x006b, B:34:0x0071, B:36:0x007c, B:37:0x0086, B:39:0x008e, B:48:0x009e, B:49:0x00a5, B:50:0x0067, B:51:0x002f), top: B:17:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009e A[Catch: IllegalArgumentException -> 0x00a6, TryCatch #0 {IllegalArgumentException -> 0x00a6, blocks: (B:19:0x002c, B:20:0x0031, B:22:0x003a, B:24:0x0040, B:27:0x0047, B:29:0x0056, B:31:0x0062, B:32:0x006b, B:34:0x0071, B:36:0x007c, B:37:0x0086, B:39:0x008e, B:48:0x009e, B:49:0x00a5, B:50:0x0067, B:51:0x002f), top: B:17:0x002a }] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final boolean zza(PackageInfo packageInfo, boolean z) {
        zzal zzm;
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo == null) {
            return false;
        }
        try {
            zzal zzalVar = z ? zzp.zzc : zzp.zzb;
            int i = AndroidUtilsLight.zza;
            com.google.android.gms.internal.common.zzv.zzd(true);
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo != null && !signingInfo.hasMultipleSigners() && signingInfo.getSigningCertificateHistory() != null) {
                int i2 = zzal.zzd;
                com.google.android.gms.internal.common.zzah zzahVar = new com.google.android.gms.internal.common.zzah();
                for (Signature signature : signingInfo.getSigningCertificateHistory()) {
                    zzahVar.zzb(signature.toByteArray());
                }
                zzm = zzahVar.zzd();
                if (!zzm.isEmpty()) {
                    throw new IllegalArgumentException("Unable to obtain package certificate history.");
                }
                zzal zzh = zzm.zzh();
                int size = zzh.size();
                int i3 = 0;
                while (i3 < size) {
                    byte[] bArr = (byte[]) zzh.get(i3);
                    zzap listIterator = zzalVar.listIterator(0);
                    do {
                        int i4 = i3 + 1;
                        if (listIterator.hasNext()) {
                        }
                    } while (!Arrays.equals(bArr, (byte[]) listIterator.next()));
                    return true;
                }
                return false;
            }
            zzm = zzal.zzm();
            if (!zzm.isEmpty()) {
            }
        } catch (IllegalArgumentException unused) {
            Log.i("GoogleSignatureVerifier", "package info is not set correctly");
            return (z ? zzb(packageInfo, zzp.zza) : zzb(packageInfo, zzp.zza[0])) != null;
        }
    }

    @Nullable
    private static zzm zzb(PackageInfo packageInfo, zzm... zzmVarArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzn zznVar = new zzn(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzmVarArr.length; i++) {
                if (zzmVarArr[i].equals(zznVar)) {
                    return zzmVarArr[i];
                }
            }
        }
        return null;
    }

    private final zzad zzc(@Nullable String str, boolean z, boolean z2) {
        zzad zzc2;
        if (str == null) {
            return zzad.zzc("null pkg");
        }
        if (str.equals(this.zze)) {
            return zzad.zzb();
        }
        if (zzq.zzf()) {
            zzy zzyVar = new zzy(null);
            zzyVar.zzc(str);
            zzyVar.zza(GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd));
            zzyVar.zzb(true);
            zzc2 = zzq.zzb(zzyVar.zzd());
        } else {
            try {
                PackageInfo packageInfo = this.zzd.getPackageManager().getPackageInfo(str, 134217792);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd);
                if (packageInfo == null) {
                    zzc2 = zzad.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzc2 = zzad.zzc("single cert required");
                } else {
                    zzn zznVar = new zzn(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzad zza2 = zzq.zza(str2, zznVar, honorsDebugCertificates, false);
                    zzc2 = (!zza2.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzq.zza(str2, zznVar, false, true).zza) ? zza2 : zzad.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzad.zzd("no pkg ".concat(str), e);
            }
        }
        if (zzc2.zza) {
            this.zze = str;
        }
        return zzc2;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzd)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String str) {
        zzad zzc2 = zzc(str, false, false);
        zzc2.zze();
        return zzc2.zza;
    }

    public boolean isUidGoogleSigned(int i) {
        zzad zzc2;
        int length;
        String[] packagesForUid = this.zzd.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzc2 = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Preconditions.checkNotNull(zzc2);
                    break;
                }
                zzc2 = zzc(packagesForUid[i2], false, false);
                if (zzc2.zza) {
                    break;
                }
                i2++;
            }
        } else {
            zzc2 = zzad.zzc("no pkgs");
        }
        zzc2.zze();
        return zzc2.zza;
    }
}
