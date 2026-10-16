package io.bidmachine.rendering.internal.controller;

import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;

/* loaded from: classes8.dex */
public interface c {
    void a();

    void a(a adController);

    void a(a adController, Error error);

    void a(e adPhaseController);

    void a(e adPhaseController, Error error);

    void a(io.bidmachine.rendering.internal.view.f placeholderView);

    void a(BrokenCreativeEvent brokenCreativeEvent);

    void a(PrivacySheetParams privacySheetParams);

    void b();

    void b(a adController);

    void b(io.bidmachine.rendering.internal.view.f placeholderView);

    void c();

    void c(a adController);

    void d();

    void e();

    void onAdClicked();
}
