/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.lifecycle.ref;

import junit.framework.TestCase;

import org.apache.cayenne.ObjectId;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.lifecycle.db.E1;

public class ReferenceableHandlerTest extends TestCase {

    private ServerRuntime runtime;

    @Override
    protected void setUp() throws Exception {
        runtime = new ServerRuntime("cayenne-lifecycle.xml");
    }

    @Override
    protected void tearDown() throws Exception {
        runtime.shutdown();
    }

    public void testGetUuid() {
        ReferenceableHandler handler = new ReferenceableHandler(runtime
                .getChannel()
                .getEntityResolver());

        E1 e1 = new E1();
        e1.setObjectId(new ObjectId("E1", "ID", 5));
        assertEquals("E1:5", handler.getUuid(e1));
    }

    public void testGetUuid_TempException() {
        ReferenceableHandler handler = new ReferenceableHandler(runtime
                .getChannel()
                .getEntityResolver());

        E1 e1 = new E1();
        e1.setObjectId(new ObjectId("E1"));

        try {
            handler.getUuid(e1);
        }
        catch (IllegalArgumentException e) {
            // expected
        }
    }

    public void testGetUuid_TempWithReplacement() {
        ReferenceableHandler handler = new ReferenceableHandler(runtime
                .getChannel()
                .getEntityResolver());

        E1 e1 = new E1();
        e1.setObjectId(new ObjectId("E1"));
        e1.getObjectId().getReplacementIdMap().put("ID", 6);

        assertEquals("E1:6", handler.getUuid(e1));
    }
}
