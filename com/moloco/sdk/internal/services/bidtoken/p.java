package com.moloco.sdk.internal.services.bidtoken;

import com.google.protobuf.ByteString;
import com.moloco.sdk.BidToken;
import com.moloco.sdk.internal.services.A;
import com.moloco.sdk.internal.services.AbstractC3439c;
import com.moloco.sdk.internal.services.E;
import com.moloco.sdk.internal.services.F;
import com.moloco.sdk.internal.services.H;
import java.util.Date;
import java.util.TimeZone;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class p implements o {
    public static final int d = 0;
    public final com.moloco.sdk.internal.services.y b;
    public final F c;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5643a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[H.values().length];
            try {
                iArr[H.f5615a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[H.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[H.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f5643a = iArr;
            int[] iArr2 = new int[com.moloco.sdk.internal.services.z.values().length];
            try {
                iArr2[com.moloco.sdk.internal.services.z.f5732a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[com.moloco.sdk.internal.services.z.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[com.moloco.sdk.internal.services.z.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    public p(com.moloco.sdk.internal.services.y deviceInfoService, F screenInfoService) {
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(screenInfoService, "screenInfoService");
        this.b = deviceInfoService;
        this.c = screenInfoService;
    }

    public final long a(long j) {
        return j * 1000000;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidTokenComponents b(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BidToken.ClientBidTokenComponents parseFrom = BidToken.ClientBidTokenComponents.parseFrom(payload);
        Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(...)");
        return parseFrom;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public byte[] a(byte[] bidTokenComponents, byte[] secret) {
        Intrinsics.checkNotNullParameter(bidTokenComponents, "bidTokenComponents");
        Intrinsics.checkNotNullParameter(secret, "secret");
        BidToken.ClientBidToken.Builder newBuilder = BidToken.ClientBidToken.newBuilder();
        newBuilder.setEs(ByteString.copyFrom(secret));
        newBuilder.setPayload(ByteString.copyFrom(bidTokenComponents));
        byte[] byteArray = newBuilder.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidTokenComponents a(com.moloco.sdk.internal.services.bidtoken.providers.k clientSignals, f bidTokenConfig) {
        BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus batteryStatus;
        BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType connectionType;
        Intrinsics.checkNotNullParameter(clientSignals, "clientSignals");
        Intrinsics.checkNotNullParameter(bidTokenConfig, "bidTokenConfig");
        com.moloco.sdk.internal.services.x b = this.b.b();
        E a2 = this.c.a();
        BidToken.ClientBidTokenComponents.Builder newBuilder = BidToken.ClientBidTokenComponents.newBuilder();
        BidToken.ClientBidTokenComponents.SdkInfo.Builder newBuilder2 = BidToken.ClientBidTokenComponents.SdkInfo.newBuilder();
        newBuilder2.setInitialized(clientSignals.v());
        newBuilder.setInfo(newBuilder2.build());
        BidToken.ClientBidTokenComponents.MemoryInfo.Builder newBuilder3 = BidToken.ClientBidTokenComponents.MemoryInfo.newBuilder();
        Boolean d2 = clientSignals.s().d();
        if (d2 != null) {
            newBuilder3.setLowMem(d2.booleanValue());
        }
        Long e = clientSignals.s().e();
        if (e != null) {
            newBuilder3.setLowMemThresholdBytes(e.longValue());
        }
        Long f = clientSignals.s().f();
        if (f != null) {
            newBuilder3.setTotalMemBytes(f.longValue());
        }
        newBuilder.setMemoryInfo(newBuilder3.build());
        BidToken.ClientBidTokenComponents.DirInfo.Builder newBuilder4 = BidToken.ClientBidTokenComponents.DirInfo.newBuilder();
        Long b2 = clientSignals.n().b();
        if (b2 != null) {
            newBuilder4.setDsizeBytes(b2.longValue());
        }
        newBuilder.setDirInfo(newBuilder4.build());
        BidToken.ClientBidTokenComponents.NetworkInfo.Builder newBuilder5 = BidToken.ClientBidTokenComponents.NetworkInfo.newBuilder();
        if (clientSignals.t().e() != null) {
            newBuilder5.setMcc(clientSignals.t().e().intValue());
        }
        Integer f2 = clientSignals.t().f();
        if (f2 != null) {
            newBuilder5.setMnc(f2.intValue());
        }
        Boolean g = clientSignals.t().g();
        if (g != null) {
            newBuilder5.setRestricted(g.booleanValue());
        }
        com.moloco.sdk.internal.services.A h = clientSignals.t().h();
        if (h != null) {
            if (h instanceof A.a) {
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.CELLULAR;
            } else if (Intrinsics.areEqual(h, A.b.b)) {
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.NO_NETWORK;
            } else {
                if (!Intrinsics.areEqual(h, A.c.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                connectionType = BidToken.ClientBidTokenComponents.NetworkInfo.ConnectionType.WIFI;
            }
            newBuilder5.setType(connectionType);
        }
        newBuilder.setNetworkInfo(newBuilder5.build());
        BidToken.ClientBidTokenComponents.BatteryInfo.Builder newBuilder6 = BidToken.ClientBidTokenComponents.BatteryInfo.newBuilder();
        Integer e2 = clientSignals.p().e();
        if (e2 != null) {
            newBuilder6.setMaxBatteryLevel(e2.intValue());
        }
        Integer d3 = clientSignals.p().d();
        if (d3 != null) {
            int intValue = d3.intValue();
            if (intValue == 2) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.CHARGING;
            } else if (intValue == 3) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.DISCHARGING;
            } else if (intValue == 4) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.NOT_CHARGING;
            } else if (intValue != 5) {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.UNKNOWN;
            } else {
                batteryStatus = BidToken.ClientBidTokenComponents.BatteryInfo.BatteryStatus.FULL;
            }
            newBuilder6.setBatteryStatus(batteryStatus);
        }
        Boolean f3 = clientSignals.p().f();
        if (f3 != null) {
            newBuilder6.setLowPowMode(f3.booleanValue());
        }
        newBuilder.setBatteryInfo(newBuilder6.build());
        BidToken.ClientBidTokenComponents.AdvertisingInfo.Builder newBuilder7 = BidToken.ClientBidTokenComponents.AdvertisingInfo.newBuilder();
        AbstractC3439c m = clientSignals.m();
        if (m instanceof AbstractC3439c.a) {
            newBuilder7.setDnt(false);
            newBuilder7.setId(((AbstractC3439c.a) m).b());
        } else if (Intrinsics.areEqual(m, AbstractC3439c.b.b)) {
            newBuilder7.setDnt(true);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        newBuilder.setAdInfo(newBuilder7.build());
        BidToken.ClientBidTokenComponents.Privacy.Builder newBuilder8 = BidToken.ClientBidTokenComponents.Privacy.newBuilder();
        Boolean isAgeRestrictedUser = clientSignals.u().getIsAgeRestrictedUser();
        if (isAgeRestrictedUser != null) {
            newBuilder8.setCoppa(isAgeRestrictedUser.booleanValue());
        }
        Boolean isUserConsent = clientSignals.u().getIsUserConsent();
        if (isUserConsent != null) {
            newBuilder8.setGdpr(isUserConsent.booleanValue());
        }
        Boolean isDoNotSell = clientSignals.u().getIsDoNotSell();
        if (isDoNotSell != null) {
            newBuilder8.setCcpa(isDoNotSell.booleanValue());
        }
        String tCFConsent = clientSignals.u().getTCFConsent();
        if (tCFConsent != null) {
            newBuilder8.setTcfConsentString(tCFConsent);
        }
        newBuilder8.setUsPrivacy(clientSignals.u().get_usPrivacy());
        newBuilder.setPrivacy(newBuilder8.build());
        BidToken.ClientBidTokenComponents.Device.Builder newBuilder9 = BidToken.ClientBidTokenComponents.Device.newBuilder();
        newBuilder9.setLanguage(b.s());
        newBuilder9.setOsv(b.x());
        newBuilder9.setMake(b.t());
        newBuilder9.setModel(b.v());
        newBuilder9.setHwv(b.r());
        newBuilder9.setCarrier(b.u());
        newBuilder9.setDevicetype(b.z() ? 5 : 1);
        newBuilder9.setJs(1);
        BidToken.ClientBidTokenComponents.Geo.Builder newBuilder10 = BidToken.ClientBidTokenComponents.Geo.newBuilder();
        newBuilder10.setUtcoffset(TimeZone.getDefault().getOffset(new Date().getTime()) / 60000);
        newBuilder9.setGeo(newBuilder10.build());
        newBuilder9.setW(a2.n());
        newBuilder9.setH(a2.l());
        newBuilder9.setPxratio(a2.i());
        newBuilder9.setPpi(a2.j());
        newBuilder9.setOs(b.w());
        if (bidTokenConfig.b()) {
            newBuilder9.setDbt(a(b.p()));
        }
        H f4 = clientSignals.q().f();
        if (f4 != null) {
            newBuilder9.setOrtn(a(f4));
        }
        Boolean a3 = this.b.a();
        if (a3 != null) {
            newBuilder9.setHasGy(a3.booleanValue());
        }
        String d4 = clientSignals.q().d();
        if (d4 != null) {
            newBuilder9.setKbLoc(d4);
        }
        String e3 = clientSignals.q().e();
        if (e3 != null) {
            newBuilder9.setLocale(e3);
        }
        newBuilder9.setXdpi(a2.o());
        newBuilder9.setYdpi(a2.p());
        newBuilder9.setHardware(b.q());
        newBuilder9.setBrand(b.o());
        newBuilder.setDevice(newBuilder9.build());
        BidToken.ClientBidTokenComponents.AudioInfo.Builder newBuilder11 = BidToken.ClientBidTokenComponents.AudioInfo.newBuilder();
        com.moloco.sdk.internal.services.z d5 = clientSignals.o().d();
        if (d5 != null) {
            newBuilder11.setMuteSwitch(a(d5));
        }
        Integer c = clientSignals.o().c();
        if (c != null) {
            newBuilder11.setVol(c.intValue());
        }
        newBuilder.setAudioInfo(newBuilder11.build());
        BidToken.ClientBidTokenComponents.AccessibilityInfo.Builder newBuilder12 = BidToken.ClientBidTokenComponents.AccessibilityInfo.newBuilder();
        Float g2 = clientSignals.l().g();
        if (g2 != null) {
            newBuilder12.setFontScale(g2.floatValue());
        }
        Boolean f5 = clientSignals.l().f();
        if (f5 != null) {
            newBuilder12.setAccessibilityLargePointerIcon(f5.booleanValue());
        }
        Boolean e4 = clientSignals.l().e();
        if (e4 != null) {
            newBuilder12.setAccessibilityCaptioningEnabled(e4.booleanValue());
        }
        Boolean h2 = clientSignals.l().h();
        if (h2 != null) {
            newBuilder12.setReduceBrightColorsActivated(h2.booleanValue());
        }
        newBuilder.setAccessibilityInfo(newBuilder12.build());
        if (clientSignals.r().q()) {
            BidToken.ClientBidTokenComponents.ImpLvlRevData.Builder newBuilder13 = BidToken.ClientBidTokenComponents.ImpLvlRevData.newBuilder();
            newBuilder13.setSessionId(clientSignals.r().o());
            newBuilder13.setLastImpTs(clientSignals.r().k());
            newBuilder13.setSessionStartTs(clientSignals.r().p());
            BidToken.ClientBidTokenComponents.ImpLvlRevData.ImpCounts.Builder newBuilder14 = BidToken.ClientBidTokenComponents.ImpLvlRevData.ImpCounts.newBuilder();
            newBuilder14.setBanner(clientSignals.r().i());
            newBuilder14.setMrec(clientSignals.r().l());
            newBuilder14.setNative(clientSignals.r().m());
            newBuilder14.setInterstitial(clientSignals.r().j());
            newBuilder14.setRewarded(clientSignals.r().n());
            newBuilder13.setImpCounts(newBuilder14.build());
            newBuilder.setImpLvlRevData(newBuilder13.build());
        }
        BidToken.ClientBidTokenComponents build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.o
    public BidToken.ClientBidToken a(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        BidToken.ClientBidToken parseFrom = BidToken.ClientBidToken.parseFrom(payload);
        Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(...)");
        return parseFrom;
    }

    public final BidToken.ClientBidTokenComponents.Device.Orientation a(H h) {
        int i = a.f5643a[h.ordinal()];
        if (i == 1) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.UNKNOWN;
        }
        if (i == 2) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.PORTRAIT;
        }
        if (i == 3) {
            return BidToken.ClientBidTokenComponents.Device.Orientation.LANDSCAPE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState a(com.moloco.sdk.internal.services.z zVar) {
        int i = a.b[zVar.ordinal()];
        if (i == 1) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.SILENT;
        }
        if (i == 2) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.VIBRATE;
        }
        if (i == 3) {
            return BidToken.ClientBidTokenComponents.AudioInfo.MuteSwitchState.NORMAL;
        }
        throw new NoWhenBranchMatchedException();
    }
}
