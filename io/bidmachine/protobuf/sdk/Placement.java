package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.StringValueOrBuilder;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.StructOrBuilder;
import com.explorestack.protobuf.UnknownFieldSet;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacementOrBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class Placement extends GeneratedMessageV3 implements PlacementOrBuilder {
    public static final int AD_TYPE_FIELD_NUMBER = 1;
    public static final int CUSTOM_DATA_FIELD_NUMBER = 3;
    public static final int HB_PLACEMENT_FIELD_NUMBER = 4;
    public static final int PLACEMENT_ID_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object adType_;
    private Struct customData_;
    private HeaderBiddingPlacement hbPlacement_;
    private byte memoizedIsInitialized;
    private StringValue placementId_;
    private static final Placement DEFAULT_INSTANCE = new Placement();
    private static final Parser<Placement> PARSER = new AbstractParser<Placement>() { // from class: io.bidmachine.protobuf.sdk.Placement.1
        @Override // com.explorestack.protobuf.Parser
        public Placement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Placement(codedInputStream, extensionRegistryLite);
        }
    };

    private Placement(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Placement() {
        this.memoizedIsInitialized = (byte) -1;
        this.adType_ = "";
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Placement();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private Placement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag != 10) {
                            if (readTag == 18) {
                                StringValue stringValue = this.placementId_;
                                StringValue.Builder builder = stringValue != null ? stringValue.toBuilder() : null;
                                StringValue stringValue2 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                this.placementId_ = stringValue2;
                                if (builder != null) {
                                    builder.mergeFrom(stringValue2);
                                    this.placementId_ = builder.buildPartial();
                                }
                            } else if (readTag == 26) {
                                Struct struct = this.customData_;
                                Struct.Builder builder2 = struct != null ? struct.toBuilder() : null;
                                Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.customData_ = struct2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(struct2);
                                    this.customData_ = builder2.buildPartial();
                                }
                            } else if (readTag == 34) {
                                HeaderBiddingPlacement headerBiddingPlacement = this.hbPlacement_;
                                HeaderBiddingPlacement.Builder builder3 = headerBiddingPlacement != null ? headerBiddingPlacement.toBuilder() : null;
                                HeaderBiddingPlacement headerBiddingPlacement2 = (HeaderBiddingPlacement) codedInputStream.readMessage(HeaderBiddingPlacement.parser(), extensionRegistryLite);
                                this.hbPlacement_ = headerBiddingPlacement2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(headerBiddingPlacement2);
                                    this.hbPlacement_ = builder3.buildPartial();
                                }
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.adType_ = codedInputStream.readStringRequireUtf8();
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
        return SDKProto.internal_static_bidmachine_protobuf_sdk_Placement_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SDKProto.internal_static_bidmachine_protobuf_sdk_Placement_fieldAccessorTable.ensureFieldAccessorsInitialized(Placement.class, Builder.class);
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public String getAdType() {
        Object obj = this.adType_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.adType_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public ByteString getAdTypeBytes() {
        Object obj = this.adType_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.adType_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public boolean hasPlacementId() {
        return this.placementId_ != null;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public StringValue getPlacementId() {
        StringValue stringValue = this.placementId_;
        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public StringValueOrBuilder getPlacementIdOrBuilder() {
        return getPlacementId();
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public boolean hasCustomData() {
        return this.customData_ != null;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public Struct getCustomData() {
        Struct struct = this.customData_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public StructOrBuilder getCustomDataOrBuilder() {
        return getCustomData();
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public boolean hasHbPlacement() {
        return this.hbPlacement_ != null;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public HeaderBiddingPlacement getHbPlacement() {
        HeaderBiddingPlacement headerBiddingPlacement = this.hbPlacement_;
        return headerBiddingPlacement == null ? HeaderBiddingPlacement.getDefaultInstance() : headerBiddingPlacement;
    }

    @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
    public HeaderBiddingPlacementOrBuilder getHbPlacementOrBuilder() {
        return getHbPlacement();
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
        if (!getAdTypeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.adType_);
        }
        if (this.placementId_ != null) {
            codedOutputStream.writeMessage(2, getPlacementId());
        }
        if (this.customData_ != null) {
            codedOutputStream.writeMessage(3, getCustomData());
        }
        if (this.hbPlacement_ != null) {
            codedOutputStream.writeMessage(4, getHbPlacement());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getAdTypeBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.adType_) : 0;
        if (this.placementId_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getPlacementId());
        }
        if (this.customData_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, getCustomData());
        }
        if (this.hbPlacement_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(4, getHbPlacement());
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
        if (!(obj instanceof Placement)) {
            return super.equals(obj);
        }
        Placement placement = (Placement) obj;
        if (!getAdType().equals(placement.getAdType()) || hasPlacementId() != placement.hasPlacementId()) {
            return false;
        }
        if ((hasPlacementId() && !getPlacementId().equals(placement.getPlacementId())) || hasCustomData() != placement.hasCustomData()) {
            return false;
        }
        if ((!hasCustomData() || getCustomData().equals(placement.getCustomData())) && hasHbPlacement() == placement.hasHbPlacement()) {
            return (!hasHbPlacement() || getHbPlacement().equals(placement.getHbPlacement())) && this.unknownFields.equals(placement.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getAdType().hashCode();
        if (hasPlacementId()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getPlacementId().hashCode();
        }
        if (hasCustomData()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getCustomData().hashCode();
        }
        if (hasHbPlacement()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getHbPlacement().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static Placement parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Placement parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Placement parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Placement parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Placement parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Placement parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Placement parseFrom(InputStream inputStream) throws IOException {
        return (Placement) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Placement parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Placement) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Placement parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Placement) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Placement parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Placement) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Placement parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Placement) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Placement parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Placement) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Placement placement) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(placement);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PlacementOrBuilder {
        private Object adType_;
        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> customDataBuilder_;
        private Struct customData_;
        private SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> hbPlacementBuilder_;
        private HeaderBiddingPlacement hbPlacement_;
        private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> placementIdBuilder_;
        private StringValue placementId_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SDKProto.internal_static_bidmachine_protobuf_sdk_Placement_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKProto.internal_static_bidmachine_protobuf_sdk_Placement_fieldAccessorTable.ensureFieldAccessorsInitialized(Placement.class, Builder.class);
        }

        private Builder() {
            this.adType_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.adType_ = "";
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = Placement.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.adType_ = "";
            if (this.placementIdBuilder_ == null) {
                this.placementId_ = null;
            } else {
                this.placementId_ = null;
                this.placementIdBuilder_ = null;
            }
            if (this.customDataBuilder_ == null) {
                this.customData_ = null;
            } else {
                this.customData_ = null;
                this.customDataBuilder_ = null;
            }
            if (this.hbPlacementBuilder_ == null) {
                this.hbPlacement_ = null;
                return this;
            }
            this.hbPlacement_ = null;
            this.hbPlacementBuilder_ = null;
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return SDKProto.internal_static_bidmachine_protobuf_sdk_Placement_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Placement getDefaultInstanceForType() {
            return Placement.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Placement build() {
            Placement buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Placement buildPartial() {
            Placement placement = new Placement(this);
            placement.adType_ = this.adType_;
            SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.placementIdBuilder_;
            if (singleFieldBuilderV3 == null) {
                placement.placementId_ = this.placementId_;
            } else {
                placement.placementId_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV32 = this.customDataBuilder_;
            if (singleFieldBuilderV32 == null) {
                placement.customData_ = this.customData_;
            } else {
                placement.customData_ = singleFieldBuilderV32.build();
            }
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV33 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV33 == null) {
                placement.hbPlacement_ = this.hbPlacement_;
            } else {
                placement.hbPlacement_ = singleFieldBuilderV33.build();
            }
            onBuilt();
            return placement;
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
            if (message instanceof Placement) {
                return mergeFrom((Placement) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Placement placement) {
            if (placement == Placement.getDefaultInstance()) {
                return this;
            }
            if (!placement.getAdType().isEmpty()) {
                this.adType_ = placement.adType_;
                onChanged();
            }
            if (placement.hasPlacementId()) {
                mergePlacementId(placement.getPlacementId());
            }
            if (placement.hasCustomData()) {
                mergeCustomData(placement.getCustomData());
            }
            if (placement.hasHbPlacement()) {
                mergeHbPlacement(placement.getHbPlacement());
            }
            mergeUnknownFields(placement.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Placement placement = null;
            try {
                try {
                    Placement placement2 = (Placement) Placement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (placement2 != null) {
                        mergeFrom(placement2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Placement placement3 = (Placement) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        placement = placement3;
                        if (placement != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (placement != null) {
                    mergeFrom(placement);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public String getAdType() {
            Object obj = this.adType_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.adType_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public ByteString getAdTypeBytes() {
            Object obj = this.adType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.adType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setAdType(String str) {
            str.getClass();
            this.adType_ = str;
            onChanged();
            return this;
        }

        public Builder clearAdType() {
            this.adType_ = Placement.getDefaultInstance().getAdType();
            onChanged();
            return this;
        }

        public Builder setAdTypeBytes(ByteString byteString) {
            byteString.getClass();
            Placement.checkByteStringIsUtf8(byteString);
            this.adType_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public boolean hasPlacementId() {
            return (this.placementIdBuilder_ == null && this.placementId_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public StringValue getPlacementId() {
            SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.placementIdBuilder_;
            if (singleFieldBuilderV3 == null) {
                StringValue stringValue = this.placementId_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setPlacementId(StringValue stringValue) {
            SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.placementIdBuilder_;
            if (singleFieldBuilderV3 == null) {
                stringValue.getClass();
                this.placementId_ = stringValue;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(stringValue);
            return this;
        }

        public Builder setPlacementId(StringValue.Builder builder) {
            SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.placementIdBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.placementId_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergePlacementId(StringValue stringValue) {
            SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.placementIdBuilder_;
            if (singleFieldBuilderV3 == null) {
                StringValue stringValue2 = this.placementId_;
                if (stringValue2 != null) {
                    this.placementId_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                } else {
                    this.placementId_ = stringValue;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(stringValue);
            return this;
        }

        public Builder clearPlacementId() {
            if (this.placementIdBuilder_ == null) {
                this.placementId_ = null;
                onChanged();
                return this;
            }
            this.placementId_ = null;
            this.placementIdBuilder_ = null;
            return this;
        }

        public StringValue.Builder getPlacementIdBuilder() {
            onChanged();
            return getPlacementIdFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public StringValueOrBuilder getPlacementIdOrBuilder() {
            SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.placementIdBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            StringValue stringValue = this.placementId_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getPlacementIdFieldBuilder() {
            if (this.placementIdBuilder_ == null) {
                this.placementIdBuilder_ = new SingleFieldBuilderV3<>(getPlacementId(), getParentForChildren(), isClean());
                this.placementId_ = null;
            }
            return this.placementIdBuilder_;
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public boolean hasCustomData() {
            return (this.customDataBuilder_ == null && this.customData_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public Struct getCustomData() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.customDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct = this.customData_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setCustomData(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.customDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                struct.getClass();
                this.customData_ = struct;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(struct);
            return this;
        }

        public Builder setCustomData(Struct.Builder builder) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.customDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.customData_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergeCustomData(Struct struct) {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.customDataBuilder_;
            if (singleFieldBuilderV3 == null) {
                Struct struct2 = this.customData_;
                if (struct2 != null) {
                    this.customData_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                } else {
                    this.customData_ = struct;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(struct);
            return this;
        }

        public Builder clearCustomData() {
            if (this.customDataBuilder_ == null) {
                this.customData_ = null;
                onChanged();
                return this;
            }
            this.customData_ = null;
            this.customDataBuilder_ = null;
            return this;
        }

        public Struct.Builder getCustomDataBuilder() {
            onChanged();
            return getCustomDataFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public StructOrBuilder getCustomDataOrBuilder() {
            SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.customDataBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Struct struct = this.customData_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getCustomDataFieldBuilder() {
            if (this.customDataBuilder_ == null) {
                this.customDataBuilder_ = new SingleFieldBuilderV3<>(getCustomData(), getParentForChildren(), isClean());
                this.customData_ = null;
            }
            return this.customDataBuilder_;
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public boolean hasHbPlacement() {
            return (this.hbPlacementBuilder_ == null && this.hbPlacement_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
        public HeaderBiddingPlacement getHbPlacement() {
            SingleFieldBuilderV3<HeaderBiddingPlacement, HeaderBiddingPlacement.Builder, HeaderBiddingPlacementOrBuilder> singleFieldBuilderV3 = this.hbPlacementBuilder_;
            if (singleFieldBuilderV3 == null) {
                HeaderBiddingPlacement headerBiddingPlacement = this.hbPlacement_;
                return headerBiddingPlacement == null ? HeaderBiddingPlacement.getDefaultInstance() : headerBiddingPlacement;
            }
            return singleFieldBuilderV3.getMessage();
        }

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

        public HeaderBiddingPlacement.Builder getHbPlacementBuilder() {
            onChanged();
            return getHbPlacementFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.PlacementOrBuilder
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

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }
    }

    public static Placement getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Placement> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<Placement> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public Placement getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
