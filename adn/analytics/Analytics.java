package adn.analytics;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class Analytics {

    public interface AdInfoOrBuilder extends MessageLiteOrBuilder {
        String getAdNetwork();

        ByteString getAdNetworkBytes();

        double getCpm();

        String getCreaId();

        ByteString getCreaIdBytes();

        String getDate();

        ByteString getDateBytes();

        int getDuration();

        int getIsClicked();

        int getIsShown();

        int getIsSkipped();

        String getPlacement();

        ByteString getPlacementBytes();

        String getPromotedAppId();

        ByteString getPromotedAppIdBytes();

        String getReviewCreaId();

        ByteString getReviewCreaIdBytes();

        boolean hasAdNetwork();

        boolean hasCpm();

        boolean hasCreaId();

        boolean hasDate();

        boolean hasDuration();

        boolean hasIsClicked();

        boolean hasIsShown();

        boolean hasIsSkipped();

        boolean hasPlacement();

        boolean hasPromotedAppId();

        boolean hasReviewCreaId();
    }

    public interface AnalyticsDataOrBuilder extends MessageLiteOrBuilder {
        int getAdsConsentGiven();

        int getAirplaneModeEnable();

        int getAppOpenCountSinceInstall();

        String getAppVersion();

        ByteString getAppVersionBytes();

        String getAppsetId();

        ByteString getAppsetIdBytes();

        int getAppsetIdScope();

        String getAppstoreId();

        ByteString getAppstoreIdBytes();

        Attribution getAttribution();

        long getAvailableDiskSpace();

        int getBattCharge();

        int getBattery();

        int getBatterySaverEnable();

        int getBluetooth();

        long getBootTime();

        String getConnectivity();

        ByteString getConnectivityBytes();

        CountInfo getCountClick(int i);

        int getCountClickCount();

        List<CountInfo> getCountClickList();

        CountInfo getCountImp(int i);

        int getCountImpCount();

        List<CountInfo> getCountImpList();

        int getCountReq();

        CountInfo getCountWonReq(int i);

        int getCountWonReqCount();

        List<CountInfo> getCountWonReqList();

        int getDarkModeEnable();

        String getDate();

        ByteString getDateBytes();

        String getDeviceManufacturer();

        ByteString getDeviceManufacturerBytes();

        String getDeviceModel();

        ByteString getDeviceModelBytes();

        int getDoNotDist();

        int getDoNotSell();

        String getExtraSignals();

        ByteString getExtraSignalsBytes();

        AdInfo getFirstXSessionDesc(int i);

        int getFirstXSessionDescCount();

        List<AdInfo> getFirstXSessionDescList();

        int getFsClickCountSinceInstall();

        int getFsCountSinceInstall();

        int getFsLoadIndex();

        String getGaid();

        ByteString getGaidBytes();

        int getGameCount();

        int getGameCountSinceInstall();

        int getGameCountSuccess();

        int getGlobalTokenIndex();

        LastClick getHasLastClick();

        int getHasSkipPriorRv();

        int getHeadset();

        String getIdfa();

        String getIdfaAuthorizationStatus();

        ByteString getIdfaAuthorizationStatusBytes();

        ByteString getIdfaBytes();

        String getIdfv();

        ByteString getIdfvBytes();

        String getInstallDate();

        ByteString getInstallDateBytes();

        int getIsPremium();

        int getIsWalking();

        String getKeyboardLang(int i);

        ByteString getKeyboardLangBytes(int i);

        int getKeyboardLangCount();

        List<String> getKeyboardLangList();

        AdInfo getLastXSessionDesc(int i);

        int getLastXSessionDescCount();

        List<AdInfo> getLastXSessionDescList();

        int getLimitAdTracking();

        String getLocalDate();

        ByteString getLocalDateBytes();

        String getMmpId();

        ByteString getMmpIdBytes();

        String getOrientation();

        ByteString getOrientationBytes();

        PerformanceMetrics getPerfMetrics();

        int getPlayTime();

        String getPluginVersion();

        ByteString getPluginVersionBytes();

        int getPpi();

        String getPrevSessionStartDate();

        ByteString getPrevSessionStartDateBytes();

        AdInfo getPrevXSessionDesc(int i);

        int getPrevXSessionDescCount();

        List<AdInfo> getPrevXSessionDescList();

        Purchase getPurchaseSinceInstall(int i);

        int getPurchaseSinceInstallCount();

        List<Purchase> getPurchaseSinceInstallList();

        RevenueGeneration getRevGen();

        RevenueGeneration getRevGenSinceInstall();

        int getRvClickCountSinceInstall();

        int getRvCountSinceInstall();

        int getRvLoadIndex();

        String getSdkVersion();

        ByteString getSdkVersionBytes();

        int getSessionCountSinceInstall();

        String getSessionId();

        ByteString getSessionIdBytes();

        String getSessionStartDate();

        ByteString getSessionStartDateBytes();

        int getSoundEnable();

        int getTestMode();

        int getTokenIndex();

        long getTotalDiskSpace();

        int getTotalTime();

        String getUnityVersion();

        ByteString getUnityVersionBytes();

        String getUtcDate();

        ByteString getUtcDateBytes();

        String getVanFsImpressionId();

        ByteString getVanFsImpressionIdBytes();

        String getVanImpressionId();

        ByteString getVanImpressionIdBytes();

        String getVanRvImpressionId();

        ByteString getVanRvImpressionIdBytes();

        String getVanUserId();

        ByteString getVanUserIdBytes();

        String getVsauceVersion();

        ByteString getVsauceVersionBytes();

        boolean hasAirplaneModeEnable();

        boolean hasAppOpenCountSinceInstall();

        boolean hasAppsetId();

        boolean hasAppsetIdScope();

        boolean hasAppstoreId();

        boolean hasAttribution();

        boolean hasAvailableDiskSpace();

        boolean hasBattCharge();

        boolean hasBattery();

        boolean hasBatterySaverEnable();

        boolean hasBluetooth();

        boolean hasBootTime();

        boolean hasConnectivity();

        boolean hasCountReq();

        boolean hasDarkModeEnable();

        boolean hasDate();

        boolean hasDoNotDist();

        boolean hasDoNotSell();

        boolean hasExtraSignals();

        boolean hasFsClickCountSinceInstall();

        boolean hasFsCountSinceInstall();

        boolean hasFsLoadIndex();

        boolean hasGaid();

        boolean hasGameCount();

        boolean hasGameCountSinceInstall();

        boolean hasGameCountSuccess();

        boolean hasHasLastClick();

        boolean hasHasSkipPriorRv();

        boolean hasHeadset();

        boolean hasIdfa();

        boolean hasIdfaAuthorizationStatus();

        boolean hasIdfv();

        boolean hasInstallDate();

        boolean hasIsPremium();

        boolean hasIsWalking();

        boolean hasLimitAdTracking();

        boolean hasLocalDate();

        boolean hasMmpId();

        boolean hasPerfMetrics();

        boolean hasPlayTime();

        boolean hasPluginVersion();

        boolean hasPpi();

        boolean hasPrevSessionStartDate();

        boolean hasRevGen();

        boolean hasRevGenSinceInstall();

        boolean hasRvClickCountSinceInstall();

        boolean hasRvCountSinceInstall();

        boolean hasRvLoadIndex();

        boolean hasSessionCountSinceInstall();

        boolean hasSessionId();

        boolean hasSessionStartDate();

        boolean hasSoundEnable();

        boolean hasTotalDiskSpace();

        boolean hasTotalTime();

        boolean hasUnityVersion();

        boolean hasUtcDate();

        boolean hasVanFsImpressionId();

        boolean hasVanImpressionId();

        boolean hasVanRvImpressionId();

        boolean hasVanUserId();

        boolean hasVsauceVersion();
    }

    public interface AttributionOrBuilder extends MessageLiteOrBuilder {
        String getCampaign();

        ByteString getCampaignBytes();

        double getCostAmount();

        String getCostCurrency();

        ByteString getCostCurrencyBytes();

        String getCostType();

        ByteString getCostTypeBytes();

        String getNetwork();

        ByteString getNetworkBytes();

        boolean hasCampaign();

        boolean hasCostAmount();

        boolean hasCostCurrency();

        boolean hasCostType();

        boolean hasNetwork();
    }

    public interface CountInfoOrBuilder extends MessageLiteOrBuilder {
        String getAdNetwork();

        ByteString getAdNetworkBytes();

        int getCnt();

        String getCreaId();

        ByteString getCreaIdBytes();

        String getPlacement();

        ByteString getPlacementBytes();

        boolean hasAdNetwork();

        boolean hasCnt();

        boolean hasCreaId();

        boolean hasPlacement();
    }

    public interface LastClickOrBuilder extends MessageLiteOrBuilder {
        int getFs();

        int getRv();

        boolean hasFs();

        boolean hasRv();
    }

    public interface PerformanceMetricsOrBuilder extends MessageLiteOrBuilder {
        int getBadFrames();

        int getTerribleFrames();

        boolean hasBadFrames();

        boolean hasTerribleFrames();
    }

    public interface PurchaseOrBuilder extends MessageLiteOrBuilder {
        String getCurrency();

        ByteString getCurrencyBytes();

        String getId();

        ByteString getIdBytes();

        double getPrice();

        String getType();

        ByteString getTypeBytes();

        boolean hasCurrency();

        boolean hasId();

        boolean hasPrice();

        boolean hasType();
    }

    public interface RevenueGenerationOrBuilder extends MessageLiteOrBuilder {
        double getFs();

        double getRv();

        boolean hasFs();

        boolean hasRv();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private Analytics() {
    }

    public static final class PerformanceMetrics extends GeneratedMessageLite<PerformanceMetrics, Builder> implements PerformanceMetricsOrBuilder {
        public static final int BAD_FRAMES_FIELD_NUMBER = 1;
        private static final PerformanceMetrics DEFAULT_INSTANCE;
        private static volatile Parser<PerformanceMetrics> PARSER = null;
        public static final int TERRIBLE_FRAMES_FIELD_NUMBER = 2;
        private int badFrames_;
        private int bitField0_;
        private int terribleFrames_;

        private PerformanceMetrics() {
        }

        @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
        public boolean hasBadFrames() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
        public int getBadFrames() {
            return this.badFrames_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBadFrames(int i) {
            this.bitField0_ |= 1;
            this.badFrames_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBadFrames() {
            this.bitField0_ &= -2;
            this.badFrames_ = 0;
        }

        @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
        public boolean hasTerribleFrames() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
        public int getTerribleFrames() {
            return this.terribleFrames_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTerribleFrames(int i) {
            this.bitField0_ |= 2;
            this.terribleFrames_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTerribleFrames() {
            this.bitField0_ &= -3;
            this.terribleFrames_ = 0;
        }

        public static PerformanceMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static PerformanceMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static PerformanceMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PerformanceMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PerformanceMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PerformanceMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PerformanceMetrics parseFrom(InputStream inputStream) throws IOException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PerformanceMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PerformanceMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PerformanceMetrics) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PerformanceMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PerformanceMetrics) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PerformanceMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PerformanceMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PerformanceMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PerformanceMetrics performanceMetrics) {
            return DEFAULT_INSTANCE.createBuilder(performanceMetrics);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PerformanceMetrics, Builder> implements PerformanceMetricsOrBuilder {
            private Builder() {
                super(PerformanceMetrics.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
            public boolean hasBadFrames() {
                return ((PerformanceMetrics) this.instance).hasBadFrames();
            }

            @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
            public int getBadFrames() {
                return ((PerformanceMetrics) this.instance).getBadFrames();
            }

            public Builder setBadFrames(int i) {
                copyOnWrite();
                ((PerformanceMetrics) this.instance).setBadFrames(i);
                return this;
            }

            public Builder clearBadFrames() {
                copyOnWrite();
                ((PerformanceMetrics) this.instance).clearBadFrames();
                return this;
            }

            @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
            public boolean hasTerribleFrames() {
                return ((PerformanceMetrics) this.instance).hasTerribleFrames();
            }

            @Override // adn.analytics.Analytics.PerformanceMetricsOrBuilder
            public int getTerribleFrames() {
                return ((PerformanceMetrics) this.instance).getTerribleFrames();
            }

            public Builder setTerribleFrames(int i) {
                copyOnWrite();
                ((PerformanceMetrics) this.instance).setTerribleFrames(i);
                return this;
            }

            public Builder clearTerribleFrames() {
                copyOnWrite();
                ((PerformanceMetrics) this.instance).clearTerribleFrames();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new PerformanceMetrics();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "badFrames_", "terribleFrames_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PerformanceMetrics> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (PerformanceMetrics.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PerformanceMetrics performanceMetrics = new PerformanceMetrics();
            DEFAULT_INSTANCE = performanceMetrics;
            GeneratedMessageLite.registerDefaultInstance(PerformanceMetrics.class, performanceMetrics);
        }

        public static PerformanceMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PerformanceMetrics> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: adn.analytics.Analytics$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static final class Attribution extends GeneratedMessageLite<Attribution, Builder> implements AttributionOrBuilder {
        public static final int CAMPAIGN_FIELD_NUMBER = 3;
        public static final int COST_AMOUNT_FIELD_NUMBER = 2;
        public static final int COST_CURRENCY_FIELD_NUMBER = 5;
        public static final int COST_TYPE_FIELD_NUMBER = 4;
        private static final Attribution DEFAULT_INSTANCE;
        public static final int NETWORK_FIELD_NUMBER = 1;
        private static volatile Parser<Attribution> PARSER;
        private int bitField0_;
        private double costAmount_;
        private String network_ = "";
        private String campaign_ = "";
        private String costType_ = "";
        private String costCurrency_ = "";

        private Attribution() {
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public boolean hasNetwork() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public String getNetwork() {
            return this.network_;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public ByteString getNetworkBytes() {
            return ByteString.copyFromUtf8(this.network_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetwork(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.network_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetwork() {
            this.bitField0_ &= -2;
            this.network_ = getDefaultInstance().getNetwork();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.network_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public boolean hasCostAmount() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public double getCostAmount() {
            return this.costAmount_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCostAmount(double d) {
            this.bitField0_ |= 2;
            this.costAmount_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCostAmount() {
            this.bitField0_ &= -3;
            this.costAmount_ = 0.0d;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public boolean hasCampaign() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public String getCampaign() {
            return this.campaign_;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public ByteString getCampaignBytes() {
            return ByteString.copyFromUtf8(this.campaign_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaign(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.campaign_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCampaign() {
            this.bitField0_ &= -5;
            this.campaign_ = getDefaultInstance().getCampaign();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCampaignBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.campaign_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public boolean hasCostType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public String getCostType() {
            return this.costType_;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public ByteString getCostTypeBytes() {
            return ByteString.copyFromUtf8(this.costType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCostType(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.costType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCostType() {
            this.bitField0_ &= -9;
            this.costType_ = getDefaultInstance().getCostType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCostTypeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.costType_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public boolean hasCostCurrency() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public String getCostCurrency() {
            return this.costCurrency_;
        }

        @Override // adn.analytics.Analytics.AttributionOrBuilder
        public ByteString getCostCurrencyBytes() {
            return ByteString.copyFromUtf8(this.costCurrency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCostCurrency(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.costCurrency_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCostCurrency() {
            this.bitField0_ &= -17;
            this.costCurrency_ = getDefaultInstance().getCostCurrency();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCostCurrencyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.costCurrency_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        public static Attribution parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Attribution parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Attribution parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Attribution parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Attribution parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Attribution parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Attribution parseFrom(InputStream inputStream) throws IOException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Attribution parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Attribution parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Attribution) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Attribution parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Attribution) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Attribution parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Attribution parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Attribution) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Attribution attribution) {
            return DEFAULT_INSTANCE.createBuilder(attribution);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Attribution, Builder> implements AttributionOrBuilder {
            private Builder() {
                super(Attribution.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public boolean hasNetwork() {
                return ((Attribution) this.instance).hasNetwork();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public String getNetwork() {
                return ((Attribution) this.instance).getNetwork();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public ByteString getNetworkBytes() {
                return ((Attribution) this.instance).getNetworkBytes();
            }

            public Builder setNetwork(String str) {
                copyOnWrite();
                ((Attribution) this.instance).setNetwork(str);
                return this;
            }

            public Builder clearNetwork() {
                copyOnWrite();
                ((Attribution) this.instance).clearNetwork();
                return this;
            }

            public Builder setNetworkBytes(ByteString byteString) {
                copyOnWrite();
                ((Attribution) this.instance).setNetworkBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public boolean hasCostAmount() {
                return ((Attribution) this.instance).hasCostAmount();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public double getCostAmount() {
                return ((Attribution) this.instance).getCostAmount();
            }

            public Builder setCostAmount(double d) {
                copyOnWrite();
                ((Attribution) this.instance).setCostAmount(d);
                return this;
            }

            public Builder clearCostAmount() {
                copyOnWrite();
                ((Attribution) this.instance).clearCostAmount();
                return this;
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public boolean hasCampaign() {
                return ((Attribution) this.instance).hasCampaign();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public String getCampaign() {
                return ((Attribution) this.instance).getCampaign();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public ByteString getCampaignBytes() {
                return ((Attribution) this.instance).getCampaignBytes();
            }

            public Builder setCampaign(String str) {
                copyOnWrite();
                ((Attribution) this.instance).setCampaign(str);
                return this;
            }

            public Builder clearCampaign() {
                copyOnWrite();
                ((Attribution) this.instance).clearCampaign();
                return this;
            }

            public Builder setCampaignBytes(ByteString byteString) {
                copyOnWrite();
                ((Attribution) this.instance).setCampaignBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public boolean hasCostType() {
                return ((Attribution) this.instance).hasCostType();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public String getCostType() {
                return ((Attribution) this.instance).getCostType();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public ByteString getCostTypeBytes() {
                return ((Attribution) this.instance).getCostTypeBytes();
            }

            public Builder setCostType(String str) {
                copyOnWrite();
                ((Attribution) this.instance).setCostType(str);
                return this;
            }

            public Builder clearCostType() {
                copyOnWrite();
                ((Attribution) this.instance).clearCostType();
                return this;
            }

            public Builder setCostTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((Attribution) this.instance).setCostTypeBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public boolean hasCostCurrency() {
                return ((Attribution) this.instance).hasCostCurrency();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public String getCostCurrency() {
                return ((Attribution) this.instance).getCostCurrency();
            }

            @Override // adn.analytics.Analytics.AttributionOrBuilder
            public ByteString getCostCurrencyBytes() {
                return ((Attribution) this.instance).getCostCurrencyBytes();
            }

            public Builder setCostCurrency(String str) {
                copyOnWrite();
                ((Attribution) this.instance).setCostCurrency(str);
                return this;
            }

            public Builder clearCostCurrency() {
                copyOnWrite();
                ((Attribution) this.instance).clearCostCurrency();
                return this;
            }

            public Builder setCostCurrencyBytes(ByteString byteString) {
                copyOnWrite();
                ((Attribution) this.instance).setCostCurrencyBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Attribution();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ለ\u0000\u0002က\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004", new Object[]{"bitField0_", "network_", "costAmount_", "campaign_", "costType_", "costCurrency_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Attribution> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (Attribution.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Attribution attribution = new Attribution();
            DEFAULT_INSTANCE = attribution;
            GeneratedMessageLite.registerDefaultInstance(Attribution.class, attribution);
        }

        public static Attribution getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Attribution> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RevenueGeneration extends GeneratedMessageLite<RevenueGeneration, Builder> implements RevenueGenerationOrBuilder {
        private static final RevenueGeneration DEFAULT_INSTANCE;
        public static final int FS_FIELD_NUMBER = 1;
        private static volatile Parser<RevenueGeneration> PARSER = null;
        public static final int RV_FIELD_NUMBER = 2;
        private int bitField0_;
        private double fs_;
        private double rv_;

        private RevenueGeneration() {
        }

        @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
        public boolean hasFs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
        public double getFs() {
            return this.fs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFs(double d) {
            this.bitField0_ |= 1;
            this.fs_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFs() {
            this.bitField0_ &= -2;
            this.fs_ = 0.0d;
        }

        @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
        public boolean hasRv() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
        public double getRv() {
            return this.rv_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRv(double d) {
            this.bitField0_ |= 2;
            this.rv_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRv() {
            this.bitField0_ &= -3;
            this.rv_ = 0.0d;
        }

        public static RevenueGeneration parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RevenueGeneration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RevenueGeneration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RevenueGeneration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RevenueGeneration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RevenueGeneration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RevenueGeneration parseFrom(InputStream inputStream) throws IOException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RevenueGeneration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RevenueGeneration parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RevenueGeneration) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RevenueGeneration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RevenueGeneration) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RevenueGeneration parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RevenueGeneration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RevenueGeneration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RevenueGeneration revenueGeneration) {
            return DEFAULT_INSTANCE.createBuilder(revenueGeneration);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RevenueGeneration, Builder> implements RevenueGenerationOrBuilder {
            private Builder() {
                super(RevenueGeneration.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
            public boolean hasFs() {
                return ((RevenueGeneration) this.instance).hasFs();
            }

            @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
            public double getFs() {
                return ((RevenueGeneration) this.instance).getFs();
            }

            public Builder setFs(double d) {
                copyOnWrite();
                ((RevenueGeneration) this.instance).setFs(d);
                return this;
            }

            public Builder clearFs() {
                copyOnWrite();
                ((RevenueGeneration) this.instance).clearFs();
                return this;
            }

            @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
            public boolean hasRv() {
                return ((RevenueGeneration) this.instance).hasRv();
            }

            @Override // adn.analytics.Analytics.RevenueGenerationOrBuilder
            public double getRv() {
                return ((RevenueGeneration) this.instance).getRv();
            }

            public Builder setRv(double d) {
                copyOnWrite();
                ((RevenueGeneration) this.instance).setRv(d);
                return this;
            }

            public Builder clearRv() {
                copyOnWrite();
                ((RevenueGeneration) this.instance).clearRv();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new RevenueGeneration();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001က\u0000\u0002က\u0001", new Object[]{"bitField0_", "fs_", "rv_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RevenueGeneration> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (RevenueGeneration.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RevenueGeneration revenueGeneration = new RevenueGeneration();
            DEFAULT_INSTANCE = revenueGeneration;
            GeneratedMessageLite.registerDefaultInstance(RevenueGeneration.class, revenueGeneration);
        }

        public static RevenueGeneration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RevenueGeneration> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class LastClick extends GeneratedMessageLite<LastClick, Builder> implements LastClickOrBuilder {
        private static final LastClick DEFAULT_INSTANCE;
        public static final int FS_FIELD_NUMBER = 1;
        private static volatile Parser<LastClick> PARSER = null;
        public static final int RV_FIELD_NUMBER = 2;
        private int bitField0_;
        private int fs_;
        private int rv_;

        private LastClick() {
        }

        @Override // adn.analytics.Analytics.LastClickOrBuilder
        public boolean hasFs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.LastClickOrBuilder
        public int getFs() {
            return this.fs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFs(int i) {
            this.bitField0_ |= 1;
            this.fs_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFs() {
            this.bitField0_ &= -2;
            this.fs_ = 0;
        }

        @Override // adn.analytics.Analytics.LastClickOrBuilder
        public boolean hasRv() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.LastClickOrBuilder
        public int getRv() {
            return this.rv_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRv(int i) {
            this.bitField0_ |= 2;
            this.rv_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRv() {
            this.bitField0_ &= -3;
            this.rv_ = 0;
        }

        public static LastClick parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static LastClick parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LastClick parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LastClick parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LastClick parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LastClick parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LastClick parseFrom(InputStream inputStream) throws IOException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LastClick parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LastClick parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LastClick) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LastClick parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LastClick) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LastClick parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LastClick parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LastClick) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LastClick lastClick) {
            return DEFAULT_INSTANCE.createBuilder(lastClick);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LastClick, Builder> implements LastClickOrBuilder {
            private Builder() {
                super(LastClick.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.LastClickOrBuilder
            public boolean hasFs() {
                return ((LastClick) this.instance).hasFs();
            }

            @Override // adn.analytics.Analytics.LastClickOrBuilder
            public int getFs() {
                return ((LastClick) this.instance).getFs();
            }

            public Builder setFs(int i) {
                copyOnWrite();
                ((LastClick) this.instance).setFs(i);
                return this;
            }

            public Builder clearFs() {
                copyOnWrite();
                ((LastClick) this.instance).clearFs();
                return this;
            }

            @Override // adn.analytics.Analytics.LastClickOrBuilder
            public boolean hasRv() {
                return ((LastClick) this.instance).hasRv();
            }

            @Override // adn.analytics.Analytics.LastClickOrBuilder
            public int getRv() {
                return ((LastClick) this.instance).getRv();
            }

            public Builder setRv(int i) {
                copyOnWrite();
                ((LastClick) this.instance).setRv(i);
                return this;
            }

            public Builder clearRv() {
                copyOnWrite();
                ((LastClick) this.instance).clearRv();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LastClick();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "fs_", "rv_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LastClick> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (LastClick.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            LastClick lastClick = new LastClick();
            DEFAULT_INSTANCE = lastClick;
            GeneratedMessageLite.registerDefaultInstance(LastClick.class, lastClick);
        }

        public static LastClick getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LastClick> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AdInfo extends GeneratedMessageLite<AdInfo, Builder> implements AdInfoOrBuilder {
        public static final int AD_NETWORK_FIELD_NUMBER = 3;
        public static final int CPM_FIELD_NUMBER = 4;
        public static final int CREA_ID_FIELD_NUMBER = 2;
        public static final int DATE_FIELD_NUMBER = 5;
        private static final AdInfo DEFAULT_INSTANCE;
        public static final int DURATION_FIELD_NUMBER = 6;
        public static final int IS_CLICKED_FIELD_NUMBER = 8;
        public static final int IS_SHOWN_FIELD_NUMBER = 7;
        public static final int IS_SKIPPED_FIELD_NUMBER = 9;
        private static volatile Parser<AdInfo> PARSER = null;
        public static final int PLACEMENT_FIELD_NUMBER = 1;
        public static final int PROMOTED_APP_ID_FIELD_NUMBER = 10;
        public static final int REVIEW_CREA_ID_FIELD_NUMBER = 11;
        private int bitField0_;
        private double cpm_;
        private int duration_;
        private int isClicked_;
        private int isShown_;
        private int isSkipped_;
        private String placement_ = "";
        private String creaId_ = "";
        private String adNetwork_ = "";
        private String date_ = "";
        private String promotedAppId_ = "";
        private String reviewCreaId_ = "";

        private AdInfo() {
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasPlacement() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public String getPlacement() {
            return this.placement_;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public ByteString getPlacementBytes() {
            return ByteString.copyFromUtf8(this.placement_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlacement(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.placement_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlacement() {
            this.bitField0_ &= -2;
            this.placement_ = getDefaultInstance().getPlacement();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlacementBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.placement_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasCreaId() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public String getCreaId() {
            return this.creaId_;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public ByteString getCreaIdBytes() {
            return ByteString.copyFromUtf8(this.creaId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreaId(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.creaId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreaId() {
            this.bitField0_ &= -3;
            this.creaId_ = getDefaultInstance().getCreaId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreaIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.creaId_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasAdNetwork() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public String getAdNetwork() {
            return this.adNetwork_;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public ByteString getAdNetworkBytes() {
            return ByteString.copyFromUtf8(this.adNetwork_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdNetwork(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.adNetwork_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdNetwork() {
            this.bitField0_ &= -5;
            this.adNetwork_ = getDefaultInstance().getAdNetwork();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdNetworkBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.adNetwork_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasCpm() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public double getCpm() {
            return this.cpm_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCpm(double d) {
            this.bitField0_ |= 8;
            this.cpm_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCpm() {
            this.bitField0_ &= -9;
            this.cpm_ = 0.0d;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasDate() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public String getDate() {
            return this.date_;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public ByteString getDateBytes() {
            return ByteString.copyFromUtf8(this.date_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDate(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.date_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDate() {
            this.bitField0_ &= -17;
            this.date_ = getDefaultInstance().getDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDateBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.date_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasDuration() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDuration(int i) {
            this.bitField0_ |= 32;
            this.duration_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDuration() {
            this.bitField0_ &= -33;
            this.duration_ = 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasIsShown() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public int getIsShown() {
            return this.isShown_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsShown(int i) {
            this.bitField0_ |= 64;
            this.isShown_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsShown() {
            this.bitField0_ &= -65;
            this.isShown_ = 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasIsClicked() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public int getIsClicked() {
            return this.isClicked_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsClicked(int i) {
            this.bitField0_ |= 128;
            this.isClicked_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsClicked() {
            this.bitField0_ &= -129;
            this.isClicked_ = 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasIsSkipped() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public int getIsSkipped() {
            return this.isSkipped_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsSkipped(int i) {
            this.bitField0_ |= 256;
            this.isSkipped_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsSkipped() {
            this.bitField0_ &= -257;
            this.isSkipped_ = 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasPromotedAppId() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public String getPromotedAppId() {
            return this.promotedAppId_;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public ByteString getPromotedAppIdBytes() {
            return ByteString.copyFromUtf8(this.promotedAppId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPromotedAppId(String str) {
            str.getClass();
            this.bitField0_ |= 512;
            this.promotedAppId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPromotedAppId() {
            this.bitField0_ &= -513;
            this.promotedAppId_ = getDefaultInstance().getPromotedAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPromotedAppIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.promotedAppId_ = byteString.toStringUtf8();
            this.bitField0_ |= 512;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public boolean hasReviewCreaId() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public String getReviewCreaId() {
            return this.reviewCreaId_;
        }

        @Override // adn.analytics.Analytics.AdInfoOrBuilder
        public ByteString getReviewCreaIdBytes() {
            return ByteString.copyFromUtf8(this.reviewCreaId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReviewCreaId(String str) {
            str.getClass();
            this.bitField0_ |= 1024;
            this.reviewCreaId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReviewCreaId() {
            this.bitField0_ &= -1025;
            this.reviewCreaId_ = getDefaultInstance().getReviewCreaId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReviewCreaIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.reviewCreaId_ = byteString.toStringUtf8();
            this.bitField0_ |= 1024;
        }

        public static AdInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AdInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AdInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AdInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AdInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AdInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AdInfo parseFrom(InputStream inputStream) throws IOException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AdInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AdInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AdInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AdInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AdInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AdInfo adInfo) {
            return DEFAULT_INSTANCE.createBuilder(adInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AdInfo, Builder> implements AdInfoOrBuilder {
            private Builder() {
                super(AdInfo.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasPlacement() {
                return ((AdInfo) this.instance).hasPlacement();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public String getPlacement() {
                return ((AdInfo) this.instance).getPlacement();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public ByteString getPlacementBytes() {
                return ((AdInfo) this.instance).getPlacementBytes();
            }

            public Builder setPlacement(String str) {
                copyOnWrite();
                ((AdInfo) this.instance).setPlacement(str);
                return this;
            }

            public Builder clearPlacement() {
                copyOnWrite();
                ((AdInfo) this.instance).clearPlacement();
                return this;
            }

            public Builder setPlacementBytes(ByteString byteString) {
                copyOnWrite();
                ((AdInfo) this.instance).setPlacementBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasCreaId() {
                return ((AdInfo) this.instance).hasCreaId();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public String getCreaId() {
                return ((AdInfo) this.instance).getCreaId();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public ByteString getCreaIdBytes() {
                return ((AdInfo) this.instance).getCreaIdBytes();
            }

            public Builder setCreaId(String str) {
                copyOnWrite();
                ((AdInfo) this.instance).setCreaId(str);
                return this;
            }

            public Builder clearCreaId() {
                copyOnWrite();
                ((AdInfo) this.instance).clearCreaId();
                return this;
            }

            public Builder setCreaIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AdInfo) this.instance).setCreaIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasAdNetwork() {
                return ((AdInfo) this.instance).hasAdNetwork();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public String getAdNetwork() {
                return ((AdInfo) this.instance).getAdNetwork();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public ByteString getAdNetworkBytes() {
                return ((AdInfo) this.instance).getAdNetworkBytes();
            }

            public Builder setAdNetwork(String str) {
                copyOnWrite();
                ((AdInfo) this.instance).setAdNetwork(str);
                return this;
            }

            public Builder clearAdNetwork() {
                copyOnWrite();
                ((AdInfo) this.instance).clearAdNetwork();
                return this;
            }

            public Builder setAdNetworkBytes(ByteString byteString) {
                copyOnWrite();
                ((AdInfo) this.instance).setAdNetworkBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasCpm() {
                return ((AdInfo) this.instance).hasCpm();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public double getCpm() {
                return ((AdInfo) this.instance).getCpm();
            }

            public Builder setCpm(double d) {
                copyOnWrite();
                ((AdInfo) this.instance).setCpm(d);
                return this;
            }

            public Builder clearCpm() {
                copyOnWrite();
                ((AdInfo) this.instance).clearCpm();
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasDate() {
                return ((AdInfo) this.instance).hasDate();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public String getDate() {
                return ((AdInfo) this.instance).getDate();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public ByteString getDateBytes() {
                return ((AdInfo) this.instance).getDateBytes();
            }

            public Builder setDate(String str) {
                copyOnWrite();
                ((AdInfo) this.instance).setDate(str);
                return this;
            }

            public Builder clearDate() {
                copyOnWrite();
                ((AdInfo) this.instance).clearDate();
                return this;
            }

            public Builder setDateBytes(ByteString byteString) {
                copyOnWrite();
                ((AdInfo) this.instance).setDateBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasDuration() {
                return ((AdInfo) this.instance).hasDuration();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public int getDuration() {
                return ((AdInfo) this.instance).getDuration();
            }

            public Builder setDuration(int i) {
                copyOnWrite();
                ((AdInfo) this.instance).setDuration(i);
                return this;
            }

            public Builder clearDuration() {
                copyOnWrite();
                ((AdInfo) this.instance).clearDuration();
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasIsShown() {
                return ((AdInfo) this.instance).hasIsShown();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public int getIsShown() {
                return ((AdInfo) this.instance).getIsShown();
            }

            public Builder setIsShown(int i) {
                copyOnWrite();
                ((AdInfo) this.instance).setIsShown(i);
                return this;
            }

            public Builder clearIsShown() {
                copyOnWrite();
                ((AdInfo) this.instance).clearIsShown();
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasIsClicked() {
                return ((AdInfo) this.instance).hasIsClicked();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public int getIsClicked() {
                return ((AdInfo) this.instance).getIsClicked();
            }

            public Builder setIsClicked(int i) {
                copyOnWrite();
                ((AdInfo) this.instance).setIsClicked(i);
                return this;
            }

            public Builder clearIsClicked() {
                copyOnWrite();
                ((AdInfo) this.instance).clearIsClicked();
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasIsSkipped() {
                return ((AdInfo) this.instance).hasIsSkipped();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public int getIsSkipped() {
                return ((AdInfo) this.instance).getIsSkipped();
            }

            public Builder setIsSkipped(int i) {
                copyOnWrite();
                ((AdInfo) this.instance).setIsSkipped(i);
                return this;
            }

            public Builder clearIsSkipped() {
                copyOnWrite();
                ((AdInfo) this.instance).clearIsSkipped();
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasPromotedAppId() {
                return ((AdInfo) this.instance).hasPromotedAppId();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public String getPromotedAppId() {
                return ((AdInfo) this.instance).getPromotedAppId();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public ByteString getPromotedAppIdBytes() {
                return ((AdInfo) this.instance).getPromotedAppIdBytes();
            }

            public Builder setPromotedAppId(String str) {
                copyOnWrite();
                ((AdInfo) this.instance).setPromotedAppId(str);
                return this;
            }

            public Builder clearPromotedAppId() {
                copyOnWrite();
                ((AdInfo) this.instance).clearPromotedAppId();
                return this;
            }

            public Builder setPromotedAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AdInfo) this.instance).setPromotedAppIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public boolean hasReviewCreaId() {
                return ((AdInfo) this.instance).hasReviewCreaId();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public String getReviewCreaId() {
                return ((AdInfo) this.instance).getReviewCreaId();
            }

            @Override // adn.analytics.Analytics.AdInfoOrBuilder
            public ByteString getReviewCreaIdBytes() {
                return ((AdInfo) this.instance).getReviewCreaIdBytes();
            }

            public Builder setReviewCreaId(String str) {
                copyOnWrite();
                ((AdInfo) this.instance).setReviewCreaId(str);
                return this;
            }

            public Builder clearReviewCreaId() {
                copyOnWrite();
                ((AdInfo) this.instance).clearReviewCreaId();
                return this;
            }

            public Builder setReviewCreaIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AdInfo) this.instance).setReviewCreaIdBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AdInfo();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004က\u0003\u0005ለ\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nለ\t\u000bለ\n", new Object[]{"bitField0_", "placement_", "creaId_", "adNetwork_", "cpm_", "date_", "duration_", "isShown_", "isClicked_", "isSkipped_", "promotedAppId_", "reviewCreaId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AdInfo> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (AdInfo.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AdInfo adInfo = new AdInfo();
            DEFAULT_INSTANCE = adInfo;
            GeneratedMessageLite.registerDefaultInstance(AdInfo.class, adInfo);
        }

        public static AdInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Purchase extends GeneratedMessageLite<Purchase, Builder> implements PurchaseOrBuilder {
        public static final int CURRENCY_FIELD_NUMBER = 4;
        private static final Purchase DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile Parser<Purchase> PARSER = null;
        public static final int PRICE_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 2;
        private int bitField0_;
        private double price_;
        private String id_ = "";
        private String type_ = "";
        private String currency_ = "";

        private Purchase() {
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public boolean hasId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public String getId() {
            return this.id_;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.id_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.bitField0_ &= -2;
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.id_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public String getType() {
            return this.type_;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.type_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -3;
            this.type_ = getDefaultInstance().getType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.type_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public boolean hasPrice() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public double getPrice() {
            return this.price_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrice(double d) {
            this.bitField0_ |= 4;
            this.price_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrice() {
            this.bitField0_ &= -5;
            this.price_ = 0.0d;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public boolean hasCurrency() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public String getCurrency() {
            return this.currency_;
        }

        @Override // adn.analytics.Analytics.PurchaseOrBuilder
        public ByteString getCurrencyBytes() {
            return ByteString.copyFromUtf8(this.currency_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrency(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.currency_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCurrency() {
            this.bitField0_ &= -9;
            this.currency_ = getDefaultInstance().getCurrency();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurrencyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.currency_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        public static Purchase parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Purchase parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Purchase parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Purchase parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Purchase parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Purchase parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Purchase parseFrom(InputStream inputStream) throws IOException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Purchase parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Purchase parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Purchase) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Purchase parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Purchase) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Purchase parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Purchase parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Purchase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Purchase purchase) {
            return DEFAULT_INSTANCE.createBuilder(purchase);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Purchase, Builder> implements PurchaseOrBuilder {
            private Builder() {
                super(Purchase.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public boolean hasId() {
                return ((Purchase) this.instance).hasId();
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public String getId() {
                return ((Purchase) this.instance).getId();
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public ByteString getIdBytes() {
                return ((Purchase) this.instance).getIdBytes();
            }

            public Builder setId(String str) {
                copyOnWrite();
                ((Purchase) this.instance).setId(str);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((Purchase) this.instance).clearId();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Purchase) this.instance).setIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public boolean hasType() {
                return ((Purchase) this.instance).hasType();
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public String getType() {
                return ((Purchase) this.instance).getType();
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public ByteString getTypeBytes() {
                return ((Purchase) this.instance).getTypeBytes();
            }

            public Builder setType(String str) {
                copyOnWrite();
                ((Purchase) this.instance).setType(str);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Purchase) this.instance).clearType();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((Purchase) this.instance).setTypeBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public boolean hasPrice() {
                return ((Purchase) this.instance).hasPrice();
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public double getPrice() {
                return ((Purchase) this.instance).getPrice();
            }

            public Builder setPrice(double d) {
                copyOnWrite();
                ((Purchase) this.instance).setPrice(d);
                return this;
            }

            public Builder clearPrice() {
                copyOnWrite();
                ((Purchase) this.instance).clearPrice();
                return this;
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public boolean hasCurrency() {
                return ((Purchase) this.instance).hasCurrency();
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public String getCurrency() {
                return ((Purchase) this.instance).getCurrency();
            }

            @Override // adn.analytics.Analytics.PurchaseOrBuilder
            public ByteString getCurrencyBytes() {
                return ((Purchase) this.instance).getCurrencyBytes();
            }

            public Builder setCurrency(String str) {
                copyOnWrite();
                ((Purchase) this.instance).setCurrency(str);
                return this;
            }

            public Builder clearCurrency() {
                copyOnWrite();
                ((Purchase) this.instance).clearCurrency();
                return this;
            }

            public Builder setCurrencyBytes(ByteString byteString) {
                copyOnWrite();
                ((Purchase) this.instance).setCurrencyBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Purchase();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003က\u0002\u0004ለ\u0003", new Object[]{"bitField0_", "id_", "type_", "price_", "currency_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Purchase> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (Purchase.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Purchase purchase = new Purchase();
            DEFAULT_INSTANCE = purchase;
            GeneratedMessageLite.registerDefaultInstance(Purchase.class, purchase);
        }

        public static Purchase getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Purchase> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class CountInfo extends GeneratedMessageLite<CountInfo, Builder> implements CountInfoOrBuilder {
        public static final int AD_NETWORK_FIELD_NUMBER = 6;
        public static final int CNT_FIELD_NUMBER = 2;
        public static final int CREA_ID_FIELD_NUMBER = 5;
        private static final CountInfo DEFAULT_INSTANCE;
        private static volatile Parser<CountInfo> PARSER = null;
        public static final int PLACEMENT_FIELD_NUMBER = 1;
        private int bitField0_;
        private int cnt_;
        private String placement_ = "";
        private String creaId_ = "";
        private String adNetwork_ = "";

        private CountInfo() {
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public boolean hasPlacement() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public String getPlacement() {
            return this.placement_;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public ByteString getPlacementBytes() {
            return ByteString.copyFromUtf8(this.placement_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlacement(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.placement_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlacement() {
            this.bitField0_ &= -2;
            this.placement_ = getDefaultInstance().getPlacement();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlacementBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.placement_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public boolean hasCnt() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public int getCnt() {
            return this.cnt_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCnt(int i) {
            this.bitField0_ |= 2;
            this.cnt_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCnt() {
            this.bitField0_ &= -3;
            this.cnt_ = 0;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public boolean hasCreaId() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public String getCreaId() {
            return this.creaId_;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public ByteString getCreaIdBytes() {
            return ByteString.copyFromUtf8(this.creaId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreaId(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.creaId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreaId() {
            this.bitField0_ &= -5;
            this.creaId_ = getDefaultInstance().getCreaId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreaIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.creaId_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public boolean hasAdNetwork() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public String getAdNetwork() {
            return this.adNetwork_;
        }

        @Override // adn.analytics.Analytics.CountInfoOrBuilder
        public ByteString getAdNetworkBytes() {
            return ByteString.copyFromUtf8(this.adNetwork_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdNetwork(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.adNetwork_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdNetwork() {
            this.bitField0_ &= -9;
            this.adNetwork_ = getDefaultInstance().getAdNetwork();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdNetworkBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.adNetwork_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        public static CountInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static CountInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CountInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CountInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CountInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CountInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CountInfo parseFrom(InputStream inputStream) throws IOException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CountInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CountInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CountInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CountInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CountInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CountInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CountInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CountInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(CountInfo countInfo) {
            return DEFAULT_INSTANCE.createBuilder(countInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CountInfo, Builder> implements CountInfoOrBuilder {
            private Builder() {
                super(CountInfo.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public boolean hasPlacement() {
                return ((CountInfo) this.instance).hasPlacement();
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public String getPlacement() {
                return ((CountInfo) this.instance).getPlacement();
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public ByteString getPlacementBytes() {
                return ((CountInfo) this.instance).getPlacementBytes();
            }

            public Builder setPlacement(String str) {
                copyOnWrite();
                ((CountInfo) this.instance).setPlacement(str);
                return this;
            }

            public Builder clearPlacement() {
                copyOnWrite();
                ((CountInfo) this.instance).clearPlacement();
                return this;
            }

            public Builder setPlacementBytes(ByteString byteString) {
                copyOnWrite();
                ((CountInfo) this.instance).setPlacementBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public boolean hasCnt() {
                return ((CountInfo) this.instance).hasCnt();
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public int getCnt() {
                return ((CountInfo) this.instance).getCnt();
            }

            public Builder setCnt(int i) {
                copyOnWrite();
                ((CountInfo) this.instance).setCnt(i);
                return this;
            }

            public Builder clearCnt() {
                copyOnWrite();
                ((CountInfo) this.instance).clearCnt();
                return this;
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public boolean hasCreaId() {
                return ((CountInfo) this.instance).hasCreaId();
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public String getCreaId() {
                return ((CountInfo) this.instance).getCreaId();
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public ByteString getCreaIdBytes() {
                return ((CountInfo) this.instance).getCreaIdBytes();
            }

            public Builder setCreaId(String str) {
                copyOnWrite();
                ((CountInfo) this.instance).setCreaId(str);
                return this;
            }

            public Builder clearCreaId() {
                copyOnWrite();
                ((CountInfo) this.instance).clearCreaId();
                return this;
            }

            public Builder setCreaIdBytes(ByteString byteString) {
                copyOnWrite();
                ((CountInfo) this.instance).setCreaIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public boolean hasAdNetwork() {
                return ((CountInfo) this.instance).hasAdNetwork();
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public String getAdNetwork() {
                return ((CountInfo) this.instance).getAdNetwork();
            }

            @Override // adn.analytics.Analytics.CountInfoOrBuilder
            public ByteString getAdNetworkBytes() {
                return ((CountInfo) this.instance).getAdNetworkBytes();
            }

            public Builder setAdNetwork(String str) {
                copyOnWrite();
                ((CountInfo) this.instance).setAdNetwork(str);
                return this;
            }

            public Builder clearAdNetwork() {
                copyOnWrite();
                ((CountInfo) this.instance).clearAdNetwork();
                return this;
            }

            public Builder setAdNetworkBytes(ByteString byteString) {
                copyOnWrite();
                ((CountInfo) this.instance).setAdNetworkBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CountInfo();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0000\u0000\u0001ለ\u0000\u0002င\u0001\u0005ለ\u0002\u0006ለ\u0003", new Object[]{"bitField0_", "placement_", "cnt_", "creaId_", "adNetwork_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CountInfo> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (CountInfo.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            CountInfo countInfo = new CountInfo();
            DEFAULT_INSTANCE = countInfo;
            GeneratedMessageLite.registerDefaultInstance(CountInfo.class, countInfo);
        }

        public static CountInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CountInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AnalyticsData extends GeneratedMessageLite<AnalyticsData, Builder> implements AnalyticsDataOrBuilder {
        public static final int ADS_CONSENT_GIVEN_FIELD_NUMBER = 34;
        public static final int AIRPLANE_MODE_ENABLE_FIELD_NUMBER = 38;
        public static final int APPSET_ID_FIELD_NUMBER = 47;
        public static final int APPSET_ID_SCOPE_FIELD_NUMBER = 78;
        public static final int APPSTORE_ID_FIELD_NUMBER = 71;
        public static final int APP_OPEN_COUNT_SINCE_INSTALL_FIELD_NUMBER = 6;
        public static final int APP_VERSION_FIELD_NUMBER = 54;
        public static final int ATTRIBUTION_FIELD_NUMBER = 16;
        public static final int AVAILABLE_DISK_SPACE_FIELD_NUMBER = 43;
        public static final int BATTERY_FIELD_NUMBER = 40;
        public static final int BATTERY_SAVER_ENABLE_FIELD_NUMBER = 41;
        public static final int BATT_CHARGE_FIELD_NUMBER = 42;
        public static final int BLUETOOTH_FIELD_NUMBER = 58;
        public static final int BOOT_TIME_FIELD_NUMBER = 80;
        public static final int CONNECTIVITY_FIELD_NUMBER = 39;
        public static final int COUNT_CLICK_FIELD_NUMBER = 76;
        public static final int COUNT_IMP_FIELD_NUMBER = 77;
        public static final int COUNT_REQ_FIELD_NUMBER = 28;
        public static final int COUNT_WON_REQ_FIELD_NUMBER = 75;
        public static final int DARK_MODE_ENABLE_FIELD_NUMBER = 59;
        public static final int DATE_FIELD_NUMBER = 68;
        private static final AnalyticsData DEFAULT_INSTANCE;
        public static final int DEVICE_MANUFACTURER_FIELD_NUMBER = 57;
        public static final int DEVICE_MODEL_FIELD_NUMBER = 56;
        public static final int DO_NOT_DIST_FIELD_NUMBER = 45;
        public static final int DO_NOT_SELL_FIELD_NUMBER = 66;
        public static final int EXTRA_SIGNALS_FIELD_NUMBER = 79;
        public static final int FIRST_X_SESSION_DESC_FIELD_NUMBER = 32;
        public static final int FS_CLICK_COUNT_SINCE_INSTALL_FIELD_NUMBER = 21;
        public static final int FS_COUNT_SINCE_INSTALL_FIELD_NUMBER = 19;
        public static final int FS_LOAD_INDEX_FIELD_NUMBER = 17;
        public static final int GAID_FIELD_NUMBER = 46;
        public static final int GAME_COUNT_FIELD_NUMBER = 11;
        public static final int GAME_COUNT_SINCE_INSTALL_FIELD_NUMBER = 10;
        public static final int GAME_COUNT_SUCCESS_FIELD_NUMBER = 13;
        public static final int GLOBAL_TOKEN_INDEX_FIELD_NUMBER = 49;
        public static final int HAS_LAST_CLICK_FIELD_NUMBER = 29;
        public static final int HAS_SKIP_PRIOR_RV_FIELD_NUMBER = 33;
        public static final int HEADSET_FIELD_NUMBER = 60;
        public static final int IDFA_AUTHORIZATION_STATUS_FIELD_NUMBER = 35;
        public static final int IDFA_FIELD_NUMBER = 70;
        public static final int IDFV_FIELD_NUMBER = 69;
        public static final int INSTALL_DATE_FIELD_NUMBER = 4;
        public static final int IS_PREMIUM_FIELD_NUMBER = 37;
        public static final int IS_WALKING_FIELD_NUMBER = 63;
        public static final int KEYBOARD_LANG_FIELD_NUMBER = 64;
        public static final int LAST_X_SESSION_DESC_FIELD_NUMBER = 30;
        public static final int LIMIT_AD_TRACKING_FIELD_NUMBER = 48;
        public static final int LOCAL_DATE_FIELD_NUMBER = 52;
        public static final int MMP_ID_FIELD_NUMBER = 9;
        public static final int ORIENTATION_FIELD_NUMBER = 65;
        private static volatile Parser<AnalyticsData> PARSER = null;
        public static final int PERF_METRICS_FIELD_NUMBER = 12;
        public static final int PLAY_TIME_FIELD_NUMBER = 14;
        public static final int PLUGIN_VERSION_FIELD_NUMBER = 74;
        public static final int PPI_FIELD_NUMBER = 62;
        public static final int PREV_SESSION_START_DATE_FIELD_NUMBER = 67;
        public static final int PREV_X_SESSION_DESC_FIELD_NUMBER = 31;
        public static final int PURCHASE_SINCE_INSTALL_FIELD_NUMBER = 36;
        public static final int REV_GEN_FIELD_NUMBER = 23;
        public static final int REV_GEN_SINCE_INSTALL_FIELD_NUMBER = 24;
        public static final int RV_CLICK_COUNT_SINCE_INSTALL_FIELD_NUMBER = 22;
        public static final int RV_COUNT_SINCE_INSTALL_FIELD_NUMBER = 20;
        public static final int RV_LOAD_INDEX_FIELD_NUMBER = 18;
        public static final int SDK_VERSION_FIELD_NUMBER = 53;
        public static final int SESSION_COUNT_SINCE_INSTALL_FIELD_NUMBER = 7;
        public static final int SESSION_ID_FIELD_NUMBER = 3;
        public static final int SESSION_START_DATE_FIELD_NUMBER = 5;
        public static final int SOUND_ENABLE_FIELD_NUMBER = 61;
        public static final int TEST_MODE_FIELD_NUMBER = 55;
        public static final int TOKEN_INDEX_FIELD_NUMBER = 50;
        public static final int TOTAL_DISK_SPACE_FIELD_NUMBER = 44;
        public static final int TOTAL_TIME_FIELD_NUMBER = 15;
        public static final int UNITY_VERSION_FIELD_NUMBER = 1;
        public static final int UTC_DATE_FIELD_NUMBER = 51;
        public static final int VAN_FS_IMPRESSION_ID_FIELD_NUMBER = 26;
        public static final int VAN_IMPRESSION_ID_FIELD_NUMBER = 25;
        public static final int VAN_RV_IMPRESSION_ID_FIELD_NUMBER = 27;
        public static final int VAN_USER_ID_FIELD_NUMBER = 8;
        public static final int VSAUCE_VERSION_FIELD_NUMBER = 2;
        private int adsConsentGiven_;
        private int airplaneModeEnable_;
        private int appOpenCountSinceInstall_;
        private int appsetIdScope_;
        private Attribution attribution_;
        private long availableDiskSpace_;
        private int battCharge_;
        private int batterySaverEnable_;
        private int battery_;
        private int bitField0_;
        private int bitField1_;
        private int bluetooth_;
        private long bootTime_;
        private int countReq_;
        private int darkModeEnable_;
        private int doNotDist_;
        private int doNotSell_;
        private int fsClickCountSinceInstall_;
        private int fsCountSinceInstall_;
        private int fsLoadIndex_;
        private int gameCountSinceInstall_;
        private int gameCountSuccess_;
        private int gameCount_;
        private int globalTokenIndex_;
        private LastClick hasLastClick_;
        private int hasSkipPriorRv_;
        private int headset_;
        private int isPremium_;
        private int isWalking_;
        private int limitAdTracking_;
        private PerformanceMetrics perfMetrics_;
        private int playTime_;
        private int ppi_;
        private RevenueGeneration revGenSinceInstall_;
        private RevenueGeneration revGen_;
        private int rvClickCountSinceInstall_;
        private int rvCountSinceInstall_;
        private int rvLoadIndex_;
        private int sessionCountSinceInstall_;
        private int soundEnable_;
        private int testMode_;
        private int tokenIndex_;
        private long totalDiskSpace_;
        private int totalTime_;
        private String unityVersion_ = "";
        private String vsauceVersion_ = "";
        private String sessionId_ = "";
        private String installDate_ = "";
        private String sessionStartDate_ = "";
        private String vanUserId_ = "";
        private String mmpId_ = "";
        private String vanImpressionId_ = "";
        private String vanFsImpressionId_ = "";
        private String vanRvImpressionId_ = "";
        private Internal.ProtobufList<AdInfo> lastXSessionDesc_ = emptyProtobufList();
        private Internal.ProtobufList<AdInfo> prevXSessionDesc_ = emptyProtobufList();
        private Internal.ProtobufList<AdInfo> firstXSessionDesc_ = emptyProtobufList();
        private String idfaAuthorizationStatus_ = "";
        private Internal.ProtobufList<Purchase> purchaseSinceInstall_ = emptyProtobufList();
        private String connectivity_ = "";
        private String gaid_ = "";
        private String appsetId_ = "";
        private String utcDate_ = "";
        private String localDate_ = "";
        private String sdkVersion_ = "";
        private String appVersion_ = "";
        private String deviceModel_ = "";
        private String deviceManufacturer_ = "";
        private Internal.ProtobufList<String> keyboardLang_ = GeneratedMessageLite.emptyProtobufList();
        private String orientation_ = "";
        private String prevSessionStartDate_ = "";
        private String date_ = "";
        private String idfv_ = "";
        private String idfa_ = "";
        private String appstoreId_ = "";
        private String pluginVersion_ = "";
        private Internal.ProtobufList<CountInfo> countWonReq_ = emptyProtobufList();
        private Internal.ProtobufList<CountInfo> countClick_ = emptyProtobufList();
        private Internal.ProtobufList<CountInfo> countImp_ = emptyProtobufList();
        private String extraSignals_ = "";

        private AnalyticsData() {
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasUnityVersion() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getUnityVersion() {
            return this.unityVersion_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getUnityVersionBytes() {
            return ByteString.copyFromUtf8(this.unityVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnityVersion(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.unityVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUnityVersion() {
            this.bitField0_ &= -2;
            this.unityVersion_ = getDefaultInstance().getUnityVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUnityVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.unityVersion_ = byteString.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasVsauceVersion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getVsauceVersion() {
            return this.vsauceVersion_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getVsauceVersionBytes() {
            return ByteString.copyFromUtf8(this.vsauceVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVsauceVersion(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.vsauceVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVsauceVersion() {
            this.bitField0_ &= -3;
            this.vsauceVersion_ = getDefaultInstance().getVsauceVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVsauceVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.vsauceVersion_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasSessionId() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getSessionId() {
            return this.sessionId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getSessionIdBytes() {
            return ByteString.copyFromUtf8(this.sessionId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionId(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.sessionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionId() {
            this.bitField0_ &= -5;
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sessionId_ = byteString.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasInstallDate() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getInstallDate() {
            return this.installDate_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getInstallDateBytes() {
            return ByteString.copyFromUtf8(this.installDate_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstallDate(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.installDate_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInstallDate() {
            this.bitField0_ &= -9;
            this.installDate_ = getDefaultInstance().getInstallDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstallDateBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.installDate_ = byteString.toStringUtf8();
            this.bitField0_ |= 8;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasSessionStartDate() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getSessionStartDate() {
            return this.sessionStartDate_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getSessionStartDateBytes() {
            return ByteString.copyFromUtf8(this.sessionStartDate_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionStartDate(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.sessionStartDate_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionStartDate() {
            this.bitField0_ &= -17;
            this.sessionStartDate_ = getDefaultInstance().getSessionStartDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionStartDateBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sessionStartDate_ = byteString.toStringUtf8();
            this.bitField0_ |= 16;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasAppOpenCountSinceInstall() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getAppOpenCountSinceInstall() {
            return this.appOpenCountSinceInstall_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppOpenCountSinceInstall(int i) {
            this.bitField0_ |= 32;
            this.appOpenCountSinceInstall_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppOpenCountSinceInstall() {
            this.bitField0_ &= -33;
            this.appOpenCountSinceInstall_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasSessionCountSinceInstall() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getSessionCountSinceInstall() {
            return this.sessionCountSinceInstall_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionCountSinceInstall(int i) {
            this.bitField0_ |= 64;
            this.sessionCountSinceInstall_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionCountSinceInstall() {
            this.bitField0_ &= -65;
            this.sessionCountSinceInstall_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasVanUserId() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getVanUserId() {
            return this.vanUserId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getVanUserIdBytes() {
            return ByteString.copyFromUtf8(this.vanUserId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanUserId(String str) {
            str.getClass();
            this.bitField0_ |= 128;
            this.vanUserId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVanUserId() {
            this.bitField0_ &= -129;
            this.vanUserId_ = getDefaultInstance().getVanUserId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanUserIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.vanUserId_ = byteString.toStringUtf8();
            this.bitField0_ |= 128;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasMmpId() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getMmpId() {
            return this.mmpId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getMmpIdBytes() {
            return ByteString.copyFromUtf8(this.mmpId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMmpId(String str) {
            str.getClass();
            this.bitField0_ |= 256;
            this.mmpId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMmpId() {
            this.bitField0_ &= -257;
            this.mmpId_ = getDefaultInstance().getMmpId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMmpIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.mmpId_ = byteString.toStringUtf8();
            this.bitField0_ |= 256;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasGameCountSinceInstall() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getGameCountSinceInstall() {
            return this.gameCountSinceInstall_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGameCountSinceInstall(int i) {
            this.bitField0_ |= 512;
            this.gameCountSinceInstall_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGameCountSinceInstall() {
            this.bitField0_ &= -513;
            this.gameCountSinceInstall_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasGameCount() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getGameCount() {
            return this.gameCount_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGameCount(int i) {
            this.bitField0_ |= 1024;
            this.gameCount_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGameCount() {
            this.bitField0_ &= -1025;
            this.gameCount_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasPerfMetrics() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public PerformanceMetrics getPerfMetrics() {
            PerformanceMetrics performanceMetrics = this.perfMetrics_;
            return performanceMetrics == null ? PerformanceMetrics.getDefaultInstance() : performanceMetrics;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPerfMetrics(PerformanceMetrics performanceMetrics) {
            performanceMetrics.getClass();
            this.perfMetrics_ = performanceMetrics;
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePerfMetrics(PerformanceMetrics performanceMetrics) {
            performanceMetrics.getClass();
            PerformanceMetrics performanceMetrics2 = this.perfMetrics_;
            if (performanceMetrics2 != null && performanceMetrics2 != PerformanceMetrics.getDefaultInstance()) {
                this.perfMetrics_ = PerformanceMetrics.newBuilder(this.perfMetrics_).mergeFrom((PerformanceMetrics.Builder) performanceMetrics).buildPartial();
            } else {
                this.perfMetrics_ = performanceMetrics;
            }
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPerfMetrics() {
            this.perfMetrics_ = null;
            this.bitField0_ &= -2049;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasGameCountSuccess() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getGameCountSuccess() {
            return this.gameCountSuccess_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGameCountSuccess(int i) {
            this.bitField0_ |= 4096;
            this.gameCountSuccess_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGameCountSuccess() {
            this.bitField0_ &= -4097;
            this.gameCountSuccess_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasPlayTime() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getPlayTime() {
            return this.playTime_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlayTime(int i) {
            this.bitField0_ |= 8192;
            this.playTime_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlayTime() {
            this.bitField0_ &= -8193;
            this.playTime_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasTotalTime() {
            return (this.bitField0_ & 16384) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getTotalTime() {
            return this.totalTime_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalTime(int i) {
            this.bitField0_ |= 16384;
            this.totalTime_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalTime() {
            this.bitField0_ &= -16385;
            this.totalTime_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasAttribution() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public Attribution getAttribution() {
            Attribution attribution = this.attribution_;
            return attribution == null ? Attribution.getDefaultInstance() : attribution;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttribution(Attribution attribution) {
            attribution.getClass();
            this.attribution_ = attribution;
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAttribution(Attribution attribution) {
            attribution.getClass();
            Attribution attribution2 = this.attribution_;
            if (attribution2 != null && attribution2 != Attribution.getDefaultInstance()) {
                this.attribution_ = Attribution.newBuilder(this.attribution_).mergeFrom((Attribution.Builder) attribution).buildPartial();
            } else {
                this.attribution_ = attribution;
            }
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAttribution() {
            this.attribution_ = null;
            this.bitField0_ &= -32769;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasFsLoadIndex() {
            return (this.bitField0_ & 65536) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getFsLoadIndex() {
            return this.fsLoadIndex_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFsLoadIndex(int i) {
            this.bitField0_ |= 65536;
            this.fsLoadIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFsLoadIndex() {
            this.bitField0_ &= -65537;
            this.fsLoadIndex_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasRvLoadIndex() {
            return (this.bitField0_ & 131072) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getRvLoadIndex() {
            return this.rvLoadIndex_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRvLoadIndex(int i) {
            this.bitField0_ |= 131072;
            this.rvLoadIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRvLoadIndex() {
            this.bitField0_ &= -131073;
            this.rvLoadIndex_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasFsCountSinceInstall() {
            return (this.bitField0_ & 262144) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getFsCountSinceInstall() {
            return this.fsCountSinceInstall_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFsCountSinceInstall(int i) {
            this.bitField0_ |= 262144;
            this.fsCountSinceInstall_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFsCountSinceInstall() {
            this.bitField0_ &= -262145;
            this.fsCountSinceInstall_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasRvCountSinceInstall() {
            return (this.bitField0_ & 524288) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getRvCountSinceInstall() {
            return this.rvCountSinceInstall_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRvCountSinceInstall(int i) {
            this.bitField0_ |= 524288;
            this.rvCountSinceInstall_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRvCountSinceInstall() {
            this.bitField0_ &= -524289;
            this.rvCountSinceInstall_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasFsClickCountSinceInstall() {
            return (this.bitField0_ & 1048576) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getFsClickCountSinceInstall() {
            return this.fsClickCountSinceInstall_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFsClickCountSinceInstall(int i) {
            this.bitField0_ |= 1048576;
            this.fsClickCountSinceInstall_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFsClickCountSinceInstall() {
            this.bitField0_ &= -1048577;
            this.fsClickCountSinceInstall_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasRvClickCountSinceInstall() {
            return (this.bitField0_ & 2097152) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getRvClickCountSinceInstall() {
            return this.rvClickCountSinceInstall_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRvClickCountSinceInstall(int i) {
            this.bitField0_ |= 2097152;
            this.rvClickCountSinceInstall_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRvClickCountSinceInstall() {
            this.bitField0_ &= -2097153;
            this.rvClickCountSinceInstall_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasRevGen() {
            return (this.bitField0_ & 4194304) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public RevenueGeneration getRevGen() {
            RevenueGeneration revenueGeneration = this.revGen_;
            return revenueGeneration == null ? RevenueGeneration.getDefaultInstance() : revenueGeneration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRevGen(RevenueGeneration revenueGeneration) {
            revenueGeneration.getClass();
            this.revGen_ = revenueGeneration;
            this.bitField0_ |= 4194304;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRevGen(RevenueGeneration revenueGeneration) {
            revenueGeneration.getClass();
            RevenueGeneration revenueGeneration2 = this.revGen_;
            if (revenueGeneration2 != null && revenueGeneration2 != RevenueGeneration.getDefaultInstance()) {
                this.revGen_ = RevenueGeneration.newBuilder(this.revGen_).mergeFrom((RevenueGeneration.Builder) revenueGeneration).buildPartial();
            } else {
                this.revGen_ = revenueGeneration;
            }
            this.bitField0_ |= 4194304;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRevGen() {
            this.revGen_ = null;
            this.bitField0_ &= -4194305;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasRevGenSinceInstall() {
            return (this.bitField0_ & 8388608) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public RevenueGeneration getRevGenSinceInstall() {
            RevenueGeneration revenueGeneration = this.revGenSinceInstall_;
            return revenueGeneration == null ? RevenueGeneration.getDefaultInstance() : revenueGeneration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRevGenSinceInstall(RevenueGeneration revenueGeneration) {
            revenueGeneration.getClass();
            this.revGenSinceInstall_ = revenueGeneration;
            this.bitField0_ |= 8388608;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRevGenSinceInstall(RevenueGeneration revenueGeneration) {
            revenueGeneration.getClass();
            RevenueGeneration revenueGeneration2 = this.revGenSinceInstall_;
            if (revenueGeneration2 != null && revenueGeneration2 != RevenueGeneration.getDefaultInstance()) {
                this.revGenSinceInstall_ = RevenueGeneration.newBuilder(this.revGenSinceInstall_).mergeFrom((RevenueGeneration.Builder) revenueGeneration).buildPartial();
            } else {
                this.revGenSinceInstall_ = revenueGeneration;
            }
            this.bitField0_ |= 8388608;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRevGenSinceInstall() {
            this.revGenSinceInstall_ = null;
            this.bitField0_ &= -8388609;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasVanImpressionId() {
            return (this.bitField0_ & 16777216) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getVanImpressionId() {
            return this.vanImpressionId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getVanImpressionIdBytes() {
            return ByteString.copyFromUtf8(this.vanImpressionId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanImpressionId(String str) {
            str.getClass();
            this.bitField0_ |= 16777216;
            this.vanImpressionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVanImpressionId() {
            this.bitField0_ &= -16777217;
            this.vanImpressionId_ = getDefaultInstance().getVanImpressionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanImpressionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.vanImpressionId_ = byteString.toStringUtf8();
            this.bitField0_ |= 16777216;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasVanFsImpressionId() {
            return (this.bitField0_ & 33554432) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getVanFsImpressionId() {
            return this.vanFsImpressionId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getVanFsImpressionIdBytes() {
            return ByteString.copyFromUtf8(this.vanFsImpressionId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanFsImpressionId(String str) {
            str.getClass();
            this.bitField0_ |= 33554432;
            this.vanFsImpressionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVanFsImpressionId() {
            this.bitField0_ &= -33554433;
            this.vanFsImpressionId_ = getDefaultInstance().getVanFsImpressionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanFsImpressionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.vanFsImpressionId_ = byteString.toStringUtf8();
            this.bitField0_ |= 33554432;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasVanRvImpressionId() {
            return (this.bitField0_ & 67108864) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getVanRvImpressionId() {
            return this.vanRvImpressionId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getVanRvImpressionIdBytes() {
            return ByteString.copyFromUtf8(this.vanRvImpressionId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanRvImpressionId(String str) {
            str.getClass();
            this.bitField0_ |= 67108864;
            this.vanRvImpressionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVanRvImpressionId() {
            this.bitField0_ &= -67108865;
            this.vanRvImpressionId_ = getDefaultInstance().getVanRvImpressionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVanRvImpressionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.vanRvImpressionId_ = byteString.toStringUtf8();
            this.bitField0_ |= 67108864;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasCountReq() {
            return (this.bitField0_ & 134217728) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getCountReq() {
            return this.countReq_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountReq(int i) {
            this.bitField0_ |= 134217728;
            this.countReq_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountReq() {
            this.bitField0_ &= -134217729;
            this.countReq_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasHasLastClick() {
            return (this.bitField0_ & 268435456) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public LastClick getHasLastClick() {
            LastClick lastClick = this.hasLastClick_;
            return lastClick == null ? LastClick.getDefaultInstance() : lastClick;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHasLastClick(LastClick lastClick) {
            lastClick.getClass();
            this.hasLastClick_ = lastClick;
            this.bitField0_ |= 268435456;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeHasLastClick(LastClick lastClick) {
            lastClick.getClass();
            LastClick lastClick2 = this.hasLastClick_;
            if (lastClick2 != null && lastClick2 != LastClick.getDefaultInstance()) {
                this.hasLastClick_ = LastClick.newBuilder(this.hasLastClick_).mergeFrom((LastClick.Builder) lastClick).buildPartial();
            } else {
                this.hasLastClick_ = lastClick;
            }
            this.bitField0_ |= 268435456;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHasLastClick() {
            this.hasLastClick_ = null;
            this.bitField0_ &= -268435457;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<AdInfo> getLastXSessionDescList() {
            return this.lastXSessionDesc_;
        }

        public List<? extends AdInfoOrBuilder> getLastXSessionDescOrBuilderList() {
            return this.lastXSessionDesc_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getLastXSessionDescCount() {
            return this.lastXSessionDesc_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public AdInfo getLastXSessionDesc(int i) {
            return this.lastXSessionDesc_.get(i);
        }

        public AdInfoOrBuilder getLastXSessionDescOrBuilder(int i) {
            return this.lastXSessionDesc_.get(i);
        }

        private void ensureLastXSessionDescIsMutable() {
            Internal.ProtobufList<AdInfo> protobufList = this.lastXSessionDesc_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.lastXSessionDesc_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLastXSessionDesc(int i, AdInfo adInfo) {
            adInfo.getClass();
            ensureLastXSessionDescIsMutable();
            this.lastXSessionDesc_.set(i, adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLastXSessionDesc(AdInfo adInfo) {
            adInfo.getClass();
            ensureLastXSessionDescIsMutable();
            this.lastXSessionDesc_.add(adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLastXSessionDesc(int i, AdInfo adInfo) {
            adInfo.getClass();
            ensureLastXSessionDescIsMutable();
            this.lastXSessionDesc_.add(i, adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLastXSessionDesc(Iterable<? extends AdInfo> iterable) {
            ensureLastXSessionDescIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.lastXSessionDesc_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLastXSessionDesc() {
            this.lastXSessionDesc_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLastXSessionDesc(int i) {
            ensureLastXSessionDescIsMutable();
            this.lastXSessionDesc_.remove(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<AdInfo> getPrevXSessionDescList() {
            return this.prevXSessionDesc_;
        }

        public List<? extends AdInfoOrBuilder> getPrevXSessionDescOrBuilderList() {
            return this.prevXSessionDesc_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getPrevXSessionDescCount() {
            return this.prevXSessionDesc_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public AdInfo getPrevXSessionDesc(int i) {
            return this.prevXSessionDesc_.get(i);
        }

        public AdInfoOrBuilder getPrevXSessionDescOrBuilder(int i) {
            return this.prevXSessionDesc_.get(i);
        }

        private void ensurePrevXSessionDescIsMutable() {
            Internal.ProtobufList<AdInfo> protobufList = this.prevXSessionDesc_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.prevXSessionDesc_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrevXSessionDesc(int i, AdInfo adInfo) {
            adInfo.getClass();
            ensurePrevXSessionDescIsMutable();
            this.prevXSessionDesc_.set(i, adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPrevXSessionDesc(AdInfo adInfo) {
            adInfo.getClass();
            ensurePrevXSessionDescIsMutable();
            this.prevXSessionDesc_.add(adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPrevXSessionDesc(int i, AdInfo adInfo) {
            adInfo.getClass();
            ensurePrevXSessionDescIsMutable();
            this.prevXSessionDesc_.add(i, adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPrevXSessionDesc(Iterable<? extends AdInfo> iterable) {
            ensurePrevXSessionDescIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.prevXSessionDesc_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrevXSessionDesc() {
            this.prevXSessionDesc_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePrevXSessionDesc(int i) {
            ensurePrevXSessionDescIsMutable();
            this.prevXSessionDesc_.remove(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<AdInfo> getFirstXSessionDescList() {
            return this.firstXSessionDesc_;
        }

        public List<? extends AdInfoOrBuilder> getFirstXSessionDescOrBuilderList() {
            return this.firstXSessionDesc_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getFirstXSessionDescCount() {
            return this.firstXSessionDesc_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public AdInfo getFirstXSessionDesc(int i) {
            return this.firstXSessionDesc_.get(i);
        }

        public AdInfoOrBuilder getFirstXSessionDescOrBuilder(int i) {
            return this.firstXSessionDesc_.get(i);
        }

        private void ensureFirstXSessionDescIsMutable() {
            Internal.ProtobufList<AdInfo> protobufList = this.firstXSessionDesc_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.firstXSessionDesc_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFirstXSessionDesc(int i, AdInfo adInfo) {
            adInfo.getClass();
            ensureFirstXSessionDescIsMutable();
            this.firstXSessionDesc_.set(i, adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFirstXSessionDesc(AdInfo adInfo) {
            adInfo.getClass();
            ensureFirstXSessionDescIsMutable();
            this.firstXSessionDesc_.add(adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFirstXSessionDesc(int i, AdInfo adInfo) {
            adInfo.getClass();
            ensureFirstXSessionDescIsMutable();
            this.firstXSessionDesc_.add(i, adInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFirstXSessionDesc(Iterable<? extends AdInfo> iterable) {
            ensureFirstXSessionDescIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.firstXSessionDesc_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFirstXSessionDesc() {
            this.firstXSessionDesc_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeFirstXSessionDesc(int i) {
            ensureFirstXSessionDescIsMutable();
            this.firstXSessionDesc_.remove(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasHasSkipPriorRv() {
            return (this.bitField0_ & 536870912) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getHasSkipPriorRv() {
            return this.hasSkipPriorRv_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHasSkipPriorRv(int i) {
            this.bitField0_ |= 536870912;
            this.hasSkipPriorRv_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHasSkipPriorRv() {
            this.bitField0_ &= -536870913;
            this.hasSkipPriorRv_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getAdsConsentGiven() {
            return this.adsConsentGiven_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdsConsentGiven(int i) {
            this.adsConsentGiven_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdsConsentGiven() {
            this.adsConsentGiven_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasIdfaAuthorizationStatus() {
            return (this.bitField0_ & 1073741824) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getIdfaAuthorizationStatus() {
            return this.idfaAuthorizationStatus_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getIdfaAuthorizationStatusBytes() {
            return ByteString.copyFromUtf8(this.idfaAuthorizationStatus_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfaAuthorizationStatus(String str) {
            str.getClass();
            this.bitField0_ |= 1073741824;
            this.idfaAuthorizationStatus_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdfaAuthorizationStatus() {
            this.bitField0_ &= -1073741825;
            this.idfaAuthorizationStatus_ = getDefaultInstance().getIdfaAuthorizationStatus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfaAuthorizationStatusBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.idfaAuthorizationStatus_ = byteString.toStringUtf8();
            this.bitField0_ |= 1073741824;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<Purchase> getPurchaseSinceInstallList() {
            return this.purchaseSinceInstall_;
        }

        public List<? extends PurchaseOrBuilder> getPurchaseSinceInstallOrBuilderList() {
            return this.purchaseSinceInstall_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getPurchaseSinceInstallCount() {
            return this.purchaseSinceInstall_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public Purchase getPurchaseSinceInstall(int i) {
            return this.purchaseSinceInstall_.get(i);
        }

        public PurchaseOrBuilder getPurchaseSinceInstallOrBuilder(int i) {
            return this.purchaseSinceInstall_.get(i);
        }

        private void ensurePurchaseSinceInstallIsMutable() {
            Internal.ProtobufList<Purchase> protobufList = this.purchaseSinceInstall_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.purchaseSinceInstall_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPurchaseSinceInstall(int i, Purchase purchase) {
            purchase.getClass();
            ensurePurchaseSinceInstallIsMutable();
            this.purchaseSinceInstall_.set(i, purchase);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPurchaseSinceInstall(Purchase purchase) {
            purchase.getClass();
            ensurePurchaseSinceInstallIsMutable();
            this.purchaseSinceInstall_.add(purchase);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPurchaseSinceInstall(int i, Purchase purchase) {
            purchase.getClass();
            ensurePurchaseSinceInstallIsMutable();
            this.purchaseSinceInstall_.add(i, purchase);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPurchaseSinceInstall(Iterable<? extends Purchase> iterable) {
            ensurePurchaseSinceInstallIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.purchaseSinceInstall_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPurchaseSinceInstall() {
            this.purchaseSinceInstall_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePurchaseSinceInstall(int i) {
            ensurePurchaseSinceInstallIsMutable();
            this.purchaseSinceInstall_.remove(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasIsPremium() {
            return (this.bitField0_ & Integer.MIN_VALUE) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getIsPremium() {
            return this.isPremium_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsPremium(int i) {
            this.bitField0_ |= Integer.MIN_VALUE;
            this.isPremium_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsPremium() {
            this.bitField0_ &= Integer.MAX_VALUE;
            this.isPremium_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasAirplaneModeEnable() {
            return (this.bitField1_ & 1) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getAirplaneModeEnable() {
            return this.airplaneModeEnable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAirplaneModeEnable(int i) {
            this.bitField1_ |= 1;
            this.airplaneModeEnable_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAirplaneModeEnable() {
            this.bitField1_ &= -2;
            this.airplaneModeEnable_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasConnectivity() {
            return (this.bitField1_ & 2) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getConnectivity() {
            return this.connectivity_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getConnectivityBytes() {
            return ByteString.copyFromUtf8(this.connectivity_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConnectivity(String str) {
            str.getClass();
            this.bitField1_ |= 2;
            this.connectivity_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConnectivity() {
            this.bitField1_ &= -3;
            this.connectivity_ = getDefaultInstance().getConnectivity();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConnectivityBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.connectivity_ = byteString.toStringUtf8();
            this.bitField1_ |= 2;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasBattery() {
            return (this.bitField1_ & 4) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getBattery() {
            return this.battery_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBattery(int i) {
            this.bitField1_ |= 4;
            this.battery_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBattery() {
            this.bitField1_ &= -5;
            this.battery_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasBatterySaverEnable() {
            return (this.bitField1_ & 8) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getBatterySaverEnable() {
            return this.batterySaverEnable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBatterySaverEnable(int i) {
            this.bitField1_ |= 8;
            this.batterySaverEnable_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBatterySaverEnable() {
            this.bitField1_ &= -9;
            this.batterySaverEnable_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasBattCharge() {
            return (this.bitField1_ & 16) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getBattCharge() {
            return this.battCharge_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBattCharge(int i) {
            this.bitField1_ |= 16;
            this.battCharge_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBattCharge() {
            this.bitField1_ &= -17;
            this.battCharge_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasAvailableDiskSpace() {
            return (this.bitField1_ & 32) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public long getAvailableDiskSpace() {
            return this.availableDiskSpace_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAvailableDiskSpace(long j) {
            this.bitField1_ |= 32;
            this.availableDiskSpace_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAvailableDiskSpace() {
            this.bitField1_ &= -33;
            this.availableDiskSpace_ = 0L;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasTotalDiskSpace() {
            return (this.bitField1_ & 64) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public long getTotalDiskSpace() {
            return this.totalDiskSpace_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTotalDiskSpace(long j) {
            this.bitField1_ |= 64;
            this.totalDiskSpace_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTotalDiskSpace() {
            this.bitField1_ &= -65;
            this.totalDiskSpace_ = 0L;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasDoNotDist() {
            return (this.bitField1_ & 128) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getDoNotDist() {
            return this.doNotDist_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoNotDist(int i) {
            this.bitField1_ |= 128;
            this.doNotDist_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoNotDist() {
            this.bitField1_ &= -129;
            this.doNotDist_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasGaid() {
            return (this.bitField1_ & 256) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getGaid() {
            return this.gaid_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getGaidBytes() {
            return ByteString.copyFromUtf8(this.gaid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGaid(String str) {
            str.getClass();
            this.bitField1_ |= 256;
            this.gaid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGaid() {
            this.bitField1_ &= -257;
            this.gaid_ = getDefaultInstance().getGaid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGaidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.gaid_ = byteString.toStringUtf8();
            this.bitField1_ |= 256;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasAppsetId() {
            return (this.bitField1_ & 512) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getAppsetId() {
            return this.appsetId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getAppsetIdBytes() {
            return ByteString.copyFromUtf8(this.appsetId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppsetId(String str) {
            str.getClass();
            this.bitField1_ |= 512;
            this.appsetId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppsetId() {
            this.bitField1_ &= -513;
            this.appsetId_ = getDefaultInstance().getAppsetId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppsetIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.appsetId_ = byteString.toStringUtf8();
            this.bitField1_ |= 512;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasLimitAdTracking() {
            return (this.bitField1_ & 1024) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getLimitAdTracking() {
            return this.limitAdTracking_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimitAdTracking(int i) {
            this.bitField1_ |= 1024;
            this.limitAdTracking_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimitAdTracking() {
            this.bitField1_ &= -1025;
            this.limitAdTracking_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getGlobalTokenIndex() {
            return this.globalTokenIndex_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGlobalTokenIndex(int i) {
            this.globalTokenIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGlobalTokenIndex() {
            this.globalTokenIndex_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getTokenIndex() {
            return this.tokenIndex_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenIndex(int i) {
            this.tokenIndex_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTokenIndex() {
            this.tokenIndex_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasUtcDate() {
            return (this.bitField1_ & 2048) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getUtcDate() {
            return this.utcDate_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getUtcDateBytes() {
            return ByteString.copyFromUtf8(this.utcDate_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUtcDate(String str) {
            str.getClass();
            this.bitField1_ |= 2048;
            this.utcDate_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUtcDate() {
            this.bitField1_ &= -2049;
            this.utcDate_ = getDefaultInstance().getUtcDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUtcDateBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.utcDate_ = byteString.toStringUtf8();
            this.bitField1_ |= 2048;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasLocalDate() {
            return (this.bitField1_ & 4096) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getLocalDate() {
            return this.localDate_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getLocalDateBytes() {
            return ByteString.copyFromUtf8(this.localDate_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLocalDate(String str) {
            str.getClass();
            this.bitField1_ |= 4096;
            this.localDate_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLocalDate() {
            this.bitField1_ &= -4097;
            this.localDate_ = getDefaultInstance().getLocalDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLocalDateBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.localDate_ = byteString.toStringUtf8();
            this.bitField1_ |= 4096;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getSdkVersion() {
            return this.sdkVersion_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getSdkVersionBytes() {
            return ByteString.copyFromUtf8(this.sdkVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersion(String str) {
            str.getClass();
            this.sdkVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkVersion() {
            this.sdkVersion_ = getDefaultInstance().getSdkVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sdkVersion_ = byteString.toStringUtf8();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getAppVersion() {
            return this.appVersion_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getAppVersionBytes() {
            return ByteString.copyFromUtf8(this.appVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersion(String str) {
            str.getClass();
            this.appVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppVersion() {
            this.appVersion_ = getDefaultInstance().getAppVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.appVersion_ = byteString.toStringUtf8();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getTestMode() {
            return this.testMode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTestMode(int i) {
            this.testMode_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTestMode() {
            this.testMode_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getDeviceModel() {
            return this.deviceModel_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getDeviceModelBytes() {
            return ByteString.copyFromUtf8(this.deviceModel_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceModel(String str) {
            str.getClass();
            this.deviceModel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceModel() {
            this.deviceModel_ = getDefaultInstance().getDeviceModel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceModelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceModel_ = byteString.toStringUtf8();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getDeviceManufacturer() {
            return this.deviceManufacturer_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getDeviceManufacturerBytes() {
            return ByteString.copyFromUtf8(this.deviceManufacturer_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceManufacturer(String str) {
            str.getClass();
            this.deviceManufacturer_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceManufacturer() {
            this.deviceManufacturer_ = getDefaultInstance().getDeviceManufacturer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceManufacturerBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceManufacturer_ = byteString.toStringUtf8();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasBluetooth() {
            return (this.bitField1_ & 8192) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getBluetooth() {
            return this.bluetooth_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBluetooth(int i) {
            this.bitField1_ |= 8192;
            this.bluetooth_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBluetooth() {
            this.bitField1_ &= -8193;
            this.bluetooth_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasDarkModeEnable() {
            return (this.bitField1_ & 16384) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getDarkModeEnable() {
            return this.darkModeEnable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDarkModeEnable(int i) {
            this.bitField1_ |= 16384;
            this.darkModeEnable_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDarkModeEnable() {
            this.bitField1_ &= -16385;
            this.darkModeEnable_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasHeadset() {
            return (this.bitField1_ & 32768) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getHeadset() {
            return this.headset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadset(int i) {
            this.bitField1_ |= 32768;
            this.headset_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeadset() {
            this.bitField1_ &= -32769;
            this.headset_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasSoundEnable() {
            return (this.bitField1_ & 65536) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getSoundEnable() {
            return this.soundEnable_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSoundEnable(int i) {
            this.bitField1_ |= 65536;
            this.soundEnable_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSoundEnable() {
            this.bitField1_ &= -65537;
            this.soundEnable_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasPpi() {
            return (this.bitField1_ & 131072) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getPpi() {
            return this.ppi_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPpi(int i) {
            this.bitField1_ |= 131072;
            this.ppi_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPpi() {
            this.bitField1_ &= -131073;
            this.ppi_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasIsWalking() {
            return (this.bitField1_ & 262144) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getIsWalking() {
            return this.isWalking_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsWalking(int i) {
            this.bitField1_ |= 262144;
            this.isWalking_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsWalking() {
            this.bitField1_ &= -262145;
            this.isWalking_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<String> getKeyboardLangList() {
            return this.keyboardLang_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getKeyboardLangCount() {
            return this.keyboardLang_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getKeyboardLang(int i) {
            return this.keyboardLang_.get(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getKeyboardLangBytes(int i) {
            return ByteString.copyFromUtf8(this.keyboardLang_.get(i));
        }

        private void ensureKeyboardLangIsMutable() {
            Internal.ProtobufList<String> protobufList = this.keyboardLang_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.keyboardLang_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyboardLang(int i, String str) {
            str.getClass();
            ensureKeyboardLangIsMutable();
            this.keyboardLang_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addKeyboardLang(String str) {
            str.getClass();
            ensureKeyboardLangIsMutable();
            this.keyboardLang_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllKeyboardLang(Iterable<String> iterable) {
            ensureKeyboardLangIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.keyboardLang_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyboardLang() {
            this.keyboardLang_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addKeyboardLangBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureKeyboardLangIsMutable();
            this.keyboardLang_.add(byteString.toStringUtf8());
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getOrientation() {
            return this.orientation_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getOrientationBytes() {
            return ByteString.copyFromUtf8(this.orientation_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOrientation(String str) {
            str.getClass();
            this.orientation_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOrientation() {
            this.orientation_ = getDefaultInstance().getOrientation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOrientationBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.orientation_ = byteString.toStringUtf8();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasDoNotSell() {
            return (this.bitField1_ & 524288) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getDoNotSell() {
            return this.doNotSell_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoNotSell(int i) {
            this.bitField1_ |= 524288;
            this.doNotSell_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoNotSell() {
            this.bitField1_ &= -524289;
            this.doNotSell_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasPrevSessionStartDate() {
            return (this.bitField1_ & 1048576) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getPrevSessionStartDate() {
            return this.prevSessionStartDate_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getPrevSessionStartDateBytes() {
            return ByteString.copyFromUtf8(this.prevSessionStartDate_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrevSessionStartDate(String str) {
            str.getClass();
            this.bitField1_ |= 1048576;
            this.prevSessionStartDate_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrevSessionStartDate() {
            this.bitField1_ &= -1048577;
            this.prevSessionStartDate_ = getDefaultInstance().getPrevSessionStartDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrevSessionStartDateBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.prevSessionStartDate_ = byteString.toStringUtf8();
            this.bitField1_ |= 1048576;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasDate() {
            return (this.bitField1_ & 2097152) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getDate() {
            return this.date_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getDateBytes() {
            return ByteString.copyFromUtf8(this.date_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDate(String str) {
            str.getClass();
            this.bitField1_ |= 2097152;
            this.date_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDate() {
            this.bitField1_ &= -2097153;
            this.date_ = getDefaultInstance().getDate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDateBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.date_ = byteString.toStringUtf8();
            this.bitField1_ |= 2097152;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasIdfv() {
            return (this.bitField1_ & 4194304) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getIdfv() {
            return this.idfv_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getIdfvBytes() {
            return ByteString.copyFromUtf8(this.idfv_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfv(String str) {
            str.getClass();
            this.bitField1_ |= 4194304;
            this.idfv_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdfv() {
            this.bitField1_ &= -4194305;
            this.idfv_ = getDefaultInstance().getIdfv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfvBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.idfv_ = byteString.toStringUtf8();
            this.bitField1_ |= 4194304;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasIdfa() {
            return (this.bitField1_ & 8388608) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getIdfa() {
            return this.idfa_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getIdfaBytes() {
            return ByteString.copyFromUtf8(this.idfa_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfa(String str) {
            str.getClass();
            this.bitField1_ |= 8388608;
            this.idfa_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdfa() {
            this.bitField1_ &= -8388609;
            this.idfa_ = getDefaultInstance().getIdfa();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfaBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.idfa_ = byteString.toStringUtf8();
            this.bitField1_ |= 8388608;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasAppstoreId() {
            return (this.bitField1_ & 16777216) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getAppstoreId() {
            return this.appstoreId_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getAppstoreIdBytes() {
            return ByteString.copyFromUtf8(this.appstoreId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppstoreId(String str) {
            str.getClass();
            this.bitField1_ |= 16777216;
            this.appstoreId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppstoreId() {
            this.bitField1_ &= -16777217;
            this.appstoreId_ = getDefaultInstance().getAppstoreId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppstoreIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.appstoreId_ = byteString.toStringUtf8();
            this.bitField1_ |= 16777216;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasPluginVersion() {
            return (this.bitField1_ & 33554432) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getPluginVersion() {
            return this.pluginVersion_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getPluginVersionBytes() {
            return ByteString.copyFromUtf8(this.pluginVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPluginVersion(String str) {
            str.getClass();
            this.bitField1_ |= 33554432;
            this.pluginVersion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPluginVersion() {
            this.bitField1_ &= -33554433;
            this.pluginVersion_ = getDefaultInstance().getPluginVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPluginVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.pluginVersion_ = byteString.toStringUtf8();
            this.bitField1_ |= 33554432;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<CountInfo> getCountWonReqList() {
            return this.countWonReq_;
        }

        public List<? extends CountInfoOrBuilder> getCountWonReqOrBuilderList() {
            return this.countWonReq_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getCountWonReqCount() {
            return this.countWonReq_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public CountInfo getCountWonReq(int i) {
            return this.countWonReq_.get(i);
        }

        public CountInfoOrBuilder getCountWonReqOrBuilder(int i) {
            return this.countWonReq_.get(i);
        }

        private void ensureCountWonReqIsMutable() {
            Internal.ProtobufList<CountInfo> protobufList = this.countWonReq_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.countWonReq_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountWonReq(int i, CountInfo countInfo) {
            countInfo.getClass();
            ensureCountWonReqIsMutable();
            this.countWonReq_.set(i, countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCountWonReq(CountInfo countInfo) {
            countInfo.getClass();
            ensureCountWonReqIsMutable();
            this.countWonReq_.add(countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCountWonReq(int i, CountInfo countInfo) {
            countInfo.getClass();
            ensureCountWonReqIsMutable();
            this.countWonReq_.add(i, countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCountWonReq(Iterable<? extends CountInfo> iterable) {
            ensureCountWonReqIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.countWonReq_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountWonReq() {
            this.countWonReq_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCountWonReq(int i) {
            ensureCountWonReqIsMutable();
            this.countWonReq_.remove(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<CountInfo> getCountClickList() {
            return this.countClick_;
        }

        public List<? extends CountInfoOrBuilder> getCountClickOrBuilderList() {
            return this.countClick_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getCountClickCount() {
            return this.countClick_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public CountInfo getCountClick(int i) {
            return this.countClick_.get(i);
        }

        public CountInfoOrBuilder getCountClickOrBuilder(int i) {
            return this.countClick_.get(i);
        }

        private void ensureCountClickIsMutable() {
            Internal.ProtobufList<CountInfo> protobufList = this.countClick_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.countClick_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountClick(int i, CountInfo countInfo) {
            countInfo.getClass();
            ensureCountClickIsMutable();
            this.countClick_.set(i, countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCountClick(CountInfo countInfo) {
            countInfo.getClass();
            ensureCountClickIsMutable();
            this.countClick_.add(countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCountClick(int i, CountInfo countInfo) {
            countInfo.getClass();
            ensureCountClickIsMutable();
            this.countClick_.add(i, countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCountClick(Iterable<? extends CountInfo> iterable) {
            ensureCountClickIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.countClick_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountClick() {
            this.countClick_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCountClick(int i) {
            ensureCountClickIsMutable();
            this.countClick_.remove(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public List<CountInfo> getCountImpList() {
            return this.countImp_;
        }

        public List<? extends CountInfoOrBuilder> getCountImpOrBuilderList() {
            return this.countImp_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getCountImpCount() {
            return this.countImp_.size();
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public CountInfo getCountImp(int i) {
            return this.countImp_.get(i);
        }

        public CountInfoOrBuilder getCountImpOrBuilder(int i) {
            return this.countImp_.get(i);
        }

        private void ensureCountImpIsMutable() {
            Internal.ProtobufList<CountInfo> protobufList = this.countImp_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.countImp_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountImp(int i, CountInfo countInfo) {
            countInfo.getClass();
            ensureCountImpIsMutable();
            this.countImp_.set(i, countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCountImp(CountInfo countInfo) {
            countInfo.getClass();
            ensureCountImpIsMutable();
            this.countImp_.add(countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCountImp(int i, CountInfo countInfo) {
            countInfo.getClass();
            ensureCountImpIsMutable();
            this.countImp_.add(i, countInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCountImp(Iterable<? extends CountInfo> iterable) {
            ensureCountImpIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.countImp_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountImp() {
            this.countImp_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCountImp(int i) {
            ensureCountImpIsMutable();
            this.countImp_.remove(i);
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasAppsetIdScope() {
            return (this.bitField1_ & 67108864) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public int getAppsetIdScope() {
            return this.appsetIdScope_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppsetIdScope(int i) {
            this.bitField1_ |= 67108864;
            this.appsetIdScope_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppsetIdScope() {
            this.bitField1_ &= -67108865;
            this.appsetIdScope_ = 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasExtraSignals() {
            return (this.bitField1_ & 134217728) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public String getExtraSignals() {
            return this.extraSignals_;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public ByteString getExtraSignalsBytes() {
            return ByteString.copyFromUtf8(this.extraSignals_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtraSignals(String str) {
            str.getClass();
            this.bitField1_ |= 134217728;
            this.extraSignals_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtraSignals() {
            this.bitField1_ &= -134217729;
            this.extraSignals_ = getDefaultInstance().getExtraSignals();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtraSignalsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.extraSignals_ = byteString.toStringUtf8();
            this.bitField1_ |= 134217728;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public boolean hasBootTime() {
            return (this.bitField1_ & 268435456) != 0;
        }

        @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
        public long getBootTime() {
            return this.bootTime_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBootTime(long j) {
            this.bitField1_ |= 268435456;
            this.bootTime_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBootTime() {
            this.bitField1_ &= -268435457;
            this.bootTime_ = 0L;
        }

        public static AnalyticsData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AnalyticsData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AnalyticsData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AnalyticsData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AnalyticsData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AnalyticsData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AnalyticsData parseFrom(InputStream inputStream) throws IOException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AnalyticsData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AnalyticsData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AnalyticsData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AnalyticsData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AnalyticsData) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AnalyticsData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AnalyticsData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AnalyticsData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AnalyticsData analyticsData) {
            return DEFAULT_INSTANCE.createBuilder(analyticsData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AnalyticsData, Builder> implements AnalyticsDataOrBuilder {
            private Builder() {
                super(AnalyticsData.DEFAULT_INSTANCE);
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasUnityVersion() {
                return ((AnalyticsData) this.instance).hasUnityVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getUnityVersion() {
                return ((AnalyticsData) this.instance).getUnityVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getUnityVersionBytes() {
                return ((AnalyticsData) this.instance).getUnityVersionBytes();
            }

            public Builder setUnityVersion(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setUnityVersion(str);
                return this;
            }

            public Builder clearUnityVersion() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearUnityVersion();
                return this;
            }

            public Builder setUnityVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setUnityVersionBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasVsauceVersion() {
                return ((AnalyticsData) this.instance).hasVsauceVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getVsauceVersion() {
                return ((AnalyticsData) this.instance).getVsauceVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getVsauceVersionBytes() {
                return ((AnalyticsData) this.instance).getVsauceVersionBytes();
            }

            public Builder setVsauceVersion(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVsauceVersion(str);
                return this;
            }

            public Builder clearVsauceVersion() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearVsauceVersion();
                return this;
            }

            public Builder setVsauceVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVsauceVersionBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasSessionId() {
                return ((AnalyticsData) this.instance).hasSessionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getSessionId() {
                return ((AnalyticsData) this.instance).getSessionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getSessionIdBytes() {
                return ((AnalyticsData) this.instance).getSessionIdBytes();
            }

            public Builder setSessionId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSessionId(str);
                return this;
            }

            public Builder clearSessionId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearSessionId();
                return this;
            }

            public Builder setSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSessionIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasInstallDate() {
                return ((AnalyticsData) this.instance).hasInstallDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getInstallDate() {
                return ((AnalyticsData) this.instance).getInstallDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getInstallDateBytes() {
                return ((AnalyticsData) this.instance).getInstallDateBytes();
            }

            public Builder setInstallDate(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setInstallDate(str);
                return this;
            }

            public Builder clearInstallDate() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearInstallDate();
                return this;
            }

            public Builder setInstallDateBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setInstallDateBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasSessionStartDate() {
                return ((AnalyticsData) this.instance).hasSessionStartDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getSessionStartDate() {
                return ((AnalyticsData) this.instance).getSessionStartDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getSessionStartDateBytes() {
                return ((AnalyticsData) this.instance).getSessionStartDateBytes();
            }

            public Builder setSessionStartDate(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSessionStartDate(str);
                return this;
            }

            public Builder clearSessionStartDate() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearSessionStartDate();
                return this;
            }

            public Builder setSessionStartDateBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSessionStartDateBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasAppOpenCountSinceInstall() {
                return ((AnalyticsData) this.instance).hasAppOpenCountSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getAppOpenCountSinceInstall() {
                return ((AnalyticsData) this.instance).getAppOpenCountSinceInstall();
            }

            public Builder setAppOpenCountSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppOpenCountSinceInstall(i);
                return this;
            }

            public Builder clearAppOpenCountSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAppOpenCountSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasSessionCountSinceInstall() {
                return ((AnalyticsData) this.instance).hasSessionCountSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getSessionCountSinceInstall() {
                return ((AnalyticsData) this.instance).getSessionCountSinceInstall();
            }

            public Builder setSessionCountSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSessionCountSinceInstall(i);
                return this;
            }

            public Builder clearSessionCountSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearSessionCountSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasVanUserId() {
                return ((AnalyticsData) this.instance).hasVanUserId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getVanUserId() {
                return ((AnalyticsData) this.instance).getVanUserId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getVanUserIdBytes() {
                return ((AnalyticsData) this.instance).getVanUserIdBytes();
            }

            public Builder setVanUserId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanUserId(str);
                return this;
            }

            public Builder clearVanUserId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearVanUserId();
                return this;
            }

            public Builder setVanUserIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanUserIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasMmpId() {
                return ((AnalyticsData) this.instance).hasMmpId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getMmpId() {
                return ((AnalyticsData) this.instance).getMmpId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getMmpIdBytes() {
                return ((AnalyticsData) this.instance).getMmpIdBytes();
            }

            public Builder setMmpId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setMmpId(str);
                return this;
            }

            public Builder clearMmpId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearMmpId();
                return this;
            }

            public Builder setMmpIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setMmpIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasGameCountSinceInstall() {
                return ((AnalyticsData) this.instance).hasGameCountSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getGameCountSinceInstall() {
                return ((AnalyticsData) this.instance).getGameCountSinceInstall();
            }

            public Builder setGameCountSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setGameCountSinceInstall(i);
                return this;
            }

            public Builder clearGameCountSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearGameCountSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasGameCount() {
                return ((AnalyticsData) this.instance).hasGameCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getGameCount() {
                return ((AnalyticsData) this.instance).getGameCount();
            }

            public Builder setGameCount(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setGameCount(i);
                return this;
            }

            public Builder clearGameCount() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearGameCount();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasPerfMetrics() {
                return ((AnalyticsData) this.instance).hasPerfMetrics();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public PerformanceMetrics getPerfMetrics() {
                return ((AnalyticsData) this.instance).getPerfMetrics();
            }

            public Builder setPerfMetrics(PerformanceMetrics performanceMetrics) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPerfMetrics(performanceMetrics);
                return this;
            }

            public Builder setPerfMetrics(PerformanceMetrics.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPerfMetrics(builder.build());
                return this;
            }

            public Builder mergePerfMetrics(PerformanceMetrics performanceMetrics) {
                copyOnWrite();
                ((AnalyticsData) this.instance).mergePerfMetrics(performanceMetrics);
                return this;
            }

            public Builder clearPerfMetrics() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearPerfMetrics();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasGameCountSuccess() {
                return ((AnalyticsData) this.instance).hasGameCountSuccess();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getGameCountSuccess() {
                return ((AnalyticsData) this.instance).getGameCountSuccess();
            }

            public Builder setGameCountSuccess(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setGameCountSuccess(i);
                return this;
            }

            public Builder clearGameCountSuccess() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearGameCountSuccess();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasPlayTime() {
                return ((AnalyticsData) this.instance).hasPlayTime();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getPlayTime() {
                return ((AnalyticsData) this.instance).getPlayTime();
            }

            public Builder setPlayTime(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPlayTime(i);
                return this;
            }

            public Builder clearPlayTime() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearPlayTime();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasTotalTime() {
                return ((AnalyticsData) this.instance).hasTotalTime();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getTotalTime() {
                return ((AnalyticsData) this.instance).getTotalTime();
            }

            public Builder setTotalTime(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setTotalTime(i);
                return this;
            }

            public Builder clearTotalTime() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearTotalTime();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasAttribution() {
                return ((AnalyticsData) this.instance).hasAttribution();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public Attribution getAttribution() {
                return ((AnalyticsData) this.instance).getAttribution();
            }

            public Builder setAttribution(Attribution attribution) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAttribution(attribution);
                return this;
            }

            public Builder setAttribution(Attribution.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAttribution(builder.build());
                return this;
            }

            public Builder mergeAttribution(Attribution attribution) {
                copyOnWrite();
                ((AnalyticsData) this.instance).mergeAttribution(attribution);
                return this;
            }

            public Builder clearAttribution() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAttribution();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasFsLoadIndex() {
                return ((AnalyticsData) this.instance).hasFsLoadIndex();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getFsLoadIndex() {
                return ((AnalyticsData) this.instance).getFsLoadIndex();
            }

            public Builder setFsLoadIndex(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setFsLoadIndex(i);
                return this;
            }

            public Builder clearFsLoadIndex() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearFsLoadIndex();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasRvLoadIndex() {
                return ((AnalyticsData) this.instance).hasRvLoadIndex();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getRvLoadIndex() {
                return ((AnalyticsData) this.instance).getRvLoadIndex();
            }

            public Builder setRvLoadIndex(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setRvLoadIndex(i);
                return this;
            }

            public Builder clearRvLoadIndex() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearRvLoadIndex();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasFsCountSinceInstall() {
                return ((AnalyticsData) this.instance).hasFsCountSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getFsCountSinceInstall() {
                return ((AnalyticsData) this.instance).getFsCountSinceInstall();
            }

            public Builder setFsCountSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setFsCountSinceInstall(i);
                return this;
            }

            public Builder clearFsCountSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearFsCountSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasRvCountSinceInstall() {
                return ((AnalyticsData) this.instance).hasRvCountSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getRvCountSinceInstall() {
                return ((AnalyticsData) this.instance).getRvCountSinceInstall();
            }

            public Builder setRvCountSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setRvCountSinceInstall(i);
                return this;
            }

            public Builder clearRvCountSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearRvCountSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasFsClickCountSinceInstall() {
                return ((AnalyticsData) this.instance).hasFsClickCountSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getFsClickCountSinceInstall() {
                return ((AnalyticsData) this.instance).getFsClickCountSinceInstall();
            }

            public Builder setFsClickCountSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setFsClickCountSinceInstall(i);
                return this;
            }

            public Builder clearFsClickCountSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearFsClickCountSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasRvClickCountSinceInstall() {
                return ((AnalyticsData) this.instance).hasRvClickCountSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getRvClickCountSinceInstall() {
                return ((AnalyticsData) this.instance).getRvClickCountSinceInstall();
            }

            public Builder setRvClickCountSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setRvClickCountSinceInstall(i);
                return this;
            }

            public Builder clearRvClickCountSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearRvClickCountSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasRevGen() {
                return ((AnalyticsData) this.instance).hasRevGen();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public RevenueGeneration getRevGen() {
                return ((AnalyticsData) this.instance).getRevGen();
            }

            public Builder setRevGen(RevenueGeneration revenueGeneration) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setRevGen(revenueGeneration);
                return this;
            }

            public Builder setRevGen(RevenueGeneration.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setRevGen(builder.build());
                return this;
            }

            public Builder mergeRevGen(RevenueGeneration revenueGeneration) {
                copyOnWrite();
                ((AnalyticsData) this.instance).mergeRevGen(revenueGeneration);
                return this;
            }

            public Builder clearRevGen() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearRevGen();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasRevGenSinceInstall() {
                return ((AnalyticsData) this.instance).hasRevGenSinceInstall();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public RevenueGeneration getRevGenSinceInstall() {
                return ((AnalyticsData) this.instance).getRevGenSinceInstall();
            }

            public Builder setRevGenSinceInstall(RevenueGeneration revenueGeneration) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setRevGenSinceInstall(revenueGeneration);
                return this;
            }

            public Builder setRevGenSinceInstall(RevenueGeneration.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setRevGenSinceInstall(builder.build());
                return this;
            }

            public Builder mergeRevGenSinceInstall(RevenueGeneration revenueGeneration) {
                copyOnWrite();
                ((AnalyticsData) this.instance).mergeRevGenSinceInstall(revenueGeneration);
                return this;
            }

            public Builder clearRevGenSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearRevGenSinceInstall();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasVanImpressionId() {
                return ((AnalyticsData) this.instance).hasVanImpressionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getVanImpressionId() {
                return ((AnalyticsData) this.instance).getVanImpressionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getVanImpressionIdBytes() {
                return ((AnalyticsData) this.instance).getVanImpressionIdBytes();
            }

            public Builder setVanImpressionId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanImpressionId(str);
                return this;
            }

            public Builder clearVanImpressionId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearVanImpressionId();
                return this;
            }

            public Builder setVanImpressionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanImpressionIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasVanFsImpressionId() {
                return ((AnalyticsData) this.instance).hasVanFsImpressionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getVanFsImpressionId() {
                return ((AnalyticsData) this.instance).getVanFsImpressionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getVanFsImpressionIdBytes() {
                return ((AnalyticsData) this.instance).getVanFsImpressionIdBytes();
            }

            public Builder setVanFsImpressionId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanFsImpressionId(str);
                return this;
            }

            public Builder clearVanFsImpressionId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearVanFsImpressionId();
                return this;
            }

            public Builder setVanFsImpressionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanFsImpressionIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasVanRvImpressionId() {
                return ((AnalyticsData) this.instance).hasVanRvImpressionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getVanRvImpressionId() {
                return ((AnalyticsData) this.instance).getVanRvImpressionId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getVanRvImpressionIdBytes() {
                return ((AnalyticsData) this.instance).getVanRvImpressionIdBytes();
            }

            public Builder setVanRvImpressionId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanRvImpressionId(str);
                return this;
            }

            public Builder clearVanRvImpressionId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearVanRvImpressionId();
                return this;
            }

            public Builder setVanRvImpressionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setVanRvImpressionIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasCountReq() {
                return ((AnalyticsData) this.instance).hasCountReq();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getCountReq() {
                return ((AnalyticsData) this.instance).getCountReq();
            }

            public Builder setCountReq(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setCountReq(i);
                return this;
            }

            public Builder clearCountReq() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearCountReq();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasHasLastClick() {
                return ((AnalyticsData) this.instance).hasHasLastClick();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public LastClick getHasLastClick() {
                return ((AnalyticsData) this.instance).getHasLastClick();
            }

            public Builder setHasLastClick(LastClick lastClick) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setHasLastClick(lastClick);
                return this;
            }

            public Builder setHasLastClick(LastClick.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setHasLastClick(builder.build());
                return this;
            }

            public Builder mergeHasLastClick(LastClick lastClick) {
                copyOnWrite();
                ((AnalyticsData) this.instance).mergeHasLastClick(lastClick);
                return this;
            }

            public Builder clearHasLastClick() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearHasLastClick();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<AdInfo> getLastXSessionDescList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getLastXSessionDescList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getLastXSessionDescCount() {
                return ((AnalyticsData) this.instance).getLastXSessionDescCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public AdInfo getLastXSessionDesc(int i) {
                return ((AnalyticsData) this.instance).getLastXSessionDesc(i);
            }

            public Builder setLastXSessionDesc(int i, AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setLastXSessionDesc(i, adInfo);
                return this;
            }

            public Builder setLastXSessionDesc(int i, AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setLastXSessionDesc(i, builder.build());
                return this;
            }

            public Builder addLastXSessionDesc(AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addLastXSessionDesc(adInfo);
                return this;
            }

            public Builder addLastXSessionDesc(int i, AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addLastXSessionDesc(i, adInfo);
                return this;
            }

            public Builder addLastXSessionDesc(AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addLastXSessionDesc(builder.build());
                return this;
            }

            public Builder addLastXSessionDesc(int i, AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addLastXSessionDesc(i, builder.build());
                return this;
            }

            public Builder addAllLastXSessionDesc(Iterable<? extends AdInfo> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllLastXSessionDesc(iterable);
                return this;
            }

            public Builder clearLastXSessionDesc() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearLastXSessionDesc();
                return this;
            }

            public Builder removeLastXSessionDesc(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).removeLastXSessionDesc(i);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<AdInfo> getPrevXSessionDescList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getPrevXSessionDescList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getPrevXSessionDescCount() {
                return ((AnalyticsData) this.instance).getPrevXSessionDescCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public AdInfo getPrevXSessionDesc(int i) {
                return ((AnalyticsData) this.instance).getPrevXSessionDesc(i);
            }

            public Builder setPrevXSessionDesc(int i, AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPrevXSessionDesc(i, adInfo);
                return this;
            }

            public Builder setPrevXSessionDesc(int i, AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPrevXSessionDesc(i, builder.build());
                return this;
            }

            public Builder addPrevXSessionDesc(AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPrevXSessionDesc(adInfo);
                return this;
            }

            public Builder addPrevXSessionDesc(int i, AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPrevXSessionDesc(i, adInfo);
                return this;
            }

            public Builder addPrevXSessionDesc(AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPrevXSessionDesc(builder.build());
                return this;
            }

            public Builder addPrevXSessionDesc(int i, AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPrevXSessionDesc(i, builder.build());
                return this;
            }

            public Builder addAllPrevXSessionDesc(Iterable<? extends AdInfo> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllPrevXSessionDesc(iterable);
                return this;
            }

            public Builder clearPrevXSessionDesc() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearPrevXSessionDesc();
                return this;
            }

            public Builder removePrevXSessionDesc(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).removePrevXSessionDesc(i);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<AdInfo> getFirstXSessionDescList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getFirstXSessionDescList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getFirstXSessionDescCount() {
                return ((AnalyticsData) this.instance).getFirstXSessionDescCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public AdInfo getFirstXSessionDesc(int i) {
                return ((AnalyticsData) this.instance).getFirstXSessionDesc(i);
            }

            public Builder setFirstXSessionDesc(int i, AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setFirstXSessionDesc(i, adInfo);
                return this;
            }

            public Builder setFirstXSessionDesc(int i, AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setFirstXSessionDesc(i, builder.build());
                return this;
            }

            public Builder addFirstXSessionDesc(AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addFirstXSessionDesc(adInfo);
                return this;
            }

            public Builder addFirstXSessionDesc(int i, AdInfo adInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addFirstXSessionDesc(i, adInfo);
                return this;
            }

            public Builder addFirstXSessionDesc(AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addFirstXSessionDesc(builder.build());
                return this;
            }

            public Builder addFirstXSessionDesc(int i, AdInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addFirstXSessionDesc(i, builder.build());
                return this;
            }

            public Builder addAllFirstXSessionDesc(Iterable<? extends AdInfo> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllFirstXSessionDesc(iterable);
                return this;
            }

            public Builder clearFirstXSessionDesc() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearFirstXSessionDesc();
                return this;
            }

            public Builder removeFirstXSessionDesc(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).removeFirstXSessionDesc(i);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasHasSkipPriorRv() {
                return ((AnalyticsData) this.instance).hasHasSkipPriorRv();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getHasSkipPriorRv() {
                return ((AnalyticsData) this.instance).getHasSkipPriorRv();
            }

            public Builder setHasSkipPriorRv(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setHasSkipPriorRv(i);
                return this;
            }

            public Builder clearHasSkipPriorRv() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearHasSkipPriorRv();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getAdsConsentGiven() {
                return ((AnalyticsData) this.instance).getAdsConsentGiven();
            }

            public Builder setAdsConsentGiven(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAdsConsentGiven(i);
                return this;
            }

            public Builder clearAdsConsentGiven() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAdsConsentGiven();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasIdfaAuthorizationStatus() {
                return ((AnalyticsData) this.instance).hasIdfaAuthorizationStatus();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getIdfaAuthorizationStatus() {
                return ((AnalyticsData) this.instance).getIdfaAuthorizationStatus();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getIdfaAuthorizationStatusBytes() {
                return ((AnalyticsData) this.instance).getIdfaAuthorizationStatusBytes();
            }

            public Builder setIdfaAuthorizationStatus(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIdfaAuthorizationStatus(str);
                return this;
            }

            public Builder clearIdfaAuthorizationStatus() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearIdfaAuthorizationStatus();
                return this;
            }

            public Builder setIdfaAuthorizationStatusBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIdfaAuthorizationStatusBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<Purchase> getPurchaseSinceInstallList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getPurchaseSinceInstallList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getPurchaseSinceInstallCount() {
                return ((AnalyticsData) this.instance).getPurchaseSinceInstallCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public Purchase getPurchaseSinceInstall(int i) {
                return ((AnalyticsData) this.instance).getPurchaseSinceInstall(i);
            }

            public Builder setPurchaseSinceInstall(int i, Purchase purchase) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPurchaseSinceInstall(i, purchase);
                return this;
            }

            public Builder setPurchaseSinceInstall(int i, Purchase.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPurchaseSinceInstall(i, builder.build());
                return this;
            }

            public Builder addPurchaseSinceInstall(Purchase purchase) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPurchaseSinceInstall(purchase);
                return this;
            }

            public Builder addPurchaseSinceInstall(int i, Purchase purchase) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPurchaseSinceInstall(i, purchase);
                return this;
            }

            public Builder addPurchaseSinceInstall(Purchase.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPurchaseSinceInstall(builder.build());
                return this;
            }

            public Builder addPurchaseSinceInstall(int i, Purchase.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addPurchaseSinceInstall(i, builder.build());
                return this;
            }

            public Builder addAllPurchaseSinceInstall(Iterable<? extends Purchase> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllPurchaseSinceInstall(iterable);
                return this;
            }

            public Builder clearPurchaseSinceInstall() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearPurchaseSinceInstall();
                return this;
            }

            public Builder removePurchaseSinceInstall(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).removePurchaseSinceInstall(i);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasIsPremium() {
                return ((AnalyticsData) this.instance).hasIsPremium();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getIsPremium() {
                return ((AnalyticsData) this.instance).getIsPremium();
            }

            public Builder setIsPremium(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIsPremium(i);
                return this;
            }

            public Builder clearIsPremium() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearIsPremium();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasAirplaneModeEnable() {
                return ((AnalyticsData) this.instance).hasAirplaneModeEnable();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getAirplaneModeEnable() {
                return ((AnalyticsData) this.instance).getAirplaneModeEnable();
            }

            public Builder setAirplaneModeEnable(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAirplaneModeEnable(i);
                return this;
            }

            public Builder clearAirplaneModeEnable() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAirplaneModeEnable();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasConnectivity() {
                return ((AnalyticsData) this.instance).hasConnectivity();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getConnectivity() {
                return ((AnalyticsData) this.instance).getConnectivity();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getConnectivityBytes() {
                return ((AnalyticsData) this.instance).getConnectivityBytes();
            }

            public Builder setConnectivity(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setConnectivity(str);
                return this;
            }

            public Builder clearConnectivity() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearConnectivity();
                return this;
            }

            public Builder setConnectivityBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setConnectivityBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasBattery() {
                return ((AnalyticsData) this.instance).hasBattery();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getBattery() {
                return ((AnalyticsData) this.instance).getBattery();
            }

            public Builder setBattery(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setBattery(i);
                return this;
            }

            public Builder clearBattery() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearBattery();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasBatterySaverEnable() {
                return ((AnalyticsData) this.instance).hasBatterySaverEnable();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getBatterySaverEnable() {
                return ((AnalyticsData) this.instance).getBatterySaverEnable();
            }

            public Builder setBatterySaverEnable(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setBatterySaverEnable(i);
                return this;
            }

            public Builder clearBatterySaverEnable() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearBatterySaverEnable();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasBattCharge() {
                return ((AnalyticsData) this.instance).hasBattCharge();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getBattCharge() {
                return ((AnalyticsData) this.instance).getBattCharge();
            }

            public Builder setBattCharge(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setBattCharge(i);
                return this;
            }

            public Builder clearBattCharge() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearBattCharge();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasAvailableDiskSpace() {
                return ((AnalyticsData) this.instance).hasAvailableDiskSpace();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public long getAvailableDiskSpace() {
                return ((AnalyticsData) this.instance).getAvailableDiskSpace();
            }

            public Builder setAvailableDiskSpace(long j) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAvailableDiskSpace(j);
                return this;
            }

            public Builder clearAvailableDiskSpace() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAvailableDiskSpace();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasTotalDiskSpace() {
                return ((AnalyticsData) this.instance).hasTotalDiskSpace();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public long getTotalDiskSpace() {
                return ((AnalyticsData) this.instance).getTotalDiskSpace();
            }

            public Builder setTotalDiskSpace(long j) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setTotalDiskSpace(j);
                return this;
            }

            public Builder clearTotalDiskSpace() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearTotalDiskSpace();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasDoNotDist() {
                return ((AnalyticsData) this.instance).hasDoNotDist();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getDoNotDist() {
                return ((AnalyticsData) this.instance).getDoNotDist();
            }

            public Builder setDoNotDist(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDoNotDist(i);
                return this;
            }

            public Builder clearDoNotDist() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearDoNotDist();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasGaid() {
                return ((AnalyticsData) this.instance).hasGaid();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getGaid() {
                return ((AnalyticsData) this.instance).getGaid();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getGaidBytes() {
                return ((AnalyticsData) this.instance).getGaidBytes();
            }

            public Builder setGaid(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setGaid(str);
                return this;
            }

            public Builder clearGaid() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearGaid();
                return this;
            }

            public Builder setGaidBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setGaidBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasAppsetId() {
                return ((AnalyticsData) this.instance).hasAppsetId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getAppsetId() {
                return ((AnalyticsData) this.instance).getAppsetId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getAppsetIdBytes() {
                return ((AnalyticsData) this.instance).getAppsetIdBytes();
            }

            public Builder setAppsetId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppsetId(str);
                return this;
            }

            public Builder clearAppsetId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAppsetId();
                return this;
            }

            public Builder setAppsetIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppsetIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasLimitAdTracking() {
                return ((AnalyticsData) this.instance).hasLimitAdTracking();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getLimitAdTracking() {
                return ((AnalyticsData) this.instance).getLimitAdTracking();
            }

            public Builder setLimitAdTracking(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setLimitAdTracking(i);
                return this;
            }

            public Builder clearLimitAdTracking() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearLimitAdTracking();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getGlobalTokenIndex() {
                return ((AnalyticsData) this.instance).getGlobalTokenIndex();
            }

            public Builder setGlobalTokenIndex(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setGlobalTokenIndex(i);
                return this;
            }

            public Builder clearGlobalTokenIndex() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearGlobalTokenIndex();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getTokenIndex() {
                return ((AnalyticsData) this.instance).getTokenIndex();
            }

            public Builder setTokenIndex(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setTokenIndex(i);
                return this;
            }

            public Builder clearTokenIndex() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearTokenIndex();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasUtcDate() {
                return ((AnalyticsData) this.instance).hasUtcDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getUtcDate() {
                return ((AnalyticsData) this.instance).getUtcDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getUtcDateBytes() {
                return ((AnalyticsData) this.instance).getUtcDateBytes();
            }

            public Builder setUtcDate(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setUtcDate(str);
                return this;
            }

            public Builder clearUtcDate() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearUtcDate();
                return this;
            }

            public Builder setUtcDateBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setUtcDateBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasLocalDate() {
                return ((AnalyticsData) this.instance).hasLocalDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getLocalDate() {
                return ((AnalyticsData) this.instance).getLocalDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getLocalDateBytes() {
                return ((AnalyticsData) this.instance).getLocalDateBytes();
            }

            public Builder setLocalDate(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setLocalDate(str);
                return this;
            }

            public Builder clearLocalDate() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearLocalDate();
                return this;
            }

            public Builder setLocalDateBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setLocalDateBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getSdkVersion() {
                return ((AnalyticsData) this.instance).getSdkVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getSdkVersionBytes() {
                return ((AnalyticsData) this.instance).getSdkVersionBytes();
            }

            public Builder setSdkVersion(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSdkVersion(str);
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearSdkVersion();
                return this;
            }

            public Builder setSdkVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSdkVersionBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getAppVersion() {
                return ((AnalyticsData) this.instance).getAppVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getAppVersionBytes() {
                return ((AnalyticsData) this.instance).getAppVersionBytes();
            }

            public Builder setAppVersion(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppVersion(str);
                return this;
            }

            public Builder clearAppVersion() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAppVersion();
                return this;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppVersionBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getTestMode() {
                return ((AnalyticsData) this.instance).getTestMode();
            }

            public Builder setTestMode(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setTestMode(i);
                return this;
            }

            public Builder clearTestMode() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearTestMode();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getDeviceModel() {
                return ((AnalyticsData) this.instance).getDeviceModel();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getDeviceModelBytes() {
                return ((AnalyticsData) this.instance).getDeviceModelBytes();
            }

            public Builder setDeviceModel(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDeviceModel(str);
                return this;
            }

            public Builder clearDeviceModel() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearDeviceModel();
                return this;
            }

            public Builder setDeviceModelBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDeviceModelBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getDeviceManufacturer() {
                return ((AnalyticsData) this.instance).getDeviceManufacturer();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getDeviceManufacturerBytes() {
                return ((AnalyticsData) this.instance).getDeviceManufacturerBytes();
            }

            public Builder setDeviceManufacturer(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDeviceManufacturer(str);
                return this;
            }

            public Builder clearDeviceManufacturer() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearDeviceManufacturer();
                return this;
            }

            public Builder setDeviceManufacturerBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDeviceManufacturerBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasBluetooth() {
                return ((AnalyticsData) this.instance).hasBluetooth();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getBluetooth() {
                return ((AnalyticsData) this.instance).getBluetooth();
            }

            public Builder setBluetooth(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setBluetooth(i);
                return this;
            }

            public Builder clearBluetooth() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearBluetooth();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasDarkModeEnable() {
                return ((AnalyticsData) this.instance).hasDarkModeEnable();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getDarkModeEnable() {
                return ((AnalyticsData) this.instance).getDarkModeEnable();
            }

            public Builder setDarkModeEnable(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDarkModeEnable(i);
                return this;
            }

            public Builder clearDarkModeEnable() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearDarkModeEnable();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasHeadset() {
                return ((AnalyticsData) this.instance).hasHeadset();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getHeadset() {
                return ((AnalyticsData) this.instance).getHeadset();
            }

            public Builder setHeadset(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setHeadset(i);
                return this;
            }

            public Builder clearHeadset() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearHeadset();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasSoundEnable() {
                return ((AnalyticsData) this.instance).hasSoundEnable();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getSoundEnable() {
                return ((AnalyticsData) this.instance).getSoundEnable();
            }

            public Builder setSoundEnable(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setSoundEnable(i);
                return this;
            }

            public Builder clearSoundEnable() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearSoundEnable();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasPpi() {
                return ((AnalyticsData) this.instance).hasPpi();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getPpi() {
                return ((AnalyticsData) this.instance).getPpi();
            }

            public Builder setPpi(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPpi(i);
                return this;
            }

            public Builder clearPpi() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearPpi();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasIsWalking() {
                return ((AnalyticsData) this.instance).hasIsWalking();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getIsWalking() {
                return ((AnalyticsData) this.instance).getIsWalking();
            }

            public Builder setIsWalking(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIsWalking(i);
                return this;
            }

            public Builder clearIsWalking() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearIsWalking();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<String> getKeyboardLangList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getKeyboardLangList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getKeyboardLangCount() {
                return ((AnalyticsData) this.instance).getKeyboardLangCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getKeyboardLang(int i) {
                return ((AnalyticsData) this.instance).getKeyboardLang(i);
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getKeyboardLangBytes(int i) {
                return ((AnalyticsData) this.instance).getKeyboardLangBytes(i);
            }

            public Builder setKeyboardLang(int i, String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setKeyboardLang(i, str);
                return this;
            }

            public Builder addKeyboardLang(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addKeyboardLang(str);
                return this;
            }

            public Builder addAllKeyboardLang(Iterable<String> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllKeyboardLang(iterable);
                return this;
            }

            public Builder clearKeyboardLang() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearKeyboardLang();
                return this;
            }

            public Builder addKeyboardLangBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addKeyboardLangBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getOrientation() {
                return ((AnalyticsData) this.instance).getOrientation();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getOrientationBytes() {
                return ((AnalyticsData) this.instance).getOrientationBytes();
            }

            public Builder setOrientation(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setOrientation(str);
                return this;
            }

            public Builder clearOrientation() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearOrientation();
                return this;
            }

            public Builder setOrientationBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setOrientationBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasDoNotSell() {
                return ((AnalyticsData) this.instance).hasDoNotSell();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getDoNotSell() {
                return ((AnalyticsData) this.instance).getDoNotSell();
            }

            public Builder setDoNotSell(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDoNotSell(i);
                return this;
            }

            public Builder clearDoNotSell() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearDoNotSell();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasPrevSessionStartDate() {
                return ((AnalyticsData) this.instance).hasPrevSessionStartDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getPrevSessionStartDate() {
                return ((AnalyticsData) this.instance).getPrevSessionStartDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getPrevSessionStartDateBytes() {
                return ((AnalyticsData) this.instance).getPrevSessionStartDateBytes();
            }

            public Builder setPrevSessionStartDate(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPrevSessionStartDate(str);
                return this;
            }

            public Builder clearPrevSessionStartDate() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearPrevSessionStartDate();
                return this;
            }

            public Builder setPrevSessionStartDateBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPrevSessionStartDateBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasDate() {
                return ((AnalyticsData) this.instance).hasDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getDate() {
                return ((AnalyticsData) this.instance).getDate();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getDateBytes() {
                return ((AnalyticsData) this.instance).getDateBytes();
            }

            public Builder setDate(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDate(str);
                return this;
            }

            public Builder clearDate() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearDate();
                return this;
            }

            public Builder setDateBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setDateBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasIdfv() {
                return ((AnalyticsData) this.instance).hasIdfv();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getIdfv() {
                return ((AnalyticsData) this.instance).getIdfv();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getIdfvBytes() {
                return ((AnalyticsData) this.instance).getIdfvBytes();
            }

            public Builder setIdfv(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIdfv(str);
                return this;
            }

            public Builder clearIdfv() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearIdfv();
                return this;
            }

            public Builder setIdfvBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIdfvBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasIdfa() {
                return ((AnalyticsData) this.instance).hasIdfa();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getIdfa() {
                return ((AnalyticsData) this.instance).getIdfa();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getIdfaBytes() {
                return ((AnalyticsData) this.instance).getIdfaBytes();
            }

            public Builder setIdfa(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIdfa(str);
                return this;
            }

            public Builder clearIdfa() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearIdfa();
                return this;
            }

            public Builder setIdfaBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setIdfaBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasAppstoreId() {
                return ((AnalyticsData) this.instance).hasAppstoreId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getAppstoreId() {
                return ((AnalyticsData) this.instance).getAppstoreId();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getAppstoreIdBytes() {
                return ((AnalyticsData) this.instance).getAppstoreIdBytes();
            }

            public Builder setAppstoreId(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppstoreId(str);
                return this;
            }

            public Builder clearAppstoreId() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAppstoreId();
                return this;
            }

            public Builder setAppstoreIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppstoreIdBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasPluginVersion() {
                return ((AnalyticsData) this.instance).hasPluginVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getPluginVersion() {
                return ((AnalyticsData) this.instance).getPluginVersion();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getPluginVersionBytes() {
                return ((AnalyticsData) this.instance).getPluginVersionBytes();
            }

            public Builder setPluginVersion(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPluginVersion(str);
                return this;
            }

            public Builder clearPluginVersion() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearPluginVersion();
                return this;
            }

            public Builder setPluginVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setPluginVersionBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<CountInfo> getCountWonReqList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getCountWonReqList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getCountWonReqCount() {
                return ((AnalyticsData) this.instance).getCountWonReqCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public CountInfo getCountWonReq(int i) {
                return ((AnalyticsData) this.instance).getCountWonReq(i);
            }

            public Builder setCountWonReq(int i, CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setCountWonReq(i, countInfo);
                return this;
            }

            public Builder setCountWonReq(int i, CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setCountWonReq(i, builder.build());
                return this;
            }

            public Builder addCountWonReq(CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountWonReq(countInfo);
                return this;
            }

            public Builder addCountWonReq(int i, CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountWonReq(i, countInfo);
                return this;
            }

            public Builder addCountWonReq(CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountWonReq(builder.build());
                return this;
            }

            public Builder addCountWonReq(int i, CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountWonReq(i, builder.build());
                return this;
            }

            public Builder addAllCountWonReq(Iterable<? extends CountInfo> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllCountWonReq(iterable);
                return this;
            }

            public Builder clearCountWonReq() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearCountWonReq();
                return this;
            }

            public Builder removeCountWonReq(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).removeCountWonReq(i);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<CountInfo> getCountClickList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getCountClickList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getCountClickCount() {
                return ((AnalyticsData) this.instance).getCountClickCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public CountInfo getCountClick(int i) {
                return ((AnalyticsData) this.instance).getCountClick(i);
            }

            public Builder setCountClick(int i, CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setCountClick(i, countInfo);
                return this;
            }

            public Builder setCountClick(int i, CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setCountClick(i, builder.build());
                return this;
            }

            public Builder addCountClick(CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountClick(countInfo);
                return this;
            }

            public Builder addCountClick(int i, CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountClick(i, countInfo);
                return this;
            }

            public Builder addCountClick(CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountClick(builder.build());
                return this;
            }

            public Builder addCountClick(int i, CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountClick(i, builder.build());
                return this;
            }

            public Builder addAllCountClick(Iterable<? extends CountInfo> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllCountClick(iterable);
                return this;
            }

            public Builder clearCountClick() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearCountClick();
                return this;
            }

            public Builder removeCountClick(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).removeCountClick(i);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public List<CountInfo> getCountImpList() {
                return Collections.unmodifiableList(((AnalyticsData) this.instance).getCountImpList());
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getCountImpCount() {
                return ((AnalyticsData) this.instance).getCountImpCount();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public CountInfo getCountImp(int i) {
                return ((AnalyticsData) this.instance).getCountImp(i);
            }

            public Builder setCountImp(int i, CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setCountImp(i, countInfo);
                return this;
            }

            public Builder setCountImp(int i, CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setCountImp(i, builder.build());
                return this;
            }

            public Builder addCountImp(CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountImp(countInfo);
                return this;
            }

            public Builder addCountImp(int i, CountInfo countInfo) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountImp(i, countInfo);
                return this;
            }

            public Builder addCountImp(CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountImp(builder.build());
                return this;
            }

            public Builder addCountImp(int i, CountInfo.Builder builder) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addCountImp(i, builder.build());
                return this;
            }

            public Builder addAllCountImp(Iterable<? extends CountInfo> iterable) {
                copyOnWrite();
                ((AnalyticsData) this.instance).addAllCountImp(iterable);
                return this;
            }

            public Builder clearCountImp() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearCountImp();
                return this;
            }

            public Builder removeCountImp(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).removeCountImp(i);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasAppsetIdScope() {
                return ((AnalyticsData) this.instance).hasAppsetIdScope();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public int getAppsetIdScope() {
                return ((AnalyticsData) this.instance).getAppsetIdScope();
            }

            public Builder setAppsetIdScope(int i) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setAppsetIdScope(i);
                return this;
            }

            public Builder clearAppsetIdScope() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearAppsetIdScope();
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasExtraSignals() {
                return ((AnalyticsData) this.instance).hasExtraSignals();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public String getExtraSignals() {
                return ((AnalyticsData) this.instance).getExtraSignals();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public ByteString getExtraSignalsBytes() {
                return ((AnalyticsData) this.instance).getExtraSignalsBytes();
            }

            public Builder setExtraSignals(String str) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setExtraSignals(str);
                return this;
            }

            public Builder clearExtraSignals() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearExtraSignals();
                return this;
            }

            public Builder setExtraSignalsBytes(ByteString byteString) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setExtraSignalsBytes(byteString);
                return this;
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public boolean hasBootTime() {
                return ((AnalyticsData) this.instance).hasBootTime();
            }

            @Override // adn.analytics.Analytics.AnalyticsDataOrBuilder
            public long getBootTime() {
                return ((AnalyticsData) this.instance).getBootTime();
            }

            public Builder setBootTime(long j) {
                copyOnWrite();
                ((AnalyticsData) this.instance).setBootTime(j);
                return this;
            }

            public Builder clearBootTime() {
                copyOnWrite();
                ((AnalyticsData) this.instance).clearBootTime();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AnalyticsData();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000N\u0000\u0002\u0001PN\u0000\b\u0000\u0001ለ\u0000\u0002ለ\u0001\u0003ለ\u0002\u0004ለ\u0003\u0005ለ\u0004\u0006င\u0005\u0007င\u0006\bለ\u0007\tለ\b\nင\t\u000bင\n\fဉ\u000b\rင\f\u000eင\r\u000fင\u000e\u0010ဉ\u000f\u0011င\u0010\u0012င\u0011\u0013င\u0012\u0014င\u0013\u0015င\u0014\u0016င\u0015\u0017ဉ\u0016\u0018ဉ\u0017\u0019ለ\u0018\u001aለ\u0019\u001bለ\u001a\u001cင\u001b\u001dဉ\u001c\u001e\u001b\u001f\u001b \u001b!င\u001d\"\u0004#ለ\u001e$\u001b%င\u001f&င 'ለ!(င\")င#*င$+ဂ%,ဂ&-င'.ለ(/ለ)0င*1\u00042\u00043ለ+4ለ,5Ȉ6Ȉ7\u00048Ȉ9Ȉ:င-;င.<င/=င0>င1?င2@ȚAȈBင3Cለ4Dለ5Eለ6Fለ7Gለ8Jለ9K\u001bL\u001bM\u001bNင:Oለ;Pဂ<", new Object[]{"bitField0_", "bitField1_", "unityVersion_", "vsauceVersion_", "sessionId_", "installDate_", "sessionStartDate_", "appOpenCountSinceInstall_", "sessionCountSinceInstall_", "vanUserId_", "mmpId_", "gameCountSinceInstall_", "gameCount_", "perfMetrics_", "gameCountSuccess_", "playTime_", "totalTime_", "attribution_", "fsLoadIndex_", "rvLoadIndex_", "fsCountSinceInstall_", "rvCountSinceInstall_", "fsClickCountSinceInstall_", "rvClickCountSinceInstall_", "revGen_", "revGenSinceInstall_", "vanImpressionId_", "vanFsImpressionId_", "vanRvImpressionId_", "countReq_", "hasLastClick_", "lastXSessionDesc_", AdInfo.class, "prevXSessionDesc_", AdInfo.class, "firstXSessionDesc_", AdInfo.class, "hasSkipPriorRv_", "adsConsentGiven_", "idfaAuthorizationStatus_", "purchaseSinceInstall_", Purchase.class, "isPremium_", "airplaneModeEnable_", "connectivity_", "battery_", "batterySaverEnable_", "battCharge_", "availableDiskSpace_", "totalDiskSpace_", "doNotDist_", "gaid_", "appsetId_", "limitAdTracking_", "globalTokenIndex_", "tokenIndex_", "utcDate_", "localDate_", "sdkVersion_", "appVersion_", "testMode_", "deviceModel_", "deviceManufacturer_", "bluetooth_", "darkModeEnable_", "headset_", "soundEnable_", "ppi_", "isWalking_", "keyboardLang_", "orientation_", "doNotSell_", "prevSessionStartDate_", "date_", "idfv_", "idfa_", "appstoreId_", "pluginVersion_", "countWonReq_", CountInfo.class, "countClick_", CountInfo.class, "countImp_", CountInfo.class, "appsetIdScope_", "extraSignals_", "bootTime_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AnalyticsData> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (AnalyticsData.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AnalyticsData analyticsData = new AnalyticsData();
            DEFAULT_INSTANCE = analyticsData;
            GeneratedMessageLite.registerDefaultInstance(AnalyticsData.class, analyticsData);
        }

        public static AnalyticsData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AnalyticsData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
