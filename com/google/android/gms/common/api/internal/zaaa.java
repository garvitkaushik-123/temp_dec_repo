package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaaa implements PendingResult.StatusListener {
    final /* synthetic */ BasePendingResult zaa;
    final /* synthetic */ zaac zab;

    zaaa(zaac zaacVar, BasePendingResult basePendingResult) {
        this.zaa = basePendingResult;
        this.zab = zaacVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        Map map;
        map = this.zab.zaa;
        map.remove(this.zaa);
    }
}
