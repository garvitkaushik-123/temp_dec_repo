package io.bidmachine.utils;

import android.location.Location;
import android.text.TextUtils;
import android.util.Base64;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.MessageLite;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Timestamp;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Ad;
import com.explorestack.protobuf.adcom.Context;
import com.explorestack.protobuf.adcom.EventType;
import com.explorestack.protobuf.adcom.LocationType;
import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.TrackEventType;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.AdExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class ProtoUtils {
    public static boolean isBannerPlacement(Placement placement, BannerSize bannerSize) {
        Placement.DisplayPlacement display = placement.getDisplay();
        return !display.getInstl() && bannerSize.width == display.getW() && bannerSize.height == display.getH();
    }

    public static boolean isInterstitialPlacement(Placement placement) {
        if (isRewardedPlacement(placement)) {
            return false;
        }
        Placement.DisplayPlacement display = placement.getDisplay();
        if (display == Placement.DisplayPlacement.getDefaultInstance() || !display.getInstl()) {
            return isVideoPlacement(placement);
        }
        return true;
    }

    public static boolean isVideoPlacement(Placement placement) {
        return placement.getVideo() != Placement.VideoPlacement.getDefaultInstance();
    }

    public static boolean isRewardedPlacement(Placement placement) {
        return placement.getReward();
    }

    public static boolean isNativePlacement(Placement placement) {
        return placement.getDisplay().getNativefmt().getAssetCount() > 0;
    }

    public static Context.Geo.Builder createGeoBuilderWithLocation(android.content.Context context, Location primaryLocation, Location secondaryLocation, boolean shouldProvideUtc) {
        Context.Geo.Builder newBuilder = Context.Geo.newBuilder();
        fillGeoBuilder(newBuilder, Utils.getBestLocation(context, primaryLocation, secondaryLocation), shouldProvideUtc);
        return newBuilder;
    }

    public static void fillGeoBuilder(Context.Geo.Builder builder, Location location, boolean shouldProvideUtc) {
        if (shouldProvideUtc) {
            builder.setUtcoffset(Utils.getUtcOffsetMinutes());
        }
        if (location != null) {
            builder.setType(getLocationType(location));
            builder.setLat((float) location.getLatitude());
            builder.setLon((float) location.getLongitude());
            builder.setAccur((int) location.getAccuracy());
            builder.setLastfix(location.getTime());
        }
    }

    public static LocationType getLocationType(Location location) {
        if (location != null) {
            if ("gps".equals(location.getProvider())) {
                return LocationType.LOCATION_TYPE_GPS;
            }
            if ("network".equals(location.getProvider()) || "passive".equals(location.getProvider())) {
                return LocationType.LOCATION_TYPE_IP;
            }
        }
        return LocationType.LOCATION_TYPE_INVALID;
    }

    public static void prepareEvents(Map<TrackEventType, List<String>> outMap, List<Ad.Event> events) {
        TrackEventType fromNumber;
        if (events == null || events.isEmpty()) {
            return;
        }
        for (Ad.Event event : events) {
            if (event.getType() == EventType.EVENT_TYPE_IMPRESSION) {
                fromNumber = TrackEventType.Show;
            } else {
                fromNumber = TrackEventType.fromNumber(event.getTypeValue());
            }
            if (fromNumber != null) {
                addEvent(outMap, fromNumber, event.getUrl());
            }
        }
    }

    public static void addEvent(Map<TrackEventType, List<String>> outMap, TrackEventType eventType, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        List<String> list = outMap.get(eventType);
        if (list == null) {
            list = new ArrayList<>(1);
            outMap.put(eventType, list);
        }
        list.add(url);
    }

    public static AdExtension findFirstAdExtension(Ad ad) {
        Any extProto;
        int extProtoCount = ad.getExtProtoCount();
        if (extProtoCount <= 0) {
            return null;
        }
        for (int i = 0; i < extProtoCount; i++) {
            try {
                extProto = ad.getExtProto(i);
            } catch (Throwable th) {
                Logger.w(th);
            }
            if (extProto.is(AdExtension.class)) {
                return (AdExtension) extProto.unpack(AdExtension.class);
            }
            continue;
        }
        return null;
    }

    public static boolean isEmpty(Struct struct) {
        return struct == null || struct.getFieldsCount() <= 0;
    }

    public static boolean isEmpty(ListValue listValue) {
        return listValue == null || listValue.getValuesCount() <= 0;
    }

    public static String encodeToString(MessageLite messageLite) {
        if (messageLite == null) {
            return null;
        }
        try {
            return Base64.encodeToString(messageLite.toByteArray(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, Object> toMap(Struct struct) {
        Map<String, Object> mapOrNull = toMapOrNull(struct);
        return mapOrNull != null ? mapOrNull : new HashMap();
    }

    public static Map<String, Object> toMapOrNull(Struct struct) {
        Object objectOrNull;
        if (isEmpty(struct)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Value> entry : struct.getFieldsMap().entrySet()) {
            String key = entry.getKey();
            Value value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && (objectOrNull = toObjectOrNull(value)) != null) {
                hashMap.put(key, objectOrNull);
            }
        }
        return hashMap;
    }

    public static List<Object> toList(ListValue listValue) {
        List<Object> listOrNull = toListOrNull(listValue);
        return listOrNull != null ? listOrNull : new ArrayList();
    }

    public static List<Object> toListOrNull(ListValue listValue) {
        if (isEmpty(listValue)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Value> it = listValue.getValuesList().iterator();
        while (it.hasNext()) {
            Object objectOrNull = toObjectOrNull(it.next());
            if (objectOrNull != null) {
                arrayList.add(objectOrNull);
            }
        }
        return arrayList;
    }

    /* renamed from: io.bidmachine.utils.ProtoUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$explorestack$protobuf$Value$KindCase;

        static {
            int[] iArr = new int[Value.KindCase.values().length];
            $SwitchMap$com$explorestack$protobuf$Value$KindCase = iArr;
            try {
                iArr[Value.KindCase.NUMBER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.STRING_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.BOOL_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.STRUCT_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$explorestack$protobuf$Value$KindCase[Value.KindCase.LIST_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static Object toObjectOrNull(Value value) {
        if (value == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$explorestack$protobuf$Value$KindCase[value.getKindCase().ordinal()];
        if (i == 1) {
            return Double.valueOf(value.getNumberValue());
        }
        if (i == 2) {
            return value.getStringValue();
        }
        if (i == 3) {
            return Boolean.valueOf(value.getBoolValue());
        }
        if (i == 4) {
            return toMapOrNull(value.getStructValue());
        }
        if (i != 5) {
            return null;
        }
        return toListOrNull(value.getListValue());
    }

    public static Struct.Builder toStructBuilderOrNull(Map<?, ?> params) {
        Value.Builder valueBuilderOrNull;
        if (params == null || params.isEmpty()) {
            return null;
        }
        Struct.Builder newBuilder = Struct.newBuilder();
        for (Map.Entry<?, ?> entry : params.entrySet()) {
            Object key = entry.getKey();
            if (key != null) {
                String valueOf = String.valueOf(key);
                if (!TextUtils.isEmpty(valueOf) && (valueBuilderOrNull = toValueBuilderOrNull(entry.getValue())) != null) {
                    newBuilder.putFields(valueOf, valueBuilderOrNull.build());
                }
            }
        }
        return newBuilder;
    }

    public static void fillStructWithPrimitiveValues(Struct.Builder structBuilder, Map<String, Object> source) {
        for (Map.Entry<String, Object> entry : source.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                if (value.getClass() == String.class) {
                    structBuilder.putFields(key, Value.newBuilder().setStringValue((String) value).build());
                } else if (value.getClass() == Boolean.class) {
                    structBuilder.putFields(key, Value.newBuilder().setBoolValue(((Boolean) value).booleanValue()).build());
                } else if (value instanceof Number) {
                    structBuilder.putFields(key, Value.newBuilder().setNumberValue(((Number) value).doubleValue()).build());
                }
            }
        }
    }

    public static Value toValueOrNull(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Value) {
            return (Value) object;
        }
        if (object instanceof Value.Builder) {
            return ((Value.Builder) object).build();
        }
        Value.Builder valueBuilderOrNull = toValueBuilderOrNull(object);
        if (valueBuilderOrNull != null) {
            return valueBuilderOrNull.build();
        }
        return null;
    }

    public static Value.Builder toValueBuilderOrNull(Object object) {
        Struct.Builder structBuilderOrNull;
        if (object == null) {
            return null;
        }
        if (object instanceof Value) {
            return ((Value) object).toBuilder();
        }
        if (object instanceof Value.Builder) {
            return (Value.Builder) object;
        }
        if (object instanceof String) {
            return Value.newBuilder().setStringValue((String) object);
        }
        if (object instanceof Number) {
            return Value.newBuilder().setNumberValue(((Number) object).doubleValue());
        }
        if (object instanceof Boolean) {
            return Value.newBuilder().setBoolValue(((Boolean) object).booleanValue());
        }
        if (object instanceof List) {
            ListValue.Builder listValueBuilderOrNull = toListValueBuilderOrNull((List) object);
            if (listValueBuilderOrNull != null) {
                return Value.newBuilder().setListValue(listValueBuilderOrNull);
            }
        } else if ((object instanceof Map) && (structBuilderOrNull = toStructBuilderOrNull((Map) object)) != null) {
            return Value.newBuilder().setStructValue(structBuilderOrNull);
        }
        return null;
    }

    public static ListValue.Builder toListValueBuilderOrNull(List<?> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ListValue.Builder newBuilder = ListValue.newBuilder();
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Value.Builder valueBuilderOrNull = toValueBuilderOrNull(it.next());
            if (valueBuilderOrNull != null) {
                newBuilder.addValues(valueBuilderOrNull);
            }
        }
        return newBuilder;
    }

    public static Timestamp msToProtobufTimestamp(long timestamp) {
        return Timestamp.newBuilder().setSeconds(timestamp / 1000).setNanos(((int) (timestamp % 1000)) * 1000000).build();
    }
}
