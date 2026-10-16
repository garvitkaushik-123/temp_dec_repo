package com.sourcepoint.cmplibrary.consent;

import com.sourcepoint.cmplibrary.model.ConsentActionImpl;
import com.sourcepoint.cmplibrary.model.exposed.NativeMessageActionType;
import kotlin.Metadata;

/* compiled from: ClientEventManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ClientEventManager;", "", "checkIfAllCampaignsWereProcessed", "", "registerConsentResponse", "setAction", "action", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImpl;", "Lcom/sourcepoint/cmplibrary/model/exposed/NativeMessageActionType;", "setCampaignsToProcess", "numberOfCampaigns", "", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ClientEventManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void checkIfAllCampaignsWereProcessed();

    void registerConsentResponse();

    void setAction(ConsentActionImpl action);

    void setAction(NativeMessageActionType action);

    void setCampaignsToProcess(int numberOfCampaigns);

    /* compiled from: ClientEventManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sourcepoint/cmplibrary/consent/ClientEventManager$Companion;", "", "()V", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
