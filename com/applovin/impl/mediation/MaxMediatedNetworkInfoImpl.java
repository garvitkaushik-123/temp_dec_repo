package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MaxMediatedNetworkInfoImpl implements MaxMediatedNetworkInfo {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f554a;

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject) {
        this.f554a = jSONObject;
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getAdapterClassName() {
        return JsonUtils.getString(this.f554a, "class", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getAdapterVersion() {
        return JsonUtils.getString(this.f554a, "version", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public MaxMediatedNetworkInfo.InitializationStatus getInitializationStatus() {
        return MaxMediatedNetworkInfo.InitializationStatus.fromCode(JsonUtils.getInt(this.f554a, "initialization_status", MaxMediatedNetworkInfo.InitializationStatus.NOT_INITIALIZED.getCode()));
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getName() {
        return JsonUtils.getString(this.f554a, "name", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getSdkVersion() {
        return JsonUtils.getString(this.f554a, BidTokenRepositoryKt.SDK_VERSION, "");
    }

    public String toString() {
        return "MaxMediatedNetworkInfo{name=" + getName() + ", adapterClassName=" + getAdapterClassName() + ", adapterVersion=" + getAdapterVersion() + ", sdkVersion=" + getSdkVersion() + ", initializationStatus=" + getInitializationStatus() + AbstractJsonLexerKt.END_OBJ;
    }
}
