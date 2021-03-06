package net.cd.extern.mail.aws;

import net.cd.extern.mail.CdMailAbstract;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

/**
 * Created by Tree.Yip on 25/6/2017.
 */
public class CdMailVendor extends CdMailAbstract {

    @SuppressWarnings("deprecation")
    @Override
    public String send() {

        BasicAWSCredentials credentials = new BasicAWSCredentials(getUsername(), getPassphrase());

        // Construct an object to contain the recipient address.
        Destination destination = new Destination().withToAddresses(new String[]{getTo()});
        destination.withBccAddresses(new String[]{getBcc()});

        // Create the subject and body of the message.
        Content subject = new Content().withData(getSubject());
        Content textBody = new Content().withData(getBody());
        Body body = new Body().withHtml(textBody);

        // Create a message with the specified subject and body.
        com.amazonaws.services.simpleemail.model.Message message = new com.amazonaws.services.simpleemail.model.Message().withSubject(subject).withBody(body);

        // Assemble the email.
        SendEmailRequest request1 = new SendEmailRequest().withSource(getFromname()+"<"+getFrom()+">").withDestination(destination).withMessage(message);

        try
        {
//            System.out.println("Attempting to send an email through Amazon SES by using the AWS SDK for Java...");

            // Instantiate an Amazon SES client, which will make the service call. The service call requires your AWS credentials.
            // Because we're not providing an argument when instantiating the client, the SDK will attempt to find your AWS credentials
            // using the default credential provider chain. The first place the chain looks for the credentials is in environment variables
            // AWS_ACCESS_KEY_ID and AWS_SECRET_KEY.
            // For more information, see http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
            AmazonSimpleEmailServiceClient client = new AmazonSimpleEmailServiceClient(credentials);

            // Choose the AWS region of the Amazon SES endpoint you want to connect to. Note that your sandbox
            // status, sending limits, and Amazon SES identity-related settings are specific to a given AWS
            // region, so be sure to select an AWS region in which you set up Amazon SES. Here, we are using
            // the US West (Oregon) region. Examples of other regions that Amazon SES supports are US_EAST_1
            // and EU_WEST_1. For a complete list, see http://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html
            Region REGION = Region.getRegion(Regions.US_EAST_1);
            client.setRegion(REGION);

            // Send the email.
            client.sendEmail(request1);
//            System.out.println("Email sent!");
        }
        catch (Exception ex)
        {
            return org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(ex);
        }

        return null;
    }

}
