package Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        List<List<String>> emailAddressList = processEmails(emails);
        Set<String> uniqueEmailSet  = new HashSet<>();

        for(List<String> emailAddress: emailAddressList) {
            String uniqueEmail = String.join("@", emailAddress.get(0), emailAddress.get(1));
            System.out.println(uniqueEmail);
            uniqueEmailSet.add(uniqueEmail);
        }

        return uniqueEmailSet.size();
    }

    private List<List<String>> processEmails(String[] emails) {
        List<List<String>> emailAddressList = new ArrayList<>();

        for(String email : emails) {
            String[] addresses = email.split("@");

            String localAddress  = processLocalAddress(addresses[0]);
            String domainAddress = addresses[1];

            List<String> emailAddress = appendAddressToList(localAddress, domainAddress);
            emailAddressList.add(emailAddress);
        }

        return emailAddressList;
     }

    private List<String> appendAddressToList(String localAddress, String domainAddress) {
        List<String> emailAddresses = new ArrayList<>();
        emailAddresses.add(localAddress);
        emailAddresses.add(domainAddress);
        return emailAddresses;
    }

    private String processLocalAddress(String address) {
        address = address.split("\\+", 0)[0];
        address = address.replaceAll("\\.", "");
        return address;
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
//        String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
        UniqueEmails ue = new UniqueEmails();
        int uniqueEmails = ue.numUniqueEmails(emails);
        System.out.println("Number of Unique Emails: " + uniqueEmails);
    }

}


