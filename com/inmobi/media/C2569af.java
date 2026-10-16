package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.af, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2569af extends Xe {
    public final GestureDetectorOnGestureListenerC2634ec e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2569af(GestureDetectorOnGestureListenerC2634ec mRenderView) {
        super(mRenderView);
        Intrinsics.checkNotNullParameter(mRenderView, "mRenderView");
        this.e = mRenderView;
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
    }

    @Override // com.inmobi.media.Xe
    public final View d() {
        this.c = new WeakReference(this.e);
        return this.e;
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
    }

    @Override // com.inmobi.media.Xe
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return d();
    }

    @Override // com.inmobi.media.Xe
    public final void a(View view, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(view, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        Map<View, FriendlyObstructionPurpose> friendlyViews = this.e.getFriendlyViews();
        if (friendlyViews != null) {
            friendlyViews.put(view, obstructionCode);
        }
        I exposureTracker = this.e.getExposureTracker();
        if (exposureTracker != null) {
            Intrinsics.checkNotNullParameter(view, "view");
            InterfaceC2971z5 interfaceC2971z5 = exposureTracker.e;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c("AdExposureTracker", "Adding friendly view: " + view);
            }
            Set set = exposureTracker.b;
            if (set != null) {
                set.add(view);
            }
        }
        this.e.getWebViewFactory().b(new Ye(view));
    }

    @Override // com.inmobi.media.Xe
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "childView");
        Map<View, FriendlyObstructionPurpose> friendlyViews = this.e.getFriendlyViews();
        if (friendlyViews != null) {
            friendlyViews.remove(view);
        }
        I exposureTracker = this.e.getExposureTracker();
        if (exposureTracker != null) {
            Intrinsics.checkNotNullParameter(view, "view");
            InterfaceC2971z5 interfaceC2971z5 = exposureTracker.e;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).c("AdExposureTracker", "Removing friendly view: " + view);
            }
            Set set = exposureTracker.b;
            if (set != null) {
                set.remove(view);
            }
        }
        this.e.getWebViewFactory().b(new Ze(view));
    }
}
