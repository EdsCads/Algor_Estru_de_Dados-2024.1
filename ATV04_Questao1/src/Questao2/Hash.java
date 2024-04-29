package Questao2;

public class Hash {

    private static final int[] SHIFT_AMTS = {
            7, 12, 17, 22,
            5, 9, 14, 20,
            4, 11, 16, 23,
            6, 10, 15, 21
    };
    private static final int[] TABLE_T = new int[64];

    static {
        for (int i = 0; i < 64; i++) {
            TABLE_T[i] = (int) (long) ((1L << 32) * Math.abs(Math.sin(i + 1)));
        }
    }

    public static int of(String frase) {
        int hashValue = 0;
        for (int i = 0; i < frase.length(); i++) {
            hashValue = (((int) Math.pow(frase.charAt(i), i+1) * 31) + hashValue);
        }
        return Math.abs(hashValue);
    }

    public static String md5(String message) {
        int[] words = preprocess(message);
        int[] hash = new int[]{0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476};

        int a = hash[0];
        int b = hash[1];
        int c = hash[2];
        int d = hash[3];

        for (int i = 0; i < 64; i++) {
            int f, g;
            if (i < 16) {
                f = (b & c) | (~b & d);
                g = i;
            } else if (i < 32) {
                f = (d & b) | (~d & c);
                g = (5 * i + 1) % 16;
            } else if (i < 48) {
                f = b ^ c ^ d;
                g = (3 * i + 5) % 16;
            } else {
                f = c ^ (b | ~d);
                g = (7 * i) % 16;
            }

            int temp = d;
            d = c;
            c = b;
            b = b + Integer.rotateLeft(a + f + words[g] + TABLE_T[i], SHIFT_AMTS[(i / 16) * 4 + (i % 4)]);
            a = temp;
        }

        hash[0] += a;
        hash[1] += b;
        hash[2] += c;
        hash[3] += d;

        StringBuilder result = new StringBuilder();
        for (int h : hash) {
            result.append(String.format("%02x", h));
        }
        return result.toString();
    }

    private static int[] preprocess(String message) {
        message = appendPadding(message);
        int[] words = new int[16];
        for (int i = 0; i < 16; i++) {
            words[i] = bytesToInt(message.substring(i * 4, (i + 1) * 4));
        }
        return words;
    }

    private static String appendPadding(String message) {
        int originalLength = message.length();
        message += (char) 0x80;
        while ((message.length() * 8) % 512 != 448) {
            message += (char) 0x00;
        }
        String bitLength = Integer.toBinaryString(originalLength * 8);
        while (bitLength.length() < 64) {
            bitLength = "0" + bitLength;
        }
        for (int i = 0; i < 64; i += 8) {
            String octet = bitLength.substring(i, i + 8);
            message += (char) Integer.parseInt(octet, 2);
        }
        return message;
    }

    private static int bytesToInt(String bytes) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result |= (bytes.charAt(i) & 0xFF) << (8 * i);
        }
        return result;
    }

}

