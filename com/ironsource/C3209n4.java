package com.ironsource;

import android.util.Log;
import com.ironsource.InterfaceC3175l4;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import kotlin.Result;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* renamed from: com.ironsource.n4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3209n4 implements InterfaceC3313t7 {

    /* renamed from: a, reason: collision with root package name */
    private final C3158k4 f3598a;
    private final Function1<C3382x8, Object> b;
    private final InterfaceC3398y7 c;
    private final InterfaceC3293s4 d;
    private final String e;
    private C3382x8 f;
    private long g;
    private final Mc h;
    private String i;

    /* renamed from: com.ironsource.n4$a */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Result<? extends C3382x8>, Unit> {
        a(Object obj) {
            super(1, obj, C3209n4.class, "onHtmlDownloadFinished", "onHtmlDownloadFinished(Ljava/lang/Object;)V", 0);
        }

        public final void a(Object obj) {
            ((C3209n4) this.receiver).b(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends C3382x8> result) {
            a(result.getValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.ironsource.n4$b */
    /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Result<? extends JSONObject>, Unit> {
        b(Object obj) {
            super(1, obj, C3209n4.class, "onAbTestDownloadFinished", "onAbTestDownloadFinished(Ljava/lang/Object;)V", 0);
        }

        public final void a(Object obj) {
            ((C3209n4) this.receiver).a(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Result<? extends JSONObject> result) {
            a(result.getValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3209n4(C3158k4 config, Function1<? super C3382x8, ? extends Object> onFinish, InterfaceC3398y7 downloadManager, InterfaceC3293s4 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.f3598a = config;
        this.b = onFinish;
        this.c = downloadManager;
        this.d = currentTimeProvider;
        this.e = "n4";
        this.f = new C3382x8(config.d(), "mobileController_0.html");
        this.g = currentTimeProvider.a();
        this.h = new Mc(config.a());
        this.i = "";
    }

    @Override // com.ironsource.InterfaceC3313t7
    public C3382x8 c() {
        return this.f;
    }

    public final Function1<C3382x8, Object> d() {
        return this.b;
    }

    public final InterfaceC3293s4 a() {
        return this.d;
    }

    @Override // com.ironsource.InterfaceC3313t7
    public void b() {
        this.g = this.d.a();
        new C3015c(new C3035d(this.h), this.f3598a.d() + "/temp", this.c, new b(this)).m();
    }

    @Override // com.ironsource.InterfaceC3313t7
    public boolean a(C3382x8 file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        return new Regex("mobileController(_\\d+)?\\.html").matches(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Object obj) {
        if (Result.m10247isFailureimpl(obj)) {
            obj = null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null && !Intrinsics.areEqual(jSONObject.optString("htmlBuildNumber"), "")) {
            SDKUtils.updateControllerConfig("abTestMap", jSONObject);
            String string = jSONObject.getString("htmlBuildNumber");
            Intrinsics.checkNotNullExpressionValue(string, "abTestMapAsJson.getString(\"htmlBuildNumber\")");
            this.i = string;
            C3192m4 a2 = a(string);
            if (a2.j()) {
                C3382x8 k = a2.k();
                this.f = k;
                this.b.invoke(k);
                return;
            }
            a2.m();
            return;
        }
        a("0").m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Object obj) {
        if (Result.m10248isSuccessimpl(obj)) {
            C3382x8 c3382x8 = (C3382x8) (Result.m10247isFailureimpl(obj) ? null : obj);
            if (!Intrinsics.areEqual(c3382x8 != null ? c3382x8.getAbsolutePath() : null, this.f.getAbsolutePath())) {
                try {
                    IronSourceStorageUtils.deleteFile(this.f);
                    Intrinsics.checkNotNull(c3382x8);
                    FilesKt.copyTo$default(c3382x8, this.f, true, 0, 4, null);
                } catch (Exception e) {
                    C3260q4.d().a(e);
                    Log.e(this.e, "Unable to copy downloaded mobileController.html to cache folder: " + e.getMessage());
                }
                Intrinsics.checkNotNull(c3382x8);
                this.f = c3382x8;
            }
            new InterfaceC3175l4.b(this.f3598a.b(), this.g, this.d).a();
        } else {
            new InterfaceC3175l4.a(this.f3598a.b()).a();
        }
        Function1<C3382x8, Object> function1 = this.b;
        if (Result.m10247isFailureimpl(obj)) {
            obj = null;
        }
        function1.invoke(obj);
    }

    private final C3192m4 a(String str) {
        return new C3192m4(new Wf(this.h, str), this.f3598a.d() + "/mobileController_" + str + ".html", this.c, new a(this));
    }
}
