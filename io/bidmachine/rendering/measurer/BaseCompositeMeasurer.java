package io.bidmachine.rendering.measurer;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import io.bidmachine.rendering.measurer.Measurer;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.utils.CountDownPostback;
import io.bidmachine.rendering.utils.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class BaseCompositeMeasurer<MeasurerType extends Measurer<ViewType>, ViewType extends View> implements Measurer<ViewType> {
    public final List<MeasurerType> measurerList;

    public BaseCompositeMeasurer(List<MeasurerType> measurerList) {
        this.measurerList = new CopyOnWriteArrayList(measurerList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Handler handler, Runnable runnable) {
        this.measurerList.clear();
        handler.post(runnable);
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void destroy(final Runnable postback) {
        final Handler createHandlerWithMyOrMainLooper = Utils.createHandlerWithMyOrMainLooper();
        CountDownPostback countDownPostback = postback != null ? new CountDownPostback(this.measurerList.size(), new Runnable() { // from class: io.bidmachine.rendering.measurer.BaseCompositeMeasurer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseCompositeMeasurer.this.a(createHandlerWithMyOrMainLooper, postback);
            }
        }) : null;
        Iterator<MeasurerType> it = this.measurerList.iterator();
        while (it.hasNext()) {
            it.next().destroy(countDownPostback);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onClicked() {
        Iterator<MeasurerType> it = this.measurerList.iterator();
        while (it.hasNext()) {
            it.next().onClicked();
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onError(Error error) {
        Iterator<MeasurerType> it = this.measurerList.iterator();
        while (it.hasNext()) {
            it.next().onError(error);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onShown() {
        Iterator<MeasurerType> it = this.measurerList.iterator();
        while (it.hasNext()) {
            it.next().onShown();
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewAddedToContainer(ViewType viewType, ViewGroup container) {
        Iterator<MeasurerType> it = this.measurerList.iterator();
        while (it.hasNext()) {
            it.next().onViewAddedToContainer(viewType, container);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewCreated(ViewType viewType) {
        Iterator<MeasurerType> it = this.measurerList.iterator();
        while (it.hasNext()) {
            it.next().onViewCreated(viewType);
        }
    }

    @Override // io.bidmachine.rendering.measurer.Measurer
    public void onViewReady(ViewType viewType) {
        Iterator<MeasurerType> it = this.measurerList.iterator();
        while (it.hasNext()) {
            it.next().onViewReady(viewType);
        }
    }
}
