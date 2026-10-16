package io.adn.sdk.internal.thirdparty.omsdk.omid;

import com.iab.omid.library.voodooio.adsession.VerificationScriptResource;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.thirdparty.omsdk.model.AdMeasurementVerificationResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OmidVerificationResourcesProvider.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\u0000¨\u0006\u0005"}, d2 = {"getVerificationScriptResources", "", "Lcom/iab/omid/library/voodooio/adsession/VerificationScriptResource;", "adMeasurementVerificationResources", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdMeasurementVerificationResource;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OmidVerificationResourcesProviderKt {
    public static final List<VerificationScriptResource> getVerificationScriptResources(List<AdMeasurementVerificationResource> adMeasurementVerificationResources) {
        Object m10241constructorimpl;
        VerificationScriptResource createVerificationScriptResourceWithParameters;
        Intrinsics.checkNotNullParameter(adMeasurementVerificationResources, "adMeasurementVerificationResources");
        ArrayList arrayList = new ArrayList();
        for (AdMeasurementVerificationResource adMeasurementVerificationResource : adMeasurementVerificationResources) {
            try {
                Result.Companion companion = Result.INSTANCE;
                URL url = new URL(adMeasurementVerificationResource.getVerificationUrl());
                if (StringsKt.isBlank(adMeasurementVerificationResource.getVerificationParameters())) {
                    createVerificationScriptResourceWithParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                } else {
                    createVerificationScriptResourceWithParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(adMeasurementVerificationResource.getVendorKey(), url, adMeasurementVerificationResource.getVerificationParameters());
                }
                m10241constructorimpl = Result.m10241constructorimpl(createVerificationScriptResourceWithParameters);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
            if (m10244exceptionOrNullimpl != null) {
                throw new AdException(AdError.OmidVerificationScriptLoadError, m10244exceptionOrNullimpl.getMessage());
            }
            VerificationScriptResource verificationScriptResource = (VerificationScriptResource) m10241constructorimpl;
            if (verificationScriptResource != null) {
                arrayList.add(verificationScriptResource);
            }
        }
        return arrayList;
    }
}
