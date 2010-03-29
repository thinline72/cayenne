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
package org.apache.cayenne.modeler.undo;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import org.apache.cayenne.modeler.util.CayenneTableModel;

public class CayenneTableModelUndoableEdit extends AbstractUndoableEdit {

    private CayenneTableModel model;
    private Object oldValue;
    private Object newValue;
    private int row;
    private int col;

    @Override
    public String getPresentationName() {
        return "Cell Change";
    }
    
    public CayenneTableModelUndoableEdit(CayenneTableModel model, Object oldValue, Object newValue,
            int row, int col) {
        
        this.model = model;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.row = row;
        this.col = col;
        
    }

    @Override
    public boolean canRedo() {
        return true;
    }

    @Override
    public void redo() throws CannotRedoException {
        model.setUpdatedValueAt(newValue, row, col);
        model.fireTableCellUpdated(row, col);
    }

    @Override
    public void undo() throws CannotUndoException {
        model.setUpdatedValueAt(oldValue, row, col);
        model.fireTableCellUpdated(row, col);
    }
}
