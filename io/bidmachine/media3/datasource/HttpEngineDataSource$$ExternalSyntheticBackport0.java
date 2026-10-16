package io.bidmachine.media3.datasource;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes7.dex */
public final /* synthetic */ class HttpEngineDataSource$$ExternalSyntheticBackport0 {
    public static /* synthetic */ String m(String str) {
        int length = str.length();
        while (length > 0) {
            int codePointBefore = Character.codePointBefore(str, length);
            if (!Character.isWhitespace(codePointBefore)) {
                break;
            }
            length -= Character.charCount(codePointBefore);
        }
        return str.substring(0, length);
    }
}
