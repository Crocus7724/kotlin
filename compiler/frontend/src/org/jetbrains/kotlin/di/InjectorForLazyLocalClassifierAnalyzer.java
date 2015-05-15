/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.di;

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.builtins.KotlinBuiltIns;
import org.jetbrains.kotlin.builtins.ReflectionTypes;
import org.jetbrains.kotlin.context.ModuleContext;
import org.jetbrains.kotlin.context.TypeLazinessToken;
import org.jetbrains.kotlin.descriptors.impl.ModuleDescriptorImpl;
import org.jetbrains.kotlin.platform.PlatformToKotlinClassMap;
import org.jetbrains.kotlin.resolve.*;
import org.jetbrains.kotlin.resolve.TypeResolver.FlexibleTypeCapabilitiesProvider;
import org.jetbrains.kotlin.resolve.calls.*;
import org.jetbrains.kotlin.resolve.calls.tasks.TaskPrioritizer;
import org.jetbrains.kotlin.resolve.lazy.NoFileScopeProvider;
import org.jetbrains.kotlin.resolve.lazy.NoTopLevelDescriptorProvider;
import org.jetbrains.kotlin.resolve.validation.SymbolUsageValidator;
import org.jetbrains.kotlin.resolve.varianceChecker.VarianceChecker;
import org.jetbrains.kotlin.storage.StorageManager;
import org.jetbrains.kotlin.types.DynamicTypesSettings;
import org.jetbrains.kotlin.types.expressions.*;

import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.kotlin.generators.injectors.InjectorsPackage. DO NOT EDIT! */
@SuppressWarnings("all")
public class InjectorForLazyLocalClassifierAnalyzer {

    private final ModuleContext moduleContext;
    private final KotlinBuiltIns kotlinBuiltIns;
    private final ModuleDescriptorImpl moduleDescriptor;
    private final PlatformToKotlinClassMap platformToKotlinClassMap;
    private final Project project;
    private final StorageManager storageManager;
    private final BindingTrace bindingTrace;
    private final AdditionalCheckerProvider additionalCheckerProvider;
    private final SymbolUsageValidator symbolUsageValidator;
    private final DynamicTypesSettings dynamicTypesSettings;
    private final LocalClassDescriptorHolder localClassDescriptorHolder;
    private final LazyTopDownAnalyzer lazyTopDownAnalyzer;
    private final NoTopLevelDescriptorProvider noTopLevelDescriptorProvider;
    private final NoFileScopeProvider noFileScopeProvider;
    private final DeclarationScopeProviderForLocalClassifierAnalyzer declarationScopeProviderForLocalClassifierAnalyzer;
    private final LocalLazyDeclarationResolver localLazyDeclarationResolver;
    private final BodyResolver bodyResolver;
    private final AnnotationResolver annotationResolver;
    private final CallResolver callResolver;
    private final ArgumentTypeResolver argumentTypeResolver;
    private final ExpressionTypingServices expressionTypingServices;
    private final ExpressionTypingComponents expressionTypingComponents;
    private final CallExpressionResolver callExpressionResolver;
    private final ControlStructureTypingUtils controlStructureTypingUtils;
    private final DescriptorResolver descriptorResolver;
    private final DelegatedPropertyResolver delegatedPropertyResolver;
    private final TypeResolver typeResolver;
    private final QualifiedExpressionResolver qualifiedExpressionResolver;
    private final FlexibleTypeCapabilitiesProvider flexibleTypeCapabilitiesProvider;
    private final TypeLazinessToken typeLazinessToken;
    private final ForLoopConventionsChecker forLoopConventionsChecker;
    private final FakeCallResolver fakeCallResolver;
    private final FunctionDescriptorResolver functionDescriptorResolver;
    private final LocalClassifierAnalyzer localClassifierAnalyzer;
    private final MultiDeclarationResolver multiDeclarationResolver;
    private final ReflectionTypes reflectionTypes;
    private final ValueParameterResolver valueParameterResolver;
    private final StatementFilter statementFilter;
    private final CallCompleter callCompleter;
    private final CandidateResolver candidateResolver;
    private final TaskPrioritizer taskPrioritizer;
    private final ControlFlowAnalyzer controlFlowAnalyzer;
    private final DeclarationsChecker declarationsChecker;
    private final ModifiersChecker modifiersChecker;
    private final FunctionAnalyzerExtension functionAnalyzerExtension;
    private final ScriptBodyResolver scriptBodyResolver;
    private final DeclarationResolver declarationResolver;
    private final OverloadResolver overloadResolver;
    private final OverrideResolver overrideResolver;
    private final VarianceChecker varianceChecker;

    public InjectorForLazyLocalClassifierAnalyzer(
        @NotNull ModuleContext moduleContext,
        @NotNull BindingTrace bindingTrace,
        @NotNull AdditionalCheckerProvider additionalCheckerProvider,
        @NotNull DynamicTypesSettings dynamicTypesSettings,
        @NotNull LocalClassDescriptorHolder localClassDescriptorHolder
    ) {
        this.moduleContext = moduleContext;
        this.kotlinBuiltIns = moduleContext.getBuiltIns();
        this.moduleDescriptor = moduleContext.getModule();
        this.platformToKotlinClassMap = moduleContext.getPlatformToKotlinClassMap();
        this.project = moduleContext.getProject();
        this.storageManager = moduleContext.getStorageManager();
        this.bindingTrace = bindingTrace;
        this.additionalCheckerProvider = additionalCheckerProvider;
        this.symbolUsageValidator = additionalCheckerProvider.getSymbolUsageValidator();
        this.dynamicTypesSettings = dynamicTypesSettings;
        this.localClassDescriptorHolder = localClassDescriptorHolder;
        this.lazyTopDownAnalyzer = new LazyTopDownAnalyzer();
        this.noTopLevelDescriptorProvider = NoTopLevelDescriptorProvider.INSTANCE$;
        this.noFileScopeProvider = NoFileScopeProvider.INSTANCE$;
        this.localLazyDeclarationResolver = new LocalLazyDeclarationResolver(moduleContext, bindingTrace, localClassDescriptorHolder);
        this.declarationScopeProviderForLocalClassifierAnalyzer = new DeclarationScopeProviderForLocalClassifierAnalyzer(localLazyDeclarationResolver, localClassDescriptorHolder);
        this.bodyResolver = new BodyResolver();
        this.annotationResolver = new AnnotationResolver();
        this.callResolver = new CallResolver();
        this.argumentTypeResolver = new ArgumentTypeResolver();
        this.expressionTypingComponents = new ExpressionTypingComponents();
        this.expressionTypingServices = new ExpressionTypingServices(expressionTypingComponents);
        this.callExpressionResolver = new CallExpressionResolver(callResolver, kotlinBuiltIns);
        this.controlStructureTypingUtils = new ControlStructureTypingUtils(callResolver);
        this.descriptorResolver = new DescriptorResolver();
        this.delegatedPropertyResolver = new DelegatedPropertyResolver();
        this.qualifiedExpressionResolver = new QualifiedExpressionResolver();
        this.flexibleTypeCapabilitiesProvider = new FlexibleTypeCapabilitiesProvider();
        this.typeLazinessToken = new TypeLazinessToken();
        this.typeResolver = new TypeResolver(annotationResolver, qualifiedExpressionResolver, moduleDescriptor, flexibleTypeCapabilitiesProvider, storageManager, typeLazinessToken, dynamicTypesSettings);
        this.forLoopConventionsChecker = new ForLoopConventionsChecker();
        this.fakeCallResolver = new FakeCallResolver(project, callResolver);
        this.functionDescriptorResolver = new FunctionDescriptorResolver(typeResolver, descriptorResolver, annotationResolver, storageManager, expressionTypingServices, kotlinBuiltIns);
        this.localClassifierAnalyzer = new LocalClassifierAnalyzer(descriptorResolver, functionDescriptorResolver, typeResolver, annotationResolver);
        this.multiDeclarationResolver = new MultiDeclarationResolver(fakeCallResolver, descriptorResolver, typeResolver, symbolUsageValidator);
        this.reflectionTypes = new ReflectionTypes(moduleDescriptor);
        this.valueParameterResolver = new ValueParameterResolver(additionalCheckerProvider, expressionTypingServices);
        this.statementFilter = new StatementFilter();
        this.candidateResolver = new CandidateResolver();
        this.callCompleter = new CallCompleter(argumentTypeResolver, candidateResolver);
        this.taskPrioritizer = new TaskPrioritizer(storageManager);
        this.controlFlowAnalyzer = new ControlFlowAnalyzer();
        this.declarationsChecker = new DeclarationsChecker();
        this.modifiersChecker = new ModifiersChecker(bindingTrace, additionalCheckerProvider);
        this.functionAnalyzerExtension = new FunctionAnalyzerExtension();
        this.scriptBodyResolver = new ScriptBodyResolver();
        this.declarationResolver = new DeclarationResolver();
        this.overloadResolver = new OverloadResolver();
        this.overrideResolver = new OverrideResolver();
        this.varianceChecker = new VarianceChecker(bindingTrace);

        this.lazyTopDownAnalyzer.setBodyResolver(bodyResolver);
        this.lazyTopDownAnalyzer.setDeclarationResolver(declarationResolver);
        this.lazyTopDownAnalyzer.setDeclarationScopeProvider(declarationScopeProviderForLocalClassifierAnalyzer);
        this.lazyTopDownAnalyzer.setFileScopeProvider(noFileScopeProvider);
        this.lazyTopDownAnalyzer.setLazyDeclarationResolver(localLazyDeclarationResolver);
        this.lazyTopDownAnalyzer.setModuleDescriptor(moduleDescriptor);
        this.lazyTopDownAnalyzer.setOverloadResolver(overloadResolver);
        this.lazyTopDownAnalyzer.setOverrideResolver(overrideResolver);
        this.lazyTopDownAnalyzer.setTopLevelDescriptorProvider(noTopLevelDescriptorProvider);
        this.lazyTopDownAnalyzer.setTrace(bindingTrace);
        this.lazyTopDownAnalyzer.setVarianceChecker(varianceChecker);

        declarationScopeProviderForLocalClassifierAnalyzer.setFileScopeProvider(noFileScopeProvider);

        localLazyDeclarationResolver.setDeclarationScopeProvider(declarationScopeProviderForLocalClassifierAnalyzer);
        localLazyDeclarationResolver.setTopLevelDescriptorProvider(noTopLevelDescriptorProvider);

        bodyResolver.setAdditionalCheckerProvider(additionalCheckerProvider);
        bodyResolver.setAnnotationResolver(annotationResolver);
        bodyResolver.setCallResolver(callResolver);
        bodyResolver.setControlFlowAnalyzer(controlFlowAnalyzer);
        bodyResolver.setDeclarationsChecker(declarationsChecker);
        bodyResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        bodyResolver.setExpressionTypingServices(expressionTypingServices);
        bodyResolver.setFunctionAnalyzerExtension(functionAnalyzerExtension);
        bodyResolver.setScriptBodyResolverResolver(scriptBodyResolver);
        bodyResolver.setTrace(bindingTrace);
        bodyResolver.setValueParameterResolver(valueParameterResolver);

        annotationResolver.setCallResolver(callResolver);
        annotationResolver.setStorageManager(storageManager);
        annotationResolver.setTypeResolver(typeResolver);

        callResolver.setAdditionalCheckerProvider(additionalCheckerProvider);
        callResolver.setArgumentTypeResolver(argumentTypeResolver);
        callResolver.setCallCompleter(callCompleter);
        callResolver.setCandidateResolver(candidateResolver);
        callResolver.setExpressionTypingServices(expressionTypingServices);
        callResolver.setTaskPrioritizer(taskPrioritizer);
        callResolver.setTypeResolver(typeResolver);

        argumentTypeResolver.setBuiltIns(kotlinBuiltIns);
        argumentTypeResolver.setExpressionTypingServices(expressionTypingServices);
        argumentTypeResolver.setTypeResolver(typeResolver);

        expressionTypingServices.setStatementFilter(statementFilter);

        expressionTypingComponents.setAdditionalCheckerProvider(additionalCheckerProvider);
        expressionTypingComponents.setAnnotationResolver(annotationResolver);
        expressionTypingComponents.setBuiltIns(kotlinBuiltIns);
        expressionTypingComponents.setCallExpressionResolver(callExpressionResolver);
        expressionTypingComponents.setCallResolver(callResolver);
        expressionTypingComponents.setControlStructureTypingUtils(controlStructureTypingUtils);
        expressionTypingComponents.setDescriptorResolver(descriptorResolver);
        expressionTypingComponents.setDynamicTypesSettings(dynamicTypesSettings);
        expressionTypingComponents.setExpressionTypingServices(expressionTypingServices);
        expressionTypingComponents.setForLoopConventionsChecker(forLoopConventionsChecker);
        expressionTypingComponents.setFunctionDescriptorResolver(functionDescriptorResolver);
        expressionTypingComponents.setGlobalContext(moduleContext);
        expressionTypingComponents.setLocalClassifierAnalyzer(localClassifierAnalyzer);
        expressionTypingComponents.setMultiDeclarationResolver(multiDeclarationResolver);
        expressionTypingComponents.setPlatformToKotlinClassMap(platformToKotlinClassMap);
        expressionTypingComponents.setReflectionTypes(reflectionTypes);
        expressionTypingComponents.setSymbolUsageValidator(symbolUsageValidator);
        expressionTypingComponents.setTypeResolver(typeResolver);
        expressionTypingComponents.setValueParameterResolver(valueParameterResolver);

        callExpressionResolver.setExpressionTypingServices(expressionTypingServices);

        descriptorResolver.setAnnotationResolver(annotationResolver);
        descriptorResolver.setBuiltIns(kotlinBuiltIns);
        descriptorResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        descriptorResolver.setExpressionTypingServices(expressionTypingServices);
        descriptorResolver.setStorageManager(storageManager);
        descriptorResolver.setTypeResolver(typeResolver);

        delegatedPropertyResolver.setAdditionalCheckerProvider(additionalCheckerProvider);
        delegatedPropertyResolver.setBuiltIns(kotlinBuiltIns);
        delegatedPropertyResolver.setCallResolver(callResolver);
        delegatedPropertyResolver.setExpressionTypingServices(expressionTypingServices);

        qualifiedExpressionResolver.setSymbolUsageValidator(symbolUsageValidator);

        forLoopConventionsChecker.setBuiltIns(kotlinBuiltIns);
        forLoopConventionsChecker.setFakeCallResolver(fakeCallResolver);
        forLoopConventionsChecker.setSymbolUsageValidator(symbolUsageValidator);

        candidateResolver.setArgumentTypeResolver(argumentTypeResolver);

        controlFlowAnalyzer.setTrace(bindingTrace);

        declarationsChecker.setDescriptorResolver(descriptorResolver);
        declarationsChecker.setModifiersChecker(modifiersChecker);
        declarationsChecker.setTrace(bindingTrace);

        functionAnalyzerExtension.setTrace(bindingTrace);

        scriptBodyResolver.setAdditionalCheckerProvider(additionalCheckerProvider);
        scriptBodyResolver.setExpressionTypingServices(expressionTypingServices);

        declarationResolver.setAnnotationResolver(annotationResolver);
        declarationResolver.setTrace(bindingTrace);

        overloadResolver.setTrace(bindingTrace);

        overrideResolver.setTrace(bindingTrace);

    }

    @PreDestroy
    public void destroy() {
    }

    public LazyTopDownAnalyzer getLazyTopDownAnalyzer() {
        return this.lazyTopDownAnalyzer;
    }

}
