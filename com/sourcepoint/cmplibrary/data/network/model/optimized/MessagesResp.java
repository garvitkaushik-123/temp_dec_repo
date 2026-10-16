package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289B[\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0001\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB;\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!JN\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\b\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001aR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0013R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010!¨\u0006:"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "", "seen1", "", "campaigns", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;", "localState", "Lkotlinx/serialization/json/JsonElement;", "nonKeyedLocalState", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "propertyId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/Integer;)V", "campaignList", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CampaignMessage;", "getCampaignList", "()Ljava/util/List;", "getCampaigns$annotations", "()V", "getCampaigns", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;", "getLocalState$annotations", "getLocalState", "()Lkotlinx/serialization/json/JsonElement;", "getNonKeyedLocalState$annotations", "getNonKeyedLocalState", "getPriority$annotations", "getPriority", "getPropertyId$annotations", "getPropertyId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonElement;Ljava/util/List;Ljava/lang/Integer;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class MessagesResp {
    private final Campaigns campaigns;
    private final JsonElement localState;
    private final JsonElement nonKeyedLocalState;
    private final List<Integer> priority;
    private final Integer propertyId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(IntSerializer.INSTANCE), null};

    public static /* synthetic */ MessagesResp copy$default(MessagesResp messagesResp, Campaigns campaigns, JsonElement jsonElement, JsonElement jsonElement2, List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            campaigns = messagesResp.campaigns;
        }
        if ((i & 2) != 0) {
            jsonElement = messagesResp.localState;
        }
        if ((i & 4) != 0) {
            jsonElement2 = messagesResp.nonKeyedLocalState;
        }
        if ((i & 8) != 0) {
            list = messagesResp.priority;
        }
        if ((i & 16) != 0) {
            num = messagesResp.propertyId;
        }
        Integer num2 = num;
        JsonElement jsonElement3 = jsonElement2;
        return messagesResp.copy(campaigns, jsonElement, jsonElement3, list, num2);
    }

    @SerialName("campaigns")
    public static /* synthetic */ void getCampaigns$annotations() {
    }

    @SerialName("localState")
    public static /* synthetic */ void getLocalState$annotations() {
    }

    @SerialName("nonKeyedLocalState")
    public static /* synthetic */ void getNonKeyedLocalState$annotations() {
    }

    @SerialName(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY)
    public static /* synthetic */ void getPriority$annotations() {
    }

    @SerialName("propertyId")
    public static /* synthetic */ void getPropertyId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Campaigns getCampaigns() {
        return this.campaigns;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonElement getLocalState() {
        return this.localState;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonElement getNonKeyedLocalState() {
        return this.nonKeyedLocalState;
    }

    public final List<Integer> component4() {
        return this.priority;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getPropertyId() {
        return this.propertyId;
    }

    public final MessagesResp copy(Campaigns campaigns, JsonElement localState, JsonElement nonKeyedLocalState, List<Integer> priority, Integer propertyId) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        return new MessagesResp(campaigns, localState, nonKeyedLocalState, priority, propertyId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessagesResp)) {
            return false;
        }
        MessagesResp messagesResp = (MessagesResp) other;
        return Intrinsics.areEqual(this.campaigns, messagesResp.campaigns) && Intrinsics.areEqual(this.localState, messagesResp.localState) && Intrinsics.areEqual(this.nonKeyedLocalState, messagesResp.nonKeyedLocalState) && Intrinsics.areEqual(this.priority, messagesResp.priority) && Intrinsics.areEqual(this.propertyId, messagesResp.propertyId);
    }

    public int hashCode() {
        Campaigns campaigns = this.campaigns;
        int hashCode = (campaigns == null ? 0 : campaigns.hashCode()) * 31;
        JsonElement jsonElement = this.localState;
        int hashCode2 = (hashCode + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        JsonElement jsonElement2 = this.nonKeyedLocalState;
        int hashCode3 = (((hashCode2 + (jsonElement2 == null ? 0 : jsonElement2.hashCode())) * 31) + this.priority.hashCode()) * 31;
        Integer num = this.propertyId;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MessagesResp> serializer() {
            return MessagesResp$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MessagesResp(int i, @SerialName("campaigns") Campaigns campaigns, @SerialName("localState") JsonElement jsonElement, @SerialName("nonKeyedLocalState") JsonElement jsonElement2, @SerialName("priority") List list, @SerialName("propertyId") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, MessagesResp$$serializer.INSTANCE.getDescriptor());
        }
        this.campaigns = campaigns;
        this.localState = jsonElement;
        this.nonKeyedLocalState = jsonElement2;
        this.priority = list;
        this.propertyId = num;
    }

    public MessagesResp(Campaigns campaigns, JsonElement jsonElement, JsonElement jsonElement2, List<Integer> priority, Integer num) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.campaigns = campaigns;
        this.localState = jsonElement;
        this.nonKeyedLocalState = jsonElement2;
        this.priority = priority;
        this.propertyId = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(MessagesResp self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, Campaigns$$serializer.INSTANCE, self.campaigns);
        output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.localState);
        output.encodeNullableSerializableElement(serialDesc, 2, JsonElementSerializer.INSTANCE, self.nonKeyedLocalState);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.priority);
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.propertyId);
    }

    public final Campaigns getCampaigns() {
        return this.campaigns;
    }

    public final JsonElement getLocalState() {
        return this.localState;
    }

    public final JsonElement getNonKeyedLocalState() {
        return this.nonKeyedLocalState;
    }

    public final List<Integer> getPriority() {
        return this.priority;
    }

    public final Integer getPropertyId() {
        return this.propertyId;
    }

    public final List<CampaignMessage> getCampaignList() {
        USNatConsentData usNat;
        CCPA ccpa;
        GDPR gdpr;
        ArrayList arrayList = new ArrayList();
        Campaigns campaigns = this.campaigns;
        if (campaigns != null && (gdpr = campaigns.getGdpr()) != null) {
            arrayList.add(gdpr);
        }
        Campaigns campaigns2 = this.campaigns;
        if (campaigns2 != null && (ccpa = campaigns2.getCcpa()) != null) {
            arrayList.add(ccpa);
        }
        Campaigns campaigns3 = this.campaigns;
        if (campaigns3 != null && (usNat = campaigns3.getUsNat()) != null) {
            arrayList.add(usNat);
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj : arrayList2) {
            linkedHashMap.put(Integer.valueOf(MessagesApiModelKt.toCategoryId(((CampaignMessage) obj).getType())), obj);
        }
        List<Integer> list = this.priority;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CampaignMessage campaignMessage = (CampaignMessage) linkedHashMap.get(Integer.valueOf(((Number) it.next()).intValue()));
            if (campaignMessage != null) {
                arrayList3.add(campaignMessage);
            }
        }
        return CollectionsKt.toList(CollectionsKt.toSet(arrayList3));
    }

    public String toString() {
        Object obj;
        Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp$toString$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                MessagesResp messagesResp = MessagesResp.this;
                converter.getSerializersModule();
                return converter.encodeToString(MessagesResp.INSTANCE.serializer(), messagesResp);
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        String str = (String) obj;
        return str == null ? super.toString() : str;
    }
}
