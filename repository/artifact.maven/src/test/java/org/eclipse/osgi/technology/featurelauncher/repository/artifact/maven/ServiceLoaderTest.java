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
package org.eclipse.osgi.technology.featurelauncher.repository.artifact.maven;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ServiceLoader;

import org.eclipse.osgi.technology.featurelauncher.repository.artifact.maven.MavenArtifactRepositoryFactory;
import org.junit.jupiter.api.Test;
import org.osgi.service.featurelauncher.repository.ArtifactRepositoryFactory;

/**
 * Try loading using service loader
 */
public class ServiceLoaderTest {

	@Test
	public void testArtifactRepoServiceLoader() throws Exception {
		ArtifactRepositoryFactory arf = ServiceLoader.load(ArtifactRepositoryFactory.class)
				.findFirst().get();
		assertNotNull(arf);
		assertTrue(MavenArtifactRepositoryFactory.class.isInstance(arf));
	}
}
