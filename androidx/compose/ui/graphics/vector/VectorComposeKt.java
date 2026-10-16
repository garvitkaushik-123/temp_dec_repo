package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: VectorCompose.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a¦\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", VastAttributes.FILL_COLOR, "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", VastAttributes.STROKE_COLOR, "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Group(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List<? extends PathNode> list, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        String str2;
        int i3;
        float f8;
        int i4;
        float f9;
        int i5;
        float f10;
        int i6;
        int i7;
        float f11;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f12;
        float f13;
        float f14;
        float f15;
        List<? extends PathNode> list2;
        float f16;
        final float f17;
        final float f18;
        final float f19;
        final float f20;
        final float f21;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-213417674);
        ComposerKt.sourceInformation(startRestartGroup, "C(Group)P(2,5,3,4,6,7,8,9)58@2500L585:VectorCompose.kt#huu6hf");
        int i14 = i2 & 1;
        if (i14 != 0) {
            i3 = i | 6;
            str2 = str;
        } else if ((i & 14) == 0) {
            str2 = str;
            i3 = (startRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            f8 = f;
            i3 |= startRestartGroup.changed(f8) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                f9 = f2;
                i3 |= startRestartGroup.changed(f9) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    f10 = f3;
                    i3 |= startRestartGroup.changed(f10) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 57344) == 0) {
                        i3 |= startRestartGroup.changed(f4) ? 16384 : 8192;
                    }
                    i7 = i2 & 32;
                    if (i7 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        f11 = f5;
                    } else {
                        f11 = f5;
                        if ((i & 458752) == 0) {
                            i3 |= startRestartGroup.changed(f11) ? 131072 : 65536;
                        }
                    }
                    i8 = i2 & 64;
                    if (i8 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        i3 |= startRestartGroup.changed(f6) ? 1048576 : 524288;
                    }
                    i9 = i2 & 128;
                    if (i9 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i10 = i9;
                        i3 |= startRestartGroup.changed(f7) ? 8388608 : 4194304;
                        i11 = i2 & 256;
                        if (i11 != 0) {
                            i3 |= 33554432;
                        }
                        if ((i2 & 512) != 0) {
                            i12 = C.ENCODING_PCM_32BIT;
                        } else {
                            if ((1879048192 & i) == 0) {
                                i12 = startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                            }
                            if (i11 != 256) {
                                i13 = i11;
                                if ((1533916891 & i3) == 306783378 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    f19 = f4;
                                    f20 = f6;
                                    list2 = list;
                                    f17 = f8;
                                    f18 = f11;
                                    f21 = f7;
                                    final float f22 = f10;
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final String str3 = str2;
                                        final float f23 = f9;
                                        final List<? extends PathNode> list3 = list2;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                invoke(composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i16) {
                                                VectorComposeKt.Group(str3, f17, f23, f22, f19, f18, f20, f21, list3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                i13 = i11;
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    str2 = "";
                                }
                                if (i15 != 0) {
                                    f8 = 0.0f;
                                }
                                if (i4 != 0) {
                                    f9 = 0.0f;
                                }
                                if (i5 != 0) {
                                    f10 = 0.0f;
                                }
                                f12 = i6 == 0 ? 1.0f : f4;
                                f13 = i7 == 0 ? f11 : 1.0f;
                                f14 = i8 == 0 ? 0.0f : f6;
                                f15 = i10 == 0 ? f7 : 0.0f;
                                if (i13 == 0) {
                                    list2 = VectorKt.getEmptyPath();
                                    i3 &= -234881025;
                                } else {
                                    list2 = list;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if (i13 != 0) {
                                    i3 &= -234881025;
                                }
                                f12 = f4;
                                f15 = f7;
                                list2 = list;
                                f13 = f11;
                                f14 = f6;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                f16 = f15;
                            } else {
                                f16 = f15;
                                ComposerKt.traceEventStart(-213417674, i3, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:57)");
                            }
                            VectorComposeKt$Group$1 vectorComposeKt$Group$1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final GroupComponent invoke() {
                                    return new GroupComponent();
                                }
                            };
                            startRestartGroup.startReplaceableGroup(-548224868);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(vectorComposeKt$Group$1);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
                            Updater.m3600setimpl(m3593constructorimpl, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                    invoke2(groupComponent, str4);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent groupComponent, String str4) {
                                    groupComponent.setName(str4);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                    invoke(groupComponent, f24.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f24) {
                                    groupComponent.setRotation(f24);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                    invoke(groupComponent, f24.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f24) {
                                    groupComponent.setPivotX(f24);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                    invoke(groupComponent, f24.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f24) {
                                    groupComponent.setPivotY(f24);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                    invoke(groupComponent, f24.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f24) {
                                    groupComponent.setScaleX(f24);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                    invoke(groupComponent, f24.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f24) {
                                    groupComponent.setScaleY(f24);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                    invoke(groupComponent, f24.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f24) {
                                    groupComponent.setTranslationX(f24);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                    invoke(groupComponent, f24.floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GroupComponent groupComponent, float f24) {
                                    groupComponent.setTranslationY(f24);
                                }
                            });
                            Updater.m3600setimpl(m3593constructorimpl, list2, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list4) {
                                    invoke2(groupComponent, list4);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list4) {
                                    groupComponent.setClipPathData(list4);
                                }
                            });
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            startRestartGroup.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f17 = f8;
                            f18 = f13;
                            f19 = f12;
                            f20 = f14;
                            f21 = f16;
                            final float f222 = f10;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i3 |= i12;
                        if (i11 != 256) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        VectorComposeKt$Group$1 vectorComposeKt$Group$12 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final GroupComponent invoke() {
                                return new GroupComponent();
                            }
                        };
                        startRestartGroup.startReplaceableGroup(-548224868);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
                        }
                        startRestartGroup.startNode();
                        if (!startRestartGroup.getInserting()) {
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                        Updater.m3600setimpl(m3593constructorimpl2, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                                invoke2(groupComponent, str4);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent groupComponent, String str4) {
                                groupComponent.setName(str4);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                invoke(groupComponent, f24.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent groupComponent, float f24) {
                                groupComponent.setRotation(f24);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                invoke(groupComponent, f24.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent groupComponent, float f24) {
                                groupComponent.setPivotX(f24);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                invoke(groupComponent, f24.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent groupComponent, float f24) {
                                groupComponent.setPivotY(f24);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                invoke(groupComponent, f24.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent groupComponent, float f24) {
                                groupComponent.setScaleX(f24);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                invoke(groupComponent, f24.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent groupComponent, float f24) {
                                groupComponent.setScaleY(f24);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                invoke(groupComponent, f24.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent groupComponent, float f24) {
                                groupComponent.setTranslationX(f24);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                                invoke(groupComponent, f24.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GroupComponent groupComponent, float f24) {
                                groupComponent.setTranslationY(f24);
                            }
                        });
                        Updater.m3600setimpl(m3593constructorimpl2, list2, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list4) {
                                invoke2(groupComponent, list4);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list4) {
                                groupComponent.setClipPathData(list4);
                            }
                        });
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                        function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f17 = f8;
                        f18 = f13;
                        f19 = f12;
                        f20 = f14;
                        f21 = f16;
                        final float f2222 = f10;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i10 = i9;
                    i11 = i2 & 256;
                    if (i11 != 0) {
                    }
                    if ((i2 & 512) != 0) {
                    }
                    i3 |= i12;
                    if (i11 != 256) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    VectorComposeKt$Group$1 vectorComposeKt$Group$122 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final GroupComponent invoke() {
                            return new GroupComponent();
                        }
                    };
                    startRestartGroup.startReplaceableGroup(-548224868);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
                    }
                    startRestartGroup.startNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    Composer m3593constructorimpl22 = Updater.m3593constructorimpl(startRestartGroup);
                    Updater.m3600setimpl(m3593constructorimpl22, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                            invoke2(groupComponent, str4);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent groupComponent, String str4) {
                            groupComponent.setName(str4);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                            invoke(groupComponent, f24.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent groupComponent, float f24) {
                            groupComponent.setRotation(f24);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                            invoke(groupComponent, f24.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent groupComponent, float f24) {
                            groupComponent.setPivotX(f24);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                            invoke(groupComponent, f24.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent groupComponent, float f24) {
                            groupComponent.setPivotY(f24);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                            invoke(groupComponent, f24.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent groupComponent, float f24) {
                            groupComponent.setScaleX(f24);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                            invoke(groupComponent, f24.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent groupComponent, float f24) {
                            groupComponent.setScaleY(f24);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                            invoke(groupComponent, f24.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent groupComponent, float f24) {
                            groupComponent.setTranslationX(f24);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                            invoke(groupComponent, f24.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GroupComponent groupComponent, float f24) {
                            groupComponent.setTranslationY(f24);
                        }
                    });
                    Updater.m3600setimpl(m3593constructorimpl22, list2, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list4) {
                            invoke2(groupComponent, list4);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list4) {
                            groupComponent.setClipPathData(list4);
                        }
                    });
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                    function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f17 = f8;
                    f18 = f13;
                    f19 = f12;
                    f20 = f14;
                    f21 = f16;
                    final float f22222 = f10;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f10 = f3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                i7 = i2 & 32;
                if (i7 == 0) {
                }
                i8 = i2 & 64;
                if (i8 == 0) {
                }
                i9 = i2 & 128;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i2 & 256;
                if (i11 != 0) {
                }
                if ((i2 & 512) != 0) {
                }
                i3 |= i12;
                if (i11 != 256) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i10 == 0) {
                }
                if (i13 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                VectorComposeKt$Group$1 vectorComposeKt$Group$1222 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                startRestartGroup.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
                }
                startRestartGroup.startNode();
                if (!startRestartGroup.getInserting()) {
                }
                Composer m3593constructorimpl222 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl222, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                        invoke2(groupComponent, str4);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent groupComponent, String str4) {
                        groupComponent.setName(str4);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                        invoke(groupComponent, f24.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent groupComponent, float f24) {
                        groupComponent.setRotation(f24);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                        invoke(groupComponent, f24.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent groupComponent, float f24) {
                        groupComponent.setPivotX(f24);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                        invoke(groupComponent, f24.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent groupComponent, float f24) {
                        groupComponent.setPivotY(f24);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                        invoke(groupComponent, f24.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent groupComponent, float f24) {
                        groupComponent.setScaleX(f24);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                        invoke(groupComponent, f24.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent groupComponent, float f24) {
                        groupComponent.setScaleY(f24);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                        invoke(groupComponent, f24.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent groupComponent, float f24) {
                        groupComponent.setTranslationX(f24);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                        invoke(groupComponent, f24.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent groupComponent, float f24) {
                        groupComponent.setTranslationY(f24);
                    }
                });
                Updater.m3600setimpl(m3593constructorimpl222, list2, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list4) {
                        invoke2(groupComponent, list4);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list4) {
                        groupComponent.setClipPathData(list4);
                    }
                });
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
                function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                f17 = f8;
                f18 = f13;
                f19 = f12;
                f20 = f14;
                f21 = f16;
                final float f222222 = f10;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f9 = f2;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            f10 = f3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            i7 = i2 & 32;
            if (i7 == 0) {
            }
            i8 = i2 & 64;
            if (i8 == 0) {
            }
            i9 = i2 & 128;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i2 & 256;
            if (i11 != 0) {
            }
            if ((i2 & 512) != 0) {
            }
            i3 |= i12;
            if (i11 != 256) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i10 == 0) {
            }
            if (i13 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            VectorComposeKt$Group$1 vectorComposeKt$Group$12222 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GroupComponent invoke() {
                    return new GroupComponent();
                }
            };
            startRestartGroup.startReplaceableGroup(-548224868);
            ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
            }
            startRestartGroup.startNode();
            if (!startRestartGroup.getInserting()) {
            }
            Composer m3593constructorimpl2222 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl2222, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                    invoke2(groupComponent, str4);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent groupComponent, String str4) {
                    groupComponent.setName(str4);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                    invoke(groupComponent, f24.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent groupComponent, float f24) {
                    groupComponent.setRotation(f24);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                    invoke(groupComponent, f24.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent groupComponent, float f24) {
                    groupComponent.setPivotX(f24);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                    invoke(groupComponent, f24.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent groupComponent, float f24) {
                    groupComponent.setPivotY(f24);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                    invoke(groupComponent, f24.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent groupComponent, float f24) {
                    groupComponent.setScaleX(f24);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                    invoke(groupComponent, f24.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent groupComponent, float f24) {
                    groupComponent.setScaleY(f24);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                    invoke(groupComponent, f24.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent groupComponent, float f24) {
                    groupComponent.setTranslationX(f24);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                    invoke(groupComponent, f24.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(GroupComponent groupComponent, float f24) {
                    groupComponent.setTranslationY(f24);
                }
            });
            Updater.m3600setimpl(m3593constructorimpl2222, list2, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list4) {
                    invoke2(groupComponent, list4);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list4) {
                    groupComponent.setClipPathData(list4);
                }
            });
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            f17 = f8;
            f18 = f13;
            f19 = f12;
            f20 = f14;
            f21 = f16;
            final float f2222222 = f10;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f8 = f;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        f9 = f2;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        f10 = f3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        i7 = i2 & 32;
        if (i7 == 0) {
        }
        i8 = i2 & 64;
        if (i8 == 0) {
        }
        i9 = i2 & 128;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i2 & 256;
        if (i11 != 0) {
        }
        if ((i2 & 512) != 0) {
        }
        i3 |= i12;
        if (i11 != 256) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        if (i13 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        VectorComposeKt$Group$1 vectorComposeKt$Group$122222 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GroupComponent invoke() {
                return new GroupComponent();
            }
        };
        startRestartGroup.startReplaceableGroup(-548224868);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode)P(1,2)332@12475L9:Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
        }
        startRestartGroup.startNode();
        if (!startRestartGroup.getInserting()) {
        }
        Composer m3593constructorimpl22222 = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl22222, str2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str4) {
                invoke2(groupComponent, str4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupComponent groupComponent, String str4) {
                groupComponent.setName(str4);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, Float.valueOf(f8), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                invoke(groupComponent, f24.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent groupComponent, float f24) {
                groupComponent.setRotation(f24);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, Float.valueOf(f9), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                invoke(groupComponent, f24.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent groupComponent, float f24) {
                groupComponent.setPivotX(f24);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, Float.valueOf(f10), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                invoke(groupComponent, f24.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent groupComponent, float f24) {
                groupComponent.setPivotY(f24);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, Float.valueOf(f12), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                invoke(groupComponent, f24.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent groupComponent, float f24) {
                groupComponent.setScaleX(f24);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, Float.valueOf(f13), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                invoke(groupComponent, f24.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent groupComponent, float f24) {
                groupComponent.setScaleY(f24);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, Float.valueOf(f14), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                invoke(groupComponent, f24.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent groupComponent, float f24) {
                groupComponent.setTranslationX(f24);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, Float.valueOf(f16), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f24) {
                invoke(groupComponent, f24.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent groupComponent, float f24) {
                groupComponent.setTranslationY(f24);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl22222, list2, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list4) {
                invoke2(groupComponent, list4);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupComponent groupComponent, List<? extends PathNode> list4) {
                groupComponent.setClipPathData(list4);
            }
        });
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1894406143, "C72@3070L9:VectorCompose.kt#huu6hf");
        function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 27) & 14));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        f17 = f8;
        f18 = f13;
        f19 = f12;
        f20 = f14;
        f21 = f16;
        final float f22222222 = f10;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m4709Path9cdaXJ4(final List<? extends PathNode> list, int i, String str, Brush brush, float f, Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, Composer composer, int i4, int i5, final int i6) {
        int i7;
        float f8;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation(startRestartGroup, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)115@5068L876:VectorCompose.kt#huu6hf");
        int defaultFillType = (i6 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i6 & 4) != 0 ? "" : str;
        Brush brush3 = (i6 & 8) != 0 ? null : brush;
        float f9 = (i6 & 16) != 0 ? 1.0f : f;
        final Brush brush4 = (i6 & 32) == 0 ? brush2 : null;
        float f10 = (i6 & 64) != 0 ? 1.0f : f2;
        float f11 = (i6 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i6 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f12 = (i6 & 1024) != 0 ? 4.0f : f4;
        float f13 = (i6 & 2048) != 0 ? 0.0f : f5;
        float f14 = (i6 & 4096) != 0 ? 1.0f : f6;
        float f15 = (i6 & 8192) != 0 ? 0.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            i7 = defaultFillType;
            f8 = f9;
            i8 = i4;
            i9 = i5;
            ComposerKt.traceEventStart(-1478270750, i8, i9, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:114)");
        } else {
            i7 = defaultFillType;
            f8 = f9;
            i8 = i4;
            i9 = i5;
        }
        final VectorComposeKt$Path$1 vectorComposeKt$Path$1 = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PathComponent invoke() {
                return new PathComponent();
            }
        };
        startRestartGroup.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation(startRestartGroup, "CC(ComposeNode):Composables.kt#9igjgp");
        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.graphics.vector.PathComponent, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final PathComponent invoke() {
                    return Function0.this.invoke();
                }
            });
        } else {
            startRestartGroup.useNode();
        }
        Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
        Updater.m3600setimpl(m3593constructorimpl, str2, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str3) {
                invoke2(pathComponent, str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent pathComponent, String str3) {
                pathComponent.setName(str3);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list2) {
                invoke2(pathComponent, list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent pathComponent, List<? extends PathNode> list2) {
                pathComponent.setPathData(list2);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, PathFillType.m4338boximpl(i7), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType) {
                m4711invokepweu1eQ(pathComponent, pathFillType.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-pweu1eQ, reason: not valid java name */
            public final void m4711invokepweu1eQ(PathComponent pathComponent, int i10) {
                pathComponent.m4703setPathFillTypeoQ8Xj4U(i10);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush5) {
                invoke2(pathComponent, brush5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent pathComponent, Brush brush5) {
                pathComponent.setFill(brush5);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f8), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f16) {
                invoke(pathComponent, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent pathComponent, float f16) {
                pathComponent.setFillAlpha(f16);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush5) {
                invoke2(pathComponent, brush5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent pathComponent, Brush brush5) {
                pathComponent.setStroke(brush5);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f10), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f16) {
                invoke(pathComponent, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent pathComponent, float f16) {
                pathComponent.setStrokeAlpha(f16);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f11), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f16) {
                invoke(pathComponent, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent pathComponent, float f16) {
                pathComponent.setStrokeLineWidth(f16);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, StrokeJoin.m4418boximpl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                m4712invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-kLtJ_vA, reason: not valid java name */
            public final void m4712invokekLtJ_vA(PathComponent pathComponent, int i10) {
                pathComponent.m4705setStrokeLineJoinWw9F2mQ(i10);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, StrokeCap.m4408boximpl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                m4710invokeCSYIeUk(pathComponent, strokeCap.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-CSYIeUk, reason: not valid java name */
            public final void m4710invokeCSYIeUk(PathComponent pathComponent, int i10) {
                pathComponent.m4704setStrokeLineCapBeK7IIE(i10);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f12), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f16) {
                invoke(pathComponent, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent pathComponent, float f16) {
                pathComponent.setStrokeLineMiter(f16);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f13), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f16) {
                invoke(pathComponent, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent pathComponent, float f16) {
                pathComponent.setTrimPathStart(f16);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f14), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f16) {
                invoke(pathComponent, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent pathComponent, float f16) {
                pathComponent.setTrimPathEnd(f16);
            }
        });
        Updater.m3600setimpl(m3593constructorimpl, Float.valueOf(f15), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f16) {
                invoke(pathComponent, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent pathComponent, float f16) {
                pathComponent.setTrimPathOffset(f16);
            }
        });
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final int i10 = defaultStrokeLineJoin;
            final float f16 = f14;
            final float f17 = f11;
            final float f18 = f12;
            final float f19 = f15;
            final int i11 = i7;
            final int i12 = i9;
            final float f20 = f10;
            final int i13 = defaultStrokeLineCap;
            final float f21 = f13;
            final int i14 = i8;
            final String str3 = str2;
            final Brush brush5 = brush3;
            final float f22 = f8;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    VectorComposeKt.m4709Path9cdaXJ4(list, i11, str3, brush5, f22, brush4, f20, f17, i13, i10, f18, f21, f16, f19, composer2, RecomposeScopeImplKt.updateChangedFlags(i14 | 1), RecomposeScopeImplKt.updateChangedFlags(i12), i6);
                }
            });
        }
    }
}
