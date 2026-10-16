package com.google.android.ump;

import android.app.Activity;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
/* loaded from: classes5.dex */
public interface ConsentForm {

    /* compiled from: com.google.android.ump:user-messaging-platform@@3.2.0 */
    public interface OnConsentFormDismissedListener {
        void onConsentFormDismissed(FormError formError);
    }

    void show(Activity activity, OnConsentFormDismissedListener onConsentFormDismissedListener);
}
