package com.ironsource;

import android.app.Activity;
import com.ironsource.C3040d4;
import com.ironsource.C3230o8;
import com.ironsource.D8;
import com.ironsource.Db;
import com.ironsource.E8;
import com.ironsource.Md;
import com.ironsource.sdk.IronSourceNetwork;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.z8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3416z8 implements D8 {
    public static final a j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f3961a;
    private final Db b;
    private final InterfaceC3280r8 c;
    private B8 d;
    private String e;
    private String f;
    private Long g;
    private D8.a h;
    private E8 i;

    /* renamed from: com.ironsource.z8$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final C3416z8 a() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            com.ironsource.sdk.controller.e controllerManager = IronSourceNetwork.getControllerManager();
            Intrinsics.checkNotNullExpressionValue(controllerManager, "controllerManager");
            return new C3416z8(uuid, new Cb(uuid, controllerManager, null, null, 12, null), new C3297s8());
        }

        private a() {
        }
    }

    public C3416z8(String id, Db controller, InterfaceC3280r8 eventTracker) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.f3961a = id;
        this.b = controller;
        this.c = eventTracker;
        controller.a(f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C3264q8 d() {
        C3264q8 a2 = new C3264q8().a(D5.x, this.f).a(D5.v, this.e).a(D5.w, C3230o8.e.NativeAd.toString()).a(D5.I, Long.valueOf(j()));
        Intrinsics.checkNotNullExpressionValue(a2, "ISNEventParams()\n       …CUSTOM_C, loadDuration())");
        return a2;
    }

    @JvmStatic
    public static final C3416z8 e() {
        return j.a();
    }

    private final b f() {
        return new b();
    }

    private final c g() {
        return new c();
    }

    private final long j() {
        Long l = this.g;
        if (l == null) {
            return -1L;
        }
        return Calendar.getInstance().getTimeInMillis() - l.longValue();
    }

    public final String h() {
        return this.e;
    }

    public final String i() {
        return this.f;
    }

    @Override // com.ironsource.D8
    public D8.a b() {
        return this.h;
    }

    @Override // com.ironsource.D8
    public B8 c() {
        return this.d;
    }

    /* renamed from: com.ironsource.z8$b */
    public static final class b implements Db.a {
        b() {
        }

        @Override // com.ironsource.Db.a
        public void a(B8 adData) {
            Intrinsics.checkNotNullParameter(adData, "adData");
            C3416z8.this.d = adData;
            InterfaceC3280r8 interfaceC3280r8 = C3416z8.this.c;
            Md.a loadAdSuccess = Md.l;
            Intrinsics.checkNotNullExpressionValue(loadAdSuccess, "loadAdSuccess");
            HashMap<String, Object> a2 = C3416z8.this.d().a();
            Intrinsics.checkNotNullExpressionValue(a2, "baseEventParams().data");
            interfaceC3280r8.a(loadAdSuccess, a2);
            D8.a b = C3416z8.this.b();
            if (b != null) {
                b.onNativeAdLoadSuccess(adData);
            }
        }

        @Override // com.ironsource.Db.a
        public void g() {
            D8.a b = C3416z8.this.b();
            if (b != null) {
                b.onNativeAdClicked();
            }
        }

        @Override // com.ironsource.Db.a
        public void a(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            C3264q8 a2 = C3416z8.this.d().a(D5.A, reason);
            InterfaceC3280r8 interfaceC3280r8 = C3416z8.this.c;
            Md.a loadAdFailed = Md.g;
            Intrinsics.checkNotNullExpressionValue(loadAdFailed, "loadAdFailed");
            HashMap<String, Object> a3 = a2.a();
            Intrinsics.checkNotNullExpressionValue(a3, "eventParams.data");
            interfaceC3280r8.a(loadAdFailed, a3);
            D8.a b = C3416z8.this.b();
            if (b != null) {
                b.onNativeAdLoadFailed(reason);
            }
        }

        @Override // com.ironsource.Db.a
        public void a() {
            D8.a b = C3416z8.this.b();
            if (b != null) {
                b.onNativeAdShown();
            }
        }
    }

    @Override // com.ironsource.D8
    public void a(D8.a aVar) {
        this.h = aVar;
    }

    @Override // com.ironsource.D8
    public void a(Activity activity, JSONObject loadParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        this.g = Long.valueOf(Calendar.getInstance().getTimeInMillis());
        this.e = loadParams.optString("demandSourceName");
        this.f = loadParams.optString("inAppBidding");
        InterfaceC3280r8 interfaceC3280r8 = this.c;
        Md.a loadAd = Md.f;
        Intrinsics.checkNotNullExpressionValue(loadAd, "loadAd");
        HashMap<String, Object> a2 = d().a();
        Intrinsics.checkNotNullExpressionValue(a2, "baseEventParams().data");
        interfaceC3280r8.a(loadAd, a2);
        JSONObject jSONObject = new JSONObject(loadParams.toString());
        jSONObject.put(C3040d4.h.y0, String.valueOf(this.g));
        this.b.a(activity, jSONObject);
    }

    /* renamed from: com.ironsource.z8$c */
    public static final class c implements E8.a {

        /* renamed from: com.ironsource.z8$c$a */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3964a;

            static {
                int[] iArr = new int[E8.b.values().length];
                try {
                    iArr[E8.b.PrivacyIcon.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f3964a = iArr;
            }
        }

        c() {
        }

        @Override // com.ironsource.E8.a
        public void a(E8.b viewName) {
            Intrinsics.checkNotNullParameter(viewName, "viewName");
            if (a.f3964a[viewName.ordinal()] == 1) {
                C3416z8.this.b.c();
                return;
            }
            JSONObject clickParams = new JSONObject().put("viewName", viewName.b());
            Db db = C3416z8.this.b;
            Intrinsics.checkNotNullExpressionValue(clickParams, "clickParams");
            db.a(clickParams);
        }

        @Override // com.ironsource.E8.a
        public void a(ag viewVisibilityParams) {
            Intrinsics.checkNotNullParameter(viewVisibilityParams, "viewVisibilityParams");
            C3416z8.this.b.a(viewVisibilityParams);
        }
    }

    @Override // com.ironsource.D8
    public void a(E8 viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> a2 = d().a();
        Intrinsics.checkNotNullExpressionValue(a2, "baseEventParams().data");
        linkedHashMap.putAll(a2);
        String jSONObject = viewHolder.t().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "viewHolder.viewsStatus().toString()");
        linkedHashMap.put(D5.y, jSONObject);
        InterfaceC3280r8 interfaceC3280r8 = this.c;
        Md.a registerAd = Md.n;
        Intrinsics.checkNotNullExpressionValue(registerAd, "registerAd");
        interfaceC3280r8.a(registerAd, linkedHashMap);
        this.i = viewHolder;
        viewHolder.a(g());
        this.b.a(viewHolder);
    }

    @Override // com.ironsource.D8
    public void a() {
        E8 e8 = this.i;
        if (e8 != null) {
            e8.a((E8.a) null);
        }
        this.b.a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ C3416z8(String str, Db db, InterfaceC3280r8 interfaceC3280r8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, db, interfaceC3280r8);
        if ((i & 1) != 0) {
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        }
    }
}
