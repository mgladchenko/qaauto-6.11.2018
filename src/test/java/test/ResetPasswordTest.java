package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RequestPasswordResetPage;
import page.RequestPasswordResetSubmitPage;
import page.SetNewPasswordPage;

public class ResetPasswordTest extends BaseTest {

    @Test
    public void successfulResetPasswordTest() {
        String userEmail = "linkedin.tst.yanina@gmail.com";

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded.");

        RequestPasswordResetPage requestPasswordResetPage =
                loginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "RequestPasswordReset page is not loaded.");

        RequestPasswordResetSubmitPage requestPasswordResetSubmitPage =
                requestPasswordResetPage.findAccount(userEmail);
        Assert.assertTrue(requestPasswordResetSubmitPage.isPageLoaded(),
                "RequestPasswordResetSubmit page is not loaded.");

        SetNewPasswordPage setNewPasswordPage =
                requestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(setNewPasswordPage.isPageLoaded(),
                "SetNewPasswordPage page is not loaded.");




    }
}
