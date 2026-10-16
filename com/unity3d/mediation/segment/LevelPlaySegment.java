package com.unity3d.mediation.segment;

import android.text.TextUtils;
import com.ironsource.C3260q4;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class LevelPlaySegment {
    public static final a Companion = new a(null);
    public static final String IAPT = "iapt";
    public static final String LEVEL = "lvl";
    public static final String PAYING = "pay";
    public static final String SEGMENT_NAME = "segName";
    public static final String USER_CREATION_DATE = "ucd";
    private static final int h = 999999;
    private static final double i = 999999.99d;
    private static final int j = 5;
    private static final String k = "custom";
    private boolean c;
    private String d;
    private long g;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Pair<String, String>> f6461a = new ArrayList<>();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private int e = -1;
    private double f = -1.0d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    private final boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new Regex("^[a-zA-Z0-9]*$").matches(str);
    }

    public final ArrayList<Pair<String, String>> getCustoms$mediationsdk_release() {
        return this.f6461a;
    }

    public final double getIapTotal() {
        return this.f;
    }

    public final int getLevel() {
        return this.e;
    }

    public final ArrayList<Pair<String, String>> getSegmentData() {
        IronLog.API.info("");
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (this.e != -1) {
            arrayList.add(new Pair<>("lvl", String.valueOf(this.e)));
        }
        if (this.c) {
            arrayList.add(new Pair<>("pay", String.valueOf(isPaying())));
        }
        if (this.f != -1.0d) {
            arrayList.add(new Pair<>("iapt", String.valueOf(this.f)));
        }
        if (this.g != 0) {
            arrayList.add(new Pair<>("ucd", String.valueOf(this.g)));
        }
        String str = this.d;
        if (str != null && !TextUtils.isEmpty(str)) {
            arrayList.add(new Pair<>(SEGMENT_NAME, str));
        }
        ArrayList<Pair<String, String>> arrayList2 = this.f6461a;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList3.add(new Pair("custom_" + pair.getFirst(), pair.getSecond()));
        }
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    public final String getSegmentName() {
        return this.d;
    }

    public final long getUserCreationDate() {
        return this.g;
    }

    public final boolean isPaying() {
        return this.b.get();
    }

    public final void setCustom(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        IronLog.API.info("");
        try {
            if (a(key) && a(key, 1, 32) && a(value) && a(value, 1, 32)) {
                if (this.f6461a.size() >= 5) {
                    this.f6461a.remove(0);
                }
                this.f6461a.add(new Pair<>(key, value));
                return;
            }
            IronLog.INTERNAL.warning(key + ", " + value + " must be alphanumeric and 1-32 in length");
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public final void setIapTotal(double d) {
        IronLog.API.info("");
        if (0.0d > d || d > i) {
            IronLog.INTERNAL.warning(d + " must be between 0-999999.99");
        } else {
            double d2 = 100;
            this.f = Math.floor(d * d2) / d2;
        }
    }

    public final void setLevel(int i2) {
        IronLog.API.info("");
        if (1 > i2 || i2 >= 1000000) {
            IronLog.INTERNAL.warning(i2 + " must be between 1-999999");
        } else {
            this.e = i2;
        }
    }

    public final void setPaying(boolean z) {
        IronLog.API.info("");
        this.c = true;
        this.b.set(z);
    }

    public final void setSegmentName(String str) {
        IronLog.API.info("");
        if (a(str) && a(str, 1, 32)) {
            this.d = str;
        } else {
            IronLog.INTERNAL.warning(str + " must be alphanumeric and 1-32 in length");
        }
    }

    public final void setUserCreationDate(long j2) {
        IronLog.API.info("");
        if (j2 <= 0) {
            IronLog.INTERNAL.warning(j2 + " is an invalid timestamp");
        } else {
            this.g = j2;
        }
    }

    public final JSONObject toJson() {
        IronLog.API.info("");
        JSONObject jSONObject = new JSONObject();
        Iterator<Pair<String, String>> it = getSegmentData().iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            try {
                jSONObject.put(next.component1(), next.component2());
            } catch (JSONException e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error("exception " + e.getMessage());
            }
        }
        return jSONObject;
    }

    private final boolean a(String str, int i2, int i3) {
        return str != null && str.length() >= i2 && str.length() <= i3;
    }
}
