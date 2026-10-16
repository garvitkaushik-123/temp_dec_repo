package com.inmobi.media;

import com.adjust.sdk.Constants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import io.bidmachine.media3.common.PlaybackException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Ia implements La {

    /* renamed from: a, reason: collision with root package name */
    public final Ha f2316a;
    public final C2782nc b;
    public final String c;
    public final AtomicBoolean d;

    public Ia(Ha ha, C2782nc c2782nc) {
        this.f2316a = ha;
        this.b = c2782nc;
        String id = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(id, "toString(...)");
        this.c = id;
        this.d = new AtomicBoolean(false);
        C2576b5 c2576b5 = Aa.f2234a;
        if (c2576b5 != null) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(this, "listener");
            c2576b5.b.put(id, new WeakReference(this));
            Iterator it = c2576b5.b.entrySet().iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (((WeakReference) ((Map.Entry) next).getValue()).get() == null) {
                    it.remove();
                }
            }
        }
        F3 f3 = Aa.b;
        if (f3 != null) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(this, "listener");
            f3.b.put(id, new WeakReference(this));
            Iterator it2 = f3.b.entrySet().iterator();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                if (((WeakReference) ((Map.Entry) next2).getValue()).get() == null) {
                    it2.remove();
                }
            }
        }
    }

    public static final void a(Ia this$0, String json) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(json, "$json");
        this$0.getClass();
        try {
            for (C2976za c2976za : this$0.a(json)) {
                this$0.c(c2976za.e);
                a(c2976za);
            }
        } catch (NoClassDefFoundError e) {
            a(this$0, (short) 2245);
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        } catch (JSONException unused) {
            a(this$0, (short) 2243);
            Ha ha = this$0.f2316a;
            if (ha != null) {
                EnumC2774n4[] enumC2774n4Arr = EnumC2774n4.f2646a;
                ((Yb) ha).a("", PlaybackException.ERROR_CODE_CONCURRENT_STREAM_LIMIT, "Ping JSON is invalid", System.currentTimeMillis(), 0);
            }
        } catch (Exception e2) {
            a(this$0, (short) 2244);
            S5 s52 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e2, "event"));
        }
    }

    public final void b(final String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue()).execute(new Runnable() { // from class: com.inmobi.media.Ia$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Ia.a(Ia.this, json);
            }
        });
    }

    public final void c(String priority) {
        C2782nc c2782nc = this.b;
        if (c2782nc != null) {
            Intrinsics.checkNotNullParameter(priority, "priority");
            Map a2 = c2782nc.a();
            a2.put("trigger", priority);
            Oa.a("PingStarted", a2);
        }
    }

    public static void a(C2976za c2976za) {
        Objects.toString(c2976za);
        if (Intrinsics.areEqual(c2976za.e, Constants.HIGH)) {
            C2576b5 c2576b5 = Aa.f2234a;
            if (c2576b5 != null) {
                c2576b5.b(c2976za);
                return;
            }
            return;
        }
        F3 f3 = Aa.b;
        if (f3 != null) {
            f3.b(c2976za);
        }
    }

    public final List a(String str) {
        String host;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        if (jSONArray.length() == 0) {
            a(this, (short) 2253);
            Ha ha = this.f2316a;
            if (ha != null) {
                EnumC2774n4[] enumC2774n4Arr = EnumC2774n4.f2646a;
                ((Yb) ha).a("", PlaybackException.ERROR_CODE_PARENTAL_CONTROL_RESTRICTED, "Ping array is empty", System.currentTimeMillis(), 0);
            }
            return CollectionsKt.emptyList();
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                a(this, (short) 2254);
            } else {
                String optString = optJSONObject.optString("id");
                if (optString != null && !StringsKt.isBlank(optString)) {
                    String optString2 = optJSONObject.optString("url");
                    if (optString2 != null && !StringsKt.isBlank(optString2)) {
                        Intrinsics.checkNotNull(optString2);
                        try {
                            URI uri = new URI(optString2);
                            if ((Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https")) && (host = uri.getHost()) != null && !StringsKt.isBlank(host)) {
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("headers");
                                if (optJSONObject2 != null) {
                                    Iterator<String> keys = optJSONObject2.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        Intrinsics.checkNotNull(next);
                                        String optString3 = optJSONObject2.optString(next, "");
                                        Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
                                        linkedHashMap.put(next, optString3);
                                    }
                                }
                                boolean optBoolean = optJSONObject.optBoolean("allowRedirects", true);
                                String optString4 = optJSONObject.optString(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, Constants.NORMAL);
                                boolean optBoolean2 = optJSONObject.optBoolean("ackRequired", false);
                                Intrinsics.checkNotNull(optString);
                                String str2 = optString4 == null ? Constants.NORMAL : optString4;
                                String str3 = this.c;
                                C2782nc c2782nc = this.b;
                                arrayList.add(new C2976za(optString2, optString, linkedHashMap, optBoolean, str2, optBoolean2, 0, str3, System.currentTimeMillis(), null, c2782nc != null ? c2782nc.f2652a : null));
                            }
                        } catch (Exception unused) {
                        }
                        a(this, (short) 2256);
                        Ha ha2 = this.f2316a;
                        if (ha2 != null) {
                            Intrinsics.checkNotNull(optString);
                            EnumC2774n4[] enumC2774n4Arr2 = EnumC2774n4.f2646a;
                            ((Yb) ha2).a(optString, PlaybackException.ERROR_CODE_AUTHENTICATION_EXPIRED, "Ping url is invalid", System.currentTimeMillis(), 0);
                        }
                    } else {
                        a(this, (short) 2252);
                        Ha ha3 = this.f2316a;
                        if (ha3 != null) {
                            Intrinsics.checkNotNull(optString);
                            EnumC2774n4[] enumC2774n4Arr3 = EnumC2774n4.f2646a;
                            ((Yb) ha3).a(optString, PlaybackException.ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED, "Ping URL is missing", System.currentTimeMillis(), 0);
                        }
                    }
                } else {
                    a(this, (short) 2255);
                    Ha ha4 = this.f2316a;
                    if (ha4 != null) {
                        Intrinsics.checkNotNull(optString);
                        EnumC2774n4[] enumC2774n4Arr4 = EnumC2774n4.f2646a;
                        ((Yb) ha4).a(optString, -101, "Ping ID is missing", System.currentTimeMillis(), 0);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void a(Ia ia, short s) {
        C2782nc c2782nc = ia.b;
        if (c2782nc != null) {
            Intrinsics.checkNotNullParameter("unknown", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY);
            Map a2 = c2782nc.a();
            a2.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(s));
            a2.put("trigger", "unknown");
            a2.put("retryCount", String.valueOf(0));
            Oa.a("PingFailed", a2);
        }
    }
}
