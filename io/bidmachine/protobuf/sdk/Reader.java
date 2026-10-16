package io.bidmachine.protobuf.sdk;

import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.BoolValue;
import com.explorestack.protobuf.BoolValueOrBuilder;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.BytesValue;
import com.explorestack.protobuf.BytesValueOrBuilder;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.MessageLite;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.RepeatedFieldBuilderV3;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.StringValueOrBuilder;
import com.explorestack.protobuf.Timestamp;
import com.explorestack.protobuf.TimestampOrBuilder;
import com.explorestack.protobuf.UInt32Value;
import com.explorestack.protobuf.UInt32ValueOrBuilder;
import com.explorestack.protobuf.UnknownFieldSet;
import io.bidmachine.protobuf.sdk.Error;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class Reader extends GeneratedMessageV3 implements ReaderOrBuilder {
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int RECORDS_FIELD_NUMBER = 3;
    public static final int TIMESTAMP_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private List<Record> records_;
    private Timestamp timestamp_;
    private static final Reader DEFAULT_INSTANCE = new Reader();
    private static final Parser<Reader> PARSER = new AbstractParser<Reader>() { // from class: io.bidmachine.protobuf.sdk.Reader.1
        @Override // com.explorestack.protobuf.Parser
        public Reader parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Reader(codedInputStream, extensionRegistryLite);
        }
    };

    public interface ConfigurationOrBuilder extends MessageOrBuilder {
        StringValue getName();

        StringValueOrBuilder getNameOrBuilder();

        Rule getRules(int i);

        int getRulesCount();

        List<Rule> getRulesList();

        RuleOrBuilder getRulesOrBuilder(int i);

        List<? extends RuleOrBuilder> getRulesOrBuilderList();

        BoolValue getUniqueOnly();

        BoolValueOrBuilder getUniqueOnlyOrBuilder();

        UInt32Value getUpdateInterval();

        UInt32ValueOrBuilder getUpdateIntervalOrBuilder();

        StringValue getUrl();

        StringValueOrBuilder getUrlOrBuilder();

        boolean hasName();

        boolean hasUniqueOnly();

        boolean hasUpdateInterval();

        boolean hasUrl();
    }

    public interface RecordOrBuilder extends MessageOrBuilder {
        Error getError();

        ErrorOrBuilder getErrorOrBuilder();

        BytesValue getRawData();

        BytesValueOrBuilder getRawDataOrBuilder();

        Rule getRule();

        RuleOrBuilder getRuleOrBuilder();

        boolean hasError();

        boolean hasRawData();

        boolean hasRule();
    }

    public interface RuleOrBuilder extends MessageOrBuilder {
        Rule.GeneralRule getGeneralRule();

        Rule.GeneralRuleOrBuilder getGeneralRuleOrBuilder();

        Rule.IOSLogRule getIosLogRule();

        Rule.IOSLogRuleOrBuilder getIosLogRuleOrBuilder();

        Rule.RuleOneofCase getRuleOneofCase();

        boolean hasGeneralRule();

        boolean hasIosLogRule();
    }

    private Reader(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    private Reader() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.records_ = Collections.emptyList();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new Reader();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Reader(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            Timestamp timestamp = this.timestamp_;
                            Timestamp.Builder builder = timestamp != null ? timestamp.toBuilder() : null;
                            Timestamp timestamp2 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                            this.timestamp_ = timestamp2;
                            if (builder != null) {
                                builder.mergeFrom(timestamp2);
                                this.timestamp_ = builder.buildPartial();
                            }
                        } else if (readTag == 26) {
                            if (!z2) {
                                this.records_ = new ArrayList();
                                z2 = true;
                            }
                            this.records_.add(codedInputStream.readMessage(Record.parser(), extensionRegistryLite));
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
                    this.records_ = Collections.unmodifiableList(this.records_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_fieldAccessorTable.ensureFieldAccessorsInitialized(Reader.class, Builder.class);
    }

    public static final class Configuration extends GeneratedMessageV3 implements ConfigurationOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int RULES_FIELD_NUMBER = 5;
        public static final int UNIQUE_ONLY_FIELD_NUMBER = 4;
        public static final int UPDATE_INTERVAL_FIELD_NUMBER = 3;
        public static final int URL_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private StringValue name_;
        private List<Rule> rules_;
        private BoolValue uniqueOnly_;
        private UInt32Value updateInterval_;
        private StringValue url_;
        private static final Configuration DEFAULT_INSTANCE = new Configuration();
        private static final Parser<Configuration> PARSER = new AbstractParser<Configuration>() { // from class: io.bidmachine.protobuf.sdk.Reader.Configuration.1
            @Override // com.explorestack.protobuf.Parser
            public Configuration parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Configuration(codedInputStream, extensionRegistryLite);
            }
        };

        private Configuration(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Configuration() {
            this.memoizedIsInitialized = (byte) -1;
            this.rules_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Configuration();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Configuration(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            Object[] objArr = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                StringValue stringValue = this.name_;
                                StringValue.Builder builder = stringValue != null ? stringValue.toBuilder() : null;
                                StringValue stringValue2 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                this.name_ = stringValue2;
                                if (builder != null) {
                                    builder.mergeFrom(stringValue2);
                                    this.name_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                StringValue stringValue3 = this.url_;
                                StringValue.Builder builder2 = stringValue3 != null ? stringValue3.toBuilder() : null;
                                StringValue stringValue4 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                this.url_ = stringValue4;
                                if (builder2 != null) {
                                    builder2.mergeFrom(stringValue4);
                                    this.url_ = builder2.buildPartial();
                                }
                            } else if (readTag == 26) {
                                UInt32Value uInt32Value = this.updateInterval_;
                                UInt32Value.Builder builder3 = uInt32Value != null ? uInt32Value.toBuilder() : null;
                                UInt32Value uInt32Value2 = (UInt32Value) codedInputStream.readMessage(UInt32Value.parser(), extensionRegistryLite);
                                this.updateInterval_ = uInt32Value2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(uInt32Value2);
                                    this.updateInterval_ = builder3.buildPartial();
                                }
                            } else if (readTag == 34) {
                                BoolValue boolValue = this.uniqueOnly_;
                                BoolValue.Builder builder4 = boolValue != null ? boolValue.toBuilder() : null;
                                BoolValue boolValue2 = (BoolValue) codedInputStream.readMessage(BoolValue.parser(), extensionRegistryLite);
                                this.uniqueOnly_ = boolValue2;
                                if (builder4 != null) {
                                    builder4.mergeFrom(boolValue2);
                                    this.uniqueOnly_ = builder4.buildPartial();
                                }
                            } else if (readTag == 42) {
                                if (objArr == false) {
                                    this.rules_ = new ArrayList();
                                    objArr = true;
                                }
                                this.rules_.add(codedInputStream.readMessage(Rule.parser(), extensionRegistryLite));
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
                    if (objArr != false) {
                        this.rules_ = Collections.unmodifiableList(this.rules_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Configuration_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Configuration_fieldAccessorTable.ensureFieldAccessorsInitialized(Configuration.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public boolean hasName() {
            return this.name_ != null;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public StringValue getName() {
            StringValue stringValue = this.name_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public StringValueOrBuilder getNameOrBuilder() {
            return getName();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public boolean hasUrl() {
            return this.url_ != null;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public StringValue getUrl() {
            StringValue stringValue = this.url_;
            return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public StringValueOrBuilder getUrlOrBuilder() {
            return getUrl();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public boolean hasUpdateInterval() {
            return this.updateInterval_ != null;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public UInt32Value getUpdateInterval() {
            UInt32Value uInt32Value = this.updateInterval_;
            return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public UInt32ValueOrBuilder getUpdateIntervalOrBuilder() {
            return getUpdateInterval();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public boolean hasUniqueOnly() {
            return this.uniqueOnly_ != null;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public BoolValue getUniqueOnly() {
            BoolValue boolValue = this.uniqueOnly_;
            return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public BoolValueOrBuilder getUniqueOnlyOrBuilder() {
            return getUniqueOnly();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public List<Rule> getRulesList() {
            return this.rules_;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public List<? extends RuleOrBuilder> getRulesOrBuilderList() {
            return this.rules_;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public int getRulesCount() {
            return this.rules_.size();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public Rule getRules(int i) {
            return this.rules_.get(i);
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
        public RuleOrBuilder getRulesOrBuilder(int i) {
            return this.rules_.get(i);
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
            if (this.name_ != null) {
                codedOutputStream.writeMessage(1, getName());
            }
            if (this.url_ != null) {
                codedOutputStream.writeMessage(2, getUrl());
            }
            if (this.updateInterval_ != null) {
                codedOutputStream.writeMessage(3, getUpdateInterval());
            }
            if (this.uniqueOnly_ != null) {
                codedOutputStream.writeMessage(4, getUniqueOnly());
            }
            for (int i = 0; i < this.rules_.size(); i++) {
                codedOutputStream.writeMessage(5, this.rules_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.name_ != null ? CodedOutputStream.computeMessageSize(1, getName()) : 0;
            if (this.url_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getUrl());
            }
            if (this.updateInterval_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, getUpdateInterval());
            }
            if (this.uniqueOnly_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(4, getUniqueOnly());
            }
            for (int i2 = 0; i2 < this.rules_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(5, this.rules_.get(i2));
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
            if (!(obj instanceof Configuration)) {
                return super.equals(obj);
            }
            Configuration configuration = (Configuration) obj;
            if (hasName() != configuration.hasName()) {
                return false;
            }
            if ((hasName() && !getName().equals(configuration.getName())) || hasUrl() != configuration.hasUrl()) {
                return false;
            }
            if ((hasUrl() && !getUrl().equals(configuration.getUrl())) || hasUpdateInterval() != configuration.hasUpdateInterval()) {
                return false;
            }
            if ((!hasUpdateInterval() || getUpdateInterval().equals(configuration.getUpdateInterval())) && hasUniqueOnly() == configuration.hasUniqueOnly()) {
                return (!hasUniqueOnly() || getUniqueOnly().equals(configuration.getUniqueOnly())) && getRulesList().equals(configuration.getRulesList()) && this.unknownFields.equals(configuration.unknownFields);
            }
            return false;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasName()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getName().hashCode();
            }
            if (hasUrl()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getUrl().hashCode();
            }
            if (hasUpdateInterval()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getUpdateInterval().hashCode();
            }
            if (hasUniqueOnly()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getUniqueOnly().hashCode();
            }
            if (getRulesCount() > 0) {
                hashCode = (((hashCode * 37) + 5) * 53) + getRulesList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Configuration parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Configuration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Configuration parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Configuration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Configuration parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Configuration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Configuration parseFrom(InputStream inputStream) throws IOException {
            return (Configuration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Configuration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Configuration) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Configuration parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Configuration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Configuration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Configuration) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Configuration parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Configuration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Configuration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Configuration) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Configuration configuration) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(configuration);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConfigurationOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> nameBuilder_;
            private StringValue name_;
            private RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> rulesBuilder_;
            private List<Rule> rules_;
            private SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> uniqueOnlyBuilder_;
            private BoolValue uniqueOnly_;
            private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> updateIntervalBuilder_;
            private UInt32Value updateInterval_;
            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> urlBuilder_;
            private StringValue url_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Configuration_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Configuration_fieldAccessorTable.ensureFieldAccessorsInitialized(Configuration.class, Builder.class);
            }

            private Builder() {
                this.rules_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.rules_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Configuration.alwaysUseFieldBuilders) {
                    getRulesFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.nameBuilder_ == null) {
                    this.name_ = null;
                } else {
                    this.name_ = null;
                    this.nameBuilder_ = null;
                }
                if (this.urlBuilder_ == null) {
                    this.url_ = null;
                } else {
                    this.url_ = null;
                    this.urlBuilder_ = null;
                }
                if (this.updateIntervalBuilder_ == null) {
                    this.updateInterval_ = null;
                } else {
                    this.updateInterval_ = null;
                    this.updateIntervalBuilder_ = null;
                }
                if (this.uniqueOnlyBuilder_ == null) {
                    this.uniqueOnly_ = null;
                } else {
                    this.uniqueOnly_ = null;
                    this.uniqueOnlyBuilder_ = null;
                }
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.rules_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Configuration_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Configuration getDefaultInstanceForType() {
                return Configuration.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Configuration build() {
                Configuration buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Configuration buildPartial() {
                Configuration configuration = new Configuration(this);
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nameBuilder_;
                if (singleFieldBuilderV3 == null) {
                    configuration.name_ = this.name_;
                } else {
                    configuration.name_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV32 = this.urlBuilder_;
                if (singleFieldBuilderV32 == null) {
                    configuration.url_ = this.url_;
                } else {
                    configuration.url_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV33 = this.updateIntervalBuilder_;
                if (singleFieldBuilderV33 == null) {
                    configuration.updateInterval_ = this.updateInterval_;
                } else {
                    configuration.updateInterval_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV34 = this.uniqueOnlyBuilder_;
                if (singleFieldBuilderV34 == null) {
                    configuration.uniqueOnly_ = this.uniqueOnly_;
                } else {
                    configuration.uniqueOnly_ = singleFieldBuilderV34.build();
                }
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    configuration.rules_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 1) != 0) {
                        this.rules_ = Collections.unmodifiableList(this.rules_);
                        this.bitField0_ &= -2;
                    }
                    configuration.rules_ = this.rules_;
                }
                onBuilt();
                return configuration;
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
                if (message instanceof Configuration) {
                    return mergeFrom((Configuration) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Configuration configuration) {
                if (configuration == Configuration.getDefaultInstance()) {
                    return this;
                }
                if (configuration.hasName()) {
                    mergeName(configuration.getName());
                }
                if (configuration.hasUrl()) {
                    mergeUrl(configuration.getUrl());
                }
                if (configuration.hasUpdateInterval()) {
                    mergeUpdateInterval(configuration.getUpdateInterval());
                }
                if (configuration.hasUniqueOnly()) {
                    mergeUniqueOnly(configuration.getUniqueOnly());
                }
                if (this.rulesBuilder_ == null) {
                    if (!configuration.rules_.isEmpty()) {
                        if (this.rules_.isEmpty()) {
                            this.rules_ = configuration.rules_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRulesIsMutable();
                            this.rules_.addAll(configuration.rules_);
                        }
                        onChanged();
                    }
                } else if (!configuration.rules_.isEmpty()) {
                    if (!this.rulesBuilder_.isEmpty()) {
                        this.rulesBuilder_.addAllMessages(configuration.rules_);
                    } else {
                        this.rulesBuilder_.dispose();
                        this.rulesBuilder_ = null;
                        this.rules_ = configuration.rules_;
                        this.bitField0_ &= -2;
                        this.rulesBuilder_ = Configuration.alwaysUseFieldBuilders ? getRulesFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(configuration.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Configuration configuration = null;
                try {
                    try {
                        Configuration configuration2 = (Configuration) Configuration.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (configuration2 != null) {
                            mergeFrom(configuration2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Configuration configuration3 = (Configuration) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            configuration = configuration3;
                            if (configuration != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (configuration != null) {
                        mergeFrom(configuration);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public boolean hasName() {
                return (this.nameBuilder_ == null && this.name_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public StringValue getName() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nameBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.name_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setName(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nameBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.name_ = stringValue;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(stringValue);
                return this;
            }

            public Builder setName(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nameBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.name_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeName(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nameBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.name_;
                    if (stringValue2 != null) {
                        this.name_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.name_ = stringValue;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(stringValue);
                return this;
            }

            public Builder clearName() {
                if (this.nameBuilder_ == null) {
                    this.name_ = null;
                    onChanged();
                    return this;
                }
                this.name_ = null;
                this.nameBuilder_ = null;
                return this;
            }

            public StringValue.Builder getNameBuilder() {
                onChanged();
                return getNameFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public StringValueOrBuilder getNameOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.nameBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.name_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getNameFieldBuilder() {
                if (this.nameBuilder_ == null) {
                    this.nameBuilder_ = new SingleFieldBuilderV3<>(getName(), getParentForChildren(), isClean());
                    this.name_ = null;
                }
                return this.nameBuilder_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public boolean hasUrl() {
                return (this.urlBuilder_ == null && this.url_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public StringValue getUrl() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.urlBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue = this.url_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setUrl(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.urlBuilder_;
                if (singleFieldBuilderV3 == null) {
                    stringValue.getClass();
                    this.url_ = stringValue;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(stringValue);
                return this;
            }

            public Builder setUrl(StringValue.Builder builder) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.urlBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.url_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeUrl(StringValue stringValue) {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.urlBuilder_;
                if (singleFieldBuilderV3 == null) {
                    StringValue stringValue2 = this.url_;
                    if (stringValue2 != null) {
                        this.url_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                    } else {
                        this.url_ = stringValue;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(stringValue);
                return this;
            }

            public Builder clearUrl() {
                if (this.urlBuilder_ == null) {
                    this.url_ = null;
                    onChanged();
                    return this;
                }
                this.url_ = null;
                this.urlBuilder_ = null;
                return this;
            }

            public StringValue.Builder getUrlBuilder() {
                onChanged();
                return getUrlFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public StringValueOrBuilder getUrlOrBuilder() {
                SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.urlBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                StringValue stringValue = this.url_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getUrlFieldBuilder() {
                if (this.urlBuilder_ == null) {
                    this.urlBuilder_ = new SingleFieldBuilderV3<>(getUrl(), getParentForChildren(), isClean());
                    this.url_ = null;
                }
                return this.urlBuilder_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public boolean hasUpdateInterval() {
                return (this.updateIntervalBuilder_ == null && this.updateInterval_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public UInt32Value getUpdateInterval() {
                SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.updateIntervalBuilder_;
                if (singleFieldBuilderV3 == null) {
                    UInt32Value uInt32Value = this.updateInterval_;
                    return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setUpdateInterval(UInt32Value uInt32Value) {
                SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.updateIntervalBuilder_;
                if (singleFieldBuilderV3 == null) {
                    uInt32Value.getClass();
                    this.updateInterval_ = uInt32Value;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(uInt32Value);
                return this;
            }

            public Builder setUpdateInterval(UInt32Value.Builder builder) {
                SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.updateIntervalBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.updateInterval_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeUpdateInterval(UInt32Value uInt32Value) {
                SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.updateIntervalBuilder_;
                if (singleFieldBuilderV3 == null) {
                    UInt32Value uInt32Value2 = this.updateInterval_;
                    if (uInt32Value2 != null) {
                        this.updateInterval_ = UInt32Value.newBuilder(uInt32Value2).mergeFrom(uInt32Value).buildPartial();
                    } else {
                        this.updateInterval_ = uInt32Value;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(uInt32Value);
                return this;
            }

            public Builder clearUpdateInterval() {
                if (this.updateIntervalBuilder_ == null) {
                    this.updateInterval_ = null;
                    onChanged();
                    return this;
                }
                this.updateInterval_ = null;
                this.updateIntervalBuilder_ = null;
                return this;
            }

            public UInt32Value.Builder getUpdateIntervalBuilder() {
                onChanged();
                return getUpdateIntervalFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public UInt32ValueOrBuilder getUpdateIntervalOrBuilder() {
                SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> singleFieldBuilderV3 = this.updateIntervalBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                UInt32Value uInt32Value = this.updateInterval_;
                return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
            }

            private SingleFieldBuilderV3<UInt32Value, UInt32Value.Builder, UInt32ValueOrBuilder> getUpdateIntervalFieldBuilder() {
                if (this.updateIntervalBuilder_ == null) {
                    this.updateIntervalBuilder_ = new SingleFieldBuilderV3<>(getUpdateInterval(), getParentForChildren(), isClean());
                    this.updateInterval_ = null;
                }
                return this.updateIntervalBuilder_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public boolean hasUniqueOnly() {
                return (this.uniqueOnlyBuilder_ == null && this.uniqueOnly_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public BoolValue getUniqueOnly() {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.uniqueOnlyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BoolValue boolValue = this.uniqueOnly_;
                    return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setUniqueOnly(BoolValue boolValue) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.uniqueOnlyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    boolValue.getClass();
                    this.uniqueOnly_ = boolValue;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(boolValue);
                return this;
            }

            public Builder setUniqueOnly(BoolValue.Builder builder) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.uniqueOnlyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.uniqueOnly_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeUniqueOnly(BoolValue boolValue) {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.uniqueOnlyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BoolValue boolValue2 = this.uniqueOnly_;
                    if (boolValue2 != null) {
                        this.uniqueOnly_ = BoolValue.newBuilder(boolValue2).mergeFrom(boolValue).buildPartial();
                    } else {
                        this.uniqueOnly_ = boolValue;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(boolValue);
                return this;
            }

            public Builder clearUniqueOnly() {
                if (this.uniqueOnlyBuilder_ == null) {
                    this.uniqueOnly_ = null;
                    onChanged();
                    return this;
                }
                this.uniqueOnly_ = null;
                this.uniqueOnlyBuilder_ = null;
                return this;
            }

            public BoolValue.Builder getUniqueOnlyBuilder() {
                onChanged();
                return getUniqueOnlyFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public BoolValueOrBuilder getUniqueOnlyOrBuilder() {
                SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> singleFieldBuilderV3 = this.uniqueOnlyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                BoolValue boolValue = this.uniqueOnly_;
                return boolValue == null ? BoolValue.getDefaultInstance() : boolValue;
            }

            private SingleFieldBuilderV3<BoolValue, BoolValue.Builder, BoolValueOrBuilder> getUniqueOnlyFieldBuilder() {
                if (this.uniqueOnlyBuilder_ == null) {
                    this.uniqueOnlyBuilder_ = new SingleFieldBuilderV3<>(getUniqueOnly(), getParentForChildren(), isClean());
                    this.uniqueOnly_ = null;
                }
                return this.uniqueOnlyBuilder_;
            }

            private void ensureRulesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.rules_ = new ArrayList(this.rules_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public List<Rule> getRulesList() {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.rules_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public int getRulesCount() {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rules_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public Rule getRules(int i) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rules_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setRules(int i, Rule rule) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    rule.getClass();
                    ensureRulesIsMutable();
                    this.rules_.set(i, rule);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, rule);
                return this;
            }

            public Builder setRules(int i, Rule.Builder builder) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRulesIsMutable();
                    this.rules_.set(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }

            public Builder addRules(Rule rule) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    rule.getClass();
                    ensureRulesIsMutable();
                    this.rules_.add(rule);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(rule);
                return this;
            }

            public Builder addRules(int i, Rule rule) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    rule.getClass();
                    ensureRulesIsMutable();
                    this.rules_.add(i, rule);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, rule);
                return this;
            }

            public Builder addRules(Rule.Builder builder) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRulesIsMutable();
                    this.rules_.add(builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }

            public Builder addRules(int i, Rule.Builder builder) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRulesIsMutable();
                    this.rules_.add(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }

            public Builder addAllRules(Iterable<? extends Rule> iterable) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRulesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.rules_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }

            public Builder clearRules() {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.rules_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            public Builder removeRules(int i) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureRulesIsMutable();
                    this.rules_.remove(i);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.remove(i);
                return this;
            }

            public Rule.Builder getRulesBuilder(int i) {
                return getRulesFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public RuleOrBuilder getRulesOrBuilder(int i) {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.rules_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.ConfigurationOrBuilder
            public List<? extends RuleOrBuilder> getRulesOrBuilderList() {
                RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.rules_);
            }

            public Rule.Builder addRulesBuilder() {
                return getRulesFieldBuilder().addBuilder(Rule.getDefaultInstance());
            }

            public Rule.Builder addRulesBuilder(int i) {
                return getRulesFieldBuilder().addBuilder(i, Rule.getDefaultInstance());
            }

            public List<Rule.Builder> getRulesBuilderList() {
                return getRulesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> getRulesFieldBuilder() {
                if (this.rulesBuilder_ == null) {
                    this.rulesBuilder_ = new RepeatedFieldBuilderV3<>(this.rules_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.rules_ = null;
                }
                return this.rulesBuilder_;
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

        public static Configuration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Configuration> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<Configuration> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Configuration getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Rule extends GeneratedMessageV3 implements RuleOrBuilder {
        public static final int GENERAL_RULE_FIELD_NUMBER = 1;
        public static final int IOS_LOG_RULE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int ruleOneofCase_;
        private Object ruleOneof_;
        private static final Rule DEFAULT_INSTANCE = new Rule();
        private static final Parser<Rule> PARSER = new AbstractParser<Rule>() { // from class: io.bidmachine.protobuf.sdk.Reader.Rule.1
            @Override // com.explorestack.protobuf.Parser
            public Rule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Rule(codedInputStream, extensionRegistryLite);
            }
        };

        public interface GeneralRuleOrBuilder extends MessageOrBuilder {
            StringValue getPath();

            StringValueOrBuilder getPathOrBuilder();

            StringValue getTag();

            StringValueOrBuilder getTagOrBuilder();

            boolean hasPath();

            boolean hasTag();
        }

        public interface IOSLogRuleOrBuilder extends MessageOrBuilder {
            StringValue getLevels(int i);

            int getLevelsCount();

            List<StringValue> getLevelsList();

            StringValueOrBuilder getLevelsOrBuilder(int i);

            List<? extends StringValueOrBuilder> getLevelsOrBuilderList();

            StringValue getSources(int i);

            int getSourcesCount();

            List<StringValue> getSourcesList();

            StringValueOrBuilder getSourcesOrBuilder(int i);

            List<? extends StringValueOrBuilder> getSourcesOrBuilderList();

            StringValue getTag();

            StringValueOrBuilder getTagOrBuilder();

            boolean hasTag();
        }

        private Rule(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.ruleOneofCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Rule() {
            this.ruleOneofCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Rule();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Rule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    GeneralRule.Builder builder = this.ruleOneofCase_ == 1 ? ((GeneralRule) this.ruleOneof_).toBuilder() : null;
                                    MessageLite readMessage = codedInputStream.readMessage(GeneralRule.parser(), extensionRegistryLite);
                                    this.ruleOneof_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom((GeneralRule) readMessage);
                                        this.ruleOneof_ = builder.buildPartial();
                                    }
                                    this.ruleOneofCase_ = 1;
                                } else if (readTag == 18) {
                                    IOSLogRule.Builder builder2 = this.ruleOneofCase_ == 2 ? ((IOSLogRule) this.ruleOneof_).toBuilder() : null;
                                    MessageLite readMessage2 = codedInputStream.readMessage(IOSLogRule.parser(), extensionRegistryLite);
                                    this.ruleOneof_ = readMessage2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom((IOSLogRule) readMessage2);
                                        this.ruleOneof_ = builder2.buildPartial();
                                    }
                                    this.ruleOneofCase_ = 2;
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
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_fieldAccessorTable.ensureFieldAccessorsInitialized(Rule.class, Builder.class);
        }

        public static final class GeneralRule extends GeneratedMessageV3 implements GeneralRuleOrBuilder {
            private static final GeneralRule DEFAULT_INSTANCE = new GeneralRule();
            private static final Parser<GeneralRule> PARSER = new AbstractParser<GeneralRule>() { // from class: io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRule.1
                @Override // com.explorestack.protobuf.Parser
                public GeneralRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new GeneralRule(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int PATH_FIELD_NUMBER = 2;
            public static final int TAG_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private StringValue path_;
            private StringValue tag_;

            private GeneralRule(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private GeneralRule() {
                this.memoizedIsInitialized = (byte) -1;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new GeneralRule();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private GeneralRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                StringValue.Builder builder;
                extensionRegistryLite.getClass();
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    StringValue stringValue = this.tag_;
                                    builder = stringValue != null ? stringValue.toBuilder() : null;
                                    StringValue stringValue2 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.tag_ = stringValue2;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue2);
                                        this.tag_ = builder.buildPartial();
                                    }
                                } else if (readTag == 18) {
                                    StringValue stringValue3 = this.path_;
                                    builder = stringValue3 != null ? stringValue3.toBuilder() : null;
                                    StringValue stringValue4 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                    this.path_ = stringValue4;
                                    if (builder != null) {
                                        builder.mergeFrom(stringValue4);
                                        this.path_ = builder.buildPartial();
                                    }
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
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_GeneralRule_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_GeneralRule_fieldAccessorTable.ensureFieldAccessorsInitialized(GeneralRule.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
            public boolean hasTag() {
                return this.tag_ != null;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
            public StringValue getTag() {
                StringValue stringValue = this.tag_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
            public StringValueOrBuilder getTagOrBuilder() {
                return getTag();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
            public boolean hasPath() {
                return this.path_ != null;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
            public StringValue getPath() {
                StringValue stringValue = this.path_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
            public StringValueOrBuilder getPathOrBuilder() {
                return getPath();
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
                if (this.tag_ != null) {
                    codedOutputStream.writeMessage(1, getTag());
                }
                if (this.path_ != null) {
                    codedOutputStream.writeMessage(2, getPath());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int computeMessageSize = this.tag_ != null ? CodedOutputStream.computeMessageSize(1, getTag()) : 0;
                if (this.path_ != null) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(2, getPath());
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
                if (!(obj instanceof GeneralRule)) {
                    return super.equals(obj);
                }
                GeneralRule generalRule = (GeneralRule) obj;
                if (hasTag() != generalRule.hasTag()) {
                    return false;
                }
                if ((!hasTag() || getTag().equals(generalRule.getTag())) && hasPath() == generalRule.hasPath()) {
                    return (!hasPath() || getPath().equals(generalRule.getPath())) && this.unknownFields.equals(generalRule.unknownFields);
                }
                return false;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (hasTag()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getTag().hashCode();
                }
                if (hasPath()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getPath().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static GeneralRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static GeneralRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static GeneralRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static GeneralRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static GeneralRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static GeneralRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static GeneralRule parseFrom(InputStream inputStream) throws IOException {
                return (GeneralRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static GeneralRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GeneralRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static GeneralRule parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (GeneralRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static GeneralRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GeneralRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static GeneralRule parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (GeneralRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static GeneralRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (GeneralRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(GeneralRule generalRule) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(generalRule);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GeneralRuleOrBuilder {
                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> pathBuilder_;
                private StringValue path_;
                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> tagBuilder_;
                private StringValue tag_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_GeneralRule_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_GeneralRule_fieldAccessorTable.ensureFieldAccessorsInitialized(GeneralRule.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = GeneralRule.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    if (this.tagBuilder_ == null) {
                        this.tag_ = null;
                    } else {
                        this.tag_ = null;
                        this.tagBuilder_ = null;
                    }
                    if (this.pathBuilder_ == null) {
                        this.path_ = null;
                        return this;
                    }
                    this.path_ = null;
                    this.pathBuilder_ = null;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_GeneralRule_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public GeneralRule getDefaultInstanceForType() {
                    return GeneralRule.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public GeneralRule build() {
                    GeneralRule buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public GeneralRule buildPartial() {
                    GeneralRule generalRule = new GeneralRule(this);
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        generalRule.tag_ = this.tag_;
                    } else {
                        generalRule.tag_ = singleFieldBuilderV3.build();
                    }
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV32 = this.pathBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        generalRule.path_ = this.path_;
                    } else {
                        generalRule.path_ = singleFieldBuilderV32.build();
                    }
                    onBuilt();
                    return generalRule;
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
                    if (message instanceof GeneralRule) {
                        return mergeFrom((GeneralRule) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(GeneralRule generalRule) {
                    if (generalRule == GeneralRule.getDefaultInstance()) {
                        return this;
                    }
                    if (generalRule.hasTag()) {
                        mergeTag(generalRule.getTag());
                    }
                    if (generalRule.hasPath()) {
                        mergePath(generalRule.getPath());
                    }
                    mergeUnknownFields(generalRule.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    GeneralRule generalRule = null;
                    try {
                        try {
                            GeneralRule generalRule2 = (GeneralRule) GeneralRule.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (generalRule2 != null) {
                                mergeFrom(generalRule2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            GeneralRule generalRule3 = (GeneralRule) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                generalRule = generalRule3;
                                if (generalRule != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (generalRule != null) {
                            mergeFrom(generalRule);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
                public boolean hasTag() {
                    return (this.tagBuilder_ == null && this.tag_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
                public StringValue getTag() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue = this.tag_;
                        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                    }
                    return singleFieldBuilderV3.getMessage();
                }

                public Builder setTag(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        stringValue.getClass();
                        this.tag_ = stringValue;
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(stringValue);
                    return this;
                }

                public Builder setTag(StringValue.Builder builder) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.tag_ = builder.build();
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }

                public Builder mergeTag(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue2 = this.tag_;
                        if (stringValue2 != null) {
                            this.tag_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                        } else {
                            this.tag_ = stringValue;
                        }
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.mergeFrom(stringValue);
                    return this;
                }

                public Builder clearTag() {
                    if (this.tagBuilder_ == null) {
                        this.tag_ = null;
                        onChanged();
                        return this;
                    }
                    this.tag_ = null;
                    this.tagBuilder_ = null;
                    return this;
                }

                public StringValue.Builder getTagBuilder() {
                    onChanged();
                    return getTagFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
                public StringValueOrBuilder getTagOrBuilder() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    StringValue stringValue = this.tag_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }

                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getTagFieldBuilder() {
                    if (this.tagBuilder_ == null) {
                        this.tagBuilder_ = new SingleFieldBuilderV3<>(getTag(), getParentForChildren(), isClean());
                        this.tag_ = null;
                    }
                    return this.tagBuilder_;
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
                public boolean hasPath() {
                    return (this.pathBuilder_ == null && this.path_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
                public StringValue getPath() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.pathBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue = this.path_;
                        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                    }
                    return singleFieldBuilderV3.getMessage();
                }

                public Builder setPath(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.pathBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        stringValue.getClass();
                        this.path_ = stringValue;
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(stringValue);
                    return this;
                }

                public Builder setPath(StringValue.Builder builder) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.pathBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.path_ = builder.build();
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }

                public Builder mergePath(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.pathBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue2 = this.path_;
                        if (stringValue2 != null) {
                            this.path_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                        } else {
                            this.path_ = stringValue;
                        }
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.mergeFrom(stringValue);
                    return this;
                }

                public Builder clearPath() {
                    if (this.pathBuilder_ == null) {
                        this.path_ = null;
                        onChanged();
                        return this;
                    }
                    this.path_ = null;
                    this.pathBuilder_ = null;
                    return this;
                }

                public StringValue.Builder getPathBuilder() {
                    onChanged();
                    return getPathFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.GeneralRuleOrBuilder
                public StringValueOrBuilder getPathOrBuilder() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.pathBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    StringValue stringValue = this.path_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }

                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getPathFieldBuilder() {
                    if (this.pathBuilder_ == null) {
                        this.pathBuilder_ = new SingleFieldBuilderV3<>(getPath(), getParentForChildren(), isClean());
                        this.path_ = null;
                    }
                    return this.pathBuilder_;
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

            public static GeneralRule getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<GeneralRule> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<GeneralRule> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public GeneralRule getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class IOSLogRule extends GeneratedMessageV3 implements IOSLogRuleOrBuilder {
            public static final int LEVELS_FIELD_NUMBER = 2;
            public static final int SOURCES_FIELD_NUMBER = 3;
            public static final int TAG_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private List<StringValue> levels_;
            private byte memoizedIsInitialized;
            private List<StringValue> sources_;
            private StringValue tag_;
            private static final IOSLogRule DEFAULT_INSTANCE = new IOSLogRule();
            private static final Parser<IOSLogRule> PARSER = new AbstractParser<IOSLogRule>() { // from class: io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRule.1
                @Override // com.explorestack.protobuf.Parser
                public IOSLogRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new IOSLogRule(codedInputStream, extensionRegistryLite);
                }
            };

            private IOSLogRule(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private IOSLogRule() {
                this.memoizedIsInitialized = (byte) -1;
                this.levels_ = Collections.emptyList();
                this.sources_ = Collections.emptyList();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new IOSLogRule();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private IOSLogRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                extensionRegistryLite.getClass();
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                int i = 0;
                while (!z) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                if (readTag != 0) {
                                    if (readTag == 10) {
                                        StringValue stringValue = this.tag_;
                                        StringValue.Builder builder = stringValue != null ? stringValue.toBuilder() : null;
                                        StringValue stringValue2 = (StringValue) codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite);
                                        this.tag_ = stringValue2;
                                        if (builder != null) {
                                            builder.mergeFrom(stringValue2);
                                            this.tag_ = builder.buildPartial();
                                        }
                                    } else if (readTag == 18) {
                                        if ((i & 1) == 0) {
                                            this.levels_ = new ArrayList();
                                            i |= 1;
                                        }
                                        this.levels_.add(codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite));
                                    } else if (readTag == 26) {
                                        if ((i & 2) == 0) {
                                            this.sources_ = new ArrayList();
                                            i |= 2;
                                        }
                                        this.sources_.add(codedInputStream.readMessage(StringValue.parser(), extensionRegistryLite));
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
                        if ((i & 1) != 0) {
                            this.levels_ = Collections.unmodifiableList(this.levels_);
                        }
                        if ((i & 2) != 0) {
                            this.sources_ = Collections.unmodifiableList(this.sources_);
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_IOSLogRule_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_IOSLogRule_fieldAccessorTable.ensureFieldAccessorsInitialized(IOSLogRule.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public boolean hasTag() {
                return this.tag_ != null;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public StringValue getTag() {
                StringValue stringValue = this.tag_;
                return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public StringValueOrBuilder getTagOrBuilder() {
                return getTag();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public List<StringValue> getLevelsList() {
                return this.levels_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public List<? extends StringValueOrBuilder> getLevelsOrBuilderList() {
                return this.levels_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public int getLevelsCount() {
                return this.levels_.size();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public StringValue getLevels(int i) {
                return this.levels_.get(i);
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public StringValueOrBuilder getLevelsOrBuilder(int i) {
                return this.levels_.get(i);
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public List<StringValue> getSourcesList() {
                return this.sources_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public List<? extends StringValueOrBuilder> getSourcesOrBuilderList() {
                return this.sources_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public int getSourcesCount() {
                return this.sources_.size();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public StringValue getSources(int i) {
                return this.sources_.get(i);
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
            public StringValueOrBuilder getSourcesOrBuilder(int i) {
                return this.sources_.get(i);
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
                if (this.tag_ != null) {
                    codedOutputStream.writeMessage(1, getTag());
                }
                for (int i = 0; i < this.levels_.size(); i++) {
                    codedOutputStream.writeMessage(2, this.levels_.get(i));
                }
                for (int i2 = 0; i2 < this.sources_.size(); i2++) {
                    codedOutputStream.writeMessage(3, this.sources_.get(i2));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int computeMessageSize = this.tag_ != null ? CodedOutputStream.computeMessageSize(1, getTag()) : 0;
                for (int i2 = 0; i2 < this.levels_.size(); i2++) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(2, this.levels_.get(i2));
                }
                for (int i3 = 0; i3 < this.sources_.size(); i3++) {
                    computeMessageSize += CodedOutputStream.computeMessageSize(3, this.sources_.get(i3));
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
                if (!(obj instanceof IOSLogRule)) {
                    return super.equals(obj);
                }
                IOSLogRule iOSLogRule = (IOSLogRule) obj;
                if (hasTag() != iOSLogRule.hasTag()) {
                    return false;
                }
                return (!hasTag() || getTag().equals(iOSLogRule.getTag())) && getLevelsList().equals(iOSLogRule.getLevelsList()) && getSourcesList().equals(iOSLogRule.getSourcesList()) && this.unknownFields.equals(iOSLogRule.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (hasTag()) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getTag().hashCode();
                }
                if (getLevelsCount() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getLevelsList().hashCode();
                }
                if (getSourcesCount() > 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + getSourcesList().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static IOSLogRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static IOSLogRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static IOSLogRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static IOSLogRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static IOSLogRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static IOSLogRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static IOSLogRule parseFrom(InputStream inputStream) throws IOException {
                return (IOSLogRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static IOSLogRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (IOSLogRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static IOSLogRule parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (IOSLogRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static IOSLogRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (IOSLogRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static IOSLogRule parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (IOSLogRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static IOSLogRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (IOSLogRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(IOSLogRule iOSLogRule) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(iOSLogRule);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IOSLogRuleOrBuilder {
                private int bitField0_;
                private RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> levelsBuilder_;
                private List<StringValue> levels_;
                private RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> sourcesBuilder_;
                private List<StringValue> sources_;
                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> tagBuilder_;
                private StringValue tag_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_IOSLogRule_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_IOSLogRule_fieldAccessorTable.ensureFieldAccessorsInitialized(IOSLogRule.class, Builder.class);
                }

                private Builder() {
                    this.levels_ = Collections.emptyList();
                    this.sources_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.levels_ = Collections.emptyList();
                    this.sources_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (IOSLogRule.alwaysUseFieldBuilders) {
                        getLevelsFieldBuilder();
                        getSourcesFieldBuilder();
                    }
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    if (this.tagBuilder_ == null) {
                        this.tag_ = null;
                    } else {
                        this.tag_ = null;
                        this.tagBuilder_ = null;
                    }
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.levels_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                    } else {
                        repeatedFieldBuilderV3.clear();
                    }
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV32 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV32 == null) {
                        this.sources_ = Collections.emptyList();
                        this.bitField0_ &= -3;
                        return this;
                    }
                    repeatedFieldBuilderV32.clear();
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_IOSLogRule_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public IOSLogRule getDefaultInstanceForType() {
                    return IOSLogRule.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public IOSLogRule build() {
                    IOSLogRule buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public IOSLogRule buildPartial() {
                    IOSLogRule iOSLogRule = new IOSLogRule(this);
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        iOSLogRule.tag_ = this.tag_;
                    } else {
                        iOSLogRule.tag_ = singleFieldBuilderV3.build();
                    }
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        iOSLogRule.levels_ = repeatedFieldBuilderV3.build();
                    } else {
                        if ((this.bitField0_ & 1) != 0) {
                            this.levels_ = Collections.unmodifiableList(this.levels_);
                            this.bitField0_ &= -2;
                        }
                        iOSLogRule.levels_ = this.levels_;
                    }
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV32 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV32 != null) {
                        iOSLogRule.sources_ = repeatedFieldBuilderV32.build();
                    } else {
                        if ((this.bitField0_ & 2) != 0) {
                            this.sources_ = Collections.unmodifiableList(this.sources_);
                            this.bitField0_ &= -3;
                        }
                        iOSLogRule.sources_ = this.sources_;
                    }
                    onBuilt();
                    return iOSLogRule;
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
                    if (message instanceof IOSLogRule) {
                        return mergeFrom((IOSLogRule) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(IOSLogRule iOSLogRule) {
                    if (iOSLogRule == IOSLogRule.getDefaultInstance()) {
                        return this;
                    }
                    if (iOSLogRule.hasTag()) {
                        mergeTag(iOSLogRule.getTag());
                    }
                    if (this.levelsBuilder_ == null) {
                        if (!iOSLogRule.levels_.isEmpty()) {
                            if (this.levels_.isEmpty()) {
                                this.levels_ = iOSLogRule.levels_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureLevelsIsMutable();
                                this.levels_.addAll(iOSLogRule.levels_);
                            }
                            onChanged();
                        }
                    } else if (!iOSLogRule.levels_.isEmpty()) {
                        if (!this.levelsBuilder_.isEmpty()) {
                            this.levelsBuilder_.addAllMessages(iOSLogRule.levels_);
                        } else {
                            this.levelsBuilder_.dispose();
                            this.levelsBuilder_ = null;
                            this.levels_ = iOSLogRule.levels_;
                            this.bitField0_ &= -2;
                            this.levelsBuilder_ = IOSLogRule.alwaysUseFieldBuilders ? getLevelsFieldBuilder() : null;
                        }
                    }
                    if (this.sourcesBuilder_ == null) {
                        if (!iOSLogRule.sources_.isEmpty()) {
                            if (this.sources_.isEmpty()) {
                                this.sources_ = iOSLogRule.sources_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureSourcesIsMutable();
                                this.sources_.addAll(iOSLogRule.sources_);
                            }
                            onChanged();
                        }
                    } else if (!iOSLogRule.sources_.isEmpty()) {
                        if (!this.sourcesBuilder_.isEmpty()) {
                            this.sourcesBuilder_.addAllMessages(iOSLogRule.sources_);
                        } else {
                            this.sourcesBuilder_.dispose();
                            this.sourcesBuilder_ = null;
                            this.sources_ = iOSLogRule.sources_;
                            this.bitField0_ &= -3;
                            this.sourcesBuilder_ = IOSLogRule.alwaysUseFieldBuilders ? getSourcesFieldBuilder() : null;
                        }
                    }
                    mergeUnknownFields(iOSLogRule.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    IOSLogRule iOSLogRule = null;
                    try {
                        try {
                            IOSLogRule iOSLogRule2 = (IOSLogRule) IOSLogRule.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (iOSLogRule2 != null) {
                                mergeFrom(iOSLogRule2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            IOSLogRule iOSLogRule3 = (IOSLogRule) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                iOSLogRule = iOSLogRule3;
                                if (iOSLogRule != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (iOSLogRule != null) {
                            mergeFrom(iOSLogRule);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public boolean hasTag() {
                    return (this.tagBuilder_ == null && this.tag_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public StringValue getTag() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue = this.tag_;
                        return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                    }
                    return singleFieldBuilderV3.getMessage();
                }

                public Builder setTag(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        stringValue.getClass();
                        this.tag_ = stringValue;
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(stringValue);
                    return this;
                }

                public Builder setTag(StringValue.Builder builder) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.tag_ = builder.build();
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }

                public Builder mergeTag(StringValue stringValue) {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        StringValue stringValue2 = this.tag_;
                        if (stringValue2 != null) {
                            this.tag_ = StringValue.newBuilder(stringValue2).mergeFrom(stringValue).buildPartial();
                        } else {
                            this.tag_ = stringValue;
                        }
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.mergeFrom(stringValue);
                    return this;
                }

                public Builder clearTag() {
                    if (this.tagBuilder_ == null) {
                        this.tag_ = null;
                        onChanged();
                        return this;
                    }
                    this.tag_ = null;
                    this.tagBuilder_ = null;
                    return this;
                }

                public StringValue.Builder getTagBuilder() {
                    onChanged();
                    return getTagFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public StringValueOrBuilder getTagOrBuilder() {
                    SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> singleFieldBuilderV3 = this.tagBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    StringValue stringValue = this.tag_;
                    return stringValue == null ? StringValue.getDefaultInstance() : stringValue;
                }

                private SingleFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getTagFieldBuilder() {
                    if (this.tagBuilder_ == null) {
                        this.tagBuilder_ = new SingleFieldBuilderV3<>(getTag(), getParentForChildren(), isClean());
                        this.tag_ = null;
                    }
                    return this.tagBuilder_;
                }

                private void ensureLevelsIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.levels_ = new ArrayList(this.levels_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public List<StringValue> getLevelsList() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return Collections.unmodifiableList(this.levels_);
                    }
                    return repeatedFieldBuilderV3.getMessageList();
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public int getLevelsCount() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.levels_.size();
                    }
                    return repeatedFieldBuilderV3.getCount();
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public StringValue getLevels(int i) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.levels_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessage(i);
                }

                public Builder setLevels(int i, StringValue stringValue) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        stringValue.getClass();
                        ensureLevelsIsMutable();
                        this.levels_.set(i, stringValue);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, stringValue);
                    return this;
                }

                public Builder setLevels(int i, StringValue.Builder builder) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureLevelsIsMutable();
                        this.levels_.set(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }

                public Builder addLevels(StringValue stringValue) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        stringValue.getClass();
                        ensureLevelsIsMutable();
                        this.levels_.add(stringValue);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(stringValue);
                    return this;
                }

                public Builder addLevels(int i, StringValue stringValue) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        stringValue.getClass();
                        ensureLevelsIsMutable();
                        this.levels_.add(i, stringValue);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, stringValue);
                    return this;
                }

                public Builder addLevels(StringValue.Builder builder) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureLevelsIsMutable();
                        this.levels_.add(builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }

                public Builder addLevels(int i, StringValue.Builder builder) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureLevelsIsMutable();
                        this.levels_.add(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }

                public Builder addAllLevels(Iterable<? extends StringValue> iterable) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureLevelsIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.levels_);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }

                public Builder clearLevels() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.levels_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                public Builder removeLevels(int i) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureLevelsIsMutable();
                        this.levels_.remove(i);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }

                public StringValue.Builder getLevelsBuilder(int i) {
                    return getLevelsFieldBuilder().getBuilder(i);
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public StringValueOrBuilder getLevelsOrBuilder(int i) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.levels_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessageOrBuilder(i);
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public List<? extends StringValueOrBuilder> getLevelsOrBuilderList() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.levelsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        return repeatedFieldBuilderV3.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.levels_);
                }

                public StringValue.Builder addLevelsBuilder() {
                    return getLevelsFieldBuilder().addBuilder(StringValue.getDefaultInstance());
                }

                public StringValue.Builder addLevelsBuilder(int i) {
                    return getLevelsFieldBuilder().addBuilder(i, StringValue.getDefaultInstance());
                }

                public List<StringValue.Builder> getLevelsBuilderList() {
                    return getLevelsFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getLevelsFieldBuilder() {
                    if (this.levelsBuilder_ == null) {
                        this.levelsBuilder_ = new RepeatedFieldBuilderV3<>(this.levels_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                        this.levels_ = null;
                    }
                    return this.levelsBuilder_;
                }

                private void ensureSourcesIsMutable() {
                    if ((this.bitField0_ & 2) == 0) {
                        this.sources_ = new ArrayList(this.sources_);
                        this.bitField0_ |= 2;
                    }
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public List<StringValue> getSourcesList() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return Collections.unmodifiableList(this.sources_);
                    }
                    return repeatedFieldBuilderV3.getMessageList();
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public int getSourcesCount() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.sources_.size();
                    }
                    return repeatedFieldBuilderV3.getCount();
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public StringValue getSources(int i) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.sources_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessage(i);
                }

                public Builder setSources(int i, StringValue stringValue) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        stringValue.getClass();
                        ensureSourcesIsMutable();
                        this.sources_.set(i, stringValue);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, stringValue);
                    return this;
                }

                public Builder setSources(int i, StringValue.Builder builder) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureSourcesIsMutable();
                        this.sources_.set(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }

                public Builder addSources(StringValue stringValue) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        stringValue.getClass();
                        ensureSourcesIsMutable();
                        this.sources_.add(stringValue);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(stringValue);
                    return this;
                }

                public Builder addSources(int i, StringValue stringValue) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        stringValue.getClass();
                        ensureSourcesIsMutable();
                        this.sources_.add(i, stringValue);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, stringValue);
                    return this;
                }

                public Builder addSources(StringValue.Builder builder) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureSourcesIsMutable();
                        this.sources_.add(builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }

                public Builder addSources(int i, StringValue.Builder builder) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureSourcesIsMutable();
                        this.sources_.add(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }

                public Builder addAllSources(Iterable<? extends StringValue> iterable) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureSourcesIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.sources_);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }

                public Builder clearSources() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.sources_ = Collections.emptyList();
                        this.bitField0_ &= -3;
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                public Builder removeSources(int i) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureSourcesIsMutable();
                        this.sources_.remove(i);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }

                public StringValue.Builder getSourcesBuilder(int i) {
                    return getSourcesFieldBuilder().getBuilder(i);
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public StringValueOrBuilder getSourcesOrBuilder(int i) {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.sources_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessageOrBuilder(i);
                }

                @Override // io.bidmachine.protobuf.sdk.Reader.Rule.IOSLogRuleOrBuilder
                public List<? extends StringValueOrBuilder> getSourcesOrBuilderList() {
                    RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> repeatedFieldBuilderV3 = this.sourcesBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        return repeatedFieldBuilderV3.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.sources_);
                }

                public StringValue.Builder addSourcesBuilder() {
                    return getSourcesFieldBuilder().addBuilder(StringValue.getDefaultInstance());
                }

                public StringValue.Builder addSourcesBuilder(int i) {
                    return getSourcesFieldBuilder().addBuilder(i, StringValue.getDefaultInstance());
                }

                public List<StringValue.Builder> getSourcesBuilderList() {
                    return getSourcesFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<StringValue, StringValue.Builder, StringValueOrBuilder> getSourcesFieldBuilder() {
                    if (this.sourcesBuilder_ == null) {
                        this.sourcesBuilder_ = new RepeatedFieldBuilderV3<>(this.sources_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                        this.sources_ = null;
                    }
                    return this.sourcesBuilder_;
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

            public static IOSLogRule getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<IOSLogRule> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<IOSLogRule> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public IOSLogRule getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public enum RuleOneofCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            GENERAL_RULE(1),
            IOS_LOG_RULE(2),
            RULEONEOF_NOT_SET(0);

            private final int value;

            RuleOneofCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static RuleOneofCase valueOf(int i) {
                return forNumber(i);
            }

            public static RuleOneofCase forNumber(int i) {
                if (i == 0) {
                    return RULEONEOF_NOT_SET;
                }
                if (i == 1) {
                    return GENERAL_RULE;
                }
                if (i != 2) {
                    return null;
                }
                return IOS_LOG_RULE;
            }

            @Override // com.explorestack.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
        public RuleOneofCase getRuleOneofCase() {
            return RuleOneofCase.forNumber(this.ruleOneofCase_);
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
        public boolean hasGeneralRule() {
            return this.ruleOneofCase_ == 1;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
        public GeneralRule getGeneralRule() {
            if (this.ruleOneofCase_ == 1) {
                return (GeneralRule) this.ruleOneof_;
            }
            return GeneralRule.getDefaultInstance();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
        public GeneralRuleOrBuilder getGeneralRuleOrBuilder() {
            if (this.ruleOneofCase_ == 1) {
                return (GeneralRule) this.ruleOneof_;
            }
            return GeneralRule.getDefaultInstance();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
        public boolean hasIosLogRule() {
            return this.ruleOneofCase_ == 2;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
        public IOSLogRule getIosLogRule() {
            if (this.ruleOneofCase_ == 2) {
                return (IOSLogRule) this.ruleOneof_;
            }
            return IOSLogRule.getDefaultInstance();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
        public IOSLogRuleOrBuilder getIosLogRuleOrBuilder() {
            if (this.ruleOneofCase_ == 2) {
                return (IOSLogRule) this.ruleOneof_;
            }
            return IOSLogRule.getDefaultInstance();
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
            if (this.ruleOneofCase_ == 1) {
                codedOutputStream.writeMessage(1, (GeneralRule) this.ruleOneof_);
            }
            if (this.ruleOneofCase_ == 2) {
                codedOutputStream.writeMessage(2, (IOSLogRule) this.ruleOneof_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.ruleOneofCase_ == 1 ? CodedOutputStream.computeMessageSize(1, (GeneralRule) this.ruleOneof_) : 0;
            if (this.ruleOneofCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (IOSLogRule) this.ruleOneof_);
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
            if (!(obj instanceof Rule)) {
                return super.equals(obj);
            }
            Rule rule = (Rule) obj;
            if (!getRuleOneofCase().equals(rule.getRuleOneofCase())) {
                return false;
            }
            int i = this.ruleOneofCase_;
            if (i == 1) {
                if (!getGeneralRule().equals(rule.getGeneralRule())) {
                    return false;
                }
            } else if (i == 2 && !getIosLogRule().equals(rule.getIosLogRule())) {
                return false;
            }
            return this.unknownFields.equals(rule.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            int i;
            int hashCode;
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode2 = 779 + getDescriptor().hashCode();
            int i2 = this.ruleOneofCase_;
            if (i2 == 1) {
                i = ((hashCode2 * 37) + 1) * 53;
                hashCode = getGeneralRule().hashCode();
            } else {
                if (i2 == 2) {
                    i = ((hashCode2 * 37) + 2) * 53;
                    hashCode = getIosLogRule().hashCode();
                }
                int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode3;
                return hashCode3;
            }
            hashCode2 = i + hashCode;
            int hashCode32 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode32;
            return hashCode32;
        }

        public static Rule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Rule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Rule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Rule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Rule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Rule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Rule parseFrom(InputStream inputStream) throws IOException {
            return (Rule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Rule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Rule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Rule parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Rule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Rule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Rule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Rule parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Rule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Rule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Rule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Rule rule) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(rule);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RuleOrBuilder {
            private SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> generalRuleBuilder_;
            private SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> iosLogRuleBuilder_;
            private int ruleOneofCase_;
            private Object ruleOneof_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_fieldAccessorTable.ensureFieldAccessorsInitialized(Rule.class, Builder.class);
            }

            private Builder() {
                this.ruleOneofCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.ruleOneofCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Rule.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.ruleOneofCase_ = 0;
                this.ruleOneof_ = null;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Rule_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Rule getDefaultInstanceForType() {
                return Rule.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Rule build() {
                Rule buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Rule buildPartial() {
                Rule rule = new Rule(this);
                if (this.ruleOneofCase_ == 1) {
                    SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> singleFieldBuilderV3 = this.generalRuleBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        rule.ruleOneof_ = this.ruleOneof_;
                    } else {
                        rule.ruleOneof_ = singleFieldBuilderV3.build();
                    }
                }
                if (this.ruleOneofCase_ == 2) {
                    SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> singleFieldBuilderV32 = this.iosLogRuleBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        rule.ruleOneof_ = this.ruleOneof_;
                    } else {
                        rule.ruleOneof_ = singleFieldBuilderV32.build();
                    }
                }
                rule.ruleOneofCase_ = this.ruleOneofCase_;
                onBuilt();
                return rule;
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
                if (message instanceof Rule) {
                    return mergeFrom((Rule) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Rule rule) {
                if (rule == Rule.getDefaultInstance()) {
                    return this;
                }
                int i = AnonymousClass2.$SwitchMap$io$bidmachine$protobuf$sdk$Reader$Rule$RuleOneofCase[rule.getRuleOneofCase().ordinal()];
                if (i == 1) {
                    mergeGeneralRule(rule.getGeneralRule());
                } else if (i == 2) {
                    mergeIosLogRule(rule.getIosLogRule());
                }
                mergeUnknownFields(rule.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Rule rule = null;
                try {
                    try {
                        Rule rule2 = (Rule) Rule.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (rule2 != null) {
                            mergeFrom(rule2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Rule rule3 = (Rule) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            rule = rule3;
                            if (rule != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (rule != null) {
                        mergeFrom(rule);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
            public RuleOneofCase getRuleOneofCase() {
                return RuleOneofCase.forNumber(this.ruleOneofCase_);
            }

            public Builder clearRuleOneof() {
                this.ruleOneofCase_ = 0;
                this.ruleOneof_ = null;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
            public boolean hasGeneralRule() {
                return this.ruleOneofCase_ == 1;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
            public GeneralRule getGeneralRule() {
                SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> singleFieldBuilderV3 = this.generalRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.ruleOneofCase_ == 1) {
                        return (GeneralRule) this.ruleOneof_;
                    }
                    return GeneralRule.getDefaultInstance();
                }
                if (this.ruleOneofCase_ == 1) {
                    return singleFieldBuilderV3.getMessage();
                }
                return GeneralRule.getDefaultInstance();
            }

            public Builder setGeneralRule(GeneralRule generalRule) {
                SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> singleFieldBuilderV3 = this.generalRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    generalRule.getClass();
                    this.ruleOneof_ = generalRule;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(generalRule);
                }
                this.ruleOneofCase_ = 1;
                return this;
            }

            public Builder setGeneralRule(GeneralRule.Builder builder) {
                SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> singleFieldBuilderV3 = this.generalRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.ruleOneof_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.ruleOneofCase_ = 1;
                return this;
            }

            public Builder mergeGeneralRule(GeneralRule generalRule) {
                SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> singleFieldBuilderV3 = this.generalRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.ruleOneofCase_ == 1 && this.ruleOneof_ != GeneralRule.getDefaultInstance()) {
                        this.ruleOneof_ = GeneralRule.newBuilder((GeneralRule) this.ruleOneof_).mergeFrom(generalRule).buildPartial();
                    } else {
                        this.ruleOneof_ = generalRule;
                    }
                    onChanged();
                } else {
                    if (this.ruleOneofCase_ == 1) {
                        singleFieldBuilderV3.mergeFrom(generalRule);
                    }
                    this.generalRuleBuilder_.setMessage(generalRule);
                }
                this.ruleOneofCase_ = 1;
                return this;
            }

            public Builder clearGeneralRule() {
                SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> singleFieldBuilderV3 = this.generalRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.ruleOneofCase_ == 1) {
                        this.ruleOneofCase_ = 0;
                        this.ruleOneof_ = null;
                        onChanged();
                    }
                    return this;
                }
                if (this.ruleOneofCase_ == 1) {
                    this.ruleOneofCase_ = 0;
                    this.ruleOneof_ = null;
                }
                singleFieldBuilderV3.clear();
                return this;
            }

            public GeneralRule.Builder getGeneralRuleBuilder() {
                return getGeneralRuleFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
            public GeneralRuleOrBuilder getGeneralRuleOrBuilder() {
                SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> singleFieldBuilderV3;
                int i = this.ruleOneofCase_;
                if (i == 1 && (singleFieldBuilderV3 = this.generalRuleBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (i == 1) {
                    return (GeneralRule) this.ruleOneof_;
                }
                return GeneralRule.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GeneralRule, GeneralRule.Builder, GeneralRuleOrBuilder> getGeneralRuleFieldBuilder() {
                if (this.generalRuleBuilder_ == null) {
                    if (this.ruleOneofCase_ != 1) {
                        this.ruleOneof_ = GeneralRule.getDefaultInstance();
                    }
                    this.generalRuleBuilder_ = new SingleFieldBuilderV3<>((GeneralRule) this.ruleOneof_, getParentForChildren(), isClean());
                    this.ruleOneof_ = null;
                }
                this.ruleOneofCase_ = 1;
                onChanged();
                return this.generalRuleBuilder_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
            public boolean hasIosLogRule() {
                return this.ruleOneofCase_ == 2;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
            public IOSLogRule getIosLogRule() {
                SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> singleFieldBuilderV3 = this.iosLogRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.ruleOneofCase_ == 2) {
                        return (IOSLogRule) this.ruleOneof_;
                    }
                    return IOSLogRule.getDefaultInstance();
                }
                if (this.ruleOneofCase_ == 2) {
                    return singleFieldBuilderV3.getMessage();
                }
                return IOSLogRule.getDefaultInstance();
            }

            public Builder setIosLogRule(IOSLogRule iOSLogRule) {
                SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> singleFieldBuilderV3 = this.iosLogRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    iOSLogRule.getClass();
                    this.ruleOneof_ = iOSLogRule;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(iOSLogRule);
                }
                this.ruleOneofCase_ = 2;
                return this;
            }

            public Builder setIosLogRule(IOSLogRule.Builder builder) {
                SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> singleFieldBuilderV3 = this.iosLogRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.ruleOneof_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.ruleOneofCase_ = 2;
                return this;
            }

            public Builder mergeIosLogRule(IOSLogRule iOSLogRule) {
                SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> singleFieldBuilderV3 = this.iosLogRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.ruleOneofCase_ == 2 && this.ruleOneof_ != IOSLogRule.getDefaultInstance()) {
                        this.ruleOneof_ = IOSLogRule.newBuilder((IOSLogRule) this.ruleOneof_).mergeFrom(iOSLogRule).buildPartial();
                    } else {
                        this.ruleOneof_ = iOSLogRule;
                    }
                    onChanged();
                } else {
                    if (this.ruleOneofCase_ == 2) {
                        singleFieldBuilderV3.mergeFrom(iOSLogRule);
                    }
                    this.iosLogRuleBuilder_.setMessage(iOSLogRule);
                }
                this.ruleOneofCase_ = 2;
                return this;
            }

            public Builder clearIosLogRule() {
                SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> singleFieldBuilderV3 = this.iosLogRuleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.ruleOneofCase_ == 2) {
                        this.ruleOneofCase_ = 0;
                        this.ruleOneof_ = null;
                        onChanged();
                    }
                    return this;
                }
                if (this.ruleOneofCase_ == 2) {
                    this.ruleOneofCase_ = 0;
                    this.ruleOneof_ = null;
                }
                singleFieldBuilderV3.clear();
                return this;
            }

            public IOSLogRule.Builder getIosLogRuleBuilder() {
                return getIosLogRuleFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RuleOrBuilder
            public IOSLogRuleOrBuilder getIosLogRuleOrBuilder() {
                SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> singleFieldBuilderV3;
                int i = this.ruleOneofCase_;
                if (i == 2 && (singleFieldBuilderV3 = this.iosLogRuleBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (i == 2) {
                    return (IOSLogRule) this.ruleOneof_;
                }
                return IOSLogRule.getDefaultInstance();
            }

            private SingleFieldBuilderV3<IOSLogRule, IOSLogRule.Builder, IOSLogRuleOrBuilder> getIosLogRuleFieldBuilder() {
                if (this.iosLogRuleBuilder_ == null) {
                    if (this.ruleOneofCase_ != 2) {
                        this.ruleOneof_ = IOSLogRule.getDefaultInstance();
                    }
                    this.iosLogRuleBuilder_ = new SingleFieldBuilderV3<>((IOSLogRule) this.ruleOneof_, getParentForChildren(), isClean());
                    this.ruleOneof_ = null;
                }
                this.ruleOneofCase_ = 2;
                onChanged();
                return this.iosLogRuleBuilder_;
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

        public static Rule getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Rule> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<Rule> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Rule getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    /* renamed from: io.bidmachine.protobuf.sdk.Reader$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$sdk$Reader$Rule$RuleOneofCase;

        static {
            int[] iArr = new int[Rule.RuleOneofCase.values().length];
            $SwitchMap$io$bidmachine$protobuf$sdk$Reader$Rule$RuleOneofCase = iArr;
            try {
                iArr[Rule.RuleOneofCase.GENERAL_RULE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$sdk$Reader$Rule$RuleOneofCase[Rule.RuleOneofCase.IOS_LOG_RULE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$sdk$Reader$Rule$RuleOneofCase[Rule.RuleOneofCase.RULEONEOF_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class Record extends GeneratedMessageV3 implements RecordOrBuilder {
        public static final int ERROR_FIELD_NUMBER = 3;
        public static final int RAW_DATA_FIELD_NUMBER = 2;
        public static final int RULE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private Error error_;
        private byte memoizedIsInitialized;
        private BytesValue rawData_;
        private Rule rule_;
        private static final Record DEFAULT_INSTANCE = new Record();
        private static final Parser<Record> PARSER = new AbstractParser<Record>() { // from class: io.bidmachine.protobuf.sdk.Reader.Record.1
            @Override // com.explorestack.protobuf.Parser
            public Record parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Record(codedInputStream, extensionRegistryLite);
            }
        };

        private Record(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private Record() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Record();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Record(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                Rule rule = this.rule_;
                                Rule.Builder builder = rule != null ? rule.toBuilder() : null;
                                Rule rule2 = (Rule) codedInputStream.readMessage(Rule.parser(), extensionRegistryLite);
                                this.rule_ = rule2;
                                if (builder != null) {
                                    builder.mergeFrom(rule2);
                                    this.rule_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                BytesValue bytesValue = this.rawData_;
                                BytesValue.Builder builder2 = bytesValue != null ? bytesValue.toBuilder() : null;
                                BytesValue bytesValue2 = (BytesValue) codedInputStream.readMessage(BytesValue.parser(), extensionRegistryLite);
                                this.rawData_ = bytesValue2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(bytesValue2);
                                    this.rawData_ = builder2.buildPartial();
                                }
                            } else if (readTag == 26) {
                                Error error = this.error_;
                                Error.Builder builder3 = error != null ? error.toBuilder() : null;
                                Error error2 = (Error) codedInputStream.readMessage(Error.parser(), extensionRegistryLite);
                                this.error_ = error2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(error2);
                                    this.error_ = builder3.buildPartial();
                                }
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
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Record_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Record_fieldAccessorTable.ensureFieldAccessorsInitialized(Record.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public boolean hasRule() {
            return this.rule_ != null;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public Rule getRule() {
            Rule rule = this.rule_;
            return rule == null ? Rule.getDefaultInstance() : rule;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public RuleOrBuilder getRuleOrBuilder() {
            return getRule();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public boolean hasRawData() {
            return this.rawData_ != null;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public BytesValue getRawData() {
            BytesValue bytesValue = this.rawData_;
            return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public BytesValueOrBuilder getRawDataOrBuilder() {
            return getRawData();
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public boolean hasError() {
            return this.error_ != null;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public Error getError() {
            Error error = this.error_;
            return error == null ? Error.getDefaultInstance() : error;
        }

        @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
        public ErrorOrBuilder getErrorOrBuilder() {
            return getError();
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
            if (this.rule_ != null) {
                codedOutputStream.writeMessage(1, getRule());
            }
            if (this.rawData_ != null) {
                codedOutputStream.writeMessage(2, getRawData());
            }
            if (this.error_ != null) {
                codedOutputStream.writeMessage(3, getError());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.rule_ != null ? CodedOutputStream.computeMessageSize(1, getRule()) : 0;
            if (this.rawData_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, getRawData());
            }
            if (this.error_ != null) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, getError());
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
            if (!(obj instanceof Record)) {
                return super.equals(obj);
            }
            Record record = (Record) obj;
            if (hasRule() != record.hasRule()) {
                return false;
            }
            if ((hasRule() && !getRule().equals(record.getRule())) || hasRawData() != record.hasRawData()) {
                return false;
            }
            if ((!hasRawData() || getRawData().equals(record.getRawData())) && hasError() == record.hasError()) {
                return (!hasError() || getError().equals(record.getError())) && this.unknownFields.equals(record.unknownFields);
            }
            return false;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (hasRule()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getRule().hashCode();
            }
            if (hasRawData()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getRawData().hashCode();
            }
            if (hasError()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getError().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Record parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Record parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Record parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Record parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Record parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Record parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Record parseFrom(InputStream inputStream) throws IOException {
            return (Record) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Record parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Record) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Record parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Record) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Record parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Record) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Record parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Record) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Record parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Record) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Record record) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(record);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RecordOrBuilder {
            private SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> errorBuilder_;
            private Error error_;
            private SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> rawDataBuilder_;
            private BytesValue rawData_;
            private SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> ruleBuilder_;
            private Rule rule_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Record_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Record_fieldAccessorTable.ensureFieldAccessorsInitialized(Record.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Record.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.ruleBuilder_ == null) {
                    this.rule_ = null;
                } else {
                    this.rule_ = null;
                    this.ruleBuilder_ = null;
                }
                if (this.rawDataBuilder_ == null) {
                    this.rawData_ = null;
                } else {
                    this.rawData_ = null;
                    this.rawDataBuilder_ = null;
                }
                if (this.errorBuilder_ == null) {
                    this.error_ = null;
                    return this;
                }
                this.error_ = null;
                this.errorBuilder_ = null;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_Record_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Record getDefaultInstanceForType() {
                return Record.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Record build() {
                Record buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Record buildPartial() {
                Record record = new Record(this);
                SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> singleFieldBuilderV3 = this.ruleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    record.rule_ = this.rule_;
                } else {
                    record.rule_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> singleFieldBuilderV32 = this.rawDataBuilder_;
                if (singleFieldBuilderV32 == null) {
                    record.rawData_ = this.rawData_;
                } else {
                    record.rawData_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> singleFieldBuilderV33 = this.errorBuilder_;
                if (singleFieldBuilderV33 == null) {
                    record.error_ = this.error_;
                } else {
                    record.error_ = singleFieldBuilderV33.build();
                }
                onBuilt();
                return record;
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
                if (message instanceof Record) {
                    return mergeFrom((Record) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Record record) {
                if (record == Record.getDefaultInstance()) {
                    return this;
                }
                if (record.hasRule()) {
                    mergeRule(record.getRule());
                }
                if (record.hasRawData()) {
                    mergeRawData(record.getRawData());
                }
                if (record.hasError()) {
                    mergeError(record.getError());
                }
                mergeUnknownFields(record.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Record record = null;
                try {
                    try {
                        Record record2 = (Record) Record.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (record2 != null) {
                            mergeFrom(record2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Record record3 = (Record) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            record = record3;
                            if (record != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (record != null) {
                        mergeFrom(record);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public boolean hasRule() {
                return (this.ruleBuilder_ == null && this.rule_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public Rule getRule() {
                SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> singleFieldBuilderV3 = this.ruleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Rule rule = this.rule_;
                    return rule == null ? Rule.getDefaultInstance() : rule;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setRule(Rule rule) {
                SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> singleFieldBuilderV3 = this.ruleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    rule.getClass();
                    this.rule_ = rule;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(rule);
                return this;
            }

            public Builder setRule(Rule.Builder builder) {
                SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> singleFieldBuilderV3 = this.ruleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.rule_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeRule(Rule rule) {
                SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> singleFieldBuilderV3 = this.ruleBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Rule rule2 = this.rule_;
                    if (rule2 != null) {
                        this.rule_ = Rule.newBuilder(rule2).mergeFrom(rule).buildPartial();
                    } else {
                        this.rule_ = rule;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(rule);
                return this;
            }

            public Builder clearRule() {
                if (this.ruleBuilder_ == null) {
                    this.rule_ = null;
                    onChanged();
                    return this;
                }
                this.rule_ = null;
                this.ruleBuilder_ = null;
                return this;
            }

            public Rule.Builder getRuleBuilder() {
                onChanged();
                return getRuleFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public RuleOrBuilder getRuleOrBuilder() {
                SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> singleFieldBuilderV3 = this.ruleBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Rule rule = this.rule_;
                return rule == null ? Rule.getDefaultInstance() : rule;
            }

            private SingleFieldBuilderV3<Rule, Rule.Builder, RuleOrBuilder> getRuleFieldBuilder() {
                if (this.ruleBuilder_ == null) {
                    this.ruleBuilder_ = new SingleFieldBuilderV3<>(getRule(), getParentForChildren(), isClean());
                    this.rule_ = null;
                }
                return this.ruleBuilder_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public boolean hasRawData() {
                return (this.rawDataBuilder_ == null && this.rawData_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public BytesValue getRawData() {
                SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> singleFieldBuilderV3 = this.rawDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BytesValue bytesValue = this.rawData_;
                    return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setRawData(BytesValue bytesValue) {
                SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> singleFieldBuilderV3 = this.rawDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    bytesValue.getClass();
                    this.rawData_ = bytesValue;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(bytesValue);
                return this;
            }

            public Builder setRawData(BytesValue.Builder builder) {
                SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> singleFieldBuilderV3 = this.rawDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.rawData_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeRawData(BytesValue bytesValue) {
                SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> singleFieldBuilderV3 = this.rawDataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    BytesValue bytesValue2 = this.rawData_;
                    if (bytesValue2 != null) {
                        this.rawData_ = BytesValue.newBuilder(bytesValue2).mergeFrom(bytesValue).buildPartial();
                    } else {
                        this.rawData_ = bytesValue;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(bytesValue);
                return this;
            }

            public Builder clearRawData() {
                if (this.rawDataBuilder_ == null) {
                    this.rawData_ = null;
                    onChanged();
                    return this;
                }
                this.rawData_ = null;
                this.rawDataBuilder_ = null;
                return this;
            }

            public BytesValue.Builder getRawDataBuilder() {
                onChanged();
                return getRawDataFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public BytesValueOrBuilder getRawDataOrBuilder() {
                SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> singleFieldBuilderV3 = this.rawDataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                BytesValue bytesValue = this.rawData_;
                return bytesValue == null ? BytesValue.getDefaultInstance() : bytesValue;
            }

            private SingleFieldBuilderV3<BytesValue, BytesValue.Builder, BytesValueOrBuilder> getRawDataFieldBuilder() {
                if (this.rawDataBuilder_ == null) {
                    this.rawDataBuilder_ = new SingleFieldBuilderV3<>(getRawData(), getParentForChildren(), isClean());
                    this.rawData_ = null;
                }
                return this.rawDataBuilder_;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public boolean hasError() {
                return (this.errorBuilder_ == null && this.error_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public Error getError() {
                SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Error error = this.error_;
                    return error == null ? Error.getDefaultInstance() : error;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setError(Error error) {
                SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
                if (singleFieldBuilderV3 == null) {
                    error.getClass();
                    this.error_ = error;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(error);
                return this;
            }

            public Builder setError(Error.Builder builder) {
                SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.error_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeError(Error error) {
                SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Error error2 = this.error_;
                    if (error2 != null) {
                        this.error_ = Error.newBuilder(error2).mergeFrom(error).buildPartial();
                    } else {
                        this.error_ = error;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(error);
                return this;
            }

            public Builder clearError() {
                if (this.errorBuilder_ == null) {
                    this.error_ = null;
                    onChanged();
                    return this;
                }
                this.error_ = null;
                this.errorBuilder_ = null;
                return this;
            }

            public Error.Builder getErrorBuilder() {
                onChanged();
                return getErrorFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sdk.Reader.RecordOrBuilder
            public ErrorOrBuilder getErrorOrBuilder() {
                SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> singleFieldBuilderV3 = this.errorBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Error error = this.error_;
                return error == null ? Error.getDefaultInstance() : error;
            }

            private SingleFieldBuilderV3<Error, Error.Builder, ErrorOrBuilder> getErrorFieldBuilder() {
                if (this.errorBuilder_ == null) {
                    this.errorBuilder_ = new SingleFieldBuilderV3<>(getError(), getParentForChildren(), isClean());
                    this.error_ = null;
                }
                return this.errorBuilder_;
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

        public static Record getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Record> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<Record> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Record getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public boolean hasTimestamp() {
        return this.timestamp_ != null;
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public Timestamp getTimestamp() {
        Timestamp timestamp = this.timestamp_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public TimestampOrBuilder getTimestampOrBuilder() {
        return getTimestamp();
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public List<Record> getRecordsList() {
        return this.records_;
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public List<? extends RecordOrBuilder> getRecordsOrBuilderList() {
        return this.records_;
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public int getRecordsCount() {
        return this.records_.size();
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public Record getRecords(int i) {
        return this.records_.get(i);
    }

    @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
    public RecordOrBuilder getRecordsOrBuilder(int i) {
        return this.records_.get(i);
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
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
        }
        if (this.timestamp_ != null) {
            codedOutputStream.writeMessage(2, getTimestamp());
        }
        for (int i = 0; i < this.records_.size(); i++) {
            codedOutputStream.writeMessage(3, this.records_.get(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getNameBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.name_) : 0;
        if (this.timestamp_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getTimestamp());
        }
        for (int i2 = 0; i2 < this.records_.size(); i2++) {
            computeStringSize += CodedOutputStream.computeMessageSize(3, this.records_.get(i2));
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
        if (!(obj instanceof Reader)) {
            return super.equals(obj);
        }
        Reader reader = (Reader) obj;
        if (getName().equals(reader.getName()) && hasTimestamp() == reader.hasTimestamp()) {
            return (!hasTimestamp() || getTimestamp().equals(reader.getTimestamp())) && getRecordsList().equals(reader.getRecordsList()) && this.unknownFields.equals(reader.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (hasTimestamp()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getTimestamp().hashCode();
        }
        if (getRecordsCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getRecordsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static Reader parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Reader parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Reader parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Reader parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Reader parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Reader parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Reader parseFrom(InputStream inputStream) throws IOException {
        return (Reader) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Reader parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Reader) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Reader parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Reader) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Reader parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Reader) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Reader parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Reader) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Reader parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Reader) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Reader reader) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(reader);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReaderOrBuilder {
        private int bitField0_;
        private Object name_;
        private RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> recordsBuilder_;
        private List<Record> records_;
        private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> timestampBuilder_;
        private Timestamp timestamp_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_fieldAccessorTable.ensureFieldAccessorsInitialized(Reader.class, Builder.class);
        }

        private Builder() {
            this.name_ = "";
            this.records_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.records_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Reader.alwaysUseFieldBuilders) {
                getRecordsFieldBuilder();
            }
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.name_ = "";
            if (this.timestampBuilder_ == null) {
                this.timestamp_ = null;
            } else {
                this.timestamp_ = null;
                this.timestampBuilder_ = null;
            }
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.records_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }
            repeatedFieldBuilderV3.clear();
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return SDKAnalyticV2Proto.internal_static_bidmachine_protobuf_sdk_analytics_v2_Reader_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Reader getDefaultInstanceForType() {
            return Reader.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Reader build() {
            Reader buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Reader buildPartial() {
            Reader reader = new Reader(this);
            reader.name_ = this.name_;
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
            if (singleFieldBuilderV3 == null) {
                reader.timestamp_ = this.timestamp_;
            } else {
                reader.timestamp_ = singleFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                reader.records_ = repeatedFieldBuilderV3.build();
            } else {
                if ((this.bitField0_ & 1) != 0) {
                    this.records_ = Collections.unmodifiableList(this.records_);
                    this.bitField0_ &= -2;
                }
                reader.records_ = this.records_;
            }
            onBuilt();
            return reader;
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
            if (message instanceof Reader) {
                return mergeFrom((Reader) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(Reader reader) {
            if (reader == Reader.getDefaultInstance()) {
                return this;
            }
            if (!reader.getName().isEmpty()) {
                this.name_ = reader.name_;
                onChanged();
            }
            if (reader.hasTimestamp()) {
                mergeTimestamp(reader.getTimestamp());
            }
            if (this.recordsBuilder_ == null) {
                if (!reader.records_.isEmpty()) {
                    if (this.records_.isEmpty()) {
                        this.records_ = reader.records_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRecordsIsMutable();
                        this.records_.addAll(reader.records_);
                    }
                    onChanged();
                }
            } else if (!reader.records_.isEmpty()) {
                if (!this.recordsBuilder_.isEmpty()) {
                    this.recordsBuilder_.addAllMessages(reader.records_);
                } else {
                    this.recordsBuilder_.dispose();
                    this.recordsBuilder_ = null;
                    this.records_ = reader.records_;
                    this.bitField0_ &= -2;
                    this.recordsBuilder_ = Reader.alwaysUseFieldBuilders ? getRecordsFieldBuilder() : null;
                }
            }
            mergeUnknownFields(reader.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            Reader reader = null;
            try {
                try {
                    Reader reader2 = (Reader) Reader.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (reader2 != null) {
                        mergeFrom(reader2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    Reader reader3 = (Reader) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        reader = reader3;
                        if (reader != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (reader != null) {
                    mergeFrom(reader);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String str) {
            str.getClass();
            this.name_ = str;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Reader.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Reader.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public boolean hasTimestamp() {
            return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public Timestamp getTimestamp() {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
            if (singleFieldBuilderV3 == null) {
                Timestamp timestamp = this.timestamp_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Builder setTimestamp(Timestamp timestamp) {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
            if (singleFieldBuilderV3 == null) {
                timestamp.getClass();
                this.timestamp_ = timestamp;
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(timestamp);
            return this;
        }

        public Builder setTimestamp(Timestamp.Builder builder) {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.timestamp_ = builder.build();
                onChanged();
                return this;
            }
            singleFieldBuilderV3.setMessage(builder.build());
            return this;
        }

        public Builder mergeTimestamp(Timestamp timestamp) {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
            if (singleFieldBuilderV3 == null) {
                Timestamp timestamp2 = this.timestamp_;
                if (timestamp2 != null) {
                    this.timestamp_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                } else {
                    this.timestamp_ = timestamp;
                }
                onChanged();
                return this;
            }
            singleFieldBuilderV3.mergeFrom(timestamp);
            return this;
        }

        public Builder clearTimestamp() {
            if (this.timestampBuilder_ == null) {
                this.timestamp_ = null;
                onChanged();
                return this;
            }
            this.timestamp_ = null;
            this.timestampBuilder_ = null;
            return this;
        }

        public Timestamp.Builder getTimestampBuilder() {
            onChanged();
            return getTimestampFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public TimestampOrBuilder getTimestampOrBuilder() {
            SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Timestamp timestamp = this.timestamp_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getTimestampFieldBuilder() {
            if (this.timestampBuilder_ == null) {
                this.timestampBuilder_ = new SingleFieldBuilderV3<>(getTimestamp(), getParentForChildren(), isClean());
                this.timestamp_ = null;
            }
            return this.timestampBuilder_;
        }

        private void ensureRecordsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.records_ = new ArrayList(this.records_);
                this.bitField0_ |= 1;
            }
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public List<Record> getRecordsList() {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.records_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public int getRecordsCount() {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.records_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public Record getRecords(int i) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.records_.get(i);
            }
            return repeatedFieldBuilderV3.getMessage(i);
        }

        public Builder setRecords(int i, Record record) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                record.getClass();
                ensureRecordsIsMutable();
                this.records_.set(i, record);
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.setMessage(i, record);
            return this;
        }

        public Builder setRecords(int i, Record.Builder builder) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRecordsIsMutable();
                this.records_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.setMessage(i, builder.build());
            return this;
        }

        public Builder addRecords(Record record) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                record.getClass();
                ensureRecordsIsMutable();
                this.records_.add(record);
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.addMessage(record);
            return this;
        }

        public Builder addRecords(int i, Record record) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                record.getClass();
                ensureRecordsIsMutable();
                this.records_.add(i, record);
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.addMessage(i, record);
            return this;
        }

        public Builder addRecords(Record.Builder builder) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRecordsIsMutable();
                this.records_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.addMessage(builder.build());
            return this;
        }

        public Builder addRecords(int i, Record.Builder builder) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRecordsIsMutable();
                this.records_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllRecords(Iterable<? extends Record> iterable) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRecordsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.records_);
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.addAllMessages(iterable);
            return this;
        }

        public Builder clearRecords() {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.records_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.clear();
            return this;
        }

        public Builder removeRecords(int i) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRecordsIsMutable();
                this.records_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilderV3.remove(i);
            return this;
        }

        public Record.Builder getRecordsBuilder(int i) {
            return getRecordsFieldBuilder().getBuilder(i);
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public RecordOrBuilder getRecordsOrBuilder(int i) {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.records_.get(i);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // io.bidmachine.protobuf.sdk.ReaderOrBuilder
        public List<? extends RecordOrBuilder> getRecordsOrBuilderList() {
            RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> repeatedFieldBuilderV3 = this.recordsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.records_);
        }

        public Record.Builder addRecordsBuilder() {
            return getRecordsFieldBuilder().addBuilder(Record.getDefaultInstance());
        }

        public Record.Builder addRecordsBuilder(int i) {
            return getRecordsFieldBuilder().addBuilder(i, Record.getDefaultInstance());
        }

        public List<Record.Builder> getRecordsBuilderList() {
            return getRecordsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Record, Record.Builder, RecordOrBuilder> getRecordsFieldBuilder() {
            if (this.recordsBuilder_ == null) {
                this.recordsBuilder_ = new RepeatedFieldBuilderV3<>(this.records_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.records_ = null;
            }
            return this.recordsBuilder_;
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

    public static Reader getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Reader> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<Reader> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public Reader getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
