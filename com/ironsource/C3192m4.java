package com.ironsource;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.m4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3192m4 implements InterfaceC3109h5<C3382x8> {

    /* renamed from: a, reason: collision with root package name */
    private final Y5 f3476a;
    private final String b;
    private final InterfaceC3398y7 c;
    private final Function1<Result<? extends C3382x8>, Unit> d;
    private C3382x8 e;

    /* JADX WARN: Multi-variable type inference failed */
    public C3192m4(Y5 fileUrl, String destinationPath, InterfaceC3398y7 downloadManager, Function1<? super Result<? extends C3382x8>, Unit> onFinish) {
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(destinationPath, "destinationPath");
        Intrinsics.checkNotNullParameter(downloadManager, "downloadManager");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        this.f3476a = fileUrl;
        this.b = destinationPath;
        this.c = downloadManager;
        this.d = onFinish;
        this.e = new C3382x8(c());
    }

    @Override // com.ironsource.InterfaceC3386xc
    public void a(C3382x8 file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Function1<Result<? extends C3382x8>, Unit> i = i();
        Result.Companion companion = Result.INSTANCE;
        i.invoke(Result.m10240boximpl(Result.m10241constructorimpl(file)));
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
        return this.f3476a;
    }

    @Override // com.ironsource.InterfaceC3109h5
    public Function1<Result<? extends C3382x8>, Unit> i() {
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

    @Override // com.ironsource.InterfaceC3386xc
    public void a(C3382x8 c3382x8, C3247p8 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Function1<Result<? extends C3382x8>, Unit> i = i();
        Result.Companion companion = Result.INSTANCE;
        i.invoke(Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(new Exception("Unable to download mobileController.html: " + error.b())))));
    }
}
