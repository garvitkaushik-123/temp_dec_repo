package io.bidmachine.iab.vast.processor;

import android.os.Bundle;
import android.text.TextUtils;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastSpecError;
import io.bidmachine.iab.vast.VastUrlProcessorRegistry;
import io.bidmachine.iab.vast.tags.AdContentTag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class VastProcessorResult {
    private VastAd b;
    private VastSpecError c;

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f6923a = new ArrayList();
    private boolean d = true;

    List<String> a() {
        return this.f6923a;
    }

    boolean b() {
        return this.d;
    }

    public VastAd getVastAd() {
        return this.b;
    }

    public VastSpecError getVastSpecError() {
        return this.c;
    }

    public boolean hasVastAd() {
        return this.b != null;
    }

    void a(VastSpecError vastSpecError) {
        this.c = vastSpecError;
    }

    void a(VastAd vastAd) {
        this.b = vastAd;
    }

    void a(boolean last) {
        this.d = last;
    }

    void a(AdContentTag adContentTag, VastSpecError vastSpecError) {
        a(vastSpecError);
        Bundle bundle = new Bundle();
        bundle.putInt(VastRequest.PARAMS_ERROR_CODE, vastSpecError.getCode());
        List<String> errorUrlList = adContentTag.getErrorUrlList();
        if (errorUrlList == null || errorUrlList.isEmpty()) {
            return;
        }
        Iterator<String> it = errorUrlList.iterator();
        while (it.hasNext()) {
            String processUrl = VastUrlProcessorRegistry.processUrl(it.next(), bundle);
            if (!TextUtils.isEmpty(processUrl)) {
                this.f6923a.add(processUrl);
            }
        }
    }
}
