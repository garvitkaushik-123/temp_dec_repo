package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfuq {
    private static final zzfuo zza = new zzfuo("PhoneskyVerificationUtils");

    public static boolean zza(Context context) {
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                try {
                    Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
                    if (signatureArr == null || (signatureArr.length) == 0) {
                        zza.zzd("Play Store package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (Signature signature : signatureArr) {
                            String zza2 = zzfup.zza(signature.toByteArray());
                            arrayList.add(zza2);
                            if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(zza2)) {
                                return true;
                            }
                            if ((Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(zza2)) {
                                return true;
                            }
                        }
                        zzfuo zzfuoVar = zza;
                        StringBuilder sb = new StringBuilder();
                        Iterator it = arrayList.iterator();
                        if (it.hasNext()) {
                            while (true) {
                                sb.append((CharSequence) it.next());
                                if (!it.hasNext()) {
                                    break;
                                }
                                sb.append((CharSequence) ", ");
                            }
                        }
                        zzfuoVar.zzd(String.format("Play Store package certs are not valid. Found these sha256 certs: [%s].", sb.toString()), new Object[0]);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zza.zzd("Play Store package is not found.", new Object[0]);
                }
            } else {
                zza.zzd("Play Store package is disabled.", new Object[0]);
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            zza.zzd("Play Store package is not found.", new Object[0]);
        }
        return false;
    }
}
