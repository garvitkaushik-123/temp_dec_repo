package io.bidmachine.protobuf.sessionmetrics;

import adn.analytics.Analytics;
import com.explorestack.protobuf.AbstractMessageLite;
import com.explorestack.protobuf.AbstractParser;
import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.CodedInputStream;
import com.explorestack.protobuf.CodedOutputStream;
import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.ExtensionRegistry;
import com.explorestack.protobuf.ExtensionRegistryLite;
import com.explorestack.protobuf.GeneratedMessageV3;
import com.explorestack.protobuf.Internal;
import com.explorestack.protobuf.InvalidProtocolBufferException;
import com.explorestack.protobuf.MapEntry;
import com.explorestack.protobuf.MapField;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.MessageOrBuilder;
import com.explorestack.protobuf.Parser;
import com.explorestack.protobuf.ProtocolMessageEnum;
import com.explorestack.protobuf.RepeatedFieldBuilderV3;
import com.explorestack.protobuf.SingleFieldBuilderV3;
import com.explorestack.protobuf.UnknownFieldSet;
import com.explorestack.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class SessionMetricsOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n)bidmachine/protobuf/session_metrics.proto\u0012\u000esessionmetrics\"Õ\u0002\n\tUserState\u0012 \n\u0018last_processed_timestamp\u0018\u0001 \u0001(\u0003\u0012?\n\u000bimpressions\u0018\u0002 \u0003(\u000b2*.sessionmetrics.UserState.ImpressionsEntry\u0012>\n\u000bad_requests\u0018\u0003 \u0003(\u000b2).sessionmetrics.UserState.AdRequestsEntry\u001aV\n\u0010ImpressionsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0005\u00121\n\u0005value\u0018\u0002 \u0001(\u000b2\".sessionmetrics.AdDomainTimestamps:\u00028\u0001\u001aM\n\u000fAdRequestsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\u0005\u0012)\n\u0005value\u0018\u0002 \u0001(\u000b2\u001a.sessionmetrics.Timestamps:\u00028\u0001\"\u0090\u0005\n\u000bUserSession\u0012\u0015\n\rlast_activity\u0018\u0001 \u0001(\u0003\u0012E\n\u0012metrics_by_ad_type\u0018\u0003 \u0003(\u000b2).sessionmetrics.UserSession.AdTypeMetrics\u0012\u0015\n\rsession_start\u0018\u0004 \u0001(\u0003\u001a@\n\u0004Ecpm\u0012\u0014\n\ffirst_prices\u0018\u0001 \u0003(\u0001\u0012\u0013\n\u000blast_prices\u0018\u0002 \u0003(\u0001\u0012\r\n\u0005count\u0018\u0003 \u0001(\u0005\u001aX\n\u0007Auction\u0012\u0019\n\u0011source_request_id\u0018\u0001 \u0001(\f\u0012\u0018\n\u0010winner_bidder_id\u0018\u0002 \u0001(\r\u0012\u0018\n\u0010losers_bidder_id\u0018\u0003 \u0003(\r\u001aï\u0002\n\rAdTypeMetrics\u0012'\n\u0007ad_type\u0018\u0001 \u0001(\u000e2\u0016.sessionmetrics.AdType\u0012\u0013\n\u000bimpressions\u0018\u0002 \u0001(\u0005\u0012\u0013\n\u000bad_requests\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004bids\u0018\u0004 \u0001(\u0005\u0012\f\n\u0004wins\u0018\u0005 \u0001(\u0005\u0012\u000e\n\u0006losses\u0018\u0006 \u0001(\u0005\u0012\r\n\u0005lurls\u0018\u0007 \u0001(\u0005\u0012\r\n\u0005nurls\u0018\b \u0001(\u0005\u0012\u001c\n\u0014cumulative_bid_price\u0018\t \u0001(\u0002\u0012\u001d\n\u0015cumulative_lurl_price\u0018\n \u0001(\u0002\u0012\u001d\n\u0015cumulative_nurl_price\u0018\u000b \u0001(\u0002\u0012.\n\u0004ecpm\u0018\f \u0001(\u000b2 .sessionmetrics.UserSession.Ecpm\u00125\n\bauctions\u0018\r \u0003(\u000b2#.sessionmetrics.UserSession.Auction\"\u009f\u0001\n\nTimestamps\u0012\u0016\n\u000elast_timestamp\u0018\u0001 \u0001(\u0003\u0012\u000e\n\u0006deltas\u0018\u0002 \u0003(\r\u00129\n\u000bday_buckets\u0018\u0003 \u0003(\u000b2$.sessionmetrics.Timestamps.DayBucket\u001a.\n\tDayBucket\u0012\u0012\n\nstart_time\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005count\u0018\u0002 \u0001(\u0005\"©\u0001\n\u0012AdDomainTimestamps\u0012E\n\nad_domains\u0018\u0001 \u0003(\u000b21.sessionmetrics.AdDomainTimestamps.AdDomainsEntry\u001aL\n\u000eAdDomainsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012)\n\u0005value\u0018\u0002 \u0001(\u000b2\u001a.sessionmetrics.Timestamps:\u00028\u0001\"B\n\rWindowMetrics\u0012\u000f\n\u0007last_1h\u0018\u0001 \u0001(\u0005\u0012\u000f\n\u0007last_1d\u0018\u0002 \u0001(\u0005\u0012\u000f\n\u0007last_7d\u0018\u0003 \u0001(\u0005\"Ö\u0001\n\u0011ImpressionMetrics\u0012'\n\u0007ad_type\u0018\u0001 \u0001(\u000e2\u0016.sessionmetrics.AdType\u0012@\n\u0007domains\u0018\u0002 \u0003(\u000b2/.sessionmetrics.ImpressionMetrics.DomainMetrics\u001aV\n\rDomainMetrics\u0012\u000e\n\u0006domain\u0018\u0001 \u0001(\t\u00125\n\u000ewindow_metrics\u0018\u0002 \u0001(\u000b2\u001d.sessionmetrics.WindowMetrics\"\u008b\u0001\n\u0010AdRequestMetrics\u0012'\n\u0007ad_type\u0018\u0001 \u0001(\u000e2\u0016.sessionmetrics.AdType\u00125\n\u000ewindow_metrics\u0018\u0002 \u0001(\u000b2\u001d.sessionmetrics.WindowMetrics\u0012\u0017\n\u000flast_timestamps\u0018\u0003 \u0003(\u0003\"µ\u0001\n\u000eSessionMetrics\u00126\n\u000bimpressions\u0018\u0001 \u0003(\u000b2!.sessionmetrics.ImpressionMetrics\u00125\n\u000bad_requests\u0018\u0002 \u0003(\u000b2 .sessionmetrics.AdRequestMetrics\u00124\n\u000fcurrent_session\u0018\u0003 \u0001(\u000b2\u001b.sessionmetrics.UserSession\"1\n\u000bUserIdQuery\u0012\u000f\n\u0007user_id\u0018\u0001 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0002 \u0001(\u0003\"X\n\tAdRequest\u0012\u000f\n\u0007user_id\u0018\u0001 \u0001(\t\u0012'\n\u0007ad_type\u0018\u0002 \u0001(\u000e2\u0016.sessionmetrics.AdType\u0012\u0011\n\ttimestamp\u0018\u0003 \u0001(\u0003*A\n\u0006AdType\u0012\u000b\n\u0007UNKNOWN\u0010\u0000\u0012\u0010\n\fINTERSTITIAL\u0010\u0001\u0012\f\n\bREWARDED\u0010\u0002\u0012\n\n\u0006BANNER\u0010\u00032²\u0001\n\u000eSessionService\u0012P\n\u0011GetSessionMetrics\u0012\u001b.sessionmetrics.UserIdQuery\u001a\u001e.sessionmetrics.SessionMetrics\u0012N\n\u0011RegisterAdRequest\u0012\u0019.sessionmetrics.AdRequest\u001a\u001e.sessionmetrics.SessionMetricsB'\n%io.bidmachine.protobuf.sessionmetricsb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdRequestMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_AdRequest_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_AdRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_ImpressionMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_SessionMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_Timestamps_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_Timestamps_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserIdQuery_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserSession_AdTypeMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserSession_AdTypeMetrics_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserSession_Auction_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserSession_Auction_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserSession_Ecpm_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserSession_Ecpm_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserSession_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserSession_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserState_AdRequestsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserState_AdRequestsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserState_ImpressionsEntry_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserState_ImpressionsEntry_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_UserState_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_UserState_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_sessionmetrics_WindowMetrics_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable;

    public interface AdDomainTimestampsOrBuilder extends MessageOrBuilder {
        boolean containsAdDomains(String str);

        @Deprecated
        Map<String, Timestamps> getAdDomains();

        int getAdDomainsCount();

        Map<String, Timestamps> getAdDomainsMap();

        Timestamps getAdDomainsOrDefault(String str, Timestamps timestamps);

        Timestamps getAdDomainsOrThrow(String str);
    }

    public interface AdRequestMetricsOrBuilder extends MessageOrBuilder {
        AdType getAdType();

        int getAdTypeValue();

        long getLastTimestamps(int i);

        int getLastTimestampsCount();

        List<Long> getLastTimestampsList();

        WindowMetrics getWindowMetrics();

        WindowMetricsOrBuilder getWindowMetricsOrBuilder();

        boolean hasWindowMetrics();
    }

    public interface AdRequestOrBuilder extends MessageOrBuilder {
        AdType getAdType();

        int getAdTypeValue();

        long getTimestamp();

        String getUserId();

        ByteString getUserIdBytes();
    }

    public interface ImpressionMetricsOrBuilder extends MessageOrBuilder {
        AdType getAdType();

        int getAdTypeValue();

        ImpressionMetrics.DomainMetrics getDomains(int i);

        int getDomainsCount();

        List<ImpressionMetrics.DomainMetrics> getDomainsList();

        ImpressionMetrics.DomainMetricsOrBuilder getDomainsOrBuilder(int i);

        List<? extends ImpressionMetrics.DomainMetricsOrBuilder> getDomainsOrBuilderList();
    }

    public interface SessionMetricsOrBuilder extends MessageOrBuilder {
        AdRequestMetrics getAdRequests(int i);

        int getAdRequestsCount();

        List<AdRequestMetrics> getAdRequestsList();

        AdRequestMetricsOrBuilder getAdRequestsOrBuilder(int i);

        List<? extends AdRequestMetricsOrBuilder> getAdRequestsOrBuilderList();

        UserSession getCurrentSession();

        UserSessionOrBuilder getCurrentSessionOrBuilder();

        ImpressionMetrics getImpressions(int i);

        int getImpressionsCount();

        List<ImpressionMetrics> getImpressionsList();

        ImpressionMetricsOrBuilder getImpressionsOrBuilder(int i);

        List<? extends ImpressionMetricsOrBuilder> getImpressionsOrBuilderList();

        boolean hasCurrentSession();
    }

    public interface TimestampsOrBuilder extends MessageOrBuilder {
        Timestamps.DayBucket getDayBuckets(int i);

        int getDayBucketsCount();

        List<Timestamps.DayBucket> getDayBucketsList();

        Timestamps.DayBucketOrBuilder getDayBucketsOrBuilder(int i);

        List<? extends Timestamps.DayBucketOrBuilder> getDayBucketsOrBuilderList();

        int getDeltas(int i);

        int getDeltasCount();

        List<Integer> getDeltasList();

        long getLastTimestamp();
    }

    public interface UserIdQueryOrBuilder extends MessageOrBuilder {
        long getTimestamp();

        String getUserId();

        ByteString getUserIdBytes();
    }

    public interface UserSessionOrBuilder extends MessageOrBuilder {
        long getLastActivity();

        UserSession.AdTypeMetrics getMetricsByAdType(int i);

        int getMetricsByAdTypeCount();

        List<UserSession.AdTypeMetrics> getMetricsByAdTypeList();

        UserSession.AdTypeMetricsOrBuilder getMetricsByAdTypeOrBuilder(int i);

        List<? extends UserSession.AdTypeMetricsOrBuilder> getMetricsByAdTypeOrBuilderList();

        long getSessionStart();
    }

    public interface UserStateOrBuilder extends MessageOrBuilder {
        boolean containsAdRequests(int i);

        boolean containsImpressions(int i);

        @Deprecated
        Map<Integer, Timestamps> getAdRequests();

        int getAdRequestsCount();

        Map<Integer, Timestamps> getAdRequestsMap();

        Timestamps getAdRequestsOrDefault(int i, Timestamps timestamps);

        Timestamps getAdRequestsOrThrow(int i);

        @Deprecated
        Map<Integer, AdDomainTimestamps> getImpressions();

        int getImpressionsCount();

        Map<Integer, AdDomainTimestamps> getImpressionsMap();

        AdDomainTimestamps getImpressionsOrDefault(int i, AdDomainTimestamps adDomainTimestamps);

        AdDomainTimestamps getImpressionsOrThrow(int i);

        long getLastProcessedTimestamp();
    }

    public interface WindowMetricsOrBuilder extends MessageOrBuilder {
        int getLast1D();

        int getLast1H();

        int getLast7D();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private SessionMetricsOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public enum AdType implements ProtocolMessageEnum {
        UNKNOWN(0),
        INTERSTITIAL(1),
        REWARDED(2),
        BANNER(3),
        UNRECOGNIZED(-1);

        public static final int BANNER_VALUE = 3;
        public static final int INTERSTITIAL_VALUE = 1;
        public static final int REWARDED_VALUE = 2;
        public static final int UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<AdType> internalValueMap = new Internal.EnumLiteMap<AdType>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdType.1
            @Override // com.explorestack.protobuf.Internal.EnumLiteMap
            public AdType findValueByNumber(int i) {
                return AdType.forNumber(i);
            }
        };
        private static final AdType[] VALUES = values();

        @Override // com.explorestack.protobuf.ProtocolMessageEnum, com.explorestack.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static AdType valueOf(int i) {
            return forNumber(i);
        }

        public static AdType forNumber(int i) {
            if (i == 0) {
                return UNKNOWN;
            }
            if (i == 1) {
                return INTERSTITIAL;
            }
            if (i == 2) {
                return REWARDED;
            }
            if (i != 3) {
                return null;
            }
            return BANNER;
        }

        public static Internal.EnumLiteMap<AdType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.explorestack.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this == UNRECOGNIZED) {
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }
            return getDescriptor().getValues().get(ordinal());
        }

        @Override // com.explorestack.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SessionMetricsOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static AdType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (enumValueDescriptor.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[enumValueDescriptor.getIndex()];
        }

        AdType(int i) {
            this.value = i;
        }
    }

    public static final class UserState extends GeneratedMessageV3 implements UserStateOrBuilder {
        public static final int AD_REQUESTS_FIELD_NUMBER = 3;
        public static final int IMPRESSIONS_FIELD_NUMBER = 2;
        public static final int LAST_PROCESSED_TIMESTAMP_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private MapField<Integer, Timestamps> adRequests_;
        private MapField<Integer, AdDomainTimestamps> impressions_;
        private long lastProcessedTimestamp_;
        private byte memoizedIsInitialized;
        private static final UserState DEFAULT_INSTANCE = new UserState();
        private static final Parser<UserState> PARSER = new AbstractParser<UserState>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserState.1
            @Override // com.explorestack.protobuf.Parser
            public UserState parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserState(codedInputStream, extensionRegistryLite);
            }
        };

        private UserState(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private UserState() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new UserState();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private UserState(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.lastProcessedTimestamp_ = codedInputStream.readInt64();
                            } else if (readTag == 18) {
                                if ((i & 1) == 0) {
                                    this.impressions_ = MapField.newMapField(ImpressionsDefaultEntryHolder.defaultEntry);
                                    i |= 1;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(ImpressionsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.impressions_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                            } else if (readTag == 26) {
                                if ((i & 2) == 0) {
                                    this.adRequests_ = MapField.newMapField(AdRequestsDefaultEntryHolder.defaultEntry);
                                    i |= 2;
                                }
                                MapEntry mapEntry2 = (MapEntry) codedInputStream.readMessage(AdRequestsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.adRequests_.getMutableMap().put(mapEntry2.getKey(), mapEntry2.getValue());
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
            return SessionMetricsOuterClass.internal_static_sessionmetrics_UserState_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected MapField internalGetMapField(int i) {
            if (i == 2) {
                return internalGetImpressions();
            }
            if (i == 3) {
                return internalGetAdRequests();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_UserState_fieldAccessorTable.ensureFieldAccessorsInitialized(UserState.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public long getLastProcessedTimestamp() {
            return this.lastProcessedTimestamp_;
        }

        private static final class ImpressionsDefaultEntryHolder {
            static final MapEntry<Integer, AdDomainTimestamps> defaultEntry = MapEntry.newDefaultInstance(SessionMetricsOuterClass.internal_static_sessionmetrics_UserState_ImpressionsEntry_descriptor, WireFormat.FieldType.INT32, 0, WireFormat.FieldType.MESSAGE, AdDomainTimestamps.getDefaultInstance());

            private ImpressionsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<Integer, AdDomainTimestamps> internalGetImpressions() {
            MapField<Integer, AdDomainTimestamps> mapField = this.impressions_;
            return mapField == null ? MapField.emptyMapField(ImpressionsDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public int getImpressionsCount() {
            return internalGetImpressions().getMap().size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public boolean containsImpressions(int i) {
            return internalGetImpressions().getMap().containsKey(Integer.valueOf(i));
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        @Deprecated
        public Map<Integer, AdDomainTimestamps> getImpressions() {
            return getImpressionsMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public Map<Integer, AdDomainTimestamps> getImpressionsMap() {
            return internalGetImpressions().getMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public AdDomainTimestamps getImpressionsOrDefault(int i, AdDomainTimestamps adDomainTimestamps) {
            Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
            return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : adDomainTimestamps;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public AdDomainTimestamps getImpressionsOrThrow(int i) {
            Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
            if (!map.containsKey(Integer.valueOf(i))) {
                throw new IllegalArgumentException();
            }
            return map.get(Integer.valueOf(i));
        }

        private static final class AdRequestsDefaultEntryHolder {
            static final MapEntry<Integer, Timestamps> defaultEntry = MapEntry.newDefaultInstance(SessionMetricsOuterClass.internal_static_sessionmetrics_UserState_AdRequestsEntry_descriptor, WireFormat.FieldType.INT32, 0, WireFormat.FieldType.MESSAGE, Timestamps.getDefaultInstance());

            private AdRequestsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<Integer, Timestamps> internalGetAdRequests() {
            MapField<Integer, Timestamps> mapField = this.adRequests_;
            return mapField == null ? MapField.emptyMapField(AdRequestsDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public int getAdRequestsCount() {
            return internalGetAdRequests().getMap().size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public boolean containsAdRequests(int i) {
            return internalGetAdRequests().getMap().containsKey(Integer.valueOf(i));
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        @Deprecated
        public Map<Integer, Timestamps> getAdRequests() {
            return getAdRequestsMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public Map<Integer, Timestamps> getAdRequestsMap() {
            return internalGetAdRequests().getMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public Timestamps getAdRequestsOrDefault(int i, Timestamps timestamps) {
            Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
            return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : timestamps;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
        public Timestamps getAdRequestsOrThrow(int i) {
            Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
            if (!map.containsKey(Integer.valueOf(i))) {
                throw new IllegalArgumentException();
            }
            return map.get(Integer.valueOf(i));
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
            long j = this.lastProcessedTimestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            GeneratedMessageV3.serializeIntegerMapTo(codedOutputStream, internalGetImpressions(), ImpressionsDefaultEntryHolder.defaultEntry, 2);
            GeneratedMessageV3.serializeIntegerMapTo(codedOutputStream, internalGetAdRequests(), AdRequestsDefaultEntryHolder.defaultEntry, 3);
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.lastProcessedTimestamp_;
            int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
            for (Map.Entry<Integer, AdDomainTimestamps> entry : internalGetImpressions().getMap().entrySet()) {
                computeInt64Size += CodedOutputStream.computeMessageSize(2, ImpressionsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            for (Map.Entry<Integer, Timestamps> entry2 : internalGetAdRequests().getMap().entrySet()) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, AdRequestsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserState)) {
                return super.equals(obj);
            }
            UserState userState = (UserState) obj;
            return getLastProcessedTimestamp() == userState.getLastProcessedTimestamp() && internalGetImpressions().equals(userState.internalGetImpressions()) && internalGetAdRequests().equals(userState.internalGetAdRequests()) && this.unknownFields.equals(userState.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getLastProcessedTimestamp());
            if (!internalGetImpressions().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 2) * 53) + internalGetImpressions().hashCode();
            }
            if (!internalGetAdRequests().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 3) * 53) + internalGetAdRequests().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static UserState parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static UserState parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static UserState parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserState parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserState parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserState parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserState parseFrom(InputStream inputStream) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserState parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserState parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserState) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserState parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserState) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserState parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserState parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserState) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserState userState) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userState);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserStateOrBuilder {
            private MapField<Integer, Timestamps> adRequests_;
            private int bitField0_;
            private MapField<Integer, AdDomainTimestamps> impressions_;
            private long lastProcessedTimestamp_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserState_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMapField(int i) {
                if (i == 2) {
                    return internalGetImpressions();
                }
                if (i == 3) {
                    return internalGetAdRequests();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMutableMapField(int i) {
                if (i == 2) {
                    return internalGetMutableImpressions();
                }
                if (i == 3) {
                    return internalGetMutableAdRequests();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserState_fieldAccessorTable.ensureFieldAccessorsInitialized(UserState.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = UserState.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.lastProcessedTimestamp_ = 0L;
                internalGetMutableImpressions().clear();
                internalGetMutableAdRequests().clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserState_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public UserState getDefaultInstanceForType() {
                return UserState.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserState build() {
                UserState buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserState buildPartial() {
                UserState userState = new UserState(this);
                userState.lastProcessedTimestamp_ = this.lastProcessedTimestamp_;
                userState.impressions_ = internalGetImpressions();
                userState.impressions_.makeImmutable();
                userState.adRequests_ = internalGetAdRequests();
                userState.adRequests_.makeImmutable();
                onBuilt();
                return userState;
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
                if (message instanceof UserState) {
                    return mergeFrom((UserState) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(UserState userState) {
                if (userState == UserState.getDefaultInstance()) {
                    return this;
                }
                if (userState.getLastProcessedTimestamp() != 0) {
                    setLastProcessedTimestamp(userState.getLastProcessedTimestamp());
                }
                internalGetMutableImpressions().mergeFrom(userState.internalGetImpressions());
                internalGetMutableAdRequests().mergeFrom(userState.internalGetAdRequests());
                mergeUnknownFields(userState.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                UserState userState = null;
                try {
                    try {
                        UserState userState2 = (UserState) UserState.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (userState2 != null) {
                            mergeFrom(userState2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        UserState userState3 = (UserState) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            userState = userState3;
                            if (userState != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (userState != null) {
                        mergeFrom(userState);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public long getLastProcessedTimestamp() {
                return this.lastProcessedTimestamp_;
            }

            public Builder setLastProcessedTimestamp(long j) {
                this.lastProcessedTimestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearLastProcessedTimestamp() {
                this.lastProcessedTimestamp_ = 0L;
                onChanged();
                return this;
            }

            private MapField<Integer, AdDomainTimestamps> internalGetImpressions() {
                MapField<Integer, AdDomainTimestamps> mapField = this.impressions_;
                return mapField == null ? MapField.emptyMapField(ImpressionsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<Integer, AdDomainTimestamps> internalGetMutableImpressions() {
                onChanged();
                if (this.impressions_ == null) {
                    this.impressions_ = MapField.newMapField(ImpressionsDefaultEntryHolder.defaultEntry);
                }
                if (!this.impressions_.isMutable()) {
                    this.impressions_ = this.impressions_.copy();
                }
                return this.impressions_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public int getImpressionsCount() {
                return internalGetImpressions().getMap().size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public boolean containsImpressions(int i) {
                return internalGetImpressions().getMap().containsKey(Integer.valueOf(i));
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            @Deprecated
            public Map<Integer, AdDomainTimestamps> getImpressions() {
                return getImpressionsMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public Map<Integer, AdDomainTimestamps> getImpressionsMap() {
                return internalGetImpressions().getMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public AdDomainTimestamps getImpressionsOrDefault(int i, AdDomainTimestamps adDomainTimestamps) {
                Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
                return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : adDomainTimestamps;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public AdDomainTimestamps getImpressionsOrThrow(int i) {
                Map<Integer, AdDomainTimestamps> map = internalGetImpressions().getMap();
                if (!map.containsKey(Integer.valueOf(i))) {
                    throw new IllegalArgumentException();
                }
                return map.get(Integer.valueOf(i));
            }

            public Builder clearImpressions() {
                internalGetMutableImpressions().getMutableMap().clear();
                return this;
            }

            public Builder removeImpressions(int i) {
                internalGetMutableImpressions().getMutableMap().remove(Integer.valueOf(i));
                return this;
            }

            @Deprecated
            public Map<Integer, AdDomainTimestamps> getMutableImpressions() {
                return internalGetMutableImpressions().getMutableMap();
            }

            public Builder putImpressions(int i, AdDomainTimestamps adDomainTimestamps) {
                adDomainTimestamps.getClass();
                internalGetMutableImpressions().getMutableMap().put(Integer.valueOf(i), adDomainTimestamps);
                return this;
            }

            public Builder putAllImpressions(Map<Integer, AdDomainTimestamps> map) {
                internalGetMutableImpressions().getMutableMap().putAll(map);
                return this;
            }

            private MapField<Integer, Timestamps> internalGetAdRequests() {
                MapField<Integer, Timestamps> mapField = this.adRequests_;
                return mapField == null ? MapField.emptyMapField(AdRequestsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<Integer, Timestamps> internalGetMutableAdRequests() {
                onChanged();
                if (this.adRequests_ == null) {
                    this.adRequests_ = MapField.newMapField(AdRequestsDefaultEntryHolder.defaultEntry);
                }
                if (!this.adRequests_.isMutable()) {
                    this.adRequests_ = this.adRequests_.copy();
                }
                return this.adRequests_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public int getAdRequestsCount() {
                return internalGetAdRequests().getMap().size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public boolean containsAdRequests(int i) {
                return internalGetAdRequests().getMap().containsKey(Integer.valueOf(i));
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            @Deprecated
            public Map<Integer, Timestamps> getAdRequests() {
                return getAdRequestsMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public Map<Integer, Timestamps> getAdRequestsMap() {
                return internalGetAdRequests().getMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public Timestamps getAdRequestsOrDefault(int i, Timestamps timestamps) {
                Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
                return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : timestamps;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserStateOrBuilder
            public Timestamps getAdRequestsOrThrow(int i) {
                Map<Integer, Timestamps> map = internalGetAdRequests().getMap();
                if (!map.containsKey(Integer.valueOf(i))) {
                    throw new IllegalArgumentException();
                }
                return map.get(Integer.valueOf(i));
            }

            public Builder clearAdRequests() {
                internalGetMutableAdRequests().getMutableMap().clear();
                return this;
            }

            public Builder removeAdRequests(int i) {
                internalGetMutableAdRequests().getMutableMap().remove(Integer.valueOf(i));
                return this;
            }

            @Deprecated
            public Map<Integer, Timestamps> getMutableAdRequests() {
                return internalGetMutableAdRequests().getMutableMap();
            }

            public Builder putAdRequests(int i, Timestamps timestamps) {
                timestamps.getClass();
                internalGetMutableAdRequests().getMutableMap().put(Integer.valueOf(i), timestamps);
                return this;
            }

            public Builder putAllAdRequests(Map<Integer, Timestamps> map) {
                internalGetMutableAdRequests().getMutableMap().putAll(map);
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

        public static UserState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserState> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<UserState> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public UserState getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class UserSession extends GeneratedMessageV3 implements UserSessionOrBuilder {
        public static final int LAST_ACTIVITY_FIELD_NUMBER = 1;
        public static final int METRICS_BY_AD_TYPE_FIELD_NUMBER = 3;
        public static final int SESSION_START_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private long lastActivity_;
        private byte memoizedIsInitialized;
        private List<AdTypeMetrics> metricsByAdType_;
        private long sessionStart_;
        private static final UserSession DEFAULT_INSTANCE = new UserSession();
        private static final Parser<UserSession> PARSER = new AbstractParser<UserSession>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.1
            @Override // com.explorestack.protobuf.Parser
            public UserSession parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserSession(codedInputStream, extensionRegistryLite);
            }
        };

        public interface AdTypeMetricsOrBuilder extends MessageOrBuilder {
            int getAdRequests();

            AdType getAdType();

            int getAdTypeValue();

            Auction getAuctions(int i);

            int getAuctionsCount();

            List<Auction> getAuctionsList();

            AuctionOrBuilder getAuctionsOrBuilder(int i);

            List<? extends AuctionOrBuilder> getAuctionsOrBuilderList();

            int getBids();

            float getCumulativeBidPrice();

            float getCumulativeLurlPrice();

            float getCumulativeNurlPrice();

            Ecpm getEcpm();

            EcpmOrBuilder getEcpmOrBuilder();

            int getImpressions();

            int getLosses();

            int getLurls();

            int getNurls();

            int getWins();

            boolean hasEcpm();
        }

        public interface AuctionOrBuilder extends MessageOrBuilder {
            int getLosersBidderId(int i);

            int getLosersBidderIdCount();

            List<Integer> getLosersBidderIdList();

            ByteString getSourceRequestId();

            int getWinnerBidderId();
        }

        public interface EcpmOrBuilder extends MessageOrBuilder {
            int getCount();

            double getFirstPrices(int i);

            int getFirstPricesCount();

            List<Double> getFirstPricesList();

            double getLastPrices(int i);

            int getLastPricesCount();

            List<Double> getLastPricesList();
        }

        private UserSession(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private UserSession() {
            this.memoizedIsInitialized = (byte) -1;
            this.metricsByAdType_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new UserSession();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private UserSession(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.lastActivity_ = codedInputStream.readInt64();
                                } else if (readTag == 26) {
                                    if (!z2) {
                                        this.metricsByAdType_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.metricsByAdType_.add(codedInputStream.readMessage(AdTypeMetrics.parser(), extensionRegistryLite));
                                } else if (readTag == 32) {
                                    this.sessionStart_ = codedInputStream.readInt64();
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
                    if (z2) {
                        this.metricsByAdType_ = Collections.unmodifiableList(this.metricsByAdType_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_fieldAccessorTable.ensureFieldAccessorsInitialized(UserSession.class, Builder.class);
        }

        public static final class Ecpm extends GeneratedMessageV3 implements EcpmOrBuilder {
            public static final int COUNT_FIELD_NUMBER = 3;
            public static final int FIRST_PRICES_FIELD_NUMBER = 1;
            public static final int LAST_PRICES_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private int count_;
            private int firstPricesMemoizedSerializedSize;
            private Internal.DoubleList firstPrices_;
            private int lastPricesMemoizedSerializedSize;
            private Internal.DoubleList lastPrices_;
            private byte memoizedIsInitialized;
            private static final Ecpm DEFAULT_INSTANCE = new Ecpm();
            private static final Parser<Ecpm> PARSER = new AbstractParser<Ecpm>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.Ecpm.1
                @Override // com.explorestack.protobuf.Parser
                public Ecpm parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Ecpm(codedInputStream, extensionRegistryLite);
                }
            };

            private Ecpm(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.firstPricesMemoizedSerializedSize = -1;
                this.lastPricesMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
            }

            private Ecpm() {
                this.firstPricesMemoizedSerializedSize = -1;
                this.lastPricesMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.firstPrices_ = emptyDoubleList();
                this.lastPrices_ = emptyDoubleList();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new Ecpm();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private Ecpm(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                extensionRegistryLite.getClass();
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                int i = 0;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 24) {
                                    this.count_ = codedInputStream.readInt32();
                                } else if (readTag == 9) {
                                    if ((i & 1) == 0) {
                                        this.firstPrices_ = newDoubleList();
                                        i |= 1;
                                    }
                                    this.firstPrices_.addDouble(codedInputStream.readDouble());
                                } else if (readTag == 10) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i & 1) == 0 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.firstPrices_ = newDoubleList();
                                        i |= 1;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.firstPrices_.addDouble(codedInputStream.readDouble());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 17) {
                                    if ((i & 2) == 0) {
                                        this.lastPrices_ = newDoubleList();
                                        i |= 2;
                                    }
                                    this.lastPrices_.addDouble(codedInputStream.readDouble());
                                } else if (readTag == 18) {
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i & 2) == 0 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.lastPrices_ = newDoubleList();
                                        i |= 2;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.lastPrices_.addDouble(codedInputStream.readDouble());
                                    }
                                    codedInputStream.popLimit(pushLimit2);
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
                        if ((i & 1) != 0) {
                            this.firstPrices_.makeImmutable();
                        }
                        if ((i & 2) != 0) {
                            this.lastPrices_.makeImmutable();
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Ecpm_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Ecpm_fieldAccessorTable.ensureFieldAccessorsInitialized(Ecpm.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
            public List<Double> getFirstPricesList() {
                return this.firstPrices_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
            public int getFirstPricesCount() {
                return this.firstPrices_.size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
            public double getFirstPrices(int i) {
                return this.firstPrices_.getDouble(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
            public List<Double> getLastPricesList() {
                return this.lastPrices_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
            public int getLastPricesCount() {
                return this.lastPrices_.size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
            public double getLastPrices(int i) {
                return this.lastPrices_.getDouble(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
            public int getCount() {
                return this.count_;
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
                getSerializedSize();
                if (getFirstPricesList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(10);
                    codedOutputStream.writeUInt32NoTag(this.firstPricesMemoizedSerializedSize);
                }
                for (int i = 0; i < this.firstPrices_.size(); i++) {
                    codedOutputStream.writeDoubleNoTag(this.firstPrices_.getDouble(i));
                }
                if (getLastPricesList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(18);
                    codedOutputStream.writeUInt32NoTag(this.lastPricesMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.lastPrices_.size(); i2++) {
                    codedOutputStream.writeDoubleNoTag(this.lastPrices_.getDouble(i2));
                }
                int i3 = this.count_;
                if (i3 != 0) {
                    codedOutputStream.writeInt32(3, i3);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int size = getFirstPricesList().size() * 8;
                int computeInt32SizeNoTag = !getFirstPricesList().isEmpty() ? size + 1 + CodedOutputStream.computeInt32SizeNoTag(size) : size;
                this.firstPricesMemoizedSerializedSize = size;
                int size2 = getLastPricesList().size() * 8;
                int i2 = computeInt32SizeNoTag + size2;
                if (!getLastPricesList().isEmpty()) {
                    i2 = i2 + 1 + CodedOutputStream.computeInt32SizeNoTag(size2);
                }
                this.lastPricesMemoizedSerializedSize = size2;
                int i3 = this.count_;
                if (i3 != 0) {
                    i2 += CodedOutputStream.computeInt32Size(3, i3);
                }
                int serializedSize = i2 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Ecpm)) {
                    return super.equals(obj);
                }
                Ecpm ecpm = (Ecpm) obj;
                return getFirstPricesList().equals(ecpm.getFirstPricesList()) && getLastPricesList().equals(ecpm.getLastPricesList()) && getCount() == ecpm.getCount() && this.unknownFields.equals(ecpm.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = 779 + getDescriptor().hashCode();
                if (getFirstPricesCount() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getFirstPricesList().hashCode();
                }
                if (getLastPricesCount() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getLastPricesList().hashCode();
                }
                int count = (((((hashCode * 37) + 3) * 53) + getCount()) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = count;
                return count;
            }

            public static Ecpm parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Ecpm parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static Ecpm parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Ecpm parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Ecpm parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Ecpm parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Ecpm parseFrom(InputStream inputStream) throws IOException {
                return (Ecpm) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Ecpm parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Ecpm) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Ecpm parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Ecpm) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Ecpm parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Ecpm) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Ecpm parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Ecpm) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Ecpm parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Ecpm) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Ecpm ecpm) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(ecpm);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EcpmOrBuilder {
                private int bitField0_;
                private int count_;
                private Internal.DoubleList firstPrices_;
                private Internal.DoubleList lastPrices_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Ecpm_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Ecpm_fieldAccessorTable.ensureFieldAccessorsInitialized(Ecpm.class, Builder.class);
                }

                private Builder() {
                    this.firstPrices_ = Ecpm.emptyDoubleList();
                    this.lastPrices_ = Ecpm.emptyDoubleList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.firstPrices_ = Ecpm.emptyDoubleList();
                    this.lastPrices_ = Ecpm.emptyDoubleList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = Ecpm.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.firstPrices_ = Ecpm.emptyDoubleList();
                    this.bitField0_ &= -2;
                    this.lastPrices_ = Ecpm.emptyDoubleList();
                    this.bitField0_ &= -3;
                    this.count_ = 0;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Ecpm_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Ecpm getDefaultInstanceForType() {
                    return Ecpm.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Ecpm build() {
                    Ecpm buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Ecpm buildPartial() {
                    Ecpm ecpm = new Ecpm(this);
                    if ((this.bitField0_ & 1) != 0) {
                        this.firstPrices_.makeImmutable();
                        this.bitField0_ &= -2;
                    }
                    ecpm.firstPrices_ = this.firstPrices_;
                    if ((this.bitField0_ & 2) != 0) {
                        this.lastPrices_.makeImmutable();
                        this.bitField0_ &= -3;
                    }
                    ecpm.lastPrices_ = this.lastPrices_;
                    ecpm.count_ = this.count_;
                    onBuilt();
                    return ecpm;
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
                    if (message instanceof Ecpm) {
                        return mergeFrom((Ecpm) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Ecpm ecpm) {
                    if (ecpm == Ecpm.getDefaultInstance()) {
                        return this;
                    }
                    if (!ecpm.firstPrices_.isEmpty()) {
                        if (this.firstPrices_.isEmpty()) {
                            this.firstPrices_ = ecpm.firstPrices_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFirstPricesIsMutable();
                            this.firstPrices_.addAll(ecpm.firstPrices_);
                        }
                        onChanged();
                    }
                    if (!ecpm.lastPrices_.isEmpty()) {
                        if (this.lastPrices_.isEmpty()) {
                            this.lastPrices_ = ecpm.lastPrices_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureLastPricesIsMutable();
                            this.lastPrices_.addAll(ecpm.lastPrices_);
                        }
                        onChanged();
                    }
                    if (ecpm.getCount() != 0) {
                        setCount(ecpm.getCount());
                    }
                    mergeUnknownFields(ecpm.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Ecpm ecpm = null;
                    try {
                        try {
                            Ecpm ecpm2 = (Ecpm) Ecpm.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (ecpm2 != null) {
                                mergeFrom(ecpm2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Ecpm ecpm3 = (Ecpm) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                ecpm = ecpm3;
                                if (ecpm != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (ecpm != null) {
                            mergeFrom(ecpm);
                        }
                        throw th;
                    }
                }

                private void ensureFirstPricesIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.firstPrices_ = Ecpm.mutableCopy(this.firstPrices_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
                public List<Double> getFirstPricesList() {
                    return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.firstPrices_) : this.firstPrices_;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
                public int getFirstPricesCount() {
                    return this.firstPrices_.size();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
                public double getFirstPrices(int i) {
                    return this.firstPrices_.getDouble(i);
                }

                public Builder setFirstPrices(int i, double d) {
                    ensureFirstPricesIsMutable();
                    this.firstPrices_.setDouble(i, d);
                    onChanged();
                    return this;
                }

                public Builder addFirstPrices(double d) {
                    ensureFirstPricesIsMutable();
                    this.firstPrices_.addDouble(d);
                    onChanged();
                    return this;
                }

                public Builder addAllFirstPrices(Iterable<? extends Double> iterable) {
                    ensureFirstPricesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.firstPrices_);
                    onChanged();
                    return this;
                }

                public Builder clearFirstPrices() {
                    this.firstPrices_ = Ecpm.emptyDoubleList();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                private void ensureLastPricesIsMutable() {
                    if ((this.bitField0_ & 2) == 0) {
                        this.lastPrices_ = Ecpm.mutableCopy(this.lastPrices_);
                        this.bitField0_ |= 2;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
                public List<Double> getLastPricesList() {
                    return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.lastPrices_) : this.lastPrices_;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
                public int getLastPricesCount() {
                    return this.lastPrices_.size();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
                public double getLastPrices(int i) {
                    return this.lastPrices_.getDouble(i);
                }

                public Builder setLastPrices(int i, double d) {
                    ensureLastPricesIsMutable();
                    this.lastPrices_.setDouble(i, d);
                    onChanged();
                    return this;
                }

                public Builder addLastPrices(double d) {
                    ensureLastPricesIsMutable();
                    this.lastPrices_.addDouble(d);
                    onChanged();
                    return this;
                }

                public Builder addAllLastPrices(Iterable<? extends Double> iterable) {
                    ensureLastPricesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.lastPrices_);
                    onChanged();
                    return this;
                }

                public Builder clearLastPrices() {
                    this.lastPrices_ = Ecpm.emptyDoubleList();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.EcpmOrBuilder
                public int getCount() {
                    return this.count_;
                }

                public Builder setCount(int i) {
                    this.count_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearCount() {
                    this.count_ = 0;
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

            public static Ecpm getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Ecpm> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<Ecpm> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Ecpm getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class Auction extends GeneratedMessageV3 implements AuctionOrBuilder {
            public static final int LOSERS_BIDDER_ID_FIELD_NUMBER = 3;
            public static final int SOURCE_REQUEST_ID_FIELD_NUMBER = 1;
            public static final int WINNER_BIDDER_ID_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private int losersBidderIdMemoizedSerializedSize;
            private Internal.IntList losersBidderId_;
            private byte memoizedIsInitialized;
            private ByteString sourceRequestId_;
            private int winnerBidderId_;
            private static final Auction DEFAULT_INSTANCE = new Auction();
            private static final Parser<Auction> PARSER = new AbstractParser<Auction>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.Auction.1
                @Override // com.explorestack.protobuf.Parser
                public Auction parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Auction(codedInputStream, extensionRegistryLite);
                }
            };

            private Auction(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.losersBidderIdMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
            }

            private Auction() {
                this.losersBidderIdMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.sourceRequestId_ = ByteString.EMPTY;
                this.losersBidderId_ = emptyIntList();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new Auction();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private Auction(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.sourceRequestId_ = codedInputStream.readBytes();
                                } else if (readTag == 16) {
                                    this.winnerBidderId_ = codedInputStream.readUInt32();
                                } else if (readTag == 24) {
                                    if (!z2) {
                                        this.losersBidderId_ = newIntList();
                                        z2 = true;
                                    }
                                    this.losersBidderId_.addInt(codedInputStream.readUInt32());
                                } else if (readTag == 26) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!z2 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.losersBidderId_ = newIntList();
                                        z2 = true;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.losersBidderId_.addInt(codedInputStream.readUInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
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
                            this.losersBidderId_.makeImmutable();
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Auction_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Auction_fieldAccessorTable.ensureFieldAccessorsInitialized(Auction.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
            public ByteString getSourceRequestId() {
                return this.sourceRequestId_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
            public int getWinnerBidderId() {
                return this.winnerBidderId_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
            public List<Integer> getLosersBidderIdList() {
                return this.losersBidderId_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
            public int getLosersBidderIdCount() {
                return this.losersBidderId_.size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
            public int getLosersBidderId(int i) {
                return this.losersBidderId_.getInt(i);
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
                getSerializedSize();
                if (!this.sourceRequestId_.isEmpty()) {
                    codedOutputStream.writeBytes(1, this.sourceRequestId_);
                }
                int i = this.winnerBidderId_;
                if (i != 0) {
                    codedOutputStream.writeUInt32(2, i);
                }
                if (getLosersBidderIdList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(26);
                    codedOutputStream.writeUInt32NoTag(this.losersBidderIdMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.losersBidderId_.size(); i2++) {
                    codedOutputStream.writeUInt32NoTag(this.losersBidderId_.getInt(i2));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int computeBytesSize = !this.sourceRequestId_.isEmpty() ? CodedOutputStream.computeBytesSize(1, this.sourceRequestId_) : 0;
                int i2 = this.winnerBidderId_;
                if (i2 != 0) {
                    computeBytesSize += CodedOutputStream.computeUInt32Size(2, i2);
                }
                int i3 = 0;
                for (int i4 = 0; i4 < this.losersBidderId_.size(); i4++) {
                    i3 += CodedOutputStream.computeUInt32SizeNoTag(this.losersBidderId_.getInt(i4));
                }
                int i5 = computeBytesSize + i3;
                if (!getLosersBidderIdList().isEmpty()) {
                    i5 = i5 + 1 + CodedOutputStream.computeInt32SizeNoTag(i3);
                }
                this.losersBidderIdMemoizedSerializedSize = i3;
                int serializedSize = i5 + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Auction)) {
                    return super.equals(obj);
                }
                Auction auction = (Auction) obj;
                return getSourceRequestId().equals(auction.getSourceRequestId()) && getWinnerBidderId() == auction.getWinnerBidderId() && getLosersBidderIdList().equals(auction.getLosersBidderIdList()) && this.unknownFields.equals(auction.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSourceRequestId().hashCode()) * 37) + 2) * 53) + getWinnerBidderId();
                if (getLosersBidderIdCount() > 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + getLosersBidderIdList().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static Auction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Auction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static Auction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static Auction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static Auction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static Auction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Auction parseFrom(InputStream inputStream) throws IOException {
                return (Auction) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Auction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Auction) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Auction parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Auction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Auction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Auction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Auction parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Auction) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Auction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Auction) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(Auction auction) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(auction);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuctionOrBuilder {
                private int bitField0_;
                private Internal.IntList losersBidderId_;
                private ByteString sourceRequestId_;
                private int winnerBidderId_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Auction_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Auction_fieldAccessorTable.ensureFieldAccessorsInitialized(Auction.class, Builder.class);
                }

                private Builder() {
                    this.sourceRequestId_ = ByteString.EMPTY;
                    this.losersBidderId_ = Auction.emptyIntList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.sourceRequestId_ = ByteString.EMPTY;
                    this.losersBidderId_ = Auction.emptyIntList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = Auction.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.sourceRequestId_ = ByteString.EMPTY;
                    this.winnerBidderId_ = 0;
                    this.losersBidderId_ = Auction.emptyIntList();
                    this.bitField0_ &= -2;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_Auction_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public Auction getDefaultInstanceForType() {
                    return Auction.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Auction build() {
                    Auction buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Auction buildPartial() {
                    Auction auction = new Auction(this);
                    auction.sourceRequestId_ = this.sourceRequestId_;
                    auction.winnerBidderId_ = this.winnerBidderId_;
                    if ((this.bitField0_ & 1) != 0) {
                        this.losersBidderId_.makeImmutable();
                        this.bitField0_ &= -2;
                    }
                    auction.losersBidderId_ = this.losersBidderId_;
                    onBuilt();
                    return auction;
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
                    if (message instanceof Auction) {
                        return mergeFrom((Auction) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Auction auction) {
                    if (auction == Auction.getDefaultInstance()) {
                        return this;
                    }
                    if (auction.getSourceRequestId() != ByteString.EMPTY) {
                        setSourceRequestId(auction.getSourceRequestId());
                    }
                    if (auction.getWinnerBidderId() != 0) {
                        setWinnerBidderId(auction.getWinnerBidderId());
                    }
                    if (!auction.losersBidderId_.isEmpty()) {
                        if (this.losersBidderId_.isEmpty()) {
                            this.losersBidderId_ = auction.losersBidderId_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLosersBidderIdIsMutable();
                            this.losersBidderId_.addAll(auction.losersBidderId_);
                        }
                        onChanged();
                    }
                    mergeUnknownFields(auction.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    Auction auction = null;
                    try {
                        try {
                            Auction auction2 = (Auction) Auction.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (auction2 != null) {
                                mergeFrom(auction2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            Auction auction3 = (Auction) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                auction = auction3;
                                if (auction != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (auction != null) {
                            mergeFrom(auction);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
                public ByteString getSourceRequestId() {
                    return this.sourceRequestId_;
                }

                public Builder setSourceRequestId(ByteString byteString) {
                    byteString.getClass();
                    this.sourceRequestId_ = byteString;
                    onChanged();
                    return this;
                }

                public Builder clearSourceRequestId() {
                    this.sourceRequestId_ = Auction.getDefaultInstance().getSourceRequestId();
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
                public int getWinnerBidderId() {
                    return this.winnerBidderId_;
                }

                public Builder setWinnerBidderId(int i) {
                    this.winnerBidderId_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearWinnerBidderId() {
                    this.winnerBidderId_ = 0;
                    onChanged();
                    return this;
                }

                private void ensureLosersBidderIdIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.losersBidderId_ = Auction.mutableCopy(this.losersBidderId_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
                public List<Integer> getLosersBidderIdList() {
                    return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.losersBidderId_) : this.losersBidderId_;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
                public int getLosersBidderIdCount() {
                    return this.losersBidderId_.size();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AuctionOrBuilder
                public int getLosersBidderId(int i) {
                    return this.losersBidderId_.getInt(i);
                }

                public Builder setLosersBidderId(int i, int i2) {
                    ensureLosersBidderIdIsMutable();
                    this.losersBidderId_.setInt(i, i2);
                    onChanged();
                    return this;
                }

                public Builder addLosersBidderId(int i) {
                    ensureLosersBidderIdIsMutable();
                    this.losersBidderId_.addInt(i);
                    onChanged();
                    return this;
                }

                public Builder addAllLosersBidderId(Iterable<? extends Integer> iterable) {
                    ensureLosersBidderIdIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.losersBidderId_);
                    onChanged();
                    return this;
                }

                public Builder clearLosersBidderId() {
                    this.losersBidderId_ = Auction.emptyIntList();
                    this.bitField0_ &= -2;
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

            public static Auction getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<Auction> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<Auction> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Auction getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        public static final class AdTypeMetrics extends GeneratedMessageV3 implements AdTypeMetricsOrBuilder {
            public static final int AD_REQUESTS_FIELD_NUMBER = 3;
            public static final int AD_TYPE_FIELD_NUMBER = 1;
            public static final int AUCTIONS_FIELD_NUMBER = 13;
            public static final int BIDS_FIELD_NUMBER = 4;
            public static final int CUMULATIVE_BID_PRICE_FIELD_NUMBER = 9;
            public static final int CUMULATIVE_LURL_PRICE_FIELD_NUMBER = 10;
            public static final int CUMULATIVE_NURL_PRICE_FIELD_NUMBER = 11;
            public static final int ECPM_FIELD_NUMBER = 12;
            public static final int IMPRESSIONS_FIELD_NUMBER = 2;
            public static final int LOSSES_FIELD_NUMBER = 6;
            public static final int LURLS_FIELD_NUMBER = 7;
            public static final int NURLS_FIELD_NUMBER = 8;
            public static final int WINS_FIELD_NUMBER = 5;
            private static final long serialVersionUID = 0;
            private int adRequests_;
            private int adType_;
            private List<Auction> auctions_;
            private int bids_;
            private float cumulativeBidPrice_;
            private float cumulativeLurlPrice_;
            private float cumulativeNurlPrice_;
            private Ecpm ecpm_;
            private int impressions_;
            private int losses_;
            private int lurls_;
            private byte memoizedIsInitialized;
            private int nurls_;
            private int wins_;
            private static final AdTypeMetrics DEFAULT_INSTANCE = new AdTypeMetrics();
            private static final Parser<AdTypeMetrics> PARSER = new AbstractParser<AdTypeMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetrics.1
                @Override // com.explorestack.protobuf.Parser
                public AdTypeMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new AdTypeMetrics(codedInputStream, extensionRegistryLite);
                }
            };

            private AdTypeMetrics(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private AdTypeMetrics() {
                this.memoizedIsInitialized = (byte) -1;
                this.adType_ = 0;
                this.auctions_ = Collections.emptyList();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new AdTypeMetrics();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            /* JADX WARN: Multi-variable type inference failed */
            private AdTypeMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                extensionRegistryLite.getClass();
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z = false;
                boolean z2 = false;
                while (!z) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                case 8:
                                    this.adType_ = codedInputStream.readEnum();
                                case 16:
                                    this.impressions_ = codedInputStream.readInt32();
                                case 24:
                                    this.adRequests_ = codedInputStream.readInt32();
                                case 32:
                                    this.bids_ = codedInputStream.readInt32();
                                case 40:
                                    this.wins_ = codedInputStream.readInt32();
                                case 48:
                                    this.losses_ = codedInputStream.readInt32();
                                case 56:
                                    this.lurls_ = codedInputStream.readInt32();
                                case 64:
                                    this.nurls_ = codedInputStream.readInt32();
                                case Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER /* 77 */:
                                    this.cumulativeBidPrice_ = codedInputStream.readFloat();
                                case 85:
                                    this.cumulativeLurlPrice_ = codedInputStream.readFloat();
                                case 93:
                                    this.cumulativeNurlPrice_ = codedInputStream.readFloat();
                                case 98:
                                    Ecpm ecpm = this.ecpm_;
                                    Ecpm.Builder builder = ecpm != null ? ecpm.toBuilder() : null;
                                    Ecpm ecpm2 = (Ecpm) codedInputStream.readMessage(Ecpm.parser(), extensionRegistryLite);
                                    this.ecpm_ = ecpm2;
                                    if (builder != null) {
                                        builder.mergeFrom(ecpm2);
                                        this.ecpm_ = builder.buildPartial();
                                    }
                                case 106:
                                    if (!z2) {
                                        this.auctions_ = new ArrayList();
                                        z2 = true;
                                    }
                                    this.auctions_.add(codedInputStream.readMessage(Auction.parser(), extensionRegistryLite));
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        z = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                        }
                    } finally {
                        if (z2) {
                            this.auctions_ = Collections.unmodifiableList(this.auctions_);
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_AdTypeMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_AdTypeMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(AdTypeMetrics.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getAdTypeValue() {
                return this.adType_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public AdType getAdType() {
                AdType valueOf = AdType.valueOf(this.adType_);
                return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getImpressions() {
                return this.impressions_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getAdRequests() {
                return this.adRequests_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getBids() {
                return this.bids_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getWins() {
                return this.wins_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getLosses() {
                return this.losses_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getLurls() {
                return this.lurls_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getNurls() {
                return this.nurls_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public float getCumulativeBidPrice() {
                return this.cumulativeBidPrice_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public float getCumulativeLurlPrice() {
                return this.cumulativeLurlPrice_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public float getCumulativeNurlPrice() {
                return this.cumulativeNurlPrice_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public boolean hasEcpm() {
                return this.ecpm_ != null;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public Ecpm getEcpm() {
                Ecpm ecpm = this.ecpm_;
                return ecpm == null ? Ecpm.getDefaultInstance() : ecpm;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public EcpmOrBuilder getEcpmOrBuilder() {
                return getEcpm();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public List<Auction> getAuctionsList() {
                return this.auctions_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public List<? extends AuctionOrBuilder> getAuctionsOrBuilderList() {
                return this.auctions_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public int getAuctionsCount() {
                return this.auctions_.size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public Auction getAuctions(int i) {
                return this.auctions_.get(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
            public AuctionOrBuilder getAuctionsOrBuilder(int i) {
                return this.auctions_.get(i);
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
                if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                    codedOutputStream.writeEnum(1, this.adType_);
                }
                int i = this.impressions_;
                if (i != 0) {
                    codedOutputStream.writeInt32(2, i);
                }
                int i2 = this.adRequests_;
                if (i2 != 0) {
                    codedOutputStream.writeInt32(3, i2);
                }
                int i3 = this.bids_;
                if (i3 != 0) {
                    codedOutputStream.writeInt32(4, i3);
                }
                int i4 = this.wins_;
                if (i4 != 0) {
                    codedOutputStream.writeInt32(5, i4);
                }
                int i5 = this.losses_;
                if (i5 != 0) {
                    codedOutputStream.writeInt32(6, i5);
                }
                int i6 = this.lurls_;
                if (i6 != 0) {
                    codedOutputStream.writeInt32(7, i6);
                }
                int i7 = this.nurls_;
                if (i7 != 0) {
                    codedOutputStream.writeInt32(8, i7);
                }
                float f = this.cumulativeBidPrice_;
                if (f != 0.0f) {
                    codedOutputStream.writeFloat(9, f);
                }
                float f2 = this.cumulativeLurlPrice_;
                if (f2 != 0.0f) {
                    codedOutputStream.writeFloat(10, f2);
                }
                float f3 = this.cumulativeNurlPrice_;
                if (f3 != 0.0f) {
                    codedOutputStream.writeFloat(11, f3);
                }
                if (this.ecpm_ != null) {
                    codedOutputStream.writeMessage(12, getEcpm());
                }
                for (int i8 = 0; i8 < this.auctions_.size(); i8++) {
                    codedOutputStream.writeMessage(13, this.auctions_.get(i8));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int computeEnumSize = this.adType_ != AdType.UNKNOWN.getNumber() ? CodedOutputStream.computeEnumSize(1, this.adType_) : 0;
                int i2 = this.impressions_;
                if (i2 != 0) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(2, i2);
                }
                int i3 = this.adRequests_;
                if (i3 != 0) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(3, i3);
                }
                int i4 = this.bids_;
                if (i4 != 0) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(4, i4);
                }
                int i5 = this.wins_;
                if (i5 != 0) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, i5);
                }
                int i6 = this.losses_;
                if (i6 != 0) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, i6);
                }
                int i7 = this.lurls_;
                if (i7 != 0) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, i7);
                }
                int i8 = this.nurls_;
                if (i8 != 0) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(8, i8);
                }
                float f = this.cumulativeBidPrice_;
                if (f != 0.0f) {
                    computeEnumSize += CodedOutputStream.computeFloatSize(9, f);
                }
                float f2 = this.cumulativeLurlPrice_;
                if (f2 != 0.0f) {
                    computeEnumSize += CodedOutputStream.computeFloatSize(10, f2);
                }
                float f3 = this.cumulativeNurlPrice_;
                if (f3 != 0.0f) {
                    computeEnumSize += CodedOutputStream.computeFloatSize(11, f3);
                }
                if (this.ecpm_ != null) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(12, getEcpm());
                }
                for (int i9 = 0; i9 < this.auctions_.size(); i9++) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(13, this.auctions_.get(i9));
                }
                int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof AdTypeMetrics)) {
                    return super.equals(obj);
                }
                AdTypeMetrics adTypeMetrics = (AdTypeMetrics) obj;
                if (this.adType_ == adTypeMetrics.adType_ && getImpressions() == adTypeMetrics.getImpressions() && getAdRequests() == adTypeMetrics.getAdRequests() && getBids() == adTypeMetrics.getBids() && getWins() == adTypeMetrics.getWins() && getLosses() == adTypeMetrics.getLosses() && getLurls() == adTypeMetrics.getLurls() && getNurls() == adTypeMetrics.getNurls() && Float.floatToIntBits(getCumulativeBidPrice()) == Float.floatToIntBits(adTypeMetrics.getCumulativeBidPrice()) && Float.floatToIntBits(getCumulativeLurlPrice()) == Float.floatToIntBits(adTypeMetrics.getCumulativeLurlPrice()) && Float.floatToIntBits(getCumulativeNurlPrice()) == Float.floatToIntBits(adTypeMetrics.getCumulativeNurlPrice()) && hasEcpm() == adTypeMetrics.hasEcpm()) {
                    return (!hasEcpm() || getEcpm().equals(adTypeMetrics.getEcpm())) && getAuctionsList().equals(adTypeMetrics.getAuctionsList()) && this.unknownFields.equals(adTypeMetrics.unknownFields);
                }
                return false;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.adType_) * 37) + 2) * 53) + getImpressions()) * 37) + 3) * 53) + getAdRequests()) * 37) + 4) * 53) + getBids()) * 37) + 5) * 53) + getWins()) * 37) + 6) * 53) + getLosses()) * 37) + 7) * 53) + getLurls()) * 37) + 8) * 53) + getNurls()) * 37) + 9) * 53) + Float.floatToIntBits(getCumulativeBidPrice())) * 37) + 10) * 53) + Float.floatToIntBits(getCumulativeLurlPrice())) * 37) + 11) * 53) + Float.floatToIntBits(getCumulativeNurlPrice());
                if (hasEcpm()) {
                    hashCode = (((hashCode * 37) + 12) * 53) + getEcpm().hashCode();
                }
                if (getAuctionsCount() > 0) {
                    hashCode = (((hashCode * 37) + 13) * 53) + getAuctionsList().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static AdTypeMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static AdTypeMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static AdTypeMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static AdTypeMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static AdTypeMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static AdTypeMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static AdTypeMetrics parseFrom(InputStream inputStream) throws IOException {
                return (AdTypeMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static AdTypeMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdTypeMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static AdTypeMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (AdTypeMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static AdTypeMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdTypeMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static AdTypeMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (AdTypeMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static AdTypeMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (AdTypeMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(AdTypeMetrics adTypeMetrics) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(adTypeMetrics);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdTypeMetricsOrBuilder {
                private int adRequests_;
                private int adType_;
                private RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> auctionsBuilder_;
                private List<Auction> auctions_;
                private int bids_;
                private int bitField0_;
                private float cumulativeBidPrice_;
                private float cumulativeLurlPrice_;
                private float cumulativeNurlPrice_;
                private SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> ecpmBuilder_;
                private Ecpm ecpm_;
                private int impressions_;
                private int losses_;
                private int lurls_;
                private int nurls_;
                private int wins_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_AdTypeMetrics_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_AdTypeMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(AdTypeMetrics.class, Builder.class);
                }

                private Builder() {
                    this.adType_ = 0;
                    this.auctions_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.adType_ = 0;
                    this.auctions_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (AdTypeMetrics.alwaysUseFieldBuilders) {
                        getAuctionsFieldBuilder();
                    }
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.adType_ = 0;
                    this.impressions_ = 0;
                    this.adRequests_ = 0;
                    this.bids_ = 0;
                    this.wins_ = 0;
                    this.losses_ = 0;
                    this.lurls_ = 0;
                    this.nurls_ = 0;
                    this.cumulativeBidPrice_ = 0.0f;
                    this.cumulativeLurlPrice_ = 0.0f;
                    this.cumulativeNurlPrice_ = 0.0f;
                    if (this.ecpmBuilder_ == null) {
                        this.ecpm_ = null;
                    } else {
                        this.ecpm_ = null;
                        this.ecpmBuilder_ = null;
                    }
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.auctions_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_AdTypeMetrics_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public AdTypeMetrics getDefaultInstanceForType() {
                    return AdTypeMetrics.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public AdTypeMetrics build() {
                    AdTypeMetrics buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public AdTypeMetrics buildPartial() {
                    AdTypeMetrics adTypeMetrics = new AdTypeMetrics(this);
                    adTypeMetrics.adType_ = this.adType_;
                    adTypeMetrics.impressions_ = this.impressions_;
                    adTypeMetrics.adRequests_ = this.adRequests_;
                    adTypeMetrics.bids_ = this.bids_;
                    adTypeMetrics.wins_ = this.wins_;
                    adTypeMetrics.losses_ = this.losses_;
                    adTypeMetrics.lurls_ = this.lurls_;
                    adTypeMetrics.nurls_ = this.nurls_;
                    adTypeMetrics.cumulativeBidPrice_ = this.cumulativeBidPrice_;
                    adTypeMetrics.cumulativeLurlPrice_ = this.cumulativeLurlPrice_;
                    adTypeMetrics.cumulativeNurlPrice_ = this.cumulativeNurlPrice_;
                    SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> singleFieldBuilderV3 = this.ecpmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        adTypeMetrics.ecpm_ = this.ecpm_;
                    } else {
                        adTypeMetrics.ecpm_ = singleFieldBuilderV3.build();
                    }
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        adTypeMetrics.auctions_ = repeatedFieldBuilderV3.build();
                    } else {
                        if ((this.bitField0_ & 1) != 0) {
                            this.auctions_ = Collections.unmodifiableList(this.auctions_);
                            this.bitField0_ &= -2;
                        }
                        adTypeMetrics.auctions_ = this.auctions_;
                    }
                    onBuilt();
                    return adTypeMetrics;
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
                    if (message instanceof AdTypeMetrics) {
                        return mergeFrom((AdTypeMetrics) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(AdTypeMetrics adTypeMetrics) {
                    if (adTypeMetrics == AdTypeMetrics.getDefaultInstance()) {
                        return this;
                    }
                    if (adTypeMetrics.adType_ != 0) {
                        setAdTypeValue(adTypeMetrics.getAdTypeValue());
                    }
                    if (adTypeMetrics.getImpressions() != 0) {
                        setImpressions(adTypeMetrics.getImpressions());
                    }
                    if (adTypeMetrics.getAdRequests() != 0) {
                        setAdRequests(adTypeMetrics.getAdRequests());
                    }
                    if (adTypeMetrics.getBids() != 0) {
                        setBids(adTypeMetrics.getBids());
                    }
                    if (adTypeMetrics.getWins() != 0) {
                        setWins(adTypeMetrics.getWins());
                    }
                    if (adTypeMetrics.getLosses() != 0) {
                        setLosses(adTypeMetrics.getLosses());
                    }
                    if (adTypeMetrics.getLurls() != 0) {
                        setLurls(adTypeMetrics.getLurls());
                    }
                    if (adTypeMetrics.getNurls() != 0) {
                        setNurls(adTypeMetrics.getNurls());
                    }
                    if (adTypeMetrics.getCumulativeBidPrice() != 0.0f) {
                        setCumulativeBidPrice(adTypeMetrics.getCumulativeBidPrice());
                    }
                    if (adTypeMetrics.getCumulativeLurlPrice() != 0.0f) {
                        setCumulativeLurlPrice(adTypeMetrics.getCumulativeLurlPrice());
                    }
                    if (adTypeMetrics.getCumulativeNurlPrice() != 0.0f) {
                        setCumulativeNurlPrice(adTypeMetrics.getCumulativeNurlPrice());
                    }
                    if (adTypeMetrics.hasEcpm()) {
                        mergeEcpm(adTypeMetrics.getEcpm());
                    }
                    if (this.auctionsBuilder_ == null) {
                        if (!adTypeMetrics.auctions_.isEmpty()) {
                            if (this.auctions_.isEmpty()) {
                                this.auctions_ = adTypeMetrics.auctions_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureAuctionsIsMutable();
                                this.auctions_.addAll(adTypeMetrics.auctions_);
                            }
                            onChanged();
                        }
                    } else if (!adTypeMetrics.auctions_.isEmpty()) {
                        if (!this.auctionsBuilder_.isEmpty()) {
                            this.auctionsBuilder_.addAllMessages(adTypeMetrics.auctions_);
                        } else {
                            this.auctionsBuilder_.dispose();
                            this.auctionsBuilder_ = null;
                            this.auctions_ = adTypeMetrics.auctions_;
                            this.bitField0_ &= -2;
                            this.auctionsBuilder_ = AdTypeMetrics.alwaysUseFieldBuilders ? getAuctionsFieldBuilder() : null;
                        }
                    }
                    mergeUnknownFields(adTypeMetrics.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    AdTypeMetrics adTypeMetrics = null;
                    try {
                        try {
                            AdTypeMetrics adTypeMetrics2 = (AdTypeMetrics) AdTypeMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (adTypeMetrics2 != null) {
                                mergeFrom(adTypeMetrics2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            AdTypeMetrics adTypeMetrics3 = (AdTypeMetrics) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                adTypeMetrics = adTypeMetrics3;
                                if (adTypeMetrics != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (adTypeMetrics != null) {
                            mergeFrom(adTypeMetrics);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getAdTypeValue() {
                    return this.adType_;
                }

                public Builder setAdTypeValue(int i) {
                    this.adType_ = i;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public AdType getAdType() {
                    AdType valueOf = AdType.valueOf(this.adType_);
                    return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
                }

                public Builder setAdType(AdType adType) {
                    adType.getClass();
                    this.adType_ = adType.getNumber();
                    onChanged();
                    return this;
                }

                public Builder clearAdType() {
                    this.adType_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getImpressions() {
                    return this.impressions_;
                }

                public Builder setImpressions(int i) {
                    this.impressions_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearImpressions() {
                    this.impressions_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getAdRequests() {
                    return this.adRequests_;
                }

                public Builder setAdRequests(int i) {
                    this.adRequests_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearAdRequests() {
                    this.adRequests_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getBids() {
                    return this.bids_;
                }

                public Builder setBids(int i) {
                    this.bids_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearBids() {
                    this.bids_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getWins() {
                    return this.wins_;
                }

                public Builder setWins(int i) {
                    this.wins_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearWins() {
                    this.wins_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getLosses() {
                    return this.losses_;
                }

                public Builder setLosses(int i) {
                    this.losses_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearLosses() {
                    this.losses_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getLurls() {
                    return this.lurls_;
                }

                public Builder setLurls(int i) {
                    this.lurls_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearLurls() {
                    this.lurls_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getNurls() {
                    return this.nurls_;
                }

                public Builder setNurls(int i) {
                    this.nurls_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearNurls() {
                    this.nurls_ = 0;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public float getCumulativeBidPrice() {
                    return this.cumulativeBidPrice_;
                }

                public Builder setCumulativeBidPrice(float f) {
                    this.cumulativeBidPrice_ = f;
                    onChanged();
                    return this;
                }

                public Builder clearCumulativeBidPrice() {
                    this.cumulativeBidPrice_ = 0.0f;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public float getCumulativeLurlPrice() {
                    return this.cumulativeLurlPrice_;
                }

                public Builder setCumulativeLurlPrice(float f) {
                    this.cumulativeLurlPrice_ = f;
                    onChanged();
                    return this;
                }

                public Builder clearCumulativeLurlPrice() {
                    this.cumulativeLurlPrice_ = 0.0f;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public float getCumulativeNurlPrice() {
                    return this.cumulativeNurlPrice_;
                }

                public Builder setCumulativeNurlPrice(float f) {
                    this.cumulativeNurlPrice_ = f;
                    onChanged();
                    return this;
                }

                public Builder clearCumulativeNurlPrice() {
                    this.cumulativeNurlPrice_ = 0.0f;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public boolean hasEcpm() {
                    return (this.ecpmBuilder_ == null && this.ecpm_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public Ecpm getEcpm() {
                    SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> singleFieldBuilderV3 = this.ecpmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Ecpm ecpm = this.ecpm_;
                        return ecpm == null ? Ecpm.getDefaultInstance() : ecpm;
                    }
                    return singleFieldBuilderV3.getMessage();
                }

                public Builder setEcpm(Ecpm ecpm) {
                    SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> singleFieldBuilderV3 = this.ecpmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        ecpm.getClass();
                        this.ecpm_ = ecpm;
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(ecpm);
                    return this;
                }

                public Builder setEcpm(Ecpm.Builder builder) {
                    SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> singleFieldBuilderV3 = this.ecpmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.ecpm_ = builder.build();
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }

                public Builder mergeEcpm(Ecpm ecpm) {
                    SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> singleFieldBuilderV3 = this.ecpmBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        Ecpm ecpm2 = this.ecpm_;
                        if (ecpm2 != null) {
                            this.ecpm_ = Ecpm.newBuilder(ecpm2).mergeFrom(ecpm).buildPartial();
                        } else {
                            this.ecpm_ = ecpm;
                        }
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.mergeFrom(ecpm);
                    return this;
                }

                public Builder clearEcpm() {
                    if (this.ecpmBuilder_ == null) {
                        this.ecpm_ = null;
                        onChanged();
                        return this;
                    }
                    this.ecpm_ = null;
                    this.ecpmBuilder_ = null;
                    return this;
                }

                public Ecpm.Builder getEcpmBuilder() {
                    onChanged();
                    return getEcpmFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public EcpmOrBuilder getEcpmOrBuilder() {
                    SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> singleFieldBuilderV3 = this.ecpmBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    Ecpm ecpm = this.ecpm_;
                    return ecpm == null ? Ecpm.getDefaultInstance() : ecpm;
                }

                private SingleFieldBuilderV3<Ecpm, Ecpm.Builder, EcpmOrBuilder> getEcpmFieldBuilder() {
                    if (this.ecpmBuilder_ == null) {
                        this.ecpmBuilder_ = new SingleFieldBuilderV3<>(getEcpm(), getParentForChildren(), isClean());
                        this.ecpm_ = null;
                    }
                    return this.ecpmBuilder_;
                }

                private void ensureAuctionsIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.auctions_ = new ArrayList(this.auctions_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public List<Auction> getAuctionsList() {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return Collections.unmodifiableList(this.auctions_);
                    }
                    return repeatedFieldBuilderV3.getMessageList();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public int getAuctionsCount() {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.auctions_.size();
                    }
                    return repeatedFieldBuilderV3.getCount();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public Auction getAuctions(int i) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.auctions_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessage(i);
                }

                public Builder setAuctions(int i, Auction auction) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        auction.getClass();
                        ensureAuctionsIsMutable();
                        this.auctions_.set(i, auction);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, auction);
                    return this;
                }

                public Builder setAuctions(int i, Auction.Builder builder) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAuctionsIsMutable();
                        this.auctions_.set(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }

                public Builder addAuctions(Auction auction) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        auction.getClass();
                        ensureAuctionsIsMutable();
                        this.auctions_.add(auction);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(auction);
                    return this;
                }

                public Builder addAuctions(int i, Auction auction) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        auction.getClass();
                        ensureAuctionsIsMutable();
                        this.auctions_.add(i, auction);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, auction);
                    return this;
                }

                public Builder addAuctions(Auction.Builder builder) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAuctionsIsMutable();
                        this.auctions_.add(builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }

                public Builder addAuctions(int i, Auction.Builder builder) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAuctionsIsMutable();
                        this.auctions_.add(i, builder.build());
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }

                public Builder addAllAuctions(Iterable<? extends Auction> iterable) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAuctionsIsMutable();
                        AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.auctions_);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }

                public Builder clearAuctions() {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        this.auctions_ = Collections.emptyList();
                        this.bitField0_ &= -2;
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.clear();
                    return this;
                }

                public Builder removeAuctions(int i) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        ensureAuctionsIsMutable();
                        this.auctions_.remove(i);
                        onChanged();
                        return this;
                    }
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }

                public Auction.Builder getAuctionsBuilder(int i) {
                    return getAuctionsFieldBuilder().getBuilder(i);
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public AuctionOrBuilder getAuctionsOrBuilder(int i) {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 == null) {
                        return this.auctions_.get(i);
                    }
                    return repeatedFieldBuilderV3.getMessageOrBuilder(i);
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSession.AdTypeMetricsOrBuilder
                public List<? extends AuctionOrBuilder> getAuctionsOrBuilderList() {
                    RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> repeatedFieldBuilderV3 = this.auctionsBuilder_;
                    if (repeatedFieldBuilderV3 != null) {
                        return repeatedFieldBuilderV3.getMessageOrBuilderList();
                    }
                    return Collections.unmodifiableList(this.auctions_);
                }

                public Auction.Builder addAuctionsBuilder() {
                    return getAuctionsFieldBuilder().addBuilder(Auction.getDefaultInstance());
                }

                public Auction.Builder addAuctionsBuilder(int i) {
                    return getAuctionsFieldBuilder().addBuilder(i, Auction.getDefaultInstance());
                }

                public List<Auction.Builder> getAuctionsBuilderList() {
                    return getAuctionsFieldBuilder().getBuilderList();
                }

                private RepeatedFieldBuilderV3<Auction, Auction.Builder, AuctionOrBuilder> getAuctionsFieldBuilder() {
                    if (this.auctionsBuilder_ == null) {
                        this.auctionsBuilder_ = new RepeatedFieldBuilderV3<>(this.auctions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                        this.auctions_ = null;
                    }
                    return this.auctionsBuilder_;
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

            public static AdTypeMetrics getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AdTypeMetrics> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<AdTypeMetrics> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AdTypeMetrics getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
        public long getLastActivity() {
            return this.lastActivity_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
        public List<AdTypeMetrics> getMetricsByAdTypeList() {
            return this.metricsByAdType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
        public List<? extends AdTypeMetricsOrBuilder> getMetricsByAdTypeOrBuilderList() {
            return this.metricsByAdType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
        public int getMetricsByAdTypeCount() {
            return this.metricsByAdType_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
        public AdTypeMetrics getMetricsByAdType(int i) {
            return this.metricsByAdType_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
        public AdTypeMetricsOrBuilder getMetricsByAdTypeOrBuilder(int i) {
            return this.metricsByAdType_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
        public long getSessionStart() {
            return this.sessionStart_;
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
            long j = this.lastActivity_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            for (int i = 0; i < this.metricsByAdType_.size(); i++) {
                codedOutputStream.writeMessage(3, this.metricsByAdType_.get(i));
            }
            long j2 = this.sessionStart_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(4, j2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.lastActivity_;
            int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
            for (int i2 = 0; i2 < this.metricsByAdType_.size(); i2++) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, this.metricsByAdType_.get(i2));
            }
            long j2 = this.sessionStart_;
            if (j2 != 0) {
                computeInt64Size += CodedOutputStream.computeInt64Size(4, j2);
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserSession)) {
                return super.equals(obj);
            }
            UserSession userSession = (UserSession) obj;
            return getLastActivity() == userSession.getLastActivity() && getMetricsByAdTypeList().equals(userSession.getMetricsByAdTypeList()) && getSessionStart() == userSession.getSessionStart() && this.unknownFields.equals(userSession.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getLastActivity());
            if (getMetricsByAdTypeCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getMetricsByAdTypeList().hashCode();
            }
            int hashLong = (((((hashCode * 37) + 4) * 53) + Internal.hashLong(getSessionStart())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        public static UserSession parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static UserSession parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static UserSession parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserSession parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserSession parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserSession parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserSession parseFrom(InputStream inputStream) throws IOException {
            return (UserSession) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserSession parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserSession) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserSession parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserSession) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserSession parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserSession) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserSession parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserSession) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserSession parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserSession) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserSession userSession) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userSession);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserSessionOrBuilder {
            private int bitField0_;
            private long lastActivity_;
            private RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> metricsByAdTypeBuilder_;
            private List<AdTypeMetrics> metricsByAdType_;
            private long sessionStart_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_fieldAccessorTable.ensureFieldAccessorsInitialized(UserSession.class, Builder.class);
            }

            private Builder() {
                this.metricsByAdType_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.metricsByAdType_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UserSession.alwaysUseFieldBuilders) {
                    getMetricsByAdTypeFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.lastActivity_ = 0L;
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.metricsByAdType_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.sessionStart_ = 0L;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserSession_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public UserSession getDefaultInstanceForType() {
                return UserSession.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserSession build() {
                UserSession buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserSession buildPartial() {
                UserSession userSession = new UserSession(this);
                userSession.lastActivity_ = this.lastActivity_;
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    userSession.metricsByAdType_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 1) != 0) {
                        this.metricsByAdType_ = Collections.unmodifiableList(this.metricsByAdType_);
                        this.bitField0_ &= -2;
                    }
                    userSession.metricsByAdType_ = this.metricsByAdType_;
                }
                userSession.sessionStart_ = this.sessionStart_;
                onBuilt();
                return userSession;
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
                if (message instanceof UserSession) {
                    return mergeFrom((UserSession) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(UserSession userSession) {
                if (userSession == UserSession.getDefaultInstance()) {
                    return this;
                }
                if (userSession.getLastActivity() != 0) {
                    setLastActivity(userSession.getLastActivity());
                }
                if (this.metricsByAdTypeBuilder_ == null) {
                    if (!userSession.metricsByAdType_.isEmpty()) {
                        if (this.metricsByAdType_.isEmpty()) {
                            this.metricsByAdType_ = userSession.metricsByAdType_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMetricsByAdTypeIsMutable();
                            this.metricsByAdType_.addAll(userSession.metricsByAdType_);
                        }
                        onChanged();
                    }
                } else if (!userSession.metricsByAdType_.isEmpty()) {
                    if (!this.metricsByAdTypeBuilder_.isEmpty()) {
                        this.metricsByAdTypeBuilder_.addAllMessages(userSession.metricsByAdType_);
                    } else {
                        this.metricsByAdTypeBuilder_.dispose();
                        this.metricsByAdTypeBuilder_ = null;
                        this.metricsByAdType_ = userSession.metricsByAdType_;
                        this.bitField0_ &= -2;
                        this.metricsByAdTypeBuilder_ = UserSession.alwaysUseFieldBuilders ? getMetricsByAdTypeFieldBuilder() : null;
                    }
                }
                if (userSession.getSessionStart() != 0) {
                    setSessionStart(userSession.getSessionStart());
                }
                mergeUnknownFields(userSession.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                UserSession userSession = null;
                try {
                    try {
                        UserSession userSession2 = (UserSession) UserSession.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (userSession2 != null) {
                            mergeFrom(userSession2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        UserSession userSession3 = (UserSession) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            userSession = userSession3;
                            if (userSession != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (userSession != null) {
                        mergeFrom(userSession);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
            public long getLastActivity() {
                return this.lastActivity_;
            }

            public Builder setLastActivity(long j) {
                this.lastActivity_ = j;
                onChanged();
                return this;
            }

            public Builder clearLastActivity() {
                this.lastActivity_ = 0L;
                onChanged();
                return this;
            }

            private void ensureMetricsByAdTypeIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.metricsByAdType_ = new ArrayList(this.metricsByAdType_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
            public List<AdTypeMetrics> getMetricsByAdTypeList() {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.metricsByAdType_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
            public int getMetricsByAdTypeCount() {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.metricsByAdType_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
            public AdTypeMetrics getMetricsByAdType(int i) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.metricsByAdType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setMetricsByAdType(int i, AdTypeMetrics adTypeMetrics) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adTypeMetrics.getClass();
                    ensureMetricsByAdTypeIsMutable();
                    this.metricsByAdType_.set(i, adTypeMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, adTypeMetrics);
                return this;
            }

            public Builder setMetricsByAdType(int i, AdTypeMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMetricsByAdTypeIsMutable();
                    this.metricsByAdType_.set(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }

            public Builder addMetricsByAdType(AdTypeMetrics adTypeMetrics) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adTypeMetrics.getClass();
                    ensureMetricsByAdTypeIsMutable();
                    this.metricsByAdType_.add(adTypeMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(adTypeMetrics);
                return this;
            }

            public Builder addMetricsByAdType(int i, AdTypeMetrics adTypeMetrics) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adTypeMetrics.getClass();
                    ensureMetricsByAdTypeIsMutable();
                    this.metricsByAdType_.add(i, adTypeMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, adTypeMetrics);
                return this;
            }

            public Builder addMetricsByAdType(AdTypeMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMetricsByAdTypeIsMutable();
                    this.metricsByAdType_.add(builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }

            public Builder addMetricsByAdType(int i, AdTypeMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMetricsByAdTypeIsMutable();
                    this.metricsByAdType_.add(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }

            public Builder addAllMetricsByAdType(Iterable<? extends AdTypeMetrics> iterable) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMetricsByAdTypeIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.metricsByAdType_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }

            public Builder clearMetricsByAdType() {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.metricsByAdType_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            public Builder removeMetricsByAdType(int i) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureMetricsByAdTypeIsMutable();
                    this.metricsByAdType_.remove(i);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.remove(i);
                return this;
            }

            public AdTypeMetrics.Builder getMetricsByAdTypeBuilder(int i) {
                return getMetricsByAdTypeFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
            public AdTypeMetricsOrBuilder getMetricsByAdTypeOrBuilder(int i) {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.metricsByAdType_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
            public List<? extends AdTypeMetricsOrBuilder> getMetricsByAdTypeOrBuilderList() {
                RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> repeatedFieldBuilderV3 = this.metricsByAdTypeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.metricsByAdType_);
            }

            public AdTypeMetrics.Builder addMetricsByAdTypeBuilder() {
                return getMetricsByAdTypeFieldBuilder().addBuilder(AdTypeMetrics.getDefaultInstance());
            }

            public AdTypeMetrics.Builder addMetricsByAdTypeBuilder(int i) {
                return getMetricsByAdTypeFieldBuilder().addBuilder(i, AdTypeMetrics.getDefaultInstance());
            }

            public List<AdTypeMetrics.Builder> getMetricsByAdTypeBuilderList() {
                return getMetricsByAdTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AdTypeMetrics, AdTypeMetrics.Builder, AdTypeMetricsOrBuilder> getMetricsByAdTypeFieldBuilder() {
                if (this.metricsByAdTypeBuilder_ == null) {
                    this.metricsByAdTypeBuilder_ = new RepeatedFieldBuilderV3<>(this.metricsByAdType_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.metricsByAdType_ = null;
                }
                return this.metricsByAdTypeBuilder_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserSessionOrBuilder
            public long getSessionStart() {
                return this.sessionStart_;
            }

            public Builder setSessionStart(long j) {
                this.sessionStart_ = j;
                onChanged();
                return this;
            }

            public Builder clearSessionStart() {
                this.sessionStart_ = 0L;
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

        public static UserSession getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserSession> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<UserSession> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public UserSession getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class Timestamps extends GeneratedMessageV3 implements TimestampsOrBuilder {
        public static final int DAY_BUCKETS_FIELD_NUMBER = 3;
        public static final int DELTAS_FIELD_NUMBER = 2;
        public static final int LAST_TIMESTAMP_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<DayBucket> dayBuckets_;
        private int deltasMemoizedSerializedSize;
        private Internal.IntList deltas_;
        private long lastTimestamp_;
        private byte memoizedIsInitialized;
        private static final Timestamps DEFAULT_INSTANCE = new Timestamps();
        private static final Parser<Timestamps> PARSER = new AbstractParser<Timestamps>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.Timestamps.1
            @Override // com.explorestack.protobuf.Parser
            public Timestamps parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Timestamps(codedInputStream, extensionRegistryLite);
            }
        };

        public interface DayBucketOrBuilder extends MessageOrBuilder {
            int getCount();

            long getStartTime();
        }

        private Timestamps(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.deltasMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private Timestamps() {
            this.deltasMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.deltas_ = emptyIntList();
            this.dayBuckets_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Timestamps();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Timestamps(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            extensionRegistryLite.getClass();
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.lastTimestamp_ = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                if ((i & 1) == 0) {
                                    this.deltas_ = newIntList();
                                    i |= 1;
                                }
                                this.deltas_.addInt(codedInputStream.readUInt32());
                            } else if (readTag == 18) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i & 1) == 0 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.deltas_ = newIntList();
                                    i |= 1;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.deltas_.addInt(codedInputStream.readUInt32());
                                }
                                codedInputStream.popLimit(pushLimit);
                            } else if (readTag == 26) {
                                if ((i & 2) == 0) {
                                    this.dayBuckets_ = new ArrayList();
                                    i |= 2;
                                }
                                this.dayBuckets_.add(codedInputStream.readMessage(DayBucket.parser(), extensionRegistryLite));
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
                    if ((i & 1) != 0) {
                        this.deltas_.makeImmutable();
                    }
                    if ((i & 2) != 0) {
                        this.dayBuckets_ = Collections.unmodifiableList(this.dayBuckets_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamps.class, Builder.class);
        }

        public static final class DayBucket extends GeneratedMessageV3 implements DayBucketOrBuilder {
            public static final int COUNT_FIELD_NUMBER = 2;
            private static final DayBucket DEFAULT_INSTANCE = new DayBucket();
            private static final Parser<DayBucket> PARSER = new AbstractParser<DayBucket>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.Timestamps.DayBucket.1
                @Override // com.explorestack.protobuf.Parser
                public DayBucket parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new DayBucket(codedInputStream, extensionRegistryLite);
                }
            };
            public static final int START_TIME_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int count_;
            private byte memoizedIsInitialized;
            private long startTime_;

            private DayBucket(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private DayBucket() {
                this.memoizedIsInitialized = (byte) -1;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new DayBucket();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private DayBucket(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if (readTag == 8) {
                                        this.startTime_ = codedInputStream.readInt64();
                                    } else if (readTag == 16) {
                                        this.count_ = codedInputStream.readInt32();
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
                return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable.ensureFieldAccessorsInitialized(DayBucket.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.Timestamps.DayBucketOrBuilder
            public long getStartTime() {
                return this.startTime_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.Timestamps.DayBucketOrBuilder
            public int getCount() {
                return this.count_;
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
                long j = this.startTime_;
                if (j != 0) {
                    codedOutputStream.writeInt64(1, j);
                }
                int i = this.count_;
                if (i != 0) {
                    codedOutputStream.writeInt32(2, i);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                long j = this.startTime_;
                int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
                int i2 = this.count_;
                if (i2 != 0) {
                    computeInt64Size += CodedOutputStream.computeInt32Size(2, i2);
                }
                int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DayBucket)) {
                    return super.equals(obj);
                }
                DayBucket dayBucket = (DayBucket) obj;
                return getStartTime() == dayBucket.getStartTime() && getCount() == dayBucket.getCount() && this.unknownFields.equals(dayBucket.unknownFields);
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getStartTime())) * 37) + 2) * 53) + getCount()) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode;
                return hashCode;
            }

            public static DayBucket parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static DayBucket parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static DayBucket parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static DayBucket parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static DayBucket parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static DayBucket parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static DayBucket parseFrom(InputStream inputStream) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static DayBucket parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DayBucket parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static DayBucket parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DayBucket parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static DayBucket parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DayBucket) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(DayBucket dayBucket) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(dayBucket);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DayBucketOrBuilder {
                private int count_;
                private long startTime_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable.ensureFieldAccessorsInitialized(DayBucket.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = DayBucket.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.startTime_ = 0L;
                    this.count_ = 0;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_DayBucket_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public DayBucket getDefaultInstanceForType() {
                    return DayBucket.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DayBucket build() {
                    DayBucket buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DayBucket buildPartial() {
                    DayBucket dayBucket = new DayBucket(this);
                    dayBucket.startTime_ = this.startTime_;
                    dayBucket.count_ = this.count_;
                    onBuilt();
                    return dayBucket;
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
                    if (message instanceof DayBucket) {
                        return mergeFrom((DayBucket) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(DayBucket dayBucket) {
                    if (dayBucket == DayBucket.getDefaultInstance()) {
                        return this;
                    }
                    if (dayBucket.getStartTime() != 0) {
                        setStartTime(dayBucket.getStartTime());
                    }
                    if (dayBucket.getCount() != 0) {
                        setCount(dayBucket.getCount());
                    }
                    mergeUnknownFields(dayBucket.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    DayBucket dayBucket = null;
                    try {
                        try {
                            DayBucket dayBucket2 = (DayBucket) DayBucket.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (dayBucket2 != null) {
                                mergeFrom(dayBucket2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            DayBucket dayBucket3 = (DayBucket) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                dayBucket = dayBucket3;
                                if (dayBucket != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (dayBucket != null) {
                            mergeFrom(dayBucket);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.Timestamps.DayBucketOrBuilder
                public long getStartTime() {
                    return this.startTime_;
                }

                public Builder setStartTime(long j) {
                    this.startTime_ = j;
                    onChanged();
                    return this;
                }

                public Builder clearStartTime() {
                    this.startTime_ = 0L;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.Timestamps.DayBucketOrBuilder
                public int getCount() {
                    return this.count_;
                }

                public Builder setCount(int i) {
                    this.count_ = i;
                    onChanged();
                    return this;
                }

                public Builder clearCount() {
                    this.count_ = 0;
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

            public static DayBucket getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DayBucket> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<DayBucket> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public DayBucket getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public long getLastTimestamp() {
            return this.lastTimestamp_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public List<Integer> getDeltasList() {
            return this.deltas_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public int getDeltasCount() {
            return this.deltas_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public int getDeltas(int i) {
            return this.deltas_.getInt(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public List<DayBucket> getDayBucketsList() {
            return this.dayBuckets_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public List<? extends DayBucketOrBuilder> getDayBucketsOrBuilderList() {
            return this.dayBuckets_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public int getDayBucketsCount() {
            return this.dayBuckets_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public DayBucket getDayBuckets(int i) {
            return this.dayBuckets_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
        public DayBucketOrBuilder getDayBucketsOrBuilder(int i) {
            return this.dayBuckets_.get(i);
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
            getSerializedSize();
            long j = this.lastTimestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            if (getDeltasList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(18);
                codedOutputStream.writeUInt32NoTag(this.deltasMemoizedSerializedSize);
            }
            for (int i = 0; i < this.deltas_.size(); i++) {
                codedOutputStream.writeUInt32NoTag(this.deltas_.getInt(i));
            }
            for (int i2 = 0; i2 < this.dayBuckets_.size(); i2++) {
                codedOutputStream.writeMessage(3, this.dayBuckets_.get(i2));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.lastTimestamp_;
            int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.deltas_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt32SizeNoTag(this.deltas_.getInt(i3));
            }
            int i4 = computeInt64Size + i2;
            if (!getDeltasList().isEmpty()) {
                i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
            }
            this.deltasMemoizedSerializedSize = i2;
            for (int i5 = 0; i5 < this.dayBuckets_.size(); i5++) {
                i4 += CodedOutputStream.computeMessageSize(3, this.dayBuckets_.get(i5));
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Timestamps)) {
                return super.equals(obj);
            }
            Timestamps timestamps = (Timestamps) obj;
            return getLastTimestamp() == timestamps.getLastTimestamp() && getDeltasList().equals(timestamps.getDeltasList()) && getDayBucketsList().equals(timestamps.getDayBucketsList()) && this.unknownFields.equals(timestamps.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getLastTimestamp());
            if (getDeltasCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getDeltasList().hashCode();
            }
            if (getDayBucketsCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getDayBucketsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static Timestamps parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Timestamps parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Timestamps parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Timestamps parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Timestamps parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Timestamps parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Timestamps parseFrom(InputStream inputStream) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Timestamps parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Timestamps parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Timestamps parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Timestamps parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Timestamps parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Timestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Timestamps timestamps) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(timestamps);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TimestampsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> dayBucketsBuilder_;
            private List<DayBucket> dayBuckets_;
            private Internal.IntList deltas_;
            private long lastTimestamp_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(Timestamps.class, Builder.class);
            }

            private Builder() {
                this.deltas_ = Timestamps.emptyIntList();
                this.dayBuckets_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.deltas_ = Timestamps.emptyIntList();
                this.dayBuckets_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Timestamps.alwaysUseFieldBuilders) {
                    getDayBucketsFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.lastTimestamp_ = 0L;
                this.deltas_ = Timestamps.emptyIntList();
                this.bitField0_ &= -2;
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.dayBuckets_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_Timestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public Timestamps getDefaultInstanceForType() {
                return Timestamps.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Timestamps build() {
                Timestamps buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Timestamps buildPartial() {
                Timestamps timestamps = new Timestamps(this);
                timestamps.lastTimestamp_ = this.lastTimestamp_;
                if ((this.bitField0_ & 1) != 0) {
                    this.deltas_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                timestamps.deltas_ = this.deltas_;
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    timestamps.dayBuckets_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 2) != 0) {
                        this.dayBuckets_ = Collections.unmodifiableList(this.dayBuckets_);
                        this.bitField0_ &= -3;
                    }
                    timestamps.dayBuckets_ = this.dayBuckets_;
                }
                onBuilt();
                return timestamps;
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
                if (message instanceof Timestamps) {
                    return mergeFrom((Timestamps) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Timestamps timestamps) {
                if (timestamps == Timestamps.getDefaultInstance()) {
                    return this;
                }
                if (timestamps.getLastTimestamp() != 0) {
                    setLastTimestamp(timestamps.getLastTimestamp());
                }
                if (!timestamps.deltas_.isEmpty()) {
                    if (this.deltas_.isEmpty()) {
                        this.deltas_ = timestamps.deltas_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDeltasIsMutable();
                        this.deltas_.addAll(timestamps.deltas_);
                    }
                    onChanged();
                }
                if (this.dayBucketsBuilder_ == null) {
                    if (!timestamps.dayBuckets_.isEmpty()) {
                        if (this.dayBuckets_.isEmpty()) {
                            this.dayBuckets_ = timestamps.dayBuckets_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDayBucketsIsMutable();
                            this.dayBuckets_.addAll(timestamps.dayBuckets_);
                        }
                        onChanged();
                    }
                } else if (!timestamps.dayBuckets_.isEmpty()) {
                    if (!this.dayBucketsBuilder_.isEmpty()) {
                        this.dayBucketsBuilder_.addAllMessages(timestamps.dayBuckets_);
                    } else {
                        this.dayBucketsBuilder_.dispose();
                        this.dayBucketsBuilder_ = null;
                        this.dayBuckets_ = timestamps.dayBuckets_;
                        this.bitField0_ &= -3;
                        this.dayBucketsBuilder_ = Timestamps.alwaysUseFieldBuilders ? getDayBucketsFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(timestamps.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                Timestamps timestamps = null;
                try {
                    try {
                        Timestamps timestamps2 = (Timestamps) Timestamps.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (timestamps2 != null) {
                            mergeFrom(timestamps2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        Timestamps timestamps3 = (Timestamps) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            timestamps = timestamps3;
                            if (timestamps != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (timestamps != null) {
                        mergeFrom(timestamps);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public long getLastTimestamp() {
                return this.lastTimestamp_;
            }

            public Builder setLastTimestamp(long j) {
                this.lastTimestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearLastTimestamp() {
                this.lastTimestamp_ = 0L;
                onChanged();
                return this;
            }

            private void ensureDeltasIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.deltas_ = Timestamps.mutableCopy(this.deltas_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public List<Integer> getDeltasList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.deltas_) : this.deltas_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public int getDeltasCount() {
                return this.deltas_.size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public int getDeltas(int i) {
                return this.deltas_.getInt(i);
            }

            public Builder setDeltas(int i, int i2) {
                ensureDeltasIsMutable();
                this.deltas_.setInt(i, i2);
                onChanged();
                return this;
            }

            public Builder addDeltas(int i) {
                ensureDeltasIsMutable();
                this.deltas_.addInt(i);
                onChanged();
                return this;
            }

            public Builder addAllDeltas(Iterable<? extends Integer> iterable) {
                ensureDeltasIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.deltas_);
                onChanged();
                return this;
            }

            public Builder clearDeltas() {
                this.deltas_ = Timestamps.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureDayBucketsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.dayBuckets_ = new ArrayList(this.dayBuckets_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public List<DayBucket> getDayBucketsList() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.dayBuckets_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public int getDayBucketsCount() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dayBuckets_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public DayBucket getDayBuckets(int i) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dayBuckets_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setDayBuckets(int i, DayBucket dayBucket) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    dayBucket.getClass();
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.set(i, dayBucket);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, dayBucket);
                return this;
            }

            public Builder setDayBuckets(int i, DayBucket.Builder builder) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.set(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }

            public Builder addDayBuckets(DayBucket dayBucket) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    dayBucket.getClass();
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(dayBucket);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(dayBucket);
                return this;
            }

            public Builder addDayBuckets(int i, DayBucket dayBucket) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    dayBucket.getClass();
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(i, dayBucket);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, dayBucket);
                return this;
            }

            public Builder addDayBuckets(DayBucket.Builder builder) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }

            public Builder addDayBuckets(int i, DayBucket.Builder builder) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.add(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }

            public Builder addAllDayBuckets(Iterable<? extends DayBucket> iterable) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.dayBuckets_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }

            public Builder clearDayBuckets() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.dayBuckets_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            public Builder removeDayBuckets(int i) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDayBucketsIsMutable();
                    this.dayBuckets_.remove(i);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.remove(i);
                return this;
            }

            public DayBucket.Builder getDayBucketsBuilder(int i) {
                return getDayBucketsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public DayBucketOrBuilder getDayBucketsOrBuilder(int i) {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.dayBuckets_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.TimestampsOrBuilder
            public List<? extends DayBucketOrBuilder> getDayBucketsOrBuilderList() {
                RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> repeatedFieldBuilderV3 = this.dayBucketsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dayBuckets_);
            }

            public DayBucket.Builder addDayBucketsBuilder() {
                return getDayBucketsFieldBuilder().addBuilder(DayBucket.getDefaultInstance());
            }

            public DayBucket.Builder addDayBucketsBuilder(int i) {
                return getDayBucketsFieldBuilder().addBuilder(i, DayBucket.getDefaultInstance());
            }

            public List<DayBucket.Builder> getDayBucketsBuilderList() {
                return getDayBucketsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DayBucket, DayBucket.Builder, DayBucketOrBuilder> getDayBucketsFieldBuilder() {
                if (this.dayBucketsBuilder_ == null) {
                    this.dayBucketsBuilder_ = new RepeatedFieldBuilderV3<>(this.dayBuckets_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.dayBuckets_ = null;
                }
                return this.dayBucketsBuilder_;
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

        public static Timestamps getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Timestamps> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<Timestamps> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public Timestamps getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AdDomainTimestamps extends GeneratedMessageV3 implements AdDomainTimestampsOrBuilder {
        public static final int AD_DOMAINS_FIELD_NUMBER = 1;
        private static final AdDomainTimestamps DEFAULT_INSTANCE = new AdDomainTimestamps();
        private static final Parser<AdDomainTimestamps> PARSER = new AbstractParser<AdDomainTimestamps>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestamps.1
            @Override // com.explorestack.protobuf.Parser
            public AdDomainTimestamps parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AdDomainTimestamps(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private MapField<String, Timestamps> adDomains_;
        private byte memoizedIsInitialized;

        private AdDomainTimestamps(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private AdDomainTimestamps() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AdDomainTimestamps();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private AdDomainTimestamps(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (!z2) {
                                    this.adDomains_ = MapField.newMapField(AdDomainsDefaultEntryHolder.defaultEntry);
                                    z2 = true;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(AdDomainsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistryLite);
                                this.adDomains_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
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
            return SessionMetricsOuterClass.internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected MapField internalGetMapField(int i) {
            if (i == 1) {
                return internalGetAdDomains();
            }
            throw new RuntimeException("Invalid map field number: " + i);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(AdDomainTimestamps.class, Builder.class);
        }

        private static final class AdDomainsDefaultEntryHolder {
            static final MapEntry<String, Timestamps> defaultEntry = MapEntry.newDefaultInstance(SessionMetricsOuterClass.internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Timestamps.getDefaultInstance());

            private AdDomainsDefaultEntryHolder() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, Timestamps> internalGetAdDomains() {
            MapField<String, Timestamps> mapField = this.adDomains_;
            return mapField == null ? MapField.emptyMapField(AdDomainsDefaultEntryHolder.defaultEntry) : mapField;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
        public int getAdDomainsCount() {
            return internalGetAdDomains().getMap().size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
        public boolean containsAdDomains(String str) {
            str.getClass();
            return internalGetAdDomains().getMap().containsKey(str);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
        @Deprecated
        public Map<String, Timestamps> getAdDomains() {
            return getAdDomainsMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
        public Map<String, Timestamps> getAdDomainsMap() {
            return internalGetAdDomains().getMap();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
        public Timestamps getAdDomainsOrDefault(String str, Timestamps timestamps) {
            str.getClass();
            Map<String, Timestamps> map = internalGetAdDomains().getMap();
            return map.containsKey(str) ? map.get(str) : timestamps;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
        public Timestamps getAdDomainsOrThrow(String str) {
            str.getClass();
            Map<String, Timestamps> map = internalGetAdDomains().getMap();
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
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetAdDomains(), AdDomainsDefaultEntryHolder.defaultEntry, 1);
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (Map.Entry<String, Timestamps> entry : internalGetAdDomains().getMap().entrySet()) {
                i2 += CodedOutputStream.computeMessageSize(1, AdDomainsDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdDomainTimestamps)) {
                return super.equals(obj);
            }
            AdDomainTimestamps adDomainTimestamps = (AdDomainTimestamps) obj;
            return internalGetAdDomains().equals(adDomainTimestamps.internalGetAdDomains()) && this.unknownFields.equals(adDomainTimestamps.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (!internalGetAdDomains().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 1) * 53) + internalGetAdDomains().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static AdDomainTimestamps parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AdDomainTimestamps parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AdDomainTimestamps parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AdDomainTimestamps parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(InputStream inputStream) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AdDomainTimestamps parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AdDomainTimestamps parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdDomainTimestamps parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AdDomainTimestamps parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdDomainTimestamps) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AdDomainTimestamps adDomainTimestamps) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adDomainTimestamps);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdDomainTimestampsOrBuilder {
            private MapField<String, Timestamps> adDomains_;
            private int bitField0_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMapField(int i) {
                if (i == 1) {
                    return internalGetAdDomains();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected MapField internalGetMutableMapField(int i) {
                if (i == 1) {
                    return internalGetMutableAdDomains();
                }
                throw new RuntimeException("Invalid map field number: " + i);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable.ensureFieldAccessorsInitialized(AdDomainTimestamps.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AdDomainTimestamps.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                internalGetMutableAdDomains().clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdDomainTimestamps_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AdDomainTimestamps getDefaultInstanceForType() {
                return AdDomainTimestamps.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdDomainTimestamps build() {
                AdDomainTimestamps buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdDomainTimestamps buildPartial() {
                AdDomainTimestamps adDomainTimestamps = new AdDomainTimestamps(this);
                adDomainTimestamps.adDomains_ = internalGetAdDomains();
                adDomainTimestamps.adDomains_.makeImmutable();
                onBuilt();
                return adDomainTimestamps;
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
                if (message instanceof AdDomainTimestamps) {
                    return mergeFrom((AdDomainTimestamps) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AdDomainTimestamps adDomainTimestamps) {
                if (adDomainTimestamps == AdDomainTimestamps.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableAdDomains().mergeFrom(adDomainTimestamps.internalGetAdDomains());
                mergeUnknownFields(adDomainTimestamps.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AdDomainTimestamps adDomainTimestamps = null;
                try {
                    try {
                        AdDomainTimestamps adDomainTimestamps2 = (AdDomainTimestamps) AdDomainTimestamps.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (adDomainTimestamps2 != null) {
                            mergeFrom(adDomainTimestamps2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        AdDomainTimestamps adDomainTimestamps3 = (AdDomainTimestamps) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            adDomainTimestamps = adDomainTimestamps3;
                            if (adDomainTimestamps != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (adDomainTimestamps != null) {
                        mergeFrom(adDomainTimestamps);
                    }
                    throw th;
                }
            }

            private MapField<String, Timestamps> internalGetAdDomains() {
                MapField<String, Timestamps> mapField = this.adDomains_;
                return mapField == null ? MapField.emptyMapField(AdDomainsDefaultEntryHolder.defaultEntry) : mapField;
            }

            private MapField<String, Timestamps> internalGetMutableAdDomains() {
                onChanged();
                if (this.adDomains_ == null) {
                    this.adDomains_ = MapField.newMapField(AdDomainsDefaultEntryHolder.defaultEntry);
                }
                if (!this.adDomains_.isMutable()) {
                    this.adDomains_ = this.adDomains_.copy();
                }
                return this.adDomains_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
            public int getAdDomainsCount() {
                return internalGetAdDomains().getMap().size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
            public boolean containsAdDomains(String str) {
                str.getClass();
                return internalGetAdDomains().getMap().containsKey(str);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
            @Deprecated
            public Map<String, Timestamps> getAdDomains() {
                return getAdDomainsMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
            public Map<String, Timestamps> getAdDomainsMap() {
                return internalGetAdDomains().getMap();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
            public Timestamps getAdDomainsOrDefault(String str, Timestamps timestamps) {
                str.getClass();
                Map<String, Timestamps> map = internalGetAdDomains().getMap();
                return map.containsKey(str) ? map.get(str) : timestamps;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdDomainTimestampsOrBuilder
            public Timestamps getAdDomainsOrThrow(String str) {
                str.getClass();
                Map<String, Timestamps> map = internalGetAdDomains().getMap();
                if (!map.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return map.get(str);
            }

            public Builder clearAdDomains() {
                internalGetMutableAdDomains().getMutableMap().clear();
                return this;
            }

            public Builder removeAdDomains(String str) {
                str.getClass();
                internalGetMutableAdDomains().getMutableMap().remove(str);
                return this;
            }

            @Deprecated
            public Map<String, Timestamps> getMutableAdDomains() {
                return internalGetMutableAdDomains().getMutableMap();
            }

            public Builder putAdDomains(String str, Timestamps timestamps) {
                str.getClass();
                timestamps.getClass();
                internalGetMutableAdDomains().getMutableMap().put(str, timestamps);
                return this;
            }

            public Builder putAllAdDomains(Map<String, Timestamps> map) {
                internalGetMutableAdDomains().getMutableMap().putAll(map);
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

        public static AdDomainTimestamps getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdDomainTimestamps> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<AdDomainTimestamps> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public AdDomainTimestamps getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class WindowMetrics extends GeneratedMessageV3 implements WindowMetricsOrBuilder {
        public static final int LAST_1D_FIELD_NUMBER = 2;
        public static final int LAST_1H_FIELD_NUMBER = 1;
        public static final int LAST_7D_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int last1D_;
        private int last1H_;
        private int last7D_;
        private byte memoizedIsInitialized;
        private static final WindowMetrics DEFAULT_INSTANCE = new WindowMetrics();
        private static final Parser<WindowMetrics> PARSER = new AbstractParser<WindowMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.WindowMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public WindowMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WindowMetrics(codedInputStream, extensionRegistryLite);
            }
        };

        private WindowMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private WindowMetrics() {
            this.memoizedIsInitialized = (byte) -1;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new WindowMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WindowMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.last1H_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.last1D_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.last7D_ = codedInputStream.readInt32();
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
            return SessionMetricsOuterClass.internal_static_sessionmetrics_WindowMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(WindowMetrics.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.WindowMetricsOrBuilder
        public int getLast1H() {
            return this.last1H_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.WindowMetricsOrBuilder
        public int getLast1D() {
            return this.last1D_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.WindowMetricsOrBuilder
        public int getLast7D() {
            return this.last7D_;
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
            int i = this.last1H_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            int i2 = this.last1D_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(2, i2);
            }
            int i3 = this.last7D_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(3, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.last1H_;
            int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) : 0;
            int i3 = this.last1D_;
            if (i3 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, i3);
            }
            int i4 = this.last7D_;
            if (i4 != 0) {
                computeInt32Size += CodedOutputStream.computeInt32Size(3, i4);
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
            if (!(obj instanceof WindowMetrics)) {
                return super.equals(obj);
            }
            WindowMetrics windowMetrics = (WindowMetrics) obj;
            return getLast1H() == windowMetrics.getLast1H() && getLast1D() == windowMetrics.getLast1D() && getLast7D() == windowMetrics.getLast7D() && this.unknownFields.equals(windowMetrics.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getLast1H()) * 37) + 2) * 53) + getLast1D()) * 37) + 3) * 53) + getLast7D()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static WindowMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static WindowMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static WindowMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static WindowMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(InputStream inputStream) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WindowMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WindowMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WindowMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WindowMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WindowMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (WindowMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WindowMetrics windowMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(windowMetrics);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WindowMetricsOrBuilder {
            private int last1D_;
            private int last1H_;
            private int last7D_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_WindowMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(WindowMetrics.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WindowMetrics.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.last1H_ = 0;
                this.last1D_ = 0;
                this.last7D_ = 0;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_WindowMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public WindowMetrics getDefaultInstanceForType() {
                return WindowMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public WindowMetrics build() {
                WindowMetrics buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public WindowMetrics buildPartial() {
                WindowMetrics windowMetrics = new WindowMetrics(this);
                windowMetrics.last1H_ = this.last1H_;
                windowMetrics.last1D_ = this.last1D_;
                windowMetrics.last7D_ = this.last7D_;
                onBuilt();
                return windowMetrics;
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
                if (message instanceof WindowMetrics) {
                    return mergeFrom((WindowMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(WindowMetrics windowMetrics) {
                if (windowMetrics == WindowMetrics.getDefaultInstance()) {
                    return this;
                }
                if (windowMetrics.getLast1H() != 0) {
                    setLast1H(windowMetrics.getLast1H());
                }
                if (windowMetrics.getLast1D() != 0) {
                    setLast1D(windowMetrics.getLast1D());
                }
                if (windowMetrics.getLast7D() != 0) {
                    setLast7D(windowMetrics.getLast7D());
                }
                mergeUnknownFields(windowMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                WindowMetrics windowMetrics = null;
                try {
                    try {
                        WindowMetrics windowMetrics2 = (WindowMetrics) WindowMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (windowMetrics2 != null) {
                            mergeFrom(windowMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        WindowMetrics windowMetrics3 = (WindowMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            windowMetrics = windowMetrics3;
                            if (windowMetrics != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (windowMetrics != null) {
                        mergeFrom(windowMetrics);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.WindowMetricsOrBuilder
            public int getLast1H() {
                return this.last1H_;
            }

            public Builder setLast1H(int i) {
                this.last1H_ = i;
                onChanged();
                return this;
            }

            public Builder clearLast1H() {
                this.last1H_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.WindowMetricsOrBuilder
            public int getLast1D() {
                return this.last1D_;
            }

            public Builder setLast1D(int i) {
                this.last1D_ = i;
                onChanged();
                return this;
            }

            public Builder clearLast1D() {
                this.last1D_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.WindowMetricsOrBuilder
            public int getLast7D() {
                return this.last7D_;
            }

            public Builder setLast7D(int i) {
                this.last7D_ = i;
                onChanged();
                return this;
            }

            public Builder clearLast7D() {
                this.last7D_ = 0;
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

        public static WindowMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WindowMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<WindowMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public WindowMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class ImpressionMetrics extends GeneratedMessageV3 implements ImpressionMetricsOrBuilder {
        public static final int AD_TYPE_FIELD_NUMBER = 1;
        public static final int DOMAINS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int adType_;
        private List<DomainMetrics> domains_;
        private byte memoizedIsInitialized;
        private static final ImpressionMetrics DEFAULT_INSTANCE = new ImpressionMetrics();
        private static final Parser<ImpressionMetrics> PARSER = new AbstractParser<ImpressionMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public ImpressionMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ImpressionMetrics(codedInputStream, extensionRegistryLite);
            }
        };

        public interface DomainMetricsOrBuilder extends MessageOrBuilder {
            String getDomain();

            ByteString getDomainBytes();

            WindowMetrics getWindowMetrics();

            WindowMetricsOrBuilder getWindowMetricsOrBuilder();

            boolean hasWindowMetrics();
        }

        private ImpressionMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private ImpressionMetrics() {
            this.memoizedIsInitialized = (byte) -1;
            this.adType_ = 0;
            this.domains_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new ImpressionMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ImpressionMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.adType_ = codedInputStream.readEnum();
                            } else if (readTag == 18) {
                                if (!z2) {
                                    this.domains_ = new ArrayList();
                                    z2 = true;
                                }
                                this.domains_.add(codedInputStream.readMessage(DomainMetrics.parser(), extensionRegistryLite));
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
                        this.domains_ = Collections.unmodifiableList(this.domains_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(ImpressionMetrics.class, Builder.class);
        }

        public static final class DomainMetrics extends GeneratedMessageV3 implements DomainMetricsOrBuilder {
            public static final int DOMAIN_FIELD_NUMBER = 1;
            public static final int WINDOW_METRICS_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private volatile Object domain_;
            private byte memoizedIsInitialized;
            private WindowMetrics windowMetrics_;
            private static final DomainMetrics DEFAULT_INSTANCE = new DomainMetrics();
            private static final Parser<DomainMetrics> PARSER = new AbstractParser<DomainMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetrics.1
                @Override // com.explorestack.protobuf.Parser
                public DomainMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new DomainMetrics(codedInputStream, extensionRegistryLite);
                }
            };

            private DomainMetrics(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            private DomainMetrics() {
                this.memoizedIsInitialized = (byte) -1;
                this.domain_ = "";
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
                return new DomainMetrics();
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private DomainMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.domain_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    WindowMetrics windowMetrics = this.windowMetrics_;
                                    WindowMetrics.Builder builder = windowMetrics != null ? windowMetrics.toBuilder() : null;
                                    WindowMetrics windowMetrics2 = (WindowMetrics) codedInputStream.readMessage(WindowMetrics.parser(), extensionRegistryLite);
                                    this.windowMetrics_ = windowMetrics2;
                                    if (builder != null) {
                                        builder.mergeFrom(windowMetrics2);
                                        this.windowMetrics_ = builder.buildPartial();
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
                return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(DomainMetrics.class, Builder.class);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
            public String getDomain() {
                Object obj = this.domain_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.domain_ = stringUtf8;
                return stringUtf8;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
            public ByteString getDomainBytes() {
                Object obj = this.domain_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.domain_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
            public boolean hasWindowMetrics() {
                return this.windowMetrics_ != null;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
            public WindowMetrics getWindowMetrics() {
                WindowMetrics windowMetrics = this.windowMetrics_;
                return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
            public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
                return getWindowMetrics();
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
                if (!getDomainBytes().isEmpty()) {
                    GeneratedMessageV3.writeString(codedOutputStream, 1, this.domain_);
                }
                if (this.windowMetrics_ != null) {
                    codedOutputStream.writeMessage(2, getWindowMetrics());
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSize;
                if (i != -1) {
                    return i;
                }
                int computeStringSize = !getDomainBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.domain_) : 0;
                if (this.windowMetrics_ != null) {
                    computeStringSize += CodedOutputStream.computeMessageSize(2, getWindowMetrics());
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
                if (!(obj instanceof DomainMetrics)) {
                    return super.equals(obj);
                }
                DomainMetrics domainMetrics = (DomainMetrics) obj;
                if (getDomain().equals(domainMetrics.getDomain()) && hasWindowMetrics() == domainMetrics.hasWindowMetrics()) {
                    return (!hasWindowMetrics() || getWindowMetrics().equals(domainMetrics.getWindowMetrics())) && this.unknownFields.equals(domainMetrics.unknownFields);
                }
                return false;
            }

            @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getDomain().hashCode();
                if (hasWindowMetrics()) {
                    hashCode = (((hashCode * 37) + 2) * 53) + getWindowMetrics().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            public static DomainMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static DomainMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static DomainMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            public static DomainMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(InputStream inputStream) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static DomainMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DomainMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static DomainMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static DomainMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static DomainMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (DomainMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }

            @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(DomainMetrics domainMetrics) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(domainMetrics);
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

            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DomainMetricsOrBuilder {
                private Object domain_;
                private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> windowMetricsBuilder_;
                private WindowMetrics windowMetrics_;

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(DomainMetrics.class, Builder.class);
                }

                private Builder() {
                    this.domain_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.domain_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = DomainMetrics.alwaysUseFieldBuilders;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.domain_ = "";
                    if (this.windowMetricsBuilder_ == null) {
                        this.windowMetrics_ = null;
                        return this;
                    }
                    this.windowMetrics_ = null;
                    this.windowMetricsBuilder_ = null;
                    return this;
                }

                @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor;
                }

                @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
                public DomainMetrics getDefaultInstanceForType() {
                    return DomainMetrics.getDefaultInstance();
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DomainMetrics build() {
                    DomainMetrics buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                public DomainMetrics buildPartial() {
                    DomainMetrics domainMetrics = new DomainMetrics(this);
                    domainMetrics.domain_ = this.domain_;
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        domainMetrics.windowMetrics_ = this.windowMetrics_;
                    } else {
                        domainMetrics.windowMetrics_ = singleFieldBuilderV3.build();
                    }
                    onBuilt();
                    return domainMetrics;
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
                    if (message instanceof DomainMetrics) {
                        return mergeFrom((DomainMetrics) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(DomainMetrics domainMetrics) {
                    if (domainMetrics == DomainMetrics.getDefaultInstance()) {
                        return this;
                    }
                    if (!domainMetrics.getDomain().isEmpty()) {
                        this.domain_ = domainMetrics.domain_;
                        onChanged();
                    }
                    if (domainMetrics.hasWindowMetrics()) {
                        mergeWindowMetrics(domainMetrics.getWindowMetrics());
                    }
                    mergeUnknownFields(domainMetrics.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    DomainMetrics domainMetrics = null;
                    try {
                        try {
                            DomainMetrics domainMetrics2 = (DomainMetrics) DomainMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (domainMetrics2 != null) {
                                mergeFrom(domainMetrics2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            DomainMetrics domainMetrics3 = (DomainMetrics) e.getUnfinishedMessage();
                            try {
                                throw e.unwrapIOException();
                            } catch (Throwable th) {
                                th = th;
                                domainMetrics = domainMetrics3;
                                if (domainMetrics != null) {
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (domainMetrics != null) {
                            mergeFrom(domainMetrics);
                        }
                        throw th;
                    }
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
                public String getDomain() {
                    Object obj = this.domain_;
                    if (!(obj instanceof String)) {
                        String stringUtf8 = ((ByteString) obj).toStringUtf8();
                        this.domain_ = stringUtf8;
                        return stringUtf8;
                    }
                    return (String) obj;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
                public ByteString getDomainBytes() {
                    Object obj = this.domain_;
                    if (obj instanceof String) {
                        ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                        this.domain_ = copyFromUtf8;
                        return copyFromUtf8;
                    }
                    return (ByteString) obj;
                }

                public Builder setDomain(String str) {
                    str.getClass();
                    this.domain_ = str;
                    onChanged();
                    return this;
                }

                public Builder clearDomain() {
                    this.domain_ = DomainMetrics.getDefaultInstance().getDomain();
                    onChanged();
                    return this;
                }

                public Builder setDomainBytes(ByteString byteString) {
                    byteString.getClass();
                    DomainMetrics.checkByteStringIsUtf8(byteString);
                    this.domain_ = byteString;
                    onChanged();
                    return this;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
                public boolean hasWindowMetrics() {
                    return (this.windowMetricsBuilder_ == null && this.windowMetrics_ == null) ? false : true;
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
                public WindowMetrics getWindowMetrics() {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        WindowMetrics windowMetrics = this.windowMetrics_;
                        return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
                    }
                    return singleFieldBuilderV3.getMessage();
                }

                public Builder setWindowMetrics(WindowMetrics windowMetrics) {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        windowMetrics.getClass();
                        this.windowMetrics_ = windowMetrics;
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(windowMetrics);
                    return this;
                }

                public Builder setWindowMetrics(WindowMetrics.Builder builder) {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        this.windowMetrics_ = builder.build();
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }

                public Builder mergeWindowMetrics(WindowMetrics windowMetrics) {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        WindowMetrics windowMetrics2 = this.windowMetrics_;
                        if (windowMetrics2 != null) {
                            this.windowMetrics_ = WindowMetrics.newBuilder(windowMetrics2).mergeFrom(windowMetrics).buildPartial();
                        } else {
                            this.windowMetrics_ = windowMetrics;
                        }
                        onChanged();
                        return this;
                    }
                    singleFieldBuilderV3.mergeFrom(windowMetrics);
                    return this;
                }

                public Builder clearWindowMetrics() {
                    if (this.windowMetricsBuilder_ == null) {
                        this.windowMetrics_ = null;
                        onChanged();
                        return this;
                    }
                    this.windowMetrics_ = null;
                    this.windowMetricsBuilder_ = null;
                    return this;
                }

                public WindowMetrics.Builder getWindowMetricsBuilder() {
                    onChanged();
                    return getWindowMetricsFieldBuilder().getBuilder();
                }

                @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetrics.DomainMetricsOrBuilder
                public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
                    SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                    if (singleFieldBuilderV3 != null) {
                        return singleFieldBuilderV3.getMessageOrBuilder();
                    }
                    WindowMetrics windowMetrics = this.windowMetrics_;
                    return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
                }

                private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> getWindowMetricsFieldBuilder() {
                    if (this.windowMetricsBuilder_ == null) {
                        this.windowMetricsBuilder_ = new SingleFieldBuilderV3<>(getWindowMetrics(), getParentForChildren(), isClean());
                        this.windowMetrics_ = null;
                    }
                    return this.windowMetricsBuilder_;
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

            public static DomainMetrics getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DomainMetrics> parser() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
            public Parser<DomainMetrics> getParserForType() {
                return PARSER;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public DomainMetrics getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
        public int getAdTypeValue() {
            return this.adType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
        public AdType getAdType() {
            AdType valueOf = AdType.valueOf(this.adType_);
            return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
        public List<DomainMetrics> getDomainsList() {
            return this.domains_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
        public List<? extends DomainMetricsOrBuilder> getDomainsOrBuilderList() {
            return this.domains_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
        public int getDomainsCount() {
            return this.domains_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
        public DomainMetrics getDomains(int i) {
            return this.domains_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
        public DomainMetricsOrBuilder getDomainsOrBuilder(int i) {
            return this.domains_.get(i);
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
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.adType_);
            }
            for (int i = 0; i < this.domains_.size(); i++) {
                codedOutputStream.writeMessage(2, this.domains_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.adType_ != AdType.UNKNOWN.getNumber() ? CodedOutputStream.computeEnumSize(1, this.adType_) : 0;
            for (int i2 = 0; i2 < this.domains_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.domains_.get(i2));
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ImpressionMetrics)) {
                return super.equals(obj);
            }
            ImpressionMetrics impressionMetrics = (ImpressionMetrics) obj;
            return this.adType_ == impressionMetrics.adType_ && getDomainsList().equals(impressionMetrics.getDomainsList()) && this.unknownFields.equals(impressionMetrics.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.adType_;
            if (getDomainsCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getDomainsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static ImpressionMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ImpressionMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ImpressionMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ImpressionMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(InputStream inputStream) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ImpressionMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImpressionMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ImpressionMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ImpressionMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ImpressionMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ImpressionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ImpressionMetrics impressionMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(impressionMetrics);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ImpressionMetricsOrBuilder {
            private int adType_;
            private int bitField0_;
            private RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> domainsBuilder_;
            private List<DomainMetrics> domains_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(ImpressionMetrics.class, Builder.class);
            }

            private Builder() {
                this.adType_ = 0;
                this.domains_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.adType_ = 0;
                this.domains_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ImpressionMetrics.alwaysUseFieldBuilders) {
                    getDomainsFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.adType_ = 0;
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.domains_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_ImpressionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public ImpressionMetrics getDefaultInstanceForType() {
                return ImpressionMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public ImpressionMetrics build() {
                ImpressionMetrics buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public ImpressionMetrics buildPartial() {
                ImpressionMetrics impressionMetrics = new ImpressionMetrics(this);
                impressionMetrics.adType_ = this.adType_;
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    impressionMetrics.domains_ = repeatedFieldBuilderV3.build();
                } else {
                    if ((this.bitField0_ & 1) != 0) {
                        this.domains_ = Collections.unmodifiableList(this.domains_);
                        this.bitField0_ &= -2;
                    }
                    impressionMetrics.domains_ = this.domains_;
                }
                onBuilt();
                return impressionMetrics;
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
                if (message instanceof ImpressionMetrics) {
                    return mergeFrom((ImpressionMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ImpressionMetrics impressionMetrics) {
                if (impressionMetrics == ImpressionMetrics.getDefaultInstance()) {
                    return this;
                }
                if (impressionMetrics.adType_ != 0) {
                    setAdTypeValue(impressionMetrics.getAdTypeValue());
                }
                if (this.domainsBuilder_ == null) {
                    if (!impressionMetrics.domains_.isEmpty()) {
                        if (this.domains_.isEmpty()) {
                            this.domains_ = impressionMetrics.domains_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDomainsIsMutable();
                            this.domains_.addAll(impressionMetrics.domains_);
                        }
                        onChanged();
                    }
                } else if (!impressionMetrics.domains_.isEmpty()) {
                    if (!this.domainsBuilder_.isEmpty()) {
                        this.domainsBuilder_.addAllMessages(impressionMetrics.domains_);
                    } else {
                        this.domainsBuilder_.dispose();
                        this.domainsBuilder_ = null;
                        this.domains_ = impressionMetrics.domains_;
                        this.bitField0_ &= -2;
                        this.domainsBuilder_ = ImpressionMetrics.alwaysUseFieldBuilders ? getDomainsFieldBuilder() : null;
                    }
                }
                mergeUnknownFields(impressionMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                ImpressionMetrics impressionMetrics = null;
                try {
                    try {
                        ImpressionMetrics impressionMetrics2 = (ImpressionMetrics) ImpressionMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (impressionMetrics2 != null) {
                            mergeFrom(impressionMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        ImpressionMetrics impressionMetrics3 = (ImpressionMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            impressionMetrics = impressionMetrics3;
                            if (impressionMetrics != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (impressionMetrics != null) {
                        mergeFrom(impressionMetrics);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
            public int getAdTypeValue() {
                return this.adType_;
            }

            public Builder setAdTypeValue(int i) {
                this.adType_ = i;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
            public AdType getAdType() {
                AdType valueOf = AdType.valueOf(this.adType_);
                return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
            }

            public Builder setAdType(AdType adType) {
                adType.getClass();
                this.adType_ = adType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = 0;
                onChanged();
                return this;
            }

            private void ensureDomainsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.domains_ = new ArrayList(this.domains_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
            public List<DomainMetrics> getDomainsList() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.domains_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
            public int getDomainsCount() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.domains_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
            public DomainMetrics getDomains(int i) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.domains_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setDomains(int i, DomainMetrics domainMetrics) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    domainMetrics.getClass();
                    ensureDomainsIsMutable();
                    this.domains_.set(i, domainMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, domainMetrics);
                return this;
            }

            public Builder setDomains(int i, DomainMetrics.Builder builder) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.set(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }

            public Builder addDomains(DomainMetrics domainMetrics) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    domainMetrics.getClass();
                    ensureDomainsIsMutable();
                    this.domains_.add(domainMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(domainMetrics);
                return this;
            }

            public Builder addDomains(int i, DomainMetrics domainMetrics) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    domainMetrics.getClass();
                    ensureDomainsIsMutable();
                    this.domains_.add(i, domainMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, domainMetrics);
                return this;
            }

            public Builder addDomains(DomainMetrics.Builder builder) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.add(builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }

            public Builder addDomains(int i, DomainMetrics.Builder builder) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.add(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }

            public Builder addAllDomains(Iterable<? extends DomainMetrics> iterable) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.domains_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }

            public Builder clearDomains() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.domains_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            public Builder removeDomains(int i) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureDomainsIsMutable();
                    this.domains_.remove(i);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.remove(i);
                return this;
            }

            public DomainMetrics.Builder getDomainsBuilder(int i) {
                return getDomainsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
            public DomainMetricsOrBuilder getDomainsOrBuilder(int i) {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.domains_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.ImpressionMetricsOrBuilder
            public List<? extends DomainMetricsOrBuilder> getDomainsOrBuilderList() {
                RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> repeatedFieldBuilderV3 = this.domainsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.domains_);
            }

            public DomainMetrics.Builder addDomainsBuilder() {
                return getDomainsFieldBuilder().addBuilder(DomainMetrics.getDefaultInstance());
            }

            public DomainMetrics.Builder addDomainsBuilder(int i) {
                return getDomainsFieldBuilder().addBuilder(i, DomainMetrics.getDefaultInstance());
            }

            public List<DomainMetrics.Builder> getDomainsBuilderList() {
                return getDomainsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DomainMetrics, DomainMetrics.Builder, DomainMetricsOrBuilder> getDomainsFieldBuilder() {
                if (this.domainsBuilder_ == null) {
                    this.domainsBuilder_ = new RepeatedFieldBuilderV3<>(this.domains_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.domains_ = null;
                }
                return this.domainsBuilder_;
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

        public static ImpressionMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImpressionMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<ImpressionMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public ImpressionMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AdRequestMetrics extends GeneratedMessageV3 implements AdRequestMetricsOrBuilder {
        public static final int AD_TYPE_FIELD_NUMBER = 1;
        public static final int LAST_TIMESTAMPS_FIELD_NUMBER = 3;
        public static final int WINDOW_METRICS_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int adType_;
        private int lastTimestampsMemoizedSerializedSize;
        private Internal.LongList lastTimestamps_;
        private byte memoizedIsInitialized;
        private WindowMetrics windowMetrics_;
        private static final AdRequestMetrics DEFAULT_INSTANCE = new AdRequestMetrics();
        private static final Parser<AdRequestMetrics> PARSER = new AbstractParser<AdRequestMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public AdRequestMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AdRequestMetrics(codedInputStream, extensionRegistryLite);
            }
        };

        private AdRequestMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.lastTimestampsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        private AdRequestMetrics() {
            this.lastTimestampsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.adType_ = 0;
            this.lastTimestamps_ = emptyLongList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AdRequestMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AdRequestMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.adType_ = codedInputStream.readEnum();
                            } else if (readTag == 18) {
                                WindowMetrics windowMetrics = this.windowMetrics_;
                                WindowMetrics.Builder builder = windowMetrics != null ? windowMetrics.toBuilder() : null;
                                WindowMetrics windowMetrics2 = (WindowMetrics) codedInputStream.readMessage(WindowMetrics.parser(), extensionRegistryLite);
                                this.windowMetrics_ = windowMetrics2;
                                if (builder != null) {
                                    builder.mergeFrom(windowMetrics2);
                                    this.windowMetrics_ = builder.buildPartial();
                                }
                            } else if (readTag == 24) {
                                if (!z2) {
                                    this.lastTimestamps_ = newLongList();
                                    z2 = true;
                                }
                                this.lastTimestamps_.addLong(codedInputStream.readInt64());
                            } else if (readTag == 26) {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if (!z2 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.lastTimestamps_ = newLongList();
                                    z2 = true;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.lastTimestamps_.addLong(codedInputStream.readInt64());
                                }
                                codedInputStream.popLimit(pushLimit);
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
                        this.lastTimestamps_.makeImmutable();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequestMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequestMetrics.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public int getAdTypeValue() {
            return this.adType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public AdType getAdType() {
            AdType valueOf = AdType.valueOf(this.adType_);
            return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public boolean hasWindowMetrics() {
            return this.windowMetrics_ != null;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public WindowMetrics getWindowMetrics() {
            WindowMetrics windowMetrics = this.windowMetrics_;
            return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
            return getWindowMetrics();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public List<Long> getLastTimestampsList() {
            return this.lastTimestamps_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public int getLastTimestampsCount() {
            return this.lastTimestamps_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
        public long getLastTimestamps(int i) {
            return this.lastTimestamps_.getLong(i);
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
            getSerializedSize();
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(1, this.adType_);
            }
            if (this.windowMetrics_ != null) {
                codedOutputStream.writeMessage(2, getWindowMetrics());
            }
            if (getLastTimestampsList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(26);
                codedOutputStream.writeUInt32NoTag(this.lastTimestampsMemoizedSerializedSize);
            }
            for (int i = 0; i < this.lastTimestamps_.size(); i++) {
                codedOutputStream.writeInt64NoTag(this.lastTimestamps_.getLong(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.adType_ != AdType.UNKNOWN.getNumber() ? CodedOutputStream.computeEnumSize(1, this.adType_) : 0;
            if (this.windowMetrics_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, getWindowMetrics());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.lastTimestamps_.size(); i3++) {
                i2 += CodedOutputStream.computeInt64SizeNoTag(this.lastTimestamps_.getLong(i3));
            }
            int i4 = computeEnumSize + i2;
            if (!getLastTimestampsList().isEmpty()) {
                i4 = i4 + 1 + CodedOutputStream.computeInt32SizeNoTag(i2);
            }
            this.lastTimestampsMemoizedSerializedSize = i2;
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AdRequestMetrics)) {
                return super.equals(obj);
            }
            AdRequestMetrics adRequestMetrics = (AdRequestMetrics) obj;
            if (this.adType_ == adRequestMetrics.adType_ && hasWindowMetrics() == adRequestMetrics.hasWindowMetrics()) {
                return (!hasWindowMetrics() || getWindowMetrics().equals(adRequestMetrics.getWindowMetrics())) && getLastTimestampsList().equals(adRequestMetrics.getLastTimestampsList()) && this.unknownFields.equals(adRequestMetrics.unknownFields);
            }
            return false;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.adType_;
            if (hasWindowMetrics()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getWindowMetrics().hashCode();
            }
            if (getLastTimestampsCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getLastTimestampsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static AdRequestMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AdRequestMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AdRequestMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AdRequestMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(InputStream inputStream) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AdRequestMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequestMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AdRequestMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequestMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AdRequestMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequestMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AdRequestMetrics adRequestMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adRequestMetrics);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdRequestMetricsOrBuilder {
            private int adType_;
            private int bitField0_;
            private Internal.LongList lastTimestamps_;
            private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> windowMetricsBuilder_;
            private WindowMetrics windowMetrics_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequestMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequestMetrics.class, Builder.class);
            }

            private Builder() {
                this.adType_ = 0;
                this.lastTimestamps_ = AdRequestMetrics.emptyLongList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.adType_ = 0;
                this.lastTimestamps_ = AdRequestMetrics.emptyLongList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AdRequestMetrics.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.adType_ = 0;
                if (this.windowMetricsBuilder_ == null) {
                    this.windowMetrics_ = null;
                } else {
                    this.windowMetrics_ = null;
                    this.windowMetricsBuilder_ = null;
                }
                this.lastTimestamps_ = AdRequestMetrics.emptyLongList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequestMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AdRequestMetrics getDefaultInstanceForType() {
                return AdRequestMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequestMetrics build() {
                AdRequestMetrics buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequestMetrics buildPartial() {
                AdRequestMetrics adRequestMetrics = new AdRequestMetrics(this);
                adRequestMetrics.adType_ = this.adType_;
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    adRequestMetrics.windowMetrics_ = this.windowMetrics_;
                } else {
                    adRequestMetrics.windowMetrics_ = singleFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 1) != 0) {
                    this.lastTimestamps_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                adRequestMetrics.lastTimestamps_ = this.lastTimestamps_;
                onBuilt();
                return adRequestMetrics;
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
                if (message instanceof AdRequestMetrics) {
                    return mergeFrom((AdRequestMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AdRequestMetrics adRequestMetrics) {
                if (adRequestMetrics == AdRequestMetrics.getDefaultInstance()) {
                    return this;
                }
                if (adRequestMetrics.adType_ != 0) {
                    setAdTypeValue(adRequestMetrics.getAdTypeValue());
                }
                if (adRequestMetrics.hasWindowMetrics()) {
                    mergeWindowMetrics(adRequestMetrics.getWindowMetrics());
                }
                if (!adRequestMetrics.lastTimestamps_.isEmpty()) {
                    if (this.lastTimestamps_.isEmpty()) {
                        this.lastTimestamps_ = adRequestMetrics.lastTimestamps_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLastTimestampsIsMutable();
                        this.lastTimestamps_.addAll(adRequestMetrics.lastTimestamps_);
                    }
                    onChanged();
                }
                mergeUnknownFields(adRequestMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AdRequestMetrics adRequestMetrics = null;
                try {
                    try {
                        AdRequestMetrics adRequestMetrics2 = (AdRequestMetrics) AdRequestMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (adRequestMetrics2 != null) {
                            mergeFrom(adRequestMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        AdRequestMetrics adRequestMetrics3 = (AdRequestMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            adRequestMetrics = adRequestMetrics3;
                            if (adRequestMetrics != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (adRequestMetrics != null) {
                        mergeFrom(adRequestMetrics);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public int getAdTypeValue() {
                return this.adType_;
            }

            public Builder setAdTypeValue(int i) {
                this.adType_ = i;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public AdType getAdType() {
                AdType valueOf = AdType.valueOf(this.adType_);
                return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
            }

            public Builder setAdType(AdType adType) {
                adType.getClass();
                this.adType_ = adType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public boolean hasWindowMetrics() {
                return (this.windowMetricsBuilder_ == null && this.windowMetrics_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public WindowMetrics getWindowMetrics() {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    WindowMetrics windowMetrics = this.windowMetrics_;
                    return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setWindowMetrics(WindowMetrics windowMetrics) {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    windowMetrics.getClass();
                    this.windowMetrics_ = windowMetrics;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(windowMetrics);
                return this;
            }

            public Builder setWindowMetrics(WindowMetrics.Builder builder) {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.windowMetrics_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeWindowMetrics(WindowMetrics windowMetrics) {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    WindowMetrics windowMetrics2 = this.windowMetrics_;
                    if (windowMetrics2 != null) {
                        this.windowMetrics_ = WindowMetrics.newBuilder(windowMetrics2).mergeFrom(windowMetrics).buildPartial();
                    } else {
                        this.windowMetrics_ = windowMetrics;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(windowMetrics);
                return this;
            }

            public Builder clearWindowMetrics() {
                if (this.windowMetricsBuilder_ == null) {
                    this.windowMetrics_ = null;
                    onChanged();
                    return this;
                }
                this.windowMetrics_ = null;
                this.windowMetricsBuilder_ = null;
                return this;
            }

            public WindowMetrics.Builder getWindowMetricsBuilder() {
                onChanged();
                return getWindowMetricsFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public WindowMetricsOrBuilder getWindowMetricsOrBuilder() {
                SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> singleFieldBuilderV3 = this.windowMetricsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                WindowMetrics windowMetrics = this.windowMetrics_;
                return windowMetrics == null ? WindowMetrics.getDefaultInstance() : windowMetrics;
            }

            private SingleFieldBuilderV3<WindowMetrics, WindowMetrics.Builder, WindowMetricsOrBuilder> getWindowMetricsFieldBuilder() {
                if (this.windowMetricsBuilder_ == null) {
                    this.windowMetricsBuilder_ = new SingleFieldBuilderV3<>(getWindowMetrics(), getParentForChildren(), isClean());
                    this.windowMetrics_ = null;
                }
                return this.windowMetricsBuilder_;
            }

            private void ensureLastTimestampsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.lastTimestamps_ = AdRequestMetrics.mutableCopy(this.lastTimestamps_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public List<Long> getLastTimestampsList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.lastTimestamps_) : this.lastTimestamps_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public int getLastTimestampsCount() {
                return this.lastTimestamps_.size();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestMetricsOrBuilder
            public long getLastTimestamps(int i) {
                return this.lastTimestamps_.getLong(i);
            }

            public Builder setLastTimestamps(int i, long j) {
                ensureLastTimestampsIsMutable();
                this.lastTimestamps_.setLong(i, j);
                onChanged();
                return this;
            }

            public Builder addLastTimestamps(long j) {
                ensureLastTimestampsIsMutable();
                this.lastTimestamps_.addLong(j);
                onChanged();
                return this;
            }

            public Builder addAllLastTimestamps(Iterable<? extends Long> iterable) {
                ensureLastTimestampsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.lastTimestamps_);
                onChanged();
                return this;
            }

            public Builder clearLastTimestamps() {
                this.lastTimestamps_ = AdRequestMetrics.emptyLongList();
                this.bitField0_ &= -2;
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

        public static AdRequestMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdRequestMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<AdRequestMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public AdRequestMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class SessionMetrics extends GeneratedMessageV3 implements SessionMetricsOrBuilder {
        public static final int AD_REQUESTS_FIELD_NUMBER = 2;
        public static final int CURRENT_SESSION_FIELD_NUMBER = 3;
        public static final int IMPRESSIONS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<AdRequestMetrics> adRequests_;
        private UserSession currentSession_;
        private List<ImpressionMetrics> impressions_;
        private byte memoizedIsInitialized;
        private static final SessionMetrics DEFAULT_INSTANCE = new SessionMetrics();
        private static final Parser<SessionMetrics> PARSER = new AbstractParser<SessionMetrics>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetrics.1
            @Override // com.explorestack.protobuf.Parser
            public SessionMetrics parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SessionMetrics(codedInputStream, extensionRegistryLite);
            }
        };

        private SessionMetrics(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private SessionMetrics() {
            this.memoizedIsInitialized = (byte) -1;
            this.impressions_ = Collections.emptyList();
            this.adRequests_ = Collections.emptyList();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new SessionMetrics();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SessionMetrics(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if ((i & 1) == 0) {
                                        this.impressions_ = new ArrayList();
                                        i |= 1;
                                    }
                                    this.impressions_.add(codedInputStream.readMessage(ImpressionMetrics.parser(), extensionRegistryLite));
                                } else if (readTag == 18) {
                                    if ((i & 2) == 0) {
                                        this.adRequests_ = new ArrayList();
                                        i |= 2;
                                    }
                                    this.adRequests_.add(codedInputStream.readMessage(AdRequestMetrics.parser(), extensionRegistryLite));
                                } else if (readTag == 26) {
                                    UserSession userSession = this.currentSession_;
                                    UserSession.Builder builder = userSession != null ? userSession.toBuilder() : null;
                                    UserSession userSession2 = (UserSession) codedInputStream.readMessage(UserSession.parser(), extensionRegistryLite);
                                    this.currentSession_ = userSession2;
                                    if (builder != null) {
                                        builder.mergeFrom(userSession2);
                                        this.currentSession_ = builder.buildPartial();
                                    }
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
                        this.impressions_ = Collections.unmodifiableList(this.impressions_);
                    }
                    if ((i & 2) != 0) {
                        this.adRequests_ = Collections.unmodifiableList(this.adRequests_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_SessionMetrics_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionMetrics.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public List<ImpressionMetrics> getImpressionsList() {
            return this.impressions_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public List<? extends ImpressionMetricsOrBuilder> getImpressionsOrBuilderList() {
            return this.impressions_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public int getImpressionsCount() {
            return this.impressions_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public ImpressionMetrics getImpressions(int i) {
            return this.impressions_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public ImpressionMetricsOrBuilder getImpressionsOrBuilder(int i) {
            return this.impressions_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public List<AdRequestMetrics> getAdRequestsList() {
            return this.adRequests_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public List<? extends AdRequestMetricsOrBuilder> getAdRequestsOrBuilderList() {
            return this.adRequests_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public int getAdRequestsCount() {
            return this.adRequests_.size();
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public AdRequestMetrics getAdRequests(int i) {
            return this.adRequests_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public AdRequestMetricsOrBuilder getAdRequestsOrBuilder(int i) {
            return this.adRequests_.get(i);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public boolean hasCurrentSession() {
            return this.currentSession_ != null;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public UserSession getCurrentSession() {
            UserSession userSession = this.currentSession_;
            return userSession == null ? UserSession.getDefaultInstance() : userSession;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
        public UserSessionOrBuilder getCurrentSessionOrBuilder() {
            return getCurrentSession();
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
            for (int i = 0; i < this.impressions_.size(); i++) {
                codedOutputStream.writeMessage(1, this.impressions_.get(i));
            }
            for (int i2 = 0; i2 < this.adRequests_.size(); i2++) {
                codedOutputStream.writeMessage(2, this.adRequests_.get(i2));
            }
            if (this.currentSession_ != null) {
                codedOutputStream.writeMessage(3, getCurrentSession());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.impressions_.size(); i3++) {
                i2 += CodedOutputStream.computeMessageSize(1, this.impressions_.get(i3));
            }
            for (int i4 = 0; i4 < this.adRequests_.size(); i4++) {
                i2 += CodedOutputStream.computeMessageSize(2, this.adRequests_.get(i4));
            }
            if (this.currentSession_ != null) {
                i2 += CodedOutputStream.computeMessageSize(3, getCurrentSession());
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SessionMetrics)) {
                return super.equals(obj);
            }
            SessionMetrics sessionMetrics = (SessionMetrics) obj;
            if (getImpressionsList().equals(sessionMetrics.getImpressionsList()) && getAdRequestsList().equals(sessionMetrics.getAdRequestsList()) && hasCurrentSession() == sessionMetrics.hasCurrentSession()) {
                return (!hasCurrentSession() || getCurrentSession().equals(sessionMetrics.getCurrentSession())) && this.unknownFields.equals(sessionMetrics.unknownFields);
            }
            return false;
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            if (getImpressionsCount() > 0) {
                hashCode = (((hashCode * 37) + 1) * 53) + getImpressionsList().hashCode();
            }
            if (getAdRequestsCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getAdRequestsList().hashCode();
            }
            if (hasCurrentSession()) {
                hashCode = (((hashCode * 37) + 3) * 53) + getCurrentSession().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public static SessionMetrics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SessionMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SessionMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SessionMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(InputStream inputStream) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SessionMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionMetrics parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SessionMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SessionMetrics parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SessionMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SessionMetrics) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SessionMetrics sessionMetrics) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(sessionMetrics);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SessionMetricsOrBuilder {
            private RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> adRequestsBuilder_;
            private List<AdRequestMetrics> adRequests_;
            private int bitField0_;
            private SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> currentSessionBuilder_;
            private UserSession currentSession_;
            private RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> impressionsBuilder_;
            private List<ImpressionMetrics> impressions_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_SessionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable.ensureFieldAccessorsInitialized(SessionMetrics.class, Builder.class);
            }

            private Builder() {
                this.impressions_ = Collections.emptyList();
                this.adRequests_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.impressions_ = Collections.emptyList();
                this.adRequests_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SessionMetrics.alwaysUseFieldBuilders) {
                    getImpressionsFieldBuilder();
                    getAdRequestsFieldBuilder();
                }
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.impressions_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV32 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV32 == null) {
                    this.adRequests_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    repeatedFieldBuilderV32.clear();
                }
                if (this.currentSessionBuilder_ == null) {
                    this.currentSession_ = null;
                    return this;
                }
                this.currentSession_ = null;
                this.currentSessionBuilder_ = null;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_SessionMetrics_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public SessionMetrics getDefaultInstanceForType() {
                return SessionMetrics.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SessionMetrics build() {
                SessionMetrics buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public SessionMetrics buildPartial() {
                SessionMetrics sessionMetrics = new SessionMetrics(this);
                int i = this.bitField0_;
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.impressions_ = Collections.unmodifiableList(this.impressions_);
                        this.bitField0_ &= -2;
                    }
                    sessionMetrics.impressions_ = this.impressions_;
                } else {
                    sessionMetrics.impressions_ = repeatedFieldBuilderV3.build();
                }
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV32 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV32 != null) {
                    sessionMetrics.adRequests_ = repeatedFieldBuilderV32.build();
                } else {
                    if ((this.bitField0_ & 2) != 0) {
                        this.adRequests_ = Collections.unmodifiableList(this.adRequests_);
                        this.bitField0_ &= -3;
                    }
                    sessionMetrics.adRequests_ = this.adRequests_;
                }
                SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> singleFieldBuilderV3 = this.currentSessionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    sessionMetrics.currentSession_ = this.currentSession_;
                } else {
                    sessionMetrics.currentSession_ = singleFieldBuilderV3.build();
                }
                onBuilt();
                return sessionMetrics;
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
                if (message instanceof SessionMetrics) {
                    return mergeFrom((SessionMetrics) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(SessionMetrics sessionMetrics) {
                if (sessionMetrics == SessionMetrics.getDefaultInstance()) {
                    return this;
                }
                if (this.impressionsBuilder_ == null) {
                    if (!sessionMetrics.impressions_.isEmpty()) {
                        if (this.impressions_.isEmpty()) {
                            this.impressions_ = sessionMetrics.impressions_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureImpressionsIsMutable();
                            this.impressions_.addAll(sessionMetrics.impressions_);
                        }
                        onChanged();
                    }
                } else if (!sessionMetrics.impressions_.isEmpty()) {
                    if (!this.impressionsBuilder_.isEmpty()) {
                        this.impressionsBuilder_.addAllMessages(sessionMetrics.impressions_);
                    } else {
                        this.impressionsBuilder_.dispose();
                        this.impressionsBuilder_ = null;
                        this.impressions_ = sessionMetrics.impressions_;
                        this.bitField0_ &= -2;
                        this.impressionsBuilder_ = SessionMetrics.alwaysUseFieldBuilders ? getImpressionsFieldBuilder() : null;
                    }
                }
                if (this.adRequestsBuilder_ == null) {
                    if (!sessionMetrics.adRequests_.isEmpty()) {
                        if (this.adRequests_.isEmpty()) {
                            this.adRequests_ = sessionMetrics.adRequests_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAdRequestsIsMutable();
                            this.adRequests_.addAll(sessionMetrics.adRequests_);
                        }
                        onChanged();
                    }
                } else if (!sessionMetrics.adRequests_.isEmpty()) {
                    if (!this.adRequestsBuilder_.isEmpty()) {
                        this.adRequestsBuilder_.addAllMessages(sessionMetrics.adRequests_);
                    } else {
                        this.adRequestsBuilder_.dispose();
                        this.adRequestsBuilder_ = null;
                        this.adRequests_ = sessionMetrics.adRequests_;
                        this.bitField0_ &= -3;
                        this.adRequestsBuilder_ = SessionMetrics.alwaysUseFieldBuilders ? getAdRequestsFieldBuilder() : null;
                    }
                }
                if (sessionMetrics.hasCurrentSession()) {
                    mergeCurrentSession(sessionMetrics.getCurrentSession());
                }
                mergeUnknownFields(sessionMetrics.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                SessionMetrics sessionMetrics = null;
                try {
                    try {
                        SessionMetrics sessionMetrics2 = (SessionMetrics) SessionMetrics.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (sessionMetrics2 != null) {
                            mergeFrom(sessionMetrics2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        SessionMetrics sessionMetrics3 = (SessionMetrics) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            sessionMetrics = sessionMetrics3;
                            if (sessionMetrics != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (sessionMetrics != null) {
                        mergeFrom(sessionMetrics);
                    }
                    throw th;
                }
            }

            private void ensureImpressionsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.impressions_ = new ArrayList(this.impressions_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public List<ImpressionMetrics> getImpressionsList() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.impressions_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public int getImpressionsCount() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.impressions_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public ImpressionMetrics getImpressions(int i) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.impressions_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setImpressions(int i, ImpressionMetrics impressionMetrics) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    impressionMetrics.getClass();
                    ensureImpressionsIsMutable();
                    this.impressions_.set(i, impressionMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, impressionMetrics);
                return this;
            }

            public Builder setImpressions(int i, ImpressionMetrics.Builder builder) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.set(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }

            public Builder addImpressions(ImpressionMetrics impressionMetrics) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    impressionMetrics.getClass();
                    ensureImpressionsIsMutable();
                    this.impressions_.add(impressionMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(impressionMetrics);
                return this;
            }

            public Builder addImpressions(int i, ImpressionMetrics impressionMetrics) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    impressionMetrics.getClass();
                    ensureImpressionsIsMutable();
                    this.impressions_.add(i, impressionMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, impressionMetrics);
                return this;
            }

            public Builder addImpressions(ImpressionMetrics.Builder builder) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.add(builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }

            public Builder addImpressions(int i, ImpressionMetrics.Builder builder) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.add(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }

            public Builder addAllImpressions(Iterable<? extends ImpressionMetrics> iterable) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.impressions_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }

            public Builder clearImpressions() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.impressions_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            public Builder removeImpressions(int i) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureImpressionsIsMutable();
                    this.impressions_.remove(i);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.remove(i);
                return this;
            }

            public ImpressionMetrics.Builder getImpressionsBuilder(int i) {
                return getImpressionsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public ImpressionMetricsOrBuilder getImpressionsOrBuilder(int i) {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.impressions_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public List<? extends ImpressionMetricsOrBuilder> getImpressionsOrBuilderList() {
                RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> repeatedFieldBuilderV3 = this.impressionsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.impressions_);
            }

            public ImpressionMetrics.Builder addImpressionsBuilder() {
                return getImpressionsFieldBuilder().addBuilder(ImpressionMetrics.getDefaultInstance());
            }

            public ImpressionMetrics.Builder addImpressionsBuilder(int i) {
                return getImpressionsFieldBuilder().addBuilder(i, ImpressionMetrics.getDefaultInstance());
            }

            public List<ImpressionMetrics.Builder> getImpressionsBuilderList() {
                return getImpressionsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ImpressionMetrics, ImpressionMetrics.Builder, ImpressionMetricsOrBuilder> getImpressionsFieldBuilder() {
                if (this.impressionsBuilder_ == null) {
                    this.impressionsBuilder_ = new RepeatedFieldBuilderV3<>(this.impressions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.impressions_ = null;
                }
                return this.impressionsBuilder_;
            }

            private void ensureAdRequestsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.adRequests_ = new ArrayList(this.adRequests_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public List<AdRequestMetrics> getAdRequestsList() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.adRequests_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public int getAdRequestsCount() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.adRequests_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public AdRequestMetrics getAdRequests(int i) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.adRequests_.get(i);
                }
                return repeatedFieldBuilderV3.getMessage(i);
            }

            public Builder setAdRequests(int i, AdRequestMetrics adRequestMetrics) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adRequestMetrics.getClass();
                    ensureAdRequestsIsMutable();
                    this.adRequests_.set(i, adRequestMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, adRequestMetrics);
                return this;
            }

            public Builder setAdRequests(int i, AdRequestMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.set(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }

            public Builder addAdRequests(AdRequestMetrics adRequestMetrics) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adRequestMetrics.getClass();
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(adRequestMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(adRequestMetrics);
                return this;
            }

            public Builder addAdRequests(int i, AdRequestMetrics adRequestMetrics) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    adRequestMetrics.getClass();
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(i, adRequestMetrics);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, adRequestMetrics);
                return this;
            }

            public Builder addAdRequests(AdRequestMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }

            public Builder addAdRequests(int i, AdRequestMetrics.Builder builder) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.add(i, builder.build());
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }

            public Builder addAllAdRequests(Iterable<? extends AdRequestMetrics> iterable) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.adRequests_);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }

            public Builder clearAdRequests() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.adRequests_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.clear();
                return this;
            }

            public Builder removeAdRequests(int i) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAdRequestsIsMutable();
                    this.adRequests_.remove(i);
                    onChanged();
                    return this;
                }
                repeatedFieldBuilderV3.remove(i);
                return this;
            }

            public AdRequestMetrics.Builder getAdRequestsBuilder(int i) {
                return getAdRequestsFieldBuilder().getBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public AdRequestMetricsOrBuilder getAdRequestsOrBuilder(int i) {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.adRequests_.get(i);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public List<? extends AdRequestMetricsOrBuilder> getAdRequestsOrBuilderList() {
                RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> repeatedFieldBuilderV3 = this.adRequestsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.adRequests_);
            }

            public AdRequestMetrics.Builder addAdRequestsBuilder() {
                return getAdRequestsFieldBuilder().addBuilder(AdRequestMetrics.getDefaultInstance());
            }

            public AdRequestMetrics.Builder addAdRequestsBuilder(int i) {
                return getAdRequestsFieldBuilder().addBuilder(i, AdRequestMetrics.getDefaultInstance());
            }

            public List<AdRequestMetrics.Builder> getAdRequestsBuilderList() {
                return getAdRequestsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AdRequestMetrics, AdRequestMetrics.Builder, AdRequestMetricsOrBuilder> getAdRequestsFieldBuilder() {
                if (this.adRequestsBuilder_ == null) {
                    this.adRequestsBuilder_ = new RepeatedFieldBuilderV3<>(this.adRequests_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.adRequests_ = null;
                }
                return this.adRequestsBuilder_;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public boolean hasCurrentSession() {
                return (this.currentSessionBuilder_ == null && this.currentSession_ == null) ? false : true;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public UserSession getCurrentSession() {
                SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> singleFieldBuilderV3 = this.currentSessionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    UserSession userSession = this.currentSession_;
                    return userSession == null ? UserSession.getDefaultInstance() : userSession;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Builder setCurrentSession(UserSession userSession) {
                SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> singleFieldBuilderV3 = this.currentSessionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    userSession.getClass();
                    this.currentSession_ = userSession;
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(userSession);
                return this;
            }

            public Builder setCurrentSession(UserSession.Builder builder) {
                SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> singleFieldBuilderV3 = this.currentSessionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.currentSession_ = builder.build();
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }

            public Builder mergeCurrentSession(UserSession userSession) {
                SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> singleFieldBuilderV3 = this.currentSessionBuilder_;
                if (singleFieldBuilderV3 == null) {
                    UserSession userSession2 = this.currentSession_;
                    if (userSession2 != null) {
                        this.currentSession_ = UserSession.newBuilder(userSession2).mergeFrom(userSession).buildPartial();
                    } else {
                        this.currentSession_ = userSession;
                    }
                    onChanged();
                    return this;
                }
                singleFieldBuilderV3.mergeFrom(userSession);
                return this;
            }

            public Builder clearCurrentSession() {
                if (this.currentSessionBuilder_ == null) {
                    this.currentSession_ = null;
                    onChanged();
                    return this;
                }
                this.currentSession_ = null;
                this.currentSessionBuilder_ = null;
                return this;
            }

            public UserSession.Builder getCurrentSessionBuilder() {
                onChanged();
                return getCurrentSessionFieldBuilder().getBuilder();
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.SessionMetricsOrBuilder
            public UserSessionOrBuilder getCurrentSessionOrBuilder() {
                SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> singleFieldBuilderV3 = this.currentSessionBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                UserSession userSession = this.currentSession_;
                return userSession == null ? UserSession.getDefaultInstance() : userSession;
            }

            private SingleFieldBuilderV3<UserSession, UserSession.Builder, UserSessionOrBuilder> getCurrentSessionFieldBuilder() {
                if (this.currentSessionBuilder_ == null) {
                    this.currentSessionBuilder_ = new SingleFieldBuilderV3<>(getCurrentSession(), getParentForChildren(), isClean());
                    this.currentSession_ = null;
                }
                return this.currentSessionBuilder_;
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

        public static SessionMetrics getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SessionMetrics> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<SessionMetrics> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public SessionMetrics getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class UserIdQuery extends GeneratedMessageV3 implements UserIdQueryOrBuilder {
        private static final UserIdQuery DEFAULT_INSTANCE = new UserIdQuery();
        private static final Parser<UserIdQuery> PARSER = new AbstractParser<UserIdQuery>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserIdQuery.1
            @Override // com.explorestack.protobuf.Parser
            public UserIdQuery parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserIdQuery(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private long timestamp_;
        private volatile Object userId_;

        private UserIdQuery(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private UserIdQuery() {
            this.memoizedIsInitialized = (byte) -1;
            this.userId_ = "";
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new UserIdQuery();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UserIdQuery(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.userId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.timestamp_ = codedInputStream.readInt64();
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
            return SessionMetricsOuterClass.internal_static_sessionmetrics_UserIdQuery_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable.ensureFieldAccessorsInitialized(UserIdQuery.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserIdQueryOrBuilder
        public String getUserId() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserIdQueryOrBuilder
        public ByteString getUserIdBytes() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserIdQueryOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
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
            if (!getUserIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.userId_);
            }
            long j = this.timestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(2, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getUserIdBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.userId_) : 0;
            long j = this.timestamp_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(2, j);
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
            if (!(obj instanceof UserIdQuery)) {
                return super.equals(obj);
            }
            UserIdQuery userIdQuery = (UserIdQuery) obj;
            return getUserId().equals(userIdQuery.getUserId()) && getTimestamp() == userIdQuery.getTimestamp() && this.unknownFields.equals(userIdQuery.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUserId().hashCode()) * 37) + 2) * 53) + Internal.hashLong(getTimestamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static UserIdQuery parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static UserIdQuery parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserIdQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserIdQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(InputStream inputStream) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserIdQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserIdQuery parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserIdQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserIdQuery parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserIdQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserIdQuery) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserIdQuery userIdQuery) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userIdQuery);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserIdQueryOrBuilder {
            private long timestamp_;
            private Object userId_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserIdQuery_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable.ensureFieldAccessorsInitialized(UserIdQuery.class, Builder.class);
            }

            private Builder() {
                this.userId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.userId_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = UserIdQuery.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.userId_ = "";
                this.timestamp_ = 0L;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_UserIdQuery_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public UserIdQuery getDefaultInstanceForType() {
                return UserIdQuery.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserIdQuery build() {
                UserIdQuery buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public UserIdQuery buildPartial() {
                UserIdQuery userIdQuery = new UserIdQuery(this);
                userIdQuery.userId_ = this.userId_;
                userIdQuery.timestamp_ = this.timestamp_;
                onBuilt();
                return userIdQuery;
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
                if (message instanceof UserIdQuery) {
                    return mergeFrom((UserIdQuery) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(UserIdQuery userIdQuery) {
                if (userIdQuery == UserIdQuery.getDefaultInstance()) {
                    return this;
                }
                if (!userIdQuery.getUserId().isEmpty()) {
                    this.userId_ = userIdQuery.userId_;
                    onChanged();
                }
                if (userIdQuery.getTimestamp() != 0) {
                    setTimestamp(userIdQuery.getTimestamp());
                }
                mergeUnknownFields(userIdQuery.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                UserIdQuery userIdQuery = null;
                try {
                    try {
                        UserIdQuery userIdQuery2 = (UserIdQuery) UserIdQuery.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (userIdQuery2 != null) {
                            mergeFrom(userIdQuery2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        UserIdQuery userIdQuery3 = (UserIdQuery) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            userIdQuery = userIdQuery3;
                            if (userIdQuery != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (userIdQuery != null) {
                        mergeFrom(userIdQuery);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserIdQueryOrBuilder
            public String getUserId() {
                Object obj = this.userId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.userId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserIdQueryOrBuilder
            public ByteString getUserIdBytes() {
                Object obj = this.userId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.userId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setUserId(String str) {
                str.getClass();
                this.userId_ = str;
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.userId_ = UserIdQuery.getDefaultInstance().getUserId();
                onChanged();
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                byteString.getClass();
                UserIdQuery.checkByteStringIsUtf8(byteString);
                this.userId_ = byteString;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.UserIdQueryOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
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

        public static UserIdQuery getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserIdQuery> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<UserIdQuery> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public UserIdQuery getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static final class AdRequest extends GeneratedMessageV3 implements AdRequestOrBuilder {
        public static final int AD_TYPE_FIELD_NUMBER = 2;
        private static final AdRequest DEFAULT_INSTANCE = new AdRequest();
        private static final Parser<AdRequest> PARSER = new AbstractParser<AdRequest>() { // from class: io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequest.1
            @Override // com.explorestack.protobuf.Parser
            public AdRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AdRequest(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        public static final int USER_ID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int adType_;
        private byte memoizedIsInitialized;
        private long timestamp_;
        private volatile Object userId_;

        private AdRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        private AdRequest() {
            this.memoizedIsInitialized = (byte) -1;
            this.userId_ = "";
            this.adType_ = 0;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new AdRequest();
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AdRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.userId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.adType_ = codedInputStream.readEnum();
                            } else if (readTag == 24) {
                                this.timestamp_ = codedInputStream.readInt64();
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
            return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequest_descriptor;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequest.class, Builder.class);
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
        public String getUserId() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
        public ByteString getUserIdBytes() {
            Object obj = this.userId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
        public int getAdTypeValue() {
            return this.adType_;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
        public AdType getAdType() {
            AdType valueOf = AdType.valueOf(this.adType_);
            return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
        }

        @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
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
            if (!getUserIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.userId_);
            }
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(2, this.adType_);
            }
            long j = this.timestamp_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !getUserIdBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.userId_) : 0;
            if (this.adType_ != AdType.UNKNOWN.getNumber()) {
                computeStringSize += CodedOutputStream.computeEnumSize(2, this.adType_);
            }
            long j = this.timestamp_;
            if (j != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(3, j);
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
            if (!(obj instanceof AdRequest)) {
                return super.equals(obj);
            }
            AdRequest adRequest = (AdRequest) obj;
            return getUserId().equals(adRequest.getUserId()) && this.adType_ == adRequest.adType_ && getTimestamp() == adRequest.getTimestamp() && this.unknownFields.equals(adRequest.unknownFields);
        }

        @Override // com.explorestack.protobuf.AbstractMessage, com.explorestack.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUserId().hashCode()) * 37) + 2) * 53) + this.adType_) * 37) + 3) * 53) + Internal.hashLong(getTimestamp())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public static AdRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AdRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AdRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AdRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AdRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AdRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AdRequest parseFrom(InputStream inputStream) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AdRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AdRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AdRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AdRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AdRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        @Override // com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AdRequest adRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(adRequest);
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

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdRequestOrBuilder {
            private int adType_;
            private long timestamp_;
            private Object userId_;

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequest_descriptor;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(AdRequest.class, Builder.class);
            }

            private Builder() {
                this.userId_ = "";
                this.adType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.userId_ = "";
                this.adType_ = 0;
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AdRequest.alwaysUseFieldBuilders;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.userId_ = "";
                this.adType_ = 0;
                this.timestamp_ = 0L;
                return this;
            }

            @Override // com.explorestack.protobuf.GeneratedMessageV3.Builder, com.explorestack.protobuf.Message.Builder, com.explorestack.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SessionMetricsOuterClass.internal_static_sessionmetrics_AdRequest_descriptor;
            }

            @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
            public AdRequest getDefaultInstanceForType() {
                return AdRequest.getDefaultInstance();
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequest build() {
                AdRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            public AdRequest buildPartial() {
                AdRequest adRequest = new AdRequest(this);
                adRequest.userId_ = this.userId_;
                adRequest.adType_ = this.adType_;
                adRequest.timestamp_ = this.timestamp_;
                onBuilt();
                return adRequest;
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
                if (message instanceof AdRequest) {
                    return mergeFrom((AdRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(AdRequest adRequest) {
                if (adRequest == AdRequest.getDefaultInstance()) {
                    return this;
                }
                if (!adRequest.getUserId().isEmpty()) {
                    this.userId_ = adRequest.userId_;
                    onChanged();
                }
                if (adRequest.adType_ != 0) {
                    setAdTypeValue(adRequest.getAdTypeValue());
                }
                if (adRequest.getTimestamp() != 0) {
                    setTimestamp(adRequest.getTimestamp());
                }
                mergeUnknownFields(adRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.explorestack.protobuf.AbstractMessage.Builder, com.explorestack.protobuf.AbstractMessageLite.Builder, com.explorestack.protobuf.MessageLite.Builder, com.explorestack.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AdRequest adRequest = null;
                try {
                    try {
                        AdRequest adRequest2 = (AdRequest) AdRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (adRequest2 != null) {
                            mergeFrom(adRequest2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        AdRequest adRequest3 = (AdRequest) e.getUnfinishedMessage();
                        try {
                            throw e.unwrapIOException();
                        } catch (Throwable th) {
                            th = th;
                            adRequest = adRequest3;
                            if (adRequest != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (adRequest != null) {
                        mergeFrom(adRequest);
                    }
                    throw th;
                }
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
            public String getUserId() {
                Object obj = this.userId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.userId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
            public ByteString getUserIdBytes() {
                Object obj = this.userId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.userId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public Builder setUserId(String str) {
                str.getClass();
                this.userId_ = str;
                onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.userId_ = AdRequest.getDefaultInstance().getUserId();
                onChanged();
                return this;
            }

            public Builder setUserIdBytes(ByteString byteString) {
                byteString.getClass();
                AdRequest.checkByteStringIsUtf8(byteString);
                this.userId_ = byteString;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
            public int getAdTypeValue() {
                return this.adType_;
            }

            public Builder setAdTypeValue(int i) {
                this.adType_ = i;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
            public AdType getAdType() {
                AdType valueOf = AdType.valueOf(this.adType_);
                return valueOf == null ? AdType.UNRECOGNIZED : valueOf;
            }

            public Builder setAdType(AdType adType) {
                adType.getClass();
                this.adType_ = adType.getNumber();
                onChanged();
                return this;
            }

            public Builder clearAdType() {
                this.adType_ = 0;
                onChanged();
                return this;
            }

            @Override // io.bidmachine.protobuf.sessionmetrics.SessionMetricsOuterClass.AdRequestOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
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

        public static AdRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdRequest> parser() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.GeneratedMessageV3, com.explorestack.protobuf.MessageLite, com.explorestack.protobuf.Message
        public Parser<AdRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.explorestack.protobuf.MessageLiteOrBuilder, com.explorestack.protobuf.MessageOrBuilder
        public AdRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_sessionmetrics_UserState_descriptor = descriptor2;
        internal_static_sessionmetrics_UserState_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"LastProcessedTimestamp", "Impressions", "AdRequests"});
        Descriptors.Descriptor descriptor3 = descriptor2.getNestedTypes().get(0);
        internal_static_sessionmetrics_UserState_ImpressionsEntry_descriptor = descriptor3;
        internal_static_sessionmetrics_UserState_ImpressionsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor4 = descriptor2.getNestedTypes().get(1);
        internal_static_sessionmetrics_UserState_AdRequestsEntry_descriptor = descriptor4;
        internal_static_sessionmetrics_UserState_AdRequestsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(1);
        internal_static_sessionmetrics_UserSession_descriptor = descriptor5;
        internal_static_sessionmetrics_UserSession_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"LastActivity", "MetricsByAdType", "SessionStart"});
        Descriptors.Descriptor descriptor6 = descriptor5.getNestedTypes().get(0);
        internal_static_sessionmetrics_UserSession_Ecpm_descriptor = descriptor6;
        internal_static_sessionmetrics_UserSession_Ecpm_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{"FirstPrices", "LastPrices", "Count"});
        Descriptors.Descriptor descriptor7 = descriptor5.getNestedTypes().get(1);
        internal_static_sessionmetrics_UserSession_Auction_descriptor = descriptor7;
        internal_static_sessionmetrics_UserSession_Auction_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor7, new String[]{"SourceRequestId", "WinnerBidderId", "LosersBidderId"});
        Descriptors.Descriptor descriptor8 = descriptor5.getNestedTypes().get(2);
        internal_static_sessionmetrics_UserSession_AdTypeMetrics_descriptor = descriptor8;
        internal_static_sessionmetrics_UserSession_AdTypeMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor8, new String[]{"AdType", "Impressions", "AdRequests", "Bids", "Wins", "Losses", "Lurls", "Nurls", "CumulativeBidPrice", "CumulativeLurlPrice", "CumulativeNurlPrice", "Ecpm", "Auctions"});
        Descriptors.Descriptor descriptor9 = getDescriptor().getMessageTypes().get(2);
        internal_static_sessionmetrics_Timestamps_descriptor = descriptor9;
        internal_static_sessionmetrics_Timestamps_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor9, new String[]{"LastTimestamp", "Deltas", "DayBuckets"});
        Descriptors.Descriptor descriptor10 = descriptor9.getNestedTypes().get(0);
        internal_static_sessionmetrics_Timestamps_DayBucket_descriptor = descriptor10;
        internal_static_sessionmetrics_Timestamps_DayBucket_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor10, new String[]{"StartTime", "Count"});
        Descriptors.Descriptor descriptor11 = getDescriptor().getMessageTypes().get(3);
        internal_static_sessionmetrics_AdDomainTimestamps_descriptor = descriptor11;
        internal_static_sessionmetrics_AdDomainTimestamps_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor11, new String[]{"AdDomains"});
        Descriptors.Descriptor descriptor12 = descriptor11.getNestedTypes().get(0);
        internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_descriptor = descriptor12;
        internal_static_sessionmetrics_AdDomainTimestamps_AdDomainsEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor12, new String[]{"Key", "Value"});
        Descriptors.Descriptor descriptor13 = getDescriptor().getMessageTypes().get(4);
        internal_static_sessionmetrics_WindowMetrics_descriptor = descriptor13;
        internal_static_sessionmetrics_WindowMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor13, new String[]{"Last1H", "Last1D", "Last7D"});
        Descriptors.Descriptor descriptor14 = getDescriptor().getMessageTypes().get(5);
        internal_static_sessionmetrics_ImpressionMetrics_descriptor = descriptor14;
        internal_static_sessionmetrics_ImpressionMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor14, new String[]{"AdType", "Domains"});
        Descriptors.Descriptor descriptor15 = descriptor14.getNestedTypes().get(0);
        internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_descriptor = descriptor15;
        internal_static_sessionmetrics_ImpressionMetrics_DomainMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor15, new String[]{"Domain", "WindowMetrics"});
        Descriptors.Descriptor descriptor16 = getDescriptor().getMessageTypes().get(6);
        internal_static_sessionmetrics_AdRequestMetrics_descriptor = descriptor16;
        internal_static_sessionmetrics_AdRequestMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor16, new String[]{"AdType", "WindowMetrics", "LastTimestamps"});
        Descriptors.Descriptor descriptor17 = getDescriptor().getMessageTypes().get(7);
        internal_static_sessionmetrics_SessionMetrics_descriptor = descriptor17;
        internal_static_sessionmetrics_SessionMetrics_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor17, new String[]{"Impressions", "AdRequests", "CurrentSession"});
        Descriptors.Descriptor descriptor18 = getDescriptor().getMessageTypes().get(8);
        internal_static_sessionmetrics_UserIdQuery_descriptor = descriptor18;
        internal_static_sessionmetrics_UserIdQuery_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor18, new String[]{"UserId", "Timestamp"});
        Descriptors.Descriptor descriptor19 = getDescriptor().getMessageTypes().get(9);
        internal_static_sessionmetrics_AdRequest_descriptor = descriptor19;
        internal_static_sessionmetrics_AdRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor19, new String[]{"UserId", "AdType", "Timestamp"});
    }
}
