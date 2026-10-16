package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class EM extends UN<C4A> {
    public static String[] A01 = {"Etf6rxr38TN0vQCp7eNtUvsDOmNclbJq", "tsAjjvZCMDWdS", "8hGTWRVePtIxVw2NOXuq9knVHvw3DPvW", "EWxkCjZIostDvyF", "5rZAWcCWfjjM2", "LrhlSMt3F2A2PPkpDiBfjHpLA", "jQk7ZNmPb7V9ueUuvUfiKmSE", "mvg7pIDRu6IgLugvRarlC3XDTGoYv5EO"};
    public final /* synthetic */ C4L A00;

    public EM(C4L c4l) {
        this.A00 = c4l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.UN
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C4A c4a) {
        C0966Ek c0966Ek;
        C0966Ek c0966Ek2;
        int A00 = c4a.A00();
        int currentPositionMS = this.A00.A00;
        if (currentPositionMS > 0) {
            c0966Ek = this.A00.A0C;
            int currentPositionMS2 = c0966Ek.getDuration();
            if (A00 == currentPositionMS2) {
                c0966Ek2 = this.A00.A0C;
                int duration = c0966Ek2.getDuration();
                int currentPositionMS3 = this.A00.A00;
                if (duration > currentPositionMS3) {
                    return;
                }
            }
        }
        C4L c4l = this.A00;
        if (A01[5].length() == 7) {
            throw new RuntimeException();
        }
        A01[5] = "7AA42mFgyTVlZSuOszNfTs49";
        c4l.A0k(A00);
    }

    @Override // com.instagram.common.viewpoint.core.UN
    public final Class<C4A> A01() {
        return C4A.class;
    }
}
