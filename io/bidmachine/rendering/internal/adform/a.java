package io.bidmachine.rendering.internal.adform;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3061e8;
import com.ironsource.D5;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.rendering.internal.A;
import io.bidmachine.rendering.internal.InterfaceC3590c;
import io.bidmachine.rendering.internal.e;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.internal.y;
import io.bidmachine.rendering.internal.z;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdElementType;
import io.bidmachine.rendering.model.AppearanceParams;
import io.bidmachine.rendering.model.Background;
import io.bidmachine.rendering.model.Border;
import io.bidmachine.rendering.model.Padding;
import io.bidmachine.rendering.model.PaddingKt;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.rendering.utils.VisibilityChanger;
import io.bidmachine.util.ViewUtilsKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00142\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\"B9\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u0018J!\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020!H\u0016¢\u0006\u0004\b&\u0010%J\u000f\u0010'\u001a\u00020!H\u0017¢\u0006\u0004\b'\u0010%J\u000f\u0010(\u001a\u00020!H\u0007¢\u0006\u0004\b(\u0010%J\u000f\u0010)\u001a\u00020!H\u0016¢\u0006\u0004\b)\u0010%J\u0019\u0010*\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0017¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020!H\u0017¢\u0006\u0004\b,\u0010%J\u0017\u0010.\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0016H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020!2\u0006\u0010-\u001a\u00020\u0016H\u0016¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020!H\u0016¢\u0006\u0004\b1\u0010%J\r\u00102\u001a\u00020!¢\u0006\u0004\b2\u0010%J\u0015\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b\"\u0010+J\r\u00103\u001a\u00020!¢\u0006\u0004\b3\u0010%J\u000f\u00104\u001a\u00020\u0013H\u0016¢\u0006\u0004\b4\u0010\u0015J\u000f\u0010\"\u001a\u00020!H\u0017¢\u0006\u0004\b\"\u0010%J\u000f\u00105\u001a\u00020!H\u0014¢\u0006\u0004\b5\u0010%J\u0017\u00107\u001a\u00020!2\u0006\u00106\u001a\u00020\u0013H\u0004¢\u0006\u0004\b7\u00108R\u001a\u0010\b\u001a\u00020\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b$\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010\f\u001a\u00020\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010DR\u0017\u0010I\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010N\u001a\u00020J8\u0006¢\u0006\f\n\u0004\b>\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010OR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010XR\u0016\u0010[\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010XR\u0016\u0010]\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010X¨\u0006^"}, d2 = {"Lio/bidmachine/rendering/internal/adform/a;", "Lio/bidmachine/rendering/internal/y;", "Lio/bidmachine/rendering/internal/c;", "Landroid/view/View$OnClickListener;", "Lio/bidmachine/rendering/utils/VisibilityChanger;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/internal/repository/a;", "repository", "Lio/bidmachine/rendering/model/AdElementParams;", "adElementParams", "Lio/bidmachine/rendering/internal/adform/c;", "adFormListener", "Lio/bidmachine/rendering/internal/event/b;", "eventCallback", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "brokenCreativeDetector", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/internal/repository/a;Lio/bidmachine/rendering/model/AdElementParams;Lio/bidmachine/rendering/internal/adform/c;Lio/bidmachine/rendering/internal/event/b;Lio/bidmachine/rendering/internal/detector/brokencreative/a;)V", "", "p", "()Ljava/lang/String;", "", "i", "()Z", "Landroid/view/View;", j.b, "()Landroid/view/View;", "v", "B", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Lio/bidmachine/rendering/internal/z;", "viewBackgroundSetter", "", "a", "(Landroid/view/View;Lio/bidmachine/rendering/internal/z;)V", "d", "()V", InneractiveMediationDefs.GENDER_FEMALE, "z", VastAttributes.VERTICAL_POSITION, "m", "onClick", "(Landroid/view/View;)V", "w", C3061e8.k, "setVisibility", "(Z)V", "lockVisibility", "unlockVisibility", CampaignEx.JSON_KEY_AD_Q, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "toString", VastAttributes.HORIZONTAL_POSITION, PglCryptUtils.KEY_MESSAGE, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)V", "c", "Lio/bidmachine/rendering/internal/repository/a;", "u", "()Lio/bidmachine/rendering/internal/repository/a;", "Lio/bidmachine/rendering/model/AdElementParams;", "h", "()Lio/bidmachine/rendering/model/AdElementParams;", "e", "Lio/bidmachine/rendering/internal/adform/c;", "r", "()Lio/bidmachine/rendering/internal/adform/c;", "Lio/bidmachine/rendering/internal/detector/brokencreative/a;", "g", "Landroid/content/Context;", "t", "()Landroid/content/Context;", "applicationContext", "Lio/bidmachine/rendering/model/AppearanceParams;", "Lio/bidmachine/rendering/model/AppearanceParams;", "s", "()Lio/bidmachine/rendering/model/AppearanceParams;", "appearanceParams", "Lio/bidmachine/rendering/internal/z;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isViewOnScreen", "Landroid/view/ViewGroup;", CampaignEx.JSON_KEY_AD_K, "Landroid/view/ViewGroup;", "container", "l", "Z", C3061e8.m, D5.q, "isVisibilityLocked", "o", "lastAcceptedVisible", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public abstract class a extends y implements InterfaceC3590c, View.OnClickListener, VisibilityChanger {
    private static final AdElementType[] q = {AdElementType.Image, AdElementType.Label};

    /* renamed from: c, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.repository.a repository;

    /* renamed from: d, reason: from kotlin metadata */
    private final AdElementParams adElementParams;

    /* renamed from: e, reason: from kotlin metadata */
    private final c adFormListener;

    /* renamed from: f, reason: from kotlin metadata */
    private final io.bidmachine.rendering.internal.detector.brokencreative.a brokenCreativeDetector;

    /* renamed from: g, reason: from kotlin metadata */
    private final Context applicationContext;

    /* renamed from: h, reason: from kotlin metadata */
    private final AppearanceParams appearanceParams;

    /* renamed from: i, reason: from kotlin metadata */
    private final z viewBackgroundSetter;

    /* renamed from: j, reason: from kotlin metadata */
    private final AtomicBoolean isViewOnScreen;

    /* renamed from: k, reason: from kotlin metadata */
    private ViewGroup container;

    /* renamed from: l, reason: from kotlin metadata */
    private volatile boolean isShown;

    /* renamed from: m, reason: from kotlin metadata */
    private volatile boolean isVisible;

    /* renamed from: n, reason: from kotlin metadata */
    private volatile boolean isVisibilityLocked;

    /* renamed from: o, reason: from kotlin metadata */
    private volatile boolean lastAcceptedVisible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, io.bidmachine.rendering.internal.repository.a repository, AdElementParams adElementParams, c adFormListener, io.bidmachine.rendering.internal.event.b eventCallback, io.bidmachine.rendering.internal.detector.brokencreative.a aVar) {
        super(eventCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(adElementParams, "adElementParams");
        Intrinsics.checkNotNullParameter(adFormListener, "adFormListener");
        Intrinsics.checkNotNullParameter(eventCallback, "eventCallback");
        this.repository = repository;
        this.adElementParams = adElementParams;
        this.adFormListener = adFormListener;
        this.brokenCreativeDetector = aVar;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.applicationContext = applicationContext;
        AppearanceParams appearanceParams = adElementParams.getAppearanceParams();
        this.appearanceParams = appearanceParams;
        Background background = appearanceParams.getBackground();
        this.viewBackgroundSetter = background != null ? A.a(background, applicationContext, repository) : null;
        this.isViewOnScreen = new AtomicBoolean(false);
        this.isVisible = true;
        this.lastAcceptedVisible = this.isVisible;
    }

    public final void A() {
        io.bidmachine.rendering.internal.detector.brokencreative.a aVar = this.brokenCreativeDetector;
        if (aVar != null) {
            aVar.i();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean B() {
        View v = v();
        if (v == 0) {
            return false;
        }
        Padding padding = this.appearanceParams.getIo.bidmachine.iab.vast.tags.VastAttributes.PADDING java.lang.String();
        if (padding != null && !padding.isZero()) {
            FrameLayout frameLayout = new FrameLayout(this.applicationContext);
            frameLayout.setId(UiUtils.generateViewId());
            PaddingKt.setPadding(frameLayout, padding);
            frameLayout.addView(v, new FrameLayout.LayoutParams(-1, -1));
            this.container = frameLayout;
        }
        View j = j();
        if (j == null) {
            return false;
        }
        j.setId(UiUtils.generateViewId());
        j.setTag(this.adElementParams.getName());
        Boolean clickable = this.appearanceParams.getClickable();
        if (clickable != null && clickable.booleanValue()) {
            j.setOnClickListener(this);
        }
        Boolean bool = this.appearanceParams.getIo.bidmachine.iab.vast.tags.VastAttributes.VISIBLE java.lang.String();
        if (bool != null) {
            setVisibility(bool.booleanValue());
        }
        if (v instanceof e) {
            ((e) v).a(this.appearanceParams);
            return true;
        }
        a(v, this.viewBackgroundSetter);
        return true;
    }

    protected void a(View view, z viewBackgroundSetter) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (viewBackgroundSetter != null) {
            z.a(viewBackgroundSetter, view, (Integer) null, (Border) null, 6, (Object) null);
            return;
        }
        Integer backgroundColor = this.appearanceParams.getBackgroundColor();
        if (backgroundColor == null || ArraysKt.contains(q, this.adElementParams.getAdElementType())) {
            return;
        }
        ViewUtilsKt.setBackgroundColorSafely(view, backgroundColor);
    }

    protected final void b(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        o.a(p(), message, new Object[0]);
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void d() {
        z();
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void f() {
        y();
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    /* renamed from: h, reason: from getter */
    public final AdElementParams getAdElementParams() {
        return this.adElementParams;
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    /* renamed from: i, reason: from getter */
    public boolean getLastAcceptedVisible() {
        return this.lastAcceptedVisible;
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public View j() {
        ViewGroup viewGroup = this.container;
        return viewGroup != null ? viewGroup : v();
    }

    @Override // io.bidmachine.rendering.utils.VisibilityChanger
    public void lockVisibility(boolean isVisible) {
        setVisibility(isVisible);
        this.isVisibilityLocked = true;
    }

    @Override // io.bidmachine.rendering.internal.InterfaceC3590c
    public void m() {
        w();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w();
    }

    @Override // io.bidmachine.rendering.internal.y
    public String p() {
        return this.adElementParams.getName();
    }

    public final void q() {
        View v = v();
        if (v == null) {
            return;
        }
        if (this.lastAcceptedVisible && this.isShown) {
            if (this.isViewOnScreen.compareAndSet(false, true)) {
                a(v);
            }
        } else if (this.isViewOnScreen.compareAndSet(true, false)) {
            A();
        }
    }

    /* renamed from: r, reason: from getter */
    protected final c getAdFormListener() {
        return this.adFormListener;
    }

    /* renamed from: s, reason: from getter */
    public final AppearanceParams getAppearanceParams() {
        return this.appearanceParams;
    }

    @Override // io.bidmachine.rendering.utils.VisibilityChanger
    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
        if (this.isVisibilityLocked) {
            return;
        }
        if (isVisible) {
            ViewUtilsKt.showViewSafely(j());
        } else {
            ViewUtilsKt.hideViewSafely(j());
        }
        this.lastAcceptedVisible = isVisible;
        q();
    }

    /* renamed from: t, reason: from getter */
    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    public String toString() {
        return "type - " + this.adElementParams.getAdElementType() + ", name - " + this.adElementParams.getName();
    }

    /* renamed from: u, reason: from getter */
    protected final io.bidmachine.rendering.internal.repository.a getRepository() {
        return this.repository;
    }

    @Override // io.bidmachine.rendering.utils.VisibilityChanger
    public void unlockVisibility() {
        this.isVisibilityLocked = false;
        setVisibility(this.isVisible);
    }

    public abstract View v();

    public void w() {
        io.bidmachine.rendering.internal.event.b o = o();
        View v = v();
        o.a(v != null ? v.getId() : -1);
    }

    protected void x() {
    }

    public final void y() {
        this.isShown = false;
        q();
    }

    public void z() {
        this.isShown = true;
        q();
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        io.bidmachine.rendering.internal.detector.brokencreative.a aVar = this.brokenCreativeDetector;
        if (aVar != null) {
            aVar.a(view);
        }
        this.adFormListener.a(this);
    }

    @Override // io.bidmachine.rendering.internal.y, io.bidmachine.rendering.internal.InterfaceC3590c
    public void a() {
        super.a();
        io.bidmachine.rendering.internal.detector.brokencreative.a aVar = this.brokenCreativeDetector;
        if (aVar != null) {
            aVar.c();
        }
        x();
    }
}
