package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.c, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3015c implements InterfaceC3109h5<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final Y5 f3208a;
    private final String b;
    private final InterfaceC3398y7 c;
    private final Function1<Result<? extends JSONObject>, Unit> d;
    private C3382x8 e;

    /* JADX WARN: Multi-variable type inference failed */
    public C3015c(Y5 fileUrl, String destinationPath, InterfaceC3398y7 downloadManager, Function1<? super Result<? extends JSONObject>, Unit> onFinish) {
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(destinationPath, "destinationPath");
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        this.f3208a = fileUrl;
        this.b = destinationPath;
        this.c = downloadManager;
        this.d = onFinish;
        this.e = new C3382x8(c(), C3040d4.h);
    }

    @Override // com.ironsource.InterfaceC3386xc
    public void a(C3382x8 file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (Intrinsics.areEqual(file.getName(), C3040d4.h)) {
            try {
                JSONObject c = c(file);
                Function1<Result<? extends JSONObject>, Unit> i = i();
                Result.Companion companion = Result.INSTANCE;
                i.invoke(Result.m10240boximpl(Result.m10241constructorimpl(c)));
            } catch (Exception e) {
                C3260q4.d().a(e);
                Function1<Result<? extends JSONObject>, Unit> i2 = i();
                Result.Companion companion2 = Result.INSTANCE;
                i2.invoke(Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(e))));
            }
        }
    }

    @Override // com.ironsource.InterfaceC3109h5
    public void b(C3382x8 c3382x8) {
        Intrinsics.checkNotNullParameter(c3382x8, "<set-?>");
        this.e = c3382x8;
    }

    @Override // com.ironsource.InterfaceC3109h5
    public String c() {
        return this.b;
    }

    @Override // com.ironsource.InterfaceC3109h5
    public Y5 d() {
        return this.f3208a;
    }

    @Override // com.ironsource.InterfaceC3109h5
    public Function1<Result<? extends JSONObject>, Unit> i() {
        return this.d;
    }

    @Override // com.ironsource.InterfaceC3109h5
    public C3382x8 k() {
        return this.e;
    }

    @Override // com.ironsource.InterfaceC3109h5
    public InterfaceC3398y7 l() {
        return this.c;
    }

    private final JSONObject c(C3382x8 c3382x8) {
        return new JSONObject(IronSourceStorageUtils.readFile(c3382x8));
    }

    @Override // com.ironsource.InterfaceC3386xc
    public void a(C3382x8 c3382x8, C3247p8 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Function1<Result<? extends JSONObject>, Unit> i = i();
        Result.Companion companion = Result.INSTANCE;
        i.invoke(Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(new Exception("Unable to download abTestMap.json: " + error.b())))));
    }
}
