package io.bidmachine;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.adcom.ConnectionType;
import com.explorestack.protobuf.adcom.Context;
import com.explorestack.protobuf.adcom.DeviceType;
import com.explorestack.protobuf.adcom.OS;
import io.bidmachine.core.TimeManager;
import io.bidmachine.core.Utils;
import io.bidmachine.models.DataRestrictions;
import io.bidmachine.protobuf.RequestTokenPayload;
import io.bidmachine.protobuf.sdk.Device;
import io.bidmachine.utils.BluetoothUtils;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.ProtoUtils;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes7.dex */
final class DeviceParams {
    private final DeviceConnectionParams deviceConnectionParams;

    public DeviceParams(DeviceConnectionParams deviceConnectionParams) {
        this.deviceConnectionParams = deviceConnectionParams;
    }

    void build(Context context, final RequestTokenPayload.Builder requestTokenPayloadBuilder, DataRestrictions dataRestrictions) {
        Device.Builder createDeviceBuilder = createDeviceBuilder(context, dataRestrictions);
        Objects.requireNonNull(requestTokenPayloadBuilder);
        Utils.ifNotNull(createDeviceBuilder, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda14
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                RequestTokenPayload.Builder.this.setDeviceData((Device.Builder) obj);
            }
        });
    }

    void build(Context context, Context.Builder contextBuilder, TargetingParams targetingParams, TargetingParams defaultTargetingParams, DataRestrictions dataRestrictions, ConnectionType connectionType) {
        Context.Device.Builder createDeviceContextBuilder = createDeviceContextBuilder(context, targetingParams, defaultTargetingParams, dataRestrictions, connectionType);
        if (createDeviceContextBuilder != null) {
            Device.Builder createDeviceBuilder = createDeviceBuilder(context, dataRestrictions);
            if (createDeviceBuilder != null) {
                createDeviceContextBuilder.addExtProto(Any.pack(createDeviceBuilder.build()));
            }
            contextBuilder.setDevice(createDeviceContextBuilder);
        }
    }

    private Device.Builder createDeviceBuilder(android.content.Context context, DataRestrictions dataRestrictions) {
        try {
            Device.Builder newBuilder = Device.newBuilder();
            fillDeviceBuilder(context, newBuilder, dataRestrictions);
            return newBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void fillDeviceBuilder(android.content.Context context, final Device.Builder builder, DataRestrictions dataRestrictions) {
        BidMachineImpl bidMachineImpl = BidMachineImpl.get();
        String ifv = bidMachineImpl.getIFV();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(ifv, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda19
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setIfv((String) obj);
            }
        });
        builder.setBmIfv(bidMachineImpl.obtainBMIFV(context));
        Set<String> inputLanguageSet = DeviceUtils.getInputLanguageSet(context);
        if (!inputLanguageSet.isEmpty()) {
            builder.addAllInputlanguage(inputLanguageSet);
        }
        Boolean isCharging = DeviceUtils.isCharging(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(isCharging, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda4
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setCharging(((Boolean) obj).booleanValue());
            }
        });
        Boolean isHeadsetConnected = BluetoothUtils.isHeadsetConnected(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(isHeadsetConnected, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda5
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setHeadset(((Boolean) obj).booleanValue());
            }
        });
        Double batteryLevel = DeviceUtils.getBatteryLevel(context);
        if (batteryLevel != null) {
            builder.setBatterylevel(batteryLevel.floatValue());
        }
        Boolean isBatterySaverEnabled = DeviceUtils.isBatterySaverEnabled(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(isBatterySaverEnabled, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda6
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setBatterysaver(((Boolean) obj).booleanValue());
            }
        });
        builder.setDarkmode(DeviceUtils.isDarkModeEnabled(context));
        Boolean isAirplaneModeOn = DeviceUtils.isAirplaneModeOn(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(isAirplaneModeOn, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda7
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setAirplane(((Boolean) obj).booleanValue());
            }
        });
        Boolean isDoNotDisturbOn = DeviceUtils.isDoNotDisturbOn(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(isDoNotDisturbOn, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda8
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setDnd(((Boolean) obj).booleanValue());
            }
        });
        if (dataRestrictions.canSendDeviceInfo()) {
            String deviceName = DeviceUtils.getDeviceName(context);
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(deviceName, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda9
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Device.Builder.this.setDevicename((String) obj);
                }
            });
            this.deviceConnectionParams.build(context, builder, DeviceUtils.getConnectionType(context));
        }
        Double screenBrightnessRatio = DeviceUtils.getScreenBrightnessRatio(context);
        if (screenBrightnessRatio != null) {
            builder.setScreenbright(screenBrightnessRatio.floatValue());
        }
        builder.setLastbootup(SystemClock.elapsedRealtime());
        Set<String> connectedHeadsets = BluetoothUtils.getConnectedHeadsets(context);
        if (connectedHeadsets != null && !connectedHeadsets.isEmpty()) {
            String next = connectedHeadsets.iterator().next();
            Objects.requireNonNull(builder);
            Utils.ifNotNull(next, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda10
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Device.Builder.this.setHeadsetname((String) obj);
                }
            });
        }
        builder.setApilevel(Build.VERSION.SDK_INT);
        builder.setTime(TimeManager.currentTimeMillis());
        String timezoneId = TimeManager.getTimezoneId();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(timezoneId, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda12
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setTimezone((String) obj);
            }
        });
        DeviceInfo obtain = DeviceInfo.obtain(context);
        if (obtain.getAvailableDiskSpaceInMB() != null) {
            builder.setDiskspace(r0.intValue());
        }
        if (obtain.getTotalDiskSpaceInMB() != null) {
            builder.setTotaldisk(r0.intValue());
        }
        builder.setJailbreak(obtain.isDeviceRooted());
        Boolean isRingMuted = obtain.getAudio().isRingMuted(context);
        Objects.requireNonNull(builder);
        Utils.ifNotNull(isRingMuted, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda13
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setRingmute(((Boolean) obj).booleanValue());
            }
        });
        Float volumeLevel = obtain.getAudio().getVolumeLevel(context);
        if (volumeLevel != null) {
            builder.setAudioContext(Context.Device.AudioContext.newBuilder().setVolumelevel(volumeLevel.floatValue()).build());
        }
        obtain.updateHwInfo(context);
        Long totalMemBytes = obtain.getRam().getTotalMemBytes();
        Objects.requireNonNull(builder);
        Utils.ifNotNull(totalMemBytes, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda20
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setTotalmem(((Long) obj).longValue());
            }
        });
        Long freeMemBytes = obtain.getRam().getFreeMemBytes();
        Objects.requireNonNull(builder);
        Utils.ifNotNull(freeMemBytes, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda21
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setFreemem(((Long) obj).longValue());
            }
        });
        String name = obtain.getCpu().getName();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(name, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda22
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setCpuname((String) obj);
            }
        });
        String vendor = obtain.getCpu().getVendor();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(vendor, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setCpuvendor((String) obj);
            }
        });
        String name2 = obtain.getGpu().getName();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(name2, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda2
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setGpuname((String) obj);
            }
        });
        String vendor2 = obtain.getGpu().getVendor();
        Objects.requireNonNull(builder);
        Utils.ifNotEmpty(vendor2, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda3
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                Device.Builder.this.setGpuvendor((String) obj);
            }
        });
    }

    private Context.Device.Builder createDeviceContextBuilder(android.content.Context context, TargetingParams targetingParams, TargetingParams defaultTargetingParams, DataRestrictions dataRestrictions, ConnectionType connectionType) {
        try {
            Context.Device.Builder newBuilder = Context.Device.newBuilder();
            fillDeviceContextBuilder(context, newBuilder, targetingParams, defaultTargetingParams, dataRestrictions, connectionType);
            return newBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void fillDeviceContextBuilder(android.content.Context context, final Context.Device.Builder builder, TargetingParams targetingParams, TargetingParams defaultTargetingParams, DataRestrictions dataRestrictions, ConnectionType connectionType) {
        DeviceType deviceType;
        DeviceInfo obtain = DeviceInfo.obtain(context);
        if (obtain.isTablet) {
            deviceType = DeviceType.DEVICE_TYPE_TABLET;
        } else {
            deviceType = DeviceType.DEVICE_TYPE_PHONE_DEVICE;
        }
        builder.setType(deviceType);
        builder.setOs(OS.OS_ANDROID);
        builder.setOsv(DeviceUtils.getOsVersion());
        builder.setPxratio(obtain.screenDensity);
        builder.setPpi(obtain.screenDpi);
        Point screenSize = Utils.getScreenSize(context);
        builder.setW(screenSize.x);
        builder.setH(screenSize.y);
        builder.setIfa(AdvertisingDataManager.getAdvertisingId(context, !dataRestrictions.canSendIfa()));
        builder.setLmt(AdvertisingDataManager.isLimitAdTrackingEnabled());
        if (dataRestrictions.canSendDeviceInfo()) {
            if (connectionType == null) {
                connectionType = DeviceUtils.getConnectionType(context);
            }
            builder.setContype(connectionType);
            builder.setMake(DeviceUtils.getManufacturer());
            String userAgent = UserAgentManager.getUserAgent(context);
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(userAgent, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda0
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Context.Device.Builder.this.setUa((String) obj);
                }
            });
            String str = obtain.model;
            Objects.requireNonNull(builder);
            Utils.ifNotNull(str, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda11
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Context.Device.Builder.this.setModel((String) obj);
                }
            });
            String hwv = obtain.getHWV();
            Objects.requireNonNull(builder);
            Utils.ifNotNull(hwv, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda15
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Context.Device.Builder.this.setHwv((String) obj);
                }
            });
            String language = Locale.getDefault().getLanguage();
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(language, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda16
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Context.Device.Builder.this.setLang((String) obj);
                }
            });
            String str2 = obtain.phoneMCCMNC;
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(str2, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda17
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Context.Device.Builder.this.setMccmnc((String) obj);
                }
            });
            String str3 = obtain.phoneCarrier;
            Objects.requireNonNull(builder);
            Utils.ifNotEmpty(str3, new Executable() { // from class: io.bidmachine.DeviceParams$$ExternalSyntheticLambda18
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Context.Device.Builder.this.setCarrier((String) obj);
                }
            });
            this.deviceConnectionParams.build(context, builder, connectionType);
        }
        if (dataRestrictions.canSendGeoPosition()) {
            builder.setGeo(ProtoUtils.createGeoBuilderWithLocation(context, targetingParams.getDeviceLocation(), defaultTargetingParams.getDeviceLocation(), true));
        }
    }
}
