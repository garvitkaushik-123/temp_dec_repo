package io.bidmachine.rendering.internal;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedCallback;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.util.UiUtilsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0003¨\u0006\f"}, d2 = {"Lio/bidmachine/rendering/internal/a;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: io.bidmachine.rendering.internal.a, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class ActivityC3588a extends Activity {
    protected void a() {
    }

    protected void b() {
        UiUtilsKt.setActivityBackgroundColor(this, -16777216);
        UiUtilsKt.setNoActivityTransition(this);
    }

    @Override // android.app.Activity
    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "onBackPressedExecuted()", imports = {}))
    public void onBackPressed() {
        a();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        b();
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new OnBackInvokedCallback() { // from class: io.bidmachine.rendering.internal.a$$ExternalSyntheticLambda0
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    ActivityC3588a.a(ActivityC3588a.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ActivityC3588a this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }
}
