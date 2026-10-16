package io.bidmachine.rendering.internal.event;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H&¢\u0006\u0004\b\u0007\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u0007\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\"À\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/event/b;", "", "", CampaignEx.JSON_KEY_AD_K, "()V", "", "viewId", "a", "(I)V", "senderId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/Integer;)V", InneractiveMediationDefs.GENDER_FEMALE, "d", "onClose", j.b, "i", "g", "c", "", "maxProgressMs", "currentProgressMs", "(JJ)V", "", "useCustomClose", "onUseCustomClose", "(Z)V", "h", "", "url", "(Ljava/lang/String;)V", "e", "()Ljava/lang/String;", "sourceName", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface b {
    void a();

    void a(int viewId);

    void a(long maxProgressMs, long currentProgressMs);

    void a(Integer senderId);

    void a(String url);

    void b();

    void b(Integer senderId);

    void c();

    void d();

    String e();

    void f();

    void g();

    void h();

    void i();

    void j();

    void k();

    void onClose();

    void onUseCustomClose(boolean useCustomClose);
}
