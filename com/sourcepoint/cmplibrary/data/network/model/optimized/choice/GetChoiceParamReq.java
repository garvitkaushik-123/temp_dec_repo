package com.sourcepoint.cmplibrary.data.network.model.optimized.choice;

import com.ironsource.D5;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg$$serializer;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: GetChoiceParamReq.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 >2\u00020\u0001:\u0002=>Bi\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015BU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0002\u0010\u0016J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003Je\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010HÆ\u0001J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001J&\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;HÁ\u0001¢\u0006\u0002\b<R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001e¨\u0006?"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "", "seen1", "", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "choiceType", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceTypeParam;", "metadataArg", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "propertyId", "", InMobiAdapter.ACCOUNT_ID, "includeData", "Lkotlinx/serialization/json/JsonObject;", "hasCsp", "", "includeCustomVendorsRes", "withSiteActions", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/util/Env;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceTypeParam;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;JJLkotlinx/serialization/json/JsonObject;ZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/util/Env;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceTypeParam;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;JJLkotlinx/serialization/json/JsonObject;ZZZ)V", "getAccountId", "()J", "getChoiceType", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceTypeParam;", "getEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "getHasCsp", "()Z", "getIncludeCustomVendorsRes", "getIncludeData", "()Lkotlinx/serialization/json/JsonObject;", "getMetadataArg", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "getPropertyId", "getWithSiteActions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class GetChoiceParamReq {
    private final long accountId;
    private final ChoiceTypeParam choiceType;
    private final Env env;
    private final boolean hasCsp;
    private final boolean includeCustomVendorsRes;
    private final JsonObject includeData;
    private final MetaDataArg metadataArg;
    private final long propertyId;
    private final boolean withSiteActions;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.data.network.util.Env", Env.values()), EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceTypeParam", ChoiceTypeParam.values()), null, null, null, null, null, null, null};

    public static /* synthetic */ GetChoiceParamReq copy$default(GetChoiceParamReq getChoiceParamReq, Env env, ChoiceTypeParam choiceTypeParam, MetaDataArg metaDataArg, long j, long j2, JsonObject jsonObject, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            env = getChoiceParamReq.env;
        }
        if ((i & 2) != 0) {
            choiceTypeParam = getChoiceParamReq.choiceType;
        }
        if ((i & 4) != 0) {
            metaDataArg = getChoiceParamReq.metadataArg;
        }
        if ((i & 8) != 0) {
            j = getChoiceParamReq.propertyId;
        }
        if ((i & 16) != 0) {
            j2 = getChoiceParamReq.accountId;
        }
        if ((i & 32) != 0) {
            jsonObject = getChoiceParamReq.includeData;
        }
        if ((i & 64) != 0) {
            z = getChoiceParamReq.hasCsp;
        }
        if ((i & 128) != 0) {
            z2 = getChoiceParamReq.includeCustomVendorsRes;
        }
        if ((i & 256) != 0) {
            z3 = getChoiceParamReq.withSiteActions;
        }
        long j3 = j2;
        long j4 = j;
        MetaDataArg metaDataArg2 = metaDataArg;
        return getChoiceParamReq.copy(env, choiceTypeParam, metaDataArg2, j4, j3, jsonObject, z, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Env getEnv() {
        return this.env;
    }

    /* renamed from: component2, reason: from getter */
    public final ChoiceTypeParam getChoiceType() {
        return this.choiceType;
    }

    /* renamed from: component3, reason: from getter */
    public final MetaDataArg getMetadataArg() {
        return this.metadataArg;
    }

    /* renamed from: component4, reason: from getter */
    public final long getPropertyId() {
        return this.propertyId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getAccountId() {
        return this.accountId;
    }

    /* renamed from: component6, reason: from getter */
    public final JsonObject getIncludeData() {
        return this.includeData;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getHasCsp() {
        return this.hasCsp;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIncludeCustomVendorsRes() {
        return this.includeCustomVendorsRes;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getWithSiteActions() {
        return this.withSiteActions;
    }

    public final GetChoiceParamReq copy(Env env, ChoiceTypeParam choiceType, MetaDataArg metadataArg, long propertyId, long accountId, JsonObject includeData, boolean hasCsp, boolean includeCustomVendorsRes, boolean withSiteActions) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(choiceType, "choiceType");
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        return new GetChoiceParamReq(env, choiceType, metadataArg, propertyId, accountId, includeData, hasCsp, includeCustomVendorsRes, withSiteActions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetChoiceParamReq)) {
            return false;
        }
        GetChoiceParamReq getChoiceParamReq = (GetChoiceParamReq) other;
        return this.env == getChoiceParamReq.env && this.choiceType == getChoiceParamReq.choiceType && Intrinsics.areEqual(this.metadataArg, getChoiceParamReq.metadataArg) && this.propertyId == getChoiceParamReq.propertyId && this.accountId == getChoiceParamReq.accountId && Intrinsics.areEqual(this.includeData, getChoiceParamReq.includeData) && this.hasCsp == getChoiceParamReq.hasCsp && this.includeCustomVendorsRes == getChoiceParamReq.includeCustomVendorsRes && this.withSiteActions == getChoiceParamReq.withSiteActions;
    }

    public int hashCode() {
        int hashCode = ((this.env.hashCode() * 31) + this.choiceType.hashCode()) * 31;
        MetaDataArg metaDataArg = this.metadataArg;
        return ((((((((((((hashCode + (metaDataArg == null ? 0 : metaDataArg.hashCode())) * 31) + Long.hashCode(this.propertyId)) * 31) + Long.hashCode(this.accountId)) * 31) + this.includeData.hashCode()) * 31) + Boolean.hashCode(this.hasCsp)) * 31) + Boolean.hashCode(this.includeCustomVendorsRes)) * 31) + Boolean.hashCode(this.withSiteActions);
    }

    public String toString() {
        return "GetChoiceParamReq(env=" + this.env + ", choiceType=" + this.choiceType + ", metadataArg=" + this.metadataArg + ", propertyId=" + this.propertyId + ", accountId=" + this.accountId + ", includeData=" + this.includeData + ", hasCsp=" + this.hasCsp + ", includeCustomVendorsRes=" + this.includeCustomVendorsRes + ", withSiteActions=" + this.withSiteActions + ")";
    }

    /* compiled from: GetChoiceParamReq.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GetChoiceParamReq> serializer() {
            return GetChoiceParamReq$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ GetChoiceParamReq(int i, Env env, ChoiceTypeParam choiceTypeParam, MetaDataArg metaDataArg, long j, long j2, JsonObject jsonObject, boolean z, boolean z2, boolean z3, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, GetChoiceParamReq$$serializer.INSTANCE.getDescriptor());
        }
        this.env = env;
        this.choiceType = choiceTypeParam;
        this.metadataArg = metaDataArg;
        this.propertyId = j;
        this.accountId = j2;
        this.includeData = jsonObject;
        if ((i & 64) == 0) {
            this.hasCsp = true;
        } else {
            this.hasCsp = z;
        }
        if ((i & 128) == 0) {
            this.includeCustomVendorsRes = false;
        } else {
            this.includeCustomVendorsRes = z2;
        }
        if ((i & 256) == 0) {
            this.withSiteActions = false;
        } else {
            this.withSiteActions = z3;
        }
    }

    public GetChoiceParamReq(Env env, ChoiceTypeParam choiceType, MetaDataArg metaDataArg, long j, long j2, JsonObject includeData, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(choiceType, "choiceType");
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        this.env = env;
        this.choiceType = choiceType;
        this.metadataArg = metaDataArg;
        this.propertyId = j;
        this.accountId = j2;
        this.includeData = includeData;
        this.hasCsp = z;
        this.includeCustomVendorsRes = z2;
        this.withSiteActions = z3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(GetChoiceParamReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.env);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.choiceType);
        output.encodeNullableSerializableElement(serialDesc, 2, MetaDataArg$$serializer.INSTANCE, self.metadataArg);
        output.encodeLongElement(serialDesc, 3, self.propertyId);
        output.encodeLongElement(serialDesc, 4, self.accountId);
        output.encodeSerializableElement(serialDesc, 5, JsonObjectSerializer.INSTANCE, self.includeData);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !self.hasCsp) {
            output.encodeBooleanElement(serialDesc, 6, self.hasCsp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.includeCustomVendorsRes) {
            output.encodeBooleanElement(serialDesc, 7, self.includeCustomVendorsRes);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.withSiteActions) {
            output.encodeBooleanElement(serialDesc, 8, self.withSiteActions);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GetChoiceParamReq(com.sourcepoint.cmplibrary.data.network.util.Env r15, com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceTypeParam r16, com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg r17, long r18, long r20, kotlinx.serialization.json.JsonObject r22, boolean r23, boolean r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 64
            if (r1 == 0) goto L9
            r1 = 1
            r11 = r1
            goto Lb
        L9:
            r11 = r23
        Lb:
            r1 = r0 & 128(0x80, float:1.8E-43)
            r2 = 0
            if (r1 == 0) goto L12
            r12 = r2
            goto L14
        L12:
            r12 = r24
        L14:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L26
            r13 = r2
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r8 = r20
            r10 = r22
            r2 = r14
            goto L34
        L26:
            r13 = r25
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r8 = r20
            r10 = r22
        L34:
            r2.<init>(r3, r4, r5, r6, r8, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sourcepoint.cmplibrary.data.network.model.optimized.choice.GetChoiceParamReq.<init>(com.sourcepoint.cmplibrary.data.network.util.Env, com.sourcepoint.cmplibrary.data.network.model.optimized.choice.ChoiceTypeParam, com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg, long, long, kotlinx.serialization.json.JsonObject, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Env getEnv() {
        return this.env;
    }

    public final ChoiceTypeParam getChoiceType() {
        return this.choiceType;
    }

    public final MetaDataArg getMetadataArg() {
        return this.metadataArg;
    }

    public final long getPropertyId() {
        return this.propertyId;
    }

    public final long getAccountId() {
        return this.accountId;
    }

    public final JsonObject getIncludeData() {
        return this.includeData;
    }

    public final boolean getHasCsp() {
        return this.hasCsp;
    }

    public final boolean getIncludeCustomVendorsRes() {
        return this.includeCustomVendorsRes;
    }

    public final boolean getWithSiteActions() {
        return this.withSiteActions;
    }
}
