package com.instagram.common.viewpoint.core;

import android.content.DialogInterface;

/* loaded from: assets/audience_network/classes2.dex */
public class YQ implements DialogInterface.OnClickListener {
    public final /* synthetic */ C1252Pp A00;

    public YQ(C1252Pp c1252Pp) {
        this.A00 = c1252Pp;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
