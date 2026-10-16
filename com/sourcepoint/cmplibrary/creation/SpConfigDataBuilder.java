package com.sourcepoint.cmplibrary.creation;

import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.util.CampaignsEnv;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.model.JsonToMapExtKt;
import com.sourcepoint.cmplibrary.model.MessageLanguage;
import com.sourcepoint.cmplibrary.model.exposed.SpCampaign;
import com.sourcepoint.cmplibrary.model.exposed.SpConfig;
import com.sourcepoint.cmplibrary.model.exposed.SpConfigKt;
import com.sourcepoint.cmplibrary.model.exposed.SpGppConfig;
import com.sourcepoint.cmplibrary.model.exposed.TargetingParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* compiled from: SpConfigDataBuilder.kt */
@SpDSL
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;J\u0016\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020+J&\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\b\u0010@\u001a\u0004\u0018\u00010+J6\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\b\u0010@\u001a\u0004\u0018\u00010+2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BJ\u000e\u00109\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u000eJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010F\u001a\u00020\u00002\u0006\u00102\u001a\u000203J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+J\u0006\u0010L\u001a\u00020MJ\r\u0010N\u001a\u00020O*\u00020;H\u0086\u0002J\r\u0010N\u001a\u00020O*\u00020\u000eH\u0086\u0002J+\u0010N\u001a\u00020O* \u0012\u0004\u0012\u00020;\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0P0>0PH\u0086\u0002J\u001f\u0010N\u001a\u00020O*\u0014\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0B0QH\u0086\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R+\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR+\u0010,\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020+8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u000b\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006R"}, d2 = {"Lcom/sourcepoint/cmplibrary/creation/SpConfigDataBuilder;", "", "()V", "<set-?>", "", InMobiAdapter.ACCOUNT_ID, "getAccountId", "()I", "setAccountId", "(I)V", "accountId$delegate", "Lkotlin/properties/ReadWriteProperty;", "campaigns", "", "Lcom/sourcepoint/cmplibrary/model/exposed/SpCampaign;", "campaignsEnv", "Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "getCampaignsEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;", "setCampaignsEnv", "(Lcom/sourcepoint/cmplibrary/data/network/util/CampaignsEnv;)V", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "getLogger", "()Lcom/sourcepoint/cmplibrary/exception/Logger;", "setLogger", "(Lcom/sourcepoint/cmplibrary/exception/Logger;)V", "messLanguage", "Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "getMessLanguage", "()Lcom/sourcepoint/cmplibrary/model/MessageLanguage;", "setMessLanguage", "(Lcom/sourcepoint/cmplibrary/model/MessageLanguage;)V", "messageTimeout", "", "getMessageTimeout", "()J", "setMessageTimeout", "(J)V", "propertyId", "getPropertyId", "setPropertyId", "propertyId$delegate", "", "propertyName", "getPropertyName", "()Ljava/lang/String;", "setPropertyName", "(Ljava/lang/String;)V", "propertyName$delegate", "spGppConfig", "Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;", "getSpGppConfig", "()Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;", "setSpGppConfig", "(Lcom/sourcepoint/cmplibrary/model/exposed/SpGppConfig;)V", "addAccountId", "addCampaign", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "targetingParams", "params", "", "Lcom/sourcepoint/cmplibrary/model/exposed/TargetingParam;", "groupPmId", "configParams", "", "Lcom/sourcepoint/cmplibrary/creation/ConfigOption;", "campaign", "addCampaignsEnv", "addGppConfig", "addLogger", "addMessageLanguage", "addMessageTimeout", "addPropertyId", "addPropertyName", "build", "Lcom/sourcepoint/cmplibrary/model/exposed/SpConfig;", "unaryPlus", "", "Lkotlin/Pair;", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SpConfigDataBuilder {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SpConfigDataBuilder.class, InMobiAdapter.ACCOUNT_ID, "getAccountId()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SpConfigDataBuilder.class, "propertyId", "getPropertyId()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(SpConfigDataBuilder.class, "propertyName", "getPropertyName()Ljava/lang/String;", 0))};
    private Logger logger;
    private SpGppConfig spGppConfig;
    private final List<SpCampaign> campaigns = new ArrayList();

    /* renamed from: accountId$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty accountId = Delegates.INSTANCE.notNull();

    /* renamed from: propertyId$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty propertyId = Delegates.INSTANCE.notNull();

    /* renamed from: propertyName$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty propertyName = Delegates.INSTANCE.notNull();
    private MessageLanguage messLanguage = MessageLanguage.ENGLISH;
    private CampaignsEnv campaignsEnv = CampaignsEnv.PUBLIC;
    private long messageTimeout = 5000;

    public final int getAccountId() {
        return ((Number) this.accountId.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setAccountId(int i) {
        this.accountId.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    public final int getPropertyId() {
        return ((Number) this.propertyId.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final void setPropertyId(int i) {
        this.propertyId.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
    }

    public final String getPropertyName() {
        return (String) this.propertyName.getValue(this, $$delegatedProperties[2]);
    }

    public final void setPropertyName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.propertyName.setValue(this, $$delegatedProperties[2], str);
    }

    public final MessageLanguage getMessLanguage() {
        return this.messLanguage;
    }

    public final void setMessLanguage(MessageLanguage messageLanguage) {
        Intrinsics.checkNotNullParameter(messageLanguage, "<set-?>");
        this.messLanguage = messageLanguage;
    }

    public final CampaignsEnv getCampaignsEnv() {
        return this.campaignsEnv;
    }

    public final void setCampaignsEnv(CampaignsEnv campaignsEnv) {
        Intrinsics.checkNotNullParameter(campaignsEnv, "<set-?>");
        this.campaignsEnv = campaignsEnv;
    }

    public final long getMessageTimeout() {
        return this.messageTimeout;
    }

    public final void setMessageTimeout(long j) {
        this.messageTimeout = j;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final void setLogger(Logger logger) {
        this.logger = logger;
    }

    public final SpGppConfig getSpGppConfig() {
        return this.spGppConfig;
    }

    public final void setSpGppConfig(SpGppConfig spGppConfig) {
        this.spGppConfig = spGppConfig;
    }

    public final void unaryPlus(CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "<this>");
        this.campaigns.add(new SpCampaign(campaignType, (List<TargetingParam>) CollectionsKt.emptyList()));
    }

    public final void unaryPlus(SpCampaign spCampaign) {
        Intrinsics.checkNotNullParameter(spCampaign, "<this>");
        this.campaigns.add(spCampaign);
    }

    public final void unaryPlus(Pair<? extends CampaignType, ? extends List<Pair<String, String>>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        List<SpCampaign> list = this.campaigns;
        CampaignType first = pair.getFirst();
        List<Pair<String, String>> second = pair.getSecond();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(second, 10));
        Iterator<T> it = second.iterator();
        while (it.hasNext()) {
            arrayList.add(SpConfigKt.toTParam((Pair) it.next()));
        }
        list.add(new SpCampaign(first, arrayList));
    }

    public final void unaryPlus(Map<CampaignType, ? extends Set<? extends ConfigOption>> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map.Entry entry = (Map.Entry) CollectionsKt.firstOrNull(map.entrySet());
        if (entry != null) {
            this.campaigns.add(new SpCampaign((CampaignType) entry.getKey(), null, null, (Set) entry.getValue(), 6, null));
        }
    }

    public final SpConfigDataBuilder addAccountId(int accountId) {
        setAccountId(accountId);
        return this;
    }

    public final SpConfigDataBuilder addPropertyId(int propertyId) {
        setPropertyId(propertyId);
        return this;
    }

    public final SpConfigDataBuilder addPropertyName(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        setPropertyName(propertyName);
        return this;
    }

    public final SpConfigDataBuilder addMessageLanguage(MessageLanguage messLanguage) {
        Intrinsics.checkNotNullParameter(messLanguage, "messLanguage");
        this.messLanguage = messLanguage;
        return this;
    }

    public final SpConfigDataBuilder addCampaignsEnv(CampaignsEnv campaignsEnv) {
        Intrinsics.checkNotNullParameter(campaignsEnv, "campaignsEnv");
        this.campaignsEnv = campaignsEnv;
        return this;
    }

    public final SpConfigDataBuilder addMessageTimeout(long messageTimeout) {
        this.messageTimeout = messageTimeout;
        return this;
    }

    public final SpConfigDataBuilder addLogger(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        return this;
    }

    public final SpConfigDataBuilder addGppConfig(SpGppConfig spGppConfig) {
        Intrinsics.checkNotNullParameter(spGppConfig, "spGppConfig");
        this.spGppConfig = spGppConfig;
        return this;
    }

    public final SpConfigDataBuilder addCampaign(CampaignType campaignType, String targetingParams) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(targetingParams, "targetingParams");
        Set<Map.Entry<String, Object>> entrySet = JsonToMapExtKt.toTreeMap(new JSONObject(targetingParams)).entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            String str2 = value instanceof String ? (String) value : null;
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(new TargetingParam(str, str2));
        }
        this.campaigns.add(new SpCampaign(campaignType, arrayList));
        return this;
    }

    public final SpConfigDataBuilder addCampaign(CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        this.campaigns.add(new SpCampaign(campaignType, (List<TargetingParam>) CollectionsKt.emptyList()));
        return this;
    }

    public final SpConfigDataBuilder addCampaign(CampaignType campaignType, List<TargetingParam> params, String groupPmId) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(params, "params");
        this.campaigns.add(new SpCampaign(campaignType, params, groupPmId, null, 8, null));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpConfigDataBuilder addCampaign$default(SpConfigDataBuilder spConfigDataBuilder, CampaignType campaignType, List list, String str, Set set, int i, Object obj) {
        if ((i & 8) != 0) {
            set = SetsKt.emptySet();
        }
        return spConfigDataBuilder.addCampaign(campaignType, list, str, set);
    }

    public final SpConfigDataBuilder addCampaign(CampaignType campaignType, List<TargetingParam> params, String groupPmId, Set<? extends ConfigOption> configParams) {
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(configParams, "configParams");
        this.campaigns.add(new SpCampaign(campaignType, params, groupPmId, configParams));
        return this;
    }

    public final SpConfigDataBuilder addCampaign(SpCampaign campaign) {
        Intrinsics.checkNotNullParameter(campaign, "campaign");
        this.campaigns.add(campaign);
        return this;
    }

    public final SpConfig build() {
        return new SpConfig(getAccountId(), getPropertyName(), this.campaigns, this.messLanguage, this.messageTimeout, getPropertyId(), this.campaignsEnv, this.logger, this.spGppConfig);
    }
}
