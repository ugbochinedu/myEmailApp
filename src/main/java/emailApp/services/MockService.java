package emailApp.services;

public class MockService {
//    public static String sendEmail(String emailAddress) {
//        if(emailAddress != null) return ""
//    }

    public static String sendToken(String phoneNumber) {
        if(phoneNumber != null) return "12345";
        throw new RuntimeException("Token wasn't sent");
    }
}
