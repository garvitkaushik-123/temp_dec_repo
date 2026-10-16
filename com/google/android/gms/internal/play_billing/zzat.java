package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
public abstract class zzat extends zzaq implements zzau {
    public static zzau zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
        return queryLocalInterface instanceof zzau ? (zzau) queryLocalInterface : new zzas(iBinder);
    }
}
