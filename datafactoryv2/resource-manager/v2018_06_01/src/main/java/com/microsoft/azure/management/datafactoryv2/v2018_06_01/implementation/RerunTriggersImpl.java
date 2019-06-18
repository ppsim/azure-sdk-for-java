/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.datafactoryv2.v2018_06_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.datafactoryv2.v2018_06_01.RerunTriggers;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import rx.Completable;
import com.microsoft.azure.management.datafactoryv2.v2018_06_01.TriggerFactoryTriggerResource;

class RerunTriggersImpl extends WrapperImpl<RerunTriggersInner> implements RerunTriggers {
    private final DataFactoryManager manager;

    RerunTriggersImpl(DataFactoryManager manager) {
        super(manager.inner().rerunTriggers());
        this.manager = manager;
    }

    public DataFactoryManager manager() {
        return this.manager;
    }

    @Override
    public TriggerFactoryTriggerResourceImpl define(String name) {
        return wrapModel(name);
    }

    private TriggerFactoryTriggerResourceImpl wrapModel(TriggerResourceInner inner) {
        return  new TriggerFactoryTriggerResourceImpl(inner, manager());
    }

    private TriggerFactoryTriggerResourceImpl wrapModel(String name) {
        return new TriggerFactoryTriggerResourceImpl(name, this.manager());
    }

    @Override
    public Completable startAsync(String resourceGroupName, String factoryName, String triggerName, String rerunTriggerName) {
        RerunTriggersInner client = this.inner();
        return client.startAsync(resourceGroupName, factoryName, triggerName, rerunTriggerName).toCompletable();
    }

    @Override
    public Completable stopAsync(String resourceGroupName, String factoryName, String triggerName, String rerunTriggerName) {
        RerunTriggersInner client = this.inner();
        return client.stopAsync(resourceGroupName, factoryName, triggerName, rerunTriggerName).toCompletable();
    }

    @Override
    public Completable cancelAsync(String resourceGroupName, String factoryName, String triggerName, String rerunTriggerName) {
        RerunTriggersInner client = this.inner();
        return client.cancelAsync(resourceGroupName, factoryName, triggerName, rerunTriggerName).toCompletable();
    }

    @Override
    public Observable<TriggerFactoryTriggerResource> listByTriggerAsync(final String resourceGroupName, final String factoryName, final String triggerName) {
        RerunTriggersInner client = this.inner();
        return client.listByTriggerAsync(resourceGroupName, factoryName, triggerName)
        .flatMapIterable(new Func1<Page<RerunTriggerResourceInner>, Iterable<RerunTriggerResourceInner>>() {
            @Override
            public Iterable<RerunTriggerResourceInner> call(Page<RerunTriggerResourceInner> page) {
                return page.items();
            }
        })
        .map(new Func1<TriggerResourceInner, TriggerFactoryTriggerResource>() {
            @Override
            public TriggerFactoryTriggerResource call(TriggerResourceInner inner) {
                return wrapModel(inner);
            }
        });
    }

}