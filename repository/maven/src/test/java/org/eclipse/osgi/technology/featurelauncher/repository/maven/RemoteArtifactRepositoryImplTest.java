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
package org.eclipse.osgi.technology.featurelauncher.repository.maven;

import org.eclipse.osgi.technology.featurelauncher.repository.maven.RemoteRepositoryImpl;
import org.eclipse.osgi.technology.featurelauncher.repository.spi.Repository;
import org.eclipse.osgi.technology.featurelauncher.repository.tests.RemoteRepositoryTest;

/**
 * Tests
 * {@link org.eclipse.osgi.technology.featurelauncher.repository.maven.LocalArtifactRepositoryImpl}
 * and
 * {@link org.eclipse.osgi.technology.featurelauncher.repository.maven.MavenRepositoryFactory}
 * 
 * As defined in: "160.2.1.2 Local Repositories"
 * 
 * @author Michael H. Siemaszko (mhs@into.software)
 * @since Sep 17, 2024
 */
public class RemoteArtifactRepositoryImplTest extends RemoteRepositoryTest{

	@Override
	protected Class<? extends Repository> getRemoteRepoImplType() {
		return RemoteRepositoryImpl.class;
	}

}
