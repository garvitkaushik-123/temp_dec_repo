package io.bidmachine.protobuf;

import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.MapEntry;
import com.explorestack.protobuf.MapField;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import com.explorestack.protobuf.UnknownFieldSet;
import com.explorestack.protobuf.WireFormat;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacementOrBuilder;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.protobuf.sdk.AppOrBuilder;
import io.bidmachine.protobuf.sdk.Device;
import io.bidmachine.protobuf.sdk.DeviceOrBuilder;
import io.bidmachine.protobuf.sdk.Placement;
import io.bidmachine.protobuf.sdk.PlacementOrBuilder;
import io.bidmachine.protobuf.sdk.SDK;
import io.bidmachine.protobuf.sdk.SDKOrBuilder;
import io.bidmachine.protobuf.sdk.Session;
import io.bidmachine.protobuf.sdk.User;
import io.bidmachine.protobuf.sdk.UserOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes8.dex */
public final class RequestTokenPayload extends GeneratedMessageV3 implements RequestTokenPayloadOrBuilder {
    public static final int AD_TYPE_FIELD_NUMBER = 10;
    public static final int APP_DATA_FIELD_NUMBER = 6;
    public static final int CUSTOM_DATA_FIELD_NUMBER = 4;
    public static final int DEVICE_DATA_FIELD_NUMBER = 3;
    public static final int EXT_FIELD_NUMBER = 7;
    public static final int HB_PLACEMENT_FIELD_NUMBER = 9;
    public static final int PLACEMENT_DATA_FIELD_NUMBER = 1;
    public static final int PLACEMENT_FIELD_NUMBER = 12;
    public static final int SESSION_DATA_FIELD_NUMBER = 2;
    public static final int SESSION_FIELD_NUMBER = 11;
    public static final int TOKEN_HASH_VALUE_FIELD_NUMBER = 8;
    public static final int USER_DATA_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private volatile Object adType_;
    private App appData_;
    private MapField<String, String> customData_;
    private Device deviceData_;
    private Struct ext_;
    private HeaderBiddingPlacement hbPlacement_;
    private byte memoizedIsInitialized;
    private SDK placementData_;
    private Placement placement_;
    private SessionData sessionData_;
    private io.bidmachine.protobuf.sdk.Session session_;
    private volatile Object tokenHashValue_;
    private User userData_;
    private static final RequestTokenPayload DEFAULT_INSTANCE = new RequestTokenPayload();
    private static final Parser<RequestTokenPayload> PARSER = new AbstractParser<RequestTokenPayload>() { // from class: io.bidmachine.protobuf.RequestTokenPayload.1
        @Override // com.explorestack.protobuf.Parser
        public RequestTokenPayload parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RequestTokenPayload(codedInputStream, extensionRegistryLite);
        }
    };

    public interface SessionDataOrBuilder extends MessageOrBuilder {
        boolean containsSessionPlacementData(String str);

        String getSessionId();

        ByteString getSessionIdBytes();

        @Deprecated
        Map<String, SessionData.SessionPlacementData> getSessionPlacementData();

        int getSessionPlacementDataCount();

        Map<String, SessionData.SessionPlacementData> getSessionPlacementDataMap();

        SessionData.SessionPlacementData getSessionPlacementDataOrDefault(String str, SessionData.SessionPlacementData sessionPlacementData);

        SessionData.SessionPlacementData getSessionPlacementDataOrThrow(String str);

        long getSessionduration();
    }

    private RequestTokenPayload(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private RequestTokenPayload() {
        this.memoizedIsInitialized = (byte) -1;
        this.tokenHashValue_ = "";
        this.adType_ = "";
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new RequestTokenPayload();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RequestTokenPayload(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        Object[] objArr = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                            case 10:
                                SDK sdk = this.placementData_;
                                SDK.Builder builder = sdk != null ? sdk.toBuilder() : null;
                                SDK sdk2 = (SDK) codedInputStream.readMessage(SDK.parser(), extensionRegistryLite);
                                this.placementData_ = sdk2;
                                if (builder != null) {
                                    builder.mergeFrom(sdk2);
                                    this.placementData_ = builder.buildPartial();
                                }
                            case 18:
                                SessionData sessionData = this.sessionData_;
                                SessionData.Builder builder2 = sessionData != null ? sessionData.toBuilder() : null;
                                SessionData sessionData2 = (SessionData) codedInputStream.readMessage(SessionData.parser(), extensionRegistryLite);
                                this.sessionData_ = sessionData2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(sessionData2);
                                    this.sessionData_ = builder2.buildPartial();
                                }
                            case 26:
                                Device device = this.deviceData_;
                                Device.Builder builder3 = device != null ? device.toBuilder() : null;
                                Device device2 = (Device) codedInputStream.readMessage(Device.parser(), extensionRegistryLite);
                                this.deviceData_ = device2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(device2);
                                    this.deviceData_ = builder3.buildPartial();
                                }
                            case 34:
                                if (objArr == false) {
                                    this.customData_ = MapField.newMapField(CustomDataDefaultEntryHolder.defaultEntry);
                                    objArr = true;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(CustomDataDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.customData_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                            case 42:
                                User user = this.userData_;
                                User.Builder builder4 = user != null ? user.toBuilder() : null;
                                User user2 = (User) codedInputStream.readMessage(User.parser(), extensionRegistryLite);
                                this.userData_ = user2;
                                if (builder4 != null) {
                                    builder4.mergeFrom(user2);
                                    this.userData_ = builder4.buildPartial();
                                }
                            case 50:
                                App app = this.appData_;
                                App.Builder builder5 = app != null ? app.toBuilder() : null;
                                App app2 = (App) codedInputStream.readMessage(App.parser(), extensionRegistryLite);
                                this.appData_ = app2;
                                if (builder5 != null) {
                                    builder5.mergeFrom(app2);
                                    this.appData_ = builder5.buildPartial();
                                }
                            case 58:
                                Struct struct = this.ext_;
                                Struct.Builder builder6 = struct != null ? struct.toBuilder() : null;
                                Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.ext_ = struct2;
                                if (builder6 != null) {
                                    builder6.mergeFrom(struct2);
                                    this.ext_ = builder6.buildPartial();
                                }
                            case 66:
                                this.tokenHashValue_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                HeaderBiddingPlacement headerBiddingPlacement = this.hbPlacement_;
                                HeaderBiddingPlacement.Builder builder7 = headerBiddingPlacement != null ? headerBiddingPlacement.toBuilder() : null;
                                HeaderBiddingPlacement headerBiddingPlacement2 = (HeaderBiddingPlacement) codedInputStream.readMessage(HeaderBiddingPlacement.parser(), extensionRegistryLite);
                                this.hbPlacement_ = headerBiddingPlacement2;
                                if (builder7 != null) {
                                    builder7.mergeFrom(headerBiddingPlacement2);
                                    this.hbPlacement_ = builder7.buildPartial();
                                }
                            case 82:
                                this.adType_ = codedInputStream.readStringRequireUtf8();
                            case 90:
                                io.bidmachine.protobuf.sdk.Session session = this.session_;
                                Session.Builder builder8 = session != null ? session.toBuilder() : null;
                                io.bidmachine.protobuf.sdk.Session session2 = (io.bidmachine.protobuf.sdk.Session) codedInputStream.readMessage(io.bidmachine.protobuf.sdk.Session.parser(), extensionRegistryLite);
                                this.session_ = session2;
                                if (builder8 != null) {
                                    builder8.mergeFrom(session2);
                                    this.session_ = builder8.buildPartial();
                                }
                            case 98:
                                Placement placement = this.placement_;
                                Placement.Builder builder9 = placement != null ? placement.toBuilder() : null;
                                Placement placement2 = (Placement) codedInputStream.readMessage(Placement.parser(), extensionRegistryLite);
                                this.placement_ = placement2;
                                if (builder9 != null) {
                                    builder9.mergeFrom(placement2);
                                    this.placement_ = builder9.buildPartial();
                                }
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    z = true;
                                }
                        }
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected MapField internalGetMapField(int i) {
        if (i == 4) {
            return internalGetCustomData();
        }
        throw new RuntimeException("Invalid map field number: " + i);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_fieldAccessorTable.ensureFieldAccessorsInitialized(RequestTokenPayload.class, Builder.class);
    }

    public static final class SessionData extends GeneratedMessageV3 implements SessionDataOrBuilder {
        private static final SessionData DEFAULT_INSTANCE = new SessionData();
        private static final Parser<SessionData> PARSER = new AbstractParser<SessionData>() { // from class: io.bidmachine.protobuf.RequestTokenPayload.SessionData.1
            @Override // com.explorestack.protobuf.Parser
            public SessionData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SessionData(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int SESSIONDURATION_FIELD_NUMBER = 2;
        public static final int SESSION_ID_FIELD_NUMBER = 1;
        public static final int SESSION_PLACEMENT_DATA_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object sessionId_;
        private MapField<String, SessionPlacementData> sessionPlacementData_;
        private long sessionduration_;

        public interface SessionPlacementDataOrBuilder extends MessageOrBuilder {
            float getClickrate();

            float getCompletionrate();

            int getImpdepth();

            String getLastadomain();

            ByteString getLastadomainBytes();

            String getLastbundle();

            ByteString getLastbundleBytes();

            boolean getLastclick();
        }

        private SessionData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SessionData() {
            this.memoizedIsInitialized = (byte) -1;
            this.sessionId_ = "";
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new SessionData();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SessionData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.sessionId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.sessionduration_ = codedInputStream.readUInt64();
                                } else if (readTag == 26) {
                                    if (!z2) {
                                        this.sessionPlacementData_ = MapField.newMapField(SessionPlacementDataDefaultEntryHolder.defaultEntry);
                                        z2 = true;
                                    }
                                    MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(SessionPlacementDataDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                    this.sessionPlacementData_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected MapField internalGetMapField(int i) {
            if (i == 3) {
                return internalGetSessionPlacementData();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionData.class, Builder.class);
        }

        public static final class SessionPlacementData extends GeneratedMessageV3 implements SessionPlacementDataOrBuilder {
            public static final int CLICKRATE_FIELD_NUMBER = 5;
            public static final int COMPLETIONRATE_FIELD_NUMBER = 7;
            public static final int IMPDEPTH_FIELD_NUMBER = 1;
            public static final int LASTADOMAIN_FIELD_NUMBER = 4;
            public static final int LASTBUNDLE_FIELD_NUMBER = 3;
            public static final int LASTCLICK_FIELD_NUMBER = 6;
            private static final long serialVersionUID = 0;
            private float clickrate_;
            private float completionrate_;
            private int impdepth_;
            private volatile Object lastadomain_;
            private volatile Object lastbundle_;
            private boolean lastclick_;
            private byte memoizedIsInitialized;
            private static final SessionPlacementData DEFAULT_INSTANCE = new SessionPlacementData();
            private static final Parser<SessionPlacementData> PARSER = new AbstractParser<SessionPlacementData>() { // from class: io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementData.1
                @Override // com.explorestack.protobuf.Parser
                public SessionPlacementData parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new SessionPlacementData(codedInputStream, extensionRegistryLite);
                }
            };

            private SessionPlacementData(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private SessionPlacementData() {
                this.memoizedIsInitialized = (byte) -1;
                this.lastbundle_ = "";
                this.lastadomain_ = "";
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new SessionPlacementData();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private SessionPlacementData(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                extensionRegistryLite.getClass();
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.impdepth_ = codedInputStream.readUInt32();
                                } else if (readTag == 26) {
                                    this.lastbundle_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 34) {
                                    this.lastadomain_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 45) {
                                    this.clickrate_ = codedInputStream.readFloat();
                                } else if (readTag == 48) {
                                    this.lastclick_ = codedInputStream.readBool();
                                } else if (readTag == 61) {
                                    this.completionrate_ = codedInputStream.readFloat();
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                        }
                    } finally {
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_SessionPlacementData_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_SessionPlacementData_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionPlacementData.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public int getImpdepth() {
                return this.impdepth_;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public String getLastbundle() {
                Object obj = this.lastbundle_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.lastbundle_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public ByteString getLastbundleBytes() {
                Object obj = this.lastbundle_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lastbundle_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public String getLastadomain() {
                Object obj = this.lastadomain_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.lastadomain_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public ByteString getLastadomainBytes() {
                Object obj = this.lastadomain_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lastadomain_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public float getClickrate() {
                return this.clickrate_;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public boolean getLastclick() {
                return this.lastclick_;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
            public float getCompletionrate() {
                return this.completionrate_;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b == 1) {
                    return true;
                }
                if (b == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i = this.impdepth_;
                if (i != 0) {
                    codedOutputStream.writeUInt32(1, i);
                }
                if (!getLastbundleBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 3, this.lastbundle_);
                }
                if (!getLastadomainBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 4, this.lastadomain_);
                }
                float f = this.clickrate_;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(5, f);
                }
                boolean z = this.lastclick_;
                if (z) {
                    codedOutputStream.writeBool(6, z);
                }
                float f2 = this.completionrate_;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(7, f2);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.impdepth_;
                int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) : 0;
                if (!getLastbundleBytes().isEmpty()) {
                    computeUInt32Size += GeneratedMessageV3.computeStringSize(3, this.lastbundle_);
                }
                if (!getLastadomainBytes().isEmpty()) {
                    computeUInt32Size += GeneratedMessageV3.computeStringSize(4, this.lastadomain_);
                }
                float f = this.clickrate_;
                if (f != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(5, f);
                }
                boolean z = this.lastclick_;
                if (z) {
                    computeUInt32Size += CodedOutputStream.computeBoolSize(6, z);
                }
                float f2 = this.completionrate_;
                if (f2 != 0.0f) {
                    computeUInt32Size += CodedOutputStream.computeFloatSize(7, f2);
                }
                int serializedSize = computeUInt32Size + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof SessionPlacementData)) {
                    return super.equals(obj);
                }
                SessionPlacementData sessionPlacementData = (SessionPlacementData) obj;
                return getImpdepth() == sessionPlacementData.getImpdepth() && getLastbundle().equals(sessionPlacementData.getLastbundle()) && getLastadomain().equals(sessionPlacementData.getLastadomain()) && Float.floatToIntBits(getClickrate()) == Float.floatToIntBits(sessionPlacementData.getClickrate()) && getLastclick() == sessionPlacementData.getLastclick() && Float.floatToIntBits(getCompletionrate()) == Float.floatToIntBits(sessionPlacementData.getCompletionrate()) && this.unknownFields.equals(sessionPlacementData.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getImpdepth()) * 37) + 3) * 53) + getLastbundle().hashCode()) * 37) + 4) * 53) + getLastadomain().hashCode()) * 37) + 5) * 53) + Float.floatToIntBits(getClickrate())) * 37) + 6) * 53) + Internal.hashBoolean(getLastclick())) * 37) + 7) * 53) + Float.floatToIntBits(getCompletionrate())) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode;
                return hashCode;
            }

            public static SessionPlacementData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static SessionPlacementData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static SessionPlacementData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static SessionPlacementData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static SessionPlacementData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static SessionPlacementData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static SessionPlacementData parseFrom(InputStream inputStream) throws IOException {
                return (SessionPlacementData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static SessionPlacementData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SessionPlacementData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static SessionPlacementData parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (SessionPlacementData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static SessionPlacementData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SessionPlacementData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static SessionPlacementData parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (SessionPlacementData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static SessionPlacementData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (SessionPlacementData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(SessionPlacementData sessionPlacementData) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(sessionPlacementData);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.explorestack.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent);
            }

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SessionPlacementDataOrBuilder {
                private float clickrate_;
                private float completionrate_;
                private int impdepth_;
                private Object lastadomain_;
                private Object lastbundle_;
                private boolean lastclick_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_SessionPlacementData_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_SessionPlacementData_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionPlacementData.class, Builder.class);
                }

                private Builder() {
                    this.lastbundle_ = "";
                    this.lastadomain_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.lastbundle_ = "";
                    this.lastadomain_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = SessionPlacementData.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.impdepth_ = 0;
                    this.lastbundle_ = "";
                    this.lastadomain_ = "";
                    this.clickrate_ = 0.0f;
                    this.lastclick_ = false;
                    this.completionrate_ = 0.0f;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_SessionPlacementData_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public SessionPlacementData getDefaultInstanceForType() {
                    return SessionPlacementData.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public SessionPlacementData build() {
                    SessionPlacementData buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public SessionPlacementData buildPartial() {
                    SessionPlacementData sessionPlacementData = new SessionPlacementData(this);
                    sessionPlacementData.impdepth_ = this.impdepth_;
                    sessionPlacementData.lastbundle_ = this.lastbundle_;
                    sessionPlacementData.lastadomain_ = this.lastadomain_;
                    sessionPlacementData.clickrate_ = this.clickrate_;
                    sessionPlacementData.lastclick_ = this.lastclick_;
                    sessionPlacementData.completionrate_ = this.completionrate_;
                    onBuilt();
                    return sessionPlacementData;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public Builder mo7073clone() {
                    return (Builder) super.mo7073clone();
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.setField(fieldDescriptor, obj);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                    return (Builder) super.clearOneof(oneofDescriptor);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                    return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public Builder mergeFrom(Message message) {
                    if (message instanceof SessionPlacementData) {
                        return mergeFrom((SessionPlacementData) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(SessionPlacementData sessionPlacementData) {
                    if (sessionPlacementData == SessionPlacementData.getDefaultInstance()) {
                        return this;
                    }
                    if (sessionPlacementData.getImpdepth() != 0) {
                        setImpdepth(sessionPlacementData.getImpdepth());
                    }
                    if (!sessionPlacementData.getLastbundle().isEmpty()) {
                        this.lastbundle_ = sessionPlacementData.lastbundle_;
                        onChanged();
                    }
                    if (!sessionPlacementData.getLastadomain().isEmpty()) {
                        this.lastadomain_ = sessionPlacementData.lastadomain_;
                        onChanged();
                    }
                    if (sessionPlacementData.getClickrate() != 0.0f) {
                        setClickrate(sessionPlacementData.getClickrate());
                    }
                    if (sessionPlacementData.getLastclick()) {
                        setLastclick(sessionPlacementData.getLastclick());
                    }
                    if (sessionPlacementData.getCompletionrate() != 0.0f) {
                        setCompletionrate(sessionPlacementData.getCompletionrate());
                    }
                    mergeUnknownFields(sessionPlacementData.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    SessionPlacementData sessionPlacementData = null;
                    try {
                        try {
                            SessionPlacementData sessionPlacementData2 = (SessionPlacementData) SessionPlacementData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (sessionPlacementData2 != null) {
                                mergeFrom(sessionPlacementData2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            SessionPlacementData sessionPlacementData3 = (SessionPlacementData) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                sessionPlacementData = sessionPlacementData3;
                                if (sessionPlacementData != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (sessionPlacementData != null) {
                            mergeFrom(sessionPlacementData);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public int getImpdepth() {
                    return this.impdepth_;
                }

                public Builder setImpdepth(int i) {
                    this.impdepth_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearImpdepth() {
                    this.impdepth_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public String getLastbundle() {
                    Object obj = this.lastbundle_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.lastbundle_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public ByteString getLastbundleBytes() {
                    Object obj = this.lastbundle_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.lastbundle_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setLastbundle(String str) {
                    str.getClass();
                    this.lastbundle_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearLastbundle() {
                    this.lastbundle_ = SessionPlacementData.getDefaultInstance().getLastbundle();
                    onChanged();
                    return this;
                }

                public Builder setLastbundleBytes(ByteString byteString) {
                    byteString.getClass();
                    SessionPlacementData.checkByteStringIsUtf8(byteString);
                    this.lastbundle_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public String getLastadomain() {
                    Object obj = this.lastadomain_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.lastadomain_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public ByteString getLastadomainBytes() {
                    Object obj = this.lastadomain_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.lastadomain_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setLastadomain(String str) {
                    str.getClass();
                    this.lastadomain_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearLastadomain() {
                    this.lastadomain_ = SessionPlacementData.getDefaultInstance().getLastadomain();
                    onChanged();
                    return this;
                }

                public Builder setLastadomainBytes(ByteString byteString) {
                    byteString.getClass();
                    SessionPlacementData.checkByteStringIsUtf8(byteString);
                    this.lastadomain_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public float getClickrate() {
                    return this.clickrate_;
                }

                public Builder setClickrate(float f) {
                    this.clickrate_ = f;
                    onChanged();
                    return this;
                }

                public Builder clearClickrate() {
                    this.clickrate_ = 0.0f;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public boolean getLastclick() {
                    return this.lastclick_;
                }

                public Builder setLastclick(boolean z) {
                    this.lastclick_ = z;
                    onChanged();
                    return this;
                }

                public Builder clearLastclick() {
                    this.lastclick_ = false;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionData.SessionPlacementDataOrBuilder
                public float getCompletionrate() {
                    return this.completionrate_;
                }

                public Builder setCompletionrate(float f) {
                    this.completionrate_ = f;
                    onChanged();
                    return this;
                }

                public Builder clearCompletionrate() {
                    this.completionrate_ = 0.0f;
                    onChanged();
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
                public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.setUnknownFields(unknownFieldSet);
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
                public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.mergeUnknownFields(unknownFieldSet);
                }
            }

            public static SessionPlacementData getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<SessionPlacementData> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<SessionPlacementData> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public SessionPlacementData getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public String getSessionId() {
            Object obj = this.sessionId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sessionId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public ByteString getSessionIdBytes() {
            Object obj = this.sessionId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sessionId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public long getSessionduration() {
            return this.sessionduration_;
        }

        private static final class SessionPlacementDataDefaultEntryHolder {
            static final MapEntry<String, SessionPlacementData> defaultEntry = MapEntry.newDefaultInstance(CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_SessionPlacementDataEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, SessionPlacementData.getDefaultInstance());

            private SessionPlacementDataDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, SessionPlacementData> internalGetSessionPlacementData() {
            MapField<String, SessionPlacementData> mapField = this.sessionPlacementData_;
            return mapField == null ? MapField.emptyMapField(SessionPlacementDataDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public int getSessionPlacementDataCount() {
            return internalGetSessionPlacementData().getMap().size();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public boolean containsSessionPlacementData(String str) {
            str.getClass();
            return internalGetSessionPlacementData().getMap().containsKey(str);
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        @Deprecated
        public Map<String, SessionPlacementData> getSessionPlacementData() {
            return getSessionPlacementDataMap();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public Map<String, SessionPlacementData> getSessionPlacementDataMap() {
            return internalGetSessionPlacementData().getMap();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public SessionPlacementData getSessionPlacementDataOrDefault(String str, SessionPlacementData sessionPlacementData) {
            str.getClass();
            Map<String, SessionPlacementData> map = internalGetSessionPlacementData().getMap();
            return map.containsKey(str) ? map.get(str) : sessionPlacementData;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
        public SessionPlacementData getSessionPlacementDataOrThrow(String str) {
            str.getClass();
            Map<String, SessionPlacementData> map = internalGetSessionPlacementData().getMap();
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return map.get(str);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getSessionIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.sessionId_);
            }
            long j = this.sessionduration_;
            if (j != 0) {
                codedOutputStream.writeUInt64(2, j);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetSessionPlacementData(), SessionPlacementDataDefaultEntryHolder.defaultEntry, 3);
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getSessionIdBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.sessionId_) : 0;
            long j = this.sessionduration_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeUInt64Size(2, j);
            }
            for (Map.Entry<String, SessionPlacementData> entry : internalGetSessionPlacementData().getMap().entrySet()) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, SessionPlacementDataDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SessionData)) {
                return super.equals(obj);
            }
            SessionData sessionData = (SessionData) obj;
            return getSessionId().equals(sessionData.getSessionId()) && getSessionduration() == sessionData.getSessionduration() && internalGetSessionPlacementData().equals(sessionData.internalGetSessionPlacementData()) && this.unknownFields.equals(sessionData.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSessionId().hashCode()) * 37) + 2) * 53) + Internal.hashLong(getSessionduration());
            if (!internalGetSessionPlacementData().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 3) * 53) + internalGetSessionPlacementData().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static SessionData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SessionData parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SessionData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SessionData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SessionData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SessionData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SessionData parseFrom(InputStream inputStream) throws IOException {
            return (SessionData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SessionData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionData) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SessionData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SessionData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SessionData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SessionData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionData) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SessionData sessionData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sessionData);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.explorestack.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SessionDataOrBuilder {
            private int bitField0_;
            private Object sessionId_;
            private MapField<String, SessionPlacementData> sessionPlacementData_;
            private long sessionduration_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMapField(int i) {
                if (i == 3) {
                    return internalGetSessionPlacementData();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMutableMapField(int i) {
                if (i == 3) {
                    return internalGetMutableSessionPlacementData();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionData.class, Builder.class);
            }

            private Builder() {
                this.sessionId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.sessionId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SessionData.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.sessionId_ = "";
                this.sessionduration_ = 0L;
                internalGetMutableSessionPlacementData().clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_SessionData_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public SessionData getDefaultInstanceForType() {
                return SessionData.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SessionData build() {
                SessionData buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SessionData buildPartial() {
                SessionData sessionData = new SessionData(this);
                sessionData.sessionId_ = this.sessionId_;
                sessionData.sessionduration_ = this.sessionduration_;
                sessionData.sessionPlacementData_ = internalGetSessionPlacementData();
                sessionData.sessionPlacementData_.makeImmutable();
                onBuilt();
                return sessionData;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo7073clone() {
                return (Builder) super.mo7073clone();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SessionData) {
                    return mergeFrom((SessionData) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SessionData sessionData) {
                if (sessionData == SessionData.getDefaultInstance()) {
                    return this;
                }
                if (!sessionData.getSessionId().isEmpty()) {
                    this.sessionId_ = sessionData.sessionId_;
                    onChanged();
                }
                if (sessionData.getSessionduration() != 0) {
                    setSessionduration(sessionData.getSessionduration());
                }
                internalGetMutableSessionPlacementData().mergeFrom(sessionData.internalGetSessionPlacementData());
                mergeUnknownFields(sessionData.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                SessionData sessionData = null;
                try {
                    try {
                        SessionData sessionData2 = (SessionData) SessionData.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (sessionData2 != null) {
                            mergeFrom(sessionData2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        SessionData sessionData3 = (SessionData) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            sessionData = sessionData3;
                            if (sessionData != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sessionData != null) {
                        mergeFrom(sessionData);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public String getSessionId() {
                Object obj = this.sessionId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.sessionId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public ByteString getSessionIdBytes() {
                Object obj = this.sessionId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sessionId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setSessionId(String str) {
                str.getClass();
                this.sessionId_ = str;
                onChanged();
                return this;
            }

            public Builder clearSessionId() {
                this.sessionId_ = SessionData.getDefaultInstance().getSessionId();
                onChanged();
                return this;
            }

            public Builder setSessionIdBytes(ByteString byteString) {
                byteString.getClass();
                SessionData.checkByteStringIsUtf8(byteString);
                this.sessionId_ = byteString;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public long getSessionduration() {
                return this.sessionduration_;
            }

            public Builder setSessionduration(long j) {
                this.sessionduration_ = j;
                onChanged();
                return this;
            }

            public Builder clearSessionduration() {
                this.sessionduration_ = 0L;
                onChanged();
                return this;
            }

            private MapField<String, SessionPlacementData> internalGetSessionPlacementData() {
                MapField<String, SessionPlacementData> mapField = this.sessionPlacementData_;
                return mapField == null ? MapField.emptyMapField(SessionPlacementDataDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<String, SessionPlacementData> internalGetMutableSessionPlacementData() {
                onChanged();
                if (this.sessionPlacementData_ == null) {
                    this.sessionPlacementData_ = MapField.newMapField(SessionPlacementDataDefaultEntryHolder.defaultEntry);
                }
                if (!this.sessionPlacementData_.isMutable()) {
                    this.sessionPlacementData_ = this.sessionPlacementData_.copy();
                }
                return this.sessionPlacementData_;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public int getSessionPlacementDataCount() {
                return internalGetSessionPlacementData().getMap().size();
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public boolean containsSessionPlacementData(String str) {
                str.getClass();
                return internalGetSessionPlacementData().getMap().containsKey(str);
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            @Deprecated
            public Map<String, SessionPlacementData> getSessionPlacementData() {
                return getSessionPlacementDataMap();
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public Map<String, SessionPlacementData> getSessionPlacementDataMap() {
                return internalGetSessionPlacementData().getMap();
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public SessionPlacementData getSessionPlacementDataOrDefault(String str, SessionPlacementData sessionPlacementData) {
                str.getClass();
                Map<String, SessionPlacementData> map = internalGetSessionPlacementData().getMap();
                return map.containsKey(str) ? map.get(str) : sessionPlacementData;
            }

            @Override // io.bidmachine.protobuf.RequestTokenPayload.SessionDataOrBuilder
            public SessionPlacementData getSessionPlacementDataOrThrow(String str) {
                str.getClass();
                Map<String, SessionPlacementData> map = internalGetSessionPlacementData().getMap();
                if (!map.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return map.get(str);
            }

            public Builder clearSessionPlacementData() {
                internalGetMutableSessionPlacementData().getMutableMap().clear();
                return this;
            }

            public Builder removeSessionPlacementData(String str) {
                str.getClass();
                internalGetMutableSessionPlacementData().getMutableMap().remove(str);
                return this;
            }

            @Deprecated
            public Map<String, SessionPlacementData> getMutableSessionPlacementData() {
                return internalGetMutableSessionPlacementData().getMutableMap();
            }

            public Builder putSessionPlacementData(String str, SessionPlacementData sessionPlacementData) {
                str.getClass();
                sessionPlacementData.getClass();
                internalGetMutableSessionPlacementData().getMutableMap().put(str, sessionPlacementData);
                return this;
            }

            public Builder putAllSessionPlacementData(Map<String, SessionPlacementData> map) {
                internalGetMutableSessionPlacementData().getMutableMap().putAll(map);
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }
        }

        public static SessionData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SessionData> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<SessionData> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public SessionData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public String getTokenHashValue() {
        Object obj = this.tokenHashValue_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.tokenHashValue_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public ByteString getTokenHashValueBytes() {
        Object obj = this.tokenHashValue_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.tokenHashValue_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public String getAdType() {
        Object obj = this.adType_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.adType_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public ByteString getAdTypeBytes() {
        Object obj = this.adType_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.adType_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public boolean hasPlacementData() {
        return this.placementData_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public SDK getPlacementData() {
        SDK sdk = this.placementData_;
        return sdk == null ? SDK.getDefaultInstance() : sdk;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public SDKOrBuilder getPlacementDataOrBuilder() {
        return getPlacementData();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public boolean hasSessionData() {
        return this.sessionData_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public SessionData getSessionData() {
        SessionData sessionData = this.sessionData_;
        return sessionData == null ? SessionData.getDefaultInstance() : sessionData;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public SessionDataOrBuilder getSessionDataOrBuilder() {
        return getSessionData();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public boolean hasSession() {
        return this.session_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public io.bidmachine.protobuf.sdk.Session getSession() {
        io.bidmachine.protobuf.sdk.Session session = this.session_;
        return session == null ? io.bidmachine.protobuf.sdk.Session.getDefaultInstance() : session;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public io.bidmachine.protobuf.sdk.SessionOrBuilder getSessionOrBuilder() {
        return getSession();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public boolean hasDeviceData() {
        return this.deviceData_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public Device getDeviceData() {
        Device device = this.deviceData_;
        return device == null ? Device.getDefaultInstance() : device;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public DeviceOrBuilder getDeviceDataOrBuilder() {
        return getDeviceData();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public boolean hasUserData() {
        return this.userData_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public User getUserData() {
        User user = this.userData_;
        return user == null ? User.getDefaultInstance() : user;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public UserOrBuilder getUserDataOrBuilder() {
        return getUserData();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public boolean hasAppData() {
        return this.appData_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public App getAppData() {
        App app = this.appData_;
        return app == null ? App.getDefaultInstance() : app;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public AppOrBuilder getAppDataOrBuilder() {
        return getAppData();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public boolean hasHbPlacement() {
        return this.hbPlacement_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public HeaderBiddingPlacement getHbPlacement() {
        HeaderBiddingPlacement headerBiddingPlacement = this.hbPlacement_;
        return headerBiddingPlacement == null ? HeaderBiddingPlacement.getDefaultInstance() : headerBiddingPlacement;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public HeaderBiddingPlacementOrBuilder getHbPlacementOrBuilder() {
        return getHbPlacement();
    }

    private static final class CustomDataDefaultEntryHolder {
        static final MapEntry<String, String> defaultEntry = MapEntry.newDefaultInstance(CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_CustomDataEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private CustomDataDefaultEntryHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapField<String, String> internalGetCustomData() {
        MapField<String, String> mapField = this.customData_;
        return mapField == null ? MapField.emptyMapField(CustomDataDefaultEntryHolder.defaultEntry) : mapField;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public int getCustomDataCount() {
        return internalGetCustomData().getMap().size();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public boolean containsCustomData(String str) {
        str.getClass();
        return internalGetCustomData().getMap().containsKey(str);
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public Map<String, String> getCustomData() {
        return getCustomDataMap();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public Map<String, String> getCustomDataMap() {
        return internalGetCustomData().getMap();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public String getCustomDataOrDefault(String str, String str2) {
        str.getClass();
        Map<String, String> map = internalGetCustomData().getMap();
        return map.containsKey(str) ? map.get(str) : str2;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    @Deprecated
    public String getCustomDataOrThrow(String str) {
        str.getClass();
        Map<String, String> map = internalGetCustomData().getMap();
        if (!map.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return map.get(str);
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public boolean hasPlacement() {
        return this.placement_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public Placement getPlacement() {
        Placement placement = this.placement_;
        return placement == null ? Placement.getDefaultInstance() : placement;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public PlacementOrBuilder getPlacementOrBuilder() {
        return getPlacement();
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public boolean hasExt() {
        return this.ext_ != null;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public Struct getExt() {
        Struct struct = this.ext_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
    public StructOrBuilder getExtOrBuilder() {
        return getExt();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.placementData_ != null) {
            codedOutputStream.writeMessage(1, getPlacementData());
        }
        if (this.sessionData_ != null) {
            codedOutputStream.writeMessage(2, getSessionData());
        }
        if (this.deviceData_ != null) {
            codedOutputStream.writeMessage(3, getDeviceData());
        }
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetCustomData(), CustomDataDefaultEntryHolder.defaultEntry, 4);
        if (this.userData_ != null) {
            codedOutputStream.writeMessage(5, getUserData());
        }
        if (this.appData_ != null) {
            codedOutputStream.writeMessage(6, getAppData());
        }
        if (this.ext_ != null) {
            codedOutputStream.writeMessage(7, getExt());
        }
        if (!getTokenHashValueBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.tokenHashValue_);
        }
        if (this.hbPlacement_ != null) {
            codedOutputStream.writeMessage(9, getHbPlacement());
        }
        if (!getAdTypeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.adType_);
        }
        if (this.session_ != null) {
            codedOutputStream.writeMessage(11, getSession());
        }
        if (this.placement_ != null) {
            codedOutputStream.writeMessage(12, getPlacement());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = this.placementData_ != null ? CodedOutputStream.computeMessageSize(1, getPlacementData()) : 0;
        if (this.sessionData_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, getSessionData());
        }
        if (this.deviceData_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getDeviceData());
        }
        for (Map.Entry<String, String> entry : internalGetCustomData().getMap().entrySet()) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, CustomDataDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        if (this.userData_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(5, getUserData());
        }
        if (this.appData_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(6, getAppData());
        }
        if (this.ext_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(7, getExt());
        }
        if (!getTokenHashValueBytes().isEmpty()) {
            computeMessageSize += GeneratedMessageV3.computeStringSize(8, this.tokenHashValue_);
        }
        if (this.hbPlacement_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(9, getHbPlacement());
        }
        if (!getAdTypeBytes().isEmpty()) {
            computeMessageSize += GeneratedMessageV3.computeStringSize(10, this.adType_);
        }
        if (this.session_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(11, getSession());
        }
        if (this.placement_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(12, getPlacement());
        }
        int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestTokenPayload)) {
            return super.equals(obj);
        }
        RequestTokenPayload requestTokenPayload = (RequestTokenPayload) obj;
        if (!getTokenHashValue().equals(requestTokenPayload.getTokenHashValue()) || !getAdType().equals(requestTokenPayload.getAdType()) || hasPlacementData() != requestTokenPayload.hasPlacementData()) {
            return false;
        }
        if ((hasPlacementData() && !getPlacementData().equals(requestTokenPayload.getPlacementData())) || hasSessionData() != requestTokenPayload.hasSessionData()) {
            return false;
        }
        if ((hasSessionData() && !getSessionData().equals(requestTokenPayload.getSessionData())) || hasSession() != requestTokenPayload.hasSession()) {
            return false;
        }
        if ((hasSession() && !getSession().equals(requestTokenPayload.getSession())) || hasDeviceData() != requestTokenPayload.hasDeviceData()) {
            return false;
        }
        if ((hasDeviceData() && !getDeviceData().equals(requestTokenPayload.getDeviceData())) || hasUserData() != requestTokenPayload.hasUserData()) {
            return false;
        }
        if ((hasUserData() && !getUserData().equals(requestTokenPayload.getUserData())) || hasAppData() != requestTokenPayload.hasAppData()) {
            return false;
        }
        if ((hasAppData() && !getAppData().equals(requestTokenPayload.getAppData())) || hasHbPlacement() != requestTokenPayload.hasHbPlacement()) {
            return false;
        }
        if ((hasHbPlacement() && !getHbPlacement().equals(requestTokenPayload.getHbPlacement())) || !internalGetCustomData().equals(requestTokenPayload.internalGetCustomData()) || hasPlacement() != requestTokenPayload.hasPlacement()) {
            return false;
        }
        if ((!hasPlacement() || getPlacement().equals(requestTokenPayload.getPlacement())) && hasExt() == requestTokenPayload.hasExt()) {
            return (!hasExt() || getExt().equals(requestTokenPayload.getExt())) && this.unknownFields.equals(requestTokenPayload.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 8) * 53) + getTokenHashValue().hashCode()) * 37) + 10) * 53) + getAdType().hashCode();
        if (hasPlacementData()) {
            hashCode = (((hashCode * 37) + 1) * 53) + getPlacementData().hashCode();
        }
        if (hasSessionData()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getSessionData().hashCode();
        }
        if (hasSession()) {
            hashCode = (((hashCode * 37) + 11) * 53) + getSession().hashCode();
        }
        if (hasDeviceData()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getDeviceData().hashCode();
        }
        if (hasUserData()) {
            hashCode = (((hashCode * 37) + 5) * 53) + getUserData().hashCode();
        }
        if (hasAppData()) {
            hashCode = (((hashCode * 37) + 6) * 53) + getAppData().hashCode();
        }
        if (hasHbPlacement()) {
            hashCode = (((hashCode * 37) + 9) * 53) + getHbPlacement().hashCode();
        }
        if (!internalGetCustomData().getMap().isEmpty()) {
            hashCode = (((hashCode * 37) + 4) * 53) + internalGetCustomData().hashCode();
        }
        if (hasPlacement()) {
            hashCode = (((hashCode * 37) + 12) * 53) + getPlacement().hashCode();
        }
        if (hasExt()) {
            hashCode = (((hashCode * 37) + 7) * 53) + getExt().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static RequestTokenPayload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static RequestTokenPayload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static RequestTokenPayload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static RequestTokenPayload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static RequestTokenPayload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RequestTokenPayload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RequestTokenPayload parseFrom(InputStream inputStream) throws IOException {
        return (RequestTokenPayload) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static RequestTokenPayload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestTokenPayload) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RequestTokenPayload parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RequestTokenPayload) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static RequestTokenPayload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestTokenPayload) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RequestTokenPayload parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RequestTokenPayload) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static RequestTokenPayload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestTokenPayload) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RequestTokenPayload requestTokenPayload) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(requestTokenPayload);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.explorestack.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestTokenPayloadOrBuilder {
        private Object adType_;
        private SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> appDataBuilder_;
        private App appData_;
        private int bitField0_;
        private MapField<String, String> customData_;
        private SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> deviceDataBuilder_;
        private Device deviceData_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> extBuilder_;
        private Struct ext_;
        private SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> hbPlacementBuilder_;
        private HeaderBiddingPlacement hbPlacement_;
        private SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> placementBuilder_;
        private SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> placementDataBuilder_;
        private SDK placementData_;
        private Placement placement_;
        private SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> sessionBuilder_;
        private SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> sessionDataBuilder_;
        private SessionData sessionData_;
        private io.bidmachine.protobuf.sdk.Session session_;
        private Object tokenHashValue_;
        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> userDataBuilder_;
        private User userData_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected MapField internalGetMapField(int i) {
            if (i == 4) {
                return internalGetCustomData();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected MapField internalGetMutableMapField(int i) {
            if (i == 4) {
                return internalGetMutableCustomData();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_fieldAccessorTable.ensureFieldAccessorsInitialized(RequestTokenPayload.class, Builder.class);
        }

        private Builder() {
            this.tokenHashValue_ = "";
            this.adType_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.tokenHashValue_ = "";
            this.adType_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = RequestTokenPayload.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.tokenHashValue_ = "";
            this.adType_ = "";
            if (this.placementDataBuilder_ == null) {
                this.placementData_ = null;
            } else {
                this.placementData_ = null;
                this.placementDataBuilder_ = null;
            }
            if (this.sessionDataBuilder_ == null) {
                this.sessionData_ = null;
            } else {
                this.sessionData_ = null;
                this.sessionDataBuilder_ = null;
            }
            if (this.sessionBuilder_ == null) {
                this.session_ = null;
            } else {
                this.session_ = null;
                this.sessionBuilder_ = null;
            }
            if (this.deviceDataBuilder_ == null) {
                this.deviceData_ = null;
            } else {
                this.deviceData_ = null;
                this.deviceDataBuilder_ = null;
            }
            if (this.userDataBuilder_ == null) {
                this.userData_ = null;
            } else {
                this.userData_ = null;
                this.userDataBuilder_ = null;
            }
            if (this.appDataBuilder_ == null) {
                this.appData_ = null;
            } else {
                this.appData_ = null;
                this.appDataBuilder_ = null;
            }
            if (this.hbPlacementBuilder_ == null) {
                this.hbPlacement_ = null;
            } else {
                this.hbPlacement_ = null;
                this.hbPlacementBuilder_ = null;
            }
            internalGetMutableCustomData().clear();
            if (this.placementBuilder_ == null) {
                this.placement_ = null;
            } else {
                this.placement_ = null;
                this.placementBuilder_ = null;
            }
            if (this.extBuilder_ == null) {
                this.ext_ = null;
                return this;
            }
            this.ext_ = null;
            this.extBuilder_ = null;
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CacheProto.internal_static_bidmachine_protobuf_RequestTokenPayload_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public RequestTokenPayload getDefaultInstanceForType() {
            return RequestTokenPayload.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public RequestTokenPayload build() {
            RequestTokenPayload buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public RequestTokenPayload buildPartial() {
            RequestTokenPayload requestTokenPayload = new RequestTokenPayload(this);
            requestTokenPayload.tokenHashValue_ = this.tokenHashValue_;
            requestTokenPayload.adType_ = this.adType_;
            SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> singleFieldBuilderV3 = this.placementDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                requestTokenPayload.placementData_ = this.placementData_;
            } else {
                requestTokenPayload.placementData_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> singleFieldBuilderV32 = this.sessionDataBuilder_;
            if (singleFieldBuilderV32 == null) {
                requestTokenPayload.sessionData_ = this.sessionData_;
            } else {
                requestTokenPayload.sessionData_ = singleFieldBuilderV32.build();
            }
            SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> singleFieldBuilderV33 = this.sessionBuilder_;
            if (singleFieldBuilderV33 == null) {
                requestTokenPayload.session_ = this.session_;
            } else {
                requestTokenPayload.session_ = singleFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> singleFieldBuilderV34 = this.deviceDataBuilder_;
            if (singleFieldBuilderV34 == null) {
                requestTokenPayload.deviceData_ = this.deviceData_;
            } else {
                requestTokenPayload.deviceData_ = singleFieldBuilderV34.build();
            }
            SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> singleFieldBuilderV35 = this.userDataBuilder_;
            if (singleFieldBuilderV35 == null) {
                requestTokenPayload.userData_ = this.userData_;
            } else {
                requestTokenPayload.userData_ = singleFieldBuilderV35.build();
            }
            SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> singleFieldBuilderV36 = this.appDataBuilder_;
            if (singleFieldBuilderV36 == null) {
                requestTokenPayload.appData_ = this.appData_;
            } else {
                requestTokenPayload.appData_ = singleFieldBuilderV36.build();
            }
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV37 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV37 == null) {
                requestTokenPayload.hbPlacement_ = this.hbPlacement_;
            } else {
                requestTokenPayload.hbPlacement_ = singleFieldBuilderV37.build();
            }
            requestTokenPayload.customData_ = internalGetCustomData();
            requestTokenPayload.customData_.makeImmutable();
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV38 = this.placementBuilder_;
            if (singleFieldBuilderV38 == null) {
                requestTokenPayload.placement_ = this.placement_;
            } else {
                requestTokenPayload.placement_ = singleFieldBuilderV38.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV39 = this.extBuilder_;
            if (singleFieldBuilderV39 == null) {
                requestTokenPayload.ext_ = this.ext_;
            } else {
                requestTokenPayload.ext_ = singleFieldBuilderV39.build();
            }
            onBuilt();
            return requestTokenPayload;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo7073clone() {
            return (Builder) super.mo7073clone();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof RequestTokenPayload) {
                return mergeFrom((RequestTokenPayload) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(RequestTokenPayload requestTokenPayload) {
            if (requestTokenPayload == RequestTokenPayload.getDefaultInstance()) {
                return this;
            }
            if (!requestTokenPayload.getTokenHashValue().isEmpty()) {
                this.tokenHashValue_ = requestTokenPayload.tokenHashValue_;
                onChanged();
            }
            if (!requestTokenPayload.getAdType().isEmpty()) {
                this.adType_ = requestTokenPayload.adType_;
                onChanged();
            }
            if (requestTokenPayload.hasPlacementData()) {
                mergePlacementData(requestTokenPayload.getPlacementData());
            }
            if (requestTokenPayload.hasSessionData()) {
                mergeSessionData(requestTokenPayload.getSessionData());
            }
            if (requestTokenPayload.hasSession()) {
                mergeSession(requestTokenPayload.getSession());
            }
            if (requestTokenPayload.hasDeviceData()) {
                mergeDeviceData(requestTokenPayload.getDeviceData());
            }
            if (requestTokenPayload.hasUserData()) {
                mergeUserData(requestTokenPayload.getUserData());
            }
            if (requestTokenPayload.hasAppData()) {
                mergeAppData(requestTokenPayload.getAppData());
            }
            if (requestTokenPayload.hasHbPlacement()) {
                mergeHbPlacement(requestTokenPayload.getHbPlacement());
            }
            internalGetMutableCustomData().mergeFrom(requestTokenPayload.internalGetCustomData());
            if (requestTokenPayload.hasPlacement()) {
                mergePlacement(requestTokenPayload.getPlacement());
            }
            if (requestTokenPayload.hasExt()) {
                mergeExt(requestTokenPayload.getExt());
            }
            mergeUnknownFields(requestTokenPayload.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RequestTokenPayload requestTokenPayload = null;
            try {
                try {
                    RequestTokenPayload requestTokenPayload2 = (RequestTokenPayload) RequestTokenPayload.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (requestTokenPayload2 != null) {
                        mergeFrom(requestTokenPayload2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    RequestTokenPayload requestTokenPayload3 = (RequestTokenPayload) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        requestTokenPayload = requestTokenPayload3;
                        if (requestTokenPayload != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (requestTokenPayload != null) {
                    mergeFrom(requestTokenPayload);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public String getTokenHashValue() {
            Object obj = this.tokenHashValue_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.tokenHashValue_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public ByteString getTokenHashValueBytes() {
            Object obj = this.tokenHashValue_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.tokenHashValue_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setTokenHashValue(String str) {
            str.getClass();
            this.tokenHashValue_ = str;
            onChanged();
            return this;
        }

        public Builder clearTokenHashValue() {
            this.tokenHashValue_ = RequestTokenPayload.getDefaultInstance().getTokenHashValue();
            onChanged();
            return this;
        }

        public Builder setTokenHashValueBytes(ByteString byteString) {
            byteString.getClass();
            RequestTokenPayload.checkByteStringIsUtf8(byteString);
            this.tokenHashValue_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public String getAdType() {
            Object obj = this.adType_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.adType_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public ByteString getAdTypeBytes() {
            Object obj = this.adType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.adType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Deprecated
        public Builder setAdType(String str) {
            str.getClass();
            this.adType_ = str;
            onChanged();
            return this;
        }

        @Deprecated
        public Builder clearAdType() {
            this.adType_ = RequestTokenPayload.getDefaultInstance().getAdType();
            onChanged();
            return this;
        }

        @Deprecated
        public Builder setAdTypeBytes(ByteString byteString) {
            byteString.getClass();
            RequestTokenPayload.checkByteStringIsUtf8(byteString);
            this.adType_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public boolean hasPlacementData() {
            return (this.placementDataBuilder_ == null && this.placementData_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public SDK getPlacementData() {
            SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> singleFieldBuilderV3 = this.placementDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                SDK sdk = this.placementData_;
                return sdk == null ? SDK.getDefaultInstance() : sdk;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setPlacementData(SDK sdk) {
            SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> singleFieldBuilderV3 = this.placementDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                sdk.getClass();
                this.placementData_ = sdk;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(sdk);
            return this;
        }

        public Builder setPlacementData(SDK.Builder builder) {
            SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> singleFieldBuilderV3 = this.placementDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.placementData_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergePlacementData(SDK sdk) {
            SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> singleFieldBuilderV3 = this.placementDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                SDK sdk2 = this.placementData_;
                if (sdk2 != null) {
                    this.placementData_ = SDK.newBuilder(sdk2).mergeFrom(sdk).buildPartial();
                } else {
                    this.placementData_ = sdk;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(sdk);
            return this;
        }

        public Builder clearPlacementData() {
            if (this.placementDataBuilder_ == null) {
                this.placementData_ = null;
                onChanged();
                return this;
            }
            this.placementData_ = null;
            this.placementDataBuilder_ = null;
            return this;
        }

        public SDK.Builder getPlacementDataBuilder() {
            onChanged();
            return getPlacementDataFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public SDKOrBuilder getPlacementDataOrBuilder() {
            SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> singleFieldBuilderV3 = this.placementDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SDK sdk = this.placementData_;
            return sdk == null ? SDK.getDefaultInstance() : sdk;
        }

        private SingleFieldBuilderV3<SDK, SDK.Builder, SDKOrBuilder> getPlacementDataFieldBuilder() {
            if (this.placementDataBuilder_ == null) {
                this.placementDataBuilder_ = new SingleFieldBuilderV3<>(getPlacementData(), getParentForChildren(), isClean());
                this.placementData_ = null;
            }
            return this.placementDataBuilder_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public boolean hasSessionData() {
            return (this.sessionDataBuilder_ == null && this.sessionData_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public SessionData getSessionData() {
            SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> singleFieldBuilderV3 = this.sessionDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                SessionData sessionData = this.sessionData_;
                return sessionData == null ? SessionData.getDefaultInstance() : sessionData;
            }
            return singleFieldBuilderV3.getMessage();
        }

        @Deprecated
        public Builder setSessionData(SessionData sessionData) {
            SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> singleFieldBuilderV3 = this.sessionDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                sessionData.getClass();
                this.sessionData_ = sessionData;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(sessionData);
            return this;
        }

        @Deprecated
        public Builder setSessionData(SessionData.Builder builder) {
            SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> singleFieldBuilderV3 = this.sessionDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.sessionData_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        @Deprecated
        public Builder mergeSessionData(SessionData sessionData) {
            SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> singleFieldBuilderV3 = this.sessionDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                SessionData sessionData2 = this.sessionData_;
                if (sessionData2 != null) {
                    this.sessionData_ = SessionData.newBuilder(sessionData2).mergeFrom(sessionData).buildPartial();
                } else {
                    this.sessionData_ = sessionData;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(sessionData);
            return this;
        }

        @Deprecated
        public Builder clearSessionData() {
            if (this.sessionDataBuilder_ == null) {
                this.sessionData_ = null;
                onChanged();
                return this;
            }
            this.sessionData_ = null;
            this.sessionDataBuilder_ = null;
            return this;
        }

        @Deprecated
        public SessionData.Builder getSessionDataBuilder() {
            onChanged();
            return getSessionDataFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public SessionDataOrBuilder getSessionDataOrBuilder() {
            SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> singleFieldBuilderV3 = this.sessionDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            SessionData sessionData = this.sessionData_;
            return sessionData == null ? SessionData.getDefaultInstance() : sessionData;
        }

        private SingleFieldBuilderV3<SessionData, SessionData.Builder, SessionDataOrBuilder> getSessionDataFieldBuilder() {
            if (this.sessionDataBuilder_ == null) {
                this.sessionDataBuilder_ = new SingleFieldBuilderV3<>(getSessionData(), getParentForChildren(), isClean());
                this.sessionData_ = null;
            }
            return this.sessionDataBuilder_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public boolean hasSession() {
            return (this.sessionBuilder_ == null && this.session_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public io.bidmachine.protobuf.sdk.Session getSession() {
            SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> singleFieldBuilderV3 = this.sessionBuilder_;
            if (singleFieldBuilderV3 == null) {
                io.bidmachine.protobuf.sdk.Session session = this.session_;
                return session == null ? io.bidmachine.protobuf.sdk.Session.getDefaultInstance() : session;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setSession(io.bidmachine.protobuf.sdk.Session session) {
            SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> singleFieldBuilderV3 = this.sessionBuilder_;
            if (singleFieldBuilderV3 == null) {
                session.getClass();
                this.session_ = session;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(session);
            return this;
        }

        public Builder setSession(Session.Builder builder) {
            SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> singleFieldBuilderV3 = this.sessionBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.session_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergeSession(io.bidmachine.protobuf.sdk.Session session) {
            SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> singleFieldBuilderV3 = this.sessionBuilder_;
            if (singleFieldBuilderV3 == null) {
                io.bidmachine.protobuf.sdk.Session session2 = this.session_;
                if (session2 != null) {
                    this.session_ = io.bidmachine.protobuf.sdk.Session.newBuilder(session2).mergeFrom(session).buildPartial();
                } else {
                    this.session_ = session;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(session);
            return this;
        }

        public Builder clearSession() {
            if (this.sessionBuilder_ == null) {
                this.session_ = null;
                onChanged();
                return this;
            }
            this.session_ = null;
            this.sessionBuilder_ = null;
            return this;
        }

        public Session.Builder getSessionBuilder() {
            onChanged();
            return getSessionFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public io.bidmachine.protobuf.sdk.SessionOrBuilder getSessionOrBuilder() {
            SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> singleFieldBuilderV3 = this.sessionBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            io.bidmachine.protobuf.sdk.Session session = this.session_;
            return session == null ? io.bidmachine.protobuf.sdk.Session.getDefaultInstance() : session;
        }

        private SingleFieldBuilderV3<io.bidmachine.protobuf.sdk.Session, Session.Builder, io.bidmachine.protobuf.sdk.SessionOrBuilder> getSessionFieldBuilder() {
            if (this.sessionBuilder_ == null) {
                this.sessionBuilder_ = new SingleFieldBuilderV3<>(getSession(), getParentForChildren(), isClean());
                this.session_ = null;
            }
            return this.sessionBuilder_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public boolean hasDeviceData() {
            return (this.deviceDataBuilder_ == null && this.deviceData_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public Device getDeviceData() {
            SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> singleFieldBuilderV3 = this.deviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Device device = this.deviceData_;
                return device == null ? Device.getDefaultInstance() : device;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setDeviceData(Device device) {
            SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> singleFieldBuilderV3 = this.deviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                device.getClass();
                this.deviceData_ = device;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(device);
            return this;
        }

        public Builder setDeviceData(Device.Builder builder) {
            SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> singleFieldBuilderV3 = this.deviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.deviceData_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergeDeviceData(Device device) {
            SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> singleFieldBuilderV3 = this.deviceDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Device device2 = this.deviceData_;
                if (device2 != null) {
                    this.deviceData_ = Device.newBuilder(device2).mergeFrom(device).buildPartial();
                } else {
                    this.deviceData_ = device;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(device);
            return this;
        }

        public Builder clearDeviceData() {
            if (this.deviceDataBuilder_ == null) {
                this.deviceData_ = null;
                onChanged();
                return this;
            }
            this.deviceData_ = null;
            this.deviceDataBuilder_ = null;
            return this;
        }

        public Device.Builder getDeviceDataBuilder() {
            onChanged();
            return getDeviceDataFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public DeviceOrBuilder getDeviceDataOrBuilder() {
            SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> singleFieldBuilderV3 = this.deviceDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Device device = this.deviceData_;
            return device == null ? Device.getDefaultInstance() : device;
        }

        private SingleFieldBuilderV3<Device, Device.Builder, DeviceOrBuilder> getDeviceDataFieldBuilder() {
            if (this.deviceDataBuilder_ == null) {
                this.deviceDataBuilder_ = new SingleFieldBuilderV3<>(getDeviceData(), getParentForChildren(), isClean());
                this.deviceData_ = null;
            }
            return this.deviceDataBuilder_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public boolean hasUserData() {
            return (this.userDataBuilder_ == null && this.userData_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public User getUserData() {
            SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> singleFieldBuilderV3 = this.userDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                User user = this.userData_;
                return user == null ? User.getDefaultInstance() : user;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setUserData(User user) {
            SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> singleFieldBuilderV3 = this.userDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                user.getClass();
                this.userData_ = user;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(user);
            return this;
        }

        public Builder setUserData(User.Builder builder) {
            SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> singleFieldBuilderV3 = this.userDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.userData_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergeUserData(User user) {
            SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> singleFieldBuilderV3 = this.userDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                User user2 = this.userData_;
                if (user2 != null) {
                    this.userData_ = User.newBuilder(user2).mergeFrom(user).buildPartial();
                } else {
                    this.userData_ = user;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(user);
            return this;
        }

        public Builder clearUserData() {
            if (this.userDataBuilder_ == null) {
                this.userData_ = null;
                onChanged();
                return this;
            }
            this.userData_ = null;
            this.userDataBuilder_ = null;
            return this;
        }

        public User.Builder getUserDataBuilder() {
            onChanged();
            return getUserDataFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public UserOrBuilder getUserDataOrBuilder() {
            SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> singleFieldBuilderV3 = this.userDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            User user = this.userData_;
            return user == null ? User.getDefaultInstance() : user;
        }

        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> getUserDataFieldBuilder() {
            if (this.userDataBuilder_ == null) {
                this.userDataBuilder_ = new SingleFieldBuilderV3<>(getUserData(), getParentForChildren(), isClean());
                this.userData_ = null;
            }
            return this.userDataBuilder_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public boolean hasAppData() {
            return (this.appDataBuilder_ == null && this.appData_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public App getAppData() {
            SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> singleFieldBuilderV3 = this.appDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                App app = this.appData_;
                return app == null ? App.getDefaultInstance() : app;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setAppData(App app) {
            SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> singleFieldBuilderV3 = this.appDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                app.getClass();
                this.appData_ = app;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(app);
            return this;
        }

        public Builder setAppData(App.Builder builder) {
            SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> singleFieldBuilderV3 = this.appDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.appData_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergeAppData(App app) {
            SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> singleFieldBuilderV3 = this.appDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                App app2 = this.appData_;
                if (app2 != null) {
                    this.appData_ = App.newBuilder(app2).mergeFrom(app).buildPartial();
                } else {
                    this.appData_ = app;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(app);
            return this;
        }

        public Builder clearAppData() {
            if (this.appDataBuilder_ == null) {
                this.appData_ = null;
                onChanged();
                return this;
            }
            this.appData_ = null;
            this.appDataBuilder_ = null;
            return this;
        }

        public App.Builder getAppDataBuilder() {
            onChanged();
            return getAppDataFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public AppOrBuilder getAppDataOrBuilder() {
            SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> singleFieldBuilderV3 = this.appDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            App app = this.appData_;
            return app == null ? App.getDefaultInstance() : app;
        }

        private SingleFieldBuilderV3<App, App.Builder, AppOrBuilder> getAppDataFieldBuilder() {
            if (this.appDataBuilder_ == null) {
                this.appDataBuilder_ = new SingleFieldBuilderV3<>(getAppData(), getParentForChildren(), isClean());
                this.appData_ = null;
            }
            return this.appDataBuilder_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public boolean hasHbPlacement() {
            return (this.hbPlacementBuilder_ == null && this.hbPlacement_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public HeaderBiddingPlacement getHbPlacement() {
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV3 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV3 == null) {
                HeaderBiddingPlacement headerBiddingPlacement = this.hbPlacement_;
                return headerBiddingPlacement == null ? HeaderBiddingPlacement.getDefaultInstance() : headerBiddingPlacement;
            }
            return singleFieldBuilderV3.getMessage();
        }

        @Deprecated
        public Builder setHbPlacement(HeaderBiddingPlacement headerBiddingPlacement) {
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV3 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV3 == null) {
                headerBiddingPlacement.getClass();
                this.hbPlacement_ = headerBiddingPlacement;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(headerBiddingPlacement);
            return this;
        }

        @Deprecated
        public Builder setHbPlacement(HeaderBiddingPlacement.Builder builder) {
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV3 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.hbPlacement_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        @Deprecated
        public Builder mergeHbPlacement(HeaderBiddingPlacement headerBiddingPlacement) {
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV3 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV3 == null) {
                HeaderBiddingPlacement headerBiddingPlacement2 = this.hbPlacement_;
                if (headerBiddingPlacement2 != null) {
                    this.hbPlacement_ = HeaderBiddingPlacement.newBuilder(headerBiddingPlacement2).mergeFrom(headerBiddingPlacement).buildPartial();
                } else {
                    this.hbPlacement_ = headerBiddingPlacement;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(headerBiddingPlacement);
            return this;
        }

        @Deprecated
        public Builder clearHbPlacement() {
            if (this.hbPlacementBuilder_ == null) {
                this.hbPlacement_ = null;
                onChanged();
                return this;
            }
            this.hbPlacement_ = null;
            this.hbPlacementBuilder_ = null;
            return this;
        }

        @Deprecated
        public HeaderBiddingPlacement.Builder getHbPlacementBuilder() {
            onChanged();
            return getHbPlacementFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public HeaderBiddingPlacementOrBuilder getHbPlacementOrBuilder() {
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV3 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            HeaderBiddingPlacement headerBiddingPlacement = this.hbPlacement_;
            return headerBiddingPlacement == null ? HeaderBiddingPlacement.getDefaultInstance() : headerBiddingPlacement;
        }

        private SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> getHbPlacementFieldBuilder() {
            if (this.hbPlacementBuilder_ == null) {
                this.hbPlacementBuilder_ = new SingleFieldBuilderV3<>(getHbPlacement(), getParentForChildren(), isClean());
                this.hbPlacement_ = null;
            }
            return this.hbPlacementBuilder_;
        }

        private MapField<String, String> internalGetCustomData() {
            MapField<String, String> mapField = this.customData_;
            return mapField == null ? MapField.emptyMapField(CustomDataDefaultEntryHolder.defaultEntry) : mapField;
        }

        private MapField<String, String> internalGetMutableCustomData() {
            onChanged();
            if (this.customData_ == null) {
                this.customData_ = MapField.newMapField(CustomDataDefaultEntryHolder.defaultEntry);
            }
            if (!this.customData_.isMutable()) {
                this.customData_ = this.customData_.copy();
            }
            return this.customData_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public int getCustomDataCount() {
            return internalGetCustomData().getMap().size();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public boolean containsCustomData(String str) {
            str.getClass();
            return internalGetCustomData().getMap().containsKey(str);
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public Map<String, String> getCustomData() {
            return getCustomDataMap();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public Map<String, String> getCustomDataMap() {
            return internalGetCustomData().getMap();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public String getCustomDataOrDefault(String str, String str2) {
            str.getClass();
            Map<String, String> map = internalGetCustomData().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        @Deprecated
        public String getCustomDataOrThrow(String str) {
            str.getClass();
            Map<String, String> map = internalGetCustomData().getMap();
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return map.get(str);
        }

        @Deprecated
        public Builder clearCustomData() {
            internalGetMutableCustomData().getMutableMap().clear();
            return this;
        }

        @Deprecated
        public Builder removeCustomData(String str) {
            str.getClass();
            internalGetMutableCustomData().getMutableMap().remove(str);
            return this;
        }

        @Deprecated
        public Map<String, String> getMutableCustomData() {
            return internalGetMutableCustomData().getMutableMap();
        }

        @Deprecated
        public Builder putCustomData(String str, String str2) {
            str.getClass();
            str2.getClass();
            internalGetMutableCustomData().getMutableMap().put(str, str2);
            return this;
        }

        @Deprecated
        public Builder putAllCustomData(Map<String, String> map) {
            internalGetMutableCustomData().getMutableMap().putAll(map);
            return this;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public boolean hasPlacement() {
            return (this.placementBuilder_ == null && this.placement_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public Placement getPlacement() {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.placementBuilder_;
            if (singleFieldBuilderV3 == null) {
                Placement placement = this.placement_;
                return placement == null ? Placement.getDefaultInstance() : placement;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setPlacement(Placement placement) {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.placementBuilder_;
            if (singleFieldBuilderV3 == null) {
                placement.getClass();
                this.placement_ = placement;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(placement);
            return this;
        }

        public Builder setPlacement(Placement.Builder builder) {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.placementBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.placement_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergePlacement(Placement placement) {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.placementBuilder_;
            if (singleFieldBuilderV3 == null) {
                Placement placement2 = this.placement_;
                if (placement2 != null) {
                    this.placement_ = Placement.newBuilder(placement2).mergeFrom(placement).buildPartial();
                } else {
                    this.placement_ = placement;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(placement);
            return this;
        }

        public Builder clearPlacement() {
            if (this.placementBuilder_ == null) {
                this.placement_ = null;
                onChanged();
                return this;
            }
            this.placement_ = null;
            this.placementBuilder_ = null;
            return this;
        }

        public Placement.Builder getPlacementBuilder() {
            onChanged();
            return getPlacementFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public PlacementOrBuilder getPlacementOrBuilder() {
            SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> singleFieldBuilderV3 = this.placementBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Placement placement = this.placement_;
            return placement == null ? Placement.getDefaultInstance() : placement;
        }

        private SingleFieldBuilderV3<Placement, Placement.Builder, PlacementOrBuilder> getPlacementFieldBuilder() {
            if (this.placementBuilder_ == null) {
                this.placementBuilder_ = new SingleFieldBuilderV3<>(getPlacement(), getParentForChildren(), isClean());
                this.placement_ = null;
            }
            return this.placementBuilder_;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public boolean hasExt() {
            return (this.extBuilder_ == null && this.ext_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public Struct getExt() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.ext_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setExt(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extBuilder_;
            if (singleFieldBuilderV3 == null) {
                struct.getClass();
                this.ext_ = struct;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(struct);
            return this;
        }

        public Builder setExt(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.ext_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergeExt(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.ext_;
                if (struct2 != null) {
                    this.ext_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.ext_ = struct;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(struct);
            return this;
        }

        public Builder clearExt() {
            if (this.extBuilder_ == null) {
                this.ext_ = null;
                onChanged();
                return this;
            }
            this.ext_ = null;
            this.extBuilder_ = null;
            return this;
        }

        public Struct.Builder getExtBuilder() {
            onChanged();
            return getExtFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.RequestTokenPayloadOrBuilder
        public StructOrBuilder getExtOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.extBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.ext_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getExtFieldBuilder() {
            if (this.extBuilder_ == null) {
                this.extBuilder_ = new SingleFieldBuilderV3<>(getExt(), getParentForChildren(), isClean());
                this.ext_ = null;
            }
            return this.extBuilder_;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static RequestTokenPayload getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RequestTokenPayload> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<RequestTokenPayload> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public RequestTokenPayload getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
