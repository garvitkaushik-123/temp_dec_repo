package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.common.util.concurrent.ListenableFuture;
import io.bidmachine.IABSharedPreference;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeqz implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;

    zzeqz(Context context, zzgdy zzgdyVar) {
        this.zza = context;
        this.zzb = zzgdyVar;
    }

    public static /* synthetic */ zzeqx zzc(zzeqz zzeqzVar) {
        Bundle bundle;
        com.google.android.gms.ads.internal.zzv.zzr();
        String string = !((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgo)).booleanValue() ? "" : zzeqzVar.zza.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
        String string2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgq)).booleanValue() ? zzeqzVar.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        com.google.android.gms.ads.internal.zzv.zzr();
        Context context = zzeqzVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgp)).booleanValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {IABSharedPreference.IAB_SUBJECT_TO_GDPR, IABSharedPreference.IAB_CONSENT_STRING, "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (defaultSharedPreferences.contains(str)) {
                    bundle.putString(str, defaultSharedPreferences.getString(str, null));
                }
            }
        } else {
            bundle = null;
        }
        return new zzeqx(string, string2, bundle, null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 18;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeqz.zzc(zzeqz.this);
            }
        });
    }
}
