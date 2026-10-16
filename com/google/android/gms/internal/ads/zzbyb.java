package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.ironsource.Y1;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbyb implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private String zzd = Y1.f;
    private int zze = -1;

    zzbyb(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzgVar;
        this.zza = context;
    }

    private final void zzb() {
        this.zzc.zzD(true);
        com.google.android.gms.ads.internal.util.zzad.zzc(this.zza);
    }

    private final void zzc(String str, int i) {
        Context context;
        boolean z = false;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaN)).booleanValue() ? str.isEmpty() || str.charAt(0) != '1' : i == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals(Y1.f))) {
            z = true;
        }
        this.zzc.zzD(z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgv)).booleanValue() && z && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        boolean z;
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaP)).booleanValue()) {
                if (Objects.equals(str, "gad_has_consent_for_cookies")) {
                    int i = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
                    com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzc;
                    if (i != zzgVar.zzb()) {
                        zzb();
                    }
                    zzgVar.zzA(i);
                    return;
                }
                if (Objects.equals(str, "IABTCF_TCString")) {
                    String string = sharedPreferences.getString(str, Y1.f);
                    com.google.android.gms.ads.internal.util.zzg zzgVar2 = this.zzc;
                    if (!Objects.equals(string, zzgVar2.zzm())) {
                        zzb();
                    }
                    zzgVar2.zzJ(string);
                    return;
                }
                return;
            }
            String string2 = sharedPreferences.getString("IABTCF_PurposeConsents", Y1.f);
            int i2 = sharedPreferences.getInt("gad_has_consent_for_cookies", -1);
            String valueOf = String.valueOf(str);
            int hashCode = valueOf.hashCode();
            if (hashCode != -2004976699) {
                if (hashCode == -527267622 && valueOf.equals("gad_has_consent_for_cookies")) {
                    z = true;
                }
                z = -1;
            } else {
                if (valueOf.equals("IABTCF_PurposeConsents")) {
                    z = false;
                }
                z = -1;
            }
            if (!z) {
                if (string2.equals(Y1.f) || this.zzd.equals(string2)) {
                    return;
                }
                this.zzd = string2;
                zzc(string2, i2);
                return;
            }
            if (!z) {
                return;
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaN)).booleanValue() || i2 == -1 || this.zze == i2) {
                return;
            }
            this.zze = i2;
            zzc(string2, i2);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "AdMobPlusIdlessListener.onSharedPreferenceChanged");
            com.google.android.gms.ads.internal.util.zze.zzb("onSharedPreferenceChanged, errorMessage = ", th);
        }
    }

    final void zza() {
        SharedPreferences sharedPreferences = this.zzb;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(sharedPreferences, "gad_has_consent_for_cookies");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaP)).booleanValue()) {
            onSharedPreferenceChanged(sharedPreferences, "IABTCF_TCString");
        } else {
            onSharedPreferenceChanged(sharedPreferences, "IABTCF_PurposeConsents");
        }
    }
}
