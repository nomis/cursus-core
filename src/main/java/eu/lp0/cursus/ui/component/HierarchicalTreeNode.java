/*
	cursus - Race series management program
	Copyright 2011  Simon Arlott

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.lp0.cursus.ui.component;

import java.util.Iterator;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public abstract class HierarchicalTreeNode<T extends Comparable<T>, N extends ExpandingTreeNode> extends ExpandingTreeNode {
	public HierarchicalTreeNode(Object userObject) {
		super(userObject);
	}

	public void updateTree(JTree tree, TreePath path, List<T> items) {
		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();

		if (items == null || items.isEmpty()) {
			removeAllChildren();
			model.nodeStructureChanged(this);
			return;
		}

		Iterator<T> iter = items.iterator();
		T next = iter.hasNext() ? iter.next() : null;
		int i = 0;

		while (next != null || i < getChildCount()) {
			if (i < getChildCount()) {
				@SuppressWarnings("unchecked")
				N node = (N)getChildAt(i);
				@SuppressWarnings("unchecked")
				T user = (T)node.getUserObject();

				if (next == null || user.compareTo(next) < 0) {
					model.removeNodeFromParent(node);
					continue;
				} else if (user.equals(next)) {
					updateNode(tree, path, node, user);
					model.nodeChanged(this);
				} else {
					N child = constructChildNode(next);
					model.insertNodeInto(child, this, i);
					child.expandAll(tree, appendedTreePath(path, child));
				}
			} else {
				N child = constructChildNode(next);
				model.insertNodeInto(child, this, i);
				child.expandAll(tree, appendedTreePath(path, child));
			}

			i++;
			next = iter.hasNext() ? iter.next() : null;
		}
	}

	protected void updateNode(JTree tree, TreePath path, N node, T item) {
		node.setUserObject(item);
	}

	protected abstract N constructChildNode(T item);
}