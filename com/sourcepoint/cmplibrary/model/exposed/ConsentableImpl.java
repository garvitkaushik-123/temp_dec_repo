package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.json.JSONObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/ConsentableImpl;", "Lcom/sourcepoint/cmplibrary/model/exposed/Consentable;", "seen1", "", "id", "", "consented", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Z)V", "getConsented", "()Z", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toJsonObject", "Lorg/json/JSONObject;", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class ConsentableImpl implements Consentable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean consented;
    private final String id;

    public static /* synthetic */ ConsentableImpl copy$default(ConsentableImpl consentableImpl, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consentableImpl.id;
        }
        if ((i & 2) != 0) {
            z = consentableImpl.consented;
        }
        return consentableImpl.copy(str, z);
    }

    @SerialName("_id")
    public static /* synthetic */ void getId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getConsented() {
        return this.consented;
    }

    public final ConsentableImpl copy(String id, boolean consented) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ConsentableImpl(id, consented);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentableImpl)) {
            return false;
        }
        ConsentableImpl consentableImpl = (ConsentableImpl) other;
        return Intrinsics.areEqual(this.id, consentableImpl.id) && this.consented == consentableImpl.consented;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + Boolean.hashCode(this.consented);
    }

    public String toString() {
        return "ConsentableImpl(id=" + this.id + ", consented=" + this.consented + ")";
    }

    /* compiled from: SPConsents.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/ConsentableImpl$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/model/exposed/ConsentableImpl;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConsentableImpl> serializer() {
            return ConsentableImpl$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ConsentableImpl(int i, @SerialName("_id") String str, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ConsentableImpl$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.consented = z;
    }

    public ConsentableImpl(String id, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.consented = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentableImpl self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeBooleanElement(serialDesc, 1, self.getConsented());
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.Consentable
    public String getId() {
        return this.id;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.Consentable
    public boolean getConsented() {
        return this.consented;
    }

    public final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", getId());
        jSONObject.put("consented", getConsented());
        return jSONObject;
    }
}
