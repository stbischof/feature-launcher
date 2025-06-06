/**
 * Copyright (c) 2024 Kentyou and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Kentyou - initial implementation
 */
package org.eclipse.osgi.technology.featurelauncher.launch.cli.plain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.osgi.technology.featurelauncher.common.decorator.impl.DecorationContext;
import org.eclipse.osgi.technology.featurelauncher.launch.spi.SecondStageLauncher;
import org.osgi.service.feature.Feature;
import org.osgi.service.featurelauncher.repository.ArtifactRepository;

public class TestSecondStageLauncher implements SecondStageLauncher {

	static final List<TestSecondStageLauncher> launchers = new ArrayList<>();

	private boolean called = false;
	private Feature feature;
	private DecorationContext<?> context;
	private List<? extends ArtifactRepository> repositories;
	private Optional<Object> frameworkFactory;
	private Map<String, Object> variableOverrides;
	private Map<String, Object> configurationProperties;
	private Map<String, String> frameworkProperties;

	@Override
	public LaunchResult launch(Feature feature, DecorationContext<?> context,
	        List<? extends ArtifactRepository> repositories, Optional<Object> frameworkFactory,
	        Map<String, Object> variableOverrides, Map<String, Object> configurationProperties,
	        Map<String, String> frameworkProperties) {

		if (called) {
			throw new IllegalStateException("Already called");
		}
		this.called = true;
		this.feature = feature;
		this.context = context;
		this.repositories = repositories;
		this.frameworkFactory = frameworkFactory;
		this.variableOverrides = variableOverrides;
		this.configurationProperties = configurationProperties;
		this.frameworkProperties = frameworkProperties;

		launchers.add(this);

		return new LaunchResult() {

			@Override
			public void waitForStop(long time) throws InterruptedException {
				// No wating
			}
		};
	}

	public Feature getFeature() {
		return feature;
	}

	public DecorationContext<?> getContext() {
		return context;
	}

	public List<? extends ArtifactRepository> getRepositories() {
		return repositories;
	}

	public Optional<Object> getFrameworkFactory() {
		return frameworkFactory;
	}

	public Map<String, Object> getVariableOverrides() {
		return variableOverrides;
	}

	public Map<String, Object> getConfigurationProperties() {
		return configurationProperties;
	}

	public Map<String, String> getFrameworkProperties() {
		return frameworkProperties;
	}
}