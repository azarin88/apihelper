package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import ru.netology.api.AuthenticationAPIClient;
import ru.netology.api.TransferAPIClient;
import ru.netology.data.AuthenticationDataGenerator;
import ru.netology.data.VerificationDataGenerator;
import ru.netology.sql.AuthenticationCodeSQLClient;
import ru.netology.sql.CardSQLClient;
import ru.netology.sql.CardTransactionSQLClient;
import ru.netology.sql.UserSQLClient;

public class BaseTransferTest {

    protected static final int initialBalance = 10000;

    protected final AuthenticationAPIClient authenticationClient = new AuthenticationAPIClient();
    protected final TransferAPIClient transferClient = new TransferAPIClient();

    protected final UserSQLClient userSql = new UserSQLClient();
    protected final AuthenticationCodeSQLClient authenticationCodeSql = new AuthenticationCodeSQLClient();
    protected final CardSQLClient cardSql = new CardSQLClient();
    protected final CardTransactionSQLClient transactionSql = new CardTransactionSQLClient();

    protected String token;
    protected String firstCard;
    protected String secondCard;

    @BeforeEach
    void setUp() {
        cardSql.resetAllBalances(initialBalance);
        authenticationCodeSql.clearAuthenticationCodes();
        transactionSql.clearTransactions();

        var firstUser = AuthenticationDataGenerator.getFirstAuthenticationInformation();
        authenticationClient.login(firstUser);
        String vasyaId = userSql.getUserId(firstUser.getLogin());
        String code = authenticationCodeSql.getLastCode(vasyaId);

        var verificationInformation = VerificationDataGenerator.getVerificationInformation(firstUser.getLogin(), code);
        token = authenticationClient.verification(verificationInformation);

        var vasyaCards = cardSql.getUserCards(vasyaId);
        firstCard = vasyaCards.get(0);
        secondCard = vasyaCards.get(1);
    }
}
