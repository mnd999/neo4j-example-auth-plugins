/**
 * Copyright (c) 2002-2017 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4j.example.auth.plugin.integration;

import com.neo4j.harness.internal.EnterpriseInProcessNeo4jBuilder;
import java.lang.reflect.Field;
import java.nio.file.Path;
import org.neo4j.harness.internal.AbstractInProcessNeo4jBuilder;

public class PluginInProcessNeo4jBuilder extends EnterpriseInProcessNeo4jBuilder {
    public PluginInProcessNeo4jBuilder(Path workingDir) {
        super(workingDir);
    }

    public Path getRealServerPath() throws Exception {
        // Get around the test harness always creating a random directory name and not telling us what it is
        Field field = AbstractInProcessNeo4jBuilder.class.getDeclaredField("serverFolder");
        field.setAccessible(true);
        return (Path) field.get(this);
    }
}
