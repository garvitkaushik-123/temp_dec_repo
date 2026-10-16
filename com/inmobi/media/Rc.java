package com.inmobi.media;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.inmobi.ads.viewsv2.NativeRecyclerViewAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Rc extends K8 {
    public RecyclerView b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rc(Context context) {
        super(context, (byte) 1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.inmobi.media.K8
    public final void a(C2681h8 scrollableContainerAsset, L8 dataSource, int i, int i2, D8 d8) {
        Intrinsics.checkNotNullParameter(scrollableContainerAsset, "scrollableContainerAsset");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        RecyclerView recyclerView = new RecyclerView(getContext());
        this.b = recyclerView;
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(dataSource instanceof NativeRecyclerViewAdapter ? (NativeRecyclerViewAdapter) dataSource : null);
        addView(this.b);
    }
}
