package io.bidmachine.protobuf;

import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.LazyStringArrayList;
import com.explorestack.protobuf.LazyStringList;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.ProtocolStringList;
import com.explorestack.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes8.dex */
public final class TokenConfiguration extends GeneratedMessageV3 implements TokenConfigurationOrBuilder {
    public static final int AD_NETWORKS_FIELD_NUMBER = 3;
    public static final int EXPIRATION_TIME_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private LazyStringList adNetworks_;
    private int expirationTime_;
    private byte memoizedIsInitialized;
    private volatile Object type_;
    private static final TokenConfiguration DEFAULT_INSTANCE = new TokenConfiguration();
    private static final Parser<TokenConfiguration> PARSER = new AbstractParser<TokenConfiguration>() { // from class: io.bidmachine.protobuf.TokenConfiguration.1
        @Override // com.explorestack.protobuf.Parser
        public TokenConfiguration parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TokenConfiguration(codedInputStream, extensionRegistryLite);
        }
    };

    private TokenConfiguration(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private TokenConfiguration() {
        this.memoizedIsInitialized = (byte) -1;
        this.type_ = "";
        this.adNetworks_ = LazyStringArrayList.EMPTY;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new TokenConfiguration();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private TokenConfiguration(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        extensionRegistryLite.getClass();
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            this.type_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 16) {
                            this.expirationTime_ = codedInputStream.readInt32();
                        } else if (readTag == 26) {
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            if (!z2) {
                                this.adNetworks_ = new LazyStringArrayList();
                                z2 = true;
                            }
                            this.adNetworks_.add(readStringRequireUtf8);
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
                if (z2) {
                    this.adNetworks_ = this.adNetworks_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return InitProto.internal_static_bidmachine_protobuf_TokenConfiguration_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return InitProto.internal_static_bidmachine_protobuf_TokenConfiguration_fieldAccessorTable.ensureFieldAccessorsInitialized(TokenConfiguration.class, Builder.class);
    }

    @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
    public String getType() {
        Object obj = this.type_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.type_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
    public ByteString getTypeBytes() {
        Object obj = this.type_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.type_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
    public int getExpirationTime() {
        return this.expirationTime_;
    }

    @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
    public ProtocolStringList getAdNetworksList() {
        return this.adNetworks_;
    }

    @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
    public int getAdNetworksCount() {
        return this.adNetworks_.size();
    }

    @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
    public String getAdNetworks(int i) {
        return (String) this.adNetworks_.get(i);
    }

    @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
    public ByteString getAdNetworksBytes(int i) {
        return this.adNetworks_.getByteString(i);
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
        if (!getTypeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.type_);
        }
        int i = this.expirationTime_;
        if (i != 0) {
            codedOutputStream.writeInt32(2, i);
        }
        for (int i2 = 0; i2 < this.adNetworks_.size(); i2++) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.adNetworks_.getRaw(i2));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getTypeBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.type_) : 0;
        int i2 = this.expirationTime_;
        if (i2 != 0) {
            computeStringSize += CodedOutputStream.computeInt32Size(2, i2);
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.adNetworks_.size(); i4++) {
            i3 += computeStringSizeNoTag(this.adNetworks_.getRaw(i4));
        }
        int size = computeStringSize + i3 + getAdNetworksList().size() + this.unknownFields.getSerializedSize();
        this.memoizedSize = size;
        return size;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenConfiguration)) {
            return super.equals(obj);
        }
        TokenConfiguration tokenConfiguration = (TokenConfiguration) obj;
        return getType().equals(tokenConfiguration.getType()) && getExpirationTime() == tokenConfiguration.getExpirationTime() && getAdNetworksList().equals(tokenConfiguration.getAdNetworksList()) && this.unknownFields.equals(tokenConfiguration.unknownFields);
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getType().hashCode()) * 37) + 2) * 53) + getExpirationTime();
        if (getAdNetworksCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getAdNetworksList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static TokenConfiguration parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TokenConfiguration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TokenConfiguration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TokenConfiguration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TokenConfiguration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TokenConfiguration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static TokenConfiguration parseFrom(InputStream inputStream) throws IOException {
        return (TokenConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TokenConfiguration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TokenConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TokenConfiguration parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TokenConfiguration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TokenConfiguration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TokenConfiguration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TokenConfiguration parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TokenConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TokenConfiguration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TokenConfiguration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TokenConfiguration tokenConfiguration) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(tokenConfiguration);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TokenConfigurationOrBuilder {
        private LazyStringList adNetworks_;
        private int bitField0_;
        private int expirationTime_;
        private Object type_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InitProto.internal_static_bidmachine_protobuf_TokenConfiguration_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InitProto.internal_static_bidmachine_protobuf_TokenConfiguration_fieldAccessorTable.ensureFieldAccessorsInitialized(TokenConfiguration.class, Builder.class);
        }

        private Builder() {
            this.type_ = "";
            this.adNetworks_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.type_ = "";
            this.adNetworks_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = TokenConfiguration.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.type_ = "";
            this.expirationTime_ = 0;
            this.adNetworks_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return InitProto.internal_static_bidmachine_protobuf_TokenConfiguration_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public TokenConfiguration getDefaultInstanceForType() {
            return TokenConfiguration.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public TokenConfiguration build() {
            TokenConfiguration buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public TokenConfiguration buildPartial() {
            TokenConfiguration tokenConfiguration = new TokenConfiguration(this);
            tokenConfiguration.type_ = this.type_;
            tokenConfiguration.expirationTime_ = this.expirationTime_;
            if ((this.bitField0_ & 1) != 0) {
                this.adNetworks_ = this.adNetworks_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            tokenConfiguration.adNetworks_ = this.adNetworks_;
            onBuilt();
            return tokenConfiguration;
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
            if (message instanceof TokenConfiguration) {
                return mergeFrom((TokenConfiguration) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(TokenConfiguration tokenConfiguration) {
            if (tokenConfiguration == TokenConfiguration.getDefaultInstance()) {
                return this;
            }
            if (!tokenConfiguration.getType().isEmpty()) {
                this.type_ = tokenConfiguration.type_;
                onChanged();
            }
            if (tokenConfiguration.getExpirationTime() != 0) {
                setExpirationTime(tokenConfiguration.getExpirationTime());
            }
            if (!tokenConfiguration.adNetworks_.isEmpty()) {
                if (this.adNetworks_.isEmpty()) {
                    this.adNetworks_ = tokenConfiguration.adNetworks_;
                    this.bitField0_ &= -2;
                } else {
                    ensureAdNetworksIsMutable();
                    this.adNetworks_.addAll(tokenConfiguration.adNetworks_);
                }
                onChanged();
            }
            mergeUnknownFields(tokenConfiguration.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            TokenConfiguration tokenConfiguration = null;
            try {
                try {
                    TokenConfiguration tokenConfiguration2 = (TokenConfiguration) TokenConfiguration.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (tokenConfiguration2 != null) {
                        mergeFrom(tokenConfiguration2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    TokenConfiguration tokenConfiguration3 = (TokenConfiguration) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        tokenConfiguration = tokenConfiguration3;
                        if (tokenConfiguration != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (tokenConfiguration != null) {
                    mergeFrom(tokenConfiguration);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setType(String str) {
            str.getClass();
            this.type_ = str;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = TokenConfiguration.getDefaultInstance().getType();
            onChanged();
            return this;
        }

        public Builder setTypeBytes(ByteString byteString) {
            byteString.getClass();
            TokenConfiguration.checkByteStringIsUtf8(byteString);
            this.type_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
        public int getExpirationTime() {
            return this.expirationTime_;
        }

        public Builder setExpirationTime(int i) {
            this.expirationTime_ = i;
            onChanged();
            return this;
        }

        public Builder clearExpirationTime() {
            this.expirationTime_ = 0;
            onChanged();
            return this;
        }

        private void ensureAdNetworksIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.adNetworks_ = new LazyStringArrayList(this.adNetworks_);
                this.bitField0_ |= 1;
            }
        }

        @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
        public ProtocolStringList getAdNetworksList() {
            return this.adNetworks_.getUnmodifiableView();
        }

        @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
        public int getAdNetworksCount() {
            return this.adNetworks_.size();
        }

        @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
        public String getAdNetworks(int i) {
            return (String) this.adNetworks_.get(i);
        }

        @Override // io.bidmachine.protobuf.TokenConfigurationOrBuilder
        public ByteString getAdNetworksBytes(int i) {
            return this.adNetworks_.getByteString(i);
        }

        public Builder setAdNetworks(int i, String str) {
            str.getClass();
            ensureAdNetworksIsMutable();
            this.adNetworks_.set(i, str);
            onChanged();
            return this;
        }

        public Builder addAdNetworks(String str) {
            str.getClass();
            ensureAdNetworksIsMutable();
            this.adNetworks_.add(str);
            onChanged();
            return this;
        }

        public Builder addAllAdNetworks(Iterable<String> iterable) {
            ensureAdNetworksIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.adNetworks_);
            onChanged();
            return this;
        }

        public Builder clearAdNetworks() {
            this.adNetworks_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder addAdNetworksBytes(ByteString byteString) {
            byteString.getClass();
            TokenConfiguration.checkByteStringIsUtf8(byteString);
            ensureAdNetworksIsMutable();
            this.adNetworks_.add(byteString);
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

    public static TokenConfiguration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TokenConfiguration> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<TokenConfiguration> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public TokenConfiguration getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
