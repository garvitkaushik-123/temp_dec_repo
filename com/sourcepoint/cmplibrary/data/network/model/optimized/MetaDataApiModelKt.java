package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toMetaDataArg", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MetaDataApiModelKt {
    public static final MetaDataArg toMetaDataArg(MetaDataResp metaDataResp) {
        Intrinsics.checkNotNullParameter(metaDataResp, "<this>");
        MetaDataResp.Ccpa ccpa = metaDataResp.getCcpa();
        MetaDataArg.CcpaArg ccpaArg = new MetaDataArg.CcpaArg(ccpa != null ? ccpa.getApplies() : null, (Boolean) null, (String) null, (JsonElement) null, (String) null, 30, (DefaultConstructorMarker) null);
        MetaDataResp.Gdpr gdpr = metaDataResp.getGdpr();
        MetaDataArg.GdprArg gdprArg = new MetaDataArg.GdprArg(gdpr != null ? gdpr.getApplies() : null, (Boolean) null, (String) null, (JsonElement) null, (String) null, 30, (DefaultConstructorMarker) null);
        MetaDataResp.USNat usNat = metaDataResp.getUsNat();
        return new MetaDataArg(ccpaArg, gdprArg, new MetaDataArg.UsNatArg(usNat != null ? usNat.getApplies() : null, (Boolean) null, (String) null, (JsonElement) null, (String) null, (String) null, (Boolean) null, (Boolean) null, 254, (DefaultConstructorMarker) null));
    }
}
