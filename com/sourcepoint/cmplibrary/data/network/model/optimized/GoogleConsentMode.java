package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.SpConsentStatusSerializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB-\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u0006,"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "", "seen1", "", "adStorage", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;", "analyticsStorage", "adUserData", "adPersonalization", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;)V", "getAdPersonalization$annotations", "()V", "getAdPersonalization", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GCMStatus;", "getAdStorage$annotations", "getAdStorage", "getAdUserData$annotations", "getAdUserData", "getAnalyticsStorage$annotations", "getAnalyticsStorage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class GoogleConsentMode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GCMStatus adPersonalization;
    private final GCMStatus adStorage;
    private final GCMStatus adUserData;
    private final GCMStatus analyticsStorage;

    public static /* synthetic */ GoogleConsentMode copy$default(GoogleConsentMode googleConsentMode, GCMStatus gCMStatus, GCMStatus gCMStatus2, GCMStatus gCMStatus3, GCMStatus gCMStatus4, int i, Object obj) {
        if ((i & 1) != 0) {
            gCMStatus = googleConsentMode.adStorage;
        }
        if ((i & 2) != 0) {
            gCMStatus2 = googleConsentMode.analyticsStorage;
        }
        if ((i & 4) != 0) {
            gCMStatus3 = googleConsentMode.adUserData;
        }
        if ((i & 8) != 0) {
            gCMStatus4 = googleConsentMode.adPersonalization;
        }
        return googleConsentMode.copy(gCMStatus, gCMStatus2, gCMStatus3, gCMStatus4);
    }

    @SerialName("ad_personalization")
    @Serializable(with = SpConsentStatusSerializer.class)
    public static /* synthetic */ void getAdPersonalization$annotations() {
    }

    @SerialName("ad_storage")
    @Serializable(with = SpConsentStatusSerializer.class)
    public static /* synthetic */ void getAdStorage$annotations() {
    }

    @SerialName("ad_user_data")
    @Serializable(with = SpConsentStatusSerializer.class)
    public static /* synthetic */ void getAdUserData$annotations() {
    }

    @SerialName("analytics_storage")
    @Serializable(with = SpConsentStatusSerializer.class)
    public static /* synthetic */ void getAnalyticsStorage$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final GCMStatus getAdStorage() {
        return this.adStorage;
    }

    /* renamed from: component2, reason: from getter */
    public final GCMStatus getAnalyticsStorage() {
        return this.analyticsStorage;
    }

    /* renamed from: component3, reason: from getter */
    public final GCMStatus getAdUserData() {
        return this.adUserData;
    }

    /* renamed from: component4, reason: from getter */
    public final GCMStatus getAdPersonalization() {
        return this.adPersonalization;
    }

    public final GoogleConsentMode copy(GCMStatus adStorage, GCMStatus analyticsStorage, GCMStatus adUserData, GCMStatus adPersonalization) {
        return new GoogleConsentMode(adStorage, analyticsStorage, adUserData, adPersonalization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleConsentMode)) {
            return false;
        }
        GoogleConsentMode googleConsentMode = (GoogleConsentMode) other;
        return this.adStorage == googleConsentMode.adStorage && this.analyticsStorage == googleConsentMode.analyticsStorage && this.adUserData == googleConsentMode.adUserData && this.adPersonalization == googleConsentMode.adPersonalization;
    }

    public int hashCode() {
        GCMStatus gCMStatus = this.adStorage;
        int hashCode = (gCMStatus == null ? 0 : gCMStatus.hashCode()) * 31;
        GCMStatus gCMStatus2 = this.analyticsStorage;
        int hashCode2 = (hashCode + (gCMStatus2 == null ? 0 : gCMStatus2.hashCode())) * 31;
        GCMStatus gCMStatus3 = this.adUserData;
        int hashCode3 = (hashCode2 + (gCMStatus3 == null ? 0 : gCMStatus3.hashCode())) * 31;
        GCMStatus gCMStatus4 = this.adPersonalization;
        return hashCode3 + (gCMStatus4 != null ? gCMStatus4.hashCode() : 0);
    }

    public String toString() {
        return "GoogleConsentMode(adStorage=" + this.adStorage + ", analyticsStorage=" + this.analyticsStorage + ", adUserData=" + this.adUserData + ", adPersonalization=" + this.adPersonalization + ")";
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GoogleConsentMode> serializer() {
            return GoogleConsentMode$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ GoogleConsentMode(int i, @SerialName("ad_storage") @Serializable(with = SpConsentStatusSerializer.class) GCMStatus gCMStatus, @SerialName("analytics_storage") @Serializable(with = SpConsentStatusSerializer.class) GCMStatus gCMStatus2, @SerialName("ad_user_data") @Serializable(with = SpConsentStatusSerializer.class) GCMStatus gCMStatus3, @SerialName("ad_personalization") @Serializable(with = SpConsentStatusSerializer.class) GCMStatus gCMStatus4, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, GoogleConsentMode$$serializer.INSTANCE.getDescriptor());
        }
        this.adStorage = gCMStatus;
        this.analyticsStorage = gCMStatus2;
        this.adUserData = gCMStatus3;
        this.adPersonalization = gCMStatus4;
    }

    public GoogleConsentMode(GCMStatus gCMStatus, GCMStatus gCMStatus2, GCMStatus gCMStatus3, GCMStatus gCMStatus4) {
        this.adStorage = gCMStatus;
        this.analyticsStorage = gCMStatus2;
        this.adUserData = gCMStatus3;
        this.adPersonalization = gCMStatus4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(GoogleConsentMode self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, SpConsentStatusSerializer.INSTANCE, self.adStorage);
        output.encodeNullableSerializableElement(serialDesc, 1, SpConsentStatusSerializer.INSTANCE, self.analyticsStorage);
        output.encodeNullableSerializableElement(serialDesc, 2, SpConsentStatusSerializer.INSTANCE, self.adUserData);
        output.encodeNullableSerializableElement(serialDesc, 3, SpConsentStatusSerializer.INSTANCE, self.adPersonalization);
    }

    public final GCMStatus getAdStorage() {
        return this.adStorage;
    }

    public final GCMStatus getAnalyticsStorage() {
        return this.analyticsStorage;
    }

    public final GCMStatus getAdUserData() {
        return this.adUserData;
    }

    public final GCMStatus getAdPersonalization() {
        return this.adPersonalization;
    }
}
