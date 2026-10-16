package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzn {
    private final Application zza;
    private final zzaq zzb;

    zzn(Application application, zzaq zzaqVar) {
        this.zza = application;
        this.zzb = zzaqVar;
    }

    final zzcj zzc(Activity activity, ConsentRequestParameters consentRequestParameters) throws zzg {
        ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
        if (consentDebugSettings == null) {
            consentDebugSettings = new ConsentDebugSettings.Builder(this.zza).build();
        }
        return zzp.zza(new zzp(this, activity, consentDebugSettings, consentRequestParameters, null));
    }
}
