package io.bidmachine.protobuf.rendering;

import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
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
import com.explorestack.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes8.dex */
public final class RenderingFeature extends GeneratedMessageV3 implements RenderingFeatureOrBuilder {
    public static final int BROKEN_CREATIVE_DETECTOR_FIELD_NUMBER = 1;
    private static final RenderingFeature DEFAULT_INSTANCE = new RenderingFeature();
    private static final Parser<RenderingFeature> PARSER = new AbstractParser<RenderingFeature>() { // from class: io.bidmachine.protobuf.rendering.RenderingFeature.1
        @Override // com.explorestack.protobuf.Parser
        public RenderingFeature parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RenderingFeature(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private int featureCase_;
    private Object feature_;
    private byte memoizedIsInitialized;

    public interface BrokenCreativeDetectorOrBuilder extends MessageOrBuilder {
        BrokenCreativeDetector.Configuration getConfiguration();

        BrokenCreativeDetector.ConfigurationOrBuilder getConfigurationOrBuilder();

        BrokenCreativeDetector.Event getEvent();

        BrokenCreativeDetector.EventOrBuilder getEventOrBuilder();

        BrokenCreativeDetector.PayloadOneofCase getPayloadOneofCase();

        boolean hasConfiguration();

        boolean hasEvent();
    }

    private RenderingFeature(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.featureCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    private RenderingFeature() {
        this.featureCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new RenderingFeature();
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private RenderingFeature(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            BrokenCreativeDetector.Builder builder = this.featureCase_ == 1 ? ((BrokenCreativeDetector) this.feature_).toBuilder() : null;
                            MessageLite readMessage = codedInputStream.readMessage(BrokenCreativeDetector.parser(), extensionRegistryLite);
                            this.feature_ = readMessage;
                            if (builder != null) {
                                builder.mergeFrom((BrokenCreativeDetector) readMessage);
                                this.feature_ = builder.buildPartial();
                            }
                            this.featureCase_ = 1;
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
        return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_descriptor;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_fieldAccessorTable.ensureFieldAccessorsInitialized(RenderingFeature.class, Builder.class);
    }

    public static final class BrokenCreativeDetector extends GeneratedMessageV3 implements BrokenCreativeDetectorOrBuilder {
        public static final int CONFIGURATION_FIELD_NUMBER = 2;
        public static final int EVENT_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int payloadOneofCase_;
        private Object payloadOneof_;
        private static final BrokenCreativeDetector DEFAULT_INSTANCE = new BrokenCreativeDetector();
        private static final Parser<BrokenCreativeDetector> PARSER = new AbstractParser<BrokenCreativeDetector>() { // from class: io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.1
            @Override // com.explorestack.protobuf.Parser
            public BrokenCreativeDetector parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BrokenCreativeDetector(codedInputStream, extensionRegistryLite);
            }
        };

        public interface AlgorithmOrBuilder extends MessageOrBuilder {
            String getName();

            ByteString getNameBytes();

            double getThreshold();

            double getWeight();
        }

        public interface AlgorithmResultOrBuilder extends MessageOrBuilder {
            Algorithm getAlgorithm();

            AlgorithmOrBuilder getAlgorithmOrBuilder();

            double getDuration();

            int getResult();

            boolean hasAlgorithm();
        }

        public interface ConfigurationOrBuilder extends MessageOrBuilder {
            Algorithm getAlgorithms(int i);

            int getAlgorithmsCount();

            List<Algorithm> getAlgorithmsList();

            AlgorithmOrBuilder getAlgorithmsOrBuilder(int i);

            List<? extends AlgorithmOrBuilder> getAlgorithmsOrBuilderList();

            boolean getAllowDuplicate();

            double getDownscaleFactor();

            boolean getErrorOnly();

            String getStopAfter();

            ByteString getStopAfterBytes();

            double getTimeout();

            double getWeightThreshold();
        }

        public interface EventOrBuilder extends MessageOrBuilder {
            AlgorithmResult getAlgorithmsResults(int i);

            int getAlgorithmsResultsCount();

            List<AlgorithmResult> getAlgorithmsResultsList();

            AlgorithmResultOrBuilder getAlgorithmsResultsOrBuilder(int i);

            List<? extends AlgorithmResultOrBuilder> getAlgorithmsResultsOrBuilderList();

            String getComponent();

            ByteString getComponentBytes();

            double getDuration();

            int getPhase();

            int getResult();
        }

        private BrokenCreativeDetector(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.payloadOneofCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        private BrokenCreativeDetector() {
            this.payloadOneofCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new BrokenCreativeDetector();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BrokenCreativeDetector(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    Event.Builder builder = this.payloadOneofCase_ == 1 ? ((Event) this.payloadOneof_).toBuilder() : null;
                                    MessageLite readMessage = codedInputStream.readMessage(Event.parser(), extensionRegistryLite);
                                    this.payloadOneof_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom((Event) readMessage);
                                        this.payloadOneof_ = builder.buildPartial();
                                    }
                                    this.payloadOneofCase_ = 1;
                                } else if (readTag == 18) {
                                    Configuration.Builder builder2 = this.payloadOneofCase_ == 2 ? ((Configuration) this.payloadOneof_).toBuilder() : null;
                                    MessageLite readMessage2 = codedInputStream.readMessage(Configuration.parser(), extensionRegistryLite);
                                    this.payloadOneof_ = readMessage2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Configuration) readMessage2);
                                        this.payloadOneof_ = builder2.buildPartial();
                                    }
                                    this.payloadOneofCase_ = 2;
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
            return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_fieldAccessorTable.ensureFieldAccessorsInitialized(BrokenCreativeDetector.class, Builder.class);
        }

        public static final class Algorithm extends GeneratedMessageV3 implements AlgorithmOrBuilder {
            public static final int NAME_FIELD_NUMBER = 1;
            public static final int THRESHOLD_FIELD_NUMBER = 3;
            public static final int WEIGHT_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private volatile Object name_;
            private double threshold_;
            private double weight_;
            private static final Algorithm DEFAULT_INSTANCE = new Algorithm();
            private static final Parser<Algorithm> PARSER = new AbstractParser<Algorithm>() { // from class: io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.Algorithm.1
                @Override // com.explorestack.protobuf.Parser
                public Algorithm parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Algorithm(codedInputStream, extensionRegistryLite);
                }
            };

            private Algorithm(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private Algorithm() {
                this.memoizedIsInitialized = (byte) -1;
                this.name_ = "";
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new Algorithm();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private Algorithm(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 17) {
                                    this.weight_ = codedInputStream.readDouble();
                                } else if (readTag == 25) {
                                    this.threshold_ = codedInputStream.readDouble();
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
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Algorithm_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Algorithm_fieldAccessorTable.ensureFieldAccessorsInitialized(Algorithm.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
            public double getWeight() {
                return this.weight_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
            public double getThreshold() {
                return this.threshold_;
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
                double d = this.weight_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(2, d);
                }
                double d2 = this.threshold_;
                if (d2 != 0.0d) {
                    codedOutputStream.writeDouble(3, d2);
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
                double d = this.weight_;
                if (d != 0.0d) {
                    computeStringSize += CodedOutputStream.computeDoubleSize(2, d);
                }
                double d2 = this.threshold_;
                if (d2 != 0.0d) {
                    computeStringSize += CodedOutputStream.computeDoubleSize(3, d2);
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
                if (!(obj instanceof Algorithm)) {
                    return super.equals(obj);
                }
                Algorithm algorithm = (Algorithm) obj;
                return getName().equals(algorithm.getName()) && Double.doubleToLongBits(getWeight()) == Double.doubleToLongBits(algorithm.getWeight()) && Double.doubleToLongBits(getThreshold()) == Double.doubleToLongBits(algorithm.getThreshold()) && this.unknownFields.equals(algorithm.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getWeight()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getThreshold()))) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode;
                return hashCode;
            }

            public static Algorithm parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Algorithm parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static Algorithm parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Algorithm parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Algorithm parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Algorithm parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Algorithm parseFrom(InputStream inputStream) throws IOException {
                return (Algorithm) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Algorithm parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Algorithm) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Algorithm parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Algorithm) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Algorithm parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Algorithm) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Algorithm parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Algorithm) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Algorithm parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Algorithm) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Algorithm algorithm) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(algorithm);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AlgorithmOrBuilder {
                private Object name_;
                private double threshold_;
                private double weight_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Algorithm_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Algorithm_fieldAccessorTable.ensureFieldAccessorsInitialized(Algorithm.class, Builder.class);
                }

                private Builder() {
                    this.name_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.name_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = Algorithm.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.name_ = "";
                    this.weight_ = 0.0d;
                    this.threshold_ = 0.0d;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Algorithm_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Algorithm getDefaultInstanceForType() {
                    return Algorithm.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Algorithm build() {
                    Algorithm buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Algorithm buildPartial() {
                    Algorithm algorithm = new Algorithm(this);
                    algorithm.name_ = this.name_;
                    algorithm.weight_ = this.weight_;
                    algorithm.threshold_ = this.threshold_;
                    onBuilt();
                    return algorithm;
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
                    if (message instanceof Algorithm) {
                        return mergeFrom((Algorithm) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Algorithm algorithm) {
                    if (algorithm == Algorithm.getDefaultInstance()) {
                        return this;
                    }
                    if (!algorithm.getName().isEmpty()) {
                        this.name_ = algorithm.name_;
                        onChanged();
                    }
                    if (algorithm.getWeight() != 0.0d) {
                        setWeight(algorithm.getWeight());
                    }
                    if (algorithm.getThreshold() != 0.0d) {
                        setThreshold(algorithm.getThreshold());
                    }
                    mergeUnknownFields(algorithm.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Algorithm algorithm = null;
                    try {
                        try {
                            Algorithm algorithm2 = (Algorithm) Algorithm.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (algorithm2 != null) {
                                mergeFrom(algorithm2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Algorithm algorithm3 = (Algorithm) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                algorithm = algorithm3;
                                if (algorithm != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (algorithm != null) {
                            mergeFrom(algorithm);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
                public String getName() {
                    Object obj = this.name_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.name_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
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
                    this.name_ = Algorithm.getDefaultInstance().getName();
                    onChanged();
                    return this;
                }

                public Builder setNameBytes(ByteString byteString) {
                    byteString.getClass();
                    Algorithm.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
                public double getWeight() {
                    return this.weight_;
                }

                public Builder setWeight(double d) {
                    this.weight_ = d;
                    onChanged();
                    return this;
                }

                public Builder clearWeight() {
                    this.weight_ = 0.0d;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmOrBuilder
                public double getThreshold() {
                    return this.threshold_;
                }

                public Builder setThreshold(double d) {
                    this.threshold_ = d;
                    onChanged();
                    return this;
                }

                public Builder clearThreshold() {
                    this.threshold_ = 0.0d;
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

            public static Algorithm getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Algorithm> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<Algorithm> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Algorithm getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class AlgorithmResult extends GeneratedMessageV3 implements AlgorithmResultOrBuilder {
            public static final int ALGORITHM_FIELD_NUMBER = 3;
            public static final int DURATION_FIELD_NUMBER = 2;
            public static final int RESULT_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private Algorithm algorithm_;
            private double duration_;
            private byte memoizedIsInitialized;
            private int result_;
            private static final AlgorithmResult DEFAULT_INSTANCE = new AlgorithmResult();
            private static final Parser<AlgorithmResult> PARSER = new AbstractParser<AlgorithmResult>() { // from class: io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResult.1
                @Override // com.explorestack.protobuf.Parser
                public AlgorithmResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new AlgorithmResult(codedInputStream, extensionRegistryLite);
                }
            };

            private AlgorithmResult(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private AlgorithmResult() {
                this.memoizedIsInitialized = (byte) -1;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new AlgorithmResult();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private AlgorithmResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.result_ = codedInputStream.readInt32();
                                } else if (readTag == 17) {
                                    this.duration_ = codedInputStream.readDouble();
                                } else if (readTag == 26) {
                                    Algorithm algorithm = this.algorithm_;
                                    Algorithm.Builder builder = algorithm != null ? algorithm.toBuilder() : null;
                                    Algorithm algorithm2 = (Algorithm) codedInputStream.readMessage(Algorithm.parser(), extensionRegistryLite);
                                    this.algorithm_ = algorithm2;
                                    if (builder != null) {
                                        builder.mergeFrom(algorithm2);
                                        this.algorithm_ = builder.buildPartial();
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
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_AlgorithmResult_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_AlgorithmResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AlgorithmResult.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
            public int getResult() {
                return this.result_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
            public double getDuration() {
                return this.duration_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
            public boolean hasAlgorithm() {
                return this.algorithm_ != null;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
            public Algorithm getAlgorithm() {
                Algorithm algorithm = this.algorithm_;
                return algorithm == null ? Algorithm.getDefaultInstance() : algorithm;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
            public AlgorithmOrBuilder getAlgorithmOrBuilder() {
                return getAlgorithm();
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
                int i = this.result_;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                double d = this.duration_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(2, d);
                }
                if (this.algorithm_ != null) {
                    codedOutputStream.writeMessage(3, getAlgorithm());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.result_;
                int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
                double d = this.duration_;
                if (d != 0.0d) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(2, d);
                }
                if (this.algorithm_ != null) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(3, getAlgorithm());
                }
                int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof AlgorithmResult)) {
                    return super.equals(obj);
                }
                AlgorithmResult algorithmResult = (AlgorithmResult) obj;
                if (getResult() == algorithmResult.getResult() && Double.doubleToLongBits(getDuration()) == Double.doubleToLongBits(algorithmResult.getDuration()) && hasAlgorithm() == algorithmResult.hasAlgorithm()) {
                    return (!hasAlgorithm() || getAlgorithm().equals(algorithmResult.getAlgorithm())) && this.unknownFields.equals(algorithmResult.unknownFields);
                }
                return false;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getResult()) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getDuration()));
                if (hasAlgorithm()) {
                    hashCode = (((hashCode * 37) + 3) * 53) + getAlgorithm().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static AlgorithmResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static AlgorithmResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static AlgorithmResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static AlgorithmResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static AlgorithmResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static AlgorithmResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static AlgorithmResult parseFrom(InputStream inputStream) throws IOException {
                return (AlgorithmResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static AlgorithmResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AlgorithmResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static AlgorithmResult parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AlgorithmResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static AlgorithmResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AlgorithmResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static AlgorithmResult parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AlgorithmResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static AlgorithmResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AlgorithmResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(AlgorithmResult algorithmResult) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(algorithmResult);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AlgorithmResultOrBuilder {
                private SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> algorithmBuilder_;
                private Algorithm algorithm_;
                private double duration_;
                private int result_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_AlgorithmResult_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_AlgorithmResult_fieldAccessorTable.ensureFieldAccessorsInitialized(AlgorithmResult.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = AlgorithmResult.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.result_ = 0;
                    this.duration_ = 0.0d;
                    if (this.algorithmBuilder_ == null) {
                        this.algorithm_ = null;
                        return this;
                    }
                    this.algorithm_ = null;
                    this.algorithmBuilder_ = null;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_AlgorithmResult_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public AlgorithmResult getDefaultInstanceForType() {
                    return AlgorithmResult.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public AlgorithmResult build() {
                    AlgorithmResult buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public AlgorithmResult buildPartial() {
                    AlgorithmResult algorithmResult = new AlgorithmResult(this);
                    algorithmResult.result_ = this.result_;
                    algorithmResult.duration_ = this.duration_;
                    SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> singleFieldBuilderV3 = this.algorithmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        algorithmResult.algorithm_ = this.algorithm_;
                    } else {
                        algorithmResult.algorithm_ = singleFieldBuilderV3.build();
                    }
                    onBuilt();
                    return algorithmResult;
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
                    if (message instanceof AlgorithmResult) {
                        return mergeFrom((AlgorithmResult) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(AlgorithmResult algorithmResult) {
                    if (algorithmResult == AlgorithmResult.getDefaultInstance()) {
                        return this;
                    }
                    if (algorithmResult.getResult() != 0) {
                        setResult(algorithmResult.getResult());
                    }
                    if (algorithmResult.getDuration() != 0.0d) {
                        setDuration(algorithmResult.getDuration());
                    }
                    if (algorithmResult.hasAlgorithm()) {
                        mergeAlgorithm(algorithmResult.getAlgorithm());
                    }
                    mergeUnknownFields(algorithmResult.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    AlgorithmResult algorithmResult = null;
                    try {
                        try {
                            AlgorithmResult algorithmResult2 = (AlgorithmResult) AlgorithmResult.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (algorithmResult2 != null) {
                                mergeFrom(algorithmResult2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            AlgorithmResult algorithmResult3 = (AlgorithmResult) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                algorithmResult = algorithmResult3;
                                if (algorithmResult != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (algorithmResult != null) {
                            mergeFrom(algorithmResult);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
                public int getResult() {
                    return this.result_;
                }

                public Builder setResult(int i) {
                    this.result_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearResult() {
                    this.result_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
                public double getDuration() {
                    return this.duration_;
                }

                public Builder setDuration(double d) {
                    this.duration_ = d;
                    onChanged();
                    return this;
                }

                public Builder clearDuration() {
                    this.duration_ = 0.0d;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
                public boolean hasAlgorithm() {
                    return (this.algorithmBuilder_ == null && this.algorithm_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
                public Algorithm getAlgorithm() {
                    SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> singleFieldBuilderV3 = this.algorithmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Algorithm algorithm = this.algorithm_;
                        return algorithm == null ? Algorithm.getDefaultInstance() : algorithm;
                    }
                    return singleFieldBuilderV3.getMessage();
                }

                public Builder setAlgorithm(Algorithm algorithm) {
                    SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> singleFieldBuilderV3 = this.algorithmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        algorithm.getClass();
                        this.algorithm_ = algorithm;
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(algorithm);
                    return this;
                }

                public Builder setAlgorithm(Algorithm.Builder builder) {
                    SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> singleFieldBuilderV3 = this.algorithmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.algorithm_ = builder.build();
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }

                public Builder mergeAlgorithm(Algorithm algorithm) {
                    SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> singleFieldBuilderV3 = this.algorithmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Algorithm algorithm2 = this.algorithm_;
                        if (algorithm2 != null) {
                            this.algorithm_ = Algorithm.newBuilder(algorithm2).mergeFrom(algorithm).buildPartial();
                        } else {
                            this.algorithm_ = algorithm;
                        }
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.mergeFrom(algorithm);
                    return this;
                }

                public Builder clearAlgorithm() {
                    if (this.algorithmBuilder_ == null) {
                        this.algorithm_ = null;
                        onChanged();
                        return this;
                    }
                    this.algorithm_ = null;
                    this.algorithmBuilder_ = null;
                    return this;
                }

                public Algorithm.Builder getAlgorithmBuilder() {
                    onChanged();
                    return getAlgorithmFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.AlgorithmResultOrBuilder
                public AlgorithmOrBuilder getAlgorithmOrBuilder() {
                    SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> singleFieldBuilderV3 = this.algorithmBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    Algorithm algorithm = this.algorithm_;
                    return algorithm == null ? Algorithm.getDefaultInstance() : algorithm;
                }

                private SingleFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> getAlgorithmFieldBuilder() {
                    if (this.algorithmBuilder_ == null) {
                        this.algorithmBuilder_ = new SingleFieldBuilderV3<>(getAlgorithm(), getParentForChildren(), isClean());
                        this.algorithm_ = null;
                    }
                    return this.algorithmBuilder_;
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

            public static AlgorithmResult getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AlgorithmResult> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<AlgorithmResult> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AlgorithmResult getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class Event extends GeneratedMessageV3 implements EventOrBuilder {
            public static final int ALGORITHMS_RESULTS_FIELD_NUMBER = 5;
            public static final int COMPONENT_FIELD_NUMBER = 4;
            public static final int DURATION_FIELD_NUMBER = 3;
            public static final int PHASE_FIELD_NUMBER = 1;
            public static final int RESULT_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private List<AlgorithmResult> algorithmsResults_;
            private volatile Object component_;
            private double duration_;
            private byte memoizedIsInitialized;
            private int phase_;
            private int result_;
            private static final Event DEFAULT_INSTANCE = new Event();
            private static final Parser<Event> PARSER = new AbstractParser<Event>() { // from class: io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.Event.1
                @Override // com.explorestack.protobuf.Parser
                public Event parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Event(codedInputStream, extensionRegistryLite);
                }
            };

            private Event(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private Event() {
                this.memoizedIsInitialized = (byte) -1;
                this.component_ = "";
                this.algorithmsResults_ = Collections.emptyList();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new Event();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private Event(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.phase_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.result_ = codedInputStream.readInt32();
                                } else if (readTag == 25) {
                                    this.duration_ = codedInputStream.readDouble();
                                } else if (readTag == 34) {
                                    this.component_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 42) {
                                    if (!z2) {
                                        this.algorithmsResults_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.algorithmsResults_.add(codedInputStream.readMessage(AlgorithmResult.parser(), extensionRegistryLite));
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
                            this.algorithmsResults_ = Collections.unmodifiableList(this.algorithmsResults_);
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Event_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public int getPhase() {
                return this.phase_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public int getResult() {
                return this.result_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public double getDuration() {
                return this.duration_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public String getComponent() {
                Object obj = this.component_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.component_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public ByteString getComponentBytes() {
                Object obj = this.component_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.component_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public List<AlgorithmResult> getAlgorithmsResultsList() {
                return this.algorithmsResults_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public List<? extends AlgorithmResultOrBuilder> getAlgorithmsResultsOrBuilderList() {
                return this.algorithmsResults_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public int getAlgorithmsResultsCount() {
                return this.algorithmsResults_.size();
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public AlgorithmResult getAlgorithmsResults(int i) {
                return this.algorithmsResults_.get(i);
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
            public AlgorithmResultOrBuilder getAlgorithmsResultsOrBuilder(int i) {
                return this.algorithmsResults_.get(i);
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
                int i = this.phase_;
                if (i != 0) {
                    codedOutputStream.writeInt32(1, i);
                }
                int i2 = this.result_;
                if (i2 != 0) {
                    codedOutputStream.writeInt32(2, i2);
                }
                double d = this.duration_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(3, d);
                }
                if (!getComponentBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 4, this.component_);
                }
                for (int i3 = 0; i3 < this.algorithmsResults_.size(); i3++) {
                    codedOutputStream.writeMessage(5, this.algorithmsResults_.get(i3));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int i2 = this.phase_;
                int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
                int i3 = this.result_;
                if (i3 != 0) {
                    computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
                }
                double d = this.duration_;
                if (d != 0.0d) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(3, d);
                }
                if (!getComponentBytes().isEmpty()) {
                    computeInt32Size += GeneratedMessageV3.computeStringSize(4, this.component_);
                }
                for (int i4 = 0; i4 < this.algorithmsResults_.size(); i4++) {
                    computeInt32Size += CodedOutputStream.computeMessageSize(5, this.algorithmsResults_.get(i4));
                }
                int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Event)) {
                    return super.equals(obj);
                }
                Event event = (Event) obj;
                return getPhase() == event.getPhase() && getResult() == event.getResult() && Double.doubleToLongBits(getDuration()) == Double.doubleToLongBits(event.getDuration()) && getComponent().equals(event.getComponent()) && getAlgorithmsResultsList().equals(event.getAlgorithmsResultsList()) && this.unknownFields.equals(event.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getPhase()) * 37) + 2) * 53) + getResult()) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getDuration()))) * 37) + 4) * 53) + getComponent().hashCode();
                if (getAlgorithmsResultsCount() > 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + getAlgorithmsResultsList().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static Event parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Event parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static Event parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Event parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Event parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Event parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Event parseFrom(InputStream inputStream) throws IOException {
                return (Event) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Event parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Event) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Event parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Event) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Event parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Event) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Event parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Event) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Event parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Event) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Event event) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(event);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EventOrBuilder {
                private RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> algorithmsResultsBuilder_;
                private List<AlgorithmResult> algorithmsResults_;
                private int bitField0_;
                private Object component_;
                private double duration_;
                private int phase_;
                private int result_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Event_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Event_fieldAccessorTable.ensureFieldAccessorsInitialized(Event.class, Builder.class);
                }

                private Builder() {
                    this.component_ = "";
                    this.algorithmsResults_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.component_ = "";
                    this.algorithmsResults_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (Event.alwaysUseFieldBuilders) {
                        getAlgorithmsResultsFieldBuilder();
                    }
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.phase_ = 0;
                    this.result_ = 0;
                    this.duration_ = 0.0d;
                    this.component_ = "";
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.algorithmsResults_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Event_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Event getDefaultInstanceForType() {
                    return Event.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Event build() {
                    Event buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Event buildPartial() {
                    Event event = new Event(this);
                    event.phase_ = this.phase_;
                    event.result_ = this.result_;
                    event.duration_ = this.duration_;
                    event.component_ = this.component_;
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        event.algorithmsResults_ = repeatedFieldBuilderV3.build();
                    } else {
                        if ((this.bitField0_ & 1) != 0) {
                            this.algorithmsResults_ = Collections.unmodifiableList(this.algorithmsResults_);
                            this.bitField0_ &= -2;
                        }
                        event.algorithmsResults_ = this.algorithmsResults_;
                    }
                    onBuilt();
                    return event;
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
                    if (message instanceof Event) {
                        return mergeFrom((Event) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Event event) {
                    if (event == Event.getDefaultInstance()) {
                        return this;
                    }
                    if (event.getPhase() != 0) {
                        setPhase(event.getPhase());
                    }
                    if (event.getResult() != 0) {
                        setResult(event.getResult());
                    }
                    if (event.getDuration() != 0.0d) {
                        setDuration(event.getDuration());
                    }
                    if (!event.getComponent().isEmpty()) {
                        this.component_ = event.component_;
                        onChanged();
                    }
                    if (this.algorithmsResultsBuilder_ == null) {
                        if (!event.algorithmsResults_.isEmpty()) {
                            if (this.algorithmsResults_.isEmpty()) {
                                this.algorithmsResults_ = event.algorithmsResults_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureAlgorithmsResultsIsMutable();
                                this.algorithmsResults_.addAll(event.algorithmsResults_);
                            }
                            onChanged();
                        }
                    } else if (!event.algorithmsResults_.isEmpty()) {
                        if (!this.algorithmsResultsBuilder_.isEmpty()) {
                            this.algorithmsResultsBuilder_.addAllMessages(event.algorithmsResults_);
                        } else {
                            this.algorithmsResultsBuilder_.dispose();
                            this.algorithmsResultsBuilder_ = null;
                            this.algorithmsResults_ = event.algorithmsResults_;
                            this.bitField0_ &= -2;
                            this.algorithmsResultsBuilder_ = Event.alwaysUseFieldBuilders ? getAlgorithmsResultsFieldBuilder() : null;
                        }
                    }
                    mergeUnknownFields(event.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Event event = null;
                    try {
                        try {
                            Event event2 = (Event) Event.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (event2 != null) {
                                mergeFrom(event2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Event event3 = (Event) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                event = event3;
                                if (event != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (event != null) {
                            mergeFrom(event);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public int getPhase() {
                    return this.phase_;
                }

                public Builder setPhase(int i) {
                    this.phase_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearPhase() {
                    this.phase_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public int getResult() {
                    return this.result_;
                }

                public Builder setResult(int i) {
                    this.result_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearResult() {
                    this.result_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public double getDuration() {
                    return this.duration_;
                }

                public Builder setDuration(double d) {
                    this.duration_ = d;
                    onChanged();
                    return this;
                }

                public Builder clearDuration() {
                    this.duration_ = 0.0d;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public String getComponent() {
                    Object obj = this.component_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.component_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public ByteString getComponentBytes() {
                    Object obj = this.component_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.component_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setComponent(String str) {
                    str.getClass();
                    this.component_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearComponent() {
                    this.component_ = Event.getDefaultInstance().getComponent();
                    onChanged();
                    return this;
                }

                public Builder setComponentBytes(ByteString byteString) {
                    byteString.getClass();
                    Event.checkByteStringIsUtf8(byteString);
                    this.component_ = byteString;
                    onChanged();
                    return this;
                }

                private void ensureAlgorithmsResultsIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.algorithmsResults_ = new ArrayList(this.algorithmsResults_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public List<AlgorithmResult> getAlgorithmsResultsList() {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return Collections.unmodifiableList(this.algorithmsResults_);
                    }
                    return repeatedFieldBuilderV3.getMessageList();
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public int getAlgorithmsResultsCount() {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.algorithmsResults_.size();
                    }
                    return repeatedFieldBuilderV3.getCount();
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public AlgorithmResult getAlgorithmsResults(int i) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.algorithmsResults_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessage(i);
                }

                public Builder setAlgorithmsResults(int i, AlgorithmResult algorithmResult) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        algorithmResult.getClass();
                        ensureAlgorithmsResultsIsMutable();
                        this.algorithmsResults_.set(i, algorithmResult);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, algorithmResult);
                    return this;
                }

                public Builder setAlgorithmsResults(int i, AlgorithmResult.Builder builder) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsResultsIsMutable();
                        this.algorithmsResults_.set(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }

                public Builder addAlgorithmsResults(AlgorithmResult algorithmResult) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        algorithmResult.getClass();
                        ensureAlgorithmsResultsIsMutable();
                        this.algorithmsResults_.add(algorithmResult);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(algorithmResult);
                    return this;
                }

                public Builder addAlgorithmsResults(int i, AlgorithmResult algorithmResult) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        algorithmResult.getClass();
                        ensureAlgorithmsResultsIsMutable();
                        this.algorithmsResults_.add(i, algorithmResult);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, algorithmResult);
                    return this;
                }

                public Builder addAlgorithmsResults(AlgorithmResult.Builder builder) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsResultsIsMutable();
                        this.algorithmsResults_.add(builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }

                public Builder addAlgorithmsResults(int i, AlgorithmResult.Builder builder) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsResultsIsMutable();
                        this.algorithmsResults_.add(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }

                public Builder addAllAlgorithmsResults(Iterable<? extends AlgorithmResult> iterable) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsResultsIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.algorithmsResults_);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }

                public Builder clearAlgorithmsResults() {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.algorithmsResults_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                public Builder removeAlgorithmsResults(int i) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsResultsIsMutable();
                        this.algorithmsResults_.remove(i);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }

                public AlgorithmResult.Builder getAlgorithmsResultsBuilder(int i) {
                    return getAlgorithmsResultsFieldBuilder().getBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public AlgorithmResultOrBuilder getAlgorithmsResultsOrBuilder(int i) {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.algorithmsResults_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessageOrBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.EventOrBuilder
                public List<? extends AlgorithmResultOrBuilder> getAlgorithmsResultsOrBuilderList() {
                    RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> repeatedFieldBuilderV3 = this.algorithmsResultsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        return repeatedFieldBuilderV3.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.algorithmsResults_);
                }

                public AlgorithmResult.Builder addAlgorithmsResultsBuilder() {
                    return getAlgorithmsResultsFieldBuilder().addBuilder(AlgorithmResult.getDefaultInstance());
                }

                public AlgorithmResult.Builder addAlgorithmsResultsBuilder(int i) {
                    return getAlgorithmsResultsFieldBuilder().addBuilder(i, AlgorithmResult.getDefaultInstance());
                }

                public List<AlgorithmResult.Builder> getAlgorithmsResultsBuilderList() {
                    return getAlgorithmsResultsFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<AlgorithmResult, AlgorithmResult.Builder, AlgorithmResultOrBuilder> getAlgorithmsResultsFieldBuilder() {
                    if (this.algorithmsResultsBuilder_ == null) {
                        this.algorithmsResultsBuilder_ = new RepeatedFieldBuilderV3<>(this.algorithmsResults_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                        this.algorithmsResults_ = null;
                    }
                    return this.algorithmsResultsBuilder_;
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

            public static Event getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Event> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<Event> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Event getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class Configuration extends GeneratedMessageV3 implements ConfigurationOrBuilder {
            public static final int ALGORITHMS_FIELD_NUMBER = 7;
            public static final int ALLOW_DUPLICATE_FIELD_NUMBER = 4;
            public static final int DOWNSCALE_FACTOR_FIELD_NUMBER = 2;
            public static final int ERROR_ONLY_FIELD_NUMBER = 3;
            public static final int STOP_AFTER_FIELD_NUMBER = 5;
            public static final int TIMEOUT_FIELD_NUMBER = 1;
            public static final int WEIGHT_THRESHOLD_FIELD_NUMBER = 6;
            private static final long serialVersionUID = 0;
            private List<Algorithm> algorithms_;
            private boolean allowDuplicate_;
            private double downscaleFactor_;
            private boolean errorOnly_;
            private byte memoizedIsInitialized;
            private volatile Object stopAfter_;
            private double timeout_;
            private double weightThreshold_;
            private static final Configuration DEFAULT_INSTANCE = new Configuration();
            private static final Parser<Configuration> PARSER = new AbstractParser<Configuration>() { // from class: io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.Configuration.1
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
                this.stopAfter_ = "";
                this.algorithms_ = Collections.emptyList();
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
                boolean z2 = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 9) {
                                    this.timeout_ = codedInputStream.readDouble();
                                } else if (readTag == 17) {
                                    this.downscaleFactor_ = codedInputStream.readDouble();
                                } else if (readTag == 24) {
                                    this.errorOnly_ = codedInputStream.readBool();
                                } else if (readTag == 32) {
                                    this.allowDuplicate_ = codedInputStream.readBool();
                                } else if (readTag == 42) {
                                    this.stopAfter_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 49) {
                                    this.weightThreshold_ = codedInputStream.readDouble();
                                } else if (readTag == 58) {
                                    if (!z2) {
                                        this.algorithms_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.algorithms_.add(codedInputStream.readMessage(Algorithm.parser(), extensionRegistryLite));
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
                            this.algorithms_ = Collections.unmodifiableList(this.algorithms_);
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Configuration_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Configuration_fieldAccessorTable.ensureFieldAccessorsInitialized(Configuration.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public double getTimeout() {
                return this.timeout_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public double getDownscaleFactor() {
                return this.downscaleFactor_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public boolean getErrorOnly() {
                return this.errorOnly_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public boolean getAllowDuplicate() {
                return this.allowDuplicate_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public String getStopAfter() {
                Object obj = this.stopAfter_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.stopAfter_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public ByteString getStopAfterBytes() {
                Object obj = this.stopAfter_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.stopAfter_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public double getWeightThreshold() {
                return this.weightThreshold_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public List<Algorithm> getAlgorithmsList() {
                return this.algorithms_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public List<? extends AlgorithmOrBuilder> getAlgorithmsOrBuilderList() {
                return this.algorithms_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public int getAlgorithmsCount() {
                return this.algorithms_.size();
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public Algorithm getAlgorithms(int i) {
                return this.algorithms_.get(i);
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
            public AlgorithmOrBuilder getAlgorithmsOrBuilder(int i) {
                return this.algorithms_.get(i);
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
                double d = this.timeout_;
                if (d != 0.0d) {
                    codedOutputStream.writeDouble(1, d);
                }
                double d2 = this.downscaleFactor_;
                if (d2 != 0.0d) {
                    codedOutputStream.writeDouble(2, d2);
                }
                boolean z = this.errorOnly_;
                if (z) {
                    codedOutputStream.writeBool(3, z);
                }
                boolean z2 = this.allowDuplicate_;
                if (z2) {
                    codedOutputStream.writeBool(4, z2);
                }
                if (!getStopAfterBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 5, this.stopAfter_);
                }
                double d3 = this.weightThreshold_;
                if (d3 != 0.0d) {
                    codedOutputStream.writeDouble(6, d3);
                }
                for (int i = 0; i < this.algorithms_.size(); i++) {
                    codedOutputStream.writeMessage(7, this.algorithms_.get(i));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                double d = this.timeout_;
                int computeDoubleSize = d != 0.0d ? CodedOutputStream.computeDoubleSize(1, d) : 0;
                double d2 = this.downscaleFactor_;
                if (d2 != 0.0d) {
                    computeDoubleSize += CodedOutputStream.computeDoubleSize(2, d2);
                }
                boolean z = this.errorOnly_;
                if (z) {
                    computeDoubleSize += CodedOutputStream.computeBoolSize(3, z);
                }
                boolean z2 = this.allowDuplicate_;
                if (z2) {
                    computeDoubleSize += CodedOutputStream.computeBoolSize(4, z2);
                }
                if (!getStopAfterBytes().isEmpty()) {
                    computeDoubleSize += GeneratedMessageV3.computeStringSize(5, this.stopAfter_);
                }
                double d3 = this.weightThreshold_;
                if (d3 != 0.0d) {
                    computeDoubleSize += CodedOutputStream.computeDoubleSize(6, d3);
                }
                for (int i2 = 0; i2 < this.algorithms_.size(); i2++) {
                    computeDoubleSize += CodedOutputStream.computeMessageSize(7, this.algorithms_.get(i2));
                }
                int serializedSize = computeDoubleSize + this.unknownFields.getSerializedSize();
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
                return Double.doubleToLongBits(getTimeout()) == Double.doubleToLongBits(configuration.getTimeout()) && Double.doubleToLongBits(getDownscaleFactor()) == Double.doubleToLongBits(configuration.getDownscaleFactor()) && getErrorOnly() == configuration.getErrorOnly() && getAllowDuplicate() == configuration.getAllowDuplicate() && getStopAfter().equals(configuration.getStopAfter()) && Double.doubleToLongBits(getWeightThreshold()) == Double.doubleToLongBits(configuration.getWeightThreshold()) && getAlgorithmsList().equals(configuration.getAlgorithmsList()) && this.unknownFields.equals(configuration.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getTimeout()))) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getDownscaleFactor()))) * 37) + 3) * 53) + Internal.hashBoolean(getErrorOnly())) * 37) + 4) * 53) + Internal.hashBoolean(getAllowDuplicate())) * 37) + 5) * 53) + getStopAfter().hashCode()) * 37) + 6) * 53) + Internal.hashLong(Double.doubleToLongBits(getWeightThreshold()));
                if (getAlgorithmsCount() > 0) {
                    hashCode = (((hashCode * 37) + 7) * 53) + getAlgorithmsList().hashCode();
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
                private RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> algorithmsBuilder_;
                private List<Algorithm> algorithms_;
                private boolean allowDuplicate_;
                private int bitField0_;
                private double downscaleFactor_;
                private boolean errorOnly_;
                private Object stopAfter_;
                private double timeout_;
                private double weightThreshold_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Configuration_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Configuration_fieldAccessorTable.ensureFieldAccessorsInitialized(Configuration.class, Builder.class);
                }

                private Builder() {
                    this.stopAfter_ = "";
                    this.algorithms_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.stopAfter_ = "";
                    this.algorithms_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (Configuration.alwaysUseFieldBuilders) {
                        getAlgorithmsFieldBuilder();
                    }
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.timeout_ = 0.0d;
                    this.downscaleFactor_ = 0.0d;
                    this.errorOnly_ = false;
                    this.allowDuplicate_ = false;
                    this.stopAfter_ = "";
                    this.weightThreshold_ = 0.0d;
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.algorithms_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_Configuration_descriptor;
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
                    configuration.timeout_ = this.timeout_;
                    configuration.downscaleFactor_ = this.downscaleFactor_;
                    configuration.errorOnly_ = this.errorOnly_;
                    configuration.allowDuplicate_ = this.allowDuplicate_;
                    configuration.stopAfter_ = this.stopAfter_;
                    configuration.weightThreshold_ = this.weightThreshold_;
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        configuration.algorithms_ = repeatedFieldBuilderV3.build();
                    } else {
                        if ((this.bitField0_ & 1) != 0) {
                            this.algorithms_ = Collections.unmodifiableList(this.algorithms_);
                            this.bitField0_ &= -2;
                        }
                        configuration.algorithms_ = this.algorithms_;
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
                    if (configuration.getTimeout() != 0.0d) {
                        setTimeout(configuration.getTimeout());
                    }
                    if (configuration.getDownscaleFactor() != 0.0d) {
                        setDownscaleFactor(configuration.getDownscaleFactor());
                    }
                    if (configuration.getErrorOnly()) {
                        setErrorOnly(configuration.getErrorOnly());
                    }
                    if (configuration.getAllowDuplicate()) {
                        setAllowDuplicate(configuration.getAllowDuplicate());
                    }
                    if (!configuration.getStopAfter().isEmpty()) {
                        this.stopAfter_ = configuration.stopAfter_;
                        onChanged();
                    }
                    if (configuration.getWeightThreshold() != 0.0d) {
                        setWeightThreshold(configuration.getWeightThreshold());
                    }
                    if (this.algorithmsBuilder_ == null) {
                        if (!configuration.algorithms_.isEmpty()) {
                            if (this.algorithms_.isEmpty()) {
                                this.algorithms_ = configuration.algorithms_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureAlgorithmsIsMutable();
                                this.algorithms_.addAll(configuration.algorithms_);
                            }
                            onChanged();
                        }
                    } else if (!configuration.algorithms_.isEmpty()) {
                        if (!this.algorithmsBuilder_.isEmpty()) {
                            this.algorithmsBuilder_.addAllMessages(configuration.algorithms_);
                        } else {
                            this.algorithmsBuilder_.dispose();
                            this.algorithmsBuilder_ = null;
                            this.algorithms_ = configuration.algorithms_;
                            this.bitField0_ &= -2;
                            this.algorithmsBuilder_ = Configuration.alwaysUseFieldBuilders ? getAlgorithmsFieldBuilder() : null;
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

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public double getTimeout() {
                    return this.timeout_;
                }

                public Builder setTimeout(double d) {
                    this.timeout_ = d;
                    onChanged();
                    return this;
                }

                public Builder clearTimeout() {
                    this.timeout_ = 0.0d;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public double getDownscaleFactor() {
                    return this.downscaleFactor_;
                }

                public Builder setDownscaleFactor(double d) {
                    this.downscaleFactor_ = d;
                    onChanged();
                    return this;
                }

                public Builder clearDownscaleFactor() {
                    this.downscaleFactor_ = 0.0d;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public boolean getErrorOnly() {
                    return this.errorOnly_;
                }

                public Builder setErrorOnly(boolean z) {
                    this.errorOnly_ = z;
                    onChanged();
                    return this;
                }

                public Builder clearErrorOnly() {
                    this.errorOnly_ = false;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public boolean getAllowDuplicate() {
                    return this.allowDuplicate_;
                }

                public Builder setAllowDuplicate(boolean z) {
                    this.allowDuplicate_ = z;
                    onChanged();
                    return this;
                }

                public Builder clearAllowDuplicate() {
                    this.allowDuplicate_ = false;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public String getStopAfter() {
                    Object obj = this.stopAfter_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.stopAfter_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public ByteString getStopAfterBytes() {
                    Object obj = this.stopAfter_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.stopAfter_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setStopAfter(String str) {
                    str.getClass();
                    this.stopAfter_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearStopAfter() {
                    this.stopAfter_ = Configuration.getDefaultInstance().getStopAfter();
                    onChanged();
                    return this;
                }

                public Builder setStopAfterBytes(ByteString byteString) {
                    byteString.getClass();
                    Configuration.checkByteStringIsUtf8(byteString);
                    this.stopAfter_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public double getWeightThreshold() {
                    return this.weightThreshold_;
                }

                public Builder setWeightThreshold(double d) {
                    this.weightThreshold_ = d;
                    onChanged();
                    return this;
                }

                public Builder clearWeightThreshold() {
                    this.weightThreshold_ = 0.0d;
                    onChanged();
                    return this;
                }

                private void ensureAlgorithmsIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.algorithms_ = new ArrayList(this.algorithms_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public List<Algorithm> getAlgorithmsList() {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return Collections.unmodifiableList(this.algorithms_);
                    }
                    return repeatedFieldBuilderV3.getMessageList();
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public int getAlgorithmsCount() {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.algorithms_.size();
                    }
                    return repeatedFieldBuilderV3.getCount();
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public Algorithm getAlgorithms(int i) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.algorithms_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessage(i);
                }

                public Builder setAlgorithms(int i, Algorithm algorithm) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        algorithm.getClass();
                        ensureAlgorithmsIsMutable();
                        this.algorithms_.set(i, algorithm);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, algorithm);
                    return this;
                }

                public Builder setAlgorithms(int i, Algorithm.Builder builder) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsIsMutable();
                        this.algorithms_.set(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }

                public Builder addAlgorithms(Algorithm algorithm) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        algorithm.getClass();
                        ensureAlgorithmsIsMutable();
                        this.algorithms_.add(algorithm);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(algorithm);
                    return this;
                }

                public Builder addAlgorithms(int i, Algorithm algorithm) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        algorithm.getClass();
                        ensureAlgorithmsIsMutable();
                        this.algorithms_.add(i, algorithm);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, algorithm);
                    return this;
                }

                public Builder addAlgorithms(Algorithm.Builder builder) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsIsMutable();
                        this.algorithms_.add(builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }

                public Builder addAlgorithms(int i, Algorithm.Builder builder) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsIsMutable();
                        this.algorithms_.add(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }

                public Builder addAllAlgorithms(Iterable<? extends Algorithm> iterable) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.algorithms_);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }

                public Builder clearAlgorithms() {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.algorithms_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                public Builder removeAlgorithms(int i) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAlgorithmsIsMutable();
                        this.algorithms_.remove(i);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }

                public Algorithm.Builder getAlgorithmsBuilder(int i) {
                    return getAlgorithmsFieldBuilder().getBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public AlgorithmOrBuilder getAlgorithmsOrBuilder(int i) {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.algorithms_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessageOrBuilder(i);
                }

                @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetector.ConfigurationOrBuilder
                public List<? extends AlgorithmOrBuilder> getAlgorithmsOrBuilderList() {
                    RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> repeatedFieldBuilderV3 = this.algorithmsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        return repeatedFieldBuilderV3.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.algorithms_);
                }

                public Algorithm.Builder addAlgorithmsBuilder() {
                    return getAlgorithmsFieldBuilder().addBuilder(Algorithm.getDefaultInstance());
                }

                public Algorithm.Builder addAlgorithmsBuilder(int i) {
                    return getAlgorithmsFieldBuilder().addBuilder(i, Algorithm.getDefaultInstance());
                }

                public List<Algorithm.Builder> getAlgorithmsBuilderList() {
                    return getAlgorithmsFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<Algorithm, Algorithm.Builder, AlgorithmOrBuilder> getAlgorithmsFieldBuilder() {
                    if (this.algorithmsBuilder_ == null) {
                        this.algorithmsBuilder_ = new RepeatedFieldBuilderV3<>(this.algorithms_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                        this.algorithms_ = null;
                    }
                    return this.algorithmsBuilder_;
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

        public enum PayloadOneofCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            EVENT(1),
            CONFIGURATION(2),
            PAYLOADONEOF_NOT_SET(0);

            private final int value;

            PayloadOneofCase(int i) {
                this.value = i;
            }

            @Deprecated
            public static PayloadOneofCase valueOf(int i) {
                return forNumber(i);
            }

            public static PayloadOneofCase forNumber(int i) {
                if (i == 0) {
                    return PAYLOADONEOF_NOT_SET;
                }
                if (i == 1) {
                    return EVENT;
                }
                if (i != 2) {
                    return null;
                }
                return CONFIGURATION;
            }

            @Override // com.explorestack.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
        public PayloadOneofCase getPayloadOneofCase() {
            return PayloadOneofCase.forNumber(this.payloadOneofCase_);
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
        public boolean hasEvent() {
            return this.payloadOneofCase_ == 1;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
        public Event getEvent() {
            if (this.payloadOneofCase_ == 1) {
                return (Event) this.payloadOneof_;
            }
            return Event.getDefaultInstance();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
        public EventOrBuilder getEventOrBuilder() {
            if (this.payloadOneofCase_ == 1) {
                return (Event) this.payloadOneof_;
            }
            return Event.getDefaultInstance();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
        public boolean hasConfiguration() {
            return this.payloadOneofCase_ == 2;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
        public Configuration getConfiguration() {
            if (this.payloadOneofCase_ == 2) {
                return (Configuration) this.payloadOneof_;
            }
            return Configuration.getDefaultInstance();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
        public ConfigurationOrBuilder getConfigurationOrBuilder() {
            if (this.payloadOneofCase_ == 2) {
                return (Configuration) this.payloadOneof_;
            }
            return Configuration.getDefaultInstance();
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
            if (this.payloadOneofCase_ == 1) {
                codedOutputStream.writeMessage(1, (Event) this.payloadOneof_);
            }
            if (this.payloadOneofCase_ == 2) {
                codedOutputStream.writeMessage(2, (Configuration) this.payloadOneof_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.payloadOneofCase_ == 1 ? CodedOutputStream.computeMessageSize(1, (Event) this.payloadOneof_) : 0;
            if (this.payloadOneofCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (Configuration) this.payloadOneof_);
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
            if (!(obj instanceof BrokenCreativeDetector)) {
                return super.equals(obj);
            }
            BrokenCreativeDetector brokenCreativeDetector = (BrokenCreativeDetector) obj;
            if (!getPayloadOneofCase().equals(brokenCreativeDetector.getPayloadOneofCase())) {
                return false;
            }
            int i = this.payloadOneofCase_;
            if (i == 1) {
                if (!getEvent().equals(brokenCreativeDetector.getEvent())) {
                    return false;
                }
            } else if (i == 2 && !getConfiguration().equals(brokenCreativeDetector.getConfiguration())) {
                return false;
            }
            return this.unknownFields.equals(brokenCreativeDetector.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            int i;
            int hashCode;
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode2 = 779 + getDescriptor().hashCode();
            int i2 = this.payloadOneofCase_;
            if (i2 == 1) {
                i = ((hashCode2 * 37) + 1) * 53;
                hashCode = getEvent().hashCode();
            } else {
                if (i2 == 2) {
                    i = ((hashCode2 * 37) + 2) * 53;
                    hashCode = getConfiguration().hashCode();
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

        public static BrokenCreativeDetector parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static BrokenCreativeDetector parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static BrokenCreativeDetector parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static BrokenCreativeDetector parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static BrokenCreativeDetector parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static BrokenCreativeDetector parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static BrokenCreativeDetector parseFrom(InputStream inputStream) throws IOException {
            return (BrokenCreativeDetector) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static BrokenCreativeDetector parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BrokenCreativeDetector) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BrokenCreativeDetector parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BrokenCreativeDetector) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BrokenCreativeDetector parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BrokenCreativeDetector) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BrokenCreativeDetector parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BrokenCreativeDetector) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static BrokenCreativeDetector parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BrokenCreativeDetector) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BrokenCreativeDetector brokenCreativeDetector) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(brokenCreativeDetector);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BrokenCreativeDetectorOrBuilder {
            private SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> configurationBuilder_;
            private SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> eventBuilder_;
            private int payloadOneofCase_;
            private Object payloadOneof_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_fieldAccessorTable.ensureFieldAccessorsInitialized(BrokenCreativeDetector.class, Builder.class);
            }

            private Builder() {
                this.payloadOneofCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.payloadOneofCase_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = BrokenCreativeDetector.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.payloadOneofCase_ = 0;
                this.payloadOneof_ = null;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_BrokenCreativeDetector_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public BrokenCreativeDetector getDefaultInstanceForType() {
                return BrokenCreativeDetector.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public BrokenCreativeDetector build() {
                BrokenCreativeDetector buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public BrokenCreativeDetector buildPartial() {
                BrokenCreativeDetector brokenCreativeDetector = new BrokenCreativeDetector(this);
                if (this.payloadOneofCase_ == 1) {
                    SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> singleFieldBuilderV3 = this.eventBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        brokenCreativeDetector.payloadOneof_ = this.payloadOneof_;
                    } else {
                        brokenCreativeDetector.payloadOneof_ = singleFieldBuilderV3.build();
                    }
                }
                if (this.payloadOneofCase_ == 2) {
                    SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> singleFieldBuilderV32 = this.configurationBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        brokenCreativeDetector.payloadOneof_ = this.payloadOneof_;
                    } else {
                        brokenCreativeDetector.payloadOneof_ = singleFieldBuilderV32.build();
                    }
                }
                brokenCreativeDetector.payloadOneofCase_ = this.payloadOneofCase_;
                onBuilt();
                return brokenCreativeDetector;
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
                if (message instanceof BrokenCreativeDetector) {
                    return mergeFrom((BrokenCreativeDetector) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(BrokenCreativeDetector brokenCreativeDetector) {
                if (brokenCreativeDetector == BrokenCreativeDetector.getDefaultInstance()) {
                    return this;
                }
                int i = AnonymousClass2.$SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$BrokenCreativeDetector$PayloadOneofCase[brokenCreativeDetector.getPayloadOneofCase().ordinal()];
                if (i == 1) {
                    mergeEvent(brokenCreativeDetector.getEvent());
                } else if (i == 2) {
                    mergeConfiguration(brokenCreativeDetector.getConfiguration());
                }
                mergeUnknownFields(brokenCreativeDetector.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                BrokenCreativeDetector brokenCreativeDetector = null;
                try {
                    try {
                        BrokenCreativeDetector brokenCreativeDetector2 = (BrokenCreativeDetector) BrokenCreativeDetector.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (brokenCreativeDetector2 != null) {
                            mergeFrom(brokenCreativeDetector2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        BrokenCreativeDetector brokenCreativeDetector3 = (BrokenCreativeDetector) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            brokenCreativeDetector = brokenCreativeDetector3;
                            if (brokenCreativeDetector != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (brokenCreativeDetector != null) {
                        mergeFrom(brokenCreativeDetector);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
            public PayloadOneofCase getPayloadOneofCase() {
                return PayloadOneofCase.forNumber(this.payloadOneofCase_);
            }

            public Builder clearPayloadOneof() {
                this.payloadOneofCase_ = 0;
                this.payloadOneof_ = null;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
            public boolean hasEvent() {
                return this.payloadOneofCase_ == 1;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
            public Event getEvent() {
                SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> singleFieldBuilderV3 = this.eventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.payloadOneofCase_ == 1) {
                        return (Event) this.payloadOneof_;
                    }
                    return Event.getDefaultInstance();
                }
                if (this.payloadOneofCase_ == 1) {
                    return singleFieldBuilderV3.getMessage();
                }
                return Event.getDefaultInstance();
            }

            public Builder setEvent(Event event) {
                SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> singleFieldBuilderV3 = this.eventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    event.getClass();
                    this.payloadOneof_ = event;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(event);
                }
                this.payloadOneofCase_ = 1;
                return this;
            }

            public Builder setEvent(Event.Builder builder) {
                SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> singleFieldBuilderV3 = this.eventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.payloadOneof_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.payloadOneofCase_ = 1;
                return this;
            }

            public Builder mergeEvent(Event event) {
                SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> singleFieldBuilderV3 = this.eventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.payloadOneofCase_ == 1 && this.payloadOneof_ != Event.getDefaultInstance()) {
                        this.payloadOneof_ = Event.newBuilder((Event) this.payloadOneof_).mergeFrom(event).buildPartial();
                    } else {
                        this.payloadOneof_ = event;
                    }
                    onChanged();
                } else {
                    if (this.payloadOneofCase_ == 1) {
                        singleFieldBuilderV3.mergeFrom(event);
                    }
                    this.eventBuilder_.setMessage(event);
                }
                this.payloadOneofCase_ = 1;
                return this;
            }

            public Builder clearEvent() {
                SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> singleFieldBuilderV3 = this.eventBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.payloadOneofCase_ == 1) {
                        this.payloadOneofCase_ = 0;
                        this.payloadOneof_ = null;
                        onChanged();
                    }
                    return this;
                }
                if (this.payloadOneofCase_ == 1) {
                    this.payloadOneofCase_ = 0;
                    this.payloadOneof_ = null;
                }
                singleFieldBuilderV3.clear();
                return this;
            }

            public Event.Builder getEventBuilder() {
                return getEventFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
            public EventOrBuilder getEventOrBuilder() {
                SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> singleFieldBuilderV3;
                int i = this.payloadOneofCase_;
                if (i == 1 && (singleFieldBuilderV3 = this.eventBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (i == 1) {
                    return (Event) this.payloadOneof_;
                }
                return Event.getDefaultInstance();
            }

            private SingleFieldBuilderV3<Event, Event.Builder, EventOrBuilder> getEventFieldBuilder() {
                if (this.eventBuilder_ == null) {
                    if (this.payloadOneofCase_ != 1) {
                        this.payloadOneof_ = Event.getDefaultInstance();
                    }
                    this.eventBuilder_ = new SingleFieldBuilderV3<>((Event) this.payloadOneof_, getParentForChildren(), isClean());
                    this.payloadOneof_ = null;
                }
                this.payloadOneofCase_ = 1;
                onChanged();
                return this.eventBuilder_;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
            public boolean hasConfiguration() {
                return this.payloadOneofCase_ == 2;
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
            public Configuration getConfiguration() {
                SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> singleFieldBuilderV3 = this.configurationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.payloadOneofCase_ == 2) {
                        return (Configuration) this.payloadOneof_;
                    }
                    return Configuration.getDefaultInstance();
                }
                if (this.payloadOneofCase_ == 2) {
                    return singleFieldBuilderV3.getMessage();
                }
                return Configuration.getDefaultInstance();
            }

            public Builder setConfiguration(Configuration configuration) {
                SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> singleFieldBuilderV3 = this.configurationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    configuration.getClass();
                    this.payloadOneof_ = configuration;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(configuration);
                }
                this.payloadOneofCase_ = 2;
                return this;
            }

            public Builder setConfiguration(Configuration.Builder builder) {
                SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> singleFieldBuilderV3 = this.configurationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.payloadOneof_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.payloadOneofCase_ = 2;
                return this;
            }

            public Builder mergeConfiguration(Configuration configuration) {
                SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> singleFieldBuilderV3 = this.configurationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.payloadOneofCase_ == 2 && this.payloadOneof_ != Configuration.getDefaultInstance()) {
                        this.payloadOneof_ = Configuration.newBuilder((Configuration) this.payloadOneof_).mergeFrom(configuration).buildPartial();
                    } else {
                        this.payloadOneof_ = configuration;
                    }
                    onChanged();
                } else {
                    if (this.payloadOneofCase_ == 2) {
                        singleFieldBuilderV3.mergeFrom(configuration);
                    }
                    this.configurationBuilder_.setMessage(configuration);
                }
                this.payloadOneofCase_ = 2;
                return this;
            }

            public Builder clearConfiguration() {
                SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> singleFieldBuilderV3 = this.configurationBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.payloadOneofCase_ == 2) {
                        this.payloadOneofCase_ = 0;
                        this.payloadOneof_ = null;
                        onChanged();
                    }
                    return this;
                }
                if (this.payloadOneofCase_ == 2) {
                    this.payloadOneofCase_ = 0;
                    this.payloadOneof_ = null;
                }
                singleFieldBuilderV3.clear();
                return this;
            }

            public Configuration.Builder getConfigurationBuilder() {
                return getConfigurationFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.rendering.RenderingFeature.BrokenCreativeDetectorOrBuilder
            public ConfigurationOrBuilder getConfigurationOrBuilder() {
                SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> singleFieldBuilderV3;
                int i = this.payloadOneofCase_;
                if (i == 2 && (singleFieldBuilderV3 = this.configurationBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (i == 2) {
                    return (Configuration) this.payloadOneof_;
                }
                return Configuration.getDefaultInstance();
            }

            private SingleFieldBuilderV3<Configuration, Configuration.Builder, ConfigurationOrBuilder> getConfigurationFieldBuilder() {
                if (this.configurationBuilder_ == null) {
                    if (this.payloadOneofCase_ != 2) {
                        this.payloadOneof_ = Configuration.getDefaultInstance();
                    }
                    this.configurationBuilder_ = new SingleFieldBuilderV3<>((Configuration) this.payloadOneof_, getParentForChildren(), isClean());
                    this.payloadOneof_ = null;
                }
                this.payloadOneofCase_ = 2;
                onChanged();
                return this.configurationBuilder_;
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

        public static BrokenCreativeDetector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BrokenCreativeDetector> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<BrokenCreativeDetector> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public BrokenCreativeDetector getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public enum FeatureCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        BROKEN_CREATIVE_DETECTOR(1),
        FEATURE_NOT_SET(0);

        private final int value;

        FeatureCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static FeatureCase valueOf(int i) {
            return forNumber(i);
        }

        public static FeatureCase forNumber(int i) {
            if (i == 0) {
                return FEATURE_NOT_SET;
            }
            if (i != 1) {
                return null;
            }
            return BROKEN_CREATIVE_DETECTOR;
        }

        @Override // com.explorestack.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
    public FeatureCase getFeatureCase() {
        return FeatureCase.forNumber(this.featureCase_);
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
    public boolean hasBrokenCreativeDetector() {
        return this.featureCase_ == 1;
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
    public BrokenCreativeDetector getBrokenCreativeDetector() {
        if (this.featureCase_ == 1) {
            return (BrokenCreativeDetector) this.feature_;
        }
        return BrokenCreativeDetector.getDefaultInstance();
    }

    @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
    public BrokenCreativeDetectorOrBuilder getBrokenCreativeDetectorOrBuilder() {
        if (this.featureCase_ == 1) {
            return (BrokenCreativeDetector) this.feature_;
        }
        return BrokenCreativeDetector.getDefaultInstance();
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
        if (this.featureCase_ == 1) {
            codedOutputStream.writeMessage(1, (BrokenCreativeDetector) this.feature_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeMessageSize = (this.featureCase_ == 1 ? CodedOutputStream.computeMessageSize(1, (BrokenCreativeDetector) this.feature_) : 0) + this.unknownFields.getSerializedSize();
        this.memoizedSize = computeMessageSize;
        return computeMessageSize;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RenderingFeature)) {
            return super.equals(obj);
        }
        RenderingFeature renderingFeature = (RenderingFeature) obj;
        if (getFeatureCase().equals(renderingFeature.getFeatureCase())) {
            return (this.featureCase_ != 1 || getBrokenCreativeDetector().equals(renderingFeature.getBrokenCreativeDetector())) && this.unknownFields.equals(renderingFeature.unknownFields);
        }
        return false;
    }

    @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        if (this.featureCase_ == 1) {
            hashCode = (((hashCode * 37) + 1) * 53) + getBrokenCreativeDetector().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public static RenderingFeature parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static RenderingFeature parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static RenderingFeature parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static RenderingFeature parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static RenderingFeature parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static RenderingFeature parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RenderingFeature parseFrom(InputStream inputStream) throws IOException {
        return (RenderingFeature) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static RenderingFeature parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RenderingFeature) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RenderingFeature parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RenderingFeature) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static RenderingFeature parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RenderingFeature) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RenderingFeature parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RenderingFeature) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static RenderingFeature parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RenderingFeature) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RenderingFeature renderingFeature) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(renderingFeature);
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

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RenderingFeatureOrBuilder {
        private SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> brokenCreativeDetectorBuilder_;
        private int featureCase_;
        private Object feature_;

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_fieldAccessorTable.ensureFieldAccessorsInitialized(RenderingFeature.class, Builder.class);
        }

        private Builder() {
            this.featureCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.featureCase_ = 0;
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = RenderingFeature.alwaysUseFieldBuilders;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.featureCase_ = 0;
            this.feature_ = null;
            return this;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return RenderingProto.internal_static_bidmachine_protobuf_RenderingFeature_descriptor;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public RenderingFeature getDefaultInstanceForType() {
            return RenderingFeature.getDefaultInstance();
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public RenderingFeature build() {
            RenderingFeature buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        public RenderingFeature buildPartial() {
            RenderingFeature renderingFeature = new RenderingFeature(this);
            if (this.featureCase_ == 1) {
                SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> singleFieldBuilderV3 = this.brokenCreativeDetectorBuilder_;
                if (singleFieldBuilderV3 == null) {
                    renderingFeature.feature_ = this.feature_;
                } else {
                    renderingFeature.feature_ = singleFieldBuilderV3.build();
                }
            }
            renderingFeature.featureCase_ = this.featureCase_;
            onBuilt();
            return renderingFeature;
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
            if (message instanceof RenderingFeature) {
                return mergeFrom((RenderingFeature) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(RenderingFeature renderingFeature) {
            if (renderingFeature == RenderingFeature.getDefaultInstance()) {
                return this;
            }
            if (AnonymousClass2.$SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$FeatureCase[renderingFeature.getFeatureCase().ordinal()] == 1) {
                mergeBrokenCreativeDetector(renderingFeature.getBrokenCreativeDetector());
            }
            mergeUnknownFields(renderingFeature.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            RenderingFeature renderingFeature = null;
            try {
                try {
                    RenderingFeature renderingFeature2 = (RenderingFeature) RenderingFeature.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (renderingFeature2 != null) {
                        mergeFrom(renderingFeature2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    RenderingFeature renderingFeature3 = (RenderingFeature) e.getUnfinishedMessage();
                    try {
                        throw e.unwrapIOException();
                    } catch (Throwable th) {
                        th = th;
                        renderingFeature = renderingFeature3;
                        if (renderingFeature != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (renderingFeature != null) {
                    mergeFrom(renderingFeature);
                }
                throw th;
            }
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
        public FeatureCase getFeatureCase() {
            return FeatureCase.forNumber(this.featureCase_);
        }

        public Builder clearFeature() {
            this.featureCase_ = 0;
            this.feature_ = null;
            onChanged();
            return this;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
        public boolean hasBrokenCreativeDetector() {
            return this.featureCase_ == 1;
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
        public BrokenCreativeDetector getBrokenCreativeDetector() {
            SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> singleFieldBuilderV3 = this.brokenCreativeDetectorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.featureCase_ == 1) {
                    return (BrokenCreativeDetector) this.feature_;
                }
                return BrokenCreativeDetector.getDefaultInstance();
            }
            if (this.featureCase_ == 1) {
                return singleFieldBuilderV3.getMessage();
            }
            return BrokenCreativeDetector.getDefaultInstance();
        }

        public Builder setBrokenCreativeDetector(BrokenCreativeDetector brokenCreativeDetector) {
            SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> singleFieldBuilderV3 = this.brokenCreativeDetectorBuilder_;
            if (singleFieldBuilderV3 == null) {
                brokenCreativeDetector.getClass();
                this.feature_ = brokenCreativeDetector;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(brokenCreativeDetector);
            }
            this.featureCase_ = 1;
            return this;
        }

        public Builder setBrokenCreativeDetector(BrokenCreativeDetector.Builder builder) {
            SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> singleFieldBuilderV3 = this.brokenCreativeDetectorBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.feature_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.featureCase_ = 1;
            return this;
        }

        public Builder mergeBrokenCreativeDetector(BrokenCreativeDetector brokenCreativeDetector) {
            SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> singleFieldBuilderV3 = this.brokenCreativeDetectorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.featureCase_ == 1 && this.feature_ != BrokenCreativeDetector.getDefaultInstance()) {
                    this.feature_ = BrokenCreativeDetector.newBuilder((BrokenCreativeDetector) this.feature_).mergeFrom(brokenCreativeDetector).buildPartial();
                } else {
                    this.feature_ = brokenCreativeDetector;
                }
                onChanged();
            } else {
                if (this.featureCase_ == 1) {
                    singleFieldBuilderV3.mergeFrom(brokenCreativeDetector);
                }
                this.brokenCreativeDetectorBuilder_.setMessage(brokenCreativeDetector);
            }
            this.featureCase_ = 1;
            return this;
        }

        public Builder clearBrokenCreativeDetector() {
            SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> singleFieldBuilderV3 = this.brokenCreativeDetectorBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.featureCase_ == 1) {
                    this.featureCase_ = 0;
                    this.feature_ = null;
                    onChanged();
                }
                return this;
            }
            if (this.featureCase_ == 1) {
                this.featureCase_ = 0;
                this.feature_ = null;
            }
            singleFieldBuilderV3.clear();
            return this;
        }

        public BrokenCreativeDetector.Builder getBrokenCreativeDetectorBuilder() {
            return getBrokenCreativeDetectorFieldBuilder().getBuilder();
        }

        @Override // io.bidmachine.protobuf.rendering.RenderingFeatureOrBuilder
        public BrokenCreativeDetectorOrBuilder getBrokenCreativeDetectorOrBuilder() {
            SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> singleFieldBuilderV3;
            int i = this.featureCase_;
            if (i == 1 && (singleFieldBuilderV3 = this.brokenCreativeDetectorBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i == 1) {
                return (BrokenCreativeDetector) this.feature_;
            }
            return BrokenCreativeDetector.getDefaultInstance();
        }

        private SingleFieldBuilderV3<BrokenCreativeDetector, BrokenCreativeDetector.Builder, BrokenCreativeDetectorOrBuilder> getBrokenCreativeDetectorFieldBuilder() {
            if (this.brokenCreativeDetectorBuilder_ == null) {
                if (this.featureCase_ != 1) {
                    this.feature_ = BrokenCreativeDetector.getDefaultInstance();
                }
                this.brokenCreativeDetectorBuilder_ = new SingleFieldBuilderV3<>((BrokenCreativeDetector) this.feature_, getParentForChildren(), isClean());
                this.feature_ = null;
            }
            this.featureCase_ = 1;
            onChanged();
            return this.brokenCreativeDetectorBuilder_;
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

    /* renamed from: io.bidmachine.protobuf.rendering.RenderingFeature$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$BrokenCreativeDetector$PayloadOneofCase;
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$FeatureCase;

        static {
            int[] iArr = new int[FeatureCase.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$FeatureCase = iArr;
            try {
                iArr[FeatureCase.BROKEN_CREATIVE_DETECTOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$FeatureCase[FeatureCase.FEATURE_NOT_SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[BrokenCreativeDetector.PayloadOneofCase.values().length];
            $SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$BrokenCreativeDetector$PayloadOneofCase = iArr2;
            try {
                iArr2[BrokenCreativeDetector.PayloadOneofCase.EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$BrokenCreativeDetector$PayloadOneofCase[BrokenCreativeDetector.PayloadOneofCase.CONFIGURATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$bidmachine$protobuf$rendering$RenderingFeature$BrokenCreativeDetector$PayloadOneofCase[BrokenCreativeDetector.PayloadOneofCase.PAYLOADONEOF_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static RenderingFeature getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RenderingFeature> parser() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
    public Parser<RenderingFeature> getParserForType() {
        return PARSER;
    }

    @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
    public RenderingFeature getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
