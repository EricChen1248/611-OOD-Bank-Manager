import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * IUIElement to display the details of a transaction to a user
 */
public class TransactionObject extends ElementObject {
    private JLabel dateLabel;
    private JLabel typeLabel;
    private JLabel amountLabel;
    private JLabel accountLabel;
    private JLabel targetUserLabel;
    private JLabel targetAccountLabel;
    private JLabel targetUserInfoLabel;
    private JLabel targetAccountInfoLabel;
    private JPanel mainPanel;
    private JLabel accountHint;
    private JLabel amountHint;
    private final Transaction transaction;

    public TransactionObject(Transaction transaction) {
        setExternalTransaction(transaction.target_account_id == -1);
        this.transaction = transaction;

        dateLabel.setText(Constants.DATE_FORMAT.format(transaction.getDate()));
        typeLabel.setText(transaction.getType().toString());
        accountLabel.setText(Integer.toString(transaction.getAccount_id()));

        if (transaction.getAmount() != null) {
            amountLabel.setText(Constants.CURRENCY_FORMAT.format(transaction.getAmount().doubleValue()) + " " + transaction.getCurrency());
        }

        if (transaction.account_id == -1) {
            if (transaction.getType() != TransactionType.OPENLOAN) {
                amountHint.setForeground(new Color(0, true));
                amountLabel.setForeground(new Color(0, true));
            }
            accountLabel.setText(transaction.getUid() + "");
            accountHint.setText("User ID");
        }

        if (transaction.getType() == TransactionType.CLOSE) {
            amountLabel.setForeground(new Color(0, true));
            amountHint.setForeground(new Color(0, true));
        }

        targetUserLabel.setText(Integer.toString(transaction.getTarget_uid()));
        targetAccountLabel.setText(Integer.toString(transaction.getTarget_account_id()));
    }

    public boolean equals(Object o) {
        return transaction == o;
    }

    private void setExternalTransaction(boolean external) {
        targetUserLabel.setForeground(new Color(0, external));
        targetUserInfoLabel.setForeground(new Color(0, external));
        targetAccountLabel.setForeground(new Color(0, external));
        targetAccountInfoLabel.setForeground(new Color(0, external));
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
        mainPanel.setLayout(new GridLayoutManager(2, 6, new Insets(10, 10, 10, 10), 1, -1));
        mainPanel.setMaximumSize(new Dimension(2147483647, 90));
        mainPanel.setMinimumSize(new Dimension(500, 90));
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        amountHint = new JLabel();
        amountHint.setText("Amount");
        mainPanel.add(amountHint, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        accountHint = new JLabel();
        accountHint.setText("Account");
        mainPanel.add(accountHint, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        amountLabel = new JLabel();
        amountLabel.setText("-1");
        mainPanel.add(amountLabel, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        accountLabel = new JLabel();
        accountLabel.setText("Label");
        mainPanel.add(accountLabel, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        targetUserInfoLabel = new JLabel();
        targetUserInfoLabel.setText("Target User");
        mainPanel.add(targetUserInfoLabel, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        targetAccountInfoLabel = new JLabel();
        targetAccountInfoLabel.setText("Target Account");
        mainPanel.add(targetAccountInfoLabel, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        targetUserLabel = new JLabel();
        targetUserLabel.setText("Label");
        mainPanel.add(targetUserLabel, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        targetAccountLabel = new JLabel();
        targetAccountLabel.setText("Label");
        mainPanel.add(targetAccountLabel, new GridConstraints(1, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Date");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Type");
        mainPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dateLabel = new JLabel();
        dateLabel.setText("Label");
        mainPanel.add(dateLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, -1), new Dimension(150, -1), new Dimension(150, -1), 1, false));
        typeLabel = new JLabel();
        typeLabel.setText("Label");
        mainPanel.add(typeLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, -1), new Dimension(150, -1), new Dimension(150, -1), 1, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
