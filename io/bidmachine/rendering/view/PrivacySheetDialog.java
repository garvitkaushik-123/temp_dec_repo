package io.bidmachine.rendering.view;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.ironsource.C3207n2;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.R;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.util.IntentUtilsKt;
import io.bidmachine.util.UtilsKt;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u000b\u0010\u0011J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\u0015J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0019\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001cR\u001b\u0010 \u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b\u000b\u0010\u001f\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lio/bidmachine/rendering/view/PrivacySheetDialog;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "<init>", "(Landroid/content/Context;Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Landroid/view/Window;", "window", "", "a", "(Landroid/view/Window;)V", "params", "(Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "Lio/bidmachine/rendering/model/PrivacySheetParams$Action;", "action", "(Lio/bidmachine/rendering/model/PrivacySheetParams$Action;)V", "", "data", "Lkotlin/Result;", "(Ljava/lang/String;)Ljava/lang/Object;", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "Lio/bidmachine/rendering/internal/view/privacy/b;", "Lkotlin/Lazy;", "()Lio/bidmachine/rendering/internal/view/privacy/b;", "privacySheetLayout", "Companion", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class PrivacySheetDialog extends Dialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<PrivacySheetDialog> c = new WeakReference<>(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PrivacySheetParams privacySheetParams;

    /* renamed from: b, reason: from kotlin metadata */
    private final Lazy privacySheetLayout;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/bidmachine/rendering/view/PrivacySheetDialog$Companion;", "", "()V", "lastPrivacySheetDialogRef", "Ljava/lang/ref/WeakReference;", "Lio/bidmachine/rendering/view/PrivacySheetDialog;", C3207n2.v, "context", "Landroid/content/Context;", "privacySheetParams", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PrivacySheetDialog show(Context context, PrivacySheetParams privacySheetParams) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
            PrivacySheetDialog privacySheetDialog = (PrivacySheetDialog) PrivacySheetDialog.c.get();
            if (privacySheetDialog != null && privacySheetDialog.isShowing()) {
                if (Intrinsics.areEqual(privacySheetDialog.privacySheetParams, privacySheetParams)) {
                    return privacySheetDialog;
                }
                privacySheetDialog.dismiss();
            }
            PrivacySheetDialog privacySheetDialog2 = new PrivacySheetDialog(context, privacySheetParams, null);
            PrivacySheetDialog.c = new WeakReference(privacySheetDialog2);
            try {
                privacySheetDialog2.show();
                return privacySheetDialog2;
            } catch (Throwable th) {
                o.b(th);
                return privacySheetDialog2;
            }
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrivacySheetParams.ActionType.values().length];
            try {
                iArr[PrivacySheetParams.ActionType.REDIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrivacySheetParams.ActionType.COPY_TO_CLIPBOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        public final void a() {
            PrivacySheetDialog.this.dismiss();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/bidmachine/rendering/internal/view/privacy/b;", "a", "()Lio/bidmachine/rendering/internal/view/privacy/b;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<io.bidmachine.rendering.internal.view.privacy.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7204a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.f7204a = context;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.bidmachine.rendering.internal.view.privacy.b invoke() {
            return new io.bidmachine.rendering.internal.view.privacy.b(this.f7204a);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()V"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ PrivacySheetParams.Action b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PrivacySheetParams.Action action) {
            super(0);
            this.b = action;
        }

        public final void a() {
            PrivacySheetDialog.this.a(this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ PrivacySheetDialog(Context context, PrivacySheetParams privacySheetParams, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, privacySheetParams);
    }

    private final io.bidmachine.rendering.internal.view.privacy.b a() {
        return (io.bidmachine.rendering.internal.view.privacy.b) this.privacySheetLayout.getValue();
    }

    private final Object b(String data) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return Result.m10241constructorimpl(Boolean.valueOf(IntentUtilsKt.openUrl(context, data)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    @JvmStatic
    public static final PrivacySheetDialog show(Context context, PrivacySheetParams privacySheetParams) {
        return INSTANCE.show(context, privacySheetParams);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        io.bidmachine.rendering.internal.view.privacy.b a2 = a();
        a2.setOnCloseClickListener(new a());
        setContentView(a2);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
            a(window);
        }
        a(this.privacySheetParams);
    }

    private PrivacySheetDialog(Context context, PrivacySheetParams privacySheetParams) {
        super(context, R.style.Bm_BottomSheetDialog);
        this.privacySheetParams = privacySheetParams;
        this.privacySheetLayout = LazyKt.lazy(new b(context));
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
    }

    private final void a(Window window) {
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
        } else {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
        }
    }

    private final void a(PrivacySheetParams params) {
        io.bidmachine.rendering.internal.view.privacy.b a2 = a();
        a2.a();
        a2.setTitle(params.getTitle());
        a2.setSubtitle(params.getSubtitle());
        for (PrivacySheetParams.Action action : params.getActions()) {
            Bitmap icon = action.getIcon();
            a2.a(action.getTitle(), icon != null ? new BitmapDrawable(a2.getResources(), icon) : null, new c(action));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(PrivacySheetParams.Action action) {
        String data = action.getData();
        int i = WhenMappings.$EnumSwitchMapping$0[action.getType().ordinal()];
        if (i == 1) {
            b(data);
        } else {
            if (i != 2) {
                return;
            }
            a(data);
        }
    }

    private final Object a(String data) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ClipboardManager clipboardManager = UtilsKt.getClipboardManager(context);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", data));
            }
            return Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }
}
