import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerInfoScreen extends BaseScreen {
    private JComboBox customerCombo;
    private JRadioButton accountRadio;
    private JRadioButton transactionRadio;
    private JPanel elementsPanel;
    private JPanel mainPanel;
    private java.util.List<Customer> customers;

    public CustomerInfoScreen(java.util.List<Customer> customers) {
        setContentPane(mainPanel);
        setSize(700, 700);
        centerScreen();

        elementsPanel.setLayout(new BoxLayout(elementsPanel, BoxLayout.Y_AXIS));
        for (Customer customer : customers) {
            customerCombo.addItem(customer);
        }

        update();

        accountRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transactionRadio.setSelected(false);
                update();
            }
        });

        transactionRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountRadio.setSelected(false);
                update();
            }
        });

        customerCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                update();
            }
        });
    }

    private void update() {
        if (transactionRadio.isSelected()) {
            loadTransactions();
        } else {
            loadAccounts();
        }

    }

    private void loadAccounts() {
        elementsPanel.removeAll();
        for (BankAccount a : ((Customer) customerCombo.getSelectedItem()).getBankAccounts()) {
            AccountsObject aa = new AccountsObject(null, a);
            elementsPanel.add(aa.$$$getRootComponent$$$());
        }

        refreshUI();
    }

    private void loadTransactions() {
        elementsPanel.removeAll();
        for (Transaction t : ((Customer) customerCombo.getSelectedItem()).getTransactions()) {
            TransactionObject tt = new TransactionObject(t);
            elementsPanel.add(tt.$$$getRootComponent$$$());
        }

        refreshUI();
    }

    private void refreshUI() {
        elementsPanel.revalidate();
        elementsPanel.repaint();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(3, 2, new Insets(10, 10, 10, 10), -1, -1));
        customerCombo = new JComboBox();
        mainPanel.add(customerCombo, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        accountRadio = new JRadioButton();
        accountRadio.setSelected(true);
        accountRadio.setText("Accounts");
        mainPanel.add(accountRadio, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        transactionRadio = new JRadioButton();
        transactionRadio.setText("Transactions");
        mainPanel.add(transactionRadio, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        elementsPanel = new JPanel();
        elementsPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(elementsPanel, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
