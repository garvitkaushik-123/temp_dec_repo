package com.sourcepoint.cmplibrary.model.exposed;

import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.model.MessageLanguage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpConfig.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J\t\u0010\u0019\u001a\u00020\fHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000fHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0013HÆ\u0003Jm\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "", InMobiAdapter.ACCOUNT_ID, "", "propertyName", "", "campaigns", "", "Lcom/sourcepoint/cmplibrary/model/exposed/SpCampaign;", "messageLanguage", "Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "messageTimeout", "", "propertyId", "campaignsEnv", "Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "spGppConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;", "(ILjava/lang/String;Ljava/util/List;Lcom/sourcepoint/cmplibrary/model/MessageLanguage;JILcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;Lcom/sourcepoint/cmplibrary/exception/Logger;Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SpConfig {
    public final int accountId;
    public final List<SpCampaign> campaigns;
    public final CampaignsEnv campaignsEnv;
    public final Logger logger;
    public final MessageLanguage messageLanguage;
    public final long messageTimeout;
    public final int propertyId;
    public final String propertyName;
    public final SpGppConfig spGppConfig;

    public static /* synthetic */ SpConfig copy$default(SpConfig spConfig, int i, String str, List list, MessageLanguage messageLanguage, long j, int i2, CampaignsEnv campaignsEnv, Logger logger, SpGppConfig spGppConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = spConfig.accountId;
        }
        if ((i3 & 2) != 0) {
            str = spConfig.propertyName;
        }
        if ((i3 & 4) != 0) {
            list = spConfig.campaigns;
        }
        if ((i3 & 8) != 0) {
            messageLanguage = spConfig.messageLanguage;
        }
        if ((i3 & 16) != 0) {
            j = spConfig.messageTimeout;
        }
        if ((i3 & 32) != 0) {
            i2 = spConfig.propertyId;
        }
        if ((i3 & 64) != 0) {
            campaignsEnv = spConfig.campaignsEnv;
        }
        if ((i3 & 128) != 0) {
            logger = spConfig.logger;
        }
        if ((i3 & 256) != 0) {
            spGppConfig = spConfig.spGppConfig;
        }
        long j2 = j;
        List list2 = list;
        MessageLanguage messageLanguage2 = messageLanguage;
        return spConfig.copy(i, str, list2, messageLanguage2, j2, i2, campaignsEnv, logger, spGppConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAccountId() {
        return this.accountId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPropertyName() {
        return this.propertyName;
    }

    public final List<SpCampaign> component3() {
        return this.campaigns;
    }

    /* renamed from: component4, reason: from getter */
    public final MessageLanguage getMessageLanguage() {
        return this.messageLanguage;
    }

    /* renamed from: component5, reason: from getter */
    public final long getMessageTimeout() {
        return this.messageTimeout;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPropertyId() {
        return this.propertyId;
    }

    /* renamed from: component7, reason: from getter */
    public final CampaignsEnv getCampaignsEnv() {
        return this.campaignsEnv;
    }

    /* renamed from: component8, reason: from getter */
    public final Logger getLogger() {
        return this.logger;
    }

    /* renamed from: component9, reason: from getter */
    public final SpGppConfig getSpGppConfig() {
        return this.spGppConfig;
    }

    public final SpConfig copy(int accountId, String propertyName, List<SpCampaign> campaigns, MessageLanguage messageLanguage, long messageTimeout, int propertyId, CampaignsEnv campaignsEnv, Logger logger, SpGppConfig spGppConfig) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(campaigns, "campaigns");
        Intrinsics.checkNotNullParameter(messageLanguage, "messageLanguage");
        Intrinsics.checkNotNullParameter(campaignsEnv, "campaignsEnv");
        return new SpConfig(accountId, propertyName, campaigns, messageLanguage, messageTimeout, propertyId, campaignsEnv, logger, spGppConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpConfig)) {
            return false;
        }
        SpConfig spConfig = (SpConfig) other;
        return this.accountId == spConfig.accountId && Intrinsics.areEqual(this.propertyName, spConfig.propertyName) && Intrinsics.areEqual(this.campaigns, spConfig.campaigns) && this.messageLanguage == spConfig.messageLanguage && this.messageTimeout == spConfig.messageTimeout && this.propertyId == spConfig.propertyId && this.campaignsEnv == spConfig.campaignsEnv && Intrinsics.areEqual(this.logger, spConfig.logger) && Intrinsics.areEqual(this.spGppConfig, spConfig.spGppConfig);
    }

    public int hashCode() {
        int hashCode = ((((((((((((Integer.hashCode(this.accountId) * 31) + this.propertyName.hashCode()) * 31) + this.campaigns.hashCode()) * 31) + this.messageLanguage.hashCode()) * 31) + Long.hashCode(this.messageTimeout)) * 31) + Integer.hashCode(this.propertyId)) * 31) + this.campaignsEnv.hashCode()) * 31;
        Logger logger = this.logger;
        int hashCode2 = (hashCode + (logger == null ? 0 : logger.hashCode())) * 31;
        SpGppConfig spGppConfig = this.spGppConfig;
        return hashCode2 + (spGppConfig != null ? spGppConfig.hashCode() : 0);
    }

    public String toString() {
        return "SpConfig(accountId=" + this.accountId + ", propertyName=" + this.propertyName + ", campaigns=" + this.campaigns + ", messageLanguage=" + this.messageLanguage + ", messageTimeout=" + this.messageTimeout + ", propertyId=" + this.propertyId + ", campaignsEnv=" + this.campaignsEnv + ", logger=" + this.logger + ", spGppConfig=" + this.spGppConfig + ")";
    }

    public SpConfig(int i, String propertyName, List<SpCampaign> campaigns, MessageLanguage messageLanguage, long j, int i2, CampaignsEnv campaignsEnv, Logger logger, SpGppConfig spGppConfig) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        Intrinsics.checkNotNullParameter(campaigns, "campaigns");
        Intrinsics.checkNotNullParameter(messageLanguage, "messageLanguage");
        Intrinsics.checkNotNullParameter(campaignsEnv, "campaignsEnv");
        this.accountId = i;
        this.propertyName = propertyName;
        this.campaigns = campaigns;
        this.messageLanguage = messageLanguage;
        this.messageTimeout = j;
        this.propertyId = i2;
        this.campaignsEnv = campaignsEnv;
        this.logger = logger;
        this.spGppConfig = spGppConfig;
    }

    public /* synthetic */ SpConfig(int i, String str, List list, MessageLanguage messageLanguage, long j, int i2, CampaignsEnv campaignsEnv, Logger logger, SpGppConfig spGppConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, list, messageLanguage, (i3 & 16) != 0 ? 10000L : j, i2, (i3 & 64) != 0 ? CampaignsEnv.PUBLIC : campaignsEnv, (i3 & 128) != 0 ? null : logger, (i3 & 256) != 0 ? null : spGppConfig);
    }
}
