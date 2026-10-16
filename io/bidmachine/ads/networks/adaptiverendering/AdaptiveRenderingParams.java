package io.bidmachine.ads.networks.adaptiverendering;

import com.explorestack.protobuf.ProtocolStringList;
import com.ironsource.C3061e8;
import io.bidmachine.ads.networks.adaptiverendering.measurer.AdMeasurerFactory;
import io.bidmachine.core.Logger;
import io.bidmachine.protobuf.rendering.Rendering;
import io.bidmachine.protobuf.rendering.RenderingFeature;
import io.bidmachine.rendering.measurer.MeasurerFactory;
import io.bidmachine.rendering.model.AdElementParams;
import io.bidmachine.rendering.model.AdElementType;
import io.bidmachine.rendering.model.AdParams;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.AnimationDirectionType;
import io.bidmachine.rendering.model.AnimationEventType;
import io.bidmachine.rendering.model.AnimationFunctionType;
import io.bidmachine.rendering.model.AnimationParams;
import io.bidmachine.rendering.model.AnimationStyleType;
import io.bidmachine.rendering.model.AppearanceParams;
import io.bidmachine.rendering.model.Background;
import io.bidmachine.rendering.model.BackgroundSource;
import io.bidmachine.rendering.model.Base64ResourceSource;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmType;
import io.bidmachine.rendering.model.BrokenCreativeDetectorParams;
import io.bidmachine.rendering.model.CacheType;
import io.bidmachine.rendering.model.Color;
import io.bidmachine.rendering.model.ColorBackgroundSource;
import io.bidmachine.rendering.model.ColorPlaceholderSource;
import io.bidmachine.rendering.model.ElementLayoutParams;
import io.bidmachine.rendering.model.EventParams;
import io.bidmachine.rendering.model.EventTaskParams;
import io.bidmachine.rendering.model.EventTaskType;
import io.bidmachine.rendering.model.EventType;
import io.bidmachine.rendering.model.FontStyleType;
import io.bidmachine.rendering.model.Gradient;
import io.bidmachine.rendering.model.GradientColorSource;
import io.bidmachine.rendering.model.GradientDirection;
import io.bidmachine.rendering.model.GradientType;
import io.bidmachine.rendering.model.HorizontalGravity;
import io.bidmachine.rendering.model.HtmlResourceSource;
import io.bidmachine.rendering.model.Image;
import io.bidmachine.rendering.model.ImageBackgroundSource;
import io.bidmachine.rendering.model.ImagePlaceholderSource;
import io.bidmachine.rendering.model.MeasurerParams;
import io.bidmachine.rendering.model.MethodParams;
import io.bidmachine.rendering.model.NamePlaceholderSource;
import io.bidmachine.rendering.model.OneColorSource;
import io.bidmachine.rendering.model.Padding;
import io.bidmachine.rendering.model.Placeholder;
import io.bidmachine.rendering.model.Resource;
import io.bidmachine.rendering.model.ScaleType;
import io.bidmachine.rendering.model.SideBindParams;
import io.bidmachine.rendering.model.SideType;
import io.bidmachine.rendering.model.StopDetectorAfter;
import io.bidmachine.rendering.model.UrlResourceSource;
import io.bidmachine.rendering.model.VisibilityParams;
import io.bidmachine.rendering.model.XmlResourceSource;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.unified.UnifiedParams;
import io.bidmachine.util.Utils;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdaptiveRenderingParams.kt */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0018\u0010'\u001a\u0004\u0018\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001dH\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0007J\u0014\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0007J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0007J\u0014\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0014\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J \u0010C\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u001d2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u001dH\u0007J\u0014\u0010G\u001a\u0004\u0018\u00010H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0014\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\u0010\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006S"}, d2 = {"Lio/bidmachine/ads/networks/adaptiverendering/AdaptiveRenderingParams;", "Lio/bidmachine/unified/UnifiedParams;", "unifiedMediationParams", "Lio/bidmachine/unified/UnifiedMediationParams;", "(Lio/bidmachine/unified/UnifiedMediationParams;)V", "adParams", "Lio/bidmachine/rendering/model/AdParams;", "getAdParams", "()Lio/bidmachine/rendering/model/AdParams;", "createAdElementParams", "Lio/bidmachine/rendering/model/AdElementParams;", "viewComponent", "Lio/bidmachine/protobuf/rendering/Rendering$Phase$ViewComponent;", "measurerFactory", "Lio/bidmachine/rendering/measurer/MeasurerFactory;", "createAdParams", "rendering", "Lio/bidmachine/protobuf/rendering/Rendering;", C3061e8.s, "Lio/bidmachine/rendering/model/VisibilityParams;", "createAdPhaseParams", "Lio/bidmachine/rendering/model/AdPhaseParams;", "phase", "Lio/bidmachine/protobuf/rendering/Rendering$Phase;", "createAnimationMap", "", "Lio/bidmachine/rendering/model/AnimationEventType;", "Lio/bidmachine/rendering/model/AnimationParams;", "adaptiveAnimationList", "", "Lio/bidmachine/protobuf/rendering/Rendering$AdaptiveAnimation;", "createAppearanceParams", "Lio/bidmachine/rendering/model/AppearanceParams;", "appearance", "Lio/bidmachine/protobuf/rendering/Rendering$Phase$ViewComponent$Appearance;", "createBackground", "Lio/bidmachine/rendering/model/Background;", "background", "Lio/bidmachine/protobuf/rendering/Rendering$Background;", "createBrokenCreativeDetectorParams", "Lio/bidmachine/rendering/model/BrokenCreativeDetectorParams;", "featureList", "Lio/bidmachine/protobuf/rendering/RenderingFeature;", "createColor", "Lio/bidmachine/rendering/model/Color;", "color", "Lio/bidmachine/protobuf/rendering/Rendering$Color;", "createElementLayoutParams", "Lio/bidmachine/rendering/model/ElementLayoutParams;", "layout", "Lio/bidmachine/protobuf/rendering/Rendering$Phase$ViewComponent$Layout;", "createEventParams", "Lio/bidmachine/rendering/model/EventParams;", "event", "Lio/bidmachine/protobuf/rendering/Rendering$Phase$Event;", "createEventTaskParams", "Lio/bidmachine/rendering/model/EventTaskParams;", "task", "Lio/bidmachine/protobuf/rendering/Rendering$Phase$Event$Task;", "createGradient", "Lio/bidmachine/rendering/model/Gradient;", "gradient", "Lio/bidmachine/protobuf/rendering/Rendering$Color$Gradient;", "createImage", "Lio/bidmachine/rendering/model/Image;", "image", "Lio/bidmachine/protobuf/rendering/Rendering$Image;", "createMeasurerParamsList", "Lio/bidmachine/rendering/model/MeasurerParams;", "measurerList", "Lio/bidmachine/protobuf/rendering/Rendering$Phase$ViewComponent$Measurer;", "createPlaceholder", "Lio/bidmachine/rendering/model/Placeholder;", "placeholder", "Lio/bidmachine/protobuf/rendering/Rendering$Placeholder;", "createResource", "Lio/bidmachine/rendering/model/Resource;", "resource", "Lio/bidmachine/protobuf/rendering/Rendering$Resource;", "isValid", "", "callback", "Lio/bidmachine/unified/UnifiedAdCallback;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AdaptiveRenderingParams extends UnifiedParams {
    private final AdParams adParams;

    /* compiled from: AdaptiveRenderingParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.values().length];
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_HEIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.ANCHOR_CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdaptiveRenderingParams(UnifiedMediationParams unifiedMediationParams) {
        super(unifiedMediationParams);
        Intrinsics.checkNotNullParameter(unifiedMediationParams, "unifiedMediationParams");
        Object objectOrNull = unifiedMediationParams.getObjectOrNull(UnifiedMediationParams.KEY_RENDERING_CONFIGURATION);
        if (objectOrNull instanceof Rendering) {
            VisibilityParams.Builder builder = new VisibilityParams.Builder();
            Float floatOrNull = unifiedMediationParams.getFloatOrNull(UnifiedMediationParams.KEY_VIEWABILITY_PIXEL_THRESHOLD);
            if (floatOrNull != null) {
                builder.setVisibilityPercent(floatOrNull.floatValue());
            }
            Boolean booleanOrNull = unifiedMediationParams.getBooleanOrNull(UnifiedMediationParams.KEY_VIEWABILITY_IGNORE_WINDOW_FOCUS);
            if (booleanOrNull != null) {
                builder.setIgnoreWindowFocus(booleanOrNull.booleanValue());
            }
            Boolean booleanOrNull2 = unifiedMediationParams.getBooleanOrNull(UnifiedMediationParams.KEY_VIEWABILITY_IGNORE_OVERLAP);
            if (booleanOrNull2 != null) {
                builder.setIgnoreOverlap(booleanOrNull2.booleanValue());
            }
            this.adParams = createAdParams((Rendering) objectOrNull, builder.build());
            return;
        }
        this.adParams = null;
    }

    public final AdParams getAdParams() {
        return this.adParams;
    }

    @Override // io.bidmachine.unified.UnifiedParams
    public boolean isValid(UnifiedAdCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.adParams != null) {
            return true;
        }
        callback.onAdLoadFailed(BMError.notFound(UnifiedMediationParams.KEY_RENDERING_CONFIGURATION));
        return false;
    }

    public final AdParams createAdParams(Rendering rendering, VisibilityParams visibilityParams) {
        Intrinsics.checkNotNullParameter(rendering, "rendering");
        Intrinsics.checkNotNullParameter(visibilityParams, "visibilityParams");
        AdMeasurerFactory adMeasurerFactory = new AdMeasurerFactory();
        AdParams.Builder customParams = new AdParams.Builder().setOrientation(AdaptiveRenderingParamsKt.toOrientation(rendering.getOrientation())).setBackground(createBackground(rendering.getBackground())).setVisibilityParams(visibilityParams).setCustomParams(rendering.getCustomParamsMap());
        CacheType cacheType = AdaptiveRenderingParamsKt.toCacheType(rendering.getCacheType());
        if (cacheType != null) {
            customParams.setCacheType(cacheType);
        }
        List<Rendering.Phase> phasesList = rendering.getPhasesList();
        Intrinsics.checkNotNullExpressionValue(phasesList, "rendering.phasesList");
        List<Rendering.Phase> mutableList = CollectionsKt.toMutableList((Collection) phasesList);
        if (mutableList.size() > 1) {
            CollectionsKt.sortWith(mutableList, new Comparator() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$createAdParams$lambda$5$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((Rendering.Phase) t).getSequence()), Integer.valueOf(((Rendering.Phase) t2).getSequence()));
                }
            });
        }
        for (Rendering.Phase phase : mutableList) {
            AdPhaseParams createAdPhaseParams = createAdPhaseParams(phase, adMeasurerFactory);
            if (createAdPhaseParams != null) {
                if (phase.getSequence() == -1) {
                    customParams.setPlaceholderParams(createAdPhaseParams);
                } else {
                    customParams.addAdPhaseParams(createAdPhaseParams);
                }
            }
        }
        return customParams.build();
    }

    public final AdPhaseParams createAdPhaseParams(Rendering.Phase phase, MeasurerFactory measurerFactory) {
        if (phase == null || phase == Rendering.Phase.getDefaultInstance()) {
            return null;
        }
        AdPhaseParams.Builder background = new AdPhaseParams.Builder(phase.getSequence()).setBackground(createBackground(phase.getBackground()));
        List<Rendering.AdaptiveAnimation> animationsList = phase.getAnimationsList();
        Intrinsics.checkNotNullExpressionValue(animationsList, "phase.animationsList");
        AdPhaseParams.Builder animationParams = background.setAnimationParams(MapsKt.toMutableMap(createAnimationMap(animationsList)));
        ProtocolStringList stateGroupsList = phase.getStateGroupsList();
        Intrinsics.checkNotNullExpressionValue(stateGroupsList, "phase.stateGroupsList");
        AdPhaseParams.Builder customParams = animationParams.setStateGroups(CollectionsKt.toMutableList((Collection) stateGroupsList)).setCustomParams(phase.getCustomParamsMap());
        Integer parseColorSafely = Utils.parseColorSafely(phase.getBackgroundColor());
        if (parseColorSafely != null) {
            customParams.setBackgroundColor(parseColorSafely.intValue());
        }
        List<Rendering.Phase.ViewComponent> adsList = phase.getAdsList();
        Intrinsics.checkNotNullExpressionValue(adsList, "phase.adsList");
        Iterator<T> it = adsList.iterator();
        while (it.hasNext()) {
            AdElementParams createAdElementParams = createAdElementParams((Rendering.Phase.ViewComponent) it.next(), measurerFactory);
            if (createAdElementParams != null) {
                customParams.addAdsElementParams(createAdElementParams);
            }
        }
        List<Rendering.Phase.ViewComponent> controlsList = phase.getControlsList();
        Intrinsics.checkNotNullExpressionValue(controlsList, "phase.controlsList");
        Iterator<T> it2 = controlsList.iterator();
        while (it2.hasNext()) {
            AdElementParams createAdElementParams2 = createAdElementParams((Rendering.Phase.ViewComponent) it2.next(), measurerFactory);
            if (createAdElementParams2 != null) {
                customParams.addControlsElementParams(createAdElementParams2);
            }
        }
        List<Rendering.Phase.Event> eventsList = phase.getEventsList();
        Intrinsics.checkNotNullExpressionValue(eventsList, "phase.eventsList");
        Iterator<T> it3 = eventsList.iterator();
        while (it3.hasNext()) {
            EventParams createEventParams = createEventParams((Rendering.Phase.Event) it3.next());
            if (createEventParams != null) {
                customParams.addEventParams(createEventParams);
            }
        }
        List<Rendering.Phase.MethodComponent> methodsList = phase.getMethodsList();
        Intrinsics.checkNotNullExpressionValue(methodsList, "phase.methodsList");
        Iterator<T> it4 = methodsList.iterator();
        while (it4.hasNext()) {
            String name = ((Rendering.Phase.MethodComponent) it4.next()).getName();
            Intrinsics.checkNotNullExpressionValue(name, "methodComponent.name");
            customParams.addMethodParams(new MethodParams(name));
        }
        return customParams.build();
    }

    public final AdElementParams createAdElementParams(Rendering.Phase.ViewComponent viewComponent, MeasurerFactory measurerFactory) {
        AdElementType adElementType;
        if (viewComponent == null || viewComponent == Rendering.Phase.ViewComponent.getDefaultInstance() || (adElementType = AdaptiveRenderingParamsKt.toAdElementType(viewComponent.getType())) == null) {
            return null;
        }
        String it = viewComponent.getText();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        String str = it.length() > 0 ? it : null;
        String name = viewComponent.getName();
        Intrinsics.checkNotNullExpressionValue(name, "viewComponent.name");
        Resource createResource = createResource(viewComponent.getResource());
        String source = viewComponent.getSource();
        String placeholder = viewComponent.getPlaceholder();
        ElementLayoutParams createElementLayoutParams = createElementLayoutParams(viewComponent.getLayout());
        AppearanceParams createAppearanceParams = createAppearanceParams(viewComponent.getAppearance());
        Map<String, String> customParamsMap = viewComponent.getCustomParamsMap();
        Intrinsics.checkNotNullExpressionValue(customParamsMap, "viewComponent.customParamsMap");
        List<Rendering.AdaptiveAnimation> animationsList = viewComponent.getAppearance().getAnimationsList();
        Intrinsics.checkNotNullExpressionValue(animationsList, "viewComponent.appearance.animationsList");
        Map<AnimationEventType, AnimationParams> createAnimationMap = createAnimationMap(animationsList);
        List<MeasurerParams> createMeasurerParamsList = createMeasurerParamsList(viewComponent.getMeasurersList());
        List<RenderingFeature> featuresList = viewComponent.getFeaturesList();
        Intrinsics.checkNotNullExpressionValue(featuresList, "viewComponent.featuresList");
        return new AdElementParams(adElementType, name, createResource, source, placeholder, str, createElementLayoutParams, createAppearanceParams, customParamsMap, createAnimationMap, measurerFactory, createMeasurerParamsList, createBrokenCreativeDetectorParams(featuresList));
    }

    public final ElementLayoutParams createElementLayoutParams(Rendering.Phase.ViewComponent.Layout layout) {
        ElementLayoutParams.Builder builder = new ElementLayoutParams.Builder();
        if (layout == null) {
            return builder.build();
        }
        List<Rendering.Phase.ViewComponent.Layout.Constraint> constraintsList = layout.getConstraintsList();
        Intrinsics.checkNotNullExpressionValue(constraintsList, "layout.constraintsList");
        for (Rendering.Phase.ViewComponent.Layout.Constraint constraint : constraintsList) {
            final Rendering.Phase.ViewComponent.Layout.Constraint.Anchor sourceAnchor = constraint.getSourceAnchor();
            Rendering.Phase.ViewComponent.Layout.Constraint.Anchor targetAnchor = constraint.getTargetAnchor();
            String target = constraint.getTarget();
            Intrinsics.checkNotNullExpressionValue(target, "constraint.target");
            float value = (float) constraint.getValue();
            switch (sourceAnchor == null ? -1 : WhenMappings.$EnumSwitchMapping$0[sourceAnchor.ordinal()]) {
                case 1:
                    builder.setWidth(value);
                    builder.setWidthPercent((float) constraint.getMultiplier());
                    break;
                case 2:
                    builder.setHeight(value);
                    builder.setHeightPercent((float) constraint.getMultiplier());
                    break;
                case 3:
                    SideType sideType = AdaptiveRenderingParamsKt.toSideType(targetAnchor);
                    if (sideType != null) {
                        builder.setLeftSideBindParams(new SideBindParams(sideType, target));
                    }
                    builder.setMarginLeft(value);
                    break;
                case 4:
                    SideType sideType2 = AdaptiveRenderingParamsKt.toSideType(targetAnchor);
                    if (sideType2 != null) {
                        builder.setTopSideBindParams(new SideBindParams(sideType2, target));
                    }
                    builder.setMarginTop(value);
                    break;
                case 5:
                    SideType sideType3 = AdaptiveRenderingParamsKt.toSideType(targetAnchor);
                    if (sideType3 != null) {
                        builder.setRightSideBindParams(new SideBindParams(sideType3, target));
                    }
                    builder.setMarginRight(value);
                    break;
                case 6:
                    SideType sideType4 = AdaptiveRenderingParamsKt.toSideType(targetAnchor);
                    if (sideType4 != null) {
                        builder.setBottomSideBindParams(new SideBindParams(sideType4, target));
                    }
                    builder.setMarginBottom(value);
                    break;
                case 7:
                    builder.setTranslationX(value);
                    break;
                case 8:
                    builder.setTranslationY(value);
                    break;
                default:
                    Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda9
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            String createElementLayoutParams$lambda$17$lambda$16;
                            createElementLayoutParams$lambda$17$lambda$16 = AdaptiveRenderingParams.createElementLayoutParams$lambda$17$lambda$16(Rendering.Phase.ViewComponent.Layout.Constraint.Anchor.this);
                            return createElementLayoutParams$lambda$17$lambda$16;
                        }
                    });
                    break;
            }
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createElementLayoutParams$lambda$17$lambda$16(Rendering.Phase.ViewComponent.Layout.Constraint.Anchor anchor) {
        return "Unsupported SourceAnchor - " + anchor;
    }

    public final AppearanceParams createAppearanceParams(Rendering.Phase.ViewComponent.Appearance appearance) {
        if (appearance == null || appearance == Rendering.Phase.ViewComponent.Appearance.getDefaultInstance()) {
            return new AppearanceParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
        }
        Background createBackground = createBackground(appearance.getBackground());
        Integer parseColorSafely = Utils.parseColorSafely(appearance.getBackgroundColor());
        Boolean valueOf = Boolean.valueOf(appearance.getVisible());
        Boolean valueOf2 = Boolean.valueOf(appearance.getClickable());
        Float valueOf3 = Float.valueOf((float) appearance.getOpacity());
        Float valueOf4 = Float.valueOf((float) appearance.getFontSize());
        FontStyleType fontStyleType = FontStyleType.INSTANCE.get(appearance.getFontStyle());
        Boolean valueOf5 = Boolean.valueOf(appearance.getOutlined());
        Float valueOf6 = Float.valueOf((float) appearance.getStrokeWidth());
        Integer parseColorSafely2 = Utils.parseColorSafely(appearance.getStrokeColor());
        Integer parseColorSafely3 = Utils.parseColorSafely(appearance.getFillColor());
        Integer parseColorSafely4 = Utils.parseColorSafely(appearance.getShadowColor());
        Padding parse = Padding.INSTANCE.parse(appearance.getPadding());
        Float valueOf7 = Float.valueOf((float) appearance.getCornerRadius());
        Integer valueOf8 = Integer.valueOf(appearance.getTextNumberOfLines());
        Float valueOf9 = Float.valueOf((float) appearance.getTextLineSpacing());
        HorizontalGravity horizontalGravity = HorizontalGravity.INSTANCE.get(appearance.getTextAlignment());
        if (horizontalGravity == null) {
            horizontalGravity = HorizontalGravity.Center;
        }
        return new AppearanceParams(createBackground, parseColorSafely, valueOf, valueOf2, valueOf3, valueOf4, fontStyleType, valueOf5, valueOf6, parseColorSafely2, parseColorSafely3, parseColorSafely4, parse, valueOf7, valueOf8, valueOf9, horizontalGravity);
    }

    private final Background createBackground(Rendering.Background background) {
        BackgroundSource backgroundSource = null;
        if (background == null || background == Rendering.Background.getDefaultInstance()) {
            return null;
        }
        if (background.hasColor()) {
            Color createColor = createColor(background.getColor());
            if (createColor != null) {
                backgroundSource = new ColorBackgroundSource(createColor);
            } else {
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String createBackground$lambda$18;
                        createBackground$lambda$18 = AdaptiveRenderingParams.createBackground$lambda$18();
                        return createBackground$lambda$18;
                    }
                });
            }
            backgroundSource = backgroundSource;
        } else if (background.hasImage()) {
            Image createImage = createImage(background.getImage());
            if (createImage != null) {
                backgroundSource = new ImageBackgroundSource(createImage);
            } else {
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda7
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String createBackground$lambda$19;
                        createBackground$lambda$19 = AdaptiveRenderingParams.createBackground$lambda$19();
                        return createBackground$lambda$19;
                    }
                });
            }
            backgroundSource = backgroundSource;
        } else {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda8
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createBackground$lambda$20;
                    createBackground$lambda$20 = AdaptiveRenderingParams.createBackground$lambda$20();
                    return createBackground$lambda$20;
                }
            });
        }
        return new Background((float) background.getOpacity(), backgroundSource, createPlaceholder(background.getPlaceholder()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createBackground$lambda$18() {
        return "BackgroundSource don't found. Can't create Color";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createBackground$lambda$19() {
        return "BackgroundSource don't found. Can't create Image";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createBackground$lambda$20() {
        return "BackgroundSource don't found. Set one of: color, gradient";
    }

    private final Color createColor(Rendering.Color color) {
        GradientColorSource gradientColorSource;
        if (color == null || color == Rendering.Color.getDefaultInstance()) {
            return null;
        }
        if (color.hasColor()) {
            Integer parseColorSafely = Utils.parseColorSafely(color.getColor());
            if (parseColorSafely == null) {
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda4
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String createColor$lambda$21;
                        createColor$lambda$21 = AdaptiveRenderingParams.createColor$lambda$21();
                        return createColor$lambda$21;
                    }
                });
                return null;
            }
            gradientColorSource = new OneColorSource(parseColorSafely.intValue());
        } else if (color.hasGradient()) {
            Gradient createGradient = createGradient(color.getGradient());
            if (createGradient == null) {
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda5
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String createColor$lambda$22;
                        createColor$lambda$22 = AdaptiveRenderingParams.createColor$lambda$22();
                        return createColor$lambda$22;
                    }
                });
                return null;
            }
            gradientColorSource = new GradientColorSource(createGradient);
        } else {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda6
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createColor$lambda$23;
                    createColor$lambda$23 = AdaptiveRenderingParams.createColor$lambda$23();
                    return createColor$lambda$23;
                }
            });
            gradientColorSource = null;
        }
        if (gradientColorSource == null) {
            return null;
        }
        return new Color(gradientColorSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createColor$lambda$21() {
        return "ColorSource don't found. Can't parse color";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createColor$lambda$22() {
        return "ColorSource don't found. Can't create Gradient";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createColor$lambda$23() {
        return "ColorSource don't found. Set one of: color, gradient";
    }

    private final Gradient createGradient(Rendering.Color.Gradient gradient) {
        if (gradient == null || gradient == Rendering.Color.Gradient.getDefaultInstance()) {
            return null;
        }
        final String type = gradient.getType();
        Intrinsics.checkNotNullExpressionValue(type, "gradient.type");
        GradientType gradientType = GradientType.INSTANCE.get(type);
        if (gradientType == null) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda10
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createGradient$lambda$24;
                    createGradient$lambda$24 = AdaptiveRenderingParams.createGradient$lambda$24(type);
                    return createGradient$lambda$24;
                }
            });
            return null;
        }
        final String direction = gradient.getDirection();
        Intrinsics.checkNotNullExpressionValue(direction, "gradient.direction");
        GradientDirection gradientDirection = GradientDirection.INSTANCE.get(direction);
        if (gradientDirection == null) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda11
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createGradient$lambda$25;
                    createGradient$lambda$25 = AdaptiveRenderingParams.createGradient$lambda$25(direction);
                    return createGradient$lambda$25;
                }
            });
            return null;
        }
        ProtocolStringList colorsList = gradient.getColorsList();
        Intrinsics.checkNotNullExpressionValue(colorsList, "gradient.colorsList");
        ProtocolStringList protocolStringList = colorsList;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = protocolStringList.iterator();
        while (it.hasNext()) {
            Integer parseColorSafely = Utils.parseColorSafely(it.next());
            if (parseColorSafely != null) {
                arrayList.add(parseColorSafely);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda12
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createGradient$lambda$27;
                    createGradient$lambda$27 = AdaptiveRenderingParams.createGradient$lambda$27();
                    return createGradient$lambda$27;
                }
            });
            return null;
        }
        if (arrayList2.size() != protocolStringList.size()) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda13
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createGradient$lambda$28;
                    createGradient$lambda$28 = AdaptiveRenderingParams.createGradient$lambda$28();
                    return createGradient$lambda$28;
                }
            });
        }
        return new Gradient(gradientType, gradientDirection, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createGradient$lambda$24(String type) {
        Intrinsics.checkNotNullParameter(type, "$type");
        return "Incorrect gradient type parameter - " + type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createGradient$lambda$25(String direction) {
        Intrinsics.checkNotNullParameter(direction, "$direction");
        return "Incorrect gradient direction parameter - " + direction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createGradient$lambda$27() {
        return "Failed to parse all colors. Check if colors are specified correctly.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createGradient$lambda$28() {
        return "Not all colors were parsed, check if the colors are specified correctly";
    }

    private final Image createImage(Rendering.Image image) {
        Resource createResource;
        if (image == null || image == Rendering.Image.getDefaultInstance() || (createResource = createResource(image.getResource())) == null) {
            return null;
        }
        ScaleType scaleType = AdaptiveRenderingParamsKt.toScaleType(image.getScale());
        if (scaleType == null) {
            scaleType = ScaleType.None;
        }
        return new Image(scaleType, createResource);
    }

    private final Resource createResource(Rendering.Resource resource) {
        XmlResourceSource xmlResourceSource;
        if (resource == null || resource == Rendering.Resource.getDefaultInstance()) {
            return null;
        }
        if (resource.hasBase64()) {
            String base64 = resource.getBase64();
            Intrinsics.checkNotNullExpressionValue(base64, "resource.base64");
            xmlResourceSource = new Base64ResourceSource(base64);
        } else if (resource.hasUrl()) {
            String url = resource.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "resource.url");
            xmlResourceSource = new UrlResourceSource(url);
        } else {
            if (resource.hasPayload()) {
                Rendering.Resource.Payload payload = resource.getPayload();
                Intrinsics.checkNotNullExpressionValue(payload, "resource.payload");
                if (payload.hasHtml()) {
                    String html = payload.getHtml();
                    Intrinsics.checkNotNullExpressionValue(html, "payload.html");
                    xmlResourceSource = new HtmlResourceSource(html);
                } else if (payload.hasXml()) {
                    String xml = payload.getXml();
                    Intrinsics.checkNotNullExpressionValue(xml, "payload.xml");
                    xmlResourceSource = new XmlResourceSource(xml);
                } else {
                    Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda14
                        @Override // io.bidmachine.utils.lazy.LazyValue
                        public final Object get() {
                            String createResource$lambda$29;
                            createResource$lambda$29 = AdaptiveRenderingParams.createResource$lambda$29();
                            return createResource$lambda$29;
                        }
                    });
                }
            } else {
                Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda15
                    @Override // io.bidmachine.utils.lazy.LazyValue
                    public final Object get() {
                        String createResource$lambda$30;
                        createResource$lambda$30 = AdaptiveRenderingParams.createResource$lambda$30();
                        return createResource$lambda$30;
                    }
                });
            }
            xmlResourceSource = null;
        }
        if (xmlResourceSource == null) {
            return null;
        }
        return new Resource(xmlResourceSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createResource$lambda$29() {
        return "ResourceSource don't found. Set one of: html, xml";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createResource$lambda$30() {
        return "ResourceSource don't found. Set one of: base64, url, payload";
    }

    private final Placeholder createPlaceholder(Rendering.Placeholder placeholder) {
        ImagePlaceholderSource imagePlaceholderSource;
        if (placeholder == null || placeholder == Rendering.Placeholder.getDefaultInstance()) {
            return null;
        }
        if (placeholder.hasName()) {
            String name = placeholder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "placeholder.name");
            imagePlaceholderSource = new NamePlaceholderSource(name);
        } else if (placeholder.hasColor()) {
            Color createColor = createColor(placeholder.getColor());
            if (createColor == null) {
                return null;
            }
            imagePlaceholderSource = new ColorPlaceholderSource(createColor);
        } else if (placeholder.hasImage()) {
            Image createImage = createImage(placeholder.getImage());
            if (createImage == null) {
                return null;
            }
            imagePlaceholderSource = new ImagePlaceholderSource(createImage);
        } else {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda1
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createPlaceholder$lambda$31;
                    createPlaceholder$lambda$31 = AdaptiveRenderingParams.createPlaceholder$lambda$31();
                    return createPlaceholder$lambda$31;
                }
            });
            imagePlaceholderSource = null;
        }
        if (imagePlaceholderSource == null) {
            return null;
        }
        return new Placeholder(imagePlaceholderSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createPlaceholder$lambda$31() {
        return "PlaceholderSource don't found. Set one of: name, color, gradient";
    }

    private final Map<AnimationEventType, AnimationParams> createAnimationMap(List<Rendering.AdaptiveAnimation> adaptiveAnimationList) {
        AnimationParams animationParams;
        HashMap hashMap = new HashMap();
        for (Rendering.AdaptiveAnimation adaptiveAnimation : adaptiveAnimationList) {
            AnimationEventType animationEventType = AnimationEventType.INSTANCE.get(adaptiveAnimation.getEvent());
            if (animationEventType != null) {
                Rendering.AdaptiveAnimation.Style style = adaptiveAnimation.getStyle();
                Intrinsics.checkNotNullExpressionValue(style, "it.style");
                if (style.hasFade()) {
                    Rendering.AdaptiveAnimation.FadeAnimationOption fade = style.getFade();
                    Intrinsics.checkNotNullExpressionValue(fade, "style.fade");
                    Rendering.AdaptiveAnimation.Timing timing = fade.getTiming();
                    Intrinsics.checkNotNullExpressionValue(timing, "fadeAnimationOption.timing");
                    animationParams = new AnimationParams(animationEventType, AnimationStyleType.Fade, AnimationFunctionType.INSTANCE.get(timing.getFunction()), AdaptiveRenderingParamsKt.getDurationMs(timing), null);
                } else if (style.hasSlide()) {
                    Rendering.AdaptiveAnimation.SlideAnimationOption slide = style.getSlide();
                    Intrinsics.checkNotNullExpressionValue(slide, "style.slide");
                    Rendering.AdaptiveAnimation.Timing timing2 = slide.getTiming();
                    Intrinsics.checkNotNullExpressionValue(timing2, "slideAnimationOption.timing");
                    animationParams = new AnimationParams(animationEventType, AnimationStyleType.Slide, AnimationFunctionType.INSTANCE.get(timing2.getFunction()), AdaptiveRenderingParamsKt.getDurationMs(timing2), AnimationDirectionType.INSTANCE.get(slide.getDirection()));
                }
                hashMap.put(animationEventType, animationParams);
            }
        }
        return hashMap;
    }

    public final List<MeasurerParams> createMeasurerParamsList(List<Rendering.Phase.ViewComponent.Measurer> measurerList) {
        List<Rendering.Phase.ViewComponent.Measurer> list = measurerList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Rendering.Phase.ViewComponent.Measurer> list2 = measurerList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Rendering.Phase.ViewComponent.Measurer measurer : list2) {
            String name = measurer.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            arrayList.add(new MeasurerParams(name, measurer.getParametersMap()));
        }
        return arrayList;
    }

    private final BrokenCreativeDetectorParams createBrokenCreativeDetectorParams(List<RenderingFeature> featureList) {
        Object obj;
        RenderingFeature.BrokenCreativeDetector brokenCreativeDetector;
        if (featureList.isEmpty()) {
            return null;
        }
        Iterator<T> it = featureList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            RenderingFeature renderingFeature = (RenderingFeature) obj;
            if (renderingFeature.hasBrokenCreativeDetector() && renderingFeature.getBrokenCreativeDetector().hasConfiguration()) {
                break;
            }
        }
        RenderingFeature renderingFeature2 = (RenderingFeature) obj;
        RenderingFeature.BrokenCreativeDetector.Configuration configuration = (renderingFeature2 == null || (brokenCreativeDetector = renderingFeature2.getBrokenCreativeDetector()) == null) ? null : brokenCreativeDetector.getConfiguration();
        if (configuration == null) {
            return null;
        }
        List<RenderingFeature.BrokenCreativeDetector.Algorithm> algorithmsList = configuration.getAlgorithmsList();
        Intrinsics.checkNotNullExpressionValue(algorithmsList, "brokenCreativeDetectorConfiguration.algorithmsList");
        ArrayList arrayList = new ArrayList();
        for (RenderingFeature.BrokenCreativeDetector.Algorithm algorithm : algorithmsList) {
            BrokenCreativeAlgorithmType brokenCreativeAlgorithmType = BrokenCreativeAlgorithmType.INSTANCE.get(algorithm.getName());
            BrokenCreativeAlgorithmParams brokenCreativeAlgorithmParams = brokenCreativeAlgorithmType == null ? null : new BrokenCreativeAlgorithmParams(brokenCreativeAlgorithmType, (float) algorithm.getThreshold(), (float) algorithm.getWeight());
            if (brokenCreativeAlgorithmParams != null) {
                arrayList.add(brokenCreativeAlgorithmParams);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createBrokenCreativeDetectorParams$lambda$36;
                    createBrokenCreativeDetectorParams$lambda$36 = AdaptiveRenderingParams.createBrokenCreativeDetectorParams$lambda$36();
                    return createBrokenCreativeDetectorParams$lambda$36;
                }
            });
            return null;
        }
        if (arrayList2.size() != algorithmsList.size()) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingParams$$ExternalSyntheticLambda3
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String createBrokenCreativeDetectorParams$lambda$37;
                    createBrokenCreativeDetectorParams$lambda$37 = AdaptiveRenderingParams.createBrokenCreativeDetectorParams$lambda$37();
                    return createBrokenCreativeDetectorParams$lambda$37;
                }
            });
        }
        long timeout = (long) configuration.getTimeout();
        double downscaleFactor = configuration.getDownscaleFactor();
        boolean errorOnly = configuration.getErrorOnly();
        boolean allowDuplicate = configuration.getAllowDuplicate();
        StopDetectorAfter stopDetectorAfter = StopDetectorAfter.INSTANCE.get(configuration.getStopAfter());
        if (stopDetectorAfter == null) {
            stopDetectorAfter = StopDetectorAfter.AnyCreative;
        }
        return new BrokenCreativeDetectorParams(timeout, downscaleFactor, errorOnly, allowDuplicate, stopDetectorAfter, configuration.getWeightThreshold(), arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createBrokenCreativeDetectorParams$lambda$36() {
        return "BrokenCreativeDetector algorithms is empty";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String createBrokenCreativeDetectorParams$lambda$37() {
        return "Not all BrokenCreativeDetector algorithms were applied, check if the algorithms are specified correctly";
    }

    public final EventParams createEventParams(Rendering.Phase.Event event) {
        EventType eventType;
        if (event == null || event == Rendering.Phase.Event.getDefaultInstance() || (eventType = AdaptiveRenderingParamsKt.toEventType(event.getName())) == null) {
            return null;
        }
        List<Rendering.Phase.Event.Task> tasksList = event.getTasksList();
        Intrinsics.checkNotNullExpressionValue(tasksList, "event.tasksList");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = tasksList.iterator();
        while (it.hasNext()) {
            EventTaskParams createEventTaskParams = createEventTaskParams((Rendering.Phase.Event.Task) it.next());
            if (createEventTaskParams != null) {
                arrayList.add(createEventTaskParams);
            }
        }
        String source = event.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "event.source");
        return new EventParams(eventType, source, arrayList);
    }

    public final EventTaskParams createEventTaskParams(Rendering.Phase.Event.Task task) {
        EventTaskType eventTaskType;
        if (task == null || task == Rendering.Phase.Event.Task.getDefaultInstance() || (eventTaskType = AdaptiveRenderingParamsKt.toEventTaskType(task.getName())) == null) {
            return null;
        }
        String target = task.getTarget();
        Intrinsics.checkNotNullExpressionValue(target, "task.target");
        String value = task.getValue();
        ProtocolStringList stateGroupsList = task.getStateGroupsList();
        Intrinsics.checkNotNullExpressionValue(stateGroupsList, "task.stateGroupsList");
        return new EventTaskParams(eventTaskType, target, value, CollectionsKt.toList(stateGroupsList));
    }
}
