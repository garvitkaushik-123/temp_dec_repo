package io.adn.sdk.internal.data.dto;

import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdRequestBody.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 72\u00020\u0001:\u000267B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010B]\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003JK\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÇ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010,\u001a\u00020\u0012H×\u0001J\t\u0010-\u001a\u00020\u0003H×\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00068"}, d2 = {"Lio/adn/sdk/internal/data/dto/AdRequestBody;", "", "id", "", MBridgeConstans.DYNAMIC_VIEW_WX_APP, "Lio/adn/sdk/internal/data/dto/AppInfoDto;", C3040d4.h.G, "Lio/adn/sdk/internal/data/dto/DeviceInfoDto;", "regs", "Lio/adn/sdk/internal/data/dto/RegsDto;", "imp", "", "Lio/adn/sdk/internal/data/dto/ImpressionDto;", AnalyticsConstants.SOURCE_USER_TYPE, "Lio/adn/sdk/internal/data/dto/UserDto;", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/data/dto/AppInfoDto;Lio/adn/sdk/internal/data/dto/DeviceInfoDto;Lio/adn/sdk/internal/data/dto/RegsDto;Ljava/util/List;Lio/adn/sdk/internal/data/dto/UserDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lio/adn/sdk/internal/data/dto/AppInfoDto;Lio/adn/sdk/internal/data/dto/DeviceInfoDto;Lio/adn/sdk/internal/data/dto/RegsDto;Ljava/util/List;Lio/adn/sdk/internal/data/dto/UserDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getApp", "()Lio/adn/sdk/internal/data/dto/AppInfoDto;", "getDevice", "()Lio/adn/sdk/internal/data/dto/DeviceInfoDto;", "getRegs", "()Lio/adn/sdk/internal/data/dto/RegsDto;", "getImp", "()Ljava/util/List;", "getUser", "()Lio/adn/sdk/internal/data/dto/UserDto;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class AdRequestBody {
    private final AppInfoDto app;
    private final DeviceInfoDto device;
    private final String id;
    private final List<ImpressionDto> imp;
    private final RegsDto regs;
    private final UserDto user;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, new ArrayListSerializer(ImpressionDto$$serializer.INSTANCE), null};

    public static /* synthetic */ AdRequestBody copy$default(AdRequestBody adRequestBody, String str, AppInfoDto appInfoDto, DeviceInfoDto deviceInfoDto, RegsDto regsDto, List list, UserDto userDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adRequestBody.id;
        }
        if ((i & 2) != 0) {
            appInfoDto = adRequestBody.app;
        }
        if ((i & 4) != 0) {
            deviceInfoDto = adRequestBody.device;
        }
        if ((i & 8) != 0) {
            regsDto = adRequestBody.regs;
        }
        if ((i & 16) != 0) {
            list = adRequestBody.imp;
        }
        if ((i & 32) != 0) {
            userDto = adRequestBody.user;
        }
        List list2 = list;
        UserDto userDto2 = userDto;
        return adRequestBody.copy(str, appInfoDto, deviceInfoDto, regsDto, list2, userDto2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final AppInfoDto getApp() {
        return this.app;
    }

    /* renamed from: component3, reason: from getter */
    public final DeviceInfoDto getDevice() {
        return this.device;
    }

    /* renamed from: component4, reason: from getter */
    public final RegsDto getRegs() {
        return this.regs;
    }

    public final List<ImpressionDto> component5() {
        return this.imp;
    }

    /* renamed from: component6, reason: from getter */
    public final UserDto getUser() {
        return this.user;
    }

    public final AdRequestBody copy(String id, AppInfoDto app, DeviceInfoDto device, RegsDto regs, List<ImpressionDto> imp, UserDto user) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(regs, "regs");
        Intrinsics.checkNotNullParameter(imp, "imp");
        Intrinsics.checkNotNullParameter(user, "user");
        return new AdRequestBody(id, app, device, regs, imp, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdRequestBody)) {
            return false;
        }
        AdRequestBody adRequestBody = (AdRequestBody) other;
        return Intrinsics.areEqual(this.id, adRequestBody.id) && Intrinsics.areEqual(this.app, adRequestBody.app) && Intrinsics.areEqual(this.device, adRequestBody.device) && Intrinsics.areEqual(this.regs, adRequestBody.regs) && Intrinsics.areEqual(this.imp, adRequestBody.imp) && Intrinsics.areEqual(this.user, adRequestBody.user);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.app.hashCode()) * 31) + this.device.hashCode()) * 31) + this.regs.hashCode()) * 31) + this.imp.hashCode()) * 31) + this.user.hashCode();
    }

    public String toString() {
        return "AdRequestBody(id=" + this.id + ", app=" + this.app + ", device=" + this.device + ", regs=" + this.regs + ", imp=" + this.imp + ", user=" + this.user + ')';
    }

    /* compiled from: AdRequestBody.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/AdRequestBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/AdRequestBody;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AdRequestBody> serializer() {
            return AdRequestBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdRequestBody(int i, String str, AppInfoDto appInfoDto, DeviceInfoDto deviceInfoDto, RegsDto regsDto, List list, UserDto userDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, AdRequestBody$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.app = appInfoDto;
        this.device = deviceInfoDto;
        this.regs = regsDto;
        this.imp = list;
        this.user = userDto;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(AdRequestBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeSerializableElement(serialDesc, 1, AppInfoDto$$serializer.INSTANCE, self.app);
        output.encodeSerializableElement(serialDesc, 2, DeviceInfoDto$$serializer.INSTANCE, self.device);
        output.encodeSerializableElement(serialDesc, 3, RegsDto$$serializer.INSTANCE, self.regs);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.imp);
        output.encodeSerializableElement(serialDesc, 5, UserDto$$serializer.INSTANCE, self.user);
    }

    public AdRequestBody(String id, AppInfoDto app, DeviceInfoDto device, RegsDto regs, List<ImpressionDto> imp, UserDto user) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(regs, "regs");
        Intrinsics.checkNotNullParameter(imp, "imp");
        Intrinsics.checkNotNullParameter(user, "user");
        this.id = id;
        this.app = app;
        this.device = device;
        this.regs = regs;
        this.imp = imp;
        this.user = user;
    }

    public final String getId() {
        return this.id;
    }

    public final AppInfoDto getApp() {
        return this.app;
    }

    public final DeviceInfoDto getDevice() {
        return this.device;
    }

    public final RegsDto getRegs() {
        return this.regs;
    }

    public final List<ImpressionDto> getImp() {
        return this.imp;
    }

    public final UserDto getUser() {
        return this.user;
    }
}
