package io.bidmachine.rendering.internal.state;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3061e8;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001:\u0002\u0005\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH'¢\u0006\u0004\b\u0005\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H'¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH'¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH'¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH'¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH'¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH'¢\u0006\u0004\b\u0007\u0010\fJ\u000f\u0010\u0014\u001a\u00020\bH'¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\u0005\u0010\u000eR\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\nR\u0014\u0010\u0016\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR\u0014\u0010\u0018\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u0014\u0010\u001a\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\nR\u0014\u0010\u001c\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/state/a;", "", "Lio/bidmachine/rendering/internal/state/a$b;", "observer", "", "a", "(Lio/bidmachine/rendering/internal/state/a$b;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "", "c", "()Z", "isLoaded", "(Z)Z", "l", "()V", "i", InneractiveMediationDefs.GENDER_FEMALE, "e", j.b, "isAppeared", CampaignEx.JSON_KEY_AD_K, "d", "isShowInitiated", "m", C3061e8.m, "g", "isFinished", "h", "isDestroyed", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/bidmachine/rendering/internal/state/a$a;", "", "<init>", "(Ljava/lang/String;I)V", "a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "c", "d", "e", InneractiveMediationDefs.GENDER_FEMALE, "g", "h", "i", j.b, CampaignEx.JSON_KEY_AD_K, "l", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.state.a$a, reason: collision with other inner class name */
    public enum EnumC0629a {
        LoadingStarted,
        Loaded,
        FailedToLoad,
        ShowInitiated,
        Shown,
        FailedToShow,
        Clicked,
        Appeared,
        Disappeared,
        Finished,
        Expired,
        Destroyed
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/state/a$b;", "", "Lio/bidmachine/rendering/internal/state/a;", "source", "Lio/bidmachine/rendering/internal/state/a$a;", "event", "", "a", "(Lio/bidmachine/rendering/internal/state/a;Lio/bidmachine/rendering/internal/state/a$a;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void a(a source, EnumC0629a event);
    }

    void a();

    void a(b observer);

    boolean a(boolean isLoaded);

    void b(b observer);

    boolean b();

    boolean b(boolean isAppeared);

    boolean c();

    boolean d();

    boolean e();

    boolean f();

    boolean g();

    boolean h();

    boolean i();

    boolean j();

    boolean k();

    void l();

    boolean m();
}
