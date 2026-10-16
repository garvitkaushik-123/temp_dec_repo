package io.bidmachine.iab.vast;

import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes7.dex */
public class VastSpecError {

    /* renamed from: a, reason: collision with root package name */
    private final int f6882a;
    public static final VastSpecError XML_PARSING = new VastSpecError(100);
    public static final VastSpecError XML_VALIDATE = new VastSpecError(101);
    public static final VastSpecError DURATION = new VastSpecError(202);
    public static final VastSpecError GENERAL_WRAPPER = new VastSpecError(300);
    public static final VastSpecError BAD_URI = new VastSpecError(Sdk.SDKError.Reason.MRAID_ERROR_VALUE);
    public static final VastSpecError EXCEEDED_WRAPPER_LIMIT = new VastSpecError(Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE);
    public static final VastSpecError WRAPPER_RESPONSE_NO_AD = new VastSpecError(303);
    public static final VastSpecError GENERAL_LINEAR = new VastSpecError(400);
    public static final VastSpecError NO_FILE = new VastSpecError(401);
    public static final VastSpecError BAD_FILE = new VastSpecError(403);
    public static final VastSpecError SHOWING = new VastSpecError(405);
    public static final VastSpecError GENERAL_COMPANION = new VastSpecError(600);
    public static final VastSpecError UNKNOWN = new VastSpecError(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);

    private VastSpecError(int code) {
        this.f6882a = code;
    }

    public int getCode() {
        return this.f6882a;
    }

    public String toString() {
        return String.format("%s", Integer.valueOf(this.f6882a));
    }
}
