package io.bidmachine.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import com.google.common.base.Function;
import io.bidmachine.media3.common.text.Cue;
import io.bidmachine.media3.common.util.BundleCollectionUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class CueEncoder {
    public byte[] encode(List<Cue> list, long j) {
        ArrayList<Bundle> bundleArrayList = BundleCollectionUtil.toBundleArrayList(list, new Function() { // from class: io.bidmachine.media3.extractor.text.CueEncoder$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Bundle serializableBundle;
                serializableBundle = ((Cue) obj).toSerializableBundle();
                return serializableBundle;
            }
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", bundleArrayList);
        bundle.putLong("d", j);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
