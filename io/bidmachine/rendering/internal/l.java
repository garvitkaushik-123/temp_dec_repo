package io.bidmachine.rendering.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.iab.mraid.MraidCalendarEvent;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.Executable;
import io.bidmachine.util.IntentUtils;
import io.bidmachine.util.Utils;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\f\u0010\u0012J/\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0017J\u0017\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0018J/\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u0015\u0010\rJ-\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u0015\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001a¨\u0006\u001c"}, d2 = {"Lio/bidmachine/rendering/internal/l;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "uri", "Lio/bidmachine/util/Executable;", "", "postMethod", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Landroid/content/Context;Landroid/net/Uri;Lio/bidmachine/util/Executable;)V", "applicationContext", "c", "Lio/bidmachine/iab/mraid/MraidCalendarEvent;", "mraidCalendarEvent", "(Landroid/content/Context;Lio/bidmachine/iab/mraid/MraidCalendarEvent;Lio/bidmachine/util/Executable;)V", "Landroid/content/Intent;", "intent", "a", "(Landroid/content/Context;Landroid/content/Intent;Lio/bidmachine/util/Executable;)V", "(Landroid/content/Intent;)Landroid/content/Intent;", "(Lio/bidmachine/iab/mraid/MraidCalendarEvent;)Landroid/content/Intent;", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", "executorService", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ExecutorService executorService;

    public l() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.executorService = newSingleThreadExecutor;
    }

    private final void b(Context context, final Uri uri, final Executable<Boolean> postMethod) {
        final Context applicationContext = context.getApplicationContext();
        this.executorService.execute(new Runnable() { // from class: io.bidmachine.rendering.internal.l$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                l.a(l.this, applicationContext, uri, postMethod);
            }
        });
    }

    private final void c(Context applicationContext, Uri uri, Executable<Boolean> postMethod) {
        IntentUtils.findEndpointAndOpenUrl(applicationContext, uri.toString(), postMethod);
    }

    public final void a(Context context, Uri uri, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            o.a("IntentLauncher", "launch - Uri is null", new Object[0]);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, postMethod);
        } else if (Utils.isHttpUri(uri)) {
            b(context, uri, postMethod);
        } else if (uri.getScheme() != null) {
            UiUtils.onUiThreadWithArgSafely(Boolean.valueOf(IntentUtils.openUrl(context, uri.toString())), postMethod);
        } else {
            o.a("IntentLauncher", "launch - Invalid uri: %s", uri);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, postMethod);
        }
    }

    private final void b(Context applicationContext, MraidCalendarEvent mraidCalendarEvent, Executable<Boolean> postMethod) {
        a(applicationContext, a(a(mraidCalendarEvent)), postMethod);
    }

    public final void a(Context context, MraidCalendarEvent mraidCalendarEvent, Executable<Boolean> postMethod) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidCalendarEvent, "mraidCalendarEvent");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        b(applicationContext, mraidCalendarEvent, postMethod);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(l this$0, Context applicationContext, Uri uri, Executable executable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uri, "$uri");
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        this$0.c(applicationContext, uri, executable);
    }

    private final void a(Context applicationContext, Intent intent, Executable<Boolean> postMethod) {
        try {
            applicationContext.startActivity(intent);
            UiUtils.onUiThreadWithArgSafely(Boolean.TRUE, postMethod);
        } catch (Exception e) {
            o.b(e);
            UiUtils.onUiThreadWithArgSafely(Boolean.FALSE, postMethod);
        }
    }

    private final Intent a(Intent intent) {
        Intent flags = Intent.createChooser(intent, "").setFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(flags, "createChooser(intent, \"\"…t.FLAG_ACTIVITY_NEW_TASK)");
        return flags;
    }

    private final Intent a(MraidCalendarEvent mraidCalendarEvent) {
        int i;
        Intent putExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("title", mraidCalendarEvent.getDescription()).putExtra("beginTime", mraidCalendarEvent.getStart().getTime());
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_INS…CalendarEvent.start.time)");
        Date end = mraidCalendarEvent.getEnd();
        if (end != null) {
            putExtra.putExtra("endTime", end.getTime());
        }
        String summary = mraidCalendarEvent.getSummary();
        if (summary != null) {
            putExtra.putExtra("description", summary);
        }
        String location = mraidCalendarEvent.getLocation();
        if (location != null) {
            putExtra.putExtra("eventLocation", location);
        }
        String status = mraidCalendarEvent.getStatus();
        int i2 = 2;
        if (status != null) {
            if (Intrinsics.areEqual(status, "confirmed")) {
                i = 1;
            } else {
                i = Intrinsics.areEqual(status, "cancelled") ? 2 : 0;
            }
            putExtra.putExtra("eventStatus", i);
        }
        String transparency = mraidCalendarEvent.getTransparency();
        if (transparency != null) {
            if (Intrinsics.areEqual(transparency, C3040d4.h.T)) {
                i2 = 1;
            } else if (Intrinsics.areEqual(transparency, "opaque")) {
                i2 = 0;
            }
            putExtra.putExtra("availability", i2);
        }
        String recurrence = mraidCalendarEvent.getRecurrence();
        if (recurrence != null) {
            putExtra.putExtra("rrule", recurrence);
        }
        return putExtra;
    }
}
