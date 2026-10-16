package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
public abstract class zzal extends zzaq implements zzam {
    public static zzam zzs(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        return queryLocalInterface instanceof zzam ? (zzam) queryLocalInterface : new zzak(iBinder);
    }
}
