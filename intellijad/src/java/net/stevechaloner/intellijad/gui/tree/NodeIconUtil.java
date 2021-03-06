/*
 * Copyright 2007 Steve Chaloner
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package net.stevechaloner.intellijad.gui.tree;

import com.intellij.openapi.vfs.VirtualFile;
import net.stevechaloner.intellijad.gui.IntelliJadIcon;

import javax.swing.Icon;
import javax.swing.JTree;

/**
 * Utils for tree node icons.
 */
class NodeIconUtil
{
    static Icon getIconFor(JTree jTree,
                           Object value,
                           boolean expanded)
    {
        Icon icon = IntelliJadIcon.JAVA.get();
        if (value.equals(jTree.getModel().getRoot()))
        {
            icon = IntelliJadIcon.INTELLIJAD_LOGO_16X16.get();
        }
        else
        {
            if (isDirectory((VisitableTreeNode)value))
            {
                icon = expanded ? IntelliJadIcon.PACKAGE_OPEN.get() : IntelliJadIcon.PACKAGE_CLOSED.get();
            }
        }
        return icon;
    }

    private static boolean isDirectory(VisitableTreeNode node)
    {
        boolean isDirectory = false;
        Object o = node.getUserObject();
        if (o instanceof CheckBoxTreeNode)
        {
            VirtualFile file = (VirtualFile)((CheckBoxTreeNode)o).getUserObject();
            isDirectory = file.isDirectory();
        }
        return isDirectory;
    }
}
