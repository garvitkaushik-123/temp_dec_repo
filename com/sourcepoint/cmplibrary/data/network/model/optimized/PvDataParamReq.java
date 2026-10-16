package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.ironsource.D5;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;

/* compiled from: PvDataApiModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataParamReq;", "", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "body", "Lkotlinx/serialization/json/JsonObject;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "(Lcom/sourcepoint/cmplibrary/data/network/util/Env;Lkotlinx/serialization/json/JsonObject;Lcom/sourcepoint/cmplibrary/exception/CampaignType;)V", "getBody", "()Lkotlinx/serialization/json/JsonObject;", "getCampaignType", "()Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "getEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PvDataParamReq {
    private final JsonObject body;
    private final CampaignType campaignType;
    private final Env env;

    public static /* synthetic */ PvDataParamReq copy$default(PvDataParamReq pvDataParamReq, Env env, JsonObject jsonObject, CampaignType campaignType, int i, Object obj) {
        if ((i & 1) != 0) {
            env = pvDataParamReq.env;
        }
        if ((i & 2) != 0) {
            jsonObject = pvDataParamReq.body;
        }
        if ((i & 4) != 0) {
            campaignType = pvDataParamReq.campaignType;
        }
        return pvDataParamReq.copy(env, jsonObject, campaignType);
    }

    /* renamed from: component1, reason: from getter */
    public final Env getEnv() {
        return this.env;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonObject getBody() {
        return this.body;
    }

    /* renamed from: component3, reason: from getter */
    public final CampaignType getCampaignType() {
        return this.campaignType;
    }

    public final PvDataParamReq copy(Env env, JsonObject body, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return new PvDataParamReq(env, body, campaignType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PvDataParamReq)) {
            return false;
        }
        PvDataParamReq pvDataParamReq = (PvDataParamReq) other;
        return this.env == pvDataParamReq.env && Intrinsics.areEqual(this.body, pvDataParamReq.body) && this.campaignType == pvDataParamReq.campaignType;
    }

    public int hashCode() {
        return (((this.env.hashCode() * 31) + this.body.hashCode()) * 31) + this.campaignType.hashCode();
    }

    public String toString() {
        return "PvDataParamReq(env=" + this.env + ", body=" + this.body + ", campaignType=" + this.campaignType + ")";
    }

    public PvDataParamReq(Env env, JsonObject body, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.env = env;
        this.body = body;
        this.campaignType = campaignType;
    }

    public final Env getEnv() {
        return this.env;
    }

    public final JsonObject getBody() {
        return this.body;
    }

    public final CampaignType getCampaignType() {
        return this.campaignType;
    }
}
