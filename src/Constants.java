import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Constants.java - class that keeps track of all the hard coded constants needed for bank.
 */
public class Constants {
    public static final BigDecimal savingsInterestPercentage = new BigDecimal("0.05");
    public static final BigDecimal loanInterestPercentage = new BigDecimal("0.10");
    public static final BigDecimal openAccountFee = new BigDecimal("5");
    public static final BigDecimal closeAccountFee = new BigDecimal("5");
    public static final BigDecimal withdrawFee = new BigDecimal("5");
    public static final BigDecimal vipThreshold = new BigDecimal("5000");

    public static final boolean DEV_MODE = false;
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("###,###.##");

    public static final BigDecimal minimalSecurityAmount = new BigDecimal(2500);
    public static final double minimalStartingSecurityAmount = 1000;

    public static final BigDecimal minAccountOpeningBalance = new BigDecimal("20");
    public static final BigDecimal checkingFee = new BigDecimal("5");
}