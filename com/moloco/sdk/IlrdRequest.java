package com.moloco.sdk;

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

/* loaded from: classes6.dex */
public final class IlrdRequest {

    public interface ImpressionLevelRevenueOrBuilder extends MessageLiteOrBuilder {
        String getEventId();

        ByteString getEventIdBytes();

        LevelPlayImpression getLevelplay();

        MaxImpression getMax();

        ImpressionLevelRevenue.PlatformCase getPlatformCase();

        String getSessionId();

        ByteString getSessionIdBytes();

        boolean hasLevelplay();

        boolean hasMax();
    }

    public interface ImpressionRevenueRequestOrBuilder extends MessageLiteOrBuilder {
        String getDeviceId();

        ByteString getDeviceIdBytes();

        ImpressionLevelRevenue getEvents(int i);

        int getEventsCount();

        List<ImpressionLevelRevenue> getEventsList();

        String getIdfv();

        ByteString getIdfvBytes();

        String getOs();

        ByteString getOsBytes();

        String getPublisherAppId();

        ByteString getPublisherAppIdBytes();

        String getPublisherId();

        ByteString getPublisherIdBytes();
    }

    public interface LevelPlayImpressionOrBuilder extends MessageLiteOrBuilder {
        String getAb();

        ByteString getAbBytes();

        String getAdFormat();

        ByteString getAdFormatBytes();

        String getAuctionId();

        ByteString getAuctionIdBytes();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        String getCreativeId();

        ByteString getCreativeIdBytes();

        String getEncryptedCpm();

        ByteString getEncryptedCpmBytes();

        String getInstanceId();

        ByteString getInstanceIdBytes();

        String getInstanceName();

        ByteString getInstanceNameBytes();

        double getLifetimeRevenue();

        String getNetworkName();

        ByteString getNetworkNameBytes();

        String getPlacement();

        ByteString getPlacementBytes();

        String getPrecision();

        ByteString getPrecisionBytes();

        double getRevenue();

        String getSegmentName();

        ByteString getSegmentNameBytes();
    }

    public interface MaxImpressionOrBuilder extends MessageLiteOrBuilder {
        String getAdFormat();

        ByteString getAdFormatBytes();

        String getCountryCode();

        ByteString getCountryCodeBytes();

        String getId();

        ByteString getIdBytes();

        String getMaxAdUnitId();

        ByteString getMaxAdUnitIdBytes();

        String getNetworkName();

        ByteString getNetworkNameBytes();

        double getRevenue();

        String getThirdPartyAdPlacementId();

        ByteString getThirdPartyAdPlacementIdBytes();

        String getUserSegment();

        ByteString getUserSegmentBytes();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private IlrdRequest() {
    }

    public static final class ImpressionRevenueRequest extends GeneratedMessageLite<ImpressionRevenueRequest, Builder> implements ImpressionRevenueRequestOrBuilder {
        private static final ImpressionRevenueRequest DEFAULT_INSTANCE;
        public static final int DEVICE_ID_FIELD_NUMBER = 1;
        public static final int EVENTS_FIELD_NUMBER = 6;
        public static final int IDFV_FIELD_NUMBER = 2;
        public static final int OS_FIELD_NUMBER = 3;
        private static volatile Parser<ImpressionRevenueRequest> PARSER = null;
        public static final int PUBLISHER_APP_ID_FIELD_NUMBER = 5;
        public static final int PUBLISHER_ID_FIELD_NUMBER = 4;
        private String deviceId_ = "";
        private String idfv_ = "";
        private String os_ = "";
        private String publisherId_ = "";
        private String publisherAppId_ = "";
        private Internal.ProtobufList<ImpressionLevelRevenue> events_ = emptyProtobufList();

        private ImpressionRevenueRequest() {
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public ByteString getDeviceIdBytes() {
            return ByteString.copyFromUtf8(this.deviceId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public String getIdfv() {
            return this.idfv_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public ByteString getIdfvBytes() {
            return ByteString.copyFromUtf8(this.idfv_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfv(String str) {
            str.getClass();
            this.idfv_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdfv() {
            this.idfv_ = getDefaultInstance().getIdfv();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdfvBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.idfv_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public String getOs() {
            return this.os_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public ByteString getOsBytes() {
            return ByteString.copyFromUtf8(this.os_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOs(String str) {
            str.getClass();
            this.os_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOs() {
            this.os_ = getDefaultInstance().getOs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.os_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public String getPublisherId() {
            return this.publisherId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public ByteString getPublisherIdBytes() {
            return ByteString.copyFromUtf8(this.publisherId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublisherId(String str) {
            str.getClass();
            this.publisherId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublisherId() {
            this.publisherId_ = getDefaultInstance().getPublisherId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublisherIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.publisherId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public String getPublisherAppId() {
            return this.publisherAppId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public ByteString getPublisherAppIdBytes() {
            return ByteString.copyFromUtf8(this.publisherAppId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublisherAppId(String str) {
            str.getClass();
            this.publisherAppId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPublisherAppId() {
            this.publisherAppId_ = getDefaultInstance().getPublisherAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPublisherAppIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.publisherAppId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public List<ImpressionLevelRevenue> getEventsList() {
            return this.events_;
        }

        public List<? extends ImpressionLevelRevenueOrBuilder> getEventsOrBuilderList() {
            return this.events_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public int getEventsCount() {
            return this.events_.size();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
        public ImpressionLevelRevenue getEvents(int i) {
            return this.events_.get(i);
        }

        public ImpressionLevelRevenueOrBuilder getEventsOrBuilder(int i) {
            return this.events_.get(i);
        }

        private void ensureEventsIsMutable() {
            Internal.ProtobufList<ImpressionLevelRevenue> protobufList = this.events_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.events_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvents(int i, ImpressionLevelRevenue impressionLevelRevenue) {
            impressionLevelRevenue.getClass();
            ensureEventsIsMutable();
            this.events_.set(i, impressionLevelRevenue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(ImpressionLevelRevenue impressionLevelRevenue) {
            impressionLevelRevenue.getClass();
            ensureEventsIsMutable();
            this.events_.add(impressionLevelRevenue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(int i, ImpressionLevelRevenue impressionLevelRevenue) {
            impressionLevelRevenue.getClass();
            ensureEventsIsMutable();
            this.events_.add(i, impressionLevelRevenue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEvents(Iterable<? extends ImpressionLevelRevenue> iterable) {
            ensureEventsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.events_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEvents() {
            this.events_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEvents(int i) {
            ensureEventsIsMutable();
            this.events_.remove(i);
        }

        public static ImpressionRevenueRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ImpressionRevenueRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ImpressionRevenueRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ImpressionRevenueRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ImpressionRevenueRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ImpressionRevenueRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ImpressionRevenueRequest parseFrom(InputStream inputStream) throws IOException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ImpressionRevenueRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImpressionRevenueRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ImpressionRevenueRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ImpressionRevenueRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionRevenueRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImpressionRevenueRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ImpressionRevenueRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionRevenueRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ImpressionRevenueRequest impressionRevenueRequest) {
            return DEFAULT_INSTANCE.createBuilder(impressionRevenueRequest);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ImpressionRevenueRequest, Builder> implements ImpressionRevenueRequestOrBuilder {
            private Builder() {
                super(ImpressionRevenueRequest.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public String getDeviceId() {
                return ((ImpressionRevenueRequest) this.instance).getDeviceId();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public ByteString getDeviceIdBytes() {
                return ((ImpressionRevenueRequest) this.instance).getDeviceIdBytes();
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setDeviceId(str);
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).clearDeviceId();
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setDeviceIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public String getIdfv() {
                return ((ImpressionRevenueRequest) this.instance).getIdfv();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public ByteString getIdfvBytes() {
                return ((ImpressionRevenueRequest) this.instance).getIdfvBytes();
            }

            public Builder setIdfv(String str) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setIdfv(str);
                return this;
            }

            public Builder clearIdfv() {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).clearIdfv();
                return this;
            }

            public Builder setIdfvBytes(ByteString byteString) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setIdfvBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public String getOs() {
                return ((ImpressionRevenueRequest) this.instance).getOs();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public ByteString getOsBytes() {
                return ((ImpressionRevenueRequest) this.instance).getOsBytes();
            }

            public Builder setOs(String str) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setOs(str);
                return this;
            }

            public Builder clearOs() {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).clearOs();
                return this;
            }

            public Builder setOsBytes(ByteString byteString) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setOsBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public String getPublisherId() {
                return ((ImpressionRevenueRequest) this.instance).getPublisherId();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public ByteString getPublisherIdBytes() {
                return ((ImpressionRevenueRequest) this.instance).getPublisherIdBytes();
            }

            public Builder setPublisherId(String str) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setPublisherId(str);
                return this;
            }

            public Builder clearPublisherId() {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).clearPublisherId();
                return this;
            }

            public Builder setPublisherIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setPublisherIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public String getPublisherAppId() {
                return ((ImpressionRevenueRequest) this.instance).getPublisherAppId();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public ByteString getPublisherAppIdBytes() {
                return ((ImpressionRevenueRequest) this.instance).getPublisherAppIdBytes();
            }

            public Builder setPublisherAppId(String str) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setPublisherAppId(str);
                return this;
            }

            public Builder clearPublisherAppId() {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).clearPublisherAppId();
                return this;
            }

            public Builder setPublisherAppIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setPublisherAppIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public List<ImpressionLevelRevenue> getEventsList() {
                return Collections.unmodifiableList(((ImpressionRevenueRequest) this.instance).getEventsList());
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public int getEventsCount() {
                return ((ImpressionRevenueRequest) this.instance).getEventsCount();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionRevenueRequestOrBuilder
            public ImpressionLevelRevenue getEvents(int i) {
                return ((ImpressionRevenueRequest) this.instance).getEvents(i);
            }

            public Builder setEvents(int i, ImpressionLevelRevenue impressionLevelRevenue) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setEvents(i, impressionLevelRevenue);
                return this;
            }

            public Builder setEvents(int i, ImpressionLevelRevenue.Builder builder) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).setEvents(i, builder.build());
                return this;
            }

            public Builder addEvents(ImpressionLevelRevenue impressionLevelRevenue) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).addEvents(impressionLevelRevenue);
                return this;
            }

            public Builder addEvents(int i, ImpressionLevelRevenue impressionLevelRevenue) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).addEvents(i, impressionLevelRevenue);
                return this;
            }

            public Builder addEvents(ImpressionLevelRevenue.Builder builder) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).addEvents(builder.build());
                return this;
            }

            public Builder addEvents(int i, ImpressionLevelRevenue.Builder builder) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).addEvents(i, builder.build());
                return this;
            }

            public Builder addAllEvents(Iterable<? extends ImpressionLevelRevenue> iterable) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).addAllEvents(iterable);
                return this;
            }

            public Builder clearEvents() {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).clearEvents();
                return this;
            }

            public Builder removeEvents(int i) {
                copyOnWrite();
                ((ImpressionRevenueRequest) this.instance).removeEvents(i);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ImpressionRevenueRequest();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u001b", new Object[]{"deviceId_", "idfv_", "os_", "publisherId_", "publisherAppId_", "events_", ImpressionLevelRevenue.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ImpressionRevenueRequest> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ImpressionRevenueRequest.class) {
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
            ImpressionRevenueRequest impressionRevenueRequest = new ImpressionRevenueRequest();
            DEFAULT_INSTANCE = impressionRevenueRequest;
            GeneratedMessageLite.registerDefaultInstance(ImpressionRevenueRequest.class, impressionRevenueRequest);
        }

        public static ImpressionRevenueRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImpressionRevenueRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.moloco.sdk.IlrdRequest$1, reason: invalid class name */
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

    public static final class ImpressionLevelRevenue extends GeneratedMessageLite<ImpressionLevelRevenue, Builder> implements ImpressionLevelRevenueOrBuilder {
        private static final ImpressionLevelRevenue DEFAULT_INSTANCE;
        public static final int EVENT_ID_FIELD_NUMBER = 2;
        public static final int LEVELPLAY_FIELD_NUMBER = 4;
        public static final int MAX_FIELD_NUMBER = 3;
        private static volatile Parser<ImpressionLevelRevenue> PARSER = null;
        public static final int SESSION_ID_FIELD_NUMBER = 1;
        private Object platform_;
        private int platformCase_ = 0;
        private String sessionId_ = "";
        private String eventId_ = "";

        private ImpressionLevelRevenue() {
        }

        public enum PlatformCase {
            MAX(3),
            LEVELPLAY(4),
            PLATFORM_NOT_SET(0);

            private final int value;

            PlatformCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static PlatformCase valueOf(int i) {
                return forNumber(i);
            }

            public static PlatformCase forNumber(int i) {
                if (i == 0) {
                    return PLATFORM_NOT_SET;
                }
                if (i == 3) {
                    return MAX;
                }
                if (i != 4) {
                    return null;
                }
                return LEVELPLAY;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public PlatformCase getPlatformCase() {
            return PlatformCase.forNumber(this.platformCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlatform() {
            this.platformCase_ = 0;
            this.platform_ = null;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public String getSessionId() {
            return this.sessionId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public ByteString getSessionIdBytes() {
            return ByteString.copyFromUtf8(this.sessionId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionId(String str) {
            str.getClass();
            this.sessionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionId() {
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sessionId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public String getEventId() {
            return this.eventId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public ByteString getEventIdBytes() {
            return ByteString.copyFromUtf8(this.eventId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventId(String str) {
            str.getClass();
            this.eventId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventId() {
            this.eventId_ = getDefaultInstance().getEventId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.eventId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public boolean hasMax() {
            return this.platformCase_ == 3;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public MaxImpression getMax() {
            if (this.platformCase_ == 3) {
                return (MaxImpression) this.platform_;
            }
            return MaxImpression.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMax(MaxImpression maxImpression) {
            maxImpression.getClass();
            this.platform_ = maxImpression;
            this.platformCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMax(MaxImpression maxImpression) {
            maxImpression.getClass();
            if (this.platformCase_ == 3 && this.platform_ != MaxImpression.getDefaultInstance()) {
                this.platform_ = MaxImpression.newBuilder((MaxImpression) this.platform_).mergeFrom((MaxImpression.Builder) maxImpression).buildPartial();
            } else {
                this.platform_ = maxImpression;
            }
            this.platformCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMax() {
            if (this.platformCase_ == 3) {
                this.platformCase_ = 0;
                this.platform_ = null;
            }
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public boolean hasLevelplay() {
            return this.platformCase_ == 4;
        }

        @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
        public LevelPlayImpression getLevelplay() {
            if (this.platformCase_ == 4) {
                return (LevelPlayImpression) this.platform_;
            }
            return LevelPlayImpression.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLevelplay(LevelPlayImpression levelPlayImpression) {
            levelPlayImpression.getClass();
            this.platform_ = levelPlayImpression;
            this.platformCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLevelplay(LevelPlayImpression levelPlayImpression) {
            levelPlayImpression.getClass();
            if (this.platformCase_ == 4 && this.platform_ != LevelPlayImpression.getDefaultInstance()) {
                this.platform_ = LevelPlayImpression.newBuilder((LevelPlayImpression) this.platform_).mergeFrom((LevelPlayImpression.Builder) levelPlayImpression).buildPartial();
            } else {
                this.platform_ = levelPlayImpression;
            }
            this.platformCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLevelplay() {
            if (this.platformCase_ == 4) {
                this.platformCase_ = 0;
                this.platform_ = null;
            }
        }

        public static ImpressionLevelRevenue parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ImpressionLevelRevenue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ImpressionLevelRevenue parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ImpressionLevelRevenue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ImpressionLevelRevenue parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ImpressionLevelRevenue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ImpressionLevelRevenue parseFrom(InputStream inputStream) throws IOException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ImpressionLevelRevenue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImpressionLevelRevenue parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ImpressionLevelRevenue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ImpressionLevelRevenue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionLevelRevenue) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ImpressionLevelRevenue parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ImpressionLevelRevenue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionLevelRevenue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ImpressionLevelRevenue impressionLevelRevenue) {
            return DEFAULT_INSTANCE.createBuilder(impressionLevelRevenue);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ImpressionLevelRevenue, Builder> implements ImpressionLevelRevenueOrBuilder {
            private Builder() {
                super(ImpressionLevelRevenue.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public PlatformCase getPlatformCase() {
                return ((ImpressionLevelRevenue) this.instance).getPlatformCase();
            }

            public Builder clearPlatform() {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).clearPlatform();
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public String getSessionId() {
                return ((ImpressionLevelRevenue) this.instance).getSessionId();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public ByteString getSessionIdBytes() {
                return ((ImpressionLevelRevenue) this.instance).getSessionIdBytes();
            }

            public Builder setSessionId(String str) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setSessionId(str);
                return this;
            }

            public Builder clearSessionId() {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).clearSessionId();
                return this;
            }

            public Builder setSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setSessionIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public String getEventId() {
                return ((ImpressionLevelRevenue) this.instance).getEventId();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public ByteString getEventIdBytes() {
                return ((ImpressionLevelRevenue) this.instance).getEventIdBytes();
            }

            public Builder setEventId(String str) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setEventId(str);
                return this;
            }

            public Builder clearEventId() {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).clearEventId();
                return this;
            }

            public Builder setEventIdBytes(ByteString byteString) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setEventIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public boolean hasMax() {
                return ((ImpressionLevelRevenue) this.instance).hasMax();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public MaxImpression getMax() {
                return ((ImpressionLevelRevenue) this.instance).getMax();
            }

            public Builder setMax(MaxImpression maxImpression) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setMax(maxImpression);
                return this;
            }

            public Builder setMax(MaxImpression.Builder builder) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setMax(builder.build());
                return this;
            }

            public Builder mergeMax(MaxImpression maxImpression) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).mergeMax(maxImpression);
                return this;
            }

            public Builder clearMax() {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).clearMax();
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public boolean hasLevelplay() {
                return ((ImpressionLevelRevenue) this.instance).hasLevelplay();
            }

            @Override // com.moloco.sdk.IlrdRequest.ImpressionLevelRevenueOrBuilder
            public LevelPlayImpression getLevelplay() {
                return ((ImpressionLevelRevenue) this.instance).getLevelplay();
            }

            public Builder setLevelplay(LevelPlayImpression levelPlayImpression) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setLevelplay(levelPlayImpression);
                return this;
            }

            public Builder setLevelplay(LevelPlayImpression.Builder builder) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).setLevelplay(builder.build());
                return this;
            }

            public Builder mergeLevelplay(LevelPlayImpression levelPlayImpression) {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).mergeLevelplay(levelPlayImpression);
                return this;
            }

            public Builder clearLevelplay() {
                copyOnWrite();
                ((ImpressionLevelRevenue) this.instance).clearLevelplay();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ImpressionLevelRevenue();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003<\u0000\u0004<\u0000", new Object[]{"platform_", "platformCase_", "sessionId_", "eventId_", MaxImpression.class, LevelPlayImpression.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ImpressionLevelRevenue> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ImpressionLevelRevenue.class) {
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
            ImpressionLevelRevenue impressionLevelRevenue = new ImpressionLevelRevenue();
            DEFAULT_INSTANCE = impressionLevelRevenue;
            GeneratedMessageLite.registerDefaultInstance(ImpressionLevelRevenue.class, impressionLevelRevenue);
        }

        public static ImpressionLevelRevenue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImpressionLevelRevenue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class MaxImpression extends GeneratedMessageLite<MaxImpression, Builder> implements MaxImpressionOrBuilder {
        public static final int AD_FORMAT_FIELD_NUMBER = 1;
        public static final int COUNTRY_CODE_FIELD_NUMBER = 2;
        private static final MaxImpression DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 3;
        public static final int MAX_AD_UNIT_ID_FIELD_NUMBER = 4;
        public static final int NETWORK_NAME_FIELD_NUMBER = 5;
        private static volatile Parser<MaxImpression> PARSER = null;
        public static final int REVENUE_FIELD_NUMBER = 6;
        public static final int THIRD_PARTY_AD_PLACEMENT_ID_FIELD_NUMBER = 7;
        public static final int USER_SEGMENT_FIELD_NUMBER = 8;
        private double revenue_;
        private String adFormat_ = "";
        private String countryCode_ = "";
        private String id_ = "";
        private String maxAdUnitId_ = "";
        private String networkName_ = "";
        private String thirdPartyAdPlacementId_ = "";
        private String userSegment_ = "";

        private MaxImpression() {
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public String getAdFormat() {
            return this.adFormat_;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public ByteString getAdFormatBytes() {
            return ByteString.copyFromUtf8(this.adFormat_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdFormat(String str) {
            str.getClass();
            this.adFormat_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdFormat() {
            this.adFormat_ = getDefaultInstance().getAdFormat();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdFormatBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.adFormat_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public String getCountryCode() {
            return this.countryCode_;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public ByteString getCountryCodeBytes() {
            return ByteString.copyFromUtf8(this.countryCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCode(String str) {
            str.getClass();
            this.countryCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountryCode() {
            this.countryCode_ = getDefaultInstance().getCountryCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.countryCode_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public String getId() {
            return this.id_;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.id_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.id_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public String getMaxAdUnitId() {
            return this.maxAdUnitId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public ByteString getMaxAdUnitIdBytes() {
            return ByteString.copyFromUtf8(this.maxAdUnitId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaxAdUnitId(String str) {
            str.getClass();
            this.maxAdUnitId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMaxAdUnitId() {
            this.maxAdUnitId_ = getDefaultInstance().getMaxAdUnitId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaxAdUnitIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.maxAdUnitId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public String getNetworkName() {
            return this.networkName_;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public ByteString getNetworkNameBytes() {
            return ByteString.copyFromUtf8(this.networkName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkName(String str) {
            str.getClass();
            this.networkName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetworkName() {
            this.networkName_ = getDefaultInstance().getNetworkName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.networkName_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public double getRevenue() {
            return this.revenue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRevenue(double d) {
            this.revenue_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRevenue() {
            this.revenue_ = 0.0d;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public String getThirdPartyAdPlacementId() {
            return this.thirdPartyAdPlacementId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public ByteString getThirdPartyAdPlacementIdBytes() {
            return ByteString.copyFromUtf8(this.thirdPartyAdPlacementId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThirdPartyAdPlacementId(String str) {
            str.getClass();
            this.thirdPartyAdPlacementId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThirdPartyAdPlacementId() {
            this.thirdPartyAdPlacementId_ = getDefaultInstance().getThirdPartyAdPlacementId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThirdPartyAdPlacementIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.thirdPartyAdPlacementId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public String getUserSegment() {
            return this.userSegment_;
        }

        @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
        public ByteString getUserSegmentBytes() {
            return ByteString.copyFromUtf8(this.userSegment_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserSegment(String str) {
            str.getClass();
            this.userSegment_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUserSegment() {
            this.userSegment_ = getDefaultInstance().getUserSegment();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUserSegmentBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.userSegment_ = byteString.toStringUtf8();
        }

        public static MaxImpression parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MaxImpression parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MaxImpression parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MaxImpression parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MaxImpression parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MaxImpression parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MaxImpression parseFrom(InputStream inputStream) throws IOException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MaxImpression parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MaxImpression parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MaxImpression) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MaxImpression parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MaxImpression) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MaxImpression parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MaxImpression parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MaxImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MaxImpression maxImpression) {
            return DEFAULT_INSTANCE.createBuilder(maxImpression);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MaxImpression, Builder> implements MaxImpressionOrBuilder {
            private Builder() {
                super(MaxImpression.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public String getAdFormat() {
                return ((MaxImpression) this.instance).getAdFormat();
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public ByteString getAdFormatBytes() {
                return ((MaxImpression) this.instance).getAdFormatBytes();
            }

            public Builder setAdFormat(String str) {
                copyOnWrite();
                ((MaxImpression) this.instance).setAdFormat(str);
                return this;
            }

            public Builder clearAdFormat() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearAdFormat();
                return this;
            }

            public Builder setAdFormatBytes(ByteString byteString) {
                copyOnWrite();
                ((MaxImpression) this.instance).setAdFormatBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public String getCountryCode() {
                return ((MaxImpression) this.instance).getCountryCode();
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public ByteString getCountryCodeBytes() {
                return ((MaxImpression) this.instance).getCountryCodeBytes();
            }

            public Builder setCountryCode(String str) {
                copyOnWrite();
                ((MaxImpression) this.instance).setCountryCode(str);
                return this;
            }

            public Builder clearCountryCode() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearCountryCode();
                return this;
            }

            public Builder setCountryCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((MaxImpression) this.instance).setCountryCodeBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public String getId() {
                return ((MaxImpression) this.instance).getId();
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public ByteString getIdBytes() {
                return ((MaxImpression) this.instance).getIdBytes();
            }

            public Builder setId(String str) {
                copyOnWrite();
                ((MaxImpression) this.instance).setId(str);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearId();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                copyOnWrite();
                ((MaxImpression) this.instance).setIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public String getMaxAdUnitId() {
                return ((MaxImpression) this.instance).getMaxAdUnitId();
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public ByteString getMaxAdUnitIdBytes() {
                return ((MaxImpression) this.instance).getMaxAdUnitIdBytes();
            }

            public Builder setMaxAdUnitId(String str) {
                copyOnWrite();
                ((MaxImpression) this.instance).setMaxAdUnitId(str);
                return this;
            }

            public Builder clearMaxAdUnitId() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearMaxAdUnitId();
                return this;
            }

            public Builder setMaxAdUnitIdBytes(ByteString byteString) {
                copyOnWrite();
                ((MaxImpression) this.instance).setMaxAdUnitIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public String getNetworkName() {
                return ((MaxImpression) this.instance).getNetworkName();
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public ByteString getNetworkNameBytes() {
                return ((MaxImpression) this.instance).getNetworkNameBytes();
            }

            public Builder setNetworkName(String str) {
                copyOnWrite();
                ((MaxImpression) this.instance).setNetworkName(str);
                return this;
            }

            public Builder clearNetworkName() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearNetworkName();
                return this;
            }

            public Builder setNetworkNameBytes(ByteString byteString) {
                copyOnWrite();
                ((MaxImpression) this.instance).setNetworkNameBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public double getRevenue() {
                return ((MaxImpression) this.instance).getRevenue();
            }

            public Builder setRevenue(double d) {
                copyOnWrite();
                ((MaxImpression) this.instance).setRevenue(d);
                return this;
            }

            public Builder clearRevenue() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearRevenue();
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public String getThirdPartyAdPlacementId() {
                return ((MaxImpression) this.instance).getThirdPartyAdPlacementId();
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public ByteString getThirdPartyAdPlacementIdBytes() {
                return ((MaxImpression) this.instance).getThirdPartyAdPlacementIdBytes();
            }

            public Builder setThirdPartyAdPlacementId(String str) {
                copyOnWrite();
                ((MaxImpression) this.instance).setThirdPartyAdPlacementId(str);
                return this;
            }

            public Builder clearThirdPartyAdPlacementId() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearThirdPartyAdPlacementId();
                return this;
            }

            public Builder setThirdPartyAdPlacementIdBytes(ByteString byteString) {
                copyOnWrite();
                ((MaxImpression) this.instance).setThirdPartyAdPlacementIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public String getUserSegment() {
                return ((MaxImpression) this.instance).getUserSegment();
            }

            @Override // com.moloco.sdk.IlrdRequest.MaxImpressionOrBuilder
            public ByteString getUserSegmentBytes() {
                return ((MaxImpression) this.instance).getUserSegmentBytes();
            }

            public Builder setUserSegment(String str) {
                copyOnWrite();
                ((MaxImpression) this.instance).setUserSegment(str);
                return this;
            }

            public Builder clearUserSegment() {
                copyOnWrite();
                ((MaxImpression) this.instance).clearUserSegment();
                return this;
            }

            public Builder setUserSegmentBytes(ByteString byteString) {
                copyOnWrite();
                ((MaxImpression) this.instance).setUserSegmentBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MaxImpression();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0000\u0007Ȉ\bȈ", new Object[]{"adFormat_", "countryCode_", "id_", "maxAdUnitId_", "networkName_", "revenue_", "thirdPartyAdPlacementId_", "userSegment_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MaxImpression> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (MaxImpression.class) {
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
            MaxImpression maxImpression = new MaxImpression();
            DEFAULT_INSTANCE = maxImpression;
            GeneratedMessageLite.registerDefaultInstance(MaxImpression.class, maxImpression);
        }

        public static MaxImpression getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MaxImpression> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class LevelPlayImpression extends GeneratedMessageLite<LevelPlayImpression, Builder> implements LevelPlayImpressionOrBuilder {
        public static final int AB_FIELD_NUMBER = 10;
        public static final int AD_FORMAT_FIELD_NUMBER = 2;
        public static final int AUCTION_ID_FIELD_NUMBER = 1;
        public static final int COUNTRY_CODE_FIELD_NUMBER = 6;
        public static final int CREATIVE_ID_FIELD_NUMBER = 14;
        private static final LevelPlayImpression DEFAULT_INSTANCE;
        public static final int ENCRYPTED_CPM_FIELD_NUMBER = 13;
        public static final int INSTANCE_ID_FIELD_NUMBER = 5;
        public static final int INSTANCE_NAME_FIELD_NUMBER = 4;
        public static final int LIFETIME_REVENUE_FIELD_NUMBER = 12;
        public static final int NETWORK_NAME_FIELD_NUMBER = 3;
        private static volatile Parser<LevelPlayImpression> PARSER = null;
        public static final int PLACEMENT_FIELD_NUMBER = 7;
        public static final int PRECISION_FIELD_NUMBER = 9;
        public static final int REVENUE_FIELD_NUMBER = 8;
        public static final int SEGMENT_NAME_FIELD_NUMBER = 11;
        private double lifetimeRevenue_;
        private double revenue_;
        private String auctionId_ = "";
        private String adFormat_ = "";
        private String networkName_ = "";
        private String instanceName_ = "";
        private String instanceId_ = "";
        private String countryCode_ = "";
        private String placement_ = "";
        private String precision_ = "";
        private String ab_ = "";
        private String segmentName_ = "";
        private String encryptedCpm_ = "";
        private String creativeId_ = "";

        private LevelPlayImpression() {
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getAuctionId() {
            return this.auctionId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getAuctionIdBytes() {
            return ByteString.copyFromUtf8(this.auctionId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuctionId(String str) {
            str.getClass();
            this.auctionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAuctionId() {
            this.auctionId_ = getDefaultInstance().getAuctionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuctionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.auctionId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getAdFormat() {
            return this.adFormat_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getAdFormatBytes() {
            return ByteString.copyFromUtf8(this.adFormat_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdFormat(String str) {
            str.getClass();
            this.adFormat_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdFormat() {
            this.adFormat_ = getDefaultInstance().getAdFormat();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdFormatBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.adFormat_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getNetworkName() {
            return this.networkName_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getNetworkNameBytes() {
            return ByteString.copyFromUtf8(this.networkName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkName(String str) {
            str.getClass();
            this.networkName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetworkName() {
            this.networkName_ = getDefaultInstance().getNetworkName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetworkNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.networkName_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getInstanceName() {
            return this.instanceName_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getInstanceNameBytes() {
            return ByteString.copyFromUtf8(this.instanceName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstanceName(String str) {
            str.getClass();
            this.instanceName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInstanceName() {
            this.instanceName_ = getDefaultInstance().getInstanceName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstanceNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.instanceName_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getInstanceId() {
            return this.instanceId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getInstanceIdBytes() {
            return ByteString.copyFromUtf8(this.instanceId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstanceId(String str) {
            str.getClass();
            this.instanceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInstanceId() {
            this.instanceId_ = getDefaultInstance().getInstanceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstanceIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.instanceId_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getCountryCode() {
            return this.countryCode_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getCountryCodeBytes() {
            return ByteString.copyFromUtf8(this.countryCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCode(String str) {
            str.getClass();
            this.countryCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCountryCode() {
            this.countryCode_ = getDefaultInstance().getCountryCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCountryCodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.countryCode_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getPlacement() {
            return this.placement_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getPlacementBytes() {
            return ByteString.copyFromUtf8(this.placement_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlacement(String str) {
            str.getClass();
            this.placement_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlacement() {
            this.placement_ = getDefaultInstance().getPlacement();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlacementBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.placement_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public double getRevenue() {
            return this.revenue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRevenue(double d) {
            this.revenue_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRevenue() {
            this.revenue_ = 0.0d;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getPrecision() {
            return this.precision_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getPrecisionBytes() {
            return ByteString.copyFromUtf8(this.precision_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrecision(String str) {
            str.getClass();
            this.precision_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrecision() {
            this.precision_ = getDefaultInstance().getPrecision();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrecisionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.precision_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getAb() {
            return this.ab_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getAbBytes() {
            return ByteString.copyFromUtf8(this.ab_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAb(String str) {
            str.getClass();
            this.ab_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAb() {
            this.ab_ = getDefaultInstance().getAb();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAbBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.ab_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getSegmentName() {
            return this.segmentName_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getSegmentNameBytes() {
            return ByteString.copyFromUtf8(this.segmentName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSegmentName(String str) {
            str.getClass();
            this.segmentName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSegmentName() {
            this.segmentName_ = getDefaultInstance().getSegmentName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSegmentNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.segmentName_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public double getLifetimeRevenue() {
            return this.lifetimeRevenue_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLifetimeRevenue(double d) {
            this.lifetimeRevenue_ = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLifetimeRevenue() {
            this.lifetimeRevenue_ = 0.0d;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getEncryptedCpm() {
            return this.encryptedCpm_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getEncryptedCpmBytes() {
            return ByteString.copyFromUtf8(this.encryptedCpm_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncryptedCpm(String str) {
            str.getClass();
            this.encryptedCpm_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEncryptedCpm() {
            this.encryptedCpm_ = getDefaultInstance().getEncryptedCpm();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncryptedCpmBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.encryptedCpm_ = byteString.toStringUtf8();
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public String getCreativeId() {
            return this.creativeId_;
        }

        @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
        public ByteString getCreativeIdBytes() {
            return ByteString.copyFromUtf8(this.creativeId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreativeId(String str) {
            str.getClass();
            this.creativeId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreativeId() {
            this.creativeId_ = getDefaultInstance().getCreativeId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreativeIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.creativeId_ = byteString.toStringUtf8();
        }

        public static LevelPlayImpression parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static LevelPlayImpression parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static LevelPlayImpression parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static LevelPlayImpression parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static LevelPlayImpression parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static LevelPlayImpression parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static LevelPlayImpression parseFrom(InputStream inputStream) throws IOException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LevelPlayImpression parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LevelPlayImpression parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LevelPlayImpression) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static LevelPlayImpression parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LevelPlayImpression) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static LevelPlayImpression parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static LevelPlayImpression parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LevelPlayImpression) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LevelPlayImpression levelPlayImpression) {
            return DEFAULT_INSTANCE.createBuilder(levelPlayImpression);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LevelPlayImpression, Builder> implements LevelPlayImpressionOrBuilder {
            private Builder() {
                super(LevelPlayImpression.DEFAULT_INSTANCE);
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getAuctionId() {
                return ((LevelPlayImpression) this.instance).getAuctionId();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getAuctionIdBytes() {
                return ((LevelPlayImpression) this.instance).getAuctionIdBytes();
            }

            public Builder setAuctionId(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setAuctionId(str);
                return this;
            }

            public Builder clearAuctionId() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearAuctionId();
                return this;
            }

            public Builder setAuctionIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setAuctionIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getAdFormat() {
                return ((LevelPlayImpression) this.instance).getAdFormat();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getAdFormatBytes() {
                return ((LevelPlayImpression) this.instance).getAdFormatBytes();
            }

            public Builder setAdFormat(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setAdFormat(str);
                return this;
            }

            public Builder clearAdFormat() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearAdFormat();
                return this;
            }

            public Builder setAdFormatBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setAdFormatBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getNetworkName() {
                return ((LevelPlayImpression) this.instance).getNetworkName();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getNetworkNameBytes() {
                return ((LevelPlayImpression) this.instance).getNetworkNameBytes();
            }

            public Builder setNetworkName(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setNetworkName(str);
                return this;
            }

            public Builder clearNetworkName() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearNetworkName();
                return this;
            }

            public Builder setNetworkNameBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setNetworkNameBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getInstanceName() {
                return ((LevelPlayImpression) this.instance).getInstanceName();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getInstanceNameBytes() {
                return ((LevelPlayImpression) this.instance).getInstanceNameBytes();
            }

            public Builder setInstanceName(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setInstanceName(str);
                return this;
            }

            public Builder clearInstanceName() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearInstanceName();
                return this;
            }

            public Builder setInstanceNameBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setInstanceNameBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getInstanceId() {
                return ((LevelPlayImpression) this.instance).getInstanceId();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getInstanceIdBytes() {
                return ((LevelPlayImpression) this.instance).getInstanceIdBytes();
            }

            public Builder setInstanceId(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setInstanceId(str);
                return this;
            }

            public Builder clearInstanceId() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearInstanceId();
                return this;
            }

            public Builder setInstanceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setInstanceIdBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getCountryCode() {
                return ((LevelPlayImpression) this.instance).getCountryCode();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getCountryCodeBytes() {
                return ((LevelPlayImpression) this.instance).getCountryCodeBytes();
            }

            public Builder setCountryCode(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setCountryCode(str);
                return this;
            }

            public Builder clearCountryCode() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearCountryCode();
                return this;
            }

            public Builder setCountryCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setCountryCodeBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getPlacement() {
                return ((LevelPlayImpression) this.instance).getPlacement();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getPlacementBytes() {
                return ((LevelPlayImpression) this.instance).getPlacementBytes();
            }

            public Builder setPlacement(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setPlacement(str);
                return this;
            }

            public Builder clearPlacement() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearPlacement();
                return this;
            }

            public Builder setPlacementBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setPlacementBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public double getRevenue() {
                return ((LevelPlayImpression) this.instance).getRevenue();
            }

            public Builder setRevenue(double d) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setRevenue(d);
                return this;
            }

            public Builder clearRevenue() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearRevenue();
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getPrecision() {
                return ((LevelPlayImpression) this.instance).getPrecision();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getPrecisionBytes() {
                return ((LevelPlayImpression) this.instance).getPrecisionBytes();
            }

            public Builder setPrecision(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setPrecision(str);
                return this;
            }

            public Builder clearPrecision() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearPrecision();
                return this;
            }

            public Builder setPrecisionBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setPrecisionBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getAb() {
                return ((LevelPlayImpression) this.instance).getAb();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getAbBytes() {
                return ((LevelPlayImpression) this.instance).getAbBytes();
            }

            public Builder setAb(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setAb(str);
                return this;
            }

            public Builder clearAb() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearAb();
                return this;
            }

            public Builder setAbBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setAbBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getSegmentName() {
                return ((LevelPlayImpression) this.instance).getSegmentName();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getSegmentNameBytes() {
                return ((LevelPlayImpression) this.instance).getSegmentNameBytes();
            }

            public Builder setSegmentName(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setSegmentName(str);
                return this;
            }

            public Builder clearSegmentName() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearSegmentName();
                return this;
            }

            public Builder setSegmentNameBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setSegmentNameBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public double getLifetimeRevenue() {
                return ((LevelPlayImpression) this.instance).getLifetimeRevenue();
            }

            public Builder setLifetimeRevenue(double d) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setLifetimeRevenue(d);
                return this;
            }

            public Builder clearLifetimeRevenue() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearLifetimeRevenue();
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getEncryptedCpm() {
                return ((LevelPlayImpression) this.instance).getEncryptedCpm();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getEncryptedCpmBytes() {
                return ((LevelPlayImpression) this.instance).getEncryptedCpmBytes();
            }

            public Builder setEncryptedCpm(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setEncryptedCpm(str);
                return this;
            }

            public Builder clearEncryptedCpm() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearEncryptedCpm();
                return this;
            }

            public Builder setEncryptedCpmBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setEncryptedCpmBytes(byteString);
                return this;
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public String getCreativeId() {
                return ((LevelPlayImpression) this.instance).getCreativeId();
            }

            @Override // com.moloco.sdk.IlrdRequest.LevelPlayImpressionOrBuilder
            public ByteString getCreativeIdBytes() {
                return ((LevelPlayImpression) this.instance).getCreativeIdBytes();
            }

            public Builder setCreativeId(String str) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setCreativeId(str);
                return this;
            }

            public Builder clearCreativeId() {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).clearCreativeId();
                return this;
            }

            public Builder setCreativeIdBytes(ByteString byteString) {
                copyOnWrite();
                ((LevelPlayImpression) this.instance).setCreativeIdBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new LevelPlayImpression();
                case 2:
                    return new Builder();
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0000\u0001\u000e\u000e\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\u0000\tȈ\nȈ\u000bȈ\f\u0000\rȈ\u000eȈ", new Object[]{"auctionId_", "adFormat_", "networkName_", "instanceName_", "instanceId_", "countryCode_", "placement_", "revenue_", "precision_", "ab_", "segmentName_", "lifetimeRevenue_", "encryptedCpm_", "creativeId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LevelPlayImpression> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (LevelPlayImpression.class) {
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
            LevelPlayImpression levelPlayImpression = new LevelPlayImpression();
            DEFAULT_INSTANCE = levelPlayImpression;
            GeneratedMessageLite.registerDefaultInstance(LevelPlayImpression.class, levelPlayImpression);
        }

        public static LevelPlayImpression getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LevelPlayImpression> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
