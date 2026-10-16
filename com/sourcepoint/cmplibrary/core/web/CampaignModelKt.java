package com.sourcepoint.cmplibrary.core.web;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CampaignModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toNativeMessageClient", "Lorg/json/JSONObject;", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CampaignModelKt {
    public static final JSONObject toNativeMessageClient(CampaignModel campaignModel) {
        Intrinsics.checkNotNullParameter(campaignModel, "<this>");
        return campaignModel.getMessage();
    }
}
