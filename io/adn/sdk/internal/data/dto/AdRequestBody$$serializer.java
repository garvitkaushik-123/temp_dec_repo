package io.adn.sdk.internal.data.dto;

import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdRequestBody.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/adn/sdk/internal/data/dto/AdRequestBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/adn/sdk/internal/data/dto/AdRequestBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes7.dex */
public /* synthetic */ class AdRequestBody$$serializer implements GeneratedSerializer<AdRequestBody> {
    public static final int $stable;
    public static final AdRequestBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private AdRequestBody$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdRequestBody$$serializer adRequestBody$$serializer = new AdRequestBody$$serializer();
        INSTANCE = adRequestBody$$serializer;
        $stable = 8;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.adn.sdk.internal.data.dto.AdRequestBody", adRequestBody$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(MBridgeConstans.DYNAMIC_VIEW_WX_APP, false);
        pluginGeneratedSerialDescriptor.addElement(C3040d4.h.G, false);
        pluginGeneratedSerialDescriptor.addElement("regs", false);
        pluginGeneratedSerialDescriptor.addElement("imp", false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.SOURCE_USER_TYPE, false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = AdRequestBody.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, AppInfoDto$$serializer.INSTANCE, DeviceInfoDto$$serializer.INSTANCE, RegsDto$$serializer.INSTANCE, kSerializerArr[4], UserDto$$serializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final AdRequestBody deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        List list;
        UserDto userDto;
        DeviceInfoDto deviceInfoDto;
        RegsDto regsDto;
        String str;
        AppInfoDto appInfoDto;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = AdRequestBody.$childSerializers;
        String str2 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            AppInfoDto appInfoDto2 = (AppInfoDto) beginStructure.decodeSerializableElement(serialDescriptor, 1, AppInfoDto$$serializer.INSTANCE, null);
            DeviceInfoDto deviceInfoDto2 = (DeviceInfoDto) beginStructure.decodeSerializableElement(serialDescriptor, 2, DeviceInfoDto$$serializer.INSTANCE, null);
            RegsDto regsDto2 = (RegsDto) beginStructure.decodeSerializableElement(serialDescriptor, 3, RegsDto$$serializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            str = decodeStringElement;
            userDto = (UserDto) beginStructure.decodeSerializableElement(serialDescriptor, 5, UserDto$$serializer.INSTANCE, null);
            regsDto = regsDto2;
            deviceInfoDto = deviceInfoDto2;
            i = 63;
            appInfoDto = appInfoDto2;
        } else {
            boolean z = true;
            int i2 = 0;
            AppInfoDto appInfoDto3 = null;
            DeviceInfoDto deviceInfoDto3 = null;
            RegsDto regsDto3 = null;
            List list2 = null;
            UserDto userDto2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        appInfoDto3 = (AppInfoDto) beginStructure.decodeSerializableElement(serialDescriptor, 1, AppInfoDto$$serializer.INSTANCE, appInfoDto3);
                        i2 |= 2;
                        break;
                    case 2:
                        deviceInfoDto3 = (DeviceInfoDto) beginStructure.decodeSerializableElement(serialDescriptor, 2, DeviceInfoDto$$serializer.INSTANCE, deviceInfoDto3);
                        i2 |= 4;
                        break;
                    case 3:
                        regsDto3 = (RegsDto) beginStructure.decodeSerializableElement(serialDescriptor, 3, RegsDto$$serializer.INSTANCE, regsDto3);
                        i2 |= 8;
                        break;
                    case 4:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list2);
                        i2 |= 16;
                        break;
                    case 5:
                        userDto2 = (UserDto) beginStructure.decodeSerializableElement(serialDescriptor, 5, UserDto$$serializer.INSTANCE, userDto2);
                        i2 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list2;
            userDto = userDto2;
            deviceInfoDto = deviceInfoDto3;
            regsDto = regsDto3;
            str = str2;
            appInfoDto = appInfoDto3;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdRequestBody(i, str, appInfoDto, deviceInfoDto, regsDto, list, userDto, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, AdRequestBody value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdRequestBody.write$Self$adn_sdk_release(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
