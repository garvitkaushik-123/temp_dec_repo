package com.vungle.ads.internal.model;

import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.vungle.ads.internal.protos.Sdk;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DeviceNode.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0003HIJB\u0083\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013Bq\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0014J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0086\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\u0005HÖ\u0001J!\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GHÇ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010!R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010!R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001e¨\u0006K"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode;", "", "seen1", "", N6.t, "", N6.B, "osv", N6.P0, N6.F, "w", "h", N6.d0, "ifa", "lmt", "ext", "Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;)V", "getCarrier", "()Ljava/lang/String;", "getExt", "()Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "setExt", "(Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;)V", "getH", "()I", "setH", "(I)V", "getIfa", "setIfa", "(Ljava/lang/String;)V", "getLmt", "()Ljava/lang/Integer;", "setLmt", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMake", "getModel", "getOs", "getOsv", "getUa", "setUa", "getW", "setW", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;)Lcom/vungle/ads/internal/model/DeviceNode;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "VungleExt", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class DeviceNode {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String carrier;
    private VungleExt ext;
    private int h;
    private String ifa;
    private Integer lmt;
    private final String make;
    private final String model;
    private final String os;
    private final String osv;
    private String ua;
    private int w;

    public static /* synthetic */ DeviceNode copy$default(DeviceNode deviceNode, String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, Integer num, VungleExt vungleExt, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = deviceNode.make;
        }
        if ((i3 & 2) != 0) {
            str2 = deviceNode.model;
        }
        if ((i3 & 4) != 0) {
            str3 = deviceNode.osv;
        }
        if ((i3 & 8) != 0) {
            str4 = deviceNode.carrier;
        }
        if ((i3 & 16) != 0) {
            str5 = deviceNode.os;
        }
        if ((i3 & 32) != 0) {
            i = deviceNode.w;
        }
        if ((i3 & 64) != 0) {
            i2 = deviceNode.h;
        }
        if ((i3 & 128) != 0) {
            str6 = deviceNode.ua;
        }
        if ((i3 & 256) != 0) {
            str7 = deviceNode.ifa;
        }
        if ((i3 & 512) != 0) {
            num = deviceNode.lmt;
        }
        if ((i3 & 1024) != 0) {
            vungleExt = deviceNode.ext;
        }
        Integer num2 = num;
        VungleExt vungleExt2 = vungleExt;
        String str8 = str6;
        String str9 = str7;
        int i4 = i;
        int i5 = i2;
        String str10 = str5;
        String str11 = str3;
        return deviceNode.copy(str, str2, str11, str4, str10, i4, i5, str8, str9, num2, vungleExt2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMake() {
        return this.make;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getLmt() {
        return this.lmt;
    }

    /* renamed from: component11, reason: from getter */
    public final VungleExt getExt() {
        return this.ext;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOsv() {
        return this.osv;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCarrier() {
        return this.carrier;
    }

    /* renamed from: component5, reason: from getter */
    public final String getOs() {
        return this.os;
    }

    /* renamed from: component6, reason: from getter */
    public final int getW() {
        return this.w;
    }

    /* renamed from: component7, reason: from getter */
    public final int getH() {
        return this.h;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUa() {
        return this.ua;
    }

    /* renamed from: component9, reason: from getter */
    public final String getIfa() {
        return this.ifa;
    }

    public final DeviceNode copy(String make, String model, String osv, String carrier, String os, int w, int h, String ua, String ifa, Integer lmt, VungleExt ext) {
        Intrinsics.checkNotNullParameter(make, "make");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(osv, "osv");
        Intrinsics.checkNotNullParameter(os, "os");
        return new DeviceNode(make, model, osv, carrier, os, w, h, ua, ifa, lmt, ext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceNode)) {
            return false;
        }
        DeviceNode deviceNode = (DeviceNode) other;
        return Intrinsics.areEqual(this.make, deviceNode.make) && Intrinsics.areEqual(this.model, deviceNode.model) && Intrinsics.areEqual(this.osv, deviceNode.osv) && Intrinsics.areEqual(this.carrier, deviceNode.carrier) && Intrinsics.areEqual(this.os, deviceNode.os) && this.w == deviceNode.w && this.h == deviceNode.h && Intrinsics.areEqual(this.ua, deviceNode.ua) && Intrinsics.areEqual(this.ifa, deviceNode.ifa) && Intrinsics.areEqual(this.lmt, deviceNode.lmt) && Intrinsics.areEqual(this.ext, deviceNode.ext);
    }

    public int hashCode() {
        int hashCode = ((((this.make.hashCode() * 31) + this.model.hashCode()) * 31) + this.osv.hashCode()) * 31;
        String str = this.carrier;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.os.hashCode()) * 31) + Integer.hashCode(this.w)) * 31) + Integer.hashCode(this.h)) * 31;
        String str2 = this.ua;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ifa;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lmt;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        VungleExt vungleExt = this.ext;
        return hashCode5 + (vungleExt != null ? vungleExt.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceNode(make=");
        sb.append(this.make).append(", model=").append(this.model).append(", osv=").append(this.osv).append(", carrier=").append(this.carrier).append(", os=").append(this.os).append(", w=").append(this.w).append(", h=").append(this.h).append(", ua=").append(this.ua).append(", ifa=").append(this.ifa).append(", lmt=").append(this.lmt).append(", ext=").append(this.ext).append(')');
        return sb.toString();
    }

    /* compiled from: DeviceNode.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeviceNode> serializer() {
            return DeviceNode$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DeviceNode(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3, String str6, String str7, Integer num, VungleExt vungleExt, SerializationConstructorMarker serializationConstructorMarker) {
        if (119 != (i & Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE)) {
            PluginExceptionsKt.throwMissingFieldException(i, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, DeviceNode$$serializer.INSTANCE.getDescriptor());
        }
        this.make = str;
        this.model = str2;
        this.osv = str3;
        if ((i & 8) == 0) {
            this.carrier = null;
        } else {
            this.carrier = str4;
        }
        this.os = str5;
        this.w = i2;
        this.h = i3;
        if ((i & 128) == 0) {
            this.ua = null;
        } else {
            this.ua = str6;
        }
        if ((i & 256) == 0) {
            this.ifa = null;
        } else {
            this.ifa = str7;
        }
        if ((i & 512) == 0) {
            this.lmt = null;
        } else {
            this.lmt = num;
        }
        if ((i & 1024) == 0) {
            this.ext = null;
        } else {
            this.ext = vungleExt;
        }
    }

    public DeviceNode(String make, String model, String osv, String str, String os, int i, int i2, String str2, String str3, Integer num, VungleExt vungleExt) {
        Intrinsics.checkNotNullParameter(make, "make");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(osv, "osv");
        Intrinsics.checkNotNullParameter(os, "os");
        this.make = make;
        this.model = model;
        this.osv = osv;
        this.carrier = str;
        this.os = os;
        this.w = i;
        this.h = i2;
        this.ua = str2;
        this.ifa = str3;
        this.lmt = num;
        this.ext = vungleExt;
    }

    @JvmStatic
    public static final void write$Self(DeviceNode self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.make);
        output.encodeStringElement(serialDesc, 1, self.model);
        output.encodeStringElement(serialDesc, 2, self.osv);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.carrier != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.carrier);
        }
        output.encodeStringElement(serialDesc, 4, self.os);
        output.encodeIntElement(serialDesc, 5, self.w);
        output.encodeIntElement(serialDesc, 6, self.h);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.ua != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.ua);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.ifa != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.ifa);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.lmt != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.lmt);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && self.ext == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 10, DeviceNode$VungleExt$$serializer.INSTANCE, self.ext);
    }

    public /* synthetic */ DeviceNode(String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, String str7, Integer num, VungleExt vungleExt, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : str4, str5, i, i2, (i3 & 128) != 0 ? null : str6, (i3 & 256) != 0 ? null : str7, (i3 & 512) != 0 ? null : num, (i3 & 1024) != 0 ? null : vungleExt);
    }

    public final String getMake() {
        return this.make;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getOsv() {
        return this.osv;
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final String getOs() {
        return this.os;
    }

    public final int getW() {
        return this.w;
    }

    public final void setW(int i) {
        this.w = i;
    }

    public final int getH() {
        return this.h;
    }

    public final void setH(int i) {
        this.h = i;
    }

    public final String getUa() {
        return this.ua;
    }

    public final void setUa(String str) {
        this.ua = str;
    }

    public final String getIfa() {
        return this.ifa;
    }

    public final void setIfa(String str) {
        this.ifa = str;
    }

    public final Integer getLmt() {
        return this.lmt;
    }

    public final void setLmt(Integer num) {
        this.lmt = num;
    }

    public final VungleExt getExt() {
        return this.ext;
    }

    public final void setExt(VungleExt vungleExt) {
        this.ext = vungleExt;
    }

    /* compiled from: DeviceNode.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bm\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u0094\u00012\u00020\u0001:\u0004\u0093\u0001\u0094\u0001B\u0091\u0002\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\u0012\u001a\u00020\n\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 Bý\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010!J\t\u0010p\u001a\u00020\u0005HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010s\u001a\u00020\nHÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\t\u0010w\u001a\u00020\u0005HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010z\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010WJ\u000b\u0010{\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010WJ\u0010\u0010}\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010WJ\u0010\u0010~\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010WJ\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010-J\n\u0010\u0080\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0088\u0002\u0010\u0086\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0003\u0010\u0087\u0001J\u0015\u0010\u0088\u0001\u001a\u00020\u00052\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u008b\u0001\u001a\u00020\u0007HÖ\u0001J(\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u00002\b\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001HÇ\u0001R&\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R(\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u00100\u0012\u0004\b+\u0010#\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010#\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010#\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R&\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b;\u0010#\u001a\u0004\b<\u0010%\"\u0004\b=\u0010'R&\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b>\u0010#\u001a\u0004\b?\u0010%\"\u0004\b@\u0010'R&\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010#\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'R&\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bD\u0010#\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010#\u001a\u0004\b\u0004\u0010H\"\u0004\bI\u0010JR$\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bK\u0010#\u001a\u0004\b\u0016\u0010H\"\u0004\bL\u0010JR$\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bM\u0010#\u001a\u0004\b\u0014\u0010H\"\u0004\bN\u0010JR&\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u0010#\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'R&\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bR\u0010#\u001a\u0004\bS\u0010%\"\u0004\bT\u0010'R(\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010Z\u0012\u0004\bU\u0010#\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR(\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010Z\u0012\u0004\b[\u0010#\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR(\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010Z\u0012\u0004\b^\u0010#\u001a\u0004\b_\u0010W\"\u0004\b`\u0010YR$\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\ba\u0010#\u001a\u0004\bb\u00108\"\u0004\bc\u0010:R(\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010Z\u0012\u0004\bd\u0010#\u001a\u0004\be\u0010W\"\u0004\bf\u0010YR$\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bg\u0010#\u001a\u0004\bh\u00108\"\u0004\bi\u0010:R&\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bj\u0010#\u001a\u0004\bk\u0010%\"\u0004\bl\u0010'R$\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bm\u0010#\u001a\u0004\bn\u00103\"\u0004\bo\u00105¨\u0006\u0095\u0001"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "", "seen1", "", "isGooglePlayServicesAvailable", "", "appSetId", "", "appSetIdScope", C3040d4.i.Y, "", "batteryState", "batterySaverEnabled", "connectionType", "connectionTypeDetail", "locale", "language", "timeZone", "volumeLevel", "soundEnabled", "isTv", C3040d4.i.i0, "isSideloadEnabled", "gaid", "amazonAdvertisingId", "sit", "", "oit", "ort", "obt", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/lang/String;Ljava/lang/Integer;FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/lang/String;Ljava/lang/Integer;FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getAmazonAdvertisingId$annotations", "()V", "getAmazonAdvertisingId", "()Ljava/lang/String;", "setAmazonAdvertisingId", "(Ljava/lang/String;)V", "getAppSetId$annotations", "getAppSetId", "setAppSetId", "getAppSetIdScope$annotations", "getAppSetIdScope", "()Ljava/lang/Integer;", "setAppSetIdScope", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBatteryLevel$annotations", "getBatteryLevel", "()F", "setBatteryLevel", "(F)V", "getBatterySaverEnabled$annotations", "getBatterySaverEnabled", "()I", "setBatterySaverEnabled", "(I)V", "getBatteryState$annotations", "getBatteryState", "setBatteryState", "getConnectionType$annotations", "getConnectionType", "setConnectionType", "getConnectionTypeDetail$annotations", "getConnectionTypeDetail", "setConnectionTypeDetail", "getGaid$annotations", "getGaid", "setGaid", "isGooglePlayServicesAvailable$annotations", "()Z", "setGooglePlayServicesAvailable", "(Z)V", "isSideloadEnabled$annotations", "setSideloadEnabled", "isTv$annotations", "setTv", "getLanguage$annotations", "getLanguage", "setLanguage", "getLocale$annotations", "getLocale", "setLocale", "getObt$annotations", "getObt", "()Ljava/lang/Long;", "setObt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOit$annotations", "getOit", "setOit", "getOrt$annotations", "getOrt", "setOrt", "getSdCardAvailable$annotations", "getSdCardAvailable", "setSdCardAvailable", "getSit$annotations", "getSit", "setSit", "getSoundEnabled$annotations", "getSoundEnabled", "setSoundEnabled", "getTimeZone$annotations", "getTimeZone", "setTimeZone", "getVolumeLevel$annotations", "getVolumeLevel", "setVolumeLevel", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;Ljava/lang/Integer;FLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Serializable
    public static final /* data */ class VungleExt {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String amazonAdvertisingId;
        private String appSetId;
        private Integer appSetIdScope;
        private float batteryLevel;
        private int batterySaverEnabled;
        private String batteryState;
        private String connectionType;
        private String connectionTypeDetail;
        private String gaid;
        private boolean isGooglePlayServicesAvailable;
        private boolean isSideloadEnabled;
        private boolean isTv;
        private String language;
        private String locale;
        private Long obt;
        private Long oit;
        private Long ort;
        private int sdCardAvailable;
        private Long sit;
        private int soundEnabled;
        private String timeZone;
        private float volumeLevel;

        public VungleExt() {
            this(false, (String) null, (Integer) null, 0.0f, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 0.0f, 0, false, 0, false, (String) null, (String) null, (Long) null, (Long) null, (Long) null, (Long) null, 4194303, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ VungleExt copy$default(VungleExt vungleExt, boolean z, String str, Integer num, float f, String str2, int i, String str3, String str4, String str5, String str6, String str7, float f2, int i2, boolean z2, int i3, boolean z3, String str8, String str9, Long l, Long l2, Long l3, Long l4, int i4, Object obj) {
            Long l5;
            Long l6;
            boolean z4 = (i4 & 1) != 0 ? vungleExt.isGooglePlayServicesAvailable : z;
            String str10 = (i4 & 2) != 0 ? vungleExt.appSetId : str;
            Integer num2 = (i4 & 4) != 0 ? vungleExt.appSetIdScope : num;
            float f3 = (i4 & 8) != 0 ? vungleExt.batteryLevel : f;
            String str11 = (i4 & 16) != 0 ? vungleExt.batteryState : str2;
            int i5 = (i4 & 32) != 0 ? vungleExt.batterySaverEnabled : i;
            String str12 = (i4 & 64) != 0 ? vungleExt.connectionType : str3;
            String str13 = (i4 & 128) != 0 ? vungleExt.connectionTypeDetail : str4;
            String str14 = (i4 & 256) != 0 ? vungleExt.locale : str5;
            String str15 = (i4 & 512) != 0 ? vungleExt.language : str6;
            String str16 = (i4 & 1024) != 0 ? vungleExt.timeZone : str7;
            float f4 = (i4 & 2048) != 0 ? vungleExt.volumeLevel : f2;
            int i6 = (i4 & 4096) != 0 ? vungleExt.soundEnabled : i2;
            boolean z5 = (i4 & 8192) != 0 ? vungleExt.isTv : z2;
            boolean z6 = z4;
            int i7 = (i4 & 16384) != 0 ? vungleExt.sdCardAvailable : i3;
            boolean z7 = (i4 & 32768) != 0 ? vungleExt.isSideloadEnabled : z3;
            String str17 = (i4 & 65536) != 0 ? vungleExt.gaid : str8;
            String str18 = (i4 & 131072) != 0 ? vungleExt.amazonAdvertisingId : str9;
            Long l7 = (i4 & 262144) != 0 ? vungleExt.sit : l;
            Long l8 = (i4 & 524288) != 0 ? vungleExt.oit : l2;
            Long l9 = (i4 & 1048576) != 0 ? vungleExt.ort : l3;
            if ((i4 & 2097152) != 0) {
                l6 = l9;
                l5 = vungleExt.obt;
            } else {
                l5 = l4;
                l6 = l9;
            }
            return vungleExt.copy(z6, str10, num2, f3, str11, i5, str12, str13, str14, str15, str16, f4, i6, z5, i7, z7, str17, str18, l7, l8, l6, l5);
        }

        @SerialName("amazon_advertising_id")
        public static /* synthetic */ void getAmazonAdvertisingId$annotations() {
        }

        @SerialName("app_set_id")
        public static /* synthetic */ void getAppSetId$annotations() {
        }

        @SerialName("app_set_id_scope")
        public static /* synthetic */ void getAppSetIdScope$annotations() {
        }

        @SerialName("battery_level")
        public static /* synthetic */ void getBatteryLevel$annotations() {
        }

        @SerialName("battery_saver_enabled")
        public static /* synthetic */ void getBatterySaverEnabled$annotations() {
        }

        @SerialName("battery_state")
        public static /* synthetic */ void getBatteryState$annotations() {
        }

        @SerialName("connection_type")
        public static /* synthetic */ void getConnectionType$annotations() {
        }

        @SerialName("connection_type_detail")
        public static /* synthetic */ void getConnectionTypeDetail$annotations() {
        }

        @SerialName("gaid")
        public static /* synthetic */ void getGaid$annotations() {
        }

        @SerialName("language")
        public static /* synthetic */ void getLanguage$annotations() {
        }

        @SerialName("locale")
        public static /* synthetic */ void getLocale$annotations() {
        }

        @SerialName("obt")
        public static /* synthetic */ void getObt$annotations() {
        }

        @SerialName("oit")
        public static /* synthetic */ void getOit$annotations() {
        }

        @SerialName("ort")
        public static /* synthetic */ void getOrt$annotations() {
        }

        @SerialName("sd_card_available")
        public static /* synthetic */ void getSdCardAvailable$annotations() {
        }

        @SerialName("sit")
        public static /* synthetic */ void getSit$annotations() {
        }

        @SerialName("sound_enabled")
        public static /* synthetic */ void getSoundEnabled$annotations() {
        }

        @SerialName("time_zone")
        public static /* synthetic */ void getTimeZone$annotations() {
        }

        @SerialName("volume_level")
        public static /* synthetic */ void getVolumeLevel$annotations() {
        }

        @SerialName("is_google_play_services_available")
        public static /* synthetic */ void isGooglePlayServicesAvailable$annotations() {
        }

        @SerialName("is_sideload_enabled")
        public static /* synthetic */ void isSideloadEnabled$annotations() {
        }

        @SerialName("is_tv")
        public static /* synthetic */ void isTv$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsGooglePlayServicesAvailable() {
            return this.isGooglePlayServicesAvailable;
        }

        /* renamed from: component10, reason: from getter */
        public final String getLanguage() {
            return this.language;
        }

        /* renamed from: component11, reason: from getter */
        public final String getTimeZone() {
            return this.timeZone;
        }

        /* renamed from: component12, reason: from getter */
        public final float getVolumeLevel() {
            return this.volumeLevel;
        }

        /* renamed from: component13, reason: from getter */
        public final int getSoundEnabled() {
            return this.soundEnabled;
        }

        /* renamed from: component14, reason: from getter */
        public final boolean getIsTv() {
            return this.isTv;
        }

        /* renamed from: component15, reason: from getter */
        public final int getSdCardAvailable() {
            return this.sdCardAvailable;
        }

        /* renamed from: component16, reason: from getter */
        public final boolean getIsSideloadEnabled() {
            return this.isSideloadEnabled;
        }

        /* renamed from: component17, reason: from getter */
        public final String getGaid() {
            return this.gaid;
        }

        /* renamed from: component18, reason: from getter */
        public final String getAmazonAdvertisingId() {
            return this.amazonAdvertisingId;
        }

        /* renamed from: component19, reason: from getter */
        public final Long getSit() {
            return this.sit;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAppSetId() {
            return this.appSetId;
        }

        /* renamed from: component20, reason: from getter */
        public final Long getOit() {
            return this.oit;
        }

        /* renamed from: component21, reason: from getter */
        public final Long getOrt() {
            return this.ort;
        }

        /* renamed from: component22, reason: from getter */
        public final Long getObt() {
            return this.obt;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getAppSetIdScope() {
            return this.appSetIdScope;
        }

        /* renamed from: component4, reason: from getter */
        public final float getBatteryLevel() {
            return this.batteryLevel;
        }

        /* renamed from: component5, reason: from getter */
        public final String getBatteryState() {
            return this.batteryState;
        }

        /* renamed from: component6, reason: from getter */
        public final int getBatterySaverEnabled() {
            return this.batterySaverEnabled;
        }

        /* renamed from: component7, reason: from getter */
        public final String getConnectionType() {
            return this.connectionType;
        }

        /* renamed from: component8, reason: from getter */
        public final String getConnectionTypeDetail() {
            return this.connectionTypeDetail;
        }

        /* renamed from: component9, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        public final VungleExt copy(boolean isGooglePlayServicesAvailable, String appSetId, Integer appSetIdScope, float batteryLevel, String batteryState, int batterySaverEnabled, String connectionType, String connectionTypeDetail, String locale, String language, String timeZone, float volumeLevel, int soundEnabled, boolean isTv, int sdCardAvailable, boolean isSideloadEnabled, String gaid, String amazonAdvertisingId, Long sit, Long oit, Long ort, Long obt) {
            return new VungleExt(isGooglePlayServicesAvailable, appSetId, appSetIdScope, batteryLevel, batteryState, batterySaverEnabled, connectionType, connectionTypeDetail, locale, language, timeZone, volumeLevel, soundEnabled, isTv, sdCardAvailable, isSideloadEnabled, gaid, amazonAdvertisingId, sit, oit, ort, obt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VungleExt)) {
                return false;
            }
            VungleExt vungleExt = (VungleExt) other;
            return this.isGooglePlayServicesAvailable == vungleExt.isGooglePlayServicesAvailable && Intrinsics.areEqual(this.appSetId, vungleExt.appSetId) && Intrinsics.areEqual(this.appSetIdScope, vungleExt.appSetIdScope) && Intrinsics.areEqual((Object) Float.valueOf(this.batteryLevel), (Object) Float.valueOf(vungleExt.batteryLevel)) && Intrinsics.areEqual(this.batteryState, vungleExt.batteryState) && this.batterySaverEnabled == vungleExt.batterySaverEnabled && Intrinsics.areEqual(this.connectionType, vungleExt.connectionType) && Intrinsics.areEqual(this.connectionTypeDetail, vungleExt.connectionTypeDetail) && Intrinsics.areEqual(this.locale, vungleExt.locale) && Intrinsics.areEqual(this.language, vungleExt.language) && Intrinsics.areEqual(this.timeZone, vungleExt.timeZone) && Intrinsics.areEqual((Object) Float.valueOf(this.volumeLevel), (Object) Float.valueOf(vungleExt.volumeLevel)) && this.soundEnabled == vungleExt.soundEnabled && this.isTv == vungleExt.isTv && this.sdCardAvailable == vungleExt.sdCardAvailable && this.isSideloadEnabled == vungleExt.isSideloadEnabled && Intrinsics.areEqual(this.gaid, vungleExt.gaid) && Intrinsics.areEqual(this.amazonAdvertisingId, vungleExt.amazonAdvertisingId) && Intrinsics.areEqual(this.sit, vungleExt.sit) && Intrinsics.areEqual(this.oit, vungleExt.oit) && Intrinsics.areEqual(this.ort, vungleExt.ort) && Intrinsics.areEqual(this.obt, vungleExt.obt);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v44 */
        /* JADX WARN: Type inference failed for: r0v45 */
        /* JADX WARN: Type inference failed for: r2v32, types: [boolean] */
        public int hashCode() {
            boolean z = this.isGooglePlayServicesAvailable;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            String str = this.appSetId;
            int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.appSetIdScope;
            int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Float.hashCode(this.batteryLevel)) * 31;
            String str2 = this.batteryState;
            int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.batterySaverEnabled)) * 31;
            String str3 = this.connectionType;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.connectionTypeDetail;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.locale;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.language;
            int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.timeZone;
            int hashCode8 = (((((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Float.hashCode(this.volumeLevel)) * 31) + Integer.hashCode(this.soundEnabled)) * 31;
            ?? r2 = this.isTv;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int hashCode9 = (((hashCode8 + i2) * 31) + Integer.hashCode(this.sdCardAvailable)) * 31;
            boolean z2 = this.isSideloadEnabled;
            int i3 = (hashCode9 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
            String str8 = this.gaid;
            int hashCode10 = (i3 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.amazonAdvertisingId;
            int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Long l = this.sit;
            int hashCode12 = (hashCode11 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.oit;
            int hashCode13 = (hashCode12 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Long l3 = this.ort;
            int hashCode14 = (hashCode13 + (l3 == null ? 0 : l3.hashCode())) * 31;
            Long l4 = this.obt;
            return hashCode14 + (l4 != null ? l4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("VungleExt(isGooglePlayServicesAvailable=");
            sb.append(this.isGooglePlayServicesAvailable).append(", appSetId=").append(this.appSetId).append(", appSetIdScope=").append(this.appSetIdScope).append(", batteryLevel=").append(this.batteryLevel).append(", batteryState=").append(this.batteryState).append(", batterySaverEnabled=").append(this.batterySaverEnabled).append(", connectionType=").append(this.connectionType).append(", connectionTypeDetail=").append(this.connectionTypeDetail).append(", locale=").append(this.locale).append(", language=").append(this.language).append(", timeZone=").append(this.timeZone).append(", volumeLevel=");
            sb.append(this.volumeLevel).append(", soundEnabled=").append(this.soundEnabled).append(", isTv=").append(this.isTv).append(", sdCardAvailable=").append(this.sdCardAvailable).append(", isSideloadEnabled=").append(this.isSideloadEnabled).append(", gaid=").append(this.gaid).append(", amazonAdvertisingId=").append(this.amazonAdvertisingId).append(", sit=").append(this.sit).append(", oit=").append(this.oit).append(", ort=").append(this.ort).append(", obt=").append(this.obt).append(')');
            return sb.toString();
        }

        /* compiled from: DeviceNode.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/model/DeviceNode$VungleExt$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<VungleExt> serializer() {
                return DeviceNode$VungleExt$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ VungleExt(int i, @SerialName("is_google_play_services_available") boolean z, @SerialName("app_set_id") String str, @SerialName("app_set_id_scope") Integer num, @SerialName("battery_level") float f, @SerialName("battery_state") String str2, @SerialName("battery_saver_enabled") int i2, @SerialName("connection_type") String str3, @SerialName("connection_type_detail") String str4, @SerialName("locale") String str5, @SerialName("language") String str6, @SerialName("time_zone") String str7, @SerialName("volume_level") float f2, @SerialName("sound_enabled") int i3, @SerialName("is_tv") boolean z2, @SerialName("sd_card_available") int i4, @SerialName("is_sideload_enabled") boolean z3, @SerialName("gaid") String str8, @SerialName("amazon_advertising_id") String str9, @SerialName("sit") Long l, @SerialName("oit") Long l2, @SerialName("ort") Long l3, @SerialName("obt") Long l4, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.isGooglePlayServicesAvailable = false;
            } else {
                this.isGooglePlayServicesAvailable = z;
            }
            if ((i & 2) == 0) {
                this.appSetId = null;
            } else {
                this.appSetId = str;
            }
            if ((i & 4) == 0) {
                this.appSetIdScope = null;
            } else {
                this.appSetIdScope = num;
            }
            if ((i & 8) == 0) {
                this.batteryLevel = 0.0f;
            } else {
                this.batteryLevel = f;
            }
            if ((i & 16) == 0) {
                this.batteryState = null;
            } else {
                this.batteryState = str2;
            }
            if ((i & 32) == 0) {
                this.batterySaverEnabled = 0;
            } else {
                this.batterySaverEnabled = i2;
            }
            if ((i & 64) == 0) {
                this.connectionType = null;
            } else {
                this.connectionType = str3;
            }
            if ((i & 128) == 0) {
                this.connectionTypeDetail = null;
            } else {
                this.connectionTypeDetail = str4;
            }
            if ((i & 256) == 0) {
                this.locale = null;
            } else {
                this.locale = str5;
            }
            if ((i & 512) == 0) {
                this.language = null;
            } else {
                this.language = str6;
            }
            if ((i & 1024) == 0) {
                this.timeZone = null;
            } else {
                this.timeZone = str7;
            }
            if ((i & 2048) == 0) {
                this.volumeLevel = 0.0f;
            } else {
                this.volumeLevel = f2;
            }
            if ((i & 4096) == 0) {
                this.soundEnabled = 1;
            } else {
                this.soundEnabled = i3;
            }
            if ((i & 8192) == 0) {
                this.isTv = false;
            } else {
                this.isTv = z2;
            }
            if ((i & 16384) == 0) {
                this.sdCardAvailable = 1;
            } else {
                this.sdCardAvailable = i4;
            }
            if ((32768 & i) == 0) {
                this.isSideloadEnabled = false;
            } else {
                this.isSideloadEnabled = z3;
            }
            if ((65536 & i) == 0) {
                this.gaid = null;
            } else {
                this.gaid = str8;
            }
            if ((131072 & i) == 0) {
                this.amazonAdvertisingId = null;
            } else {
                this.amazonAdvertisingId = str9;
            }
            if ((262144 & i) == 0) {
                this.sit = null;
            } else {
                this.sit = l;
            }
            if ((524288 & i) == 0) {
                this.oit = null;
            } else {
                this.oit = l2;
            }
            if ((1048576 & i) == 0) {
                this.ort = null;
            } else {
                this.ort = l3;
            }
            if ((i & 2097152) == 0) {
                this.obt = null;
            } else {
                this.obt = l4;
            }
        }

        public VungleExt(boolean z, String str, Integer num, float f, String str2, int i, String str3, String str4, String str5, String str6, String str7, float f2, int i2, boolean z2, int i3, boolean z3, String str8, String str9, Long l, Long l2, Long l3, Long l4) {
            this.isGooglePlayServicesAvailable = z;
            this.appSetId = str;
            this.appSetIdScope = num;
            this.batteryLevel = f;
            this.batteryState = str2;
            this.batterySaverEnabled = i;
            this.connectionType = str3;
            this.connectionTypeDetail = str4;
            this.locale = str5;
            this.language = str6;
            this.timeZone = str7;
            this.volumeLevel = f2;
            this.soundEnabled = i2;
            this.isTv = z2;
            this.sdCardAvailable = i3;
            this.isSideloadEnabled = z3;
            this.gaid = str8;
            this.amazonAdvertisingId = str9;
            this.sit = l;
            this.oit = l2;
            this.ort = l3;
            this.obt = l4;
        }

        @JvmStatic
        public static final void write$Self(VungleExt self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.isGooglePlayServicesAvailable) {
                output.encodeBooleanElement(serialDesc, 0, self.isGooglePlayServicesAvailable);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.appSetId != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.appSetId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appSetIdScope != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.appSetIdScope);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual((Object) Float.valueOf(self.batteryLevel), (Object) Float.valueOf(0.0f))) {
                output.encodeFloatElement(serialDesc, 3, self.batteryLevel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.batteryState != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.batteryState);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.batterySaverEnabled != 0) {
                output.encodeIntElement(serialDesc, 5, self.batterySaverEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.connectionType != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.connectionType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.connectionTypeDetail != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.connectionTypeDetail);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.locale != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.locale);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.language != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.language);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.timeZone != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.timeZone);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || !Intrinsics.areEqual((Object) Float.valueOf(self.volumeLevel), (Object) Float.valueOf(0.0f))) {
                output.encodeFloatElement(serialDesc, 11, self.volumeLevel);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.soundEnabled != 1) {
                output.encodeIntElement(serialDesc, 12, self.soundEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.isTv) {
                output.encodeBooleanElement(serialDesc, 13, self.isTv);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.sdCardAvailable != 1) {
                output.encodeIntElement(serialDesc, 14, self.sdCardAvailable);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.isSideloadEnabled) {
                output.encodeBooleanElement(serialDesc, 15, self.isSideloadEnabled);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.gaid != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.gaid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.amazonAdvertisingId != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.amazonAdvertisingId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.sit != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, LongSerializer.INSTANCE, self.sit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.oit != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, LongSerializer.INSTANCE, self.oit);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.ort != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, LongSerializer.INSTANCE, self.ort);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 21) && self.obt == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 21, LongSerializer.INSTANCE, self.obt);
        }

        public /* synthetic */ VungleExt(boolean z, String str, Integer num, float f, String str2, int i, String str3, String str4, String str5, String str6, String str7, float f2, int i2, boolean z2, int i3, boolean z3, String str8, String str9, Long l, Long l2, Long l3, Long l4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : num, (i4 & 8) != 0 ? 0.0f : f, (i4 & 16) != 0 ? null : str2, (i4 & 32) != 0 ? 0 : i, (i4 & 64) != 0 ? null : str3, (i4 & 128) != 0 ? null : str4, (i4 & 256) != 0 ? null : str5, (i4 & 512) != 0 ? null : str6, (i4 & 1024) != 0 ? null : str7, (i4 & 2048) == 0 ? f2 : 0.0f, (i4 & 4096) != 0 ? 1 : i2, (i4 & 8192) != 0 ? false : z2, (i4 & 16384) == 0 ? i3 : 1, (32768 & i4) != 0 ? false : z3, (i4 & 65536) != 0 ? null : str8, (i4 & 131072) != 0 ? null : str9, (i4 & 262144) != 0 ? null : l, (i4 & 524288) != 0 ? null : l2, (i4 & 1048576) != 0 ? null : l3, (i4 & 2097152) != 0 ? null : l4);
        }

        public final boolean isGooglePlayServicesAvailable() {
            return this.isGooglePlayServicesAvailable;
        }

        public final void setGooglePlayServicesAvailable(boolean z) {
            this.isGooglePlayServicesAvailable = z;
        }

        public final String getAppSetId() {
            return this.appSetId;
        }

        public final void setAppSetId(String str) {
            this.appSetId = str;
        }

        public final Integer getAppSetIdScope() {
            return this.appSetIdScope;
        }

        public final void setAppSetIdScope(Integer num) {
            this.appSetIdScope = num;
        }

        public final float getBatteryLevel() {
            return this.batteryLevel;
        }

        public final void setBatteryLevel(float f) {
            this.batteryLevel = f;
        }

        public final String getBatteryState() {
            return this.batteryState;
        }

        public final void setBatteryState(String str) {
            this.batteryState = str;
        }

        public final int getBatterySaverEnabled() {
            return this.batterySaverEnabled;
        }

        public final void setBatterySaverEnabled(int i) {
            this.batterySaverEnabled = i;
        }

        public final String getConnectionType() {
            return this.connectionType;
        }

        public final void setConnectionType(String str) {
            this.connectionType = str;
        }

        public final String getConnectionTypeDetail() {
            return this.connectionTypeDetail;
        }

        public final void setConnectionTypeDetail(String str) {
            this.connectionTypeDetail = str;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final void setLocale(String str) {
            this.locale = str;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final void setLanguage(String str) {
            this.language = str;
        }

        public final String getTimeZone() {
            return this.timeZone;
        }

        public final void setTimeZone(String str) {
            this.timeZone = str;
        }

        public final float getVolumeLevel() {
            return this.volumeLevel;
        }

        public final void setVolumeLevel(float f) {
            this.volumeLevel = f;
        }

        public final int getSoundEnabled() {
            return this.soundEnabled;
        }

        public final void setSoundEnabled(int i) {
            this.soundEnabled = i;
        }

        public final boolean isTv() {
            return this.isTv;
        }

        public final void setTv(boolean z) {
            this.isTv = z;
        }

        public final int getSdCardAvailable() {
            return this.sdCardAvailable;
        }

        public final void setSdCardAvailable(int i) {
            this.sdCardAvailable = i;
        }

        public final boolean isSideloadEnabled() {
            return this.isSideloadEnabled;
        }

        public final void setSideloadEnabled(boolean z) {
            this.isSideloadEnabled = z;
        }

        public final String getGaid() {
            return this.gaid;
        }

        public final void setGaid(String str) {
            this.gaid = str;
        }

        public final String getAmazonAdvertisingId() {
            return this.amazonAdvertisingId;
        }

        public final void setAmazonAdvertisingId(String str) {
            this.amazonAdvertisingId = str;
        }

        public final Long getSit() {
            return this.sit;
        }

        public final void setSit(Long l) {
            this.sit = l;
        }

        public final Long getOit() {
            return this.oit;
        }

        public final void setOit(Long l) {
            this.oit = l;
        }

        public final Long getOrt() {
            return this.ort;
        }

        public final void setOrt(Long l) {
            this.ort = l;
        }

        public final Long getObt() {
            return this.obt;
        }

        public final void setObt(Long l) {
            this.obt = l;
        }
    }
}
