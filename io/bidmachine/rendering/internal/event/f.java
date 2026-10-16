package io.bidmachine.rendering.internal.event;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.PrivacySheetParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\nJ#\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0006J#\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0007\u0010\u000fJ#\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0010\u0010\u000fJ/\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0010\u0010\u0016J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0011H&¢\u0006\u0004\b\u0010\u0010\u0018J!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u001aJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u0010\u0010\u001dJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b\u0010\u0010!J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Lio/bidmachine/rendering/internal/event/f;", "", "", "url", "", "g", "(Ljava/lang/String;)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", "e", "()V", "targetElementName", "", "senderId", "c", "(Ljava/lang/String;Ljava/lang/Integer;)V", "a", "", "maxProgressMs", "currentProgressMs", "", "percent", "(Ljava/lang/String;JJF)V", "timeMs", "(Ljava/lang/String;J)V", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "", "lockVisibility", "(Ljava/lang/String;Z)V", InneractiveMediationDefs.GENDER_FEMALE, "Lio/bidmachine/rendering/model/PrivacySheetParams;", "privacySheetParams", "(Lio/bidmachine/rendering/model/PrivacySheetParams;)V", "stateGroups", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public interface f {
    void a(PrivacySheetParams privacySheetParams);

    void a(String stateGroups);

    void a(String targetElementName, long timeMs);

    void a(String targetElementName, long maxProgressMs, long currentProgressMs, float percent);

    void a(String targetElementName, Integer senderId);

    void a(String targetElementName, String value);

    void a(String targetElementName, boolean lockVisibility);

    void b();

    void b(String url);

    void b(String targetElementName, Integer senderId);

    void c(String targetElementName);

    void c(String targetElementName, Integer senderId);

    void d(String url);

    void d(String targetElementName, Integer senderId);

    void e();

    void e(String targetElementName);

    void f(String targetElementName);

    void g(String url);
}
