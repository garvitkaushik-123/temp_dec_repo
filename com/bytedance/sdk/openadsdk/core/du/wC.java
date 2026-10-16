package com.bytedance.sdk.openadsdk.core.du;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.AdSessionConfiguration;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.CreativeType;
import com.iab.omid.library.bytedance2.adsession.ImpressionType;
import com.iab.omid.library.bytedance2.adsession.Owner;
import com.iab.omid.library.bytedance2.adsession.Partner;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class wC {
    public static kb eli(View view, Set<aAs> set) {
        AdSession eli = eli(CreativeType.VIDEO, set, Owner.NATIVE);
        return new FC(eli, AdEvents.createAdEvents(eli), view, MediaEvents.createMediaEvents(eli));
    }

    public static kb eli(WebView webView) {
        Partner eli = ui.eli();
        if (eli == null) {
            throw new IllegalArgumentException("Parameter 'partner' may not be null.");
        }
        AdSession createAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(eli, webView, "", ""));
        return new kb(createAdSession, AdEvents.createAdEvents(createAdSession), webView);
    }

    private static AdSession eli(CreativeType creativeType, Set<aAs> set, Owner owner) {
        List<VerificationScriptResource> eli = eli(set);
        eli.isEmpty();
        Partner eli2 = ui.eli();
        if (eli2 == null) {
            return null;
        }
        return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(eli2, ui.DbA(), eli, "", ""));
    }

    private static List<VerificationScriptResource> eli(Set<aAs> set) {
        ArrayList arrayList = new ArrayList();
        for (aAs aas : set) {
            if (!TextUtils.isEmpty(aas.eli()) && !TextUtils.isEmpty(aas.DbA())) {
                arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(aas.eli(), aas.Os(), aas.DbA()));
            }
            arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(aas.Os()));
        }
        return arrayList;
    }
}
