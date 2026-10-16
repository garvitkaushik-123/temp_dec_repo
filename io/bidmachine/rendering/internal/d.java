package io.bidmachine.rendering.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.internal.view.e;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.Background;
import io.bidmachine.rendering.model.Border;
import io.bidmachine.rendering.model.ElementLayoutParams;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.ViewUtils;
import io.bidmachine.util.ViewUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0011\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0011\u0010\u0014J=\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0011\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR(\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010 \u001a\u0004\u0018\u00010\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#¨\u0006%"}, d2 = {"Lio/bidmachine/rendering/internal/d;", "", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdPhaseParams;", "adPhaseParams", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdPhaseParams;)V", "Landroid/view/ViewGroup;", "rootContainer", "", "Lio/bidmachine/rendering/internal/c;", com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "controls", "", "a", "(Landroid/view/ViewGroup;Ljava/util/List;Ljava/util/List;)Z", "", "()V", "Lio/bidmachine/rendering/internal/view/e;", "elementsContainer", "adElements", "adElement", "(Landroid/content/Context;Landroid/view/ViewGroup;Lio/bidmachine/rendering/internal/view/e;Ljava/util/List;Lio/bidmachine/rendering/internal/c;)V", "Lio/bidmachine/rendering/model/AdPhaseParams;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()Lio/bidmachine/rendering/model/AdPhaseParams;", "Lio/bidmachine/rendering/internal/z;", "Lio/bidmachine/rendering/internal/z;", "viewBackgroundSetter", "<set-?>", "c", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AdPhaseParams adPhaseParams;

    /* renamed from: b, reason: from kotlin metadata */
    private final z viewBackgroundSetter;

    /* renamed from: c, reason: from kotlin metadata */
    private ViewGroup view;

    public d(Context context, io.bidmachine.rendering.internal.repository.a repository, AdPhaseParams adPhaseParams) {
        z zVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adPhaseParams, "adPhaseParams");
        this.adPhaseParams = adPhaseParams;
        Background background = adPhaseParams.getBackground();
        if (background != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            zVar = A.a(background, applicationContext, repository);
        } else {
            zVar = null;
        }
        this.viewBackgroundSetter = zVar;
    }

    public final boolean a(ViewGroup rootContainer, List<? extends InterfaceC3590c> ads, List<? extends InterfaceC3590c> controls) {
        Intrinsics.checkNotNullParameter(rootContainer, "rootContainer");
        Intrinsics.checkNotNullParameter(ads, "ads");
        Intrinsics.checkNotNullParameter(controls, "controls");
        Context context = rootContainer.getContext();
        a();
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(UiUtils.generateViewId());
        z zVar = this.viewBackgroundSetter;
        if (zVar != null) {
            z.a(zVar, frameLayout, (Integer) null, (Border) null, 6, (Object) null);
        } else {
            ViewUtilsKt.setBackgroundColorSafely(frameLayout, this.adPhaseParams.getBackgroundColor());
        }
        this.view = frameLayout;
        io.bidmachine.rendering.internal.view.e eVar = new io.bidmachine.rendering.internal.view.e(context);
        for (InterfaceC3590c interfaceC3590c : ads) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a(context, rootContainer, eVar, ads, interfaceC3590c);
        }
        ViewGroup viewGroup = this.view;
        if (viewGroup != null) {
            viewGroup.addView(eVar, ViewUtils.createMatchParentParams());
        }
        io.bidmachine.rendering.internal.view.e eVar2 = new io.bidmachine.rendering.internal.view.e(context);
        for (InterfaceC3590c interfaceC3590c2 : controls) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a(context, rootContainer, eVar2, controls, interfaceC3590c2);
        }
        ViewGroup viewGroup2 = this.view;
        if (viewGroup2 != null) {
            viewGroup2.addView(eVar2, ViewUtils.createMatchParentParams());
        }
        rootContainer.addView(this.view, 0, ViewUtils.createMatchParentParams());
        return true;
    }

    /* renamed from: b, reason: from getter */
    public final AdPhaseParams getAdPhaseParams() {
        return this.adPhaseParams;
    }

    /* renamed from: c, reason: from getter */
    public final ViewGroup getView() {
        return this.view;
    }

    public final void a() {
        ViewGroup viewGroup = this.view;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            ViewUtilsKt.removeFromParent(viewGroup);
        }
        this.view = null;
    }

    public final void a(Context context, ViewGroup rootContainer, io.bidmachine.rendering.internal.view.e elementsContainer, List<? extends InterfaceC3590c> adElements, InterfaceC3590c adElement) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootContainer, "rootContainer");
        Intrinsics.checkNotNullParameter(elementsContainer, "elementsContainer");
        Intrinsics.checkNotNullParameter(adElements, "adElements");
        Intrinsics.checkNotNullParameter(adElement, "adElement");
        View j = adElement.j();
        if (j == null) {
            return;
        }
        ElementLayoutParams elementLayoutParams = adElement.h().getElementLayoutParams();
        int widthPx = elementLayoutParams.getWidthPx(context);
        int heightPx = elementLayoutParams.getHeightPx(context);
        if (widthPx <= 0) {
            widthPx = -1;
        }
        if (heightPx <= 0) {
            heightPx = -1;
        }
        e.a aVar = new e.a(widthPx, heightPx);
        aVar.a(context, elementLayoutParams, (List<InterfaceC3590c>) adElements);
        elementsContainer.addView(j, aVar);
        try {
            adElement.a(rootContainer);
        } catch (Throwable th) {
            o.b(th);
        }
    }
}
