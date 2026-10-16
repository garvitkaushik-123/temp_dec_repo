package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
final class zzba implements UserMessagingPlatform.OnConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener {
    private final UserMessagingPlatform.OnConsentFormLoadSuccessListener zza;
    private final UserMessagingPlatform.OnConsentFormLoadFailureListener zzb;

    /* synthetic */ zzba(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener, zzbb zzbbVar) {
        this.zza = onConsentFormLoadSuccessListener;
        this.zzb = onConsentFormLoadFailureListener;
    }

    @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
    public final void onConsentFormLoadFailure(FormError formError) {
        this.zzb.onConsentFormLoadFailure(formError);
    }

    @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.zza.onConsentFormLoadSuccess(consentForm);
    }
}
