package v0.project.mysite.KBC.temp;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Log4j2
public class Sha256PasswordEncoder implements PasswordEncoder {

    //    @Override
//    public String encode(CharSequence rawPassword) {
//        try {
//            // SHA-256 해시 계산
//
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hash = digest.digest(rawPassword.toString().getBytes());
//
//            // 16진수 문자열로 변환
//            return bytesToHex(hash);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("SHA-256 algorithm not found", e);
//        }
//    }
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        // rawPassword가 인코딩된 문자열이 아닌 평문 비밀번호여야 합니다.
//        String rawPasswordEncoded = encode(rawPassword);
//        log.info("Comparing raw password: {} with encoded password: {}", rawPasswordEncoded, encodedPassword);
//        return rawPasswordEncoded.equalsIgnoreCase(encodedPassword);
//    }
//
//    // 바이트 배열을 16진수 문자열로 변환하는 메소드
//    private String bytesToHex(byte[] bytes) {
//        StringBuilder hexString = new StringBuilder(2 * bytes.length);
//        for (byte b : bytes) {
//            String hex = Integer.toHexString(0xff & b);
//            if (hex.length() == 1) {
//                hexString.append('0');
//            }
//            hexString.append(hex);
//        }
//        log.info(hexString.toString());
//        return hexString.toString();
//    }
    @Override
    public String encode(CharSequence rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(rawPassword.toString().getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        try {
            byte[] rawPasswordHash = sha256(rawPassword.toString());
            byte[] encodedPasswordBytes = encodedPassword.getBytes();
            return Arrays.equals(rawPasswordHash, encodedPasswordBytes);
        } catch (Exception e) {
            log.error("Error comparing passwords", e);
            return false;
        }
    }

    private byte[] sha256(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(password.getBytes());
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private byte[] hexToBytes(String hex) {
        int length = hex.length();
        byte[] bytes = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i+1), 16));
        }
        return bytes;
    }
}
