package edu.kirkwood.shared;

import com.azure.communication.email.EmailClient;
import com.azure.communication.email.EmailClientBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import com.azure.communication.email.models.EmailAddress;
import com.azure.communication.email.models.EmailMessage;
import com.azure.communication.email.models.EmailSendResult;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;

public class AzureEmail {
    public static EmailClient getEmailClient() {
        String connectionString = Dotenv.load().get("AZURE_EMAIL_CONNECTION");

        EmailClient emailClient = new EmailClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        return emailClient;
    }

    public static String sendEmail(String toEmailAddress, String subject, String bodyHTML) {
        EmailClient emailClient = getEmailClient();
        EmailAddress toAddress = new EmailAddress(toEmailAddress);
        String body = Helpers.html2text(bodyHTML);
        EmailMessage emailMessage = new EmailMessage()
                .setSenderAddress(Dotenv.load().get("AZURE_EMAIL_FROM"))
                .setToRecipients(toAddress)
                .setSubject(subject)
                .setBodyPlainText(body)
                .setBodyHtml(bodyHTML);
        SyncPoller<EmailSendResult, EmailSendResult> poller = null;
        try {
            poller = emailClient.beginSend(emailMessage, null);
        } catch(RuntimeException e) {
            return e.getMessage();
        }
        PollResponse<EmailSendResult> result = poller.waitForCompletion();

        return "";
    }

    public static void main(String[] args) {
        // Pretend this is your doPost method in a servlet
        // Get all parameters
        String toEmailAddress = "abc@example.com"; // Use your own email address
        String subject = "Testing";
        String bodyHTML = "<h2>This is a test email</h2><p>Testing, Testing, Testing</p>";
        // Set the parameters as attribute

        // validate inputs
        boolean error =false;
        if(toEmailAddress == null || !Validators.isValidEmail(toEmailAddress)) {
            // set error attribute
            System.out.println("Invalid email address: " + toEmailAddress);
            error = true;
        }

        if(subject == null || subject.isEmpty()) {
            // set error attribute
            System.out.println("Subject is required");
            error = true;
        }

        if(bodyHTML == null || bodyHTML.isEmpty()) {
            // set error attribute
            System.out.println("Body is required");
            error = true;
        }

        if(!error) {
            EmailThread emailThread1 = new EmailThread(toEmailAddress, subject, bodyHTML);
            emailThread1.start();
            EmailThread emailThread2 = new EmailThread("abcd@example.com", subject, bodyHTML);
            emailThread2.start();
            try {
                emailThread1.join();
                emailThread2.join();
            } catch (InterruptedException e) {

            }
            String errorMessage1 = emailThread1.getErrorMessage();
            String errorMessage2 = emailThread2.getErrorMessage();
            if (errorMessage1.isEmpty() && errorMessage2.isEmpty()) {
                // Set a success attribute
                System.out.println("Message sent to " + toEmailAddress);
            } else {
                // Set an error attribute
                System.out.println("Message not sent to " + toEmailAddress + " - " + errorMessage1);
            }
        }
        // Forward req/resp to a JSP
    }
}
