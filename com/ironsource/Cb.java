package com.ironsource;

import android.app.Activity;
import com.ironsource.B8;
import com.ironsource.C3040d4;
import com.ironsource.Db;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.utils.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class Cb implements Db {

    /* renamed from: a, reason: collision with root package name */
    private final String f2816a;
    private final com.ironsource.sdk.controller.e b;
    private final S8 c;
    private final InterfaceC2983a1 d;
    private final String e;
    private Db.a f;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2817a = new a();
        public static final String b = "nativeAd.load";
        public static final String c = "nativeAd.loadReport";
        public static final String d = "nativeAd.register";
        public static final String e = "nativeAd.click";
        public static final String f = "nativeAd.privacyClick";
        public static final String g = "nativeAd.visibilityChanged";
        public static final String h = "nativeAd.destroy";

        private a() {
        }
    }

    public Cb(String id, com.ironsource.sdk.controller.e controllerManager, S8 imageLoader, InterfaceC2983a1 adViewManagement) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(adViewManagement, "adViewManagement");
        this.f2816a = id;
        this.b = controllerManager;
        this.c = imageLoader;
        this.d = adViewManagement;
        this.e = "Cb";
        controllerManager.a(id, d());
    }

    private final l.b d() {
        return new l.b() { // from class: com.ironsource.Cb$$ExternalSyntheticLambda0
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(C3368wb c3368wb) {
                Cb.a(Cb.this, c3368wb);
            }
        };
    }

    private final JSONObject e() {
        JSONObject put = new JSONObject().put(f.b.g, a.e).put("sdkCallback", C3040d4.g.U);
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n        .pu…hods.ON_RECEIVED_MESSAGE)");
        return put;
    }

    @Override // com.ironsource.Db
    public void a(Db.a aVar) {
        this.f = aVar;
    }

    @Override // com.ironsource.Db
    public Db.a b() {
        return this.f;
    }

    @Override // com.ironsource.Db
    public void c() {
        this.b.a(new f.c(this.f2816a, a.f, new JSONObject()), (l.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Cb this$0, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.b(it);
    }

    @Override // com.ironsource.Db
    public void a(final Activity activity, JSONObject loadParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loadParams, "loadParams");
        this.b.a(activity);
        this.b.a(new f.c(this.f2816a, a.b, loadParams), new l.a() { // from class: com.ironsource.Cb$$ExternalSyntheticLambda3
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                Cb.a(Cb.this, activity, aVar);
            }
        });
    }

    private final void b(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.e, "failed to handle show on native ad: missing params");
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            Logger.i(this.e, "failed to handle show on native ad: " + aVar.d().optString("reason", "unexpected error"));
        } else {
            Db.a b = b();
            if (b != null) {
                b.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Cb this$0, Activity activity, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.a(activity, it);
    }

    private final void a(Activity activity, f.a aVar) {
        if (aVar.d() == null) {
            Db.a b = b();
            if (b != null) {
                b.a("failed to load native ad: missing params");
                return;
            }
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            String reason = aVar.d().optString("reason", "failed to load native ad: unexpected error");
            Db.a b2 = b();
            if (b2 != null) {
                Intrinsics.checkNotNullExpressionValue(reason, "reason");
                b2.a(reason);
                return;
            }
            return;
        }
        B8.b a2 = new B8.a(this.c, this.d).a(activity, aVar.d());
        a(a2, a2.a().h());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Cb(String str, com.ironsource.sdk.controller.e eVar, S8 s8, InterfaceC2983a1 interfaceC2983a1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, eVar, s8, interfaceC2983a1);
        s8 = (i & 4) != 0 ? new R8(null, 1, null) : s8;
        if ((i & 8) != 0) {
            interfaceC2983a1 = C3179l8.a();
            Intrinsics.checkNotNullExpressionValue(interfaceC2983a1, "getInstance()");
        }
    }

    private final void a(B8.b bVar, final B8 b8) {
        this.b.a(new f.c(this.f2816a, "nativeAd.loadReport." + this.f2816a, bVar.b()), new l.a() { // from class: com.ironsource.Cb$$ExternalSyntheticLambda2
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                Cb.a(Cb.this, b8, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Cb this$0, B8 adData, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adData, "$adData");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.a(adData, it);
    }

    private final void a(B8 b8, f.a aVar) {
        if (aVar.d() == null) {
            Db.a b = b();
            if (b != null) {
                b.a("failed to load native ad: missing report params");
                return;
            }
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            String reason = aVar.d().optString("reason", "failed to load native ad: unexpected error");
            Db.a b2 = b();
            if (b2 != null) {
                Intrinsics.checkNotNullExpressionValue(reason, "reason");
                b2.a(reason);
                return;
            }
            return;
        }
        Db.a b3 = b();
        if (b3 != null) {
            b3.a(b8);
        }
    }

    @Override // com.ironsource.Db
    public void a() {
        this.b.a(new f.c(this.f2816a, a.h, new JSONObject()), (l.a) null);
    }

    @Override // com.ironsource.Db
    public void a(E8 viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        JSONObject params = new JSONObject().put("assetViews", viewHolder.t()).put("adViewClickCommand", e());
        String str = this.f2816a;
        Intrinsics.checkNotNullExpressionValue(params, "params");
        this.b.a(new f.c(str, a.d, params), (l.a) null);
    }

    @Override // com.ironsource.Db
    public void a(ag viewVisibilityParams) {
        Intrinsics.checkNotNullParameter(viewVisibilityParams, "viewVisibilityParams");
        this.b.a(new f.c(this.f2816a, a.g, viewVisibilityParams.g()), new l.a() { // from class: com.ironsource.Cb$$ExternalSyntheticLambda4
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                Cb.b(Cb.this, aVar);
            }
        });
    }

    @Override // com.ironsource.Db
    public void a(JSONObject clickParams) {
        Intrinsics.checkNotNullParameter(clickParams, "clickParams");
        this.b.a(new f.c(this.f2816a, a.e, clickParams), new l.a() { // from class: com.ironsource.Cb$$ExternalSyntheticLambda1
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                Cb.a(Cb.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Cb this$0, f.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.a(it);
    }

    private final void a(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.e, "failed to handle click on native ad: missing params");
            return;
        }
        if (!aVar.d().optBoolean("success", false)) {
            Logger.i(this.e, "failed to handle click on native ad: " + aVar.d().optString("reason", "unexpected error"));
        } else {
            Db.a b = b();
            if (b != null) {
                b.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Cb this$0, C3368wb msg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Intrinsics.areEqual(msg.e(), a.e)) {
            this$0.a(msg);
        }
    }

    private final void a(C3368wb c3368wb) {
        if (c3368wb.f() == null) {
            Logger.i(this.e, "failed to handle click on native ad: missing params");
            return;
        }
        if (!c3368wb.f().optBoolean("success", false)) {
            Logger.i(this.e, "failed to handle click on native ad: " + c3368wb.f().optString("reason", "unexpected error"));
        } else {
            Db.a b = b();
            if (b != null) {
                b.g();
            }
        }
    }
}
