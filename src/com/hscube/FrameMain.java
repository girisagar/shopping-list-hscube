package com.hscube;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.user.items.Category;
import com.user.items.CategoryController;
import com.user.items.Item;
import com.user.items.ItemController;
import com.user.items.Priority;
import com.user.items.PriorityController;
import com.user.items.WishList;
import com.user.items.WishlistController;

import comparators.ItemCategoryAscComparator;
import comparators.ItemCategoryDesComparator;
import comparators.ItemNameAscComparator;
import comparators.ItemNameDesComparator;
import comparators.ItemPriorityAscComparator;
import comparators.ItemPriorityDesComparator;
import comparators.ItemQuantityAscComparator;
import comparators.ItemQuantityDesComparator;

/**
 * @author s s
 */


public class FrameMain extends JFrame {
	private static ArrayList<Item> arrItems;
	private static ArrayList<WishList> arrWishLists;
	
	private static  Boolean nameAsc = false;
	private static  Boolean quantityAsc = false;
	private static  Boolean priorityAsc = false;
	private static  Boolean categoryAsc = false;
	
	public FrameMain() {
		initComponents();
	}

	private void btnAddActionPerformed(ActionEvent e) {
		AddFrames n = new AddFrames();
		n.setVisible(true);
	}
	
	private void btnCheckoutActionPerformed(ActionEvent e) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		ArrayList<Integer> arrListPrinting = new ArrayList<Integer>();
		

		for (int i = 0; i < tblWishlist.getRowCount(); i++) {
			Boolean chked = Boolean
					.valueOf(tblWishlist.getValueAt(i, 1).toString());
			int ID = (int) tblWishlist.getValueAt(i, 0);
			
			if (chked) {
				arrList.add(ID);
				arrListPrinting.add(i);
				tblWishlist.setValueAt(Boolean.FALSE, i, 1);
			}
		}
		
		JTable tblPrint = new JTable();
		
		DefaultTableModel modelPrint = new DefaultTableModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return Integer.class;
				default:
					return String.class;
				}
			}
		};

		tblPrint.setModel(modelPrint);

		modelPrint.addColumn("Name");
		modelPrint.addColumn("Category");
		modelPrint.addColumn("Priority");
		modelPrint.addColumn("Quantity");

		// Data Row


		{
			TableColumnModel cm = tblItem.getColumnModel();
			cm.getColumn(0).setResizable(false);
			cm.getColumn(1).setResizable(false);
			cm.getColumn(2).setResizable(false);
			cm.getColumn(3).setResizable(false);
		}
		
		
		
		int counter = 0;
		Iterator<Integer> it = arrListPrinting.iterator();
		while (it.hasNext()) {
			int row = it.next();
			
			modelPrint.addRow(new Object[0]);
			modelPrint.setValueAt(tblWishlist.getValueAt(row, 2), counter, 0);
			modelPrint.setValueAt(tblWishlist.getValueAt(row, 3), counter, 1);
			modelPrint.setValueAt(tblWishlist.getValueAt(row, 4), counter, 2);
			modelPrint.setValueAt(tblWishlist.getValueAt(row, 5), counter, 3);
			
			counter++;
		}
		
		try {
			boolean printed = tblPrint.print();
			if(printed){
				if (WishlistController.deleteItemFromWishList(arrList)) {
					insertTableRowsInWishList((DefaultTableModel) tblWishlist.getModel());
					JOptionPane.showMessageDialog(this, "Items Printed.");
				}
			}
			
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private void btnDeleteWishListActionPerformed(ActionEvent e) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> arrListRemove = new ArrayList<Integer>();
		boolean hasRow = false;

		for (int i = 0; i < tblWishlist.getRowCount(); i++) {
			hasRow = true;
			Boolean chked = Boolean
					.valueOf(tblWishlist.getValueAt(i, 1).toString());
			int ID = (int) tblWishlist.getValueAt(i, 0);
			if (chked) {
				arrList.add(ID);
				System.out.println("row id, add: " + ID);
				arrListRemove.add(i);
				tblWishlist.setValueAt(Boolean.FALSE, i, 1);
			}
		}
		
		if(!hasRow) {
			JOptionPane.showMessageDialog(this, "No item to delete.");
			return;
		}

		if(arrListRemove.size() == 0) {
			JOptionPane.showMessageDialog(this, "Item not selected.");
			return;
		}
		
		if (WishlistController.deleteItemFromWishList(arrList)) {
			insertTableRowsInWishList((DefaultTableModel) tblWishlist.getModel());
			
			JOptionPane.showMessageDialog(this, "Items deleted.");
		}
	}
	
	private void btnDeleteActionPerformed(ActionEvent e) {
		boolean hasRow = false;
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		ArrayList<Integer> arrListRemove = new ArrayList<Integer>();

		for (int i = 0; i < tblItem.getRowCount(); i++) {
			hasRow = true;
			Boolean chked = Boolean
					.valueOf(tblItem.getValueAt(i, 1).toString());
			int ID = (int) tblItem.getValueAt(i, 0);
			if (chked) {
				arrList.add(ID);
				System.out.println("row id, add: " + ID);
				arrListRemove.add(i);
				tblItem.setValueAt(Boolean.FALSE, i, 1);
			}
		}
		
		if(!hasRow) {
			JOptionPane.showMessageDialog(this, "No item to delete.");
			return;
		}
		
		if(arrListRemove.size() == 0) {
			JOptionPane.showMessageDialog(this, "Item not selected.");
			return;
		}
		

		if (ItemController.deleteItems(arrList)) {
			insertTableRows((DefaultTableModel) tblItem.getModel());
			insertTableRowsInWishList((DefaultTableModel) tblWishlist.getModel());
			JOptionPane.showMessageDialog(this, "Items deleted.");
		}

	}

	private void btnMoveToWishlistActionPerformed(ActionEvent e) {

		ArrayList<Integer> arrList = new ArrayList<Integer>();

		for (int i = 0; i < tblItem.getRowCount(); i++) {
			Boolean chked = Boolean
					.valueOf(tblItem.getValueAt(i, 1).toString());
			int ID = (int) tblItem.getValueAt(i, 0);
			if (chked) {
				arrList.add(ID);
				tblItem.setValueAt(Boolean.FALSE, i, 1);
				System.out.println(ID);
			}
		}

		if (WishlistController.addItemForWishList(arrList)) {
			insertTableRowsInWishList((DefaultTableModel) tblWishlist.getModel());
			JOptionPane.showMessageDialog(this, "Items added to your wishlist");

		} else {
			JOptionPane.showMessageDialog(this, "Item not selected.");
		}

	}
	
	private void btnPrintActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "Need to print the items");
	}

	private void mnuFileActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void mnuAboutActionPerformed(ActionEvent e) {
		About about = new About();
		about.setVisible(true);
		
	}

	public class TableHeaderMouseListener extends MouseAdapter {
		 public String setColumnName(String columnName, int type){
			 if(type==0){
				 return columnName+" \u25bc";
			 }
			 return columnName+" \u25b2";
		 }
		 
		 public void resetTableHeaderColumn(){
			 JTableHeader th = tblItem.getTableHeader();
			 TableColumnModel tcm = th.getColumnModel();
			 for(int columnIndex=0; columnIndex<  tblItem.getColumnCount(); columnIndex++){				 
				 TableColumn tc = tcm.getColumn(columnIndex);
				 tc.setHeaderValue(tblItem.getColumnName(columnIndex));
			 }
			 th.repaint();
		 }
		 
		 public void mouseClicked(MouseEvent event) {
		        Point point = event.getPoint();
		        int columnIndex = tblItem.columnAtPoint(point);
		        String columnName = tblItem.getColumnName(columnIndex);
				DefaultTableModel modelItem = (DefaultTableModel) tblItem.getModel();
				
				JTableHeader th = tblItem.getTableHeader();
				TableColumnModel tcm = th.getColumnModel();
				
				TableColumn tc = tcm.getColumn(columnIndex);
				resetTableHeaderColumn();
				
				int type = 0;
				
		        switch (columnName) {
					case "Name":
						if(nameAsc){
							type = 0;
							Collections.sort(arrItems, new ItemNameDesComparator());
							nameAsc = false;
						}else{
							type = 1;
							Collections.sort(arrItems, new ItemNameAscComparator());
							nameAsc = true;
						}
						break;
					case "Category":
						if(categoryAsc){
							type = 0;
							Collections.sort(arrItems, new ItemCategoryDesComparator());							
							categoryAsc = false;
						}else{
							type = 1;
							Collections.sort(arrItems, new ItemCategoryAscComparator());
							categoryAsc = true;
						}
						break;
					case "Quantity":
						if(quantityAsc){
							type = 0;
							Collections.sort(arrItems, new ItemQuantityDesComparator());							
							quantityAsc = false;
						}else{
							type = 1;
							Collections.sort(arrItems, new ItemQuantityAscComparator());							
							quantityAsc = true;
						}
						break;
					case "Priority":
						if(priorityAsc){
							type = 0;
							Collections.sort(arrItems, new ItemPriorityDesComparator());							
							priorityAsc = false;
						}else{
							type = 1;
							Collections.sort(arrItems, new ItemPriorityAscComparator());							
							priorityAsc = true;
						}
						break;
					default:
						type = -1;
						break;
				}
		        if(type >-1){
		        	tc.setHeaderValue(setColumnName(columnName, type));
					th.repaint();
					refreshTableItem(modelItem);
		        }		        
		    }
	}
   
    
	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - s s
		menuBar = new JMenuBar();
		mnuFile = new JMenu();
		mnuExit = new JMenuItem();
		mnuHelp = new JMenu();
		mnuAbout = new JMenuItem();
		tabbedItem = new JTabbedPane();
		panelItem = new JPanel();
		scrollPane1 = new JScrollPane();
		tblItem = new JTable();
		btnAdd = new JButton();
		btnDelete = new JButton();
		btnMoveToWishlist = new JButton();
		panelItem2 = new JPanel();
		scrollPane2 = new JScrollPane();
		tblWishlist = new JTable();
		btnDeleteWishList = new JButton();
		btnCheckout = new JButton();
		btnPrint = new JButton();

		// ======== this ========
		setTitle("Shopping List (HSCube)");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		// ======== menuBar ========
		{

			// ======== mnuFile ========
			{
				mnuFile.setText("File");
				mnuFile.addActionListener(e -> mnuFileActionPerformed(e));

				// ---- mnuExit ----
				mnuExit.setText("Exit");
				mnuFile.add(mnuExit);
			}
			menuBar.add(mnuFile);

			// ======== mnuHelp ========
			{
				mnuHelp.setText("Help");

				// ---- mnuAbout ----
				mnuAbout.setText("About");
				mnuAbout.addActionListener(e -> mnuAboutActionPerformed(e));
				mnuHelp.add(mnuAbout);
			}
			menuBar.add(mnuHelp);
		}
		setJMenuBar(menuBar);

		// ======== tabbedItem ========
		{

			// ======== panelItem ========
			{

				// ======== scrollPane1 ========
				{

					// Object[][] objectForTable = new
					// Object[arrItems.size()][5];

					// ---- table1 ----
					// setting the model for the table

					DefaultTableModel model = new DefaultTableModel() {

						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public Class<?> getColumnClass(int column) {
							switch (column) {
							case 0:
								return Integer.class;
							case 1:
								return Boolean.class;
							case 2:
								return String.class;
							case 3:
								return String.class;
							case 4:
								return String.class;
							case 5:
								return Integer.class;
							default:
								return String.class;
							}
						}
					};

					tblItem.setModel(model);

					model.addColumn("ID");
					model.addColumn("Select");
					model.addColumn("Name");
					model.addColumn("Category");
					model.addColumn("Priority");
					model.addColumn("Quantity");

					// Data Row

					insertTableRows(model);

					{
						TableColumnModel cm = tblItem.getColumnModel();
						cm.getColumn(0).setResizable(false);
						cm.getColumn(1).setResizable(false);
						cm.getColumn(2).setResizable(false);
						cm.getColumn(3).setResizable(false);
						cm.getColumn(4).setResizable(false);
						cm.getColumn(5).setResizable(false);

						cm.getColumn(0).setMinWidth(0);
						cm.getColumn(0).setMaxWidth(0);
						cm.getColumn(0).setPreferredWidth(0);

					}

					scrollPane1.setViewportView(tblItem);
				}

				// tblItem.removeColumn(tblItem.getColumnModel().getColumn(0));

				// ---- btnAdd ----
				btnAdd.setText("Add");
				btnAdd.addActionListener(e -> btnAddActionPerformed(e));

				// ---- btnDelete ----
				btnDelete.setText("Delete");
				btnDelete.addActionListener(e -> btnDeleteActionPerformed(e));

				// ---- btnMoveToWishlist ----
				btnMoveToWishlist.setText("Move to Wishlist");
				btnMoveToWishlist
						.addActionListener(e -> btnMoveToWishlistActionPerformed(e));
				
				// ---- btnPrint ----
				btnPrint.setText("Print");
				btnPrint.addActionListener(e -> btnPrintActionPerformed(e));

				GroupLayout panelItemLayout = new GroupLayout(panelItem);
				panelItem.setLayout(panelItemLayout);
				panelItemLayout
						.setHorizontalGroup(panelItemLayout
								.createParallelGroup()
								.addGroup(
										panelItemLayout
												.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														panelItemLayout
																.createParallelGroup()
																.addComponent(
																		scrollPane1,
																		GroupLayout.DEFAULT_SIZE,
																		711,
																		Short.MAX_VALUE)
																.addGroup(
																		panelItemLayout
																				.createSequentialGroup()
																				.addComponent(
																						btnAdd)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						btnDelete)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						btnMoveToWishlist)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(
																						btnPrint)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																				.addGap(0,
																						392,
																						Short.MAX_VALUE)))
												.addContainerGap()));
				panelItemLayout
						.setVerticalGroup(panelItemLayout
								.createParallelGroup()
								.addGroup(
										panelItemLayout
												.createSequentialGroup()
												.addGap(9, 9, 9)
												.addGroup(
														panelItemLayout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		btnAdd)
																.addComponent(
																		btnDelete)
																.addComponent(
																		btnMoveToWishlist)
																.addComponent(
																		btnPrint))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														scrollPane1,
														GroupLayout.DEFAULT_SIZE,
														261, Short.MAX_VALUE)
												.addContainerGap()));
			}
			tabbedItem.addTab("Item", panelItem);

			// ======== panelItem2 ========
			{

				// ======== scrollPane2 ========
				{

					// ---- tblWishlist ----
					
					// Object[][] objectForTable = new
					// Object[arrItems.size()][5];

					// ---- table1 ----
					// setting the model for the table

					DefaultTableModel modelWishList = new DefaultTableModel() {

						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public Class<?> getColumnClass(int column) {
							switch (column) {
							case 0:
								return Integer.class;
							case 1:
								return Boolean.class;
							case 2:
								return String.class;
							case 3:
								return String.class;
							case 4:
								return String.class;
							case 5:
								return Integer.class;
							default:
								return String.class;
							}
						}
					};

					tblWishlist.setModel(modelWishList);

					modelWishList.addColumn("ID");
					modelWishList.addColumn("Select");
					modelWishList.addColumn("Name");
					modelWishList.addColumn("Category");
					modelWishList.addColumn("Priority");
					modelWishList.addColumn("Quantity");

					insertTableRowsInWishList(modelWishList);
					{
						TableColumnModel cmWishlist = tblWishlist
								.getColumnModel();
						cmWishlist.getColumn(0).setResizable(false);
						cmWishlist.getColumn(1).setResizable(false);
						cmWishlist.getColumn(2).setResizable(false);
						cmWishlist.getColumn(3).setResizable(false);
						cmWishlist.getColumn(4).setResizable(false);
						cmWishlist.getColumn(5).setResizable(false);

						cmWishlist.getColumn(0).setMinWidth(0);
						cmWishlist.getColumn(0).setMaxWidth(0);
						cmWishlist.getColumn(0).setPreferredWidth(0);

					}
					scrollPane2.setViewportView(tblWishlist);
				}
				//--- table column header ---
				JTableHeader header = tblItem.getTableHeader();	     
				header.addMouseListener(new TableHeaderMouseListener());
				
				// ---- btnDeleteWishList ----
				btnDeleteWishList.setText("Delete");
				btnDeleteWishList.addActionListener(e -> btnDeleteWishListActionPerformed(e));
				
				
				// ---- btnCheckout ----
				btnCheckout.setText("Checkout");
				btnCheckout.addActionListener(e -> btnCheckoutActionPerformed(e));

				GroupLayout panelItem2Layout = new GroupLayout(panelItem2);
				panelItem2.setLayout(panelItem2Layout);
				panelItem2Layout
						.setHorizontalGroup(panelItem2Layout
								.createParallelGroup()
								.addGroup(
										panelItem2Layout
												.createSequentialGroup()
												.addContainerGap()
												.addGroup(
														panelItem2Layout
																.createParallelGroup()
																.addComponent(
																		scrollPane2,
																		GroupLayout.DEFAULT_SIZE,
																		711,
																		Short.MAX_VALUE)
																.addGroup(
																		panelItem2Layout
																				.createSequentialGroup()
																				.addComponent(
																						btnDeleteWishList)
																				.addGap(18,
																						18,
																						18)
																				.addComponent(
																						btnCheckout)
																				.addGap(0,
																						505,
																						Short.MAX_VALUE)))
												.addContainerGap()));
				panelItem2Layout
						.setVerticalGroup(panelItem2Layout
								.createParallelGroup()
								.addGroup(
										panelItem2Layout
												.createSequentialGroup()
												.addGap(9, 9, 9)
												.addGroup(
														panelItem2Layout
																.createParallelGroup(
																		GroupLayout.Alignment.BASELINE)
																.addComponent(
																		btnDeleteWishList)
																.addComponent(
																		btnCheckout))
												.addPreferredGap(
														LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														scrollPane2,
														GroupLayout.DEFAULT_SIZE,
														261, Short.MAX_VALUE)
												.addContainerGap()));
			}
			tabbedItem.addTab("Wishlist", panelItem2);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(contentPaneLayout
				.createParallelGroup().addGroup(
						contentPaneLayout.createSequentialGroup()
								.addContainerGap().addComponent(tabbedItem)
								.addContainerGap()));
		contentPaneLayout.setVerticalGroup(contentPaneLayout
				.createParallelGroup().addGroup(
						GroupLayout.Alignment.TRAILING,
						contentPaneLayout.createSequentialGroup()
								.addContainerGap().addComponent(tabbedItem)
								.addContainerGap()));
		pack();
		setLocationRelativeTo(getOwner());
		// //GEN-END:initComponents
	}

	private void insertTableRows(DefaultTableModel model) {
		int counter = 0;
		model.setRowCount(0);
		arrItems = ItemController.displayList();
		Iterator<Item> it = arrItems.iterator();
		while (it.hasNext()) {
			model.addRow(new Object[0]);
			Item i = (Item) it.next();
			model.setValueAt(i.getId(), counter, 0);
			model.setValueAt(Boolean.FALSE, counter, 1);
			model.setValueAt(i.getName(), counter, 2);
			model.setValueAt(i.getCategory().getName(), counter, 3);
			model.setValueAt(i.getPriority().getName(), counter, 4);
			model.setValueAt(i.getQuantity(), counter, 5);
			counter++;
		}

	}
	
	private void refreshTableItem(DefaultTableModel model) {
		int counter = 0;
		model.setRowCount(0);		
		Iterator<Item> it = arrItems.iterator();
		
		while (it.hasNext()) {
			model.addRow(new Object[0]);
			Item i = (Item) it.next();
			model.setValueAt(i.getId(), counter, 0);
			model.setValueAt(Boolean.FALSE, counter, 1);
			model.setValueAt(i.getName(), counter, 2);
			model.setValueAt(i.getCategory().getName(), counter, 3);
			model.setValueAt(i.getPriority().getName(), counter, 4);
			model.setValueAt(i.getQuantity(), counter, 5);
			counter++;
		}

	}
	
	private void insertTableRowsInWishList(DefaultTableModel model) {
		int counter = 0;
		model.setRowCount(0);
		
		arrWishLists = WishlistController.displayList();
		Iterator<WishList> it = arrWishLists.iterator();
		
		while (it.hasNext()) {
			model.addRow(new Object[0]);
			WishList w = (WishList) it.next();
			model.setValueAt(w.getId(), counter, 0);
			model.setValueAt(Boolean.FALSE, counter, 1);
			model.setValueAt(w.getitem().getName(), counter, 2);
			model.setValueAt(w.getitem().getCategory().getName(),
					counter, 3);
			model.setValueAt(w.getitem().getPriority().getName(),
					counter, 4);
			model.setValueAt(w.getitem().getQuantity(), counter, 5);
			counter++;
		}

	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - s s
	private JMenuBar menuBar;
	private JMenu mnuFile;
	private JMenuItem mnuExit;
	private JMenu mnuHelp;
	private JMenuItem mnuAbout;
	private JTabbedPane tabbedItem;
	private JPanel panelItem;
	private JScrollPane scrollPane1;
	private JTable tblItem;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnMoveToWishlist;
	private JPanel panelItem2;
	private JScrollPane scrollPane2;
	private JTable tblWishlist;
	private JButton btnDeleteWishList;
	private JButton btnCheckout;
	private JButton btnPrint;

	// JFormDesigner - End of variables declaration //GEN-END:variables

	public class AddFrames extends JFrame {
		public AddFrames() {
			initComponents();
		}

		private void btnCancelActionPerformed(ActionEvent e) {
			this.setVisible(false);
		}

		private void btnAddActionPerformed(ActionEvent e) {
			// add the item to the database
			
			if(txtName.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Enter the name for an item.");
				return;
			}

			Item item = new Item(0, txtName.getText(),
					CategoryController.getCategoryByName(comboboxCategory
							.getSelectedItem().toString()),
					PriorityController.getPriorityByName(comboboxPriority
							.getSelectedItem().toString()),
					(Integer) spinnerQuantity.getValue());

			if (item.addItem()) {
				JOptionPane.showMessageDialog(this, "Added successfully");
				this.setVisible(false);
				insertTableRows((DefaultTableModel) tblItem.getModel());
			}

		}

		
		private void initComponents() {
			
			label1 = new JLabel();
			txtName = new JTextField();
			label2 = new JLabel();
			comboboxCategory = new JComboBox<>();
			comboboxPriority = new JComboBox<>();
			label3 = new JLabel();
			label4 = new JLabel();
			spinnerQuantity = new JSpinner();
			btnAdd = new JButton();
			btnCancel = new JButton();
			btnPrint = new JButton();
			
			spinnerQuantity.setValue(new Integer(1));

			// ======== this ========
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			Container contentPane = getContentPane();

			// ---- label1 ----
			label1.setText("Name:");

			// ---- label2 ----
			label2.setText("Category:");

			// ---- comboboxCategory ----

			// getting the list of the category

			ArrayList<Category> arrCategories = CategoryController
					.displayList();
			Iterator<Category> itC = arrCategories.iterator();
			String[] arrayCategory = new String[arrCategories.size()];

			int counter = 0;
			while (itC.hasNext()) {
				Category c = (Category) itC.next();
				arrayCategory[counter] = c.getName();
				counter++;
			}

			comboboxCategory
					.setModel(new DefaultComboBoxModel<>(arrayCategory));

			// ---- comboboxPriority ----

			// getting the list of the priority

			ArrayList<Priority> arrPriorities = PriorityController
					.displayList();
			Iterator<Priority> itP = arrPriorities.iterator();
			String[] arrayPriority = new String[arrPriorities.size()];

			counter = 0;
			while (itP.hasNext()) {
				Priority p = (Priority) itP.next();
				arrayPriority[counter] = p.getName();
				counter++;
			}
			comboboxPriority
					.setModel(new DefaultComboBoxModel<>(arrayPriority));

			// ---- label3 ----
			label3.setText("Priority:");

			// ---- label4 ----
			label4.setText("Quantity:");

			// ---- btnAdd ----
			btnAdd.setText("Add");
			btnAdd.addActionListener(e -> btnAddActionPerformed(e));

			// ---- btnCancel ----
			btnCancel.setText("Cancel");
			btnCancel.addActionListener(e -> btnCancelActionPerformed(e));

			GroupLayout contentPaneLayout = new GroupLayout(contentPane);
			contentPane.setLayout(contentPaneLayout);
			contentPaneLayout
					.setHorizontalGroup(contentPaneLayout
							.createParallelGroup()
							.addGroup(
									contentPaneLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													contentPaneLayout
															.createParallelGroup()
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addComponent(
																					label1,
																					GroupLayout.PREFERRED_SIZE,
																					91,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(10,
																					10,
																					10)
																			.addComponent(
																					txtName,
																					GroupLayout.PREFERRED_SIZE,
																					206,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addComponent(
																					label2,
																					GroupLayout.PREFERRED_SIZE,
																					91,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(11,
																					11,
																					11)
																			.addComponent(
																					comboboxCategory,
																					GroupLayout.PREFERRED_SIZE,
																					205,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addComponent(
																					label3,
																					GroupLayout.PREFERRED_SIZE,
																					91,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(11,
																					11,
																					11)
																			.addComponent(
																					comboboxPriority,
																					GroupLayout.PREFERRED_SIZE,
																					205,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addComponent(
																					label4,
																					GroupLayout.PREFERRED_SIZE,
																					91,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(14,
																					14,
																					14)
																			.addComponent(
																					spinnerQuantity,
																					GroupLayout.PREFERRED_SIZE,
																					53,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addComponent(
																					btnAdd)
																			.addGap(146,
																					146,
																					146)
																			.addComponent(
																					btnCancel)))
											.addContainerGap(16,
													Short.MAX_VALUE)));
			contentPaneLayout
					.setVerticalGroup(contentPaneLayout
							.createParallelGroup()
							.addGroup(
									contentPaneLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													contentPaneLayout
															.createParallelGroup()
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addGap(6,
																					6,
																					6)
																			.addComponent(
																					label1))
															.addComponent(
																	txtName,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(8, 8, 8)
											.addGroup(
													contentPaneLayout
															.createParallelGroup()
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addGap(4,
																					4,
																					4)
																			.addComponent(
																					label2))
															.addComponent(
																	comboboxCategory,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(4, 4, 4)
											.addGroup(
													contentPaneLayout
															.createParallelGroup()
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addGap(4,
																					4,
																					4)
																			.addComponent(
																					label3))
															.addComponent(
																	comboboxPriority,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(10, 10, 10)
											.addGroup(
													contentPaneLayout
															.createParallelGroup()
															.addGroup(
																	contentPaneLayout
																			.createSequentialGroup()
																			.addGap(6,
																					6,
																					6)
																			.addComponent(
																					label4))
															.addComponent(
																	spinnerQuantity,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(16, 16, 16)
											.addGroup(
													contentPaneLayout
															.createParallelGroup()
															.addComponent(
																	btnAdd)
															.addComponent(
																	btnCancel))
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			pack();
			setLocationRelativeTo(getOwner());
			// JFormDesigner - End of component initialization
			// //GEN-END:initComponents
		}

		// JFormDesigner - Variables declaration - DO NOT MODIFY
		// //GEN-BEGIN:variables
		// Generated using JFormDesigner Evaluation license - s s
		private JLabel label1;
		private JTextField txtName;
		private JLabel label2;
		private JComboBox<String> comboboxCategory;
		private JComboBox<String> comboboxPriority;
		private JLabel label3;
		private JLabel label4;
		private JSpinner spinnerQuantity;
		private JButton btnAdd;
		private JButton btnCancel;
		// JFormDesigner - End of variables declaration //GEN-END:variables
	}

}
