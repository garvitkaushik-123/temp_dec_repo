package io.bidmachine.nativead;

import io.bidmachine.LabelData;
import io.bidmachine.PrivacySheetData;

/* loaded from: classes6.dex */
public interface NativeData extends NativePublicData {
    LabelData getAdLabelData();

    String getClickUrl();

    PrivacySheetData getPrivacySheetData();

    String getVideoAdm();

    String getVideoUrl();
}
