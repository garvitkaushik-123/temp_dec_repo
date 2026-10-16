package io.bidmachine.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import com.google.common.base.Function;
import io.bidmachine.media3.common.text.Cue;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.BundleCollectionUtil;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public final class CueDecoder {
    static final String BUNDLE_FIELD_CUES = "c";
    static final String BUNDLE_FIELD_DURATION_US = "d";

    public CuesWithTiming decode(long j, byte[] bArr, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, i, i2);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return new CuesWithTiming(BundleCollectionUtil.fromBundleList(new Function() { // from class: io.bidmachine.media3.extractor.text.CueDecoder$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Cue fromBundle;
                fromBundle = Cue.fromBundle((Bundle) obj);
                return fromBundle;
            }
        }, (ArrayList) Assertions.checkNotNull(readBundle.getParcelableArrayList(BUNDLE_FIELD_CUES))), j, readBundle.getLong("d"));
    }
}
