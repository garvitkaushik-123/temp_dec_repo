package com.ironsource;

import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.unity3d.mediation.impression.LevelPlayImpressionData;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Pa implements ImpressionDataListener {

    /* renamed from: a, reason: collision with root package name */
    private final LevelPlayImpressionDataListener f2995a;

    public Pa(LevelPlayImpressionDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f2995a = listener;
    }

    public final LevelPlayImpressionDataListener a() {
        return this.f2995a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pa) {
            return Intrinsics.areEqual(this.f2995a, ((Pa) obj).f2995a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2995a.hashCode();
    }

    @Override // com.ironsource.mediationsdk.impressionData.ImpressionDataListener
    public void onImpressionSuccess(ImpressionData impressionData) {
        Intrinsics.checkNotNullParameter(impressionData, "impressionData");
        if (impressionData.getAllData() != null) {
            JSONObject allData = impressionData.getAllData();
            Intrinsics.checkNotNullExpressionValue(allData, "impressionData.allData");
            this.f2995a.onImpressionSuccess(new LevelPlayImpressionData(allData));
        }
    }
}
