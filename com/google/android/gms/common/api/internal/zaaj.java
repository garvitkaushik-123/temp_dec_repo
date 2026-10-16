package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaaj implements Runnable {
    final /* synthetic */ zaau zaa;

    zaaj(zaau zaauVar) {
        this.zaa = zaauVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        zaau zaauVar = this.zaa;
        googleApiAvailabilityLight = zaauVar.zad;
        context = zaauVar.zac;
        googleApiAvailabilityLight.cancelAvailabilityErrorNotifications(context);
    }
}
