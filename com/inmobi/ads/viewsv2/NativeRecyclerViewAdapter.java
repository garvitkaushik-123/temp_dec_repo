package com.inmobi.ads.viewsv2;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.inmobi.media.C2681h8;
import com.inmobi.media.C2811p8;
import com.inmobi.media.D8;
import com.inmobi.media.I8;
import com.inmobi.media.L8;
import com.ironsource.C3040d4;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00122\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00122\n\u0010\u0010\u001a\u00060\u0002R\u00020\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/inmobi/ads/viewsv2/NativeRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/inmobi/media/I8;", "Lcom/inmobi/media/L8;", "Lcom/inmobi/media/p8;", "nativeDataModel", "Lcom/inmobi/media/D8;", "nativeLayoutInflater", "<init>", "(Lcom/inmobi/media/p8;Lcom/inmobi/media/D8;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/inmobi/media/I8;", "holder", C3040d4.h.L, "", "onBindViewHolder", "(Lcom/inmobi/media/I8;I)V", "onViewRecycled", "(Lcom/inmobi/media/I8;)V", "Lcom/inmobi/media/h8;", "pageContainerAsset", "buildScrollableView", "(ILandroid/view/ViewGroup;Lcom/inmobi/media/h8;)Landroid/view/ViewGroup;", "getItemCount", "()I", "destroy", "()V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeRecyclerViewAdapter extends RecyclerView.Adapter<I8> implements L8 {

    /* renamed from: a, reason: collision with root package name */
    public C2811p8 f2224a;
    public D8 b;
    public final SparseArray c;

    public NativeRecyclerViewAdapter(C2811p8 nativeDataModel, D8 nativeLayoutInflater) {
        Intrinsics.checkNotNullParameter(nativeDataModel, "nativeDataModel");
        Intrinsics.checkNotNullParameter(nativeLayoutInflater, "nativeLayoutInflater");
        this.f2224a = nativeDataModel;
        this.b = nativeLayoutInflater;
        this.c = new SparseArray();
    }

    public ViewGroup buildScrollableView(int position, ViewGroup parent, C2681h8 pageContainerAsset) {
        D8 d8;
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(pageContainerAsset, "pageContainerAsset");
        D8 d82 = this.b;
        ViewGroup container = d82 != null ? d82.a(parent, pageContainerAsset) : null;
        if (container != null && (d8 = this.b) != null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(pageContainerAsset, "root");
            d8.b(container, pageContainerAsset);
        }
        return container;
    }

    @Override // com.inmobi.media.L8
    public void destroy() {
        C2811p8 c2811p8 = this.f2224a;
        if (c2811p8 != null) {
            c2811p8.l = null;
            c2811p8.g = null;
        }
        this.f2224a = null;
        this.b = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        C2811p8 c2811p8 = this.f2224a;
        if (c2811p8 != null) {
            return c2811p8.d();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(I8 holder, int position) {
        View buildScrollableView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        C2811p8 c2811p8 = this.f2224a;
        C2681h8 b = c2811p8 != null ? c2811p8.b(position) : null;
        WeakReference weakReference = (WeakReference) this.c.get(position);
        if (b != null) {
            if (weakReference == null || (buildScrollableView = (View) weakReference.get()) == null) {
                buildScrollableView = buildScrollableView(position, holder.f2314a, b);
            }
            if (buildScrollableView != null) {
                if (position != getItemCount() - 1) {
                    holder.f2314a.setPadding(0, 0, 16, 0);
                }
                holder.f2314a.addView(buildScrollableView);
                this.c.put(position, new WeakReference(buildScrollableView));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public I8 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new I8(new FrameLayout(parent.getContext()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(I8 holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.f2314a.removeAllViews();
        super.onViewRecycled((NativeRecyclerViewAdapter) holder);
    }
}
