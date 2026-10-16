package com.inmobi.media;

import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.r9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2843r9 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f2694a = new LinkedList();
    public int b;
    public int c;
    public final /* synthetic */ D9 d;

    public AbstractC2843r9(D9 d9) {
        this.d = d9;
    }

    public abstract View a(Context context);

    public void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        HashMap hashMap = D9.c;
        C2779n9.a(view);
        view.setOnClickListener(null);
        this.f2694a.add(view);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        this.d.f2263a++;
    }

    public final String toString() {
        return "Size:" + this.f2694a.size() + " Miss Count:" + this.b + " Hit Count:" + this.c;
    }

    public void a(View view, C2613d8 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        view.setVisibility(asset.v);
        view.setOnClickListener(null);
    }
}
