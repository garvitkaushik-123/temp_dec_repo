package com.sourcepoint.cmplibrary.model.exposed;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B9\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "", "seen1", "", "granted", "", "purposeGrants", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/util/Map;)V", "getGranted$annotations", "()V", "getGranted", "()Z", "getPurposeGrants", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class GDPRPurposeGrants {
    private final boolean granted;
    private final Map<String, Boolean> purposeGrants;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, BooleanSerializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public GDPRPurposeGrants() {
        this(false, (Map) null, 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GDPRPurposeGrants copy$default(GDPRPurposeGrants gDPRPurposeGrants, boolean z, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = gDPRPurposeGrants.granted;
        }
        if ((i & 2) != 0) {
            map = gDPRPurposeGrants.purposeGrants;
        }
        return gDPRPurposeGrants.copy(z, map);
    }

    @SerialName("vendorGrant")
    public static /* synthetic */ void getGranted$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getGranted() {
        return this.granted;
    }

    public final Map<String, Boolean> component2() {
        return this.purposeGrants;
    }

    public final GDPRPurposeGrants copy(boolean granted, Map<String, Boolean> purposeGrants) {
        Intrinsics.checkNotNullParameter(purposeGrants, "purposeGrants");
        return new GDPRPurposeGrants(granted, purposeGrants);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GDPRPurposeGrants)) {
            return false;
        }
        GDPRPurposeGrants gDPRPurposeGrants = (GDPRPurposeGrants) other;
        return this.granted == gDPRPurposeGrants.granted && Intrinsics.areEqual(this.purposeGrants, gDPRPurposeGrants.purposeGrants);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.granted) * 31) + this.purposeGrants.hashCode();
    }

    public String toString() {
        return "GDPRPurposeGrants(granted=" + this.granted + ", purposeGrants=" + this.purposeGrants + ")";
    }

    /* compiled from: SPConsents.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GDPRPurposeGrants> serializer() {
            return GDPRPurposeGrants$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ GDPRPurposeGrants(int i, @SerialName("vendorGrant") boolean z, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        this.granted = (i & 1) == 0 ? false : z;
        if ((i & 2) == 0) {
            this.purposeGrants = MapsKt.emptyMap();
        } else {
            this.purposeGrants = map;
        }
    }

    public GDPRPurposeGrants(boolean z, Map<String, Boolean> purposeGrants) {
        Intrinsics.checkNotNullParameter(purposeGrants, "purposeGrants");
        this.granted = z;
        this.purposeGrants = purposeGrants;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(GDPRPurposeGrants self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.granted) {
            output.encodeBooleanElement(serialDesc, 0, self.granted);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && Intrinsics.areEqual(self.purposeGrants, MapsKt.emptyMap())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.purposeGrants);
    }

    public final boolean getGranted() {
        return this.granted;
    }

    public /* synthetic */ GDPRPurposeGrants(boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Boolean> getPurposeGrants() {
        return this.purposeGrants;
    }
}
