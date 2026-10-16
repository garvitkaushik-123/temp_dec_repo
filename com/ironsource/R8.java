package com.ironsource;

import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import java.io.File;
import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class R8 implements S8 {

    /* renamed from: a, reason: collision with root package name */
    private final W3 f3027a;

    /* JADX WARN: Multi-variable type inference failed */
    public R8() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Object b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("file does not exists")));
        }
        Drawable createFromPath = Drawable.createFromPath(file.getPath());
        if (createFromPath == null) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("failed to create a drawable")));
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m10241constructorimpl(createFromPath);
    }

    private final Object c(String str) {
        InputStream a2 = this.f3027a.a(str);
        try {
            Drawable createFromStream = Drawable.createFromStream(a2, new File(str).getName());
            CloseableKt.closeFinally(a2, null);
            if (createFromStream == null) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("failed to create a drawable")));
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(createFromStream);
        } finally {
        }
    }

    private final boolean d(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    @Override // com.ironsource.S8
    public Object a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            return d(url) ? c(url) : b(url);
        } catch (Exception e) {
            C3260q4.d().a(e);
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(e));
        }
    }

    public R8(W3 connectionFactory) {
        Intrinsics.checkNotNullParameter(connectionFactory, "connectionFactory");
        this.f3027a = connectionFactory;
    }

    public /* synthetic */ R8(W3 w3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? K4.f2923a : w3);
    }
}
