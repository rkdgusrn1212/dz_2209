package controller.member;

import java.security.SecureRandom;
import java.util.Date;

class RandomCodeGenerator {
    
    private char[] mCharSet = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '!', '@', '#', '$', '%', '^', '&' };
    
    String getRandomCode(int size) {
        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());
        int idx = 0;
        int len = mCharSet.length;
        for (int i=0; i<size; i++) {
            idx = sr.nextInt(len);
            sb.append(mCharSet[idx]);
        }
        return sb.toString();
    }
    
    //영문자, 숫자, 특수문자가 하나이상 포함된 size크기의 비밀번호 생성.
    String getRamdomPwd(int size) {
   
        StringBuffer sb = new StringBuffer();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());
        int[] numbers = new int[size];
        for(int i=0 ;i<size; i++) {
            numbers[i] = i;
        }
        int numIdx = numbers[(int) Math.random()*size];
        swapNumbers(numbers,numIdx,size-1);
        int specIdx = numbers[(int) Math.random()*(size-1)];
        swapNumbers(numbers,specIdx,size-2);
        int alpIdx = numbers[(int) Math.random()*(size-2)];
        swapNumbers(numbers,numIdx,size-3);
        int idx = 0;
        int len = mCharSet.length;
        for (int i=0; i<size; i++) {
            if(i == numIdx) {
                sb.append(mCharSet[(int)Math.random()*10]);
                continue;
            }
            if(i == specIdx) {
                sb.append(mCharSet[10+(int)Math.random()*52]);
                continue;
            }
            if(i == alpIdx) {
                sb.append(mCharSet[62+(int)Math.random()*7]);
                continue;
            }
            idx = sr.nextInt(len);
            sb.append(mCharSet[idx]);
        }
        return sb.toString();
    }
    
    private void swapNumbers(int[] array, int idx1, int idx2) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;
    }
}
