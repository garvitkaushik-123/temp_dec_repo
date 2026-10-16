package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzavu;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzp implements View.OnTouchListener {
    final /* synthetic */ zzu zza;

    zzp(zzu zzuVar) {
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzavu zzavuVar;
        zzavu zzavuVar2;
        zzu zzuVar = this.zza;
        zzavuVar = zzuVar.zzh;
        if (zzavuVar == null) {
            return false;
        }
        zzavuVar2 = zzuVar.zzh;
        zzavuVar2.zzd(motionEvent);
        return false;
    }
}
